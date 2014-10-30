package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
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
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Section to specify if an EClass is abstract or not.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EClassAbstractSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Button bAbstract;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		bAbstract = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE);
		bAbstract.setText("abstract");
		bAbstract.setLayoutData(data);
		bAbstract.setSelection(true);
		
		bAbstract.addSelectionListener(listener);
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        bAbstract.setSelection(((EClass)bo).isAbstract());
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
		        
			    if ((control.getSelection() != ((EClass)bo).isAbstract())){
			        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EClass)bo);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						
						@Override
						protected void doExecute() {
							if (pe instanceof ContainerShape) {
					            ContainerShape cs = (ContainerShape) pe;
					            for (Shape shape : cs.getChildren()) {
					                if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
					                    org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) shape.getGraphicsAlgorithm();					                   
					                    if (DiagramUtils.isTag(text))
					                    	if (control.getSelection()) text.setValue("<<abstract>>");
					                    	else text.setValue("");
					                }
					            }
							}
					        ((EClass)bo).setAbstract(control.getSelection());			      	
						}
					});
		        }
		    }	
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};
}
