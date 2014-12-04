package org.mondo.editor.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.utils.AppliedPatternsMenuAdapter;
import org.mondo.editor.ui.utils.ImagesUtils;

/**
 * View to work with applied patterns.
 * 
 * @author miso  partner AnaPescador
 *
 */
public class AppliedPatternsView extends ViewPart {

	public static final String ID = "org.mondo.editor.ui.views.AppliedPatternsView";

	private TreeViewer viewer;
	private Diagram diagram = null;
	final List<ENamedElement> layerElements = new ArrayList<ENamedElement>();
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
		        | SWT.V_SCROLL);				    
		viewer.setContentProvider(treeContentProvider);
		viewer.setLabelProvider(treeLabelProvider);
		viewer.getTree().addSelectionListener(listenerSelectionEAnnotation);
		viewer.getTree().addMouseListener(mouseListener);
		viewer.getTree().addFocusListener(focusListener);
		
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
			if (element instanceof EAnnotation){
				return ((((EAnnotation)element).getEModelElement() instanceof EPackage) || (((EAnnotation)element).getEModelElement() instanceof EClass));
			}
			return false;
		}
		
		@Override
		public Object getParent(Object element) {
			return null;
		}
		
		@Override
		public Object[] getElements(Object inputElement) {
		    @SuppressWarnings("unchecked")
			List<EAnnotation> list = (List<EAnnotation>) inputElement;
		    return list.toArray();
		}
		
		@Override
		public Object[] getChildren(Object parentElement) {
				List<Object> listEAnnnotations = new ArrayList<>(Arrays.asList(((EAnnotation)parentElement).getReferences().toArray()));
				return listEAnnnotations.toArray();
		}
	};
	
	private LabelProvider treeLabelProvider = new LabelProvider(){
		@Override
		public String getText(Object element) {
			String s = ((EAnnotation) element).getSource();
		    return s;
		}

		@Override
		public Image getImage(Object element) {
			ImageDescriptor desc = null;
			if (((EAnnotation)element).getEModelElement()instanceof EPackage){
				desc = ImagesUtils.getImageDescriptor("icons/appliedPatternsView.gif");
			}else if (((EAnnotation)element).getEModelElement()instanceof EClass){
				desc = ImagesUtils.getImageDescriptor("icons/eClass.gif");
			} else if (((EAnnotation)element).getEModelElement()instanceof EReference){
				desc = ImagesUtils.getImageDescriptor("icons/eReference.gif");
			} else if (((EAnnotation)element).getEModelElement()instanceof EAttribute){
				desc = ImagesUtils.getImageDescriptor("icons/eAttribute.gif");
			} 
			if (desc != null)return desc.createImage();
			return null;
			}
		}; 
	
	private MouseListener mouseListener = new MouseListener() {
		
		@Override
		public void mouseUp(MouseEvent e) {
			if (diagram != null) {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				EAnnotation treeObj = (EAnnotation)obj;
				if (treeObj != null){
					if (!(treeObj.getEModelElement() instanceof EPackage)){	
						DiagramUtils.selectPictogram(diagram);
						showHiddenElements();		
					}
				}
			}	
		}
		
		@Override
		public void mouseDown(MouseEvent e) {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			EAnnotation treeObj = (EAnnotation)obj;
			if (treeObj != null){
				if (!(treeObj.getEModelElement() instanceof EPackage)){	
					PictogramElement pe = DiagramUtils.getPictogramToSelect(diagram, (ENamedElement) treeObj.getEModelElement());
					DiagramUtils.selectPictogram(pe);
					showHiddenElements();
				}
			}
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			
		}
	};
	
	private SelectionListener listenerSelectionEAnnotation = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			final EAnnotation treeObj = (EAnnotation)obj;
			if (treeObj != null){
				if (treeObj.getEModelElement() instanceof EPackage){					
					showHiddenElements();
					List<PictogramElement> pes = new ArrayList<PictogramElement>();
					for (EObject annot : treeObj.getReferences()){
						if (annot instanceof EAnnotation){
							pes.add(DiagramUtils.getPictogramToSelect(diagram, (EClass)((EAnnotation)annot).getEModelElement()));
							layerElements.add((EClass)((EAnnotation)annot).getEModelElement());
							for (EObject subAnnot :((EAnnotation) annot).getReferences()){
								if (subAnnot instanceof EAnnotation)
									if (((EAnnotation)subAnnot).getEModelElement() instanceof EReference){
										pes.add(DiagramUtils.getPictogramToSelect(diagram, (EReference)((EAnnotation)subAnnot).getEModelElement()));
										layerElements.add((EReference)((EAnnotation)subAnnot).getEModelElement());
									}
							}
						}
					}
					DiagramUtils.selectPictograms(pes);
					
					if (pes.size()!=0)hideElements();
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
		if (activePage.getActiveEditor() instanceof IDiagramContainerUI){	
			IEditorPart editor = activePage.getActiveEditor();				
			if (editor instanceof IDiagramContainerUI){	
				final Menu menu = new Menu(viewer.getTree());
				viewer.getTree().setMenu(menu);			
				menu.addMenuListener(new AppliedPatternsMenuAdapter(menu, viewer, ((IDiagramContainerUI)editor).getDiagramTypeProvider().getFeatureProvider()));	
				diagram = ((IDiagramContainerUI)editor).getDiagramBehavior().getDiagramTypeProvider().getDiagram();
				if (ModelUtils.existsPackage(diagram)){
					viewer.setInput(ModelUtils.getAllAppliedPatterns(diagram));
					return;
				} 
			}
		}
		viewer.setInput(null);
	}
	
	private void showHiddenElements(){
		if (!layerElements.isEmpty()){
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
	        layerElements.clear();
		}
	}
	
	private void hideElements(){
		final EPackage pack = ModelUtils.getBusinessModel(diagram);
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pack);
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