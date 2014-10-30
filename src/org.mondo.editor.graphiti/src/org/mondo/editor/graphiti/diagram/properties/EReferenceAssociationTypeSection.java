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
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorFigure;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorText;

/**
 * Section to modify EReference EType value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EReferenceAssociationTypeSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Button bContainment;
	private Button bOrdered;
	private Button bUnique;
	
	private final String CONTAINMENT = "Containment";
	private final String ORDERED = "Ordered";
	private final String UNIQUE = "Unique";



	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		bContainment = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(15, 0);
		data.top = new FormAttachment(0, VSPACE);
		bContainment.setText(CONTAINMENT);
		bContainment.setLayoutData(data);		
		bContainment.addSelectionListener(listener);
		
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
	        
	        if (((EReference)bo).getEOpposite() !=  null)
	        	bContainment.setEnabled(!((EReference)bo).getEOpposite().isContainment());
	        else 
	        	bContainment.setEnabled(true);
	        
	        bContainment.setSelection(((EReference)bo).isContainment());

	        bOrdered.setSelection(((EReference)bo).isOrdered());
	        bUnique.setSelection(((EReference)bo).isUnique());
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
		        
			    if (control.getText().compareTo(CONTAINMENT)==0){
		        
			        if ((control.getSelection() != ((EReference)bo).isContainment())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								((EReference)bo).setContainment(control.getSelection());
								if (control.getSelection()){
									if (((EReference)bo).getEOpposite()!=null) {
										((EReference)bo).getEOpposite().setLowerBound(0);
										((EReference)bo).getEOpposite().setUpperBound(1);
										DiagramUtils.setDecoratorText((Connection)pe, "0..1", DecoratorText.EREF_DECORATOR_BOUNDS_OP);
									}
									DiagramUtils.createContainmentDecorator(getDiagram(), (Connection)pe, 0);
								} else {
									DiagramUtils.deleteDecorator((Connection)pe, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
								}
							}
						});
			        }
			    } else if (control.getText().compareTo(ORDERED)==0){
		        
			        if ((control.getSelection() != ((EReference)bo).isOrdered())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								((EReference)bo).setOrdered(control.getSelection());
								DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getOrderedUniqueText((EReference)bo), DecoratorText.EREF_DECORATOR_ORUNI);
							}
						});
			        }
			    } else if (control.getText().compareTo(UNIQUE)==0){
		        
			        if ((control.getSelection() != ((EReference)bo).isUnique())){
				        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EReference)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								((EReference)bo).setUnique(control.getSelection());
								DiagramUtils.setDecoratorText((Connection)pe, DiagramUtils.getOrderedUniqueText((EReference)bo), DecoratorText.EREF_DECORATOR_ORUNI);
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
