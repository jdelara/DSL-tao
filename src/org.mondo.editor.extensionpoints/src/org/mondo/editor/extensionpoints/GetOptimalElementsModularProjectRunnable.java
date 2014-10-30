package org.mondo.editor.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

import dslPatterns.MMInterface;

/**
 * Class that implements the interface: ISafeRunnable, and allows to get the optimal elements to apply
 * the pattern: "Hierarchical Project"
 * 
 * @author miso partner AnaPescador
 *
 */
public class GetOptimalElementsModularProjectRunnable implements ISafeRunnable {

	private List<ENamedElement> optimale = null;
	public List<ENamedElement> getOptimalElements() {
		return optimale;
	}

	private EPackage pathMetamodel =null;
	private IPatternImplementation cmp = null;
	private MMInterface mmi = null;
	
	public GetOptimalElementsModularProjectRunnable(IPatternImplementation o, EPackage pathMetamodel, MMInterface mminterface) {
		this.cmp = o;
		this.pathMetamodel = pathMetamodel;
		this.mmi = mminterface;
	}

	@Override
	public void handleException(Throwable e) {
		System.out.println("Exception in client");
	}
	@Override
	public void run() throws Exception {
		optimale = ((IPatternImplementation) cmp).getOptimalElements(pathMetamodel, mmi);
	}
}
