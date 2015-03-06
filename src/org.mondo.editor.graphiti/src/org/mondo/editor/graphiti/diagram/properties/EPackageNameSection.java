package org.mondo.editor.graphiti.diagram.properties;

import java.util.HashMap;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to modify EPackage name value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EPackageNameSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text name;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		name = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		name.setLayoutData(data);
		
		name.addFocusListener(focusListener);
		name.addKeyListener(keyListener);

		
		CLabel valueLabel = factory.createCLabel(composite,  "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(name, -HSPACE);
		data.top = new FormAttachment(name, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	    	EPackage pack = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        
	        String name = pack.getName();
	        this.name.setText(name == null ? "" : name);
	        if (pe instanceof Diagram){
	        	if(!((Diagram) pe).getName().startsWith(".")) this.name.setEnabled(true);
	        	else  this.name.setEnabled(false);
	        }else this.name.setEnabled(true); 
	    }
	}
	
	private KeyListener keyListener = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewName(e);
			}
		}
	};
	
	private FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewName(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			
		}
	};
	private void setNewName(TypedEvent e){
		
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {  		        
	        final Text control = (Text)e.getSource();    
	        
	        final EPackage bo = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        
	        //Name Validation
	        if (bo.getName().compareTo(control.getText())!=0){
	        	if (control.getText().isEmpty()){
            		control.setText(((EPackage)bo).getName());
	        		Messages.displayEditErrorMessage("Empty name");
				}else if (!ModelUtils.isIDValid(control.getText())){
            		control.setText(((EPackage)bo).getName());
					Messages.displayEditErrorMessage("The name is not valid");
				}else if (ModelUtils.existsEPackageName(getDiagram(), control.getText())){
            		control.setText(((EPackage)bo).getName());
					Messages.displayEditErrorMessage("Duplicated Name");
				}else{	
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EPackage)bo);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {	
							//related objects.
							HashMap<Diagram, Object[]>diagramsNewObjects = DiagramUtils.getRecursiveLinkedDiagramsNewObjects(getDiagramTypeProvider().getFeatureProvider(),(EPackage)bo , getDiagram());
							HashMap<Diagram, HashMap<EObject,Object[]>> diagramsNewObjectsR = new HashMap<Diagram, HashMap<EObject, Object[]>>();

							for (Diagram diagram: diagramsNewObjects.keySet()){
								HashMap<EObject, Object[]> objPes = new HashMap<EObject, Object[]>(); 
								for (Object pack: diagramsNewObjects.get(diagram)){
									if (pack instanceof EPackage){
										if (EcoreUtil.equals((EPackage)pack, ModelUtils.getBusinessModel(diagram))){
											for (EClassifier classif : ((EPackage)pack).getEClassifiers()){
												objPes.put(classif,Graphiti.getLinkService().getPictogramElements(diagram,classif).toArray());
												
												if (classif instanceof EClass){
													for (EAttribute att : ((EClass) classif).getEAttributes()){
														objPes.put(att,Graphiti.getLinkService().getPictogramElements(diagram,att).toArray());
														for (EAnnotation anott : att.getEAnnotations()){
															objPes.put(anott,Graphiti.getLinkService().getPictogramElements(diagram,anott).toArray());
														}
													}
													for (EReference ref : ((EClass) classif).getEReferences()){
														objPes.put(ref,Graphiti.getLinkService().getPictogramElements(diagram,ref).toArray());
														for (EAnnotation anott : ref.getEAnnotations()){
															objPes.put(anott,Graphiti.getLinkService().getPictogramElements(diagram,anott).toArray());
														}
													}
																								
												} else if (classif instanceof EEnum){
													for (EEnumLiteral lit : ((EEnum) classif).getELiterals()){
														objPes.put(lit,Graphiti.getLinkService().getPictogramElements(diagram,lit).toArray());
														for (EAnnotation anott : lit.getEAnnotations()){
															objPes.put(anott,Graphiti.getLinkService().getPictogramElements(diagram,anott).toArray());
														}
													}
												}
												for (EAnnotation anott : classif.getEAnnotations()){
													objPes.put(anott,Graphiti.getLinkService().getPictogramElements(diagram,anott).toArray());
												}
												
											}
										}
										objPes.put((EPackage)pack,Graphiti.getLinkService().getPictogramElements(diagram,(EPackage)pack).toArray());
										for (EAnnotation anott : ((EPackage)pack).getEAnnotations()){
											objPes.put(anott,Graphiti.getLinkService().getPictogramElements(diagram,anott).toArray());
										}
										
									}
								}
								diagramsNewObjectsR.put(diagram, objPes);
							}
							
							HashMap<Diagram, HashMap<PictogramElement, EObject[]>> diagramsNewPictR = new HashMap<Diagram, HashMap<PictogramElement, EObject[]>>();

							for (Diagram diagram: diagramsNewObjectsR.keySet()){
								
								HashMap<PictogramElement, EObject[]> peObjs = new HashMap<PictogramElement, EObject[]>();
								for (EObject obj : diagramsNewObjectsR.get(diagram).keySet()){
									
									for (Object pe :diagramsNewObjectsR.get(diagram).get(obj)){
										EObject[] oldObjects = peObjs.get(pe);
										if (oldObjects ==null){
											oldObjects = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement((PictogramElement)pe);
											peObjs.put((PictogramElement)pe, oldObjects);
										}
										for (int i=0; i<oldObjects.length;i++){
											if (EcoreUtil.equals(oldObjects[i], obj)){
												oldObjects[i] = obj;
											}
										}
									}				
								}
								diagramsNewPictR.put(diagram, peObjs);			
							}
							
							((EPackage)bo).setName(control.getText());

							for (Diagram diagram: diagramsNewPictR.keySet()) {
								
								if (diagram.getName().compareTo(getDiagram().getName())!=0){
								
									final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();
									dp.init(diagram, dp.getDiagramBehavior());
									
									for (PictogramElement pe: diagramsNewPictR.get(diagram).keySet() ){
										dp.getFeatureProvider().link(pe,diagramsNewPictR.get(diagram).get(pe));
									}
									
									IResourceUtils.saveResource(diagram.eResource());
									
								}
							}
								
							getDiagramTypeProvider().getFeatureProvider().link(getDiagram(),  Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(getDiagram()));
							IResourceUtils.saveResource(getDiagram().eResource());
						}
					});
				}
	        }
	    }
		
	}
}
