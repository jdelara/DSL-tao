package org.mondo.editor.extensionpoints;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.EPackage;

import runtimePatterns.PatternInstance;

/**
 * Class that implements the interface: "ISafeRunnable", and allows to validate the application of
 * a pattern
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidatePatternRunnable implements ISafeRunnable {

	private ValidationInfo vi = null;
	public ValidationInfo getValidationInfo() {
		return vi;
	}

	private EPackage pathMetamodel =null;
	private PatternInstance pattern = null;
	private IPatternImplementation cmp = null;
	
	public ValidatePatternRunnable(IPatternImplementation o, EPackage pathMetamodel, PatternInstance pattern) {
		this.cmp = o;
		this.pathMetamodel = pathMetamodel;
		this.pattern = pattern;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	@Override
	public void run() throws Exception {
		vi = ((IPatternImplementation) cmp).validate(pathMetamodel, pattern);
	}
}
