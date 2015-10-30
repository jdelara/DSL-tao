package org.mondo.editor.analysis.graphiti.diagram.properties;

import java.util.Iterator;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.MindMapDSMLFactory;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.PropertiesUtils;

public class IdeaFeaturesSection extends GFPropertySection implements ITabbedPropertyConstants {

	private final int ALTO_GRUPO = 220;
	private final int ANCHO_GRUPO = 550;
	private final int ALTO_BTN = 30;
	private final int ANCHO_BTN = 60;
	private final int SEPARACION_VERTICAL = 30;
	private final int MARGEN_IZQ = 15;
	private final int ALTO_LST = 180;
	private final int ANCHO_LST = 190;
	
	private TableViewer viewerValues;
	private Button btnDeleteValue;
	
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		Group grpValues = factory.createGroup(composite, "Values: ");
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.width = ANCHO_GRUPO;
		data.height = ALTO_GRUPO;
		grpValues.setLayoutData(data);
		grpValues.setLayout(null);
		
		viewerValues = PropertiesUtils.createViewerValues(grpValues);
		
		Button btnAddValue = factory.createButton(grpValues, "Add", SWT.PUSH);
		btnAddValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);		
		btnAddValue.addSelectionListener(listenerAddFeatureAction);
		
		btnDeleteValue = factory.createButton(grpValues, "Delete", SWT.PUSH);
		btnDeleteValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);
		btnDeleteValue.addSelectionListener(listenerDeleteFeatureAction);

	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	    	
	        if (bo == null)
	            return;
	        
	        viewerValues.setInput(((Idea)bo).getFeatures());
	        viewerValues.refresh();
	    }
	}

	private SelectionListener listenerAddFeatureAction = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
            final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
              
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Idea)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
					    Feature feature = MindMapDSMLFactory.eINSTANCE.createFeature();
				        feature.setKey(ModelUtils.getFeatureKeyValid((Idea)bo));
				        feature.setValue("value");
				        ((Idea)bo).getFeatures().add(feature);
				        viewerValues.refresh();
					}
		        });
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};
	
	
	private SelectionListener listenerDeleteFeatureAction = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
            final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
              
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Idea)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						ISelection selectionValue = viewerValues.getSelection();
						 if (selectionValue != null && selectionValue instanceof IStructuredSelection){
							 
							IStructuredSelection sel = (IStructuredSelection) selectionValue; 

				            for (@SuppressWarnings("unchecked")
							Iterator<Feature> iterator = sel.iterator(); iterator.hasNext();) {
				                final Feature value = (Feature)iterator.next();
				                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(value);
						        domain.getCommandStack().execute(new RecordingCommand(domain) {
									@Override
									protected void doExecute() {
										((Idea)bo).getFeatures().remove(value);
									}
						        });
				              }
				            viewerValues.setSelection(StructuredSelection.EMPTY);
					        viewerValues.refresh();
						 }
					}
		        });
		       
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};
	
}
