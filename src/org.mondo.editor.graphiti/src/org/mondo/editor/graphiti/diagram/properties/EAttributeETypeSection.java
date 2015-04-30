package org.mondo.editor.graphiti.diagram.properties;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.utils.DataTypeUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.DataTypeUtils.DataType;

/**
 * Section to modify EAttribute EType value.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EAttributeETypeSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Combo cDataType;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
			
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		cDataType = new Combo(composite, SWT.VERTICAL);
		data = new FormData();
		data.left = new FormAttachment(0, 100);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		
		cDataType.setLayoutData(data);
		
		cDataType.addSelectionListener(listener);
		
		
		CLabel valueLabel = factory.createCLabel(composite,  "EType:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cDataType, -HSPACE);
		data.top = new FormAttachment(cDataType, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	    
	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	        if (bo == null)
	            return;
	        
	        cDataType.removeAll();
	        for (DataType dt: DataType.values()){
				cDataType.add(dt.getText());
			}
	        List<EEnum> eenumL = ModelUtils.getEEnums(getDiagram());
	        for (EEnum enumAux: eenumL)
	        		cDataType.add(enumAux.getName());
	        
	        EDataType edt = (EDataType)((EAttribute) bo).getEType();
	        if (edt instanceof EEnum){
	        	cDataType.select(DataType.values().length + eenumL.indexOf(edt));
	        	
	        }else if (edt != null){
		        DataType dt= DataTypeUtils.getDataType(edt);
		        //No obtiene ese tipo de datos porque para la herramienta no exite.
		        
		        cDataType.select(DataTypeUtils.getIndex(dt));
	        }
	    }
	}
	
	private SelectionListener listener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
		        
		        final Combo control = (Combo)e.getSource();    
		        
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EAttribute)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {			
						
						
						DataType dt = DataTypeUtils.getDataType(control.getText());
	                    if (dt != null)	((EAttribute)bo).setEType(dt.getEDataType());
	                    else ((EAttribute)bo).setEType(ModelUtils.getEEnum(getDiagram(), control.getText()));
	                    
	                    if (pe instanceof ContainerShape) {
				            ContainerShape cs = (ContainerShape) pe;
				            for (Shape shape : cs.getChildren()) {
				                if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
				                    org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) shape.getGraphicsAlgorithm();
			                    		text.setValue(DiagramUtils.getAttributeText((EAttribute)bo));
			                    	}
				            }
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
