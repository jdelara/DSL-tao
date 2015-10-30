package org.mondo.editor.extensionpoints;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.EPackage;

/**
 * Class that implements the interface: ISafeRunnable, and allows to process a meta-model.
 * The validation is included.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ProcessMetaModelRunnable implements ISafeRunnable {

	private ExecuteInfo ci = null;
	public ExecuteInfo getCreationInfo() {
		return ci;
	}

	private EPackage ePack =null;
	private IProcessMetaModelImplementation cmp = null;
	
	public ProcessMetaModelRunnable(IProcessMetaModelImplementation o, EPackage ePack) {
		this.cmp = o;
		this.ePack = ePack;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	
	@Override
	public void run() throws Exception {
		ValidationInfo vi = ((IProcessMetaModelImplementation) cmp).validate(ePack);
		ci = new ExecuteInfo();
		ci.setValidationInfo(vi);
		if (vi == null){
			 ci.setSuccess(((IProcessMetaModelImplementation) cmp).execute(ePack));
		} else if (vi.noErrors()) 
			ci.setSuccess(((IProcessMetaModelImplementation) cmp).execute(ePack));
	}
}
