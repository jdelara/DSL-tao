package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
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
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to modify EnumLiteral literal value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EEnumLiteralNameSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text nameText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		nameText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		nameText.setLayoutData(data);
		
		nameText.addFocusListener(focusListener);
		nameText.addKeyListener(keyListener);
		
		CLabel valueLabel = factory.createCLabel(composite,  "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, -HSPACE);
		data.top = new FormAttachment(nameText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        String name = ((EEnumLiteral) bo).getName();
	        nameText.setText(name == null ? "" : name);
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
	        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource();    
	        
	        if (((EEnumLiteral)bo).getName().compareTo(control.getText())!=0){
	        	if (ModelUtils.existsEnumLitName(((EEnumLiteral)bo).getEEnum(), control.getText())){
            		control.setText(((EEnumLiteral)bo).getName());
	        		Messages.displayEditErrorMessage("Duplicated name");
            	}         		
            	else if (!ModelUtils.isIDValid(control.getText())){
            		control.setText(((EEnumLiteral)bo).getName());
            		Messages.displayEditErrorMessage("The name is not valid");
            	}	
            	else{
		        	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EEnumLiteral)bo);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							if (pe instanceof ContainerShape) {
					            ContainerShape cs = (ContainerShape) pe;
					            for (Shape shape : cs.getChildren()) {
					                if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
					                    org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) shape.getGraphicsAlgorithm();
					                    if (text.getValue().compareTo(control.getText())!=0){
					                    	text.setValue(control.getText());
						                    ((EEnumLiteral)bo).setName(control.getText());
					                    }}}}}
					});
            	}
	        } 
	    }	
	}

}
