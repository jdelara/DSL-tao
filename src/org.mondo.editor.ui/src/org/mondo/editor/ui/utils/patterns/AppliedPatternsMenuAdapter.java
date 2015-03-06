package org.mondo.editor.ui.utils.patterns;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.ui.utils.services.PatternServiceInfo;
import org.mondo.editor.ui.utils.services.RuntimeServicesModelUtils;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.TypeFeatureRoleInstance;

/**
 * Menu to control the applied patterns (delete applied role)
 * 
 * @author miso  partner AnaPescador
 *
 */
public class AppliedPatternsMenuAdapter extends MenuAdapter {
	private Menu menu;
	private TreeViewer viewer;
	
	public AppliedPatternsMenuAdapter(Menu menu, TreeViewer viewer) {
		this.menu = menu;
		this.viewer = viewer;
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
						TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(item.getData());
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
				        	@Override
							protected void doExecute() {
				        		
				        		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
								IDiagramContainerUI editor = (IDiagramContainerUI)activePage.getActiveEditor();
								
				        		if (item.getData() instanceof PatternInstance){
				        			PatternInstance pi = (PatternInstance)item.getData();
									
				        			RuntimePatternsModelUtils.deletePaintedPatternInformation(editor.getDiagramBehavior(), pi);
									RuntimePatternsModelUtils.deletePatternInstance(editor.getDiagramBehavior(), pi);
									
				        			@SuppressWarnings("unchecked")
									List<PatternInstance> patterns = (List<PatternInstance>)viewer.getInput();
									patterns.remove(item.getData());
									viewer.setInput(patterns);
									IDiagramTypeProvider dtp = editor.getDiagramBehavior().getDiagramTypeProvider();
									if (dtp instanceof EcoreDiagramTypeProvider){
										List<PatternServiceInfo> patternServiceInfoList = RuntimeServicesModelUtils.getPatternServicesInfo(editor.getDiagramBehavior());
										Object ir = ((EcoreDiagramTypeProvider)dtp).getInterfaceModel();
										if(ir!= null) {
											IProject project = IResourceUtils.getProject(dtp.getDiagram().eResource());
											
											PatternUtils.deletePatternServicesInfo(patternServiceInfoList, pi.getIdent(),(Resource)ir, PatternUtils.getAllPatterns(project));
										}
									}					
				        		}else {
					        		//Delete elements.
					        		Object parentData = item.getParentItem().getData();
									if (item.getData() instanceof ClassRoleInstance){
										ClassRoleInstance cri = (ClassRoleInstance)item.getData();
										RuntimePatternsModelUtils.deletePaintedPatternInformation(editor.getDiagramBehavior(), cri);
										RuntimePatternsModelUtils.deleteClassRoleInstance((PatternInstance)parentData, cri);
									}else if (item.getData() instanceof ReferenceRoleInstance){
										ReferenceRoleInstance rri = (ReferenceRoleInstance)item.getData();
										RuntimePatternsModelUtils.deletePaintedPatternInformation(editor.getDiagramBehavior(),(ClassRoleInstance)parentData, rri);
										RuntimePatternsModelUtils.deleteReferenceRoleInstance((ClassRoleInstance)parentData, (ReferenceRoleInstance)item.getData());
									}else if (item.getData() instanceof TypeFeatureRoleInstance){
										RuntimePatternsModelUtils.deleteTypeFeatureRoleInstance((ClassRoleInstance)parentData, (TypeFeatureRoleInstance)item.getData());
									}
				        		}
							}
				        });	     
					viewer.refresh();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
        }
	}  
}
