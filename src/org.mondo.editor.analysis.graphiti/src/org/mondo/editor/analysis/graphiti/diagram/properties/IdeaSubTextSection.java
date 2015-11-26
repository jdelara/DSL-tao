package org.mondo.editor.analysis.graphiti.diagram.properties;

import mindMapDSML.Idea;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
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

/**
 * Section to modify "subtext" name value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class IdeaSubTextSection extends GFPropertySection implements ITabbedPropertyConstants {
	private Text subText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		subText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 125);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		subText.setLayoutData(data);
		
		subText.addFocusListener(focusListener);
		subText.addKeyListener(keyListener);
		
		
		CLabel valueLabel = factory.createCLabel(composite,  "SubText:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(subText, -HSPACE);
		data.top = new FormAttachment(subText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        String name = ((Idea) bo).getSubText();
	        subText.setText(name == null ? "" : name);
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
			refresh();
		}
	};
	
	
	private void setNewName(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
	        final EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        final Text control = (Text)e.getSource();    
	        
	        if (((Idea)bo).getName().compareTo(control.getText())!=0){
	        	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Idea)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						for (PictogramElement peAux : Graphiti.getLinkService().getPictogramElements(getDiagram(), bo)){
							if (peAux instanceof ConnectionDecorator) {
								org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) peAux.getGraphicsAlgorithm();
					            if (text.getValue().compareTo(control.getText())!=0){
				                    text.setValue(control.getText());	                    		
				                    ((Idea)bo).setSubText(control.getText());
					            }}
		        		}
					}
				});
	        } 
	    }

	}
}
