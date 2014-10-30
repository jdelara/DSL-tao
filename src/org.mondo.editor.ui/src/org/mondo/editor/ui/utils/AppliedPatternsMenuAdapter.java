package org.mondo.editor.ui.utils;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;
import org.mondo.editor.graphiti.diagram.DeleteEAnnotationFeature;

/**
 * Menu to control the applied patterns (delete applied role)
 * 
 * @author miso  partner AnaPescador
 *
 */
public class AppliedPatternsMenuAdapter extends MenuAdapter {
	private Menu menu;
	private TreeViewer viewer;
	private IFeatureProvider fp;
	
	public AppliedPatternsMenuAdapter(Menu menu, TreeViewer viewer, IFeatureProvider fp) {
		this.menu = menu;
		this.viewer = viewer;
		this.fp = fp;
	}
	
	@Override
	public void menuShown(MenuEvent e) {
		 MenuItem[] items = menu.getItems();
         for (int i = 0; i < items.length; i++)
             items[i].dispose();
         
        for (final TreeItem item: viewer.getTree().getSelection()){	            	
        	
        	MenuItem itemClear = new MenuItem(menu, SWT.NONE);
            itemClear.setText("Delete");
            
            itemClear.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					EAnnotation annot = (EAnnotation) item.getData();
					
					List<EAnnotation> annotations =  PatternUtils.getDeleteAnnotations(annot);
					for (final EAnnotation annotDel : annotations){
						TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(annotDel);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
				        	@Override
							protected void doExecute() {
				        		
				        		if (annotDel.getEModelElement() instanceof EPackage){
								   @SuppressWarnings("unchecked")
								   List< EAnnotation> patterns = (List<EAnnotation>)viewer.getInput();
								   patterns.remove(annotDel);
								   viewer.setInput(patterns);
								}
				        		
				        		DeleteEAnnotationFeature daf = new DeleteEAnnotationFeature(fp, annotDel);
								daf.delete(null);	
							}
				        });	     
					}	
					viewer.refresh();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
        }
	}  
}
