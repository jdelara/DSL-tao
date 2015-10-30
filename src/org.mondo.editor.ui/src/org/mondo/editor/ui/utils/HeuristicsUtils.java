package org.mondo.editor.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.mondo.editor.graphiti.diagram.utils.DataTypeUtils.DataType;
import org.mondo.editor.ui.utils.patterns.MMInterfaceRelDiagram;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.ClassInterface;
import dslPatterns.FeatureType;
import dslPatterns.ReferenceInterface;

/**
 * Class of utility functions to obtain the optimal elements for applying a pattern.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class HeuristicsUtils {
	
	/**
	 * Static method to obtain the optimal elements to apply a pattern
	 * @param mmird MMInterfaceRelDiagram selected
	 * @param ecore diagram metamodel
	 * @param status current relationship between pattern interfaces and metamodel elements.
	 * @return a list with the optimal elements to apply the pattern.
	 */
	public static List<ENamedElement> getOptimalElements(MMInterfaceRelDiagram mmird, EPackage ecore, List<MMInterfaceRelDiagram> status){

		if (mmird.getMmInterface() instanceof ClassInterface){
			return getOptimalEClasses(mmird,ecore, status);
		} else if (mmird.getMmInterface() instanceof FeatureType){	
			return getOptimalFeatures(mmird, ecore, status);
	    } else if (mmird.getMmInterface() instanceof ReferenceInterface){
			return getOptimalReferences(mmird, ecore, status);
	    }
        return null;
	}
	
	/**
	 * Static method to obtain the optimal eclasses to apply a pattern
	 * @param mmird MMInterfaceRelDiagram target
	 * @param ecore diagram metamodel
	 * @param currently status relationship between pattern interfaces and metamodel elements.
	 * @return  a list with the optimal classes to apply the pattern.
	 */
	private static List<ENamedElement> getOptimalEClasses(MMInterfaceRelDiagram mmird, EPackage ecore, List<MMInterfaceRelDiagram> status){
		List<MMInterfaceRelDiagram> children = PatternUtils.getChildren(status, mmird);
		
		int contAtt = 0;
		int contRef = 0;
		int contRefCont = 0; //containment
		int contRefRefl = 0; //reflexive
		int contRefContRefl = 0; //reflexive and containment
		
		//Same name of attributes, reflexive and containment references, containment references, reflexive 
		//references and check the inheritance.
		for (MMInterfaceRelDiagram child: children){
			if (child.getMmInterface() instanceof ReferenceInterface){
				if (PatternUtils.isContainmentReference((ReferenceInterface)child.getMmInterface()))
					if (PatternUtils.isReflexiveReference(status,child))
						contRefContRefl++;
					else contRefCont++;
				else if (PatternUtils.isReflexiveReference(status,child))
						contRefRefl++;
				else contRef++;
			} else if (child.getMmInterface() instanceof FeatureType)
				contAtt++;
		}
		
		List<ENamedElement> bestClasses = new ArrayList<ENamedElement>();
		for (EClassifier eclassif : ecore.getEClassifiers() ){
			if (eclassif instanceof EClass)	
				if (((EClass) eclassif).getEAttributes().size()>= contAtt){
					int contRefClass = 0;
					int contRefContClass = 0;
					int contRefReflClass = 0;
					int contRefContReflClass = 0;
					for (EReference ref: ((EClass) eclassif).getEReferences())
						if (ref.isContainment())
							if (ref.getEContainingClass()== ref.getEType())
								contRefContReflClass++;
							else contRefContClass++;
						else if (ref.getEContainingClass() == ref.getEType())
								contRefReflClass++;
						else contRefClass++;
					if ((contRefClass >= contRef) && (contRefContClass>= contRefCont) && (contRefReflClass >= contRefRefl) && (contRefContReflClass >= contRefContRefl)){
						if (PatternUtils.areCompatibleClasses(status, mmird, (EClass)eclassif))bestClasses.add(eclassif);
					}
				}
		}
		return bestClasses;
	}
	
	/**
	 * Static method to obtain the optimal eAttributes to apply a pattern
	 * @param featureInterface pattern feature interface target
	 * @param ecore diagram meta-model
	 * @param status currently status relationship between pattern interfaces and metamodel elements.
	 * @return List of optimal attributes
	 */
	private static List<ENamedElement> getOptimalFeatures(MMInterfaceRelDiagram mmird, EPackage ecore, List<MMInterfaceRelDiagram> status){
		//MMInterfaceRelDiagram parent = PatternUtils.getParent(status, mmird);
		MMInterfaceRelDiagram parent = mmird.getParent();
		EObject parentClass = ModelsUtils.getEObject(ecore, parent.getElementDiagram());
		List<ENamedElement> bestAttrib = new ArrayList<ENamedElement>();

		//attributes that belongs to the class and have the same EType.
		if (parentClass instanceof EClass){
    		for (EAttribute attrib : ((EClass) parentClass).getEAllAttributes()){
    			if ((PatternUtils.getEType((FeatureType)mmird.getMmInterface())== DataType.EJAVAOBJECT.getEDataType()) || (PatternUtils.getEType((FeatureType)mmird.getMmInterface())== attrib.getEAttributeType()))
					if (PatternUtils.areCompatibleFeatureTypes((FeatureType)mmird.getMmInterface(), attrib))bestAttrib.add(attrib);
    		}
		}
		return bestAttrib;
	}
	
	/**
	 * Static method to obtain the optimal ereferences to apply a pattern
	 * @param MMInterfaceRelDiagram mminterdaceRelDiagram target
	 * @param ecore diagram meta-model
	 * @param status currently status relationship between pattern interfaces and metamodel elements.
	 * @return list of optimal references.
	 */
	private static List<ENamedElement> getOptimalReferences(MMInterfaceRelDiagram mmird, EPackage ecore, List<MMInterfaceRelDiagram> status){
    	//MMInterfaceRelDiagram parent = PatternUtils.getParent(status, mmird);
		MMInterfaceRelDiagram parent = mmird.getParent();
		EObject parentClass = ModelsUtils.getEObject(ecore, parent.getElementDiagram());
		List<ENamedElement> bestReferences = new ArrayList<ENamedElement>();

		//References that belongs to the class and have the same cardinality and type (containment)
		//And point to the correct class.Check the eopposite references.
		if (parentClass instanceof EClass){
    		for (EReference ref: ((EClass) parentClass).getEAllReferences()){
    			if (PatternUtils.areCompatibleReferences((ReferenceInterface)mmird.getMmInterface(), ref)){
	    			if (PatternUtils.isETypeTarget(mmird, (EClass)ref.getEType(), status, ecore, mmird.getOrderPointer())){
	    				if (PatternUtils.areCompatibleEOppositeReferences(status, mmird, ref))
	    					bestReferences.add(ref);
	    			}
    			}
    		}
		}
		return bestReferences;
	}
}