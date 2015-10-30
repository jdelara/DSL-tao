package org.mondo.editor.ui.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Policy;
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
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.ui.utils.ImagesUtils;
import org.mondo.editor.ui.utils.patterns.PatternUtils;
import org.mondo.editor.ui.utils.services.ActivateSupport;
import org.mondo.editor.ui.utils.services.PatternServiceInfo;
import org.mondo.editor.ui.utils.services.RuntimeServicesModelUtils;

import dslPatterns.Pattern;

public class PatternServicesView extends ViewPart {

	public static final String ID = "org.mondo.editor.ui.views.PatternServicesView";
	
	private TableViewer viewer;
	public PatternServicesView() {
	}
	
	IPartListener2 pl = new IPartListener2() {

       public void partActivated(IWorkbenchPartReference ref) {   
       }

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);   
			if (part instanceof IEditorPart) {
	        	   part.setFocus();
	        	   refresh();
	           }
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);   
			if (part instanceof IEditorPart) {
	        	   part.setFocus();
	        	   refresh();
	           }
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {	
		}
  };

	@Override
	public void createPartControl(Composite parent) {
		IWorkbenchPage page = this.getSite().getPage();
		page.addPartListener(pl);
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
				  List<PatternServiceInfo> list = (List<PatternServiceInfo>) inputElement;
		    	  return list.toArray();
			}
		});	
	    viewer.getTable().setHeaderVisible(true);
		
	    createTableViewerColumn(viewer, "Activate",80, 0);
	    createTableViewerColumn(viewer, "Pattern",200, 1);
	    createTableViewerColumn(viewer, "Service", 250,2);
	    createTableViewerColumn(viewer, "Activable",90, 3);
	    createTableViewerColumn(viewer, "Missing", 350,4);
	    createTableViewerColumn(viewer, "OfferedBy",700, 5);
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
		    	case 0: return ((((PatternServiceInfo)element).getMissing().isEmpty()?(((PatternServiceInfo)element).isActivated()?"Yes":"No"):""));
		    	case 1: return (((PatternServiceInfo)element).getPatternName());
				case 2: return (((PatternServiceInfo)element).getService()!=null?((PatternServiceInfo)element).getService().getName(): "No Service");
				case 4: return ((PatternServiceInfo)element).getMissingText();
				case 5: return ((PatternServiceInfo)element).getOfferedByText();
				}  
		    	return "";
		      }

			@Override
			public Image getImage(Object element) {
				switch (colNumber) {
				case 3: 
					ImageDescriptor desc = null;
					if (((PatternServiceInfo)element).getMissing().isEmpty())
						desc = ImagesUtils.getImageDescriptor("icons/activable.gif");
					else desc = ImagesUtils.getImageDescriptor("icons/noActivable.gif");
					if (desc != null) return desc.createImage();
				}  
		    	return null;
			}
	    });
	    
	    return viewerColumn;
	  }

	@Override
	public void setFocus() {
		refresh();
	}
	
	public void refresh(){
		List<PatternServiceInfo> services = null;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Resource intModel= null;
		List<Pattern> allPatterns = new LinkedList<>();
		IEditorPart editor = activePage.getActiveEditor();				
		if (editor instanceof IDiagramContainerUI){	
			
			IDiagramTypeProvider dtp = ((IDiagramContainerUI)editor).getDiagramBehavior().getDiagramTypeProvider();
			if (dtp instanceof EcoreDiagramTypeProvider){
				services = RuntimeServicesModelUtils.getPatternServicesInfo(((IDiagramContainerUI)editor).getDiagramBehavior());
				IProject project = IResourceUtils.getProject(dtp.getDiagram().eResource());
				intModel = (Resource)((EcoreDiagramTypeProvider)dtp).getInterfaceModel();
				if(intModel== null) {
					intModel = PatternUtils.getInterfaceModel(project);
					((EcoreDiagramTypeProvider)dtp).setInterfaceModel(intModel);
				}
				allPatterns = PatternUtils.getAllPatterns(project);
			}				
		}
		if (!viewer.getTable().isDisposed()){
			TableViewerColumn tvc = (TableViewerColumn)viewer.getTable().getColumn(0).getData(Policy.JFACE + ".columnViewer"); 
			tvc.setEditingSupport(new ActivateSupport(viewer, intModel, allPatterns));		
			viewer.setInput(services);
		}
	}
}
