package org.mondo.editor.extensionpoints;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.EPackage;

import runtimePatterns.PatternInstance;

/**
 * Class that implements the interface: ISafeRunnable, and allows to run the implementation 
 * according to the applied pattern.
 * The validation is included.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExecutePatternRunnable implements ISafeRunnable {

	private ExecuteInfo ci = null;
	public ExecuteInfo getCreationInfo() {
		return ci;
	}

	private EPackage ePack =null;
	private PatternInstance pattern = null;
	private IPatternImplementation cmp = null;
	private IPath iPath= null;
	
	public ExecutePatternRunnable(IPatternImplementation o, EPackage ePack, PatternInstance pattern, IPath iPath) {
		this.cmp = o;
		this.ePack = ePack;
		this.pattern = pattern;
		this.iPath = iPath;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	@Override
	public void run() throws Exception {
		ValidationInfo vi = ((IPatternImplementation) cmp).validate(ePack, pattern);
		ci = new ExecuteInfo();
		ci.setValidationInfo(vi);
		if (vi == null){
			 ci.setSuccess(((IPatternImplementation) cmp).execute(ePack, pattern, iPath));
		} else if (vi.noErrors()) 
			ci.setSuccess(((IPatternImplementation) cmp).execute(ePack, pattern, iPath));
	}
}
