package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to modify EAttribute EType value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EAttributeTypeSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Button bID;
	private Button bOrdered;
	private Button bUnique;
	
	private final String ID = "ID";
	private final String ORDERED = "Ordered";
	private final String UNIQUE = "Unique";


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		bID = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE);
		bID.setText(ID);
		bID.setLayoutData(data);
		bID.setSelection(false);
		
		bID.addSelectionListener(listener);
		
		bOrdered = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE+30+5);
		bOrdered.setText(ORDERED);
		bOrdered.setLayoutData(data);
		bOrdered.addSelectionListener(listener);
		
		bUnique = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE+60+5);
		bUnique.setText(UNIQUE);
		bUnique.setLayoutData(data);
		bUnique.addSelectionListener(listener);	
		
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        bID.setSelection(((EAttribute)bo).isID());
	        
	        if (((EAttribute)bo).isID()){
	        	bID.setEnabled(true);	
	        }else bID.setEnabled(!ModelUtils.existsIDAtt(((EAttribute)bo).getEContainingClass()));
	        
	        bOrdered.setSelection(((EAttribute)bo).isOrdered());
	        bUnique.setSelection(((EAttribute)bo).isUnique());
	    }
	}
	
	
	private SelectionListener listener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService()
		             .getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
		        
		        final Button control = (Button)e.getSource();    
		        
			    if (control.getText().compareTo(ID)==0){
		        
			        if ((control.getSelection() != ((EAttribute)bo).isID())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EAttribute)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								((EAttribute)bo).setID(control.getSelection());
							}
						});
			        }
			    } else if (control.getText().compareTo(ORDERED)==0){
		        
			        if ((control.getSelection() != ((EAttribute)bo).isOrdered())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EAttribute)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								((EAttribute)bo).setOrdered(control.getSelection());
							}
						});
			        }
			    } else if (control.getText().compareTo(UNIQUE)==0){
		        
			        if ((control.getSelection() != ((EAttribute)bo).isUnique())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EAttribute)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								((EAttribute)bo).setUnique(control.getSelection());
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

}
