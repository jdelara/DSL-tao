package org.mondo.editor.analysis.graphiti.diagram;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mindMapDSML.Idea;

import org.eclipse.core.resources.IProject;
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
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.analysis.graphiti.diagram.utils.PatternAssistantUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.ui.wizards.PatternChoiceWizard;

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
			
		Map<PatternMetaModel,Integer> metamodelsCount = PatternAssistantUtils.getPatternsMetamodelRelated(project, bo.getName()+" "+bo.getDescription());
		List<PatternMetaModel> metamodels = new LinkedList<PatternMetaModel>();
		for (PatternMetaModel pattern: PatternAssistantUtils.orderForValues(metamodelsCount).keySet()){
			metamodels.add(pattern);
		}
		
		if ((!metamodels.isEmpty()) || ((metamodels.isEmpty() && (bo.getPattern()!=null)))){
			
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
				changes = true;	
				bo.setPattern(pmm);
				writePattern(bo, pes[0]);
			}
		
		} else Messages.displayGeneralMessage("Pattern Association", "No related patterns");
	}

	private void writePattern(Idea idea, final PictogramElement pe){
    	final String name = ((idea.getPattern()!=null)?((Variant)idea.getPattern().eContainer()).getName(): "");

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
