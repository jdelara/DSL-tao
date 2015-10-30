package org.mondo.editor.extensionpoints;

import org.eclipse.emf.ecore.EPackage;

/**
 * Interface that defines methods to process a meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public interface IProcessMetaModelImplementation {
	
	/**
	 * Method that process a meta-model
	 * @param ePack - initial meta-model package
	 * @return boolean that specifies the execution success 
	 */
	boolean execute(EPackage ePack);
	
	/**
	 * Method that validates the meta-model to be processed
	 * @param ePack - initial meta-model package
	 * @return a validation info object that contains the validation results.
	 */
	ValidationInfo validate(EPackage ePack);
	
}