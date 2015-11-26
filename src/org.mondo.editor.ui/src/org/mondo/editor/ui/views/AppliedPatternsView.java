package org.mondo.editor.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.utils.ImagesUtils;
import org.mondo.editor.ui.utils.patterns.AppliedPatternUtils;
import org.mondo.editor.ui.utils.patterns.AppliedPatternsMenuAdapter;
import org.mondo.editor.ui.utils.patterns.InstanceFeatureMenuAdapter;
import org.mondo.editor.ui.utils.patterns.InstanceFeatureSupport;
import org.mondo.editor.ui.utils.patterns.RuntimePatternsModelUtils;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.RoleInstance;
import runtimePatterns.TypeFeatureRoleInstance;

/**
 * View to work with applied patterns.
 * 
 * @author miso  partner AnaPescador
 *
 */
public class AppliedPatternsView extends ViewPart {

	public static final String ID = "org.mondo.editor.ui.views.AppliedPatternsView";
	

	private TreeViewer viewer;
	private TableViewer fiViewer;
	private Diagram diagram = null;
	final List<ENamedElement> layerElements = new ArrayList<ENamedElement>();
	
	
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
	
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
				
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
		        | SWT.V_SCROLL);				    
		
		viewer.setContentProvider(treeContentProvider);
		viewer.setLabelProvider(treeLabelProvider);
		viewer.getTree().addSelectionListener(listenerSelectionElement);
		viewer.getTree().addFocusListener(focusListener);
		IWorkbenchPage page = this.getSite().getPage();
		page.addPartListener(pl);	
		
		fiViewer = AppliedPatternUtils.createViewerFeatureInstanceRoles(parent);
		final Menu menu = new Menu(fiViewer.getTable());
		fiViewer.getTable().setMenu(menu);			
		menu.addMenuListener(new InstanceFeatureMenuAdapter(menu, fiViewer));

	}	
	
	private ITreeContentProvider treeContentProvider = new ITreeContentProvider() {
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
		@Override
		public void dispose() {
		}
		
		@Override
		public boolean hasChildren(Object element) { 
			return ((element instanceof PatternInstance)|| (element instanceof ClassRoleInstance));
		}
		
		@Override
		public Object getParent(Object element) {
			return null;
		}
		
		@Override
		public Object[] getElements(Object inputElement) {
		    @SuppressWarnings("unchecked")
			List<PatternInstance> list = (List<PatternInstance>) inputElement;
		    return list.toArray();
		}
		
		@Override
		public Object[] getChildren(Object parentElement) {
			List<Object> list = null;	
			if (parentElement instanceof PatternInstance)
				list = new ArrayList<>(Arrays.asList(((PatternInstance)parentElement).getClassInstances().toArray()));
			else if (parentElement instanceof ClassRoleInstance){	
				list = new ArrayList<>();
				List<Object> listFeatures = new ArrayList<>(Arrays.asList(((ClassRoleInstance)parentElement).getFeatureInstances().toArray()));	
				for (Object fi : listFeatures)
					if (fi instanceof TypeFeatureRoleInstance) list.add(fi);
				list.addAll( new ArrayList<>(Arrays.asList(((ClassRoleInstance)parentElement).getReferenceInstances().toArray())));
			}
			
			return list.toArray();

		}
	};
	
	private LabelProvider treeLabelProvider = new LabelProvider(){
		@Override
		public String getText(Object element) {
			if (element instanceof PatternInstance)
				return ((PatternInstance)element).getIdent();
			else if (element instanceof RoleInstance){
				return RuntimePatternsModelUtils.getPatternRoleName((RoleInstance)element);
			}			
		    return "";
		}

		@Override
		public Image getImage(Object element) {
			ImageDescriptor desc = null;
			if (element instanceof PatternInstance){
				if (((PatternInstance)element).isAttached()) desc = ImagesUtils.getImageDescriptor("icons/attached.gif");
				else desc = ImagesUtils.getImageDescriptor("icons/appliedPatternsView.gif");
			
			}else if (element instanceof ClassRoleInstance){
				desc = ImagesUtils.getImageDescriptor("icons/eClass.gif");
			} else if (element instanceof ReferenceRoleInstance){
				desc = ImagesUtils.getImageDescriptor("icons/eReference.gif");
			} else if (element instanceof TypeFeatureRoleInstance){
				desc = ImagesUtils.getImageDescriptor("icons/eAttribute.gif");
			} 
			if (desc != null)return desc.createImage();
			return null;
			}
		}; 
	
	
	
	private SelectionListener listenerSelectionElement = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			
			if (obj != null){
				if (obj instanceof PatternInstance){					
					showHiddenElements();
					List<PictogramElement> pes = new ArrayList<PictogramElement>();
					
					for (ClassRoleInstance cri : ((PatternInstance)obj).getClassInstances()){							
						pes.add(DiagramUtils.getPictogramToSelect(diagram, RuntimePatternsModelUtils.getElement(cri)));
						ENamedElement element = RuntimePatternsModelUtils.getElement(cri);
						if (element!=null)layerElements.add(element);

						for (ReferenceRoleInstance rri :cri.getReferenceInstances()){
							pes.add(DiagramUtils.getPictogramToSelect(diagram,RuntimePatternsModelUtils.getElement(rri)));
							ENamedElement elementR = RuntimePatternsModelUtils.getElement(rri);
							if (elementR!=null)layerElements.add(elementR);
						}
					}
					DiagramUtils.selectPictograms(pes);
					if (pes.size()!=0)hideElements();
				} 
				
				else {
					if (obj instanceof ClassRoleInstance){
						fiViewer.setInput(RuntimePatternsModelUtils.getInstanceFeatureRolesInstances((ClassRoleInstance)obj));
						fiViewer.refresh();
					}
					else {
						if (fiViewer.getInput() != null){
							fiViewer.setInput(null);
							fiViewer.refresh();
						}
					}

					PictogramElement pe = DiagramUtils.getPictogramToSelect(diagram, RuntimePatternsModelUtils.getElement((RoleInstance)obj));
					DiagramUtils.selectPictogram(pe);
					showHiddenElements();
				}
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};

	private FocusListener focusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			if (diagram != null) {
				DiagramUtils.selectPictogram(diagram);
				showHiddenElements();		
			}	
		}
		
		@Override
		public void focusGained(FocusEvent e) {
		}
	};
	
	public void setFocus() {
		refresh();
	}
	
	public void refresh(){
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();				
		if (editor instanceof IDiagramContainerUI){	
			if (!viewer.getTree().isDisposed()){
				final Menu menu = new Menu(viewer.getTree());
				viewer.getTree().setMenu(menu);			
				menu.addMenuListener(new AppliedPatternsMenuAdapter(menu, viewer));	
				
				IDiagramTypeProvider dtp = ((IDiagramContainerUI)editor).getDiagramBehavior().getDiagramTypeProvider();
				if (dtp instanceof EcoreDiagramTypeProvider){
					
					DiagramBehavior diagramB = ((IDiagramContainerUI)editor).getDiagramBehavior();
					TableViewerColumn tvc = (TableViewerColumn)fiViewer.getTable().getColumn(1).getData(Policy.JFACE + ".columnViewer"); //No hay otra manera de obtenerlo.
					tvc.setEditingSupport(new InstanceFeatureSupport(fiViewer, diagramB));
				    
				    diagram = dtp.getDiagram();	
				    
					if (ModelUtils.existsPackage(diagram)){
						viewer.setInput(RuntimePatternsModelUtils.getAllAppliedPatterns(((IDiagramContainerUI)editor).getDiagramBehavior()));
						fiViewer.setInput(null);
						return;
					} 
				}
			}else return;
		}
		if (viewer!= null) if (!viewer.getTree().isDisposed())viewer.setInput(null);
		if (fiViewer!=null) if (!fiViewer.getTable().isDisposed())fiViewer.setInput(null);
	}
	
	private void showHiddenElements(){
		if (!layerElements.isEmpty()){
			if (!allLayerElementsNull()){
				final EPackage pack = ModelUtils.getBusinessModel(diagram);
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pack);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					
					@Override
					protected void doExecute() {
						for (EClassifier eclassif: pack.getEClassifiers() ){
							if (!layerElements.contains(eclassif))
								DiagramUtils.setElementVisibility(diagram, eclassif,true,layerElements);
						}
						for (EPackage epack: pack.getESubpackages() ){
							if (!layerElements.contains(epack))
							DiagramUtils.setElementVisibility(diagram, epack,true,layerElements);
						}
					}
				});
			}
	        layerElements.clear();
		}
	}
	
	private boolean allLayerElementsNull(){
		for (ENamedElement element: layerElements)
			if (element!=null)
				return false;
		return true;
	}
	
	private void hideElements(){
		if (!layerElements.isEmpty())
			if (!allLayerElementsNull()){
				final EPackage pack = ModelUtils.getBusinessModel(diagram);
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pack);
		        if (domain!=null)
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					
					@Override
					protected void doExecute() {
						for (EClassifier eclassif: pack.getEClassifiers()){
							if (!layerElements.contains(eclassif))
								if (eclassif instanceof EClass)DiagramUtils.setElementVisibility(diagram, eclassif,false,layerElements);
						}
						for (EPackage epack: pack.getESubpackages() ){
							if (!layerElements.contains(epack))
							DiagramUtils.setElementVisibility(diagram, epack,false,layerElements);
						}
					}
				});
			}
	}
	
}