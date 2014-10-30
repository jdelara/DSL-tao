package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EPackage;
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
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to modify EPackage nsURI value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EPackageNsURISection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text nsURI;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		nsURI = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		nsURI.setLayoutData(data);
		
		nsURI.addFocusListener(focusListener);
		nsURI.addKeyListener(keyListener);

		
		CLabel valueLabel = factory.createCLabel(composite,  "Ns URI:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nsURI, -HSPACE);
		data.top = new FormAttachment(nsURI, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	    	
	    	EPackage pack = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        
	    	String uri = pack.getNsURI();
	        nsURI.setText(uri == null ? "" : uri);
	    }
	}
	
	private KeyListener keyListener = new KeyListener() {
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.CR){
				setNewNsURI(e);
			}
		}
	};
	
	
	private FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			setNewNsURI(e);
		}
		
		@Override
		public void focusGained(FocusEvent e) {			
		}
	};
	
	private void setNewNsURI(TypedEvent e){
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {  		        
	        final Text control = (Text)e.getSource();     
	        final EPackage bo = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        
	        if  (bo.getNsURI().compareTo(control.getText())!=0){
	        	if (control.getText().isEmpty()){
            		control.setText(((EPackage)bo).getNsURI());
	        		Messages.displayEditErrorMessage("Empty Ns URI");
				}else if (!ModelUtils.isURIValid(control.getText())){
            		control.setText(((EPackage)bo).getNsURI());
					Messages.displayEditErrorMessage("Ns URI is not valid");
				}else{
		        	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(bo);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							bo.setNsURI(control.getText());
						}
			        });
				}
	        }
	    }		
	}

}
