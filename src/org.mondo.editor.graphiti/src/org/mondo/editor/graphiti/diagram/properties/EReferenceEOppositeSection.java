package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorFigure;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorText;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to create/delete EOpposite EReference objects,
 * and modify their properties.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EReferenceEOppositeSection extends GFPropertySection implements ITabbedPropertyConstants {
	
	private Button bActiveOp;
	private Text nameTextOp;
	private Text lowerBoundOp;
	private Text upperBoundOp;
	private Button bContainmentOp;
	private Button bOrderedOp;
	private Button bUniqueOp;
	
	private final String ACTIVE = "Opposite";
	private final String CONTAINMENT = "Containment";
	private final String ORDERED = "Ordered";
	private final String UNIQUE = "Unique";


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		//check activate
		bActiveOp = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE);
		bActiveOp.setText(ACTIVE);
		bActiveOp.setLayoutData(data);
		bActiveOp.setSelection(false);
		bActiveOp.addSelectionListener(listenerActiveOp);
		
		nameTextOp = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE+30+5);
		nameTextOp.setLayoutData(data);
		nameTextOp.addFocusListener(focusListenerNameOp);
		nameTextOp.addKeyListener(keyListenerNameOp);
		nameTextOp.setEnabled(false);
		
		CLabel valueLabelNameOp = factory.createCLabel(composite,  "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameTextOp, -HSPACE);
		data.top = new FormAttachment(nameTextOp, 0, SWT.CENTER);
		valueLabelNameOp.setLayoutData(data);
		
		lowerBoundOp = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 130);
		data.right = new FormAttachment(10, 0);
		data.top = new FormAttachment(0, VSPACE+60+15);
		lowerBoundOp.setLayoutData(data);
		lowerBoundOp.setData("id", "lower");
		lowerBoundOp.addFocusListener(focusListenerBoundOp);
		lowerBoundOp.addKeyListener(keyListenerBoundOp);
		CLabel valueLabelLbOp = factory.createCLabel(composite,  "Lower Bound:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(lowerBoundOp, -HSPACE);
		data.top = new FormAttachment(lowerBoundOp, 0, SWT.CENTER);
		valueLabelLbOp.setLayoutData(data);
		lowerBoundOp.setEnabled(false);
		
		CLabel valueLabelUbOp = factory.createCLabel(composite,  "Upper Bound:");
		data = new FormData();
		data.left = new FormAttachment(lowerBoundOp, HSPACE);
		data.top = new FormAttachment(lowerBoundOp, 0, SWT.CENTER);
		valueLabelUbOp.setLayoutData(data);	
		upperBoundOp = factory.createText(composite, "");
		upperBoundOp.setData("id", "upper");
		data = new FormData();
		data.left = new FormAttachment(valueLabelUbOp, HSPACE);
		data.top = new FormAttachment(valueLabelUbOp, 0, SWT.CENTER);
		upperBoundOp.setLayoutData(data);
		upperBoundOp.addFocusListener(focusListenerBoundOp);
		upperBoundOp.addKeyListener(keyListenerBoundOp);
		upperBoundOp.setEnabled(false);
		
		bContainmentOp = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE+90+25);
		bContainmentOp.setText(CONTAINMENT);
		bContainmentOp.setLayoutData(data);
		bContainmentOp.addSelectionListener(listenerTypeOp);
		bContainmentOp.setEnabled(false);
		
		bOrderedOp = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE+120+25);
		bOrderedOp.setText(ORDERED);
		bOrderedOp.setLayoutData(data);
		bOrderedOp.addSelectionListener(listenerTypeOp);
		bOrderedOp.setEnabled(false);
		
		bUniqueOp = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE+150+25);
		bUniqueOp.setText(UNIQUE);
		bUniqueOp.setLayoutData(data);
		bUniqueOp.addSelectionListener(listenerTypeOp);	
		bUniqueOp.setEnabled(false);
	}

	
	private void setOldValueControl(Text control, EReference bo){
		if (control.getData("id").toString().compareToIgnoreCase("lower")==0) control.setText(String.valueOf(bo.getLowerBound()));
    	else {
    		 String upperBoundS = String.valueOf(bo.getUpperBound());
 	        control.setText(upperBoundS.compareTo("-1")==0 ? "*" : upperBoundS); 
    	}
	}
	
	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        EReference eOpposite = ((EReference)bo).getEOpposite();
	        if (eOpposite!=null){
	        	bActiveOp.setEnabled(true);
	        	bActiveOp.setSelection(true);
		        String name = eOpposite.getName();
		        nameTextOp.setText(name == null ? "" : name);
		        nameTextOp.setEnabled(true);
		        
		        lowerBoundOp.setEnabled(true);
	        	setOldValueControl(lowerBoundOp, eOpposite);
		        
		        upperBoundOp.setEnabled(true);
	        	setOldValueControl(upperBoundOp,eOpposite);
		        
		        bContainmentOp.setEnabled(!((EReference)bo).isContainment());
		        bContainmentOp.setSelection(eOpposite.isContainment());
		        bOrderedOp.setEnabled(true);
		        bOrderedOp.setSelection(eOpposite.isOrdered());
		        bUniqueOp.setEnabled(true);
		        bUniqueOp.setSelection(eOpposite.isUnique());
	        }
	    }
	}
	
	
	private SelectionListener listenerActiveOp = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {

			final Connection pe = (Connection)getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService()
		             .getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
		        
		        final Button control = (Button)e.getSource();    

				nameTextOp.setEnabled(control.getSelection());
				lowerBoundOp.setEnabled(control.getSelection());
				upperBoundOp.setEnabled(control.getSelection());
				bContainmentOp.setEnabled(control.getSelection());
				bOrderedOp.setEnabled(control.getSelection());
				bUniqueOp.setEnabled(control.getSelection());
			
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					
					@Override
					protected void doExecute() {
						
						if (control.getSelection()) {
							DiagramUtils.createEOppositeReference((EReference)bo, getDiagram());
							
						}else {
							DiagramUtils.setDecoratorText((Connection)pe, "", DecoratorText.EREF_DECORATOR_NAME_OP);
							DiagramUtils.setDecoratorText((Connection)pe, "", DecoratorText.EREF_DECORATOR_BOUNDS_OP);
							DiagramUtils.setDecoratorText((Connection)pe, "", DecoratorText.EREF_DECORATOR_ORUNI_OP);
							DiagramUtils.setDecoratorText((Connection)pe, "", DecoratorText.EREF_DECORATOR_PATTERN_OP);
							
							
							DiagramUtils.deleteDecorator((Connection)pe, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR);
							if (((EReference)bo).getEOpposite().isContainment()) DiagramUtils.deleteDecorator((Connection)pe, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
							
							DiagramUtils.deleteCollapseReferenceText(getDiagram(), ((EReference)bo).getEOpposite());
							ContainerShape peEnd =  (ContainerShape)pe.getEnd().eContainer();
							EClass sourceOpC = (EClass)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(peEnd); 
							sourceOpC.getEStructuralFeatures().remove(((EReference)bo).getEOpposite());
							((EReference)bo).setEOpposite(null);
						}
					}
				});
		        refresh();
			}

		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};
	
	
	private SelectionListener listenerTypeOp = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			//obtain pictogram element (EReference)
			final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        // the filter assured, that it is a EReference
		        if (bo == null)
		            return;
		        
		        final Button control = (Button)e.getSource();    
		        final EReference eOpposite = ((EReference)bo).getEOpposite();
		        
			    if (control.getText().compareTo(CONTAINMENT)==0){
		        
			        if ((control.getSelection() != eOpposite.isContainment())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								eOpposite.setContainment(control.getSelection());
								if (control.getSelection()){
									if (eOpposite.getEOpposite()!=null){
										eOpposite.getEOpposite().setLowerBound(0);
										eOpposite.getEOpposite().setUpperBound(1);
										DiagramUtils.setDecoratorText((Connection)pe, "0..1", DecoratorText.EREF_DECORATOR_BOUNDS);
									}
									DiagramUtils.createContainmentDecorator(getDiagram(), (Connection)pe, 1);	
								} else {
									DiagramUtils.deleteDecorator((Connection)pe, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
								}
							}
						});
			        }
			    } else if (control.getText().compareTo(ORDERED)==0){
		        
			        if ((control.getSelection() != eOpposite.isOrdered())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								eOpposite.setOrdered(control.getSelection());
								DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getOrderedUniqueText(eOpposite), DecoratorText.EREF_DECORATOR_ORUNI_OP);
							}
						});
			        }
			    } else if (control.getText().compareTo(UNIQUE)==0){
		        
			        if ((control.getSelection() != eOpposite.isUnique())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								eOpposite.setUnique(control.getSelection());
								DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getOrderedUniqueText(eOpposite), DecoratorText.EREF_DECORATOR_ORUNI_OP);
							}
						});
			        }
			    }
		    }	
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};
	
	private KeyListener keyListenerNameOp = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewNameOp(e);
			}
		}
	};
	
	
	private FocusListener focusListenerNameOp = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewNameOp(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {

		}
	};
	
	private void setNewNameOp(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        // the filter assured, that it is a EReference
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource();    
	        final EReference eOpposite = ((EReference)bo).getEOpposite();
	        
	        if (eOpposite.getName().compareTo(control.getText())!=0){
	        	if (ModelUtils.existsRefName(eOpposite.getEContainingClass(), control.getText())){
	        		control.setText(eOpposite.getName());
	        		Messages.displayEditErrorMessage("Duplicated name");
	        	}else {
			        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
				       		String key = DiagramUtils.getCollapseReferenceTextKey((EReference)eOpposite);

							eOpposite.setName(control.getText());
				       		DiagramUtils.setDecoratorText((Connection)pe, control.getText(), DecoratorText.EREF_DECORATOR_NAME_OP);
				       		
				       		DiagramUtils.updateCollapseReferenceText(getDiagram(), key, (EReference)eOpposite);
						}
					});
	        	}
	        } 
	    }
	}
	
	private KeyListener keyListenerBoundOp = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewBoundOp(e);
			}
		}
	};
	
	private FocusListener focusListenerBoundOp = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewBoundOp(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			
		}
	};	
	
	private void setNewBoundOp(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        // the filter assured, that it is a EReference
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource(); 
	        final EReference eOpposite = ((EReference)bo).getEOpposite();
	        final int bound;
	        try{
	        	if (control.getText().compareTo("*")==0) bound = -1;
	        	else bound = Integer.valueOf(control.getText());
	        }catch (Exception e2){
	        	setOldValueControl(control, eOpposite);
	        	Messages.displayEditErrorMessage("Please enter a number");
	        	return;
	        }
	        
	        if (control.getData("id").toString().compareToIgnoreCase("lower")==0){
		        if (eOpposite.getLowerBound()!=bound){
	        		if (bound>=0)
	        		if ((eOpposite.getUpperBound()==-1) || (bound<=eOpposite.getUpperBound())){    	
			        	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								DiagramUtils.setDecoratorText((Connection)pe, control.getText()+".."+(eOpposite.getUpperBound() == -1 ? "*" : eOpposite.getUpperBound()), DecoratorText.EREF_DECORATOR_BOUNDS_OP);
					       		String key = DiagramUtils.getCollapseReferenceTextKey(eOpposite);
								eOpposite.setLowerBound(bound);
					    		DiagramUtils.updateCollapseReferenceText(getDiagram(),key,(EReference)eOpposite);

							}
						});	
			        }else { 
			        	setOldValueControl(control,eOpposite);
			        	Messages.displayEditErrorMessage("Please enter a number lower than Upper Bound");
			        }
	        		else {
			        	setOldValueControl(control, eOpposite);
	        			Messages.displayEditErrorMessage("Please enter a positive number");  
	        		}
		        }
	        }else {
	        	if (eOpposite.getUpperBound()!=bound){
	        		if (bound>=-1){
	        			
	        			if (eOpposite.getEOpposite()!=null)
	        				if ((eOpposite.getEOpposite().isContainment()) && ((bound > 1)|| (bound <0))){
	        		        	setOldValueControl(control, eOpposite);
	        					Messages.displayEditErrorMessage("Please enter a number lower or equal to 1 ");
	        					return;
	        				}
	        			
		        		if ((bound==-1) || (bound>=eOpposite.getLowerBound())){
					        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eOpposite);
					        domain.getCommandStack().execute(new RecordingCommand(domain) {
								@Override
								protected void doExecute() {
									DiagramUtils.setDecoratorText((Connection)pe, eOpposite.getLowerBound()+".."+((control.getText() == "-1" ? "*" : control.getText())), DecoratorText.EREF_DECORATOR_BOUNDS_OP);
									String key = DiagramUtils.getCollapseReferenceTextKey(eOpposite);
									eOpposite.setUpperBound(bound);
						    		DiagramUtils.updateCollapseReferenceText(getDiagram(),key, (EReference)eOpposite);
								}
							});
				        }else {
				        	setOldValueControl(control, eOpposite);
				        	Messages.displayEditErrorMessage("Please enter a number upper than Lower Bound");  
				        }
	        		
	        	}else {
		        	setOldValueControl(control, eOpposite);
	        		Messages.displayEditErrorMessage("Please enter a positive number"); 
	        	}
	        	}
	        }
	    }
	}

}
