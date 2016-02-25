package org.mondo.editor.analysis.graphiti.diagram;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.Link;
import mindMapDSML.MindMap;
import mindMapDSML.Note;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.PatternAssistantUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.TransformationUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.WordUtils;
import org.mondo.editor.analysis.graphiti.diagram.wizards.MindMapMondoDiagramWizard;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.LayoutDiagramFeature;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.ui.utils.HeuristicsUtils;
import org.mondo.editor.ui.utils.patterns.MMInterfaceRelDiagram;
import org.mondo.editor.ui.utils.patterns.PatternApplicationUtils;
import org.mondo.editor.ui.utils.patterns.PatternUtils;
import org.mondo.editor.ui.utils.patterns.RuntimePatternsModelUtils;

import runtimePatterns.PatternInstances;
import dslPatterns.ClassInterface;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureType;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.ReferenceInterface;

/**
 * Class to generate a design diagram from the analysis diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateMondoDesignDiagram extends AbstractCustomFeature {
 
    public CreateMondoDesignDiagram(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Create Design Meta-model...";
    }
 
    @Override
    public String getDescription() {
        return "Create Design Meta-model";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
        		if (ModelUtils.existsMindMap((Diagram) pes[0]))
                	ret = true;
            }
        }
        return ret;
    }
 
    @Override
    public void execute(ICustomContext context) {    
		
		IFile file = IResourceUtils.getFile(getDiagram().eResource());
		final MindMap mindMap = ModelUtils.getBusinessModel(getDiagram());
		String name = file.getName();
		name = name.replaceFirst("[.][^.]+$", "")+"_design";	 
		
		MindMapMondoDiagramWizard dw = new MindMapMondoDiagramWizard(name);
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), dw)
		{
			@Override
	        protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			newShell.setSize(850, 650);
			}
		};
		dialog.create();
		
		dialog.getShell().setText("DSL-tao DIAGRAM");
		
		if (Window.OK == dialog.open()){
			
			String path = file.getLocationURI().toString();
			try{ 
			  	if (path != null) {									
				    TransactionalEditingDomain editingDomain = GraphitiUi.getEmfService().createResourceSetAndEditingDomain();
		
					ResourceSet metaResourceSet = editingDomain.getResourceSet();
				    
					String ifilePath = file.getParent().getFullPath().makeRelative().toString()+"/"+dw.getDiagramName()+".diagram"; 
					
					final Resource metaResource = new XMIResourceImpl(URI.createPlatformResourceURI(ifilePath, false));
					metaResourceSet.getResources().add(metaResource);

					final Diagram diagram = Graphiti.getPeCreateService().createDiagram("mondo", dw.getDiagramName(), true);							
					final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();	
					Map<Idea, EClass> ideasEClasses = new LinkedHashMap<Idea, EClass>();
					
					final EPackage pack = translateMindMapToEcore(mindMap, name, ideasEClasses, dw.getOptions());
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					
							@Override
							protected void doExecute() {
								metaResource.getContents().add(diagram);
								metaResource.getContents().add(pack);
																
								dp.init(diagram, dp.getDiagramBehavior());
								dp.getFeatureProvider().link(diagram, pack);
								
						        DiagramUtils.initCollapseInheritance(diagram);
							}
					});
					IResourceUtils.saveResource(metaResource);						
					file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);		
					DiagramUtils.drawDiagram(dp.getFeatureProvider(), diagram);    
					
					IResourceUtils.saveResource(metaResource);
				   
					file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				   
					try {
						IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
								
						IFile fich = file.getParent().getFile(new Path(dw.getDiagramName()+".diagram"));
						
						IEditorPart ep = IDE.openEditor(activePage, fich);				
						activePage.closeEditor(ep, false);
						ep = IDE.openEditor(activePage, fich);
						
						//PATRONES
						if (activePage.getActiveEditor() instanceof IDiagramContainerUI){
							IDiagramContainerUI editor = (IDiagramContainerUI)activePage.getActiveEditor();
							
							PatternInstances pis = RuntimePatternsModelUtils.getPatternInstances(editor.getDiagramBehavior(), true);
							List<PatternMetaModel> appliedPatterns = new LinkedList<PatternMetaModel>();
							for (Idea idea: ideasEClasses.keySet()){
								if (idea.getPattern()!= null){
									//if mainIdea reset appliedPatterns
									if (ModelUtils.isFirstLevel(idea)) appliedPatterns.clear();
									if (!PatternAssistantUtils.containsMetamodel(appliedPatterns, idea.getPattern())){
										Map<ClassInterface, EClass> binding = getPatternBinding(idea, ideasEClasses);
										createPattern(pack, ideasEClasses.get(idea),idea.getPattern(),editor.getDiagramBehavior(), pis, binding);
										appliedPatterns.add(idea.getPattern());
									}
								}
							}
							TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(editor.getDiagramTypeProvider().getDiagram());
							domain.getCommandStack().execute(new RecordingCommand(domain) {
								
								@Override
								protected void doExecute() {
							        LayoutDiagramFeature ldf = new LayoutDiagramFeature(editor.getDiagramTypeProvider().getFeatureProvider());
							        ldf.execute(null);
								}
							});
						}
						
						activePage.saveEditor(ep, false);
					} catch (PartInitException e) {	
					}
					Messages.displayGeneralMessage("Create Diagram", "Your diagram was created successfully");
				} 
			}catch (Exception ex){ 
				Messages.displayGeneralErrorMessage("Create Diagram", "Your diagram wasn't created successfully");
				ex.printStackTrace(); 
			} 
		}
    }
    
    /**
     * Static method that translates a mind map into an ecore
     * @param mindMap
     * @param diagramName
     * @param ideasEClasses
     * @return the main package of the ecore.
     */
    private static EPackage translateMindMapToEcore(MindMap mindMap, String diagramName, Map<Idea, EClass> ideasEClasses, Map<String, Boolean> options){

    	EPackage pack = EcoreFactory.eINSTANCE.createEPackage();

    	pack.setName(diagramName);
		pack.setNsPrefix(diagramName.toLowerCase());
		pack.setNsURI("http://mondo.org/"+diagramName.replace(" ",""));
		
		//1. TRANSLATE IDEAS.
		for (Idea idea: mindMap.getIdeas()){
			translateIdeatoClass(pack,null, idea, ideasEClasses, options);
		}
		
		
		//2. REFERENCES, ATTRIBUTES AND ANNOTATIONS.
		for (Idea idea: ideasEClasses.keySet()){
			EClass sourceEClass = ideasEClasses.get(idea);
			//REFERENCES.
			for (Link link: idea.getLinks()){
				EClass targetClass = ideasEClasses.get(link.getTarget());
				EReference eref = EcoreFactory.eINSTANCE.createEReference();
				String name =  org.mondo.editor.graphiti.diagram.utils.ModelUtils.getRefNameValid(sourceEClass, TransformationUtils.getNameRef(link));
				eref.setName(name);
				eref.setEType(targetClass);

				//CARDINALITY
				eref.setLowerBound(TransformationUtils.fulfillCondition(TransformationUtils.OPTIONAL_REFERENCE,link, options)?0:1);
				eref.setUpperBound(TransformationUtils.fulfillCondition(TransformationUtils.MULTIPLICITY,link, options)?-1:1);
			
				sourceEClass.getEStructuralFeatures().add(eref);	
			}
			
			//ATRIBUTES
			for (Feature feature: idea.getFeatures()){
				if (TransformationUtils.fulfillCondition(TransformationUtils.FEATURE_TO, feature, options))
					translateFeatureToAttribute(sourceEClass, feature, TransformationUtils.fulfillCondition(TransformationUtils.COMMA_TO_ENUM, feature, options));
				else translateFeatureToClass(pack, sourceEClass, feature);
			}
			
			//ANNOTATIONS (NOTES)
			if (TransformationUtils.fulfillCondition(TransformationUtils.NOTE_TO_ANNOTATION, idea, options)){
				EAnnotation noteAnnot = EcoreFactory.eINSTANCE.createEAnnotation();
				sourceEClass.getEAnnotations().add(noteAnnot);
				noteAnnot.setSource("notes");
				for (Note note: idea.getNotes()){
					EClass entryClass = EcoreFactory.eINSTANCE.getEcorePackage().getEStringToStringMapEntry();
					EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(entryClass);
					entry.setKey(ModelUtils.getNoteKeyValid(noteAnnot));
					entry.setValue(note.getText());
					noteAnnot.getDetails().add(entry);
				}
			}
		}
		return pack;
	}
    /**
     * Static method that transforms a feature into an eattribute.
     * @param eclassParent - parent class.
     * @param feature
     */
    private static void translateFeatureToAttribute(EClass eclassParent, Feature feature, Boolean commas){
    	EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
		att.setName(WordUtils.toCamelCase(feature.getKey(), false));
		EClassifier classif = TransformationUtils.getEType(feature, commas);
		if (classif instanceof EEnum) 
			((EPackage)eclassParent.eContainer()).getEClassifiers().add(classif);
		att.setEType(classif);
		att.setDefaultValueLiteral(TransformationUtils.getDefaultValue(feature, commas));
		eclassParent.getEStructuralFeatures().add(att);
    }
    
    /**
     * Static method that transforms a feature into an eclass.
     * @param pack - ePackage
     * @param eclassParent - parent class
     * @param feature 
     */
    private static void translateFeatureToClass(EPackage pack, EClass eclassParent, Feature feature){
    	EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		String name = org.mondo.editor.graphiti.diagram.utils.ModelUtils.getClassNameValid(pack,WordUtils.toCamelCase(feature.getKey(), true));
		eclass.setName(name);
		
		EReference eref = EcoreFactory.eINSTANCE.createEReference();
		eref.setEType(eclass);
		eref.setContainment(true);
		
		String nameRef =  org.mondo.editor.graphiti.diagram.utils.ModelUtils.getRefNameValid(eclassParent, feature.getKey()+"s");
		eref.setName(nameRef);

		//CARDINALITY
		eref.setLowerBound(1);
		eref.setUpperBound(1);
		
		eclassParent.getEStructuralFeatures().add(eref);	
		pack.getEClassifiers().add(eclass);
    }
	
    /**
     * Static method that translates an idea into a class, and establish the relationship between the idea and its parent idea.
     * @param pack
     * @param eclassParent
     * @param idea
     * @param ideasEClasses map that associate ideas with their related class.
     * @return boolean - true = transformation into a hierarchy.
     */
	private static boolean translateIdeatoClass(EPackage pack, EClass eclassParent, Idea idea, Map<Idea, EClass> ideasEClasses, Map<String,Boolean> options){
		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		String name = "";
		boolean inheritance = false;
		if (idea.getPattern() != null){
			String roleName = "";
			if (idea.getPatternRole() != null){
				EClass eclassPattern = PatternUtils.getEClass(idea.getPatternRole());
				if (eclassPattern != null) roleName = eclassPattern.getName();
			}
			if (roleName.isEmpty()) roleName = getRootName(idea.getPattern());
			
			name = org.mondo.editor.graphiti.diagram.utils.ModelUtils.getClassNameValid(pack, roleName);//IMPORTANTE BUSCAR
		}else name = org.mondo.editor.graphiti.diagram.utils.ModelUtils.getClassNameValid(pack, TransformationUtils.fulfillCondition(TransformationUtils.IDEA_TO_SINGULAR, idea, options)?WordUtils.toSingular(WordUtils.toCamelCase(idea.getName(), true)):WordUtils.toCamelCase(idea.getName(), true) );
		eclass.setName(name);
		
		if (eclassParent != null)
			if (TransformationUtils.fulfillCondition(TransformationUtils.INHERITANCE,idea, options)){
				eclass.getESuperTypes().add(eclassParent);
				inheritance = true;
			}else{
				EReference eref = EcoreFactory.eINSTANCE.createEReference();
				eref.setEType(eclass);
				eref.setContainment(true);
				
				String nameRef =  org.mondo.editor.graphiti.diagram.utils.ModelUtils.getRefNameValid(eclassParent, TransformationUtils.getNameRef(idea));
				eref.setName(nameRef);
				
				//CARDINALITY
				eref.setLowerBound(TransformationUtils.fulfillCondition(TransformationUtils.OPTIONAL_REFERENCE,idea, options)?0:1);
				eref.setUpperBound(TransformationUtils.fulfillCondition(TransformationUtils.MULTIPLICITY,idea,options)?-1:1);
				
				eclassParent.getEStructuralFeatures().add(eref);		
				
				//Eopposite
				if (TransformationUtils.fulfillCondition(TransformationUtils.BIDIRECTIONAL_CONTAINMENT, idea, options)){
					EReference eopp = EcoreFactory.eINSTANCE.createEReference();
					eopp.setEType(eclassParent);
					
					
					String nameRefOp =  org.mondo.editor.graphiti.diagram.utils.ModelUtils.getRefNameValid(eclass, TransformationUtils.getNameRefOpp(idea));
					eopp.setName(nameRefOp);
					
					//CARDINALITY
					eopp.setLowerBound(0);
					eopp.setUpperBound(1);
					
					eclass.getEStructuralFeatures().add(eopp);
					eref.setEOpposite(eopp);
					eopp.setEOpposite(eref);
				}
		}
			
		pack.getEClassifiers().add(eclass);
		ideasEClasses.put(idea, eclass);
		boolean inheritance2 = true;
		for (Idea ssubIdea: idea.getContains()){
			inheritance2 = translateIdeatoClass(pack,eclass, ssubIdea, ideasEClasses, options) && inheritance2;
		}
		eclass.setAbstract(inheritance2 && idea.getContains().size()>1);
		return inheritance;
	}
	
	/**
	 * Static method that returns 
	 * @param pattern
	 * @return
	 */
	private static String getRootName (PatternMetaModel pattern){
		ClassInterface ci = getRoot(pattern);
		if (ci!= null){
			EClass eclass = PatternUtils.getEClass(ci);
			if (eclass != null) return eclass.getName();
		}
		return "";
	}
	
	/**
	 * Static method that returns 
	 * @param pattern
	 * @return
	 */
	private static ClassInterface getRoot (PatternMetaModel pattern){
		for (ClassInterface ci: pattern.getClassInterfaces()){
			if (!ci.isAbstract()){
				return ci;
			}
		}
		return null;
	}
	
	/**
	 * Static method that creates the pattern (metamodel) into the package being the class root, the root element within the pattern.
	 * @param pack
	 * @param root
	 * @param metamodel
	 * @param db
	 * @param pis
	 */
	private static void createPattern (EPackage pack, EClass root, PatternMetaModel metamodel, DiagramBehavior db, PatternInstances pis, Map< ClassInterface, EClass> binding){
		//boolean first = true;
		List<MMInterfaceRelDiagram> patternRelDiagram = new LinkedList<MMInterfaceRelDiagram>();
		  if (metamodel!=null){
			  for (ClassInterface ci: metamodel.getClassInterfaces()){ 
				  if (PatternUtils.existsEClass(ci)){
					  String element = "";
					  if (binding.get(ci)!= null) element = binding.get(ci).getName();
					  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ci, element, patternRelDiagram);
					  patternRelDiagram.add(relElement);		  
				  }
			  }
			  for (FeatureInterface fi: metamodel.getAttrInterfaces()){  
				  if (PatternUtils.existsEAttribute(fi))
					  if (fi instanceof FeatureType){
						  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, "", patternRelDiagram);
						  patternRelDiagram.add(relElement);
					  }else {//FeatureInstance
						  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, PatternUtils.getDefaultValue((FeatureInstance)fi), patternRelDiagram);
						  patternRelDiagram.add(relElement);
					  }
			  }
			  for (ReferenceInterface ri: metamodel.getRefInterfaces())	 {   	
				  if (PatternUtils.existsEReference(ri)){
					  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ri, "", patternRelDiagram);
					  
					  List<ENamedElement> recommended = HeuristicsUtils.getOptimalElements(relElement, pack, patternRelDiagram);
					  if (recommended.size()>0) {
						  if (recommended.get(0)instanceof EReference){
							  EReference ref = (EReference)(recommended.get(0));
							  relElement.setElementDiagram( ref.getEContainingClass().getName()+"/"+ref.getName());
						  }
					  }
					  //////////////////
					  
					  patternRelDiagram.add(relElement);
				  }
			  }
			 //InstanceName 
			  Pattern pattern = getPattern(metamodel);
			  String patternInstanceName = RuntimePatternsModelUtils.getPatternNameValid(pis, pattern.getName());
			 PatternApplicationUtils.applyPattern(patternRelDiagram, db, getPattern(metamodel), pis, patternInstanceName, false);
	    	}
	}
	
	@Override
	public boolean hasDoneChanges() {
		return false;
	}
	
	/**
	 * Static method that returns the pattern associated with a metamodel.
	 * @param metamodel
	 * @return the pattern object
	 */
	private static Pattern getPattern(PatternMetaModel metamodel){
		if (((ComplexFeatureMain)metamodel.eContainer()).eContainer() instanceof ComplexFeatureMain)
			if (((ComplexFeatureMain)metamodel.eContainer()).eContainer().eContainer() instanceof Pattern)
				return (Pattern)((ComplexFeatureMain)metamodel.eContainer()).eContainer().eContainer();
		return null;
	}
	
	private static Map<ClassInterface, EClass> getPatternBinding (Idea idea, Map<Idea, EClass> ideasEClasses){
		Map< ClassInterface, EClass> binding = new HashMap<ClassInterface, EClass>();
		PatternMetaModel pattern = idea.getPattern();
		
		if (idea.getPatternRole()!=null) 
			binding.put(idea.getPatternRole(), ideasEClasses.get(idea));
		else {//Será el root
			ClassInterface root = getRoot(idea.getPattern());
			if (root!=null)binding.put(root, ideasEClasses.get(idea));
		}
		Idea root = ModelUtils.getRootIdea(idea);
		for (Idea subidea: root.getContains()){
			fillPatternBinding(subidea, ideasEClasses, pattern, binding);
		}
		
		return binding;
	}
	
	private static void fillPatternBinding (Idea idea, Map<Idea, EClass> ideasEClasses, PatternMetaModel pattern, Map< ClassInterface, EClass> binding){
		PatternMetaModel patternIdea = idea.getPattern();
		if (pattern.equals(patternIdea)){
			if (idea.getPatternRole()!=null) 
				binding.put(idea.getPatternRole(), ideasEClasses.get(idea));
		}
		for (Idea subidea: idea.getContains()){
			fillPatternBinding(subidea, ideasEClasses, pattern, binding);
		}
	}
	
}