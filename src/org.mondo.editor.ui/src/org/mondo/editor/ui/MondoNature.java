package org.mondo.editor.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class MondoNature implements IProjectNature {

	public static final String ID = "org.mondo.editor.ui.mondoNature";
	
	@Override
	public void configure() throws CoreException {

	}

	@Override
	public void deconfigure() throws CoreException {

	}

	@Override
	public IProject getProject() {
		return null;
	}

	@Override
	public void setProject(IProject project) {

	}

}
