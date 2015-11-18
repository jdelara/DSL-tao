package org.mondo.editor.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.graphiti.diagram.CollapseAllFeature;
import org.mondo.editor.graphiti.diagram.CollapseInheritanceFeature;
import org.mondo.editor.graphiti.diagram.DrillDownEPackageFeature;
import org.mondo.editor.graphiti.diagram.EcoreFeatureProvider;
import org.mondo.editor.graphiti.diagram.ExecuteAllPatternsFeature;
import org.mondo.editor.graphiti.diagram.ExecutePatternFeature;
import org.mondo.editor.graphiti.diagram.ExpandAllFeature;
import org.mondo.editor.graphiti.diagram.ExpandInheritanceFeature;
import org.mondo.editor.graphiti.diagram.ExportMetamodelFeature;
import org.mondo.editor.graphiti.diagram.ExportMetamodelPatternsFeature;
import org.mondo.editor.graphiti.diagram.HidePatternInfoFeature;
import org.mondo.editor.graphiti.diagram.ImportMetamodelFeature;
import org.mondo.editor.graphiti.diagram.LayoutDiagramFeature;
import org.mondo.editor.graphiti.diagram.ProcessMetaModelFeature;
import org.mondo.editor.graphiti.diagram.ShowPatternInfoFeature;
import org.mondo.editor.graphiti.diagram.ValidateAllFeature;
import org.mondo.editor.graphiti.diagram.ValidatePatternFeature;

import dslPatterns.Pattern;

public class DSLtaoMenuOption extends ContributionItem {

	@Override
	public boolean isEnabled() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();

		 if (editor instanceof IDiagramContainerUI){
			IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
			IFeatureProvider fp =   diagramEditor.getDiagramTypeProvider().getFeatureProvider();
			
			if(fp instanceof EcoreFeatureProvider){
				return diagramEditor.getSelectedPictogramElements() != null;
			}
		 }
		 return false;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	public boolean isVisible() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();

		 if (editor instanceof IDiagramContainerUI){
			IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor;
			IFeatureProvider fp = diagramEditor.getDiagramTypeProvider().getFeatureProvider();
			
			if(fp instanceof EcoreFeatureProvider)
				return diagramEditor.getSelectedPictogramElements().length !=0;
		 }
		 return false;
	}

	@Override
	public void fill(Menu menu, int index) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();

		 if (editor instanceof IDiagramContainerUI){
			IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
			IFeatureProvider fp =   diagramEditor.getDiagramTypeProvider().getFeatureProvider();
			
			if (fp instanceof EcoreFeatureProvider){
			
				PictogramElement pes[] = new PictogramElement[]{fp.getDiagramTypeProvider().getDiagram()};
				ICustomContext context = new CustomContext(pes);
				
				ICustomFeature[] basicCf =  new ICustomFeature[] { new ValidateAllFeature(fp), new ImportMetamodelFeature(fp), new ExportMetamodelFeature(fp), new ExportMetamodelPatternsFeature(fp),
			    	new ProcessMetaModelFeature(fp),
			    	new CollapseAllFeature(fp), new ExpandAllFeature(fp), 
		    		new CollapseInheritanceFeature(fp), new ExpandInheritanceFeature(fp),
		    		new ShowPatternInfoFeature(fp),new HidePatternInfoFeature(fp),
		    		new DrillDownEPackageFeature(fp),
		    		new LayoutDiagramFeature(fp),
		    		new ExecuteAllPatternsFeature(fp)};
				
				EObject ecoreObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pes[0]);
				createMenuOptions(menu, new ArrayList<ICustomFeature>(Arrays.asList(basicCf)), context, ecoreObject);
				
				HashMap<Pattern, List<ICustomFeature>> patterns = new HashMap<Pattern, List<ICustomFeature>>();
				if (ModelUtils.existsPackage(fp.getDiagramTypeProvider().getDiagram())){
					for (String pattern : ModelUtils.getAppliedPatternNames(fp.getDiagramTypeProvider().getDiagram())){			
						ValidatePatternFeature validate = new ValidatePatternFeature(fp, pattern, true);
						ExecutePatternFeature execute = new ExecutePatternFeature(fp, pattern, true);
						List<ICustomFeature> features = patterns.get(validate.getPattern());
						if (features!=null) {
							features.add(validate);
							features.add(execute);
						}else {
							List<ICustomFeature> featuresNew = new ArrayList<ICustomFeature>();
							featuresNew.add(validate);
							featuresNew.add(execute);
							patterns.put(validate.getPattern(),featuresNew);
						}
					}
				}
								
				for (Pattern pattern: patterns.keySet()){
					MenuItem item2 = new MenuItem (menu, SWT.CASCADE);
					item2.setText (pattern.getName());
					Menu subMenu = new Menu (menu);
					item2.setMenu (subMenu);
					createMenuOptions(subMenu, patterns.get(pattern), context, ecoreObject);
				}
			}
		 }
	}
	
	
	private void createMenuOptions (Menu menu,List<ICustomFeature> features,final IContext context ,final EObject ecoreObject){
		for (final ICustomFeature cf : features){
			MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
			menuItem.setText(cf.getName());
			menuItem.setEnabled(cf.canExecute(context));
			
			menuItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ecoreObject);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {     		
				           cf.execute(context);
						}
					});
				}
			});
		}
	}
	
	public DSLtaoMenuOption() {
	}

	public DSLtaoMenuOption(String id) {
		super(id);
	}

}
