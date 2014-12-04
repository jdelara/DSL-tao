package org.mondo.editor.graphiti.diagram.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.PropertiesUtils;

/**
 * Section to work with additional information about an EClass:
 * all the attributes, ancestor, children and references.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EPackageAdditionalInformationSection extends GFPropertySection implements ITabbedPropertyConstants {

	private TableViewer viewerContainmentRoots;
	private TableViewer viewerInheritanceRoots;
	private CLabel labelNumClasses;
	private CLabel labelNumAttributes;
	private CLabel labelNumReferences;
	
	private final static int MARGEN_TOP = 10;
	private final int ALTO_GRUPO = 200;
	private final int ANCHO_GRUPO = 300;
	
	private List<ENamedElement> selectedNamedElements = new ArrayList<ENamedElement>();
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
			
		Group grpMetricElements = factory.createGroup(composite, "Metrics: ");
		grpMetricElements.redraw();
		FormData data_2 = new FormData();
		data_2.left = new FormAttachment(0, ANCHO_GRUPO*2);
		data_2.top = new FormAttachment(0, MARGEN_TOP);
		data_2.width = ANCHO_GRUPO*5/2;
		data_2.height = ALTO_GRUPO;
		grpMetricElements.setLayoutData(data_2);
		grpMetricElements.setLayout(new RowLayout(SWT.VERTICAL));
		
	    labelNumClasses = new CLabel(grpMetricElements, SWT.NONE);
	    labelNumAttributes = new CLabel(grpMetricElements, SWT.NONE);
	    labelNumReferences = new CLabel(grpMetricElements, SWT.NONE);
		
		Group grpContainerElements = factory.createGroup(composite, "All inheritance hierarchical roots: ");
		grpContainerElements.redraw();
		FormData data_1 = new FormData();
		data_1.left = new FormAttachment(0, ANCHO_GRUPO);
		data_1.right = new FormAttachment(grpMetricElements, -HSPACE);
		data_1.top = new FormAttachment(grpMetricElements, 0, SWT.CENTER);
		data_1.width = ANCHO_GRUPO;
		data_1.height = ALTO_GRUPO;
		grpContainerElements.setLayoutData(data_1);
		grpContainerElements.setLayout(null);
		viewerInheritanceRoots = PropertiesUtils.createViewerClasses(grpContainerElements);
		viewerInheritanceRoots.getTable().addMouseListener(mouseListener);
	
		Group grpContainedElements = factory.createGroup(composite, "All containment roots: ");
		grpContainedElements.redraw();
		FormData data_0 = new FormData();
		data_0.left = new FormAttachment(0, 0);
		data_0.right = new FormAttachment(grpContainerElements, -HSPACE);
		data_0.top = new FormAttachment(grpContainerElements, 0, SWT.CENTER);
		data_0.width = ANCHO_GRUPO;
		data_0.height = ALTO_GRUPO;
		grpContainedElements.setLayoutData(data_0);
		grpContainedElements.setLayout(null);
		viewerContainmentRoots = PropertiesUtils.createViewerClasses(grpContainedElements);		
		viewerContainmentRoots.getTable().addMouseListener(mouseListener);
	}

	@Override
	public void refresh() {
		PictogramElement peMain = getSelectedPictogramElement();
	    if (peMain != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(peMain);
	        if (bo == null)
	            return;
	        try{
		        viewerContainmentRoots.setInput(ModelUtils.getAllRootContaintmentElements((EPackage)bo));
		        viewerContainmentRoots.refresh();
		        viewerInheritanceRoots.setInput(ModelUtils.getAllRootInheritanceElements((EPackage)bo));
		        viewerInheritanceRoots.refresh();
		        
		        int[] metrics = ModelUtils.getMetrics((EPackage)bo);
		        labelNumClasses.setText("Num. EClasses: "+metrics[0]);
			    labelNumAttributes.setText("Num. EAttributes: "+metrics[1]);
			    labelNumReferences.setText("Num. EReferences: "+metrics[2]);
 		        
	        }catch(Exception e){
	        }
	    }
	}
	
	private MouseListener mouseListener = new MouseListener() {
		
		@Override
		public void mouseUp(MouseEvent e) {
			DiagramUtils.selectPictogram(getDiagram());
        	selectedNamedElements.clear();
		}
		
		@Override
		public void mouseDown(MouseEvent e) {
			Table control = (Table)e.getSource();    
	        TableItem[] selection = control.getSelection();
	        if (selection != null) {

	        	DiagramUtils.selectPictogram(getDiagram());
	        	selectedNamedElements.clear();
				for (TableItem ti : selection) {
	        		  ENamedElement value = (ENamedElement)ti.getData();
	        		  selectedNamedElements.add(value);
	        		  //Add its contained elements.
	        		  if (control.equals(viewerContainmentRoots.getTable()))
	        		  selectedNamedElements.addAll(ModelUtils.getAllContainedElements((EClass)value));
	        		  else selectedNamedElements.addAll(ModelUtils.getAllChildren((EClass)value));
	        	}   
	    		List<PictogramElement> pes = new ArrayList<>();			
	    		for (ENamedElement element:selectedNamedElements){
	    			PictogramElement pe = DiagramUtils.getPictogramToSelect(getDiagram(), element);
	    			if (pe != null)	pes.add(pe);					
	    		}
	    		DiagramUtils.selectPictograms(pes);	
	        }
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			
		}
	};

} 

