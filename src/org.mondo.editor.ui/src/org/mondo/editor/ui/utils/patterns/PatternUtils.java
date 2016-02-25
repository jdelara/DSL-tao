package org.mondo.editor.ui.utils.patterns;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.utils.ModelsUtils;
import org.mondo.editor.ui.utils.Utils;
import org.mondo.editor.ui.utils.services.PatternServiceInfo;
import org.mondo.editor.ui.utils.services.RuntimeServicesModelUtils;
import org.osgi.framework.Bundle;

import runtimePatterns.PatternInstance;
import runtimeServices.DisconnectedElement;
import runtimeServices.ServiceInstance;
import serviceInterfaces.Interface;
import serviceInterfaces.InterfaceRepository;
import serviceInterfaces.Package;
import serviceInterfaces.Packageable;
import serviceInterfaces.impl.InterfaceImpl;

import dslPatterns.Acceptor;
import dslPatterns.Category;
import dslPatterns.ClassInterface;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureType;
import dslPatterns.Injector;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.PatternSet;
import dslPatterns.Plug;
import dslPatterns.Port;
import dslPatterns.ReferenceInterface;
import dslPatterns.Service;
import dslPatterns.Slot;
import dslPatterns.Variant;

/**
 * Class of utility functions to work with patterns.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class PatternUtils {

	static final String PATTERNS_FOLDER = "patterns";
	static final String PATTERNS_FILE_NAME = "repository.dslpatterns";
	static final String PATTERNS_INTERFACES_NAME = "interfaces.serviceInterfaces";	
	static final String PLUGIN_DSL_ID = "org.mondo.dsl";
	static final String PLUGIN_DSL_RELATIVE_DIR = PATTERNS_FOLDER+File.separator;
	public static final String PATH_IMAGE_DEFAULT = PATTERNS_FOLDER+File.separator+"icons"+File.separator+"NoImagePattern.gif";

	/**
	 * Static method that returns the PatternSet object stored on the given project
	 * @param project
	 * @return PatternSet, null if it's not possible
	 */
	public static PatternSet getPatternSetModel(IProject project) {
		String filename = getPathProjectPatterns(project);
		if (filename!=null){
			URI uri = URI.createFileURI(filename);
			ResourceSet resourceSet = new ResourceSetImpl();					
			try{
				Resource resource = resourceSet.getResource(uri, true);		
				if (resource != null){
					PatternSet patternSet = (PatternSet) resource.getContents().get(0);	
					//set relative uri
					setPatternsRelativeURI(patternSet.eResource());
					return patternSet;
				}
			}catch (RuntimeException e){
			}
		}	
		return null;
	}
	
	/**
	 * Static method that returns the interface model stored on the given project
	 * @param project
	 * @return resource.
	 */
	public static Resource getInterfaceModel(IProject project){
		String fileName = getPathIntefacePatterns(project);
		if (fileName!=null){
			URI uri = URI.createFileURI(fileName);
			ResourceSet resourceSet = new ResourceSetImpl();
			try{
				Resource resource = resourceSet.getResource(uri, true);
				//set relative uri
				setInterfacesRelativeURI(resource);
				return resource;
			}catch (Exception ex){		
			}
		} 
		return null;
	}
	
	/**
	* Static method that returns the image associated with the metamodel.
	* @param metamodel
	* @return image
	*/
	public static Image getImagePatternMetamodels(PatternMetaModel metamodel, IProject project){
		IFile file = null;
		if (metamodel != null){ 
			String img = metamodel.getImg();
			if (img != null){
				file = project.getFile(new Path(img));
			}
		} else file = project.getFile(new Path(PATH_IMAGE_DEFAULT));
		try {
			URL url = file.getLocationURI().toURL();
			ImageDescriptor desc =  ImageDescriptor.createFromURL(url);
			if (desc != null) return desc.createImage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Static method that returns the path where the patterns file is stored on the given project	
	 * @param project
	 * @return string path, null if it doesnt exist
	 */
	public static String getPathProjectPatterns(IProject project){
		IFile file = project.getFile(new Path(PATTERNS_FOLDER+File.separator+PATTERNS_FILE_NAME));
		if (file != null) return file.getLocation().toOSString();
		else return null;
	}
	
	/**
	 * Static method that returns the path where the interfaces file is stores on the given project
	 * @param project
	 * @return string path, null if it doesnt exist
	 */
	public static String getPathIntefacePatterns(IProject project){
		IFile file = project.getFile(new Path(PATTERNS_FOLDER+File.separator+PATTERNS_INTERFACES_NAME));
		if (file != null) return file.getLocation().toOSString();
		else return null;
	}
	
	/**
	 * static method that return the path where the plug-in patterns set in stored.
	 * @return string path, null if i doesnt exist
	 */
	public static String getPathFolderPluginPatternsSet(){
		Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
		IPath relativeIPath = new Path(PLUGIN_DSL_RELATIVE_DIR);	
		URL fileInPlugin = FileLocator.find(plugin, relativeIPath, null);			
		URL srcUrl;
		try {
			srcUrl = FileLocator.toFileURL(fileInPlugin);
			File src = new File(srcUrl.getPath());	
			return src.getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Static method that change the uri of the given Interfaces resource to convert it into relative.
	 * @param resource
	 */
	public static void setInterfacesRelativeURI(Resource resource){
		URI relativeURI = URI.createURI(PATTERNS_FOLDER+"/"+PATTERNS_INTERFACES_NAME, false);
		resource.setURI(relativeURI);
	}
	
	/**
	 * Static method that change the uri of the given Patterns resource to convert it into relative.
	 * @param resource
	 */
	public static void setPatternsRelativeURI(Resource resource){
		URI relativeURI = URI.createURI(PATTERNS_FOLDER+"/"+PATTERNS_FILE_NAME, false);
		resource.setURI(relativeURI);
	}
	
	/**
	 * Static method that copy the folder with all the information about the patterns into the given project.
	 * @param project
	 */
	public static void copyPatternsFolder(IProject project){
		String source =getPathFolderPluginPatternsSet();
		IFolder folder = project.getFolder(new Path(PATTERNS_FOLDER));
		String destiny = folder.getLocation().toOSString();
		try {
			Utils.copy(source, destiny);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Static method that register the epackage of the given file.
	 * @param file
	 */
	private static void registerEpackage(IFile file){	
		String pathName= file.getLocation().toOSString();
		URI uriMetamodel = URI.createFileURI(pathName);
		// register globally the Ecore Resource Factory to the ".ecore" extension
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		    "ecore", new EcoreResourceFactoryImpl());

		ResourceSet rs = new ResourceSetImpl();
		// enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
		    extendedMetaData);

		Resource r = rs.getResource(uriMetamodel, true);
		EObject eObject = r.getContents().get(0);
		if (eObject instanceof EPackage) {
		    EPackage p = (EPackage)eObject;
		    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);		    
		}
	}
	
	/**
	 * Static method that register the epackages of the project.
	 * @param project
	 */
	public static void registerEpackages(IProject project){	
		IFolder folder = project.getFolder(new Path(PATTERNS_FOLDER));
		try {
			IResource[] resources = folder.members(true);
			for (IResource resource: resources){
				if (resource instanceof IFile){
					if (((IFile)resource).getName().endsWith(".ecore")){
						registerEpackage((IFile)resource);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram object (mmird) children (references and attributes)
	 * @param list
	 * @param mmird
	 * @return a list that contains the children, if doesn't have children null.
	 */
	public static List<MMInterfaceRelDiagram> getChildren(List<MMInterfaceRelDiagram> list, MMInterfaceRelDiagram mmird){
		
		return mmird.getChildren();
	}

	/**
	 * Static method that returns the MMInterfaceRelDiagram object from the specified text and order.
	 * @param patternRelDiagram
	 * @param text
	 * @param order
	 * @return the MMInterfaceRelDiagram object, if doesn't exist returns null
	 */
	public static MMInterfaceRelDiagram getMMInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, String text, int order){
		for (MMInterfaceRelDiagram mmird: patternRelDiagram){
			  if ((mmird.getTextMMInterfaceRelDiagram().compareTo(text)==0)&& (mmird.getOrder()==order)){
				  return mmird;
			  }
		}
		return null;
	}
	
	/**
	 * Static method that returns all the MMInterfaceRelDiagram objects from the specified text.
	 * @param patternRelDiagram
	 * @param text
	 * @return the list of MMInterfaceRelDiagram objects, if there isn't any one an empty list.
	 */
	public static List<MMInterfaceRelDiagram> getAllMMInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, EClass text, int orderPointer){
		List<MMInterfaceRelDiagram> allmmird = new LinkedList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird: patternRelDiagram){
			  if (((mmird.getTextMMInterfaceRelDiagram().compareTo(text.getName())==0)) 
			  && (mmird.getOrderPointer()== orderPointer)){
				  allmmird.add(mmird);
			  }
		}
		//Si no existe devolvemos sus hijos.
		if (allmmird.isEmpty()) {
			for (EClass child : ModelUtils.getChildren(text.getEPackage(), text)){
				allmmird.addAll(getAllMMInterfaceRelDiagram (patternRelDiagram, child,orderPointer));
			}
		}
		return allmmird;
	}
		
	/**
	 * Static method that returns the first MMInterfaceRelDiagram object from the specified text. (ORDER IS IMPORTANT)
	 * @param patternRelDiagram
	 * @param text
	 * @param order
	 * @return the MMInterfaceRelDiagram object, if doesn't exist returns null
	 */
	public static MMInterfaceRelDiagram getFirstMMInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, String text, int order){
		for (MMInterfaceRelDiagram mmird: patternRelDiagram){
			  if (((mmird.getTextMMInterfaceRelDiagram().compareTo(text)==0)) && (mmird.getOrder()==order)){
				  return mmird;
			  }
		}
		return null;
	}
		
	/**
	 * Static method that returns the MMInterfaceRelDiagram that is related to the specified diagram element.
	 * @param patternRelDiagram
	 * @param diagramElement
	 * @return the MMInterfaceRelDiagram object, if doesn't exist returns null
	 */
	public static MMInterfaceRelDiagram getMMInterfaceRelDiagramFromDiagramElement (List<MMInterfaceRelDiagram> patternRelDiagram, String diagramElement){
		for (MMInterfaceRelDiagram mmird: patternRelDiagram){
			  if (mmird.getElementDiagram().compareTo(diagramElement)==0){
				  return mmird;
			  }
		}
		return null;
	}
		
	/**
	 * Static method that returns the number of the MMInterfaceRelDiagram objects with the same MMInterface as mmird. 
	 * @param patternRelDiagram
	 * @param mmird
	 * @return an integer that contains the order.
	 */
	public static int getNumMMInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		int cont = 0;
		String mmirdText = mmird.getTextMMInterfaceRelDiagram();
		for (MMInterfaceRelDiagram mmirdAux: patternRelDiagram){
			if (mmirdAux.getTextMMInterfaceRelDiagram().compareTo(mmirdText)==0){ 
					cont++;			  
			}
		}
		return cont;
	}
	
	/**
	 * Static method that returns the maximum order of the MMInterfaceRelDiagram objects with the same MMInterface than mmird. 
	 * @param patternRelDiagram
	 * @param mmird
	 * @return an integer that contains the max order.
	 */
	public static int getNumMaxOrderMMInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		int max = 0;
		String mmirdText = mmird.getTextMMInterfaceRelDiagram();
		for (MMInterfaceRelDiagram mmirdAux: patternRelDiagram){
			if (mmirdAux.getTextMMInterfaceRelDiagram().compareTo(mmirdText)==0){ 
					if (mmirdAux.getOrder()>max) 
						max = mmirdAux.getOrder(); 		  
			}
		}
		return max;
	}
	
	/**
	 * Static method that return the number of the MMInterfaceRelDiagram objects with the same MMInterface and order.
	 * @param patternRelDiagram
	 * @param mmird
	 * @return number of MMInterfaceRelDiagram with the same order
	 */
	public static int getNumMMInterfaceRelDiagramSameOrder (List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		int cont = 0;
		String mmirdText = mmird.getTextMMInterfaceRelDiagram();
		for (MMInterfaceRelDiagram mmirdAux: patternRelDiagram){
			if ((mmirdAux.getTextMMInterfaceRelDiagram().compareTo(mmirdText)==0)&&(mmirdAux.getOrder()==mmird.getOrder())){ 
					cont++;			  
			}
		}
		return cont;
	}
				
	/**
	 * Static method that check if an eclass is the same as the related to the specified pattern object(refTarjet).
	 * @param target -> reference MMInterfaceRelDiagram to relate
	 * @param eClass -> eclass to compare
	 * @param patternRelDiagram -> status relation between pattern and ecore.
	 * @param modelPack -> ecore.
	 * @param orderPoint -> reference order pointer.
	 * @return ETypeTarget
	 */
	public static boolean isETypeTarget( MMInterfaceRelDiagram target, EClass eClass, List<MMInterfaceRelDiagram> patternRelDiagram, EPackage modelPack, int orderPoint){

		if (((MMInterfaceRelDiagram)target).getMmInterface() instanceof ReferenceInterface){
		
			MMInterfaceRelDiagram mmird = null;
			if (target.getToConcreteSubtype()!= null) mmird = target.getToConcreteSubtype();
			else {
				ReferenceInterface refTarget = (ReferenceInterface)((MMInterfaceRelDiagram)target).getMmInterface() ;
				EReference eRefObject = getEReference(refTarget);
				EClass eTypeClassPattern = (EClass) eRefObject.getEType();
				mmird = getMMInterfaceRelDiagram(patternRelDiagram, eTypeClassPattern.getName(), orderPoint);
			}
			if ((mmird == null)) return true;
			
			if (!isAbstract(mmird, patternRelDiagram)){
				String elementDiagram = mmird.getElementDiagram();
				if (!elementDiagram.isEmpty()){
					  EClass eTypeClassDiagram = (EClass)ModelsUtils.getEObject(modelPack,elementDiagram);
					  if (eTypeClassDiagram.getEAllSuperTypes() != null)  
						  if ((eTypeClassDiagram == eClass)||(eTypeClassDiagram.getEAllSuperTypes().contains(eClass))) return true;
					  if (eClass.getEAllSuperTypes() != null)  
						  if ((eClass == eTypeClassDiagram)||(eClass.getEAllSuperTypes().contains(eTypeClassDiagram))) return true;
					  else if (eTypeClassDiagram == eClass) return true;
				}
			}else {
				if (target.getToConcreteSubtype()==null){
					for (MMInterfaceRelDiagram mmirdChildren: getSubTypesConcrete(patternRelDiagram, mmird)){
						String elementDiagram = mmirdChildren.getElementDiagram();
						if (!elementDiagram.isEmpty()){
							EClass eTypeClassDiagram = (EClass)ModelsUtils.getEObject(modelPack,elementDiagram);
							if (eTypeClassDiagram.getEAllSuperTypes() != null)
								if ((eTypeClassDiagram == eClass)||(eTypeClassDiagram.getEAllSuperTypes().contains(eClass))) return true;
								else if (eTypeClassDiagram == eClass) return true;
						}	
					}
				}
			}
		}
		return false;
	}

	/**
	 * Static method that returns a list that contains all of the MMInterfaceRelDiagram objects that points to the specified classInterface.
	 * @param patternRelDiagram of the pattern
	 * @param classInterface
	 * @param order
	 * @return a list that contains MMInterfaceRelDiagram objects 
	 */
	public static List<MMInterfaceRelDiagram> getMMInterfaceRelDiagramRefsEClass(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram classInterface){
		List<MMInterfaceRelDiagram> refs = new ArrayList<MMInterfaceRelDiagram>();

		if (classInterface.getMmInterface() instanceof ClassInterface){			
			EClass classObject = getEClass((ClassInterface)classInterface.getMmInterface());	
			for (MMInterfaceRelDiagram mmird : patternRelDiagram){
				if ((mmird.getMmInterface() instanceof ReferenceInterface)&&(mmird.getOrderPointer()==classInterface.getOrder())){
					EReference ref = getEReference((ReferenceInterface)mmird.getMmInterface());
					if ((ref.getEType().getName().compareTo(classObject.getName()) ==0)
							|| (mmird.getToConcreteSubtype() == classInterface)	)				
						refs.add(mmird);
				}
			}
		}
		return refs;
		
	}
		
	/**
	 * Static method that returns a list that contains all of the MMInterfaceRelDiagram objects that points to the specified classInterface (without its
	 * reflexive references)
	 * @param patternRelDiagram of the pattern
	 * @param classInterface
	 * @param order
	 * @return a list that contains MMInterfaceRelDiagram objects 
	 */
	public static List<MMInterfaceRelDiagram> getMMInterfaceRelDiagramRefsEClassWithoutDirectReflexives(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram classInterface){
		
		if (classInterface.getMmInterface() instanceof ClassInterface){
		EClass classObject = getEClass((ClassInterface)classInterface.getMmInterface());
		
		List<MMInterfaceRelDiagram> refs = new ArrayList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird : patternRelDiagram){
			if ((mmird.getMmInterface() instanceof ReferenceInterface)&&(mmird.getOrderPointer()==classInterface.getOrder())){
				EReference ref = getEReference((ReferenceInterface)mmird.getMmInterface());
				if (((ref.getEType().getName().compareTo(classObject.getName()) ==0) 
						|| (mmird.getToConcreteSubtype() == classInterface))
						&& !(isDirectReflexiveReference(patternRelDiagram, mmird)) && (classInterface.getOrder()==mmird.getOrder()))				
					refs.add(mmird);
			}
		}
		return refs;
		}
		
		return null;
	}
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram pointed by the specified ReferenceInterface.
	 * @param patternRelDiagram of the pattern
	 * @param refInterface 
	 * @param order of the MMInterfaceRelDiagram searched.
	 * @return the  MMInterfaceRelDiagram object, if doesn't exist return null.
	 */
	public static MMInterfaceRelDiagram getMMInterfaceRelDiagramRef(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram refInterface){
		
		if (refInterface.getMmInterface() instanceof ReferenceInterface){
		
			EReference refObject = getEReference((ReferenceInterface)refInterface.getMmInterface());
			
			for (MMInterfaceRelDiagram mmird : patternRelDiagram){
				if ((mmird.getMmInterface() instanceof ClassInterface)&&(mmird.getOrder()== refInterface.getOrderPointer())){
					EClass eClassObject = getEClass((ClassInterface)mmird.getMmInterface());
					if (refInterface.getToConcreteSubtype() != null) {
						if (refInterface.getToConcreteSubtype() == mmird) return mmird;
					}
					else if (refObject.getEType().getName().compareTo(eClassObject.getName()) ==0)
						return mmird;
				}
			}
		}
		return null;
	}
	
	/**
	 * Static method that copy the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a referenceInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmird MMInterfaceRelDiagram which's going to be copy
	 * @param order of the MMInterfaceRelDiagram which's going to be created
	 */
	public static void duplicateStructureReference(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird, int order, MMInterfaceRelDiagram parent){
		
		if (mmird.getMmInterface() instanceof ReferenceInterface){
			
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(patternRelDiagram, mmird);
			
			if (mmirdRef != null){
				int orderPointer = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(patternRelDiagram, mmirdRef)+1;
				if (((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(patternRelDiagram,mmird)) || (mmird.getMaxValue()==-1)  )
						&& ((mmirdRef.getMaxValue() > PatternUtils.getNumMMInterfaceRelDiagram(patternRelDiagram,mmirdRef))|| (mmirdRef.getMaxValue()==-1))){
					
					MMInterfaceRelDiagram mmirdRef2 = new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), "", orderPointer, -1,patternRelDiagram);
					patternRelDiagram.add(mmirdRef2);
					duplicateChildren(patternRelDiagram, mmirdRef, orderPointer, mmirdRef2);
					
					for (MMInterfaceRelDiagram subtype: PatternUtils.getSubTypes(patternRelDiagram, mmirdRef)){
						int orderSubtype = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(patternRelDiagram, subtype)+1;
						duplicateStructureClass(patternRelDiagram,subtype,orderSubtype, orderPointer);

					}
					MMInterfaceRelDiagram mmirdD = new MMInterfaceRelDiagram((ReferenceInterface)mmird.getMmInterface(), "",order ,orderPointer, patternRelDiagram, (parent==null?mmird.getParent():parent));
					mmirdD.setToConcreteSubtype(mmirdRef2);
					patternRelDiagram.add(mmirdD);
				}
			}else {
				//Reference to nothing
				if ((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(patternRelDiagram,mmird)) || (mmird.getMaxValue()==-1))
				patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)mmird.getMmInterface(), "",order ,0, patternRelDiagram, mmird.getParent()));
			}
			
		}
	}

	private static void duplicateChildren(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef, int orderPointer, MMInterfaceRelDiagram mmirdRefParent) {
		for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
			if (child.getMmInterface() instanceof ReferenceInterface){
				if (((isReflexiveReference(patternRelDiagram, child)) && (child.getOrder()== child.getOrderPointer()))
					/*All references same behavior || (!isContainmentReference((ReferenceInterface)child.getMmInterface()))*/){
					MMInterfaceRelDiagram reflex= new MMInterfaceRelDiagram((ReferenceInterface)child.getMmInterface(), "", orderPointer, orderPointer, patternRelDiagram, mmirdRefParent);
					reflex.setToConcreteSubtype(mmirdRefParent);
					patternRelDiagram.add(reflex);

				}else {duplicateStructureReference(patternRelDiagram,child,orderPointer, /**/mmirdRefParent);}			
			}else {
				if (child.getMmInterface() instanceof FeatureInstance)							
					patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), PatternUtils.getDefaultValue((FeatureInstance)child.getMmInterface()), orderPointer, patternRelDiagram, mmirdRefParent));
				else patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), "", orderPointer, patternRelDiagram, mmirdRefParent));
			}
		}
		
	}
	
	/**
	 * Static method that copy the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a classInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 * @param order of the MMInterfaceRelDiagram which's going to be created
	 * @return 
	 */
	public static MMInterfaceRelDiagram duplicateStructureClass(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef, int order, int orderPointer){
		
		if (mmirdRef.getMmInterface() instanceof ClassInterface){
			MMInterfaceRelDiagram newClass = 	new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), "", order,orderPointer, patternRelDiagram);
			patternRelDiagram.add(newClass);
				
			for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
				if (child.getMmInterface() instanceof ReferenceInterface){
					if (((isReflexiveReference(patternRelDiagram, child)) && (child.getOrder()== child.getOrderPointer()))
							|| (!isContainmentReference((ReferenceInterface)child.getMmInterface())))
						patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)child.getMmInterface(), "", order, order, patternRelDiagram, newClass));
					else duplicateStructureReference(patternRelDiagram,child,order, null);			
				}else {
					if (child.getMmInterface() instanceof FeatureInstance)							
						patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), /*PatternUtils.getDefaultValue((FeatureInstance)child.getMmInterface())*/child.getElementDiagram(), order, patternRelDiagram, newClass));
					else patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), "", order, patternRelDiagram, newClass));
				}
			}
			for (MMInterfaceRelDiagram subtype: PatternUtils.getSubTypes(patternRelDiagram, mmirdRef)){
				int orderSubtype = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(patternRelDiagram, subtype)+1;
				duplicateStructureClass(patternRelDiagram, subtype, orderSubtype, order);
			}
			return newClass;
		}
		return null;
	}
	
	/**
	 * Static method that copy an attribute
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 * @param order of the MMInterfaceRelDiagram which's going to be created
	 */
	public static void duplicateAttribute(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef, int order){
		if (mmirdRef.getMmInterface() instanceof FeatureInterface){
			if (mmirdRef.getMmInterface() instanceof FeatureInstance)							
				patternRelDiagram.add(new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), PatternUtils.getDefaultValue((FeatureInstance)mmirdRef.getMmInterface()), order, patternRelDiagram));
			else patternRelDiagram.add(new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), "", order, patternRelDiagram));
		}
	}
		
	/**
	 * Static method that delete the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a referenceInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmird MMInterfaceRelDiagram which's going to be copy
	 */
	public static void deleteStructureReference(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		
		if (mmird.getMmInterface() instanceof ReferenceInterface){
			
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(patternRelDiagram, mmird);
			
			if ((mmirdRef != null)&&(!((isReflexiveReference(patternRelDiagram,mmird)) && (mmird.getOrder()== mmird.getOrderPointer())))
					&& (PatternUtils.getMMInterfaceRelDiagramRefsEClassWithoutDirectReflexives(patternRelDiagram, mmirdRef).size()==1)){
				PatternApplicationUtils.copyAttRefClassChildren(patternRelDiagram, mmirdRef);

				for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
					if (child.getMmInterface() instanceof ReferenceInterface){
						deleteStructureReference(patternRelDiagram,child);			
					}else 
						patternRelDiagram.remove(child);
				}
				patternRelDiagram.remove(mmirdRef);

			}
			mmird.getParent().getChildren().remove(mmird);
			patternRelDiagram.remove(mmird);
		}
	}
	
	/**
	 * Static method that delete the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a referenceInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 */
	public static void deleteStructureClass(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef){						
		if (mmirdRef.getMmInterface() instanceof ClassInterface)
		if ((mmirdRef.getMinValue() < PatternUtils.getNumMMInterfaceRelDiagram(patternRelDiagram,mmirdRef))){
			PatternApplicationUtils.copyAttRefClassChildren(patternRelDiagram, mmirdRef);
			
			for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
				if (child.getMmInterface() instanceof ReferenceInterface){
					if  (!isContainmentReference((ReferenceInterface)child.getMmInterface()))
						patternRelDiagram.remove(child);
					else deleteStructureReference(patternRelDiagram,child);			
				}else {
					patternRelDiagram.remove(child);
				}
			}
			patternRelDiagram.remove(mmirdRef);
		}
	}
	
	/**
	 * Static method that delete the attribute pointed by the specified MMInterfaceRelDiagram (it has to contain a featureInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 */
	public static void deleteAttribute(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef){						
		if (mmirdRef.getMmInterface() instanceof FeatureInterface){
			mmirdRef.getParent().getChildren().remove(mmirdRef);
			patternRelDiagram.remove(mmirdRef);
		}
	}
	
	/**
	 * Static method that returns whether the specified reference is reflexive
	 * @param reference
	 * @return true if it´s reflexive, false whether not.
	 */
	public static boolean isReflexiveReference (List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram reference){
		if (reference.getMmInterface() instanceof ReferenceInterface){
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(content, reference);
			if (mmirdRef == null){
				//Si hemos borrado a quien apunta..
				EReference ref = getEReference((ReferenceInterface)reference.getMmInterface());
				return ref.getEType()== ref.getEContainingClass() || (ref.getEContainingClass().getEAllSuperTypes().contains(ref.getEType()));
			}else {	
				List<MMInterfaceRelDiagram> subtypes = getSubTypesAllLevels(content, mmirdRef);
				if (subtypes!=null) return subtypes.contains(reference.getParent()) || mmirdRef.equals(reference.getParent());
				else return mmirdRef.equals(reference.getParent());
			}
		}else return false;
	}
	
	/**
	 * Static method that returns whether the specified referenceInterface is direct reflexive
	 * @param reference
	 * @return true if it´s reflexive, false whether not.
	 */
	public static boolean isDirectReflexiveReference (List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram reference){

		if (reference.getMmInterface() instanceof ReferenceInterface){
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(content, reference);
			if (mmirdRef == null){
				//Si hemos borrado a quien apunta..
				EReference ref = getEReference((ReferenceInterface)reference.getMmInterface());
				return ref.getEType()== ref.getEContainingClass();
			}else 
				return mmirdRef.equals(reference.getParent());
		}else return false;
	}
	
	/**
	 * Static method that returns whether the specified referenceInterface is containment
	 * @param reference
	 * @return true if it´s containment, false whether not.
	 */
	public static boolean isContainmentReference (ReferenceInterface reference){
		EReference ref = getEReference(reference);
		
		return ref.isContainment();
	}

	/**
	 * Static method that returns whether the specified references have the same cardinality and if they are containment.
	 * @param referenceI
	 * @param reference
	 * @return true if they're compatible, false whether not.
	 */
	public static boolean areCompatibleReferences (ReferenceInterface referenceI, EReference reference){
		EReference refI = getEReference(referenceI);	
		if (((referenceI.isFlexibleComposite())||(refI.isContainment()== reference.isContainment()))
				&& ((referenceI.isAnyMin()) || (refI.getLowerBound()==reference.getLowerBound())) 
				&& ((referenceI.isAnyMax()) || (refI.getUpperBound()==reference.getUpperBound())) 
				&& ((referenceI.isAnyOrdering()) || (refI.isOrdered()==reference.isOrdered()))
				&& ((!referenceI.isUniqueMatters()) || (refI.isUnique()==reference.isUnique())))
			return true;
		else return false;	
	}
	
	/**
	 * Static method that returns whether the specified attributes have the same cardinality.
	 * @param featureT
	 * @param attribute
	 * @return true if they're compatible, false whether not.
	 */
	public static boolean areCompatibleFeatureTypes (FeatureType featureT, EAttribute attribute){
		EAttribute attI = getEAttribute(featureT);	
		return (((featureT.isAnyMin()) || (attI.getLowerBound()==attribute.getLowerBound())) && ((featureT.isAnyMax())||(attI.getUpperBound()==attribute.getUpperBound()))
				&& ((featureT.isAnyOrdering())||(attI.isOrdered()==attribute.isOrdered()))
				&& ((!featureT.isIDMatters())||(attI.isID()==attribute.isID()))
				&& ((!featureT.isUniqueMatters())||(attI.isUnique()==attribute.isUnique())));
	}
	
	/**
	 * Static method that returns whether the opposite references are related too. 
	 * @param content List<MMInterfaceRelDiagram> with the current content.
	 * @param mmird
	 * @param reference
	 * @return true if they're compatible, false whether not.
	 */
	public static boolean areCompatibleEOppositeReferences (List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram mmird, EReference reference){
		if (mmird.getMmInterface() instanceof ReferenceInterface){
		EReference refI = getEReference((ReferenceInterface)mmird.getMmInterface());	
		if (refI.getEOpposite()!= null){
			MMInterfaceRelDiagram mmrdOp = getMMInterfaceRelDiagram(content, refI.getEOpposite().getEContainingClass().getName()+"/"+refI.getEOpposite().getName(), mmird.getOrder());
			if (mmrdOp.getElementDiagram().isEmpty()) return true;
			else if (reference.getEOpposite()!= null)
				return reference.getEOpposite() == ModelsUtils.getEObject(reference.getEContainingClass().getEPackage(), mmrdOp.getElementDiagram());
			else return false; 
		}return true;
		} return false;
	}
	
	/**
	 * Static method that returns whether the specified classes have the same parents.
	 * @param classMMI
	 * @param eclass
	 * @return true if they're compatible, false whether not.
	 */
	public static boolean areCompatibleClasses (List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI, EClass eclass){
		if (classMMI.getMmInterface() instanceof ClassInterface){		
			EClass classMMIO = PatternUtils.getEClass((ClassInterface)classMMI.getMmInterface());			

			List<MMInterfaceRelDiagram> supertypes = PatternApplicationUtils.getSuperTypesConcrete(content, classMMI);
			if (supertypes.size() != 0){
				for (MMInterfaceRelDiagram parentClass: supertypes){
					if (parentClass != null) 
						if (!((ClassInterface)parentClass.getMmInterface()).isAbstract())
							if (!hasSuperTypeName(eclass, parentClass.getElementDiagram())) return false;
				}
			}	
			return (!((ClassInterface)classMMI.getMmInterface()).isAbstractMatters()) || (eclass.isAbstract()== classMMIO.isAbstract());			
		}return false;
	}
	
	/**
	 * Static method that returns the object ereference pointed by the specified referenceInterface
	 * @param referenceI - ReferenceInterface
	 * @return EReference
	 */
	public static EReference getEReference(ReferenceInterface referenceI) {
		EReference eRef = (EReference)referenceI.getRef();
		return eRef;
	}
	
	/**
	 * Static method that returns if the ereference pointed by the reference interface exists.
	 * @param referenceI - ReferenceInterface
	 * @return true if exists, false if not.
	 */
	public static boolean existsEReference(ReferenceInterface referenceI){
		EReference eref = getEReference(referenceI);
		if (eref != null) return eref.eResource() != null;
		return false;
	}
	
	/**
	 * Static method that returns the object eclass pointed by the specified classInterface
	 * @param classI - ClassInterface
	 * @return EClass
	 */
	public static EClass getEClass(ClassInterface classI) {
		EList<EClass> classes = classI.getRef();
		if (classes.size()>0)
			return  (EClass)classI.getRef().get(0);
		else return null;
	}
	
	/**
	 * Static method that returns if the eclass pointed by the class interface exists.
	 * @param classI - ClassInterface
	 * @return true if exists, false if not.
	 */
	public static boolean existsEClass(ClassInterface classI){
		EClass eclass = getEClass(classI);
		if (eclass != null) return eclass.eResource() != null;
		return false;
	}
	
	/**
	 * Static method that returns the object eattribute pointed by the specified featureInterface
	 * @param featureI - FeatureInterface
	 * @return EAttribute
	 */
	public static EAttribute getEAttribute(FeatureInterface featureI) {
		EList<EAttribute> attrs = featureI.getRef();
		if (attrs.size()>0)
			return (EAttribute)featureI.getRef().get(0);
		else return null;
	}
	
	/**
	 * Static method that returns if the eattribute pointed by the feature interface exists
	 * @param featureI - FeatureInterface
	 * @return true if exists, false if not
	 */
	public static boolean existsEAttribute(FeatureInterface featureI){
		EAttribute eatt = getEAttribute(featureI);
		if (eatt != null) return eatt.eResource() != null;
		return false;
	}
	
	/**
	 * Static method that returns the default value of the attribute pointed by the specified featureInstance.
	 * @param featureI
	 * @return default value text
	 */
	public static String getDefaultValue(FeatureInstance featureI) {
		EAttribute eAttRef = (EAttribute)featureI.getRef().get(0);
		return eAttRef.getDefaultValueLiteral();
	}
	
	/**
	 * Static method that returns the datatype of the attribute pointed by the specified featureInstance.
	 * @param featureI
	 * @return EDataType
	 */
	public static EDataType getEType(FeatureType featureI) {
		EAttribute eAttRef = (EAttribute)featureI.getRef().get(0);
		return eAttRef.getEAttributeType();
	}

	/**
	 * Static method that returns the list of plug interfaces associated with the service.	
	 * @param service
	 * @param intModel resource with the interface model
	 * @return list of interfaces
	 */
	public static List<Interface> getPlugInterfaces(Service service, Resource intModel){
		List<Interface> interfaces = new LinkedList<Interface>();
		for (Port port : service.getPorts()){
			if (port instanceof Plug)
				for (Interface interf : port.getUses()){
					if (interf.eIsProxy())	interf = getProxyInterface(interf, intModel);
					interfaces.add(interf);
				}
		}
		return interfaces;
	}
	
	/**
	 * Static method that returns the interface related to the proxy interface.
	 * @param proxyI
	 * @param intModel
	 * @return interface object
	 */
	private static Interface getProxyInterface(Interface proxyI, Resource intModel){
		URI uri = ((InterfaceImpl)proxyI).eProxyURI();
		if (uri.isRelative()){
			URI uri2= intModel.getURI();
			uri2 = uri2.appendFragment(uri.fragment());
			((InterfaceImpl)proxyI).eSetProxyURI(uri2);
		}
		return (Interface)EcoreUtil.resolve(proxyI, intModel);

	}
	
	/**
	 * Static method that returns the list of slots interfaces associated with the service.	
	 * @param service
	 * @param intModel resource with the interface model
	 * @return list of interfaces
	 */
	public static List<Interface> getSlotInterfaces(Service service, Resource intModel){
		List<Interface> interfaces = new LinkedList<Interface>();
		for (Port port : service.getPorts()){
			if (port instanceof Slot)
				for (Interface interf : port.getUses()){
					if (interf.eIsProxy())	interf = getProxyInterface(interf, intModel);
					interfaces.add(interf);
				}
		}
		return interfaces;
	}
	
	/**
	 * Static method that returns the list of acceptor interfaces associated with the service.	
	 * @param service
	 * @param intModel resource with the interface model
	 * @return list of interfaces
	 */
	public static List<Interface> getAcceptorInterfaces(Service service, Resource intModel){
		List<Interface> interfaces = new LinkedList<Interface>();
		for (Port port : service.getPorts()){
			if (port instanceof Acceptor)
				for (Interface interf : port.getUses()){
					if (interf.eIsProxy()) interf = getProxyInterface(interf, intModel);
					interfaces.add(interf);
				}
		}
		return interfaces;
	}
	
	/**
	 * Static method that returns the list of injector interfaces associated with the service.	
	 * @param service
	 * @param intModel resource with the interface model
	 * @return list of interfaces
	 */
	public static List<Interface> getInjectorInterfaces(Service service, Resource intModel){
		List<Interface> interfaces = new LinkedList<Interface>();
		for (Port port : service.getPorts()){
			if (port instanceof Injector)
				for (Interface interf : port.getUses()){
					if (interf.eIsProxy())interf = getProxyInterface(interf, intModel);
					interfaces.add(interf);
				}
		}
		return interfaces;
	}
	
	/**
	 * Static method that adds the services and their info associated with the pattern.
	 * @param patternServiceInfoList - current list of pattern service info.
	 * @param pi - patternInstance 
	 * @param intModel - interfaces Model
	 * @param allPatterns 
	 * @return operation success
	 */
	public static boolean addPatternServicesInfo(List<PatternServiceInfo> patternServiceInfoList, PatternInstance pi, Resource intModel, List<Pattern> allPatterns  ){
		Pattern pattern = pi.getPattern();
		for (Service service : pattern.getServices()){
			
			ServiceInstance si = RuntimeServicesModelUtils.addPatternServiceInfo(pi, service, true);
			PatternServiceInfo psi = new PatternServiceInfo(pi.getIdent(), pattern, si);

			//Activable
			checkActivableService(psi,patternServiceInfoList,intModel, allPatterns);
						
			//check for updates
			if ((psi.isActivated())&&(psi.getMissing().isEmpty()))addCheckActivableServiceForUpdates(patternServiceInfoList, pattern);
			
			patternServiceInfoList.add(psi);
		}
		return true;
	}
	
	/**
	 * Static method that checks if a service is activable
	 * @param psi - patternServiceInfo
	 * @param patternServiceInfoList  - current list of pattern service info.
	 * @param intModel - interface model
	 * @param allPatterns
	 */
	public static void checkActivableService(PatternServiceInfo psi, List<PatternServiceInfo> patternServiceInfoList, Resource intModel, List<Pattern> allPatterns){
		psi.getMissing().clear();
		//PLUG-SLOT
		List<Interface> ri = getPlugInterfaces(psi.getService(), intModel);
		for (Interface i: ri){
			if (!slotProvidedByAnotherService(patternServiceInfoList, i, intModel)) {
				//Get the relative interface without modifying the repository
				Interface irelative = PatternUtils.getInterface(intModel, i);
				psi.addMissing((irelative!=null?irelative:i), getSlotOfferedBy(i, intModel, allPatterns));
			}
		}
		//ACCEPTOR-INJECTOR
		ri = getAcceptorInterfaces(psi.getService(), intModel);
		for (Interface i: ri){
			if (!injectorProvidedByAnotherService(patternServiceInfoList, i, intModel)) {
				Interface irelative = PatternUtils.getInterface(intModel, i);
				psi.addMissing((irelative!=null?irelative:i),  getInjectorOfferedBy(i, intModel, allPatterns));
			}
		}
	}
	
	/**
	 * Static method that checks if a service is activable due to updates.
	 * @param patternServiceInfoList
	 * @param pattern
	 */
	public static void addCheckActivableServiceForUpdates(List<PatternServiceInfo> patternServiceInfoList, Pattern pattern){
		for (PatternServiceInfo psi : patternServiceInfoList){
			List<DisconnectedElement> deToRemove = new LinkedList<DisconnectedElement>();

			for (DisconnectedElement de: psi.getMissing()){
				if (containsPattern(pattern, de.getPatterns()))
					deToRemove.add(de);
			}

			for (DisconnectedElement de: deToRemove){
				psi.removeMissing(de);
			}
		}
	}
	
	/**
	 * Static method that check if a service is activable after a delete operation.
	 * @param patternServiceInfoList
	 * @param intModel - interface model
	 */
	public static void deleteCheckActivableServiceForUpdates(List<PatternServiceInfo> patternServiceInfoList, Resource intModel, List<Pattern> allPatterns){
		for (PatternServiceInfo psi: patternServiceInfoList){
			checkActivableService(psi, patternServiceInfoList, intModel, allPatterns);
		}
	}
	
	/**
	 * Static method that returns if the list of patterns contain the specific pattern.
	 * @param pattern
	 * @param patterns
	 * @return true if is contained, false if not.
	 */
	private static boolean containsPattern(Pattern pattern, List<Pattern> patterns){
		for (Pattern patAux: patterns){
			if (patAux.getName().compareToIgnoreCase(pattern.getName())==0) 
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that remove the information about the services of a pattern.
	 * @param patternServiceInfoList
	 * @param patternName
	 * @param intModel - interface model
	 * @return true - success method.
	 */
	public static boolean deletePatternServicesInfo(List<PatternServiceInfo> patternServiceInfoList, String patternName, Resource intModel, List<Pattern> allPatterns){	
		for (PatternServiceInfo psi: patternServiceInfoList){
			if (psi.getPatternName().compareTo(patternName)==0) 
				patternServiceInfoList.remove(psi);
		}
		deleteCheckActivableServiceForUpdates(patternServiceInfoList, intModel, allPatterns);
		
		return true;
	}
	
	/**
	 * Static method that returns if the interface is implemented by any activated service (check only slot interfaces)
	 * @param patternServiceInfoList
	 * @param interf
	 * @return true if any service implements the interface.
	 */
	private static boolean slotProvidedByAnotherService(List<PatternServiceInfo> patternServiceInfoList, Interface interf, Resource intModel){
		for (PatternServiceInfo psi: patternServiceInfoList){
			if (psi.isActivated())
				for (Interface provInt: getSlotInterfaces(psi.getService(), intModel)){
					if (provInt.getQName().compareTo(interf.getQName())==0) return true;
				}		
		}
		return false;
	}
	
	/**
	 * Static method that returns if the interface is implemented by any activated service (check only injector interfaces)
	 * @param patternServiceInfoList
	 * @param interf
	 * @return true if any service implements the interface.
	 */
	private static boolean injectorProvidedByAnotherService(List<PatternServiceInfo> patternServiceInfoList, Interface interf, Resource intModel){
		for (PatternServiceInfo psi: patternServiceInfoList){
			if (psi.isActivated())
				for (Interface provInt: getInjectorInterfaces(psi.getService(), intModel)){
					if (provInt.getQName().compareTo(interf.getQName())==0) return true;
				}		
		}
		return false;
	}
	
	/**
	 * Static method that returns the patterns that offer the slot interface 
	 * @param interf
	 * @param intModel - interface model
	 * @return list of pattern
	 */
	private static List<Pattern> getSlotOfferedBy (Interface interf, Resource intModel, List<Pattern> allPatterns){
		List<Pattern> patterns = new LinkedList<Pattern>();
		for (Pattern pattern: allPatterns){
			for (Service service: pattern.getServices()){
				for (Interface interfAux : getSlotInterfaces(service, intModel)){
					if (interfAux.getQName().compareTo(interf.getQName())==0) patterns.add(pattern);
				}
			}
		}
		return patterns;
	}
	
	public static Interface getInterface(Resource intModel, Interface interf){
		InterfaceRepository ir =(InterfaceRepository) intModel.getContents().get(0);
		for (Packageable pack : ir.getContents()){
			Interface inter = getInterface(pack, interf);
			if (inter != null) return inter;	
		}
		return null;
	}
	
	private static Interface getInterface(Packageable pack, Interface interf){
		if (pack instanceof Interface){
			if (((Interface)pack).getQName().compareTo(interf.getQName())==0)
			return (Interface)pack;	
		} else if (pack instanceof Package) {
			for (Packageable subPack: ((Package)pack).getContents()){
				Interface inter = getInterface(subPack, interf);
				if (inter != null) return inter;
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the patterns that offer the injector interface
	 * @param interf
	 * @param intModel - interface method
	 * @return list of patterns
	 */
	private static List<Pattern> getInjectorOfferedBy (Interface interf, Resource intModel, List<Pattern> allPatterns){
		List<Pattern> patterns = new LinkedList<Pattern>();
		for (Pattern pattern: allPatterns){
			for (Service service: pattern.getServices()){
				for (Interface interfAux : getInjectorInterfaces(service, intModel)){
					if (interfAux.getQName().compareTo(interf.getQName())==0) patterns.add(pattern);
				}
			}
		}
		return patterns;
	}
	
	/**
	 * Static method that returns all the patterns stored on the project
	 * @param project 
	 * @return list of pattern
	 */
	public static List<Pattern> getAllPatterns (IProject project){
		List<Pattern> patterns = new LinkedList<Pattern>();
		PatternSet patternset = getPatternSetModel(project);
		if (patternset != null)
		for (Category cat: patternset.getCategories()){
			setPatterns(patterns, cat);
		}
		return patterns;
	}
	
	/**
	 * Static method that adds all the pattern of this category (can exists subcategories)
	 * @param patterns
	 * @param cat
	 */
	private static void setPatterns(List<Pattern> patterns, Category cat){
		if (cat!=null){
			patterns.addAll(cat.getPatterns());
			cat.getSubcategories().forEach(subcat->setPatterns(patterns, subcat));
		}
		
	}
	
	/**
	 * Static method that returns if a classinterface is abstract or belongs to an abstract classinterface.
	 * @param mmird
	 * @param list
	 * @return true if it's an abstract classinterface or belongs to it.
	 */
	public static boolean isAbstract (MMInterfaceRelDiagram mmird, List<MMInterfaceRelDiagram> list){
		ClassInterface ci = null;
		if (mmird != null){
			if (mmird.getMmInterface() instanceof ClassInterface)
				ci=(ClassInterface)mmird.getMmInterface();
			else {
				MMInterfaceRelDiagram parent = mmird.getParent();
				ci=(ClassInterface)parent.getMmInterface();
			}
			return ci.isAbstract();
		}else return false;
	}

	/**
	 * Static method that returns if the eClass has any parent with the specified name.
	 * @param eclass
	 * @param name
	 * @return true if it has, false it hasn't
	 */
	private static boolean hasSuperTypeName(EClass eclass, String name){
		if (!name.isEmpty())
			for (EClass superClass: eclass.getEAllSuperTypes()){
				if (superClass.getName().compareTo(name)==0){
					return true;
				}
			}
		return false;
	}

	/**
	 * Static method that returns the children of a classinterface.(first level)
	 * @param content
	 * @param classMMI
	 * @return list of MMInterfaceRelDiagram objects
	 */
	public static List<MMInterfaceRelDiagram> getSubTypesConcrete(List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI){
		List<MMInterfaceRelDiagram> subTypes = new LinkedList<MMInterfaceRelDiagram>();
		if (classMMI.getMmInterface() instanceof ClassInterface){
			EClass eclass = getEClass((ClassInterface)classMMI.getMmInterface());
			for (EClass child:ModelUtils.getChildren(eclass.getEPackage(), eclass)){		
				
				List<MMInterfaceRelDiagram> subTypesAux = getAllMMInterfaceRelDiagram(content, child,classMMI.getOrder());
				for (MMInterfaceRelDiagram subType :subTypesAux){
					if (isAbstract(subType, content)) 
						subTypes.addAll(getSubTypesConcrete(content, subType));
					else subTypes.add(subType);	
				}
			}
		}return subTypes;
	}
	
	/**
	 * Static method that returns the children of a classinterface. (first level)
	 * @param content
	 * @param classMMI
	 * @return list of MMInterfaceRelDiagram objects
	 */
	public static List<MMInterfaceRelDiagram> getSubTypes(List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI){
		List<MMInterfaceRelDiagram> subTypes = new LinkedList<MMInterfaceRelDiagram>();
		if (classMMI.getMmInterface() instanceof ClassInterface){
			EClass eclass = getEClass((ClassInterface)classMMI.getMmInterface());
			for (EClass child:ModelUtils.getChildren(eclass.getEPackage(), eclass)){		
				for (MMInterfaceRelDiagram subType :getAllMMInterfaceRelDiagram(content, child,classMMI.getOrder())){
					subTypes.add(subType);	
				}
			}
		}return subTypes;
	}
		
	/**
	 * Static method that returns the children of a classinterface. (all levels)
	 * @param content
	 * @param classMMI
	 * @return list of MMInterfaceRelDiagram objects
	 */
	public static List<MMInterfaceRelDiagram> getSubTypesAllLevels(List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI){
		List<MMInterfaceRelDiagram> subTypes = new LinkedList<MMInterfaceRelDiagram>();
		
		for (MMInterfaceRelDiagram subtype: getSubTypes(content, classMMI)){
			subTypes.add (subtype);
			subTypes.addAll (getSubTypesAllLevels(content, subtype));
		}
		return subTypes;
	}

	/**
	 * Static method that returns the list of pattern metaModel objects that contains the pattern.
	 * @param pattern
	 * @return list of pattern meta-models.
	 */
	public static List<PatternMetaModel> getPatternMetamodel (Pattern pattern){
		List<PatternMetaModel> pm = new ArrayList<>();
		ComplexFeatureMain cf = pattern.getRootVariant();
		if (cf != null){
			for (Variant var : cf.getAndChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
			for (Variant var : cf.getOrChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
			for (Variant var : cf.getXorChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
		}
		return pm;
	}
	
	/**
	 * Static method that returns if the pattern meta-models are equals.
	 * @param pmm1
	 * @param pmm2
	 * @return boolean
	 */
	public static boolean areEqualsPatternMetamodels (PatternMetaModel pmm1, PatternMetaModel pmm2){
	  if ((pmm1 != null) && (pmm2 != null)){
		  String name1= ((Variant)pmm1.eContainer()).getName();
		  String name2 = ((Variant)pmm2.eContainer()).getName();
		  return name1.equals(name2);
		  
	  } else return pmm1 == pmm2;
	}
	
	/**
	 * Static method that returns if the list contains the pattern meta-model
	 * @param patternMetamodels
	 * @param pmm
	 * @return boolean
	 */
	public static boolean containsPatternMetamodel (List<PatternMetaModel> patternMetamodels, PatternMetaModel pmm){
		for (PatternMetaModel pmmAux: patternMetamodels){
			if (areEqualsPatternMetamodels(pmmAux, pmm)) return true;
		}
		return false;
	}
	
}
