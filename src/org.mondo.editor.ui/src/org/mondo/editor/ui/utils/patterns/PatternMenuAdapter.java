package org.mondo.editor.ui.utils.patterns;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.ui.utils.HeuristicsUtils;
import org.mondo.editor.ui.utils.ModelsUtils;
import org.mondo.editor.ui.utils.dragdrop.DragAndDropUtils;
import org.mondo.editor.ui.utils.dragdrop.MMInterfaceRelDiagram;

import dslPatterns.ClassInterface;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureType;
import dslPatterns.ReferenceInterface;

/**
 * Class that controls the menu for the treeviewer interfaces
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternMenuAdapter extends MenuAdapter {
	private Menu menu;
	private TreeViewer viewer;
	private final EPackage pack;
	private TreeViewer viewerEcore;
	private String patternName;

	
	public PatternMenuAdapter(Menu menu, TreeViewer viewer, EPackage pack, TreeViewer viewerEcore, String patternName) {
		this.menu = menu;
		this.viewer = viewer;
		this.pack = pack;
		this.viewerEcore = viewerEcore;
		this.patternName = patternName;
	}
	
	@Override
	public void menuShown(MenuEvent e) {
		 MenuItem[] items = menu.getItems();
         for (int i = 0; i < items.length; i++)
             items[i].dispose();
         
        for (final TreeItem item: viewer.getTree().getSelection()){	            	
        	
        	//Clear option
        	if ((!(((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof FeatureInstance))  && (!(((MMInterfaceRelDiagram)item.getData()).getElementDiagram().isEmpty()))){
            	MenuItem itemClear = new MenuItem(menu, SWT.NONE);
	            itemClear.setText("Clear" );
	            
	            itemClear.addSelectionListener(new SelectionListener() {
					
	            	private void clearMMInterfaceRelDiagram(MMInterfaceRelDiagram target, List<MMInterfaceRelDiagram> content){
	            		target.setElementDiagram("");
	            		
	            		if (target.getMmInterface() instanceof ClassInterface){
	            			for (MMInterfaceRelDiagram mmird : PatternUtils.getChildren(content, target)){
	            				if (!(mmird.getMmInterface() instanceof FeatureInstance))
	            				mmird.setElementDiagram("");
	            			}
	            			 
	            			for (MMInterfaceRelDiagram mmird : PatternUtils.getMMInterfaceRelDiagramRefsEClass(content, (ClassInterface)target.getMmInterface() , target.getOrder())){
	            				 mmird.setElementDiagram("");
	            			}
	            			
	    					EClass targetClass = PatternUtils.getEClass((ClassInterface)target.getMmInterface());
	            			if (targetClass.getEAllSuperTypes().size()==0){
		    					String[] childrenA = target.getAdditionalInformation().split(",");
		    					for (String child: childrenA){
		    						MMInterfaceRelDiagram childClass = PatternUtils.getMMInterfaceRelDiagram(content, child, /*classMMI.getOrder()*/0);
		    						if (childClass != null) if (!childClass.getElementDiagram().isEmpty())
		    							clearMMInterfaceRelDiagram(childClass, content);
		    					}
	            			}
	            			
	            		}
	            	}
	            	
					@SuppressWarnings("unchecked")
					@Override
					public void widgetSelected(SelectionEvent e) {
						clearMMInterfaceRelDiagram( (MMInterfaceRelDiagram)item.getData(),(List<MMInterfaceRelDiagram>) viewer.getInput());
						viewer.refresh();
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
          
        	}
        	//Add option
        	if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ReferenceInterface){	
					final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();

		            @SuppressWarnings("unchecked")
		            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
		            MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(input, (ReferenceInterface)mmird.getMmInterface(),mmird.getOrderPointer());
					
					MenuItem itemAdd = new MenuItem(menu, SWT.NONE);		        
            		itemAdd.setText("Add new "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
	
					boolean  ok = ((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(input,mmird)) || (mmird.getMaxValue()==-1));
					if ((mmirdRef != null)&&(!PatternUtils.isReflexiveReference((ReferenceInterface)mmird.getMmInterface()))) {
						int numMmird = PatternUtils.getNumMMInterfaceRelDiagram(input,mmirdRef);		
						ok = ok && ((mmirdRef.getMaxValue() > numMmird)|| (mmirdRef.getMaxValue()==-1));		            
					}
					
					itemAdd.setEnabled(ok);							
				
					itemAdd.addSelectionListener(new SelectionListener() {
					
						@Override
						public void widgetSelected(SelectionEvent e) {
							PatternUtils.duplicateStructureReference(input,mmird, mmird.getOrder());
						
							Object[] expandedElements =viewer.getExpandedElements();
							viewer.setInput(input);
							viewer.setExpandedElements(expandedElements);
						}
					
						@Override
						public void widgetDefaultSelected(SelectionEvent e) {							
						}
					});
		            
        	}else if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ClassInterface){
        		final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();
    			MenuItem itemAdd = new MenuItem(menu, SWT.NONE);		        
        		itemAdd.setText("Add new "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
	            
	            @SuppressWarnings("unchecked")
	            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
				boolean  ok = ((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagram(input,mmird)) || (mmird.getMaxValue()==-1));		            
				itemAdd.setEnabled(ok);		

	            itemAdd.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						int order = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(input, mmird)+1;
						PatternUtils.duplicateStructureClass(input, mmird, order);
						Object[] expandedElements =viewer.getExpandedElements();
						viewer.setInput(input);
						viewer.setExpandedElements(expandedElements);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {							
					}
				});
        	}else if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof FeatureInterface){
        		final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();
    			MenuItem itemAdd = new MenuItem(menu, SWT.NONE);		        
        		itemAdd.setText("Add new "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
	            
	            @SuppressWarnings("unchecked")
	            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
				boolean  ok = ((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(input,mmird)) || (mmird.getMaxValue()==-1));		            
				itemAdd.setEnabled(ok);		

	            itemAdd.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						PatternUtils.duplicateAttribute(input, mmird, mmird.getOrder());
						Object[] expandedElements =viewer.getExpandedElements();
						viewer.setInput(input);
						viewer.setExpandedElements(expandedElements);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {							
					}
				});
        	}
        	
        	//Delete option
        	if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ReferenceInterface){	
        		//All references same behavior
    				final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();

		            
	            	@SuppressWarnings("unchecked")
		            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
	    			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(input, (ReferenceInterface)mmird.getMmInterface(),mmird.getOrderPointer());
					
        			MenuItem itemDelete = new MenuItem(menu, SWT.NONE);
	            	itemDelete.setText("Delete "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
    			
	    			boolean ok = ((mmird.getMinValue()< PatternUtils.getNumMMInterfaceRelDiagramSameOrder(input,mmird)));
	    			if ((mmirdRef != null)&&(!PatternUtils.isReflexiveReference((ReferenceInterface)mmird.getMmInterface())))
	    				ok = ok	&& ((mmirdRef.getMinValue() < PatternUtils.getNumMMInterfaceRelDiagram(input,mmirdRef)));
					itemDelete.setEnabled(ok);	

	            	itemDelete.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent e) {
							PatternUtils.deleteStructureReference(input,mmird);
							
							Object[] expandedElements =viewer.getExpandedElements();
							viewer.setInput(input);
							viewer.setExpandedElements(expandedElements);
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent e) {							
						}
					});
	            	//All references same behaviour
        	} else if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ClassInterface){
        		final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();
    			MenuItem itemDelete = new MenuItem(menu, SWT.NONE);
            	itemDelete.setText("Delete "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
	            
            	@SuppressWarnings("unchecked")
	            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
				boolean ok = (((mmird.getMinValue()< PatternUtils.getNumMMInterfaceRelDiagram(input,mmird))) 
						&& (PatternUtils.getMMInterfaceRelDiagramRefsEClassWithoutReflexives(input, (ClassInterface)mmird.getMmInterface(), mmird.getOrder()).size()==0));

				itemDelete.setEnabled(ok);	

            	itemDelete.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						PatternUtils.deleteStructureClass(input, mmird);
						
						Object[] expandedElements =viewer.getExpandedElements();
						viewer.setInput(input);
						viewer.setExpandedElements(expandedElements);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {							
					}
				});
        	} else if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof FeatureInterface){
        		final MMInterfaceRelDiagram mmird = (MMInterfaceRelDiagram)item.getData();
    			MenuItem itemDelete = new MenuItem(menu, SWT.NONE);
            	itemDelete.setText("Delete "+mmird.getTextMMInterfaceRelDiagramOnlyName(false));
	            
            	@SuppressWarnings("unchecked")
	            final List<MMInterfaceRelDiagram> input = (List<MMInterfaceRelDiagram>) viewer.getInput();	
				boolean ok = ((mmird.getMinValue()< PatternUtils.getNumMMInterfaceRelDiagramSameOrder(input,mmird)));

				itemDelete.setEnabled(ok);	

            	itemDelete.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						PatternUtils.deleteAttribute(input, mmird);
						
						Object[] expandedElements =viewer.getExpandedElements();
						viewer.setInput(input);
						viewer.setExpandedElements(expandedElements);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {							
					}
				});
        	}
        	
        	//Assistant option
        	//Classes
        	if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ClassInterface){
	        	MenuItem itemAssistant = new MenuItem(menu, SWT.NONE);
	        	itemAssistant.setText("Assistant" );
	            
	        	itemAssistant.addSelectionListener(new SelectionListener() {
					
					@SuppressWarnings("unchecked")
					@Override
					public void widgetSelected(SelectionEvent e) {
						List<ENamedElement> elements = 
								EvaluateExtensionPoint.evaluateGetOptimalElements(Platform.getExtensionRegistry(),patternName,pack,((MMInterfaceRelDiagram)item.getData()).getMmInterface() );
						
						if (DragAndDropUtils.noDragElementsToSelect(elements)){
								elements = HeuristicsUtils.getOptimalElements((MMInterfaceRelDiagram)item.getData(), pack,(List<MMInterfaceRelDiagram>) viewer.getInput());	
						}	
						
						DragAndDropUtils.selectDragElements(viewerEcore, elements);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
        	}
        	
        	//Feature types
        	if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof FeatureType){
	        	if(!((MMInterfaceRelDiagram)item.getParentItem().getData()).getElementDiagram().isEmpty()){
	        		MenuItem itemAssistant = new MenuItem(menu, SWT.NONE);
		        	itemAssistant.setText("Assistant" );
		            
		        	itemAssistant.addSelectionListener(new SelectionListener() {
						
						@SuppressWarnings("unchecked")
						@Override
						public void widgetSelected(SelectionEvent e) {

							List<ENamedElement> elements = 
									EvaluateExtensionPoint.evaluateGetOptimalElements(Platform.getExtensionRegistry(),patternName,pack,((MMInterfaceRelDiagram)item.getData()).getMmInterface() );
							
							if (DragAndDropUtils.noDragElementsToSelect(elements)){
									elements = HeuristicsUtils.getOptimalElements((MMInterfaceRelDiagram)item.getData(), pack,(List<MMInterfaceRelDiagram>) viewer.getInput());	
							}								
							MMInterfaceRelDiagram parent = PatternUtils.getParent((List<MMInterfaceRelDiagram>) viewer.getInput(), (MMInterfaceRelDiagram)item.getData());
							EObject parentClass = ModelsUtils.getEObject(pack, parent.getElementDiagram());

							DragAndDropUtils.selectDragElements(viewerEcore,(EClass) parentClass, elements);

						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent e) {
						}
					});
	        	}
        	}
        	//References
        	if (((MMInterfaceRelDiagram)item.getData()).getMmInterface() instanceof ReferenceInterface){
        		if(!((MMInterfaceRelDiagram)item.getParentItem().getData()).getElementDiagram().isEmpty()){
        			MenuItem itemAssistant = new MenuItem(menu, SWT.NONE);
        			itemAssistant.setText("Assistant" );
      
        			itemAssistant.addSelectionListener(new SelectionListener() {
			
        				@SuppressWarnings("unchecked")
						@Override
        				public void widgetSelected(SelectionEvent e) {
        					List<ENamedElement> elements = 
    								EvaluateExtensionPoint.evaluateGetOptimalElements(Platform.getExtensionRegistry(),patternName,pack,((MMInterfaceRelDiagram)item.getData()).getMmInterface() );
    						
    						if (DragAndDropUtils.noDragElementsToSelect(elements)){
    								elements = HeuristicsUtils.getOptimalElements((MMInterfaceRelDiagram)item.getData(), pack,(List<MMInterfaceRelDiagram>) viewer.getInput());	
    						}
							MMInterfaceRelDiagram parent = PatternUtils.getParent((List<MMInterfaceRelDiagram>) viewer.getInput(), (MMInterfaceRelDiagram)item.getData());
							EObject parentClass = ModelsUtils.getEObject(pack, parent.getElementDiagram());

							DragAndDropUtils.selectDragElements(viewerEcore,(EClass) parentClass, elements);
        				}
			
        				@Override
        				public void widgetDefaultSelected(SelectionEvent e) {
        				}
        			});
        		}
        	}
        }
	} 

}
