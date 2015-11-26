package org.mondo.editor.extensionpoints;


import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.EPackage;

import runtimePatterns.PatternInstances;

import dslPatterns.Pattern;

/**
 * Class that implements the interface: ISafeRunnable, and allows to apply a pattern.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ApplyPatternRunnable implements ISafeRunnable {

	private EPackage pathMetamodel =null;
	private Pattern pattern = null;
	private IPatternImplementation pi = null;
	private PatternInstances patternInstances = null;
	private boolean successful;
	private IPath iPath= null;
	
	public boolean isSuccessful() {
		return successful;
	}

	public ApplyPatternRunnable(IPatternImplementation o, Pattern pattern, EPackage pathMetamodel,  PatternInstances pis, IPath iPath) {
		this.pi = o;
		this.pattern = pattern;
		this.pathMetamodel = pathMetamodel;
		this.patternInstances = pis;
		this.iPath = iPath;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	@Override
	public void run() throws Exception {
		successful =((IPatternImplementation) pi).applyPattern(pathMetamodel, pattern, patternInstances, iPath);
	}
}
