package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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
import org.mondo.editor.graphiti.diagram.utils.Messages;

/**
 * Section to modify EEnumLiteral value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EEnumLiteralValueSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text valueText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		valueText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		valueText.setLayoutData(data);
		
		valueText.addFocusListener(focusListener);
		valueText.addKeyListener(keyListener);
		
		CLabel valueLabel = factory.createCLabel(composite,  "Value:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(valueText, -HSPACE);
		data.top = new FormAttachment(valueText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        String value = String.valueOf(((EEnumLiteral) bo).getValue());
	        valueText.setText(value == null ? "" : value);
	    }
	}
	
	private KeyListener keyListener = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewValue(e);
			}
		}
	};

	private FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewValue(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			
		}
	};
	
	private void setNewValue(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
	        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource();    
	        final int value;
	        try{
	        	 value = Integer.valueOf(control.getText());
	        }catch (Exception e2){
	        	String valueS = String.valueOf(((EEnumLiteral) bo).getValue());
		        control.setText(valueS == null ? "" : valueS);
	        	Messages.displayEditErrorMessage("Please enter a number");
	        	return;
	        }
	        if (((EEnumLiteral)bo).getValue()!= value){
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EEnumLiteral)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						((EEnumLiteral)bo).setValue(value);
					}
				});
	        } 
	    }	
	}

}
