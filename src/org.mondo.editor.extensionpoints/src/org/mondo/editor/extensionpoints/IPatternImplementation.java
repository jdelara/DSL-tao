package org.mondo.editor.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

import runtimePatterns.PatternInstance;

import dslPatterns.MMInterface;

/**
 * Interface that defines methods to apply a pattern.
 * 
 * @author miso partner AnaPescador
 *
 */
public interface IPatternImplementation {
	
	/**
	 * Method that execute the code associated to the pattern
	 * @param ePack - initial meta-model package
	 * @param pattern - pattern instance
	 * @param iPath - diagram IPath
	 * @return boolean that specifies the execution success 
	 */
	boolean execute(EPackage ePack, PatternInstance pattern, IPath iPath);
	
	/**
	 * Method that validates the meta-model depending on the pattern 
	 * @param ePack - initial meta-model package
	 * @param pattern - pattern instance
	 * @return a validation info object that contains the validation results.
	 */
	ValidationInfo validate(EPackage ePack, PatternInstance pattern);
	
	/**
	 * Method that returns a list with the optimal elements to assign the mminterface
	 * @param ePack - initial meta-model package
	 * @param mminterface - mminterface target.
	 * @return a list of eNamedElements they are the optimal elements to assign mminterface.
	 */
	List<ENamedElement> getOptimalElements(EPackage ePack, MMInterface mminterface);
}