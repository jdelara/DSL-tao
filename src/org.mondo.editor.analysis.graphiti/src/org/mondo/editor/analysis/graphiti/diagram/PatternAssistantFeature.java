package org.mondo.editor.analysis.graphiti.diagram;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mindMapDSML.Idea;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.PatternAssistantUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.ui.utils.patterns.PatternUtils;
import org.mondo.editor.ui.wizards.PatternChoiceWizard;

import dslPatterns.ClassInterface;
import dslPatterns.PatternMetaModel;
import dslPatterns.Variant;

/**
 * Class to open the EPackage content.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternAssistantFeature extends AbstractCustomFeature {
	
	private boolean changes = false;
	public PatternAssistantFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Pattern Assistant";
	}

	@Override
	public String getDescription() {
		return "Associate the idea with a pattern";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Idea) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Idea bo = (Idea)getBusinessObjectForPictogramElement(pes[0]);

		IProject project= IResourceUtils.getProject(getDiagram().eResource());
			
		Map<PatternMetaModel,Integer> metamodelsCount = PatternAssistantUtils.getPatternsMetamodelRelated(project, bo.getName()+" "+(bo.getDescription()==null?"":bo.getDescription()));
		
		/*for (PatternMetaModel pmm : metamodelsCount.keySet()){
			System.out.println(pmm.getImg()+"  "+metamodelsCount.get(pmm));
		}*/
		
		List<PatternMetaModel> metamodels = new LinkedList<PatternMetaModel>();
		for (PatternMetaModel pattern: PatternAssistantUtils.orderForValues(metamodelsCount).keySet()){
			metamodels.add(pattern);
		}			
		PatternChoiceWizard pw= new PatternChoiceWizard(metamodels, project, bo.getPattern());
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), pw)
		{
			@Override							        
			protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			newShell.setSize(925, 725);
			}
		};
		dialog.create();
		
		dialog.getShell().setText("PATTERNS");
		int result = dialog.open();
		if (result == Window.OK){
			PatternMetaModel pmm = pw.getPatternMetaModelSelected();
			PatternMetaModel pmmOld = bo.getPattern(); 

			if (pmmOld != pmm){
				if (pmmOld != null) {
					Idea root = ModelUtils.getRootIdea(bo);
					if (root != null) resetRoles(root, pmmOld);
				}
				changes = true;	
				bo.setPattern(pmm);
				
				if (pmm != null) bo.setPatternRole(PatternAssistantUtils.getRole(pmm, bo.getName()));
				else bo.setPatternRole(null);
				writePattern(bo, pes[0]);
				
				if (pmm != null){
					Map<ClassInterface, Idea> rolesSubIdeas =  getRestRoles(pmm, bo, bo.getPatternRole());
					for (ClassInterface ciAux : rolesSubIdeas.keySet()){
						Idea ideaAux = rolesSubIdeas.get(ciAux);
						if (ideaAux!=null){
							ideaAux.setPattern(pmm);
							ideaAux.setPatternRole(ciAux);
							writePattern(ideaAux);
						}
					}
				}
			}
		}
	}

	/**
	 * Method that returns a map with the associations between roles and ideas for the pattern.
	 * The method searches within the given idea's subideas (recursive).
	 * @param pmm pattern meta-model
	 * @param idea main idea
	 * @param role exception 
	 * @return map classInterface (role) - idea.
	 */
	private Map<ClassInterface, Idea> getRestRoles(PatternMetaModel pmm, Idea idea, ClassInterface role){	
		//obtenemos la idea raíz.
		Idea root = ModelUtils.getRootIdea(idea);
		
		Map<ClassInterface, Idea> roles = new HashMap<ClassInterface, Idea>();
		for (ClassInterface roleAux: pmm.getClassInterfaces()){
			if (!roleAux.equals(role)){
			EClass eclass = PatternUtils.getEClass(roleAux);
				if (eclass!= null){
					String nameRole = eclass.getName();
					roles.put(roleAux, getSubIdeaRole(root, nameRole, idea, roles));
				}
			}
		}
		return roles;
	}
	
	/**
	 * Method that clears the subidea's content if it`s related to the given pattern meta-model.
	 * @param idea main idea
	 * @param pmm pattern meta-model
	 */
	private void resetRoles (Idea idea, PatternMetaModel pmm){	
		if (idea != null) {
			if (idea.getPattern()==pmm){
				idea.setPattern(null);
				idea.setPatternRole(null);
				writePattern(idea);
			}
			for (Idea subidea: idea.getContains())
				resetRoles(subidea, pmm);
		}
	}
	
	/**
	 * Method that returns the subidea that can have the given role.
	 * @param idea main idea
	 * @param role
	 * @param ideaException - the found idea can't be ideaException.
	 * @return the idea that can have the given role
	 */
	private Idea getSubIdeaRole (Idea idea, String role, Idea ideaException, Map<ClassInterface, Idea> roles){
		if (idea!= null){	
			if (!idea.equals(ideaException)){
				boolean noPattern = true;
				if (roles.containsValue(idea)) noPattern = false;
				//String singular = WordUtils.toSingular(idea.getName());
				//if ((role.compareToIgnoreCase(idea.getName())==0) || (role.compareToIgnoreCase(singular)==0))
				if (noPattern)
				for (String tagAux: idea.getName().split(" ")){
					if  (PatternAssistantUtils.isTagInRole(tagAux, role))
						return idea;
				}
			}
			for (Idea subidea: idea.getContains())
				if (getSubIdeaRole(subidea, role, ideaException, roles) != null) return  getSubIdeaRole(subidea, role, ideaException, roles);
		}
		return null;
	}
	
	/**
	 * Method that paints in the diagram the information about the pattern and role of the given idea.
	 * @param idea
	 */
	private void writePattern(Idea idea){
		for (PictogramElement pe2: Graphiti.getLinkService().getPictogramElements(getDiagram(),idea)){
			if (pe2 instanceof ContainerShape){
				writePattern(idea, pe2);
			}
		}
	}
	/**
	 * Method that paints in the given pictogram the pattern and role associated to the idea.
	 * @param idea
	 * @param pe
	 */
	private void writePattern(Idea idea, final PictogramElement pe){
		String role = "";
		if (idea.getPatternRole()!= null){
			EClass eclass = PatternUtils.getEClass(idea.getPatternRole());
			if (eclass!= null) role = "."+eclass.getName();
		}

		final String name = ((idea.getPattern()!=null)?((Variant)idea.getPattern().eContainer()).getName(): "")+role;

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(idea);
        domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				if (pe instanceof ContainerShape) {
		            ContainerShape cs = (ContainerShape) pe;
		            for (Shape shape : cs.getChildren()) {
		                if (shape.getGraphicsAlgorithm() instanceof Text) {
		                    Text text = (Text) shape.getGraphicsAlgorithm();
		                    if ((text.getValue().compareTo(name)!=0)&& (DiagramUtils.isInfoPatterns(text))){
	                    		text.setValue(name);
		                    }}}}
			}
		});
	}

	@Override
	public boolean hasDoneChanges() {
		return changes;
	}
}
