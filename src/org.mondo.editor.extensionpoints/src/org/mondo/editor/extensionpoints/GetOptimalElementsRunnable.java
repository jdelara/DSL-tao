package org.mondo.editor.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;


import dslPatterns.MMInterface;

/**
 * Class that implements the interface: ISafeRunnable, and allows to get the optimal elements to apply
 * a pattern
 * 
 * @author miso partner AnaPescador
 *
 */
public class GetOptimalElementsRunnable implements ISafeRunnable {

	private List<ENamedElement> optimal = null;
	public List<ENamedElement> getOptimalElements() {
		return optimal;
	}

	private EPackage pathMetamodel =null;
	private IPatternImplementation pi = null;
	private MMInterface mmi = null;
	
	public GetOptimalElementsRunnable(IPatternImplementation o, EPackage pathMetamodel,  MMInterface mminterface) {
		this.pi = o;
		this.pathMetamodel = pathMetamodel;
		this.mmi = mminterface;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	@Override
	public void run() throws Exception {
		optimal = ((IPatternImplementation) pi).getOptimalElements(pathMetamodel, mmi);
	}
}
