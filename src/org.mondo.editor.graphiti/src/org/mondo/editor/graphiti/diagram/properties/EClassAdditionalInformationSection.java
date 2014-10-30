package org.mondo.editor.graphiti.diagram.properties;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.PropertiesUtils;

/**
 * Section to work with addional information about an EClass:
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
	 
	private final static int MARGEN_TOP = 10;
	private final int ALTO_GRUPO = 300;
	private final int ANCHO_GRUPO = 325;
	
	private List<ENamedElement> selectedNamedElements = new ArrayList<ENamedElement>();
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		Group grpReferences = factory.createGroup(composite, "All references: ");
		grpReferences.redraw();
		FormData data = new FormData();
		data.left = new FormAttachment(0, ANCHO_GRUPO*3);
		data.top = new FormAttachment(0, MARGEN_TOP);
		data.width = ANCHO_GRUPO;
		data.height = ALTO_GRUPO;
		grpReferences.setLayoutData(data);
		grpReferences.setLayout(null);
		viewerReferences = PropertiesUtils.createViewerReferences(grpReferences);
		viewerReferences.addSelectionChangedListener(listenerNamedElement);
		viewerReferences.getTable().addFocusListener(listenerFocusNamedElement);
		
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
		viewerChildren.addSelectionChangedListener(listenerNamedElement);
		viewerChildren.getTable().addFocusListener(listenerFocusNamedElement);
		
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
		viewerAncestors.addSelectionChangedListener(listenerNamedElement);
		viewerAncestors.getTable().addFocusListener(listenerFocusNamedElement);
		
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
		viewerAttributes.addSelectionChangedListener(listenerNamedElement);
		viewerAttributes.getTable().addFocusListener(listenerFocusNamedElement);		
	
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
	        	viewerChildren.setInput(ModelUtils.getAllChildren(getDiagram(),(EClass)bo));
	        	viewerChildren.refresh();
		        viewerReferences.setInput(((EClass)bo).getEAllReferences());
		        viewerReferences.refresh();
	        }catch(Exception e){
	        	
	        }
	    }
	}
	
	private ISelectionChangedListener listenerNamedElement = new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) { 
			
			TableViewer control = (TableViewer)event.getSource();    
	        ISelection selection = control.getSelection();
	        if (selection != null && selection instanceof IStructuredSelection) {
	        	IStructuredSelection sel = (IStructuredSelection) selection; 

	        	DiagramUtils.selectPictogram(getDiagram());
	        	selectedNamedElements.clear();
	        	for (@SuppressWarnings("unchecked")
				Iterator<ENamedElement> iterator = sel.iterator(); iterator.hasNext();) {
	        		  ENamedElement value = (ENamedElement)iterator.next();
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
	  };
	  
	  
	private FocusListener listenerFocusNamedElement = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			DiagramUtils.selectPictogram(getDiagram());
        	selectedNamedElements.clear();
        	if (!((Table)e.getSource()).isDisposed()) ((Table)e.getSource()).deselectAll();
		}
		
		@Override
		public void focusGained(FocusEvent e) {
		}
	  };
	  
	  
} 

