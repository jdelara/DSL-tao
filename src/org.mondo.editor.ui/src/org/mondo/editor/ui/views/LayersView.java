package org.mondo.editor.ui.views;

import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.ui.utils.ImagesUtils;
import org.mondo.editor.ui.utils.layers.RuntimeLayersModelUtils;

import runtimeLayers.Layer;

public class LayersView extends ViewPart {

	public static final String ID = "org.mondo.editor.ui.views.LayersView";
	
	private TableViewer viewer;
	public LayersView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent,SWT.BORDER);
		
	    viewer.setContentProvider(new IStructuredContentProvider() {
			
	    	@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				  List<Layer> list = (List<Layer>) inputElement;
				  return  list.toArray();
			}
		});	
	    viewer.getTable().setHeaderVisible(true);
		
	    createTableViewerColumn(viewer, "Active",60,0);
	    createTableViewerColumn(viewer, "Show",80, 1);
	    createTableViewerColumn(viewer, "Layer",200, 2);
	}
	
	private static TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int width,  final int colNumber) {
	    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(width);
	    column.setResizable(true);
	    column.setMoveable(true);
	    
	    viewerColumn.setLabelProvider(new ColumnLabelProvider(){
	    	@Override
		      public String getText(Object element) {
		    	switch (colNumber) {
			    	case 1: return (((Layer)element).isVisualised()?"Yes":"No");
			    	case 2: return ((Layer)element).getName();
				}  
		    	return "";
		      }

			@Override
			public Image getImage(Object element) {
				switch (colNumber) {
		    	case 0: 
		    		ImageDescriptor desc = null;
					if (((Layer)element).isActivated())
						desc = ImagesUtils.getImageDescriptor("icons/activable.gif");
					if (desc != null) return desc.createImage();
				}  
		    	return null;
			}
	    });
	    
	    return viewerColumn;
	  }

	@Override
	public void setFocus() {
		List<Layer> layers = null;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage.getActiveEditor() instanceof IDiagramContainerUI){	
			IEditorPart editor = activePage.getActiveEditor();				
			if (editor instanceof IDiagramContainerUI){	
				IDiagramTypeProvider dtp = ((IDiagramContainerUI)editor).getDiagramBehavior().getDiagramTypeProvider();
				if (dtp instanceof EcoreDiagramTypeProvider){
					layers = RuntimeLayersModelUtils.getAllLayers(((IDiagramContainerUI)editor).getDiagramBehavior());
				}				
			}
		}
		viewer.setInput(layers);
	}
}
