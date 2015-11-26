package org.mondo.editor.graphiti.diagram.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

import runtimePatterns.PatternInstance;
import runtimePatterns.PatternInstances;

/**
 * Class of utility functions to work with emf ecore.
 * 
 * @author miso partner AnaPescador
 *
 */
public  class ModelUtils {
	
	/**
	 * Static method that returns the main ePackage of the diagram.If it doesn't exist, the EPackage is created.
	 * @param diagram 
	 * @return EPackage.
	 */
	public static EPackage getBusinessModel (Diagram diagram) {
        EPackage pack = null;
        if (diagram!=null) {
        	pack = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
            // if EPackage does not exist, create new one
            if (pack == null) {
                pack = EcoreFactory.eINSTANCE.createEPackage();
        		pack.setName(diagram.getName().replace(" ",""));
	            pack.setNsPrefix(diagram.getName().replace(" ","").toLowerCase());
	            pack.setNsURI("http://mondo.org/"+diagram.getName().replace(" ",""));
	            diagram.eResource().getContents().add(pack);
	            
	            DiagramUtils.initPatternInfo(diagram);
	            DiagramUtils.initCollapseInheritance(diagram);
            }
        }
        return pack;
    }
	
	/**
	 * Static method that returns if the main ePackage has been created.
	 * @param diagram 
	 * @return boolean - true created, false not created.
	 */
	public static boolean existsPackage(Diagram diagram) {
		EPackage pack = null;
        if (diagram!=null) {
        	pack = (EPackage)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
        }
        return pack!=null;	
	}
	
	/**
	 * Static method that returns if the specified ePackage is valid or not. (ID, NsPrefix, URI)
	 * @param pack - ePackage
	 * @return String - message
	 */
	public static String isPackageValid(EPackage pack){
		String error="";
		if ((pack.getName())==null) error += "Empty package name\n";
		else if (pack.getName().isEmpty()) error += "Empty package name\n";
		else if (!isIDValid(pack.getName())) error += "Not valid package name\n";
		
		if (pack.getNsPrefix() != null) 
		if ((!pack.getNsPrefix().isEmpty()) && (!isIDValid(pack.getNsPrefix()))) error += "Not valid ns prefix\n";
		
		if (pack.getNsURI()== null)  error += "Empty Ns Uri\n";
		else if (pack.getNsURI().isEmpty()) error += "Empty Ns Uri\n";
		else if (!isURIValid(pack.getNsURI())) error += "Not valid URI\n";
		
		return error;
	}
	
	/**
	 * Static method that returns if the specified URI is valid
	 * @param uri
	 * @return boolean -  true valid, false not valid
	 */
	public static boolean isURIValid(String uri){
		try{
			URI.createURI(uri);
		}catch (IllegalArgumentException ex){
			return false;
		}
		return true;	
	}
	
	/**
	 * Static method that stores a meta-model  on a resource.
	 * @param path  of the resource
	 * @param rootElement meta-model
	 * @throws IOException
	 */
	public static void saveModel(String path, EObject rootElement) throws IOException	{
		/*Copier copier = new Copier();
		EObject result = copier.copy(rootElement);
		copier.copyReferences();*/
		
		ResourceSet metaResourceSet = new ResourceSetImpl();
		Resource metaResource = metaResourceSet.createResource(URI.createURI(path));	
		metaResource.getContents().add(rootElement);
		IResourceUtils.saveResource(metaResource);
	} 
	
	/**
	 * Static method that returns the pattern model stored on the diagram
	 * @param diagram
	 * @return the object if exists, null if it doesn't exist.
	 */
	public static EObject getPatternsModel (Diagram diagram){
		ResourceSet rs =diagram.eResource().getResourceSet();
		List<Resource> res = rs.getResources();
		if (res.size()>=1){
			for (EObject obj:res.get(0).getContents() ){
				if (obj instanceof PatternInstances){
					return obj;
				}
			}
		}
		return null;
	}
	
	public static PatternInstance getPatternInstance (Diagram diagram, String name){
		Object patternsI = getPatternsModel(diagram);
		if (patternsI instanceof PatternInstances)
			for (PatternInstance pi : ((PatternInstances) patternsI).getAppliedPatterns()){
				if (pi.getIdent().compareTo(name) ==0 ) return pi;
			}
		return null;
	}
	
	/**
	 * Static method that returns the ePackage contained on the specified path. 
	 * @param path
	 * @return EPackage, null if it's not possible.
	 * @throws IOException
	 */
	public static EPackage openModel(String path) throws IOException	{
		ResourceSet metaResourceSet = new ResourceSetImpl();
		Resource metaResource = metaResourceSet.getResource(URI.createURI(path), true);	
		for (EObject obj: metaResource.getContents()){
			if (obj instanceof EPackage) return (EPackage)obj;
		}
		return null;
	} 
	
	
	/**
	 * Static method that returns if the specified eClass exists on the diagram argument.
	 * @param diagram
	 * @param name
	 * @return boolean - true exists, false not exists
	 */
	public static boolean existsClassName(Diagram diagram, String name){
		EPackage pack = getBusinessModel(diagram);
		for (EClassifier classif : pack.getEClassifiers()){
			if (classif instanceof EClass)
				if (((EClass)classif).getName().compareTo(name)==0)
            		return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the specified eClass exists on the package argument.
	 * @param epackage
	 * @param name
	 * @return boolean - true exists, false not exists
	 */
	public static boolean existsClassName(EPackage pack, String name){
		for (EClassifier classif : pack.getEClassifiers()){
			if (classif instanceof EClass)
				if (((EClass)classif).getName().compareTo(name)==0)
            		return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns a valid eClass name.
	 * @param epackage
	 * @param name rootName
	 * @return String - name.
	 */
	public static String getClassNameValid(EPackage pack, String name){
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsClassName(pack, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	
	/**
	 * Static method that returns if the specified eClass is valid.
	 * @param eClass
	 * @return String - message.
	 */
	public static String isEClassValid(EClass eClass){
		String errors = "";
		boolean id = false;
		
		EList<EAttribute> atts = eClass.getEAllAttributes();
		for (int i=0; i<atts.size(); i++){
			EAttribute att = atts.get(i);
			if (att.isID()) 
				if (id) 
					errors+= att.getName()+" ID duplicated\n";
				else id = true;
			for (int j=i+1; j<atts.size();j++){
				EAttribute att2 = atts.get(j);
				if ((att!=att2)&&(att.getName().compareTo(att2.getName())==0))
					errors += att.getName()+" is duplicated\n";
			}
		}
		
		EList<EReference> refs = eClass.getEAllReferences();
		for (int i=0; i<refs.size(); i++){
			EReference ref = refs.get(i);
			for (int j=i+1; j<refs.size();j++){
				EReference ref2 = refs.get(j);
				if ((ref!=ref2)&&(ref.getName().compareTo(ref2.getName())==0))
					errors += ref.getName()+" is duplicated\n";
			}
		}	
		return errors;
	}
	
	/**
	 * Static method that returns a valid eClass name.
	 * @param diagram
	 * @return String - name.
	 */
	public static String getClassNameValid(Diagram diagram){
		String name = "EClass";
		return getClassNameValid(diagram, name);
	}
	
	/**
	 * Static method that returns a valid eClass name.
	 * @param diagram
	 * @param name rootName
	 * @return String - name.
	 */
	public static String getClassNameValid(Diagram diagram, String name){
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsClassName(diagram, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns if the specified eEnum name exists on the diagram argument.
	 * @param diagram
	 * @param name
	 * @return boolean- true exists, false not exists
	 */
	public static boolean existsEnumName(Diagram diagram, String name){ 
		EPackage pack = getBusinessModel(diagram);
		for (EClassifier classif : pack.getEClassifiers()){
			if (classif instanceof EEnum)
				if (((EEnum)classif).getName().compareTo(name)==0)
            		return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns a valid eEnum name.
	 * @param diagram
	 * @return String - name
	 */
	public static String getEnumNameValid(Diagram diagram){
		String name = "EEnum";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsEnumName(diagram, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	
	/**
	 * Static method that returns if the specified eEnum name exists on the diagram argument.
	 * @param diagram
	 * @param name
	 * @return boolean- true exists, false not exists
	 */
	public static boolean existsEPackageName(Diagram diagram, String name){ 
		EPackage pack = getBusinessModel(diagram);
		for (EPackage subPack : pack.getESubpackages()){
			if (subPack.getName().compareTo(name)==0)
           		return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns a valid eEnum name.
	 * @param diagram
	 * @return String - name
	 */
	public static String getEPackageNameValid(Diagram diagram){
		String name = "EPackage";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsEPackageName(diagram, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns if the specified ID is valid (java)
	 * @param id
	 * @return boolean - true valid, false not valid.
	 */
	public static boolean isIDValid(String id){
		return Pattern.matches("^(?!abstract$|assert$|boolean$" +
				"|break$|byte$|case$|catch$|char$|class$|const$|continue$|default$|do$" +
				"|double$|else$|enum$|extends$|final$|finally$|float$|for$|goto$|if$|implements$" +
				"|import$|instanceof$|int$|interface$|long$|native$|new$|package$|private$" +
				"|protected$|public$|return$|short$|static$|strictfp$|super$|switch$|synchronized$" +
				"|this$|throw$|throws$|transient$|try$|void$|volatile$|while$)[a-zA-Z$_][\\w$]*", id);
	}
	
	/**
	 * Static method that returns if the specified eAttribute name exists on the  eClass argument.
	 * @param eClass
	 * @param name - eattribute name
	 * @return boolean - true exists, false not exists.
	 */
	public static boolean existsAttName(EClass eClass, String name){
		for (EAttribute att: eClass.getEAllAttributes()){
			if (att.getName().compareTo(name)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the ID exists on the specified eClass.
	 * @param eClass 
	 * @return boolean - true exists, false not exists.
	 */
	public static boolean existsIDAtt(EClass eClass){
		for (EAttribute att: eClass.getEAllAttributes()){
			if (att.isID())	return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns an valid eAttribute name.
	 * @param eClass - eAttribute container
	 * @return String - name.
	 */
	public static String getAttNameValid(EClass eClass){
		String name = "EAttribute";
		return getAttNameValid(eClass,name);
	}
	
	/**
	 * Static method that returns an valid eAttribute name.
	 * @param eClass - eAttribute container
	 * @param name - rootName
	 * @return String - name.
	 */
	public static String getAttNameValid(EClass eClass, String name){
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsAttName(eClass, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns if the specified name exists as a source annotation in the element argument.
	 * @param element
	 * @param name
	 * @return true if exists, false if not
	 */
	public static boolean existsSourceName(EModelElement element, String name){
		for (EAnnotation ann: element.getEAnnotations()){
			if (ann.getSource().compareTo(name)==0)
				return true;
		}
		return false;
	}

	/**
	 * Static method that returns a source valid name for the especified element. 
	 * @param element
	 * @param name - name beginning
	 * @return source name
	 */
	public static String getSourceNameValid(EModelElement element, String name){
		if (!existsSourceName(element, name)) return name;
		
		boolean enc = true;
		int cont = 0;
		while (enc){
			cont++;
			enc = existsSourceName(element, name+(cont==0?"":cont));	
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns if the specified eReference name exists on the eClass argument.
	 * @param eClass
	 * @param name
	 * @return boolean - true exists, false not exists.
	 */
	public static boolean existsRefName(EClass eClass, String name){
		for (EReference ref: eClass.getEAllReferences()){
			if (ref.getName().compareTo(name)==0)
				return true;
		}
		return false;
	}
	
	
	/**
	 * Static method that returns an valid eReference name.
	 * @param eClass - eclass container
	 * @return String - name beginning.
	 */
	public static String getRefNameValid(EClass eClass){
		String name = "eRef";
		return getRefNameValid(eClass, name);
	}
	
	/**
	 * Static method that returns a valid EReference name.
	 * @param eClass
	 * @param name rootName
	 * @return String - name.
	 */
	public static String getRefNameValid(EClass eClass, String name){
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsRefName(eClass, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	
	/**
	 * Static method that returns a valid eReference name.
	 * @param eClass - eclass container
	 * @return String - name beginning.
	 */
	public static String getRefOpNameValid(EClass eClass){
		String name = "eOpp";
		return getRefNameValid(eClass, name);
	}
	
	
	
	/**
	 * Static method that returns if the specified eEnumLiteral literalName exists on the eEnum argument.
	 * @param eEnum
	 * @param literalName
	 * @return boolean - true exists, false not exists
	 */
	public static boolean existsEnumLitLitName(EEnum eEnum, String literalName){
		for (EEnumLiteral lit: eEnum.getELiterals()){
			if (lit.getLiteral().compareTo(literalName)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that return if the specified eEnumLiteral name exists on the eEnum argument.
	 * @param eEnum
	 * @param name
	 * @return boolean - exists, false not exists.
	 */
	public static boolean existsEnumLitName(EEnum eEnum, String name){
		for (EEnumLiteral lit: eEnum.getELiterals()){
			if (lit.getName().compareTo(name)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns an eEnumLiteral literalName valid for the specified EEnum.
	 * @param eEnum
	 * @return String - name
	 */
	public static String getEnumLitLitNameValid(EEnum eEnum){
		String name = "eEnumLiteral";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsEnumLitLitName(eEnum, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns an eEnumLiteral name valid for the specified EEnum.
	 * @param eEnum
	 * @return String - name
	 */
	public static String getEnumLitNameValid(EEnum eEnum){
		String name = "eEnumLiteral";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsEnumLitName(eEnum, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns all the eClasses contained within the specified diagram
	 * @param diagram
	 * @return List<EClass>
	 */
	public static List<EClass> getEClasses (Diagram diagram){
		List<EClass> classifL = new ArrayList<EClass>();
        for (EClassifier classif: getBusinessModel(diagram).getEClassifiers()){
        	if (classif instanceof EClass) 
        		classifL.add((EClass)classif);
        } 
        return classifL;
	}
	
	/**
	 * Static method that returns all the eClasses contained within the specified package and its subpackages
	 * @param pack package
	 * @return List<EClass>
	 */
	public static List<EClass> getAllEClasses (EPackage pack){
		List<EClass> classifL = new ArrayList<EClass>();
        for (EClassifier classif: pack.getEClassifiers()){
        	if (classif instanceof EClass) 
        		classifL.add((EClass)classif);
        } 
        for (EPackage subPack: pack.getESubpackages()){
        	classifL.addAll(getAllEClasses(subPack));
        }
        return classifL;
	}
	
	/**
	 * Static method that returns all the eEnums contained within the specified diagram
	 * @param diagram
	 * @return List<EEnum>
	 */
	public static List<EEnum> getEEnums (Diagram diagram){
		List<EEnum> classifL = new ArrayList<EEnum>();
        for (EClassifier classif: getBusinessModel(diagram).getEClassifiers()){
        	if (classif instanceof EEnum) 
        		classifL.add((EEnum)classif);
        } 
        return classifL;
	}
	
	/**
	 * Static method that returns the eEnum whose name is specified.
	 * @param diagram
	 * @param name
	 * @return EEnum, null if it doesn't exist.
	 */
	public static EEnum getEEnum(Diagram diagram, String name){
		for (EEnum enumAux : getEEnums(diagram))
			if (enumAux.getName().compareTo(name)==0) return enumAux;
		return null;
			
	}
	
	/**
	 * Static method that returns if the key (name) exists on the eAnnotation argument.
	 * @param annot - eAnnotation
	 * @param name
	 * @return boolean - true exists, false doesn't exist.
	 */
	public static boolean existsAnnotationKey(EAnnotation annot, String name){
		for (int i = 0; i<annot.getDetails().size();i++){
			if (annot.getDetails().get(i).getKey().compareTo(name) ==0) 
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns an eAnnotation valid key for the eannotation given.
	 * @param annot - eAnnotation
	 * @return String - name
	 */
	public static String getAnnotationKeyValid(EAnnotation annot){
		String name = "key";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsAnnotationKey(annot, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}

	/**
	 * Static method that returns if the specified eAnnotation source (name) exists in the element argument.
	 * @param element - eModelElement
	 * @param name
	 * @return boolean - true exists, false doesn't exist.
	 */
	public static boolean existsAnnotationSource(EModelElement element, String name){
		for (EAnnotation annot: element.getEAnnotations()){
			if (annot.getSource().compareTo(name)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns an eAnnotation valid source for the specified element.
	 * @param element
	 * @return String source.
	 */
	public static String getAnnotationSourceValid(EModelElement element){
		String name = "annotation";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsAnnotationSource(element, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns all the eClass children.
	 * @param eclass
	 * @return List<EClass>
	 */
	public static List<EClass> getAllChildren (EClass eclass){
		List<EClass> children = new ArrayList<EClass>();
        if (eclass != null) if (eclass.getEPackage()!= null)
		for (EClassifier classif: eclass.getEPackage().getEClassifiers()){
        	if (classif instanceof EClass) {
        		EList<EClass> superTypes = ((EClass)classif).getEAllSuperTypes();
        		if (superTypes!=null)
        			if (superTypes.contains(eclass))
        				children.add((EClass)classif);
        	}	
        } 
        return children;
	}
	
	/**
	 * Static method that returns if any children of the eclass is a child of the parent class or its ancestors.
	 * @param eclass
	 * @param parent
	 * @return true if any children of the class is a child of this parent or parent ancestors, false not
	 */
	public static boolean hasAnyChildren(EClass eclass, EClass parent){
		List<EClass> children = getAllChildren(eclass);
		for (EClass child: children){
			if (child.getEAllSuperTypes().contains(parent)) return true;
			for (EClass fa: parent.getEAllSuperTypes()){
				if (child.getEAllSuperTypes().contains(fa)) return true;
			}
		}
		return false;
	}
	
	/**
	 * Static method that returns the eClass children (first level).
	 * @param pack
	 * @param eclass
	 * @return List of child
	 */
	public static List<EClass> getChildren (EPackage pack, EClass eclass){
		List<EClass> children = new ArrayList<EClass>();
        for (EClassifier classif: pack.getEClassifiers()){
        	if (classif instanceof EClass) {
        		EList<EClass> superTypes = ((EClass)classif).getESuperTypes();
        		if (superTypes!=null)
        			if (superTypes.contains(eclass))
        				children.add((EClass)classif);
        	}	
        } 
        return children;
	}
	
	/**
	 * Static method that returns the list of applied patterns, if the pattern has been applied twice only returns one.
	 * @param diagram
	 * @return list of pattern names (without the enumeration)
	 */
	public static List<String> getAppliedPatternNames (Diagram diagram){
		List<String> patterns = new ArrayList<String>();
		
		String patternsS = DiagramUtils.getPatternPictogramText(diagram, getBusinessModel(diagram));
		if (patternsS != null)
		for (String pattern: patternsS.split("\n")){
			patterns.add(pattern.replace("@", ""));
		}
		return patterns;		
	}
	
	/**
	 * Static method that returns the main diagram epackage of the specified epackage (pack) 
	 * @param diagramPack - current main diagram epackage
	 * @param pack - searched epackage
	 * @return EPackage
	 */
	public static EPackage getEPackageDiagram(EPackage diagramPack, EPackage pack){
		if (EcoreUtil.equals(pack, diagramPack)){
			return diagramPack;
		}else {
			for (EPackage p : diagramPack.getESubpackages()){
				if (getEPackageDiagram(p, pack)!=null)
					return getEPackageDiagram(p, pack);
			}
			return null;
		}
	}


	/**
	 * Static method that adds to the list "ce" all the contained elements of the class.
	 * @param eClass
	 */
	public static void addAllContainedElements (EClass eClass, List<EClass> ce){
		if (!ce.contains(eClass)){
			ce.add(eClass);
			for (EReference ref: eClass.getEAllContainments()){
				EClass nextClass = (EClass)ref.getEType();			
				addAllContainedElements(nextClass, ce);
			}
			for (EClass child : getAllChildren(eClass)){
				addAllContainedElements(child, ce);
			}
		}
	}
	
	/**
	 * Static method that returns the list of EClass reached by containment associations (included inheritance)
	 * @param eClass
	 * @return list of EClass objects
	 */
	public static List<EClass> getAllContainedElements (EClass eClass){
		List<EClass> ce = new LinkedList<EClass>(); 
		for (EReference ref: eClass.getEAllContainments())	addAllContainedElements((EClass)ref.getEType(), ce);
		return ce;
	}
	
	/**
	 * Static backtracking method that fill all the EClasses that contains the eClass, its root is known.
	 * @param root
	 * @param eClass
	 * @param containerElements
	 * @return true if the eClass has been found.
	 */
	public static boolean getAllContainerElements(EClass root, EClass eClass, List<EClass> containerElements){
		if (root.equals(eClass)){
			if (hasReflexiveReference(root)) containerElements.add(root);
			return true;
		} else {
			List<EClass> children = new LinkedList<EClass>();
			for (EReference ref: root.getEAllContainments()){
				EClass refEClass = (EClass)ref.getEType();
				if (!refEClass.equals(root) && !(root.getEAllSuperTypes().contains(refEClass)))
					children.add(refEClass);
				if (!(root.getEAllSuperTypes().contains(refEClass))) children.addAll(getAllChildren(refEClass));
			}
			for (EClass child: children){
				if (getAllContainerElements(child, eClass, containerElements)){
					containerElements.add(root);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Static method that returns if the eClass has any reflexive containment reference.
	 * @param eClass
	 * @return true if it's reflexive, false if not.
	 */
	private static boolean hasReflexiveReference(EClass eClass){
		for (EReference ref: eClass.getEAllContainments()){
			if (ref.getEType().equals(eClass))  return true;
			else if (eClass.getEAllSuperTypes() != null)
					if (eClass.getEAllSuperTypes().contains(ref.getEType())) return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns the list of EClass that contains the eClass by containment associations (included inheritance)
	 * @param eClass
	 * @return list of EClass
	 */
	public static List<EClass> getAllContainerElements (EClass eClass){
		List<EClass> ce = new LinkedList<EClass>(); 
		List<EClass> roots = getRootContaintmentElement(eClass.getEPackage(), eClass);
		for (EClass root: roots){
			getAllContainerElements (root, eClass, ce);
		}
		return ce;
	}
	
		
	/**
	 * Static method that returns the list of EClass that are root in containment associations.
	 * @param pack
	 * @return list of EClass
	 */
	public static List<EClass> getAllRootContaintmentElements(EPackage pack){
		List<EClass> candidates = new LinkedList<EClass>();
		for (EClassifier classif: pack.getEClassifiers()){
			if (classif instanceof EClass) candidates.add((EClass)classif);
		}		
		for (EClassifier classif: pack.getEClassifiers()){
			if ((classif instanceof EClass) &&  (candidates.contains(classif))){
				if (((EClass)classif).getEAllContainments().size()!=0){
					List<EClass> contained = getAllContainedElements((EClass)classif);
					//root with reflexive relation
					if (contained.contains(classif)) contained.remove(classif);
					
					candidates.removeAll(contained);
				}else candidates.remove((EClass)classif);
			}
		}
		return candidates;
	}
	
	/**
	 * Static method that returns the list of EClass that are root of an EClass.
	 * @param pack
	 * @param eclass
	 * @return list of EClass
	 */
	public static List<EClass> getRootContaintmentElement(EPackage pack, EClass eclass){
		List<EClass> candidates = new LinkedList<EClass>();
		for (EClassifier classif: pack.getEClassifiers()){
			if (classif instanceof EClass) candidates.add((EClass)classif);
		}		
		for (EClassifier classif: pack.getEClassifiers()){
			if ((classif instanceof EClass) &&  (candidates.contains(classif))){
				if (((EClass)classif).getEAllContainments().size()!=0){
					List<EClass> containedElements = getAllContainedElements((EClass)classif);
					//root with reflexive relation
					if (containedElements.contains(classif))
						containedElements.remove(classif);	
					if ((!classif.equals(eclass))&&(!containedElements.contains(eclass))) 
						//the possible root doesn't contain the class.
						candidates.remove((EClass)classif);
					candidates.removeAll(containedElements);
				}else candidates.remove((EClass)classif);
			}
		}
		return candidates;
	}
	
	/**
	 * Static method that returns all the inheritance root EClasses 
	 * @param pack
	 * @return list of EClass
	 */
	public static List<EClass> getAllRootInheritanceElements(EPackage pack){
		List<EClass> candidates = new LinkedList<EClass>();
		for (EClassifier classif: pack.getEClassifiers()){
			if (classif instanceof EClass) candidates.add((EClass)classif);
		}		
		for (EClassifier classif: pack.getEClassifiers()){
			if ((classif instanceof EClass) &&  (candidates.contains(classif))){
				if (((EClass)classif).getESuperTypes().size() == 0){
					List<EClass> children = getAllChildren((EClass)classif);
					 if (children.size()!= 0) candidates.removeAll(children);
					 else candidates.remove((EClass)classif);
				}else candidates.remove((EClass)classif);
			}
		}
		return candidates;
	}
	
	/**
	 * static method that returns an array with the metrics.
	 * pos 0 = number of EClasses
	 * pos 1 = number of EAttributes
	 * pos 2 = number of EReferences
	 * With an array is more efficient, we dont have to go EClass by EClass three times
	 * @param pack
	 * @return int[3]
	 */
	public static int[] getMetrics(EPackage pack){
		int[] metrics = new int[3];
		metrics[0] = 0;
		metrics[1] = 0;
		metrics[2] = 0;
		for (EClassifier classif: pack.getEClassifiers()){
			if (classif instanceof EClass){
				metrics[0]++;
				metrics[1] +=((EClass)classif).getEAttributes().size();
				metrics[2] +=((EClass)classif).getEReferences().size();
			}
		}		
		return metrics;
	}

}
