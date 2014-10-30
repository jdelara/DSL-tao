package org.mondo.editor.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

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
	 * @param ePack init metamodel epackage
	 * @param iPath diagrama IPath
	 * @return boolean that specifies the execution success 
	 */
	boolean execute(EPackage ePack, IPath iPath);
	
	/**
	 * Method that validates the metamodel depending on the pattern 
	 * @param ePack init metamodel package
	 * @return a validationinfo object that contains the validation results.
	 */
	ValidationInfo validate(EPackage ePack);
	
	/**
	 * Method that returns a list with the optimal elements to assign the mminterface
	 * @param ePack : init metamodel package
	 * @param mminterface : mminterface target.
	 * @return a list of eNamedElements they are the optimal elements to assign mminterface.
	 */
	List<ENamedElement> getOptimalElements(EPackage ePack, MMInterface mminterface);


}