package org.mondo.editor.ui.utils.patterns;


import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableItem;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.InstanceFeatureRoleInstance;

/**
 * Menu to control the applied patterns (delete applied role)
 * 
 * @author miso  partner AnaPescador
 *
 */
public class InstanceFeatureMenuAdapter extends MenuAdapter {
	private Menu menu;
	private TableViewer viewer;
	
	public InstanceFeatureMenuAdapter(Menu menu, TableViewer viewer) {
		this.menu = menu;
		this.viewer = viewer;
	}
	
	@Override
	public void menuShown(MenuEvent e) {
		MenuItem[] items = menu.getItems();
		for (int i = 0; i < items.length; i++)
             items[i].dispose();
         
		for (final TableItem item: viewer.getTable().getSelection()){	            	
        	
        	MenuItem itemClear = new MenuItem(menu, SWT.NONE);
            itemClear.setText("Delete");
            
            itemClear.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
						TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(item.getData());
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
				        	@Override
							protected void doExecute() {
				        		ClassRoleInstance classRole = (ClassRoleInstance)((InstanceFeatureRoleInstance)item.getData()).eContainer();
								RuntimePatternsModelUtils.deleteInstanceFeatureRoleInstance((InstanceFeatureRoleInstance)item.getData());
								viewer.setInput(RuntimePatternsModelUtils.getInstanceFeatureRolesInstances(classRole));
								viewer.refresh();
							}
				        });	     
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
        }
	}  
}
