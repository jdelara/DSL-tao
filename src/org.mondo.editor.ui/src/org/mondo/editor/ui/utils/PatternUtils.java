package org.mondo.editor.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationCustomFeature;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationEntryFeature;
import org.mondo.editor.graphiti.diagram.CreateEAttributeFeature;
import org.mondo.editor.graphiti.diagram.CreateEClassFeature;
import org.mondo.editor.graphiti.diagram.CreateEReferenceFeature;
import org.mondo.editor.graphiti.diagram.CreateESuperTypeFeature;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.utils.dragdrop.MMInterfaceRelDiagram;
import org.mondo.editor.ui.utils.services.PatternServiceInfo;
import org.osgi.framework.Bundle;

import serviceInterfaces.Interface;
import serviceInterfaces.impl.InterfaceImpl;

import dslPatterns.Acceptor;
import dslPatterns.Category;
import dslPatterns.ClassInterface;
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

/**
 * Class of utility functions to work with patterns.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class PatternUtils {

	static final String RELATIVE_DIR = "samples"+File.separator;
	static final String PATTERN_FILE_NAME = "repository.dslpatterns";
	static final String PATTERN_INTERFACES_NAME = "interfaces.serviceInterfaces";
	static final String PLUGIN_DSL_ID = "org.mondo.dsl";
	static final String PATH_IMAGE_DEFAULT = "samples"+File.separator+"icons"+File.separator+"NoImagePattern.gif";

	/**
	 * Static method that returns the PatternSet object stored on RELATIVE_PATH
	 * @return PatternSet, null if it's not possible
	 */
	public static PatternSet getPatternSetModel() {
		try{
			Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
			IPath relativeIPath = new Path(PatternUtils.RELATIVE_DIR+PatternUtils.PATTERN_FILE_NAME);	
			URL fileInPlugin = FileLocator.find(plugin, relativeIPath, null);
			
			URL srcUrl = FileLocator.toFileURL(fileInPlugin);		
			File src = new File(srcUrl.getPath());	
			
			XMIResourceImpl resource = new XMIResourceImpl();
			resource.load( new FileInputStream(src), new HashMap<Object,Object>());
			PatternSet patternSet = (PatternSet) resource.getContents().get(0);
				
			return patternSet;	
			
		} catch (Exception e){
			System.out.println("file doesn't exist");
			return null;
		}		
	}
	
	/**
	 * Static method that returns the image associated with the metamodel.
	 * @param metamodel
	 * @return image
	 */
	public static Image getImagePatternMetamodels(PatternMetaModel metamodel){
		Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
		URL url = null;
		if (metamodel != null){ 
			String img = metamodel.getImg();
			if (img != null){
				url = FileLocator.find(plugin, new Path(img), null);
				if (url!=null){
					ImageDescriptor desc =  ImageDescriptor.createFromURL(url);
					if (desc != null) return desc.createImage();
				}
			}
		}
		url = FileLocator.find(plugin, new Path(PATH_IMAGE_DEFAULT), null);
		if (url!=null){
			ImageDescriptor desc =  ImageDescriptor.createFromURL(url);
			if (desc != null) return desc.createImage();
		}
		return null;
	}
	
	/**
	 * Static method that returns an eobject by his name, it's on the dsl plugin.
	 * @param refEObject
	 * @return EObject
	 */
 	private static EObject getEObjectRef(String refEObject){
		String[] cads = refEObject.split("#//");
		
		if (cads.length > 1){
			try{
				Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
				IPath relativeIPath = new Path(PatternUtils.RELATIVE_DIR+cads[0]);	
				URL fileInPlugin = FileLocator.find(plugin, relativeIPath, null);
				URL srcUrl = FileLocator.toFileURL(fileInPlugin);				
				
				EPackage epack = ModelUtils.openModel(srcUrl.toString());
				return ModelsUtils.getEObject(epack, cads[1]);
				
			}catch(Exception e){
				System.out.println("Error "+e.getMessage());
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram object (mmird) children
	 * @param list
	 * @param mmird
	 * @return a list that contains the children, if doesn't have children null.
	 */
	public static List<MMInterfaceRelDiagram> getChildren(List<MMInterfaceRelDiagram> list, MMInterfaceRelDiagram mmird){
		
		if (mmird.getMmInterface() instanceof ClassInterface){
			String eObjectName = mmird.getTextMMInterfaceRelDiagram();
			List<MMInterfaceRelDiagram> children = new ArrayList<>();
			
			try{
				for (MMInterfaceRelDiagram info: list){
					String[] cads = info.getTextMMInterfaceRelDiagram().split("/");
					if (cads.length > 1)
					if ((cads[0].compareTo(eObjectName)==0) && (mmird.getOrder()== info.getOrder())) 
						children.add(info);
				}
				
			}catch(Exception e){
				System.out.println("Error "+e.getMessage());
			}
	
			return children;
		}else return null;
	}
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram object (mmird) children
	 * @param list
	 * @param mmird
	 * @return a list that contains the children, if doesn't have children null.
	 */
	public static MMInterfaceRelDiagram getParent(List<MMInterfaceRelDiagram> list, MMInterfaceRelDiagram mmird){
		
		if ((mmird.getMmInterface() instanceof FeatureInterface) || (mmird.getMmInterface() instanceof ReferenceInterface)) {
			String eObjectName = mmird.getTextMMInterfaceRelDiagram();
			String[] cads = eObjectName.split("/");
			try{
				for (MMInterfaceRelDiagram info: list){
					if (info.getMmInterface() instanceof ClassInterface){
						String eClassName = info.getTextMMInterfaceRelDiagram();
						if ((cads[0].compareTo(eClassName)==0)&& (mmird.getOrder()== info.getOrder())) 
							return info;
					}
				}
				
			}catch(Exception e){
				System.out.println("Error "+e.getMessage());
			}
		}
		return null;
	}

	/**
	 *Static method that apply the pattern according to an user selection.
	 * @param patternRelDiagram
	 * @param diagramBehavior
	 */
	public static void applyPattern( final List<MMInterfaceRelDiagram> patternRelDiagram, final DiagramBehavior diagramBehavior, final String patternName){

		final IFeatureProvider fp = diagramBehavior.getDiagramTypeProvider().getFeatureProvider();	
		diagramBehavior.getEditingDomain().getCommandStack().execute(new RecordingCommand(diagramBehavior.getEditingDomain()) {

			@Override
			protected void doExecute() {
				EPackage pack = null;
				if (!ModelUtils.existsPackage(diagramBehavior.getDiagramTypeProvider().getDiagram())){
					pack = ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram());
					diagramBehavior.getDiagramTypeProvider().getFeatureProvider().link(diagramBehavior.getDiagramTypeProvider().getDiagram(), pack);
				} else 	pack = ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram());

				String annotationName = ModelUtils.getSourceNameValid(pack, patternName);
				EAnnotation annotationEPackage = createEAnnotation(diagramBehavior,pack ,annotationName );  

				for (final MMInterfaceRelDiagram info: patternRelDiagram){
					if (info.getMmInterface() instanceof ClassInterface){
						EObject selObj = null; 
						if (ModelUtils.existsPackage(diagramBehavior.getDiagramTypeProvider().getDiagram()))
							selObj = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), info.getElementDiagram());
						EAnnotation annotation = null;
						 if (selObj != null){
							 annotation = createEAnnotation(diagramBehavior, (EClass) selObj,info.getTextMMInterfaceRelDiagram() );  
							 annotationEPackage.getReferences().add(annotation);
							 info.setAnnotation(annotation);
	
						 }else if ((selObj == null) && (info.getMinValue()>0)){
							CreateContext cc = new CreateContext();
							CreateEClassFeature ccf = new CreateEClassFeature(fp);
							Object[] eClasses = ccf.create(cc);
							
							AddContext ac = new AddContext();
							ac.setLocation(100, 100);
							ac.setTargetContainer(diagramBehavior.getDiagramTypeProvider().getDiagram());
							ac.setNewObject(eClasses[0]);
							fp.getAddFeature(ac).add(ac);
							
							annotation = createEAnnotation(diagramBehavior, (EModelElement)eClasses[0],info.getTextMMInterfaceRelDiagram() );
							annotationEPackage.getReferences().add(annotation);

							info.setAnnotation(annotation);
							
							EClass eclass = PatternUtils.getEClass((ClassInterface)info.getMmInterface());
							
							if (eclass.getESuperTypes().size()!=0){
								CreateConnectionContext ccc = new CreateConnectionContext();
								Anchor sourceAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), ((EClass)eClasses[0]));
								
								EClass superType = (EClass)eclass.getESuperTypes().get(0);
								MMInterfaceRelDiagram infoESuperEClass = getMMInterfaceRelDiagram(patternRelDiagram, superType.getName(), info.getOrderPointer());
								EObject eTypeEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoESuperEClass.getElementDiagram());

								Anchor targetAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(),(EClass)eTypeEClass);
	
								
								ccc.setSourceAnchor(sourceAnc);
								ccc.setTargetAnchor(targetAnc);
								CreateESuperTypeFeature crf = new CreateESuperTypeFeature(fp);
								crf.create(ccc);
								
							}
							
							info.setElementDiagram(((EClass)eClasses[0]).getName());
					
						  }
						 
						 for (MMInterfaceRelDiagram child : getChildren(patternRelDiagram, info)){
							 if (child.getMmInterface() instanceof FeatureInstance){
								EAttribute eAttObject = getEAttribute((FeatureInterface)child.getMmInterface());	
								 
								CreateEAnnotationEntryFeature cae = new CreateEAnnotationEntryFeature(diagramBehavior.getDiagramTypeProvider().getFeatureProvider(),annotation, ((EAttribute)eAttObject).getName(),child.getElementDiagram());
								if (cae.canCreate(new CreateContext())){
									diagramBehavior.executeFeature(cae, new CreateContext());
								}
							 }
						 }
							
					}
					
				}
				
				
				for (final MMInterfaceRelDiagram info: patternRelDiagram){
				  
					if ((info.getMmInterface() instanceof ReferenceInterface) || (info.getMmInterface() instanceof FeatureType)){
					
						EObject selObj = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), info.getElementDiagram());
						 if (selObj != null){
							EAnnotation annotation = createEAnnotation(diagramBehavior, (EModelElement) selObj,info.getTextMMInterfaceRelDiagram());  

							String refName = info.getTextMMInterfaceRelDiagram();
							String[] cads = refName.split("/");
							
							String classAnnot = cads[0];
							MMInterfaceRelDiagram mmirdClass = getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
							mmirdClass.getAnnotation().getReferences().add(annotation);
				 			
							info.setAnnotation(annotation);

						 }else if ((selObj == null)&&(info.getMmInterface() instanceof ReferenceInterface)  && (info.getMinValue()>0)){
	
						  String refName = info.getTextMMInterfaceRelDiagram();
						  String[] cads = refName.split("/");
						  if (cads.length == 2) {
							  String classAnnot = cads[0];
							  MMInterfaceRelDiagram infoContentEClass = getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
							  if (infoContentEClass!=null){
									final EObject contentEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoContentEClass.getElementDiagram());
									EObject eRefObject = getEReference((ReferenceInterface)info.getMmInterface());
									boolean created=false;
									if ((eRefObject != null)&& (eRefObject instanceof EReference)&&(((EReference)eRefObject).getEOpposite()!= null)){
										EReference patternOpposite = ((EReference)eRefObject).getEOpposite();
										String nameOpposite = patternOpposite.getEContainingClass().getName()+"/"+patternOpposite.getName();
										MMInterfaceRelDiagram mmirdOpposite = getMMInterfaceRelDiagram(patternRelDiagram, nameOpposite, info.getOrder());
										if (!mmirdOpposite.getElementDiagram().isEmpty()){
											EReference refOp = (EReference) ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), mmirdOpposite.getElementDiagram());
											EReference newRef= DiagramUtils.createEOppositeReference(refOp,(EReference)eRefObject,diagramBehavior.getDiagramTypeProvider().getDiagram());
											
											EAnnotation annotation = createEAnnotation(diagramBehavior,newRef,info.getTextMMInterfaceRelDiagram() );	
											MMInterfaceRelDiagram mmirdClass = getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
											mmirdClass.getAnnotation().getReferences().add(annotation);

											created = true;
										}
									}
									
									if ((!created)&&(eRefObject != null)&& (eRefObject instanceof EReference)){
										MMInterfaceRelDiagram infoETypeEClass = getMMInterfaceRelDiagram(patternRelDiagram, ((EReference)eRefObject).getEType().getName(), info.getOrderPointer());
										EObject eTypeEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoETypeEClass.getElementDiagram());
	
										CreateConnectionContext cc = new CreateConnectionContext();
										Anchor sourceAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)contentEClass);
										Anchor targetAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)eTypeEClass);
	
										
										cc.setSourceAnchor(sourceAnc);
										cc.setTargetAnchor(targetAnc);
										CreateEReferenceFeature crf = new CreateEReferenceFeature(fp);
										
										cc.putProperty("EREFERENCE", (EReference)eRefObject);
										
										Connection con = crf.create(cc);
										EReference eReference = (EReference)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
										
										EAnnotation annotation = createEAnnotation(diagramBehavior, eReference,info.getTextMMInterfaceRelDiagram() );	

										MMInterfaceRelDiagram mmirdClass = getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
										mmirdClass.getAnnotation().getReferences().add(annotation);
										
										info.setElementDiagram(eReference.getEContainingClass().getName()+"/"+eReference.getName());
										
									}
							  }
						  }
	
					  }
	 
					  else if ((selObj == null)&&(info.getMmInterface() instanceof FeatureType)  && (info.getMinValue()>0)){
	
						  String refName = info.getTextMMInterfaceRelDiagram();
						  String[] cads = refName.split("/");
						  if (cads.length == 2) {
							  String classAnnot = cads[0];
							  MMInterfaceRelDiagram infoContentEClass = getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
							  if (infoContentEClass!=null){
									EObject contentEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoContentEClass.getElementDiagram());
									
									EAttribute eAttObject = getEAttribute((FeatureInterface)info.getMmInterface());
	
									if ((eAttObject != null)&& (eAttObject instanceof EAttribute)){
										
										CreateContext cc = new CreateContext();
	
										ContainerShape cs = DiagramUtils.getTargetContainer(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)contentEClass);
										cc.setTargetContainer(cs);
										CreateEAttributeFeature crf = new CreateEAttributeFeature(fp);
										Object[] atts = crf.create(cc);									
										
										((EAttribute)atts[0]).setEType(eAttObject.getEType());
										
										EAnnotation annotation = createEAnnotation(diagramBehavior, (EAttribute)atts[0],info.getTextMMInterfaceRelDiagram() );
										
										infoContentEClass.getAnnotation().getReferences().add(annotation);
									}
							  }
						  }
					  }  
					
					}		
				}
			}
		});
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
	 * Static method that returns the number of the MMInterfaceRelDiagram objects with the same MMInterface than mmird. 
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
	 * Static method that returns the maximun order of the MMInterfaceRelDiagram objects with the same MMInterface than mmird. 
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
	 * @return num MMInterfaceRelDiagram with the same order
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
	 * Static method that creates an annotation for the specified element with the specified text.
	 * @param editor
	 * @param element
	 * @param text
	 * @return the EAnnotation object
	 */
	private static EAnnotation createEAnnotation (DiagramBehavior editor, EModelElement element, String text){
		CreateEAnnotationCustomFeature caf = new CreateEAnnotationCustomFeature(editor.getDiagramTypeProvider().getFeatureProvider(),element, text);
		editor.executeFeature(caf, new CustomContext());	
		return caf.getAnnotation();
	}
	
	/**
	 * Static method that check if an eclass is the same as the related to the specified pattern object(refTarjet).
	 * @param refTarget -> reference interface to relate
	 * @param eClass -> eclass to compare
	 * @param patternRelDiagram -> status relation between pattern and ecore.
	 * @param modelPack -> ecore.
	 * @param orderPoint -> reference order pointer.
	 * @return ETypeTarget
	 */
	public static boolean isETypeTarget( ReferenceInterface refTarget, EClass eClass, List<MMInterfaceRelDiagram> patternRelDiagram, EPackage modelPack, int orderPoint){
		
		EReference eRefObject = getEReference(refTarget);
		EClass eTypeClassPattern = (EClass) eRefObject.getEType();
		MMInterfaceRelDiagram mmird = getMMInterfaceRelDiagram(patternRelDiagram, eTypeClassPattern.getName(), orderPoint);
		if (mmird == null) return true;
		String elementDiagram = mmird.getElementDiagram();
		
		if (!elementDiagram.isEmpty()){
			  EClass eTypeClassDiagram = (EClass)ModelsUtils.getEObject(modelPack,elementDiagram);
			  if (eClass.getEAllSuperTypes() != null)  
				  return ((eTypeClassDiagram == eClass)||(eClass.getEAllSuperTypes().contains(eTypeClassDiagram)));
			  else return (eTypeClassDiagram == eClass);
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
	public static List<MMInterfaceRelDiagram> getMMInterfaceRelDiagramRefsEClass(List<MMInterfaceRelDiagram> patternRelDiagram, ClassInterface classInterface, int order){

		EClass classObject = getEClass(classInterface);
		
		List<MMInterfaceRelDiagram> refs = new ArrayList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird : patternRelDiagram){
			if ((mmird.getMmInterface() instanceof ReferenceInterface)&&(mmird.getOrderPointer()==order)){
				EReference ref = getEReference((ReferenceInterface)mmird.getMmInterface());
				if (ref.getEType().getName().compareTo(classObject.getName()) ==0)				
					refs.add(mmird);
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
	public static List<MMInterfaceRelDiagram> getMMInterfaceRelDiagramRefsEClassWithoutReflexives(List<MMInterfaceRelDiagram> patternRelDiagram, ClassInterface classInterface, int order){

		EClass classObject = getEClass(classInterface);
		
		List<MMInterfaceRelDiagram> refs = new ArrayList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird : patternRelDiagram){
			if ((mmird.getMmInterface() instanceof ReferenceInterface)&&(mmird.getOrderPointer()==order)){
				EReference ref = getEReference((ReferenceInterface)mmird.getMmInterface());
				if ((ref.getEType().getName().compareTo(classObject.getName()) ==0) 
						&& !(isReflexiveReference((ReferenceInterface)mmird.getMmInterface()) && (order==mmird.getOrder())))				
					refs.add(mmird);
			}
		}
		return refs;
	}
	
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram pointed by the specified ReferenceInterface.
	 * @param patternRelDiagram of the pattern
	 * @param refInterface 
	 * @param order of the MMInterfaceRelDiagram searched.
	 * @return the  MMInterfaceRelDiagram object, if doesn't exist return null.
	 */
	public static MMInterfaceRelDiagram getMMInterfaceRelDiagramRef(List<MMInterfaceRelDiagram> patternRelDiagram, ReferenceInterface refInterface, int order){

		EReference refObject = getEReference(refInterface);
		
		for (MMInterfaceRelDiagram mmird : patternRelDiagram){
			if ((mmird.getMmInterface() instanceof ClassInterface)&&(mmird.getOrder()==order)){
				EClass eClassObject = getEClass((ClassInterface)mmird.getMmInterface());
				if (refObject.getEType().getName().compareTo(eClassObject.getName()) ==0)				
					return mmird;
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
	public static void duplicateStructureReference(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird, int order){
		
		if (mmird.getMmInterface() instanceof ReferenceInterface){
			
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(patternRelDiagram, (ReferenceInterface)mmird.getMmInterface(),mmird.getOrderPointer());
			
			if (mmirdRef != null){
				int orderPointer = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(patternRelDiagram, mmirdRef)+1;
				if (((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(patternRelDiagram,mmird)) || (mmird.getMaxValue()==-1)  )
						&& ((mmirdRef.getMaxValue() > PatternUtils.getNumMMInterfaceRelDiagram(patternRelDiagram,mmirdRef))|| (mmirdRef.getMaxValue()==-1))){
					patternRelDiagram.add(new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), "", orderPointer));
					
					for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
						if (child.getMmInterface() instanceof ReferenceInterface){
							if (((isReflexiveReference((ReferenceInterface)child.getMmInterface())) && (child.getOrder()== child.getOrderPointer()))
									|| (!isContainmentReference((ReferenceInterface)child.getMmInterface())))
								patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)child.getMmInterface(), "", orderPointer, orderPointer));
							else duplicateStructureReference(patternRelDiagram,child,orderPointer);			
						}else {
							if (child.getMmInterface() instanceof FeatureInstance)							
								patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), PatternUtils.getDefaultValue((FeatureInstance)child.getMmInterface()), orderPointer));
							else patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), "", orderPointer));
						}
					}
					patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)mmird.getMmInterface(), "",order ,orderPointer));
				}
			}else {
				//Reference to nothing
				if ((mmird.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagramSameOrder(patternRelDiagram,mmird)) || (mmird.getMaxValue()==-1))
				patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)mmird.getMmInterface(), "",order ,0));
			}
			
		}
	}
	
	/**
	 * Static method that copy the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a classInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 * @param orderPointer of the MMInterfaceRelDiagram which's going to be created
	 */
	public static void duplicateStructureClass(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef, int orderPointer){
		
		if (mmirdRef.getMmInterface() instanceof ClassInterface){
			if ((mmirdRef.getMaxValue() > orderPointer)|| (mmirdRef.getMaxValue()==-1)){
				patternRelDiagram.add(new MMInterfaceRelDiagram(mmirdRef.getMmInterface(), "", orderPointer));
				
				for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
					if (child.getMmInterface() instanceof ReferenceInterface){
						if (((isReflexiveReference((ReferenceInterface)child.getMmInterface())) && (child.getOrder()== child.getOrderPointer()))
								|| (!isContainmentReference((ReferenceInterface)child.getMmInterface())))
							patternRelDiagram.add(new MMInterfaceRelDiagram((ReferenceInterface)child.getMmInterface(), "", orderPointer, orderPointer));
						else duplicateStructureReference(patternRelDiagram,child,orderPointer);			
					}else {
						if (child.getMmInterface() instanceof FeatureInstance)							
							patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), PatternUtils.getDefaultValue((FeatureInstance)child.getMmInterface()), orderPointer));
						else patternRelDiagram.add(new MMInterfaceRelDiagram(child.getMmInterface(), "", orderPointer));
					}
				}
			}
		}
	}
		
	/**
	 * Static method that delete the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a referenceInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmird MMInterfaceRelDiagram which's going to be copy
	 */
	public static void deleteStructureReference(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		
		if (mmird.getMmInterface() instanceof ReferenceInterface){
			
			MMInterfaceRelDiagram  mmirdRef = PatternUtils.getMMInterfaceRelDiagramRef(patternRelDiagram, (ReferenceInterface)mmird.getMmInterface(),mmird.getOrderPointer());
			
				if ((mmirdRef != null)&&(!((isReflexiveReference((ReferenceInterface)mmird.getMmInterface())) && (mmird.getOrder()== mmird.getOrderPointer())))){
					
					for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, mmirdRef)){		
						if (child.getMmInterface() instanceof ReferenceInterface){
							if  (!isContainmentReference((ReferenceInterface)child.getMmInterface()))
								patternRelDiagram.remove(child);
							else deleteStructureReference(patternRelDiagram,child);			
						}else 
							patternRelDiagram.remove(child);

					patternRelDiagram.remove(mmirdRef);
					
					patternRelDiagram.remove(mmird);
				}			
				}else 
					patternRelDiagram.remove(mmird);
		}
	}
	
	/**
	 * Static method that delete the structure pointed by the specified MMInterfaceRelDiagram (it has to contain a referenceInterface, if not, this method doesn't do anything).
	 * @param patternRelDiagram of the pattern
	 * @param mmirdRef MMInterfaceRelDiagram which's going to be copy
	 */
	public static void deleteStructureClass(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmirdRef){						
		if ((mmirdRef.getMinValue() < PatternUtils.getNumMMInterfaceRelDiagram(patternRelDiagram,mmirdRef))){
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
	 * Static method that returns whether the specified referenceInterface is reflexive
	 * @param reference
	 * @return true if it´s reflexive, false whether not.
	 */
	public static boolean isReflexiveReference (ReferenceInterface reference){
		EReference ref = getEReference(reference);
		
		return ref.getEType()== ref.getEContainingClass();
	}
	
	/**
	 * Static method that returns whether the specified referenceInterface is containment
	 * @param reference
	 * @return true if it´s containtment, false whether not.
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
		if ((refI.isContainment()== reference.isContainment()) && (refI.getLowerBound()==reference.getLowerBound()) && (refI.getUpperBound()==reference.getUpperBound()) )
			return true;
		else return false;	
	}
	
	/**
	 * Static method that returns whether the references are compatible, regarding their opposite relationships, 
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
		if (classMMIO.getEAllSuperTypes().size() != 0){
				if (eclass.getEAllSuperTypes().size()!=0){
					String[] parentsA = classMMI.getAdditionalInformation().split(",");
					for (String parent: parentsA){
						MMInterfaceRelDiagram parentClass = PatternUtils.getMMInterfaceRelDiagram(content, parent, /*classMMI.getOrder()*/0);
						if (parentClass != null) if (!hasSuperTypeName(eclass, parentClass.getElementDiagram())) return false;
					}
					return true;
				}return false;
			}return true;			
		}return false;
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
	 * Static method that returns the object ereference pointed by the specified referenceInterface
	 * @param referenceI
	 * @return EReference
	 */
	public static EReference getEReference(ReferenceInterface referenceI) {
		EReference eRef = (EReference)referenceI.getRef();
		URI uriERef =((EReferenceImpl)eRef).eProxyURI();
		EReference ref = (EReference)PatternUtils.getEObjectRef(uriERef.toString());
		return ref;
	}
	
	/**
	 * Static method that returns the object eclass pointed by the specified classInterface
	 * @param classI
	 * @return EClass
	 */
	public static EClass getEClass(ClassInterface classI) {
		EClass eClassRef = (EClass)classI.getRef().get(0);
		URI uriEClass =((EClassImpl)eClassRef).eProxyURI();
		EClass eClass = (EClass)PatternUtils.getEObjectRef(uriEClass.toString());
		return eClass;
	}
	
	/**
	 * Static method that returns the object eattribute pointed by the specified featureInterface
	 * @param featureI
	 * @return EAttribute
	 */
	public static EAttribute getEAttribute(FeatureInterface featureI) {
		EAttribute eAttRef = (EAttribute)featureI.getRef().get(0);
		URI uriEAtt =((EAttributeImpl)eAttRef).eProxyURI();
		EAttribute eAtt= (EAttribute)PatternUtils.getEObjectRef(uriEAtt.toString());
		return eAtt;
	}
	
	/**
	 * Static method that returns the default value of the attribute pointed by the specified featureInstance.
	 * @param featureI
	 * @return default value text
	 */
	public static String getDefaultValue(FeatureInstance featureI) {
		EAttribute eAttRef = (EAttribute)featureI.getRef().get(0);
		URI uriEAtt =((EAttributeImpl)eAttRef).eProxyURI();
		EAttribute eAtt= (EAttribute)PatternUtils.getEObjectRef(uriEAtt.toString());
		return eAtt.getDefaultValueLiteral();
	}
	
	/**
	 * Static method that returns the datatype of the attribute pointed by the specified featureInstance.
	 * @param featureI
	 * @return EDataType
	 */
	public static EDataType getEType(FeatureType featureI) {
		EAttribute eAttRef = (EAttribute)featureI.getRef().get(0);
		URI uriEAtt =((EAttributeImpl)eAttRef).eProxyURI();
		EAttribute eAtt= (EAttribute)PatternUtils.getEObjectRef(uriEAtt.toString());
		return eAtt.getEAttributeType();
	}
	
	/**
	 * Static method that returns the annotations applied to the specified package, so the name of the patterns applied to the metamodel.
	 * @param pack
	 * @return list of annotations.
	 */
	public static List<EAnnotation> getPatternAnnotations (EPackage pack){
		List<EAnnotation> patternAnnotations = new ArrayList<EAnnotation>();
		for (EAnnotation patEAnnot:pack.getEAnnotations()){
			if (patEAnnot.getReferences().size()!= 0){
				patternAnnotations.add(patEAnnot);
			}
		}
		return patternAnnotations;
	}
	
	/**
	 * Recursive static method that returns the annotations to delete if we want to delete the specified annotation.
	 * @param annot
	 * @return list of annotations
	 */
	public static List<EAnnotation> getDeleteAnnotations(EAnnotation annot){
		List<EAnnotation> annotations = new ArrayList<EAnnotation>();
		for (EObject annotChild : annot.getReferences())
			if (annotChild instanceof EAnnotation)
				annotations.addAll(getDeleteAnnotations((EAnnotation)annotChild));
		annotations.add(annot);
		return annotations;
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
	 * @param pattern 
	 * @param name - name of the pattern, can't be the name of the pattern (pattern applies many times)
	 * @param intModel - interfaces Model
	 * @return operation success
	 */
	public static boolean addPatternServicesInfo(List<PatternServiceInfo> patternServiceInfoList, Pattern pattern, String name, Resource intModel  ){
		for (Service service : pattern.getServices()){
			PatternServiceInfo psi = new PatternServiceInfo();
			psi.setPatternName(name);
			psi.setPattern(pattern);
			psi.setService(service);
			psi.setActivated(true);
			
			//Activable
			checkActivableService(psi,patternServiceInfoList,intModel);
						
			//check for updates
			if ((psi.isActivated())&&(psi.getMissing().isEmpty()))addCheckActivableServiceForUpdates(patternServiceInfoList, pattern);
			patternServiceInfoList.add(psi);
		}
		return true;
	}
	
	/**
	 * Static method that checks if a service is activable
	 * @param psi
	 * @param patternServiceInfoList
	 * @param intModel - interface model
	 */
	public static void checkActivableService(PatternServiceInfo psi, List<PatternServiceInfo> patternServiceInfoList, Resource intModel){
		
		psi.getMissing().clear();
		//PLUG-SLOT
		List<Interface> ri = getPlugInterfaces(psi.getService(), intModel);
		for (Interface i: ri){
			if (!slotProvidedByAnotherService(patternServiceInfoList, i, intModel)) {
				psi.getMissing().put(i, getSlotOfferedBy(i, intModel));
			}
		}
		//ACCEPTOR-INJECTOR
		ri = getAcceptorInterfaces(psi.getService(), intModel);
		for (Interface i: ri){
			if (!injectorProvidedByAnotherService(patternServiceInfoList, i, intModel)) {
				psi.getMissing().put(i, getInjectorOfferedBy(i, intModel));
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
			List<Interface> interfsToRemove = new LinkedList<Interface>();
			for (Interface interf : psi.getMissing().keySet()){
				if (containsPattern(pattern, psi.getMissing().get(interf)))
					interfsToRemove.add(interf);
			}
			for (int i=0; i<interfsToRemove.size();i++){
				psi.getMissing().remove(interfsToRemove.get(i));
			}
		}
	}
	
	/**
	 * Static method that check if a service is activable after a delete operation.
	 * @param patternServiceInfoList
	 * @param intModel - interface model
	 */
	public static void deleteCheckActivableServiceForUpdates(List<PatternServiceInfo> patternServiceInfoList, Resource intModel){
		for (PatternServiceInfo psi: patternServiceInfoList){
			checkActivableService(psi, patternServiceInfoList, intModel);
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
	public static boolean deletePatternServicesInfo(List<PatternServiceInfo> patternServiceInfoList, String patternName, Resource intModel){
		
		for (PatternServiceInfo psi: patternServiceInfoList){
			if (psi.getPatternName().compareTo(patternName)==0) 
				patternServiceInfoList.remove(psi);
		}
		deleteCheckActivableServiceForUpdates(patternServiceInfoList, intModel);
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
					if (provInt.equals(interf)) return true;
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
					if (provInt.equals(interf)) return true;
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
	private static List<Pattern> getSlotOfferedBy (Interface interf, Resource intModel){
		List<Pattern> patterns = new LinkedList<Pattern>();
		for (Pattern pattern: getAllPatterns()){
			for (Service service: pattern.getServices()){
				for (Interface interfAux : getSlotInterfaces(service, intModel)){
					if (interfAux.equals(interf)) patterns.add(pattern);
				}
			}
		}
		return patterns;
	}
	
	/**
	 * Static method that returns the patterns that offer the injector interface
	 * @param interf
	 * @param intModel - interface method
	 * @return list of patterns
	 */
	private static List<Pattern> getInjectorOfferedBy (Interface interf, Resource intModel){
		List<Pattern> patterns = new LinkedList<Pattern>();
		for (Pattern pattern: getAllPatterns()){
			for (Service service: pattern.getServices()){
				for (Interface interfAux : getInjectorInterfaces(service, intModel)){
					if (interfAux.equals(interf)) patterns.add(pattern);
				}
			}
		}
		return patterns;
		
	}
	
	/**
	 * Static method that returns all the patterns of the model
	 * @return list of pattern
	 */
	public static List<Pattern> getAllPatterns (){
		List<Pattern> patterns = new LinkedList<Pattern>();
		for (Category cat: getPatternSetModel().getCategories()){
			patterns.addAll(cat.getPatterns());
		}
		return patterns;
	}
	
	/**
	 * Static method that returns the interface model to work
	 * @return resource.
	 */
	public static Resource getInterfaceModel(){
			Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
			IPath relativeIPath = new Path(PatternUtils.RELATIVE_DIR+PatternUtils.PATTERN_INTERFACES_NAME);	
			URL fileInPlugin = FileLocator.find(plugin, relativeIPath, null);

			try {
				URL srcUrl = FileLocator.toFileURL(fileInPlugin);
				File src = new File(srcUrl.getPath());	
				String filename = src.getAbsolutePath();
				URI uri = URI.createFileURI(filename);
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.getResource(uri, true);
				return resource;
			} catch (IOException e) {
				e.printStackTrace();
			}		

		return null;
	}
	
}
