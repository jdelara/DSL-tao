package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Connection;
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
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorText;
import org.mondo.editor.graphiti.diagram.utils.Messages;

/**
 * Section to modify EReference bound values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EReferenceBoundsSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text lowerBound;
	private Text upperBound;


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
			
		lowerBound = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 130);
		data.right = new FormAttachment(10, 0);
		data.top = new FormAttachment(0, VSPACE);
		lowerBound.setLayoutData(data);
		lowerBound.setData("id", "lower");
		
		lowerBound.addFocusListener(focusListener);
		lowerBound.addKeyListener(keyListener);
		
		CLabel valueLabel = factory.createCLabel(composite,  "Lower Bound:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(lowerBound, -HSPACE);
		data.top = new FormAttachment(lowerBound, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		
		CLabel valueLabel2 = factory.createCLabel(composite,  "Upper Bound:");
		data = new FormData();
		data.left = new FormAttachment(lowerBound, HSPACE);
		data.top = new FormAttachment(lowerBound, 0, SWT.CENTER);
		valueLabel2.setLayoutData(data);
		
		upperBound = factory.createText(composite, "");
		upperBound.setData("id", "upper");
		data = new FormData();
		data.left = new FormAttachment(valueLabel2, HSPACE);
		data.top = new FormAttachment(valueLabel2, 0, SWT.CENTER);
		upperBound.setLayoutData(data);
		
		upperBound.addFocusListener(focusListener);
		upperBound.addKeyListener(keyListener);
		
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
	        
	      setOldValueControl(lowerBound, (EReference)bo);
	      setOldValueControl(upperBound, (EReference)bo);
	    }
	}
	
	private KeyListener keyListener = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewBound(e);
			}
		}
	};
	
	private FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewBound(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {			
		}
	};	
	
	private void setNewBound(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
	        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource(); 

	        final int bound;
	        try{
	        	if (control.getText().compareTo("*")==0) bound = -1;
	        	else bound = Integer.valueOf(control.getText());
	        }catch (Exception e2){
	        	setOldValueControl(control, (EReference) bo); 
	        	Messages.displayEditErrorMessage("Please enter a number");
	        	return;
	        }
	        
	        if (control.getData("id").toString().compareToIgnoreCase("lower")==0){
		        if (((EReference)bo).getLowerBound()!=bound){
	        		if (bound>=0)
	        		if ((((EReference)bo).getUpperBound()==-1) || (bound<=((EReference)bo).getUpperBound())){    	
			        	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								String key = DiagramUtils.getCollapseReferenceTextKey((EReference)bo);
					       		((EReference)bo).setLowerBound(bound);
					       		
					       		DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getBoundReferenceText((EReference)bo), DecoratorText.EREF_DECORATOR_BOUNDS);
								DiagramUtils.updateCollapseReferenceText(getDiagram(),key, (EReference)bo);

							}
						});	
			        }else {
			        	setOldValueControl(control, (EReference) bo); 
			        	Messages.displayEditErrorMessage("Please enter a number lower or equal to Upper Bound");
			        }
	        		else {
			        	setOldValueControl(control, (EReference) bo); 
	        			Messages.displayEditErrorMessage("Please enter a positive number");  
	        		}
		        }
	        }else {//UpperBound
	        	if (((EReference)bo).getUpperBound()!=bound){
	        		if (bound>=-1){
	        			if (((EReference)bo).getEOpposite()!=null)
	        				if ((((EReference)bo).getEOpposite().isContainment()) && ((bound > 1) || (bound < 0))){
	        		        	setOldValueControl(control, (EReference) bo); 
	        					Messages.displayEditErrorMessage("Please enter a number lower or equal to 1 ");
	        					return;
	        				}
	        			if ((bound==-1) || (bound>=((EReference)bo).getLowerBound())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								String key = DiagramUtils.getCollapseReferenceTextKey((EReference)bo);
								((EReference)bo).setUpperBound(bound);
					       		
					       		DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getBoundReferenceText((EReference)bo), DecoratorText.EREF_DECORATOR_BOUNDS);
					    		DiagramUtils.updateCollapseReferenceText(getDiagram(), key, (EReference)bo);
							}
						});
	        			} else {
	    		        	setOldValueControl(control, (EReference) bo); 
	        				Messages.displayEditErrorMessage("Please enter a number upper or equal to Lower Bound");   		
	        			}
	        		} else {
			        	setOldValueControl(control, (EReference) bo); 
	        			Messages.displayEditErrorMessage("Please enter a positive number");   
	        		}
	        	}
	        }
	    }
	}


}
