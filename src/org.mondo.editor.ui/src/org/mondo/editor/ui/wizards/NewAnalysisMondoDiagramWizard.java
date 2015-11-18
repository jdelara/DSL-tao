package org.mondo.editor.ui.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;

/**
 * Wizard to create new analysis DSL-tao diagrams. 
 * 
 * @author miso partner AnaPescador
 *
 */
public class NewAnalysisMondoDiagramWizard extends Wizard implements INewWizard {
	private NewMondoDiagramWizardPage page;
	private ISelection selection;

	public NewAnalysisMondoDiagramWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		page = new NewMondoDiagramWizardPage(selection);
		addPage(page);
	}

	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName()+".diagram";
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	private void doFinish(String containerName,String fileName,IProgressMonitor monitor)
		throws CoreException {
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		
		final IFile file = container.getFile(new Path(fileName));
		ResourceSet metaResourceSet = new ResourceSetImpl();
		
		final Resource metaResource = metaResourceSet.createResource(URI.createURI(file.getLocationURI().toString()));	
		TransactionalEditingDomain editingDomain = GraphitiUi.getEmfService().createResourceSetAndEditingDomain();
		final Diagram diagram = Graphiti.getPeCreateService().createDiagram("mmDSML", fileName.replace(".diagram", ""), true);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {	
				@Override
				protected void doExecute() {
					metaResource.getContents().add(diagram);
					//RuntimeLayersModelUtils.createLayerSet(metaResource);
				}
		   });
		IResourceUtils.saveResource(metaResource);
						
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {					
					IEditorPart ep = IDE.openEditor(page, file);
					page.closeEditor(ep, false);
					IDE.openEditor(page, file);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.mondo.editor.ui", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}