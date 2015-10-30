package org.mondo.editor.ui.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;


/**
 * Class of utility functions to work with models.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class ModelsUtils {
	
	/**
	 * Static method that returns the object contained on the specified package (pack) and whose name is the specified parameter name.
	 * @param pack - epackage
	 * @param name - object name
	 * @return EObject, null if it's not possible
	 */
	public static EObject getEObject(EPackage pack, String name){
		
		String[] nameA = name.split("/");
		if (nameA.length == 1){
			return getEClass(pack, name);
		} else if (nameA.length == 2){
			EClass eClass = getEClass(pack, nameA[0]);
			EAttribute eAtt = getEAttribute(eClass, nameA[1]);
			if (eAtt!= null) 
				return eAtt;
			else {
				EReference eRef = getEReference(eClass, nameA[1]);
				if (eRef!= null) return eRef;
			}
		}
		return null;
		
	}	
	
	/**
	 * Static method to obtain an eclass by name
	 * @param pack
	 * @param name
	 * @return EClass
	 */
	private static EClass getEClass(EPackage pack, String name){
		return (EClass) pack.getEClassifier(name);
	}
	
	/**
	 * Static method to obtain an eattribute by name 
	 * @param eClass
	 * @param name
	 * @return EAttribute
	 */
	private static EAttribute getEAttribute(EClass eClass, String name){
		for (EAttribute att: eClass.getEAllAttributes()){
			if (att.getName().compareTo(name)==0) return att;
		}
		return null;	
	}
	
	/**
	 * Static method to obtain an ereference by name
	 * @param eClass
	 * @param name
	 * @return EReference
	 */
	private static EReference getEReference(EClass eClass, String name){
		for (EReference ref: eClass.getEAllReferences()){
			if (ref.getName().compareTo(name)==0) return ref;
		}
		return null;	
	}
	
	
}
