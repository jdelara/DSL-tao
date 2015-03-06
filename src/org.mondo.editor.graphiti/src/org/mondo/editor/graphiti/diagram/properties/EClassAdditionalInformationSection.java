package org.mondo.editor.graphiti.diagram.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
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
public class EClassAdditionalInformationSection extends GFPropertySection implements ITabbedPropertyConstants {
	
	private TableViewer viewerAttributes;
	private TableViewer viewerAncestors;
	private TableViewer viewerChildren;
	private TableViewer viewerReferences;
	private TableViewer viewerContainedElements;
	private TableViewer viewerContainerElements;

	
	private final static int MARGEN_TOP = 10;
	private final int ALTO_GRUPO = 300;
	private final int ANCHO_GRUPO = 220;
	
	private List<ENamedElement> selectedNamedElements = new ArrayList<ENamedElement>();
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
				
		Group grpContainerElements = factory.createGroup(composite, "All container elements: ");
		grpContainerElements.redraw();
		FormData data_1 = new FormData();
		data_1.left = new FormAttachment(0, ANCHO_GRUPO*5);
		data_1.top = new FormAttachment(0, MARGEN_TOP);
		data_1.width = ANCHO_GRUPO;
		data_1.height = ALTO_GRUPO;
		grpContainerElements.setLayoutData(data_1);
		grpContainerElements.setLayout(null);
		viewerContainerElements = PropertiesUtils.createViewerClasses(grpContainerElements);
		viewerContainerElements.getTable().addMouseListener(mouseListener);
		
		Group grpContainedElements = factory.createGroup(composite, "All contained elements: ");
		grpContainedElements.redraw();
		FormData data0 = new FormData();
		data0.left = new FormAttachment(0, ANCHO_GRUPO*4);
		data0.right = new FormAttachment(grpContainerElements, -HSPACE);
		data0.top = new FormAttachment(grpContainerElements, 0, SWT.CENTER);
		data0.width = ANCHO_GRUPO;
		data0.height = ALTO_GRUPO;
		grpContainedElements.setLayoutData(data0);
		grpContainedElements.setLayout(null);
		viewerContainedElements = PropertiesUtils.createViewerClasses(grpContainedElements);
		viewerContainedElements.getTable().addMouseListener(mouseListener);
		
		Group grpReferences = factory.createGroup(composite, "All references: ");
		grpReferences.redraw();
		FormData data = new FormData();
		data.left = new FormAttachment(0, ANCHO_GRUPO*3);
		data.right = new FormAttachment(grpContainedElements, -HSPACE);
		data.top = new FormAttachment(grpContainedElements, 0, SWT.CENTER);
		data.width = ANCHO_GRUPO;
		data.height = ALTO_GRUPO;
		grpReferences.setLayoutData(data);
		grpReferences.setLayout(null);
		viewerReferences = PropertiesUtils.createViewerReferences(grpReferences);
		viewerReferences.getTable().addMouseListener(mouseListener);
		
		Group grpChildren = factory.createGroup(composite, "All children: ");
		grpChildren.redraw();
		FormData data1 = new FormData();
		data1.left = new FormAttachment(0, ANCHO_GRUPO*2);
		data1.right = new FormAttachment(grpReferences, -HSPACE);
		data1.top = new FormAttachment(grpReferences, 0, SWT.CENTER);
		data1.width = ANCHO_GRUPO;
		data1.height = ALTO_GRUPO;
		grpChildren.setLayoutData(data1);
		grpChildren.setLayout(null);
		viewerChildren = PropertiesUtils.createViewerClasses(grpChildren);
		viewerChildren.getTable().addMouseListener(mouseListener);
		
		Group grpAncesters = factory.createGroup(composite, "All ancestors: ");
		grpAncesters.redraw();
		FormData data2 = new FormData();
		data2.left = new FormAttachment(0, ANCHO_GRUPO);
		data2.right = new FormAttachment(grpChildren, -HSPACE);
		data2.top = new FormAttachment(grpChildren, 0, SWT.CENTER);
		data2.width = ANCHO_GRUPO;
		data2.height = ALTO_GRUPO;
		grpAncesters.setLayoutData(data2);
		grpAncesters.setLayout(null);
		viewerAncestors = PropertiesUtils.createViewerClasses(grpAncesters);
		viewerAncestors.getTable().addMouseListener(mouseListener);
		
        Group grpAttributes = factory.createGroup(composite, "All attributes: ");
        grpAttributes.redraw();
		FormData data3 = new FormData();
		data3.left = new FormAttachment(0, 0);
		data3.right = new FormAttachment(grpAncesters, -HSPACE);
		data3.top = new FormAttachment(grpAncesters, 0, SWT.CENTER);
		data3.width = ANCHO_GRUPO;
		data3.height = ALTO_GRUPO;
		grpAttributes.setLayoutData(data3);
		grpAttributes.setLayout(null);
		
		viewerAttributes = PropertiesUtils.createViewerAttributes(grpAttributes);
		viewerAttributes.getTable().addMouseListener(mouseListener);
	}

	@Override
	public void refresh() {
		PictogramElement peMain = getSelectedPictogramElement();
	    if (peMain != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(peMain);
	        if (bo == null)
	            return;
	        try{
		        viewerAttributes.setInput(((EClass)bo).getEAllAttributes());
		        viewerAttributes.refresh();
		        viewerAncestors.setInput(((EClass)bo).getEAllSuperTypes());
		        viewerAncestors.refresh();
	        	viewerChildren.setInput(ModelUtils.getAllChildren((EClass)bo));
	        	viewerChildren.refresh();
		        viewerReferences.setInput(((EClass)bo).getEAllReferences());
		        viewerReferences.refresh();
		        viewerContainedElements.setInput(ModelUtils.getAllContainedElements((EClass)bo));
		        viewerContainedElements.refresh();
		        viewerContainerElements.setInput(ModelUtils.getAllContainerElements((EClass)bo));
		        viewerContainerElements.refresh();   
	        }catch(Exception e){
	        }
	    }
	}
	
	
	  
	  private MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				DiagramUtils.selectPictogram(getDiagram());
	        	selectedNamedElements.clear();
	        	if (!((Table)e.getSource()).isDisposed()) ((Table)e.getSource()).deselectAll();
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
		        		  if (value instanceof EAttribute) value = ((EAttribute)value).getEContainingClass();
		        		  selectedNamedElements.add(value);
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

