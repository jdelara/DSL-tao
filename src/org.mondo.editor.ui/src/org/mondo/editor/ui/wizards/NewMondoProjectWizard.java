package org.mondo.editor.ui.wizards;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.ui.MondoNature;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

public class NewMondoProjectWizard extends Wizard implements INewWizard {
	private NewMondoProjectWizardPage page;
	
	public NewMondoProjectWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		final String project = page.getProjectName();
		
		IRunnableWithProgress op = new IRunnableWithProgress()  {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					try {
						doFinish(project, monitor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (AWTException e) {
						e.printStackTrace();
					}
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
	
	private void doFinish(String projectName, IProgressMonitor monitor)
			throws CoreException, InterruptedException, IOException, AWTException {
			
			monitor.beginTask("Creating " + projectName, 2);		
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();		
			IProject project  = root.getProject(projectName);
			
			project.create(monitor);
			project.open(monitor);
			
			IProjectDescription description = project.getDescription();
			
			ArrayList<String> newIds = new ArrayList<String>();
			newIds.add(MondoNature.ID);
			
			description.setNatureIds((String[]) newIds.toArray(new String[newIds.size()]));
			project.setDescription(description, monitor);
			
			PatternUtils.copyPatternsFolder(project);
			// refresh project so new files are present in workspace
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
			
			PatternUtils.registerEpackages(project);


			getShell().getDisplay().asyncExec(new Runnable() {			
				public void run() {
					@SuppressWarnings("unused")
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				}			
			});			
			
			monitor.worked(1);
			monitor.done();
		}	

	@Override
	public void addPages() {
		page = new NewMondoProjectWizardPage();
		addPage(page);
	}
}
