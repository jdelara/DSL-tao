package org.mondo.editor.ui.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.wizards.EcoreMondoDiagramWizard;

/**
 * Class to create a DSL-tao diagram from a ecore file.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateMondoDiagram implements IObjectActionDelegate {

	private ISelection selection;
	
	public CreateMondoDiagram() {
		super();
	}
	
	

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void run(IAction action) {
		
		if (selection instanceof IStructuredSelection){
			
			Object obj[] = ((IStructuredSelection) selection).toArray();
			final IFile file = IResourceUtils.convertObjectToIFile(obj[0]);
			
			String name = file.getName();
			name = name.replaceFirst("[.][^.]+$", "");	
			
			EcoreMondoDiagramWizard dw = new EcoreMondoDiagramWizard(name);
			WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), dw)
			{
				@Override
		        protected void configureShell(Shell newShell) {
				super.configureShell(newShell);
				newShell.setSize(1000, 800);
				
				}
			};
			dialog.create();
			
			dialog.getShell().setText("DSL-tao DIAGRAM");
			
			if (Window.OK == dialog.open()){

				String path = file.getLocationURI().toString();
				try{ 
				  	if (path != null) {									
						final EPackage pack= ModelUtils.openModel(path);
					    TransactionalEditingDomain editingDomain = GraphitiUi.getEmfService().createResourceSetAndEditingDomain();
  		
						ResourceSet metaResourceSet = editingDomain.getResourceSet();
					    
						String ifilePath = file.getParent().getFullPath().makeRelative().toString()+"/"+dw.getDiagramName()+".diagram"; 
						
						final Resource metaResource = new XMIResourceImpl(URI.createPlatformResourceURI(ifilePath, false));
						metaResourceSet.getResources().add(metaResource);

						final Diagram diagram = Graphiti.getPeCreateService().createDiagram("mondo", dw.getDiagramName(), true);							
						final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();	
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						
								@Override
								protected void doExecute() {
									metaResource.getContents().add(diagram);
									metaResource.getContents().add(pack);
																	
									dp.init(diagram, dp.getDiagramBehavior());
									dp.getFeatureProvider().link(diagram, pack);
									
									DiagramUtils.initPatternInfo(diagram);
							        DiagramUtils.initCollapseInheritance(diagram);
									
								}
						   });
						IResourceUtils.saveResource(metaResource);						
						file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);		
						DiagramUtils.drawDiagram(dp.getFeatureProvider(), diagram);    							
						IResourceUtils.saveResource(metaResource);
					   
					   file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
						
						try {
							IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
									
							IFile fich = file.getParent().getFile(new Path(dw.getDiagramName()+".diagram"));
							
							IEditorPart ep = IDE.openEditor(activePage, fich);
							activePage.closeEditor(ep, false);
							IDE.openEditor(activePage, fich);
							
						} catch (PartInitException e) {
								
						}
						Messages.displayGeneralMessage("Create Diagram", "Your diagram was created successfully");
					} 
				}catch (Exception ex){ 
					Messages.displayGeneralErrorMessage("Create Diagram", "Your diagram wasn't created successfully");
					ex.printStackTrace(); 
				} 
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
