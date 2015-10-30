package org.mondo.editor.graphiti.diagram.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.internal.WorkbenchMessages;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Section to work with additional information about an EClass:
 * all the attributes, ancestor, children and references.
 * 
 * @author miso partner AnaPescador
 *
 */
public class SearchSection extends GFPropertySection implements ITabbedPropertyConstants {
	
	TreeViewer viewer;
	private List<ENamedElement> selectedNamedElements = new ArrayList<ENamedElement>();
	private FilteredTree filteredTree;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);	
		
		Composite composite = new Composite(parent, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    gridLayout.marginHeight = gridLayout.marginWidth = 2;
	    gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
	    composite.setLayout(gridLayout);

	    PatternFilter filter = new PatternFilter();
		filteredTree = new FilteredTree(composite, SWT.BORDER | SWT.H_SCROLL, filter, true);
		viewer = filteredTree.getViewer();
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
		        | GridData.FILL_VERTICAL );
		viewer.getTree().setLayoutData(gd);
		
 		viewer.setContentProvider(new ITreeContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public boolean hasChildren(Object element) {
				return (element instanceof EClass);
			}
			
			@Override
			public Object getParent(Object element) {
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
			    @SuppressWarnings("unchecked")
				List<ENamedElement> list = (List<ENamedElement>) inputElement;
			    return list.toArray();
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof EClass){
					List<Object> listAttributes = new ArrayList<>(Arrays.asList(((EClass)parentElement).getEAllAttributes().toArray()));
					List<Object> listReferences = new ArrayList<>(Arrays.asList(((EClass)parentElement).getEAllReferences().toArray()));
					listAttributes.addAll(listReferences);
					return listAttributes.toArray();
				}
				return null;
			}
		});
	    
 		viewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				String s = ((ENamedElement) element).getName(); 
			    return s;
			}
			
			@Override
			public Image getImage(Object element) {
				return null;
			}
 		});
 		viewer.getTree().addMouseListener(mouseListener);
	}

	@Override
	public void refresh() {
		PictogramElement peMain = getSelectedPictogramElement();
	    if (peMain != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(peMain);
	        if (bo == null)
	            return;
	        try{	
	         List<ENamedElement> dml = new ArrayList<>();
	       	  if ((EPackage)bo != null) {    	 	
	           	//for (EClassifier classif : ((EPackage)bo).getEClassifiers()){
	       		  for (EClassifier classif: ModelUtils.getAllEClasses((EPackage)bo)){
	           		if (classif instanceof EClass){   			
	           			dml.add(classif);				
	           		}
	           	}
	       	  } 
	       	  viewer.setInput(dml); 
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
			Tree control = (Tree)e.getSource();    
	        if (!isExpandCollapse(e)){
				TreeItem[] selection = control.getSelection();
		        if (selection != null) {
		        	DiagramUtils.selectPictogram(getDiagram());
		        	selectedNamedElements.clear();
					for (TreeItem ti : selection) {
		        		  ENamedElement value = (ENamedElement)ti.getData();
		        		  selectedNamedElements.add(value);
		        	}   
		    		List<PictogramElement> pes = new ArrayList<>();			
		    		for (ENamedElement element:selectedNamedElements){
		    			PictogramElement pe = DiagramUtils.getPictogramToSelect(getDiagram(), element);
		    			if (pe != null)	pes.add(pe);
		    			else {
		    				pe = DiagramUtils.getPictogramEPackageToSelect(getDiagram(), element);
		    				if (pe != null)	pes.add(pe);
		    			}
		    		}
		    		DiagramUtils.selectPictograms(pes);	
		        }
	        }
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			
		}
	};

	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
		if (!filteredTree.isDisposed())
		filteredTree.setInitialText(WorkbenchMessages.FilteredTree_FilterMessage);
	}
	
	private boolean isExpandCollapse (MouseEvent e){
		return (e.x <= 21);
	}
} 

