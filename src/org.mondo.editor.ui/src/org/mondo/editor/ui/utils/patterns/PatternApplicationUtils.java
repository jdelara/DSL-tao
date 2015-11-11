package org.mondo.editor.ui.utils.patterns;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.graphiti.diagram.CreateEAttributeFeature;
import org.mondo.editor.graphiti.diagram.CreateEClassFeature;
import org.mondo.editor.graphiti.diagram.CreateEReferenceFeature;
import org.mondo.editor.graphiti.diagram.CreateESuperTypeFeature;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.ui.utils.ModelsUtils;
import org.mondo.editor.ui.utils.services.PatternServiceInfo;
import org.mondo.editor.ui.utils.services.RuntimeServicesModelUtils;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.PatternInstances;
import runtimePatterns.ReferenceRoleInstance;
import dslPatterns.ClassInterface;
import dslPatterns.ClassInterfaceAttached;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureInterfaceAttached;
import dslPatterns.FeatureType;
import dslPatterns.MMInterface;
import dslPatterns.MMInterfaceAttached;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModelAttached;
import dslPatterns.ReferenceInterface;
import dslPatterns.ReferenceInterfaceAttached;

public final class PatternApplicationUtils {

	/**
	 *Static method that applies the pattern according to an user selection.
	 * @param patternRelDiagram
	 * @param diagramBehavior
	 * @param pattern 
	 */
	public static void applyPattern( final List<MMInterfaceRelDiagram> patternRelDiagram, final DiagramBehavior diagramBehavior, final Pattern pattern, final PatternInstances pis, final String patternInstanceName, final boolean attached){
	
		final IFeatureProvider fp = diagramBehavior.getDiagramTypeProvider().getFeatureProvider();

		diagramBehavior.getEditingDomain().getCommandStack().execute(new RecordingCommand(diagramBehavior.getEditingDomain()) {
	
			@Override
			protected void doExecute() {
				EPackage pack = null;
				if (!ModelUtils.existsPackage(diagramBehavior.getDiagramTypeProvider().getDiagram())){
					pack = ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram());
					diagramBehavior.getDiagramTypeProvider().getFeatureProvider().link(diagramBehavior.getDiagramTypeProvider().getDiagram(), pack);
				} else 	pack = ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram());
				
				PatternInstance pi = RuntimePatternsModelUtils.createPatternInstance(pis, patternInstanceName, pattern);
				pi.setAttached(attached);
				RuntimePatternsModelUtils.paintPatternInformation(diagramBehavior, pack, patternInstanceName);

				List<MMInterfaceRelDiagram> newspatternRelDiagram = new LinkedList<MMInterfaceRelDiagram>();
				
				//1. CLASSES
				for (final MMInterfaceRelDiagram info: patternRelDiagram){
					if (info.getMmInterface() instanceof ClassInterface){
						applyClassInterface(patternRelDiagram, diagramBehavior, fp, pi, newspatternRelDiagram, info);
					}
				}
				
				//Abstract inheritance
				//2. ADD NEW ELEMENTS
				patternRelDiagram.addAll(newspatternRelDiagram);

				//3. SUPERTYPES, REFERENCES AND ATTRIBUTES
				for (final MMInterfaceRelDiagram info: patternRelDiagram){
					if (!PatternUtils.isAbstract(info, patternRelDiagram)){
						//SUPERTYPES
						if (info.getMmInterface() instanceof ClassInterface){
							createESuperTypes(patternRelDiagram,diagramBehavior, fp, info);
						}//REFERENCES AND FEATURETYPE
						else if ((info.getMmInterface() instanceof ReferenceInterface) || (info.getMmInterface() instanceof FeatureType)){
							applyEStructuralFeatureInterface(patternRelDiagram,diagramBehavior, fp, pi, info);  
						}	
					}
				}
				
				//4. SERVICE INTERFACE
				IDiagramTypeProvider dtp = diagramBehavior.getDiagramTypeProvider();
				if (dtp instanceof EcoreDiagramTypeProvider){
					Object info = ((EcoreDiagramTypeProvider)dtp).getPatternServicesInfo();
					if(info== null) {
						info = new LinkedList<PatternServiceInfo>();
						((EcoreDiagramTypeProvider)dtp).setPatternServicesInfo(info);
					}
					
					Object intModel = ((EcoreDiagramTypeProvider)dtp).getInterfaceModel();
					IProject project = IResourceUtils.getProject(fp.getDiagramTypeProvider().getDiagram().eResource());
					if(intModel== null) {
						intModel = PatternUtils.getInterfaceModel(project);
						((EcoreDiagramTypeProvider)dtp).setInterfaceModel(intModel);
					}
					if (intModel != null){
						List<PatternServiceInfo> patternServiceInfoList = RuntimeServicesModelUtils.getPatternServicesInfo(diagramBehavior);
						PatternUtils.addPatternServicesInfo(patternServiceInfoList, pi,(Resource)intModel, PatternUtils.getAllPatterns(project));
					}else  {
						MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Service Interface", "Service Interfaces aren't defined.");
					}
				}		
			}
		});
		
	}
	
	/**
	 * Static method that applies a pattern to a class element (if it doesn't exist, it's created)
	 * @param patternRelDiagram - list of current MMInterfaceRelDiagram objects.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param pi - pattern instances
	 * @param newspatternRelDiagram - fill the list with the new elements
	 * @param info - MMInterfaceRelDiagram to apply
	 */
	private static void applyClassInterface(List<MMInterfaceRelDiagram> patternRelDiagram,DiagramBehavior diagramBehavior,IFeatureProvider fp, PatternInstance pi,List<MMInterfaceRelDiagram> newspatternRelDiagram,MMInterfaceRelDiagram info) {
		if (!PatternUtils.isAbstract(info, patternRelDiagram)){
			ClassRoleInstance cri = null; 
			EObject selObj = null; 
			if (ModelUtils.existsPackage(diagramBehavior.getDiagramTypeProvider().getDiagram()))
				selObj = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), info.getElementDiagram());
				if ((selObj == null) ){
				EClass eclass = PatternUtils.getEClass((ClassInterface)info.getMmInterface());

				EClass newEclass = createEClass(diagramBehavior, fp, eclass);
				
				info.setElementDiagram(newEclass.getName());
				selObj = newEclass;
			  }
			
			cri = RuntimePatternsModelUtils.createClassRoleInstance(pi, (EClass) selObj, (ClassInterface)info.getMmInterface());
			RuntimePatternsModelUtils.paintPatternInformation(diagramBehavior, (EClass) selObj, /*info.getTextMMInterfaceRelDiagram()*/RuntimePatternsModelUtils.getPatternRoleName(cri));

			//featureInstances
			for (MMInterfaceRelDiagram child : PatternUtils.getChildren(patternRelDiagram, info)){
				 if (child.getMmInterface() instanceof FeatureInstance){
					RuntimePatternsModelUtils.createInstanceFeatureRoleInstance(cri, (FeatureInstance)child.getMmInterface(), child.getElementDiagram());
				 }
			 }
			
			for (MMInterfaceRelDiagram parent: getSuperTypesAbstract(patternRelDiagram, info)){
				//not neccesary..
				if (PatternUtils.isAbstract(parent, patternRelDiagram)){
					newspatternRelDiagram.addAll(createAttRefAbstractClass(pi, parent,info, diagramBehavior, patternRelDiagram, cri));
				}
			}							
		}
	}

	/**
	 * Static method that applies a pattern to a structural element (if it doesn't exist, it's created)
	 * @param patternRelDiagram - list of current MMInterfaceRelDiagram objects.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param pi - pattern instance
	 * @param info - MMInterfaceRelDiagram
	 */
	private static void applyEStructuralFeatureInterface(List<MMInterfaceRelDiagram> patternRelDiagram,DiagramBehavior diagramBehavior,IFeatureProvider fp, PatternInstance pi,MMInterfaceRelDiagram info) {
		
		EObject selObj = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), info.getElementDiagram());
		if (selObj != null){			
			//get MMInterfaceRelDiagram parent.
			MMInterfaceRelDiagram mmirdClass = info.getParent();

			EObject mmirdEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), mmirdClass.getElementDiagram());
			ClassRoleInstance cri =  RuntimePatternsModelUtils.getClassRoleInstance(pi,(ClassInterface)mmirdClass.getMmInterface(), (EClass)mmirdEClass);
			if (info.getMmInterface() instanceof ReferenceInterface){
				ReferenceRoleInstance ri = RuntimePatternsModelUtils.createReferenceRoleInstance(cri,(EReference)selObj,(ReferenceInterface)info.getMmInterface());
				RuntimePatternsModelUtils.paintPatternInformation(diagramBehavior, (EReference) selObj, /*info.getTextMMInterfaceRelDiagram()*/RuntimePatternsModelUtils.getPatternRoleName(cri)+"/"+RuntimePatternsModelUtils.getPatternRoleName(ri));
			}else RuntimePatternsModelUtils.createTypeFeatureRoleInstance(cri, (EAttribute)selObj, (FeatureType)info.getMmInterface());

		 }else if ((selObj == null)&&(info.getMmInterface() instanceof ReferenceInterface))
			 applyReferenceInterfaceNewObject(patternRelDiagram, diagramBehavior,fp, pi, info);
		 else if ((selObj == null)&&(info.getMmInterface() instanceof FeatureType))
			  applyAttributeInterfaceNewObject(patternRelDiagram,diagramBehavior, fp, pi, info);
	}

	/**
	 * Static method that applies a pattern to an attribute element (the element is created)
	 * @param patternRelDiagram - list of current MMInterfaceRelDiagram objects.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param pi - pattern instance
	 * @param info - MMInterfaaceRelDiagram
	 */
	private static void applyAttributeInterfaceNewObject(List<MMInterfaceRelDiagram> patternRelDiagram,	DiagramBehavior diagramBehavior, IFeatureProvider fp,PatternInstance pi, MMInterfaceRelDiagram info) {
		String refName = info.getTextMMInterfaceRelDiagram();
		String[] cads = refName.split("/");
		if (cads.length == 2) {
			//Get MMInterfaceRelDiagram parent.
			MMInterfaceRelDiagram infoContentEClass =  info.getParent();	
			if (infoContentEClass!=null){
				EObject contentEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoContentEClass.getElementDiagram());
				EAttribute eAttObject = PatternUtils.getEAttribute((FeatureInterface)info.getMmInterface());
				if ((eAttObject != null)&& (eAttObject instanceof EAttribute)){			
					EAttribute newEatt = createEAttribute(diagramBehavior, fp,contentEClass, eAttObject);
					ClassRoleInstance cri =  RuntimePatternsModelUtils.getClassRoleInstance(pi,(ClassInterface)infoContentEClass.getMmInterface(), (EClass)contentEClass);
					RuntimePatternsModelUtils.createTypeFeatureRoleInstance(cri, newEatt, (FeatureType)info.getMmInterface());				
					info.setElementDiagram(infoContentEClass.getElementDiagram()+"/"+newEatt.getName());
				}
			}
		}
	}

	/**
	 * Static method that applies a pattern to a reference element (the element is created)
	 * @param patternRelDiagram  - list of current MMInterfaceRelDiagram objects.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param pi - pattern instance
	 * @param info - MMInterfaceRelDiagram
	 */
	private static void applyReferenceInterfaceNewObject(List<MMInterfaceRelDiagram> patternRelDiagram,	DiagramBehavior diagramBehavior, IFeatureProvider fp,PatternInstance pi, MMInterfaceRelDiagram info) {
	
		String refName = info.getTextMMInterfaceRelDiagram();
		String[] cads = refName.split("/");
		if (cads.length == 2) {
			
			//Get MMInterfaceRelDiagram parent.
			MMInterfaceRelDiagram infoContentEClass =  info.getParent();
			String classAnnot = infoContentEClass.getTextMMInterfaceRelDiagram();
			
			if (infoContentEClass!=null){
				final EObject contentEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoContentEClass.getElementDiagram());
				EObject eRefObject = PatternUtils.getEReference((ReferenceInterface)info.getMmInterface());
				boolean created=false;
				if ((eRefObject != null)&& (eRefObject instanceof EReference)&&(((EReference)eRefObject).getEOpposite()!= null)){
					EReference patternOpposite = ((EReference)eRefObject).getEOpposite();
					//eopposite
					String nameOpposite = patternOpposite.getEContainingClass().getName()+"/"+patternOpposite.getName();
					MMInterfaceRelDiagram mmirdOpposite = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, nameOpposite, info.getOrder());
		
					if (!mmirdOpposite.getElementDiagram().isEmpty() || PatternUtils.isAbstract(mmirdOpposite, patternRelDiagram)){
			
						List<EReference> refOps = new LinkedList<EReference>();
						if (!mmirdOpposite.getElementDiagram().isEmpty()){
							EReference refOp = (EReference) ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), mmirdOpposite.getElementDiagram());
							refOps.add(refOp);
						} else {
							//new children refs
							for (MMInterfaceRelDiagram subType: PatternUtils.getSubTypesConcrete(patternRelDiagram,PatternUtils.getFirstMMInterfaceRelDiagram(patternRelDiagram, patternOpposite.getEContainingClass().getName(), mmirdOpposite.getOrder()))){
								EClass subtypeC = (EClass) ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), subType.getElementDiagram());
								String nameOppositeS = subtypeC.getName()+"/"+patternOpposite.getName();
								MMInterfaceRelDiagram mmirdref = PatternApplicationUtils.getMMmInterfaceRelDiagramPrefixElement(patternRelDiagram, nameOppositeS, subType.getOrder());
								EReference refOp = (EReference) ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), mmirdref.getElementDiagram());
								refOps.add(refOp);
							}
						}
				
						for (EReference refOp:refOps){
							EReference newRef= DiagramUtils.createEOppositeReference(refOp,(EReference)eRefObject,diagramBehavior.getDiagramTypeProvider().getDiagram());
							MMInterfaceRelDiagram mmirdClass = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
							ClassRoleInstance cri =  RuntimePatternsModelUtils.getClassRoleInstance(pi,(ClassInterface)mmirdClass.getMmInterface(), (EClass)contentEClass);
							ReferenceRoleInstance ri = RuntimePatternsModelUtils.createReferenceRoleInstance(cri,newRef,(ReferenceInterface)info.getMmInterface());
							RuntimePatternsModelUtils.paintPatternInformation(diagramBehavior, newRef, /*info.getTextMMInterfaceRelDiagram()*/RuntimePatternsModelUtils.getPatternRoleName(cri)+"/"+RuntimePatternsModelUtils.getPatternRoleName(ri));
							created = true;
							info.setElementDiagram(newRef.getEContainingClass().getName()+"/"+newRef.getName());
						}
					}
				}
		
				if ((!created)&&(eRefObject != null)&& (eRefObject instanceof EReference)){										
			
					MMInterfaceRelDiagram infoETypeEClass = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, ((EReference)eRefObject).getEType().getName(), info.getOrderPointer());
					
					//abstract class
					if (infoETypeEClass==null) 
						infoETypeEClass = info.getToConcreteSubtype();

					if (infoETypeEClass != null){//Reference pointed to nothing it isn't painted
						List<MMInterfaceRelDiagram> eTypeMmirds = new LinkedList<MMInterfaceRelDiagram>();
						if (!PatternUtils.isAbstract(infoETypeEClass, patternRelDiagram))
							eTypeMmirds.add(infoETypeEClass);
						else 
							if (info.getToConcreteSubtype()==null){
								//eTypeEClass has to be the children. //14/05-direct????
								if (PatternUtils.isDirectReflexiveReference(patternRelDiagram, info))
									eTypeMmirds.add(info.getParent());
								else 
									for (MMInterfaceRelDiagram subType: PatternUtils.getSubTypesConcrete(patternRelDiagram, infoETypeEClass))
										eTypeMmirds.add(subType);
							}else {
								//if the target isn`t be deleted.
								if (patternRelDiagram.contains(info.getToConcreteSubtype()))eTypeMmirds.add(info.getToConcreteSubtype());
							}
						
						for (MMInterfaceRelDiagram eTypeMmird: eTypeMmirds){
							EObject eTypeEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), eTypeMmird.getElementDiagram());
							EReference eReference = createEReference(diagramBehavior,fp, contentEClass,eRefObject,eTypeEClass);
							MMInterfaceRelDiagram mmirdClass = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, classAnnot, info.getOrder());
							
							ClassRoleInstance cri =  RuntimePatternsModelUtils.getClassRoleInstance(pi,(ClassInterface)mmirdClass.getMmInterface(),(EClass)contentEClass);
							ReferenceRoleInstance ri = RuntimePatternsModelUtils.createReferenceRoleInstance(cri,eReference,(ReferenceInterface)info.getMmInterface());
							RuntimePatternsModelUtils.paintPatternInformation(diagramBehavior, eReference, /*info.getTextMMInterfaceRelDiagram()*/RuntimePatternsModelUtils.getPatternRoleName(cri)+"/"+RuntimePatternsModelUtils.getPatternRoleName(ri));
							
							info.setElementDiagram(eReference.getEContainingClass().getName()+"/"+eReference.getName());
						}
					}
				}
			}
		 }
	}
	
	/**
	 * Static method that creates a structure with the information of the patternMetamodelAttached and the related elements (patternRelDiagram)
	 * @param pma
	 * @param patternRelDiagram
	 * @param iproject
	 * @return a list of MMInterfaceRelDiagram
	 */
	public static List<MMInterfaceRelDiagram> createPatternAttachedStructure (PatternMetaModelAttached pma, List<MMInterfaceRelDiagram> patternRelDiagram){
		List<MMInterfaceRelDiagram> patternStructure = new LinkedList<MMInterfaceRelDiagram>();
		
		if (pma!=null)
		  for (ClassInterfaceAttached cia: pma.getClassIntAtt()){ 
			  ClassInterface ci = (ClassInterface)cia.getType();
			  if (PatternUtils.existsEClass(ci)){
				  for (MMInterfaceRelDiagram atElement: getMmInterfaceRelDiagramAttached(patternRelDiagram, cia)){
					  String elementDiagram = "";
					  if (atElement != null)elementDiagram = atElement.getElementDiagram();
					  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ci, elementDiagram, patternStructure);
					  patternStructure.add(relElement);
					  
					  //References
					  for (ReferenceInterfaceAttached ria: cia.getRefIntAtt()){  
						  ReferenceInterface ri = (ReferenceInterface) ria.getType();
						  if (PatternUtils.existsEReference(ri)){
							  
							  for (MMInterfaceRelDiagram atElementR:getMmInterfaceRelDiagramAttached(patternRelDiagram, ria)){
								  String elementDiagramR = "";
								  if (atElementR != null){
									  if (atElementR.getParent().equals(atElement)){
										  elementDiagramR = atElementR.getElementDiagram();
										  MMInterfaceRelDiagram relElementR = new MMInterfaceRelDiagram(ri, elementDiagramR, patternStructure, relElement);
										  patternStructure.add(relElementR);
									  }
								  } else {
									  MMInterfaceRelDiagram relElementR = new MMInterfaceRelDiagram(ri, elementDiagramR, patternStructure, relElement);
									  patternStructure.add(relElementR);
								  }
							  }
							  
						  }
					  }
					  
					  for (FeatureInterfaceAttached fia: cia.getFeatIntAtt()){  
						  FeatureInterface fi = (FeatureInterface) fia.getType();
						  if (PatternUtils.existsEAttribute(fi))
							  if (fi instanceof FeatureType){
								  
								  for(MMInterfaceRelDiagram atElementF : getMmInterfaceRelDiagramAttached(patternRelDiagram, fia)){
									  String elementDiagramF = "";
									  if (atElementF!=null){
										  if (atElementF.getParent().equals(atElement)){
											  elementDiagramF = atElementF.getElementDiagram();
										  	  MMInterfaceRelDiagram relElementF = new MMInterfaceRelDiagram(fi,elementDiagramF, patternStructure, relElement);
										  	  patternStructure.add(relElementF);
										  }
									  }else {
										  MMInterfaceRelDiagram relElementF = new MMInterfaceRelDiagram(fi,elementDiagramF, patternStructure, relElement);
									  	  patternStructure.add(relElementF);
									  }
								  }
							  
							  }else {//FeatureInstance
								  MMInterfaceRelDiagram relElementF = new MMInterfaceRelDiagram(fi, getFeatureInstanceValue(cia, (FeatureInstance)fi), patternStructure, relElement);
								  patternStructure.add(relElementF);
							  }
					  }
				  }
			  }
		  }
		return patternStructure;
	}
	
	/**
	 * Static method that returns the value of the classInterfaceAttached instance for the given featureinstance
	 * @param cia ClassInterfaceAttached
	 * @param fi featureIntance
	 * @return an string with the value
	 */
	private static String getFeatureInstanceValue (ClassInterfaceAttached cia, FeatureInstance fi){
		//Features
		EObjectImpl objImp = (EObjectImpl)cia.getValue();
		if (objImp != null){
			EClass classXMI = (EClass)objImp.eClass();
	  		EAttribute attFI = fi.getRef().get(0);
	  		for (EAttribute att:classXMI.getEAllAttributes() ){
	  			if (att.getName().compareTo(attFI.getName())==0)
	  				return objImp.eGet(att).toString();
	  		}
		}
		return null;
	}
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram objects pointed by the given MMInterfaceAttached of the list "patternRelDiagram"
	 * @param patternRelDiagram
	 * @param mmia MMInterfaceAttached
	 * @return list of MMInterfaceRelDiagram objects
	 */
	private static List<MMInterfaceRelDiagram> getMmInterfaceRelDiagramAttached (List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceAttached mmia){
		
		List<MMInterfaceRelDiagram> mmirdL = new LinkedList<MMInterfaceRelDiagram>();
		if (mmia.getAttached().size()==0) mmirdL.add(null);
		else for (MMInterface mmi : mmia.getAttached()){
			List<MMInterfaceRelDiagram> mmirds = getMmInterfaceRelDiagram (patternRelDiagram, mmi);
			if (mmirds.size()!=0) mmirdL.addAll(mmirds);
		}
		return mmirdL;
	}
	
	/**
	 * Static method that returns the MMInterfaceRelDiagram object related to the mminterface of the list "patternRelDiagram"
	 * @param patternRelDiagram
	 * @param mmi MMInterface
	 * @return List of MMInterfaceRelDiagram objects
	 */
	public static List<MMInterfaceRelDiagram> getMmInterfaceRelDiagram (List<MMInterfaceRelDiagram> patternRelDiagram, MMInterface mmi){
		List<MMInterfaceRelDiagram> mmirdL = new LinkedList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird : patternRelDiagram){
			if (mmird.getMmInterface().equals(mmi)) mmirdL.add(mmird);
		}
		return mmirdL;
	}
	
	/**
	 * Static method that returns if the mmird object has the object "child" as a child.
	 * @param mmird
	 * @param child
	 * @return boolean true if has a child, false if not.
	 */
	private static boolean hasSimilarChild (MMInterfaceRelDiagram mmird, MMInterfaceRelDiagram child){
		for (MMInterfaceRelDiagram auxChild: mmird.getChildren()){
			if ((auxChild.getMmInterface().equals(child.getMmInterface())) 
				&&(auxChild.getOrderPointer() == child.getOrderPointer()))
					return true;
		}
		return false;
	}
	
	/**
	 * Static method that copy and create attributes and references of an abstract class to their children.
	 * @param pi
	 * @param abstractParent
	 * @param eclass
	 * @param eclassI
	 * @param diagramBehavior
	 * @param patternRelDiagram
	 * @return list of MMInterfaceRelDiagram objects
	 */
	private static List<MMInterfaceRelDiagram> createAttRefAbstractClass(PatternInstance pi, MMInterfaceRelDiagram abstractParent,MMInterfaceRelDiagram info, DiagramBehavior diagramBehavior, List<MMInterfaceRelDiagram> patternRelDiagram, ClassRoleInstance cri ){
		List<MMInterfaceRelDiagram> newspatternRelDiagram = new LinkedList<MMInterfaceRelDiagram>();

		for (MMInterfaceRelDiagram parent: getSuperTypesAbstract(patternRelDiagram, info)){					
			List<MMInterfaceRelDiagram> source = PatternUtils.getChildren(patternRelDiagram, parent);
			
			for (MMInterfaceRelDiagram mmird : source){
				
				if (!hasSimilarChild(info, mmird)){
					if (mmird.getMmInterface() instanceof FeatureType){
						newspatternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), "",mmird.getOrder(), patternRelDiagram, info));					
					} else if (mmird.getMmInterface() instanceof FeatureInstance){
						newspatternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), mmird.getElementDiagram(), mmird.getOrder(),patternRelDiagram, info));
						RuntimePatternsModelUtils.createInstanceFeatureRoleInstance(cri, (FeatureInstance)mmird.getMmInterface(), mmird.getElementDiagram());
					}
					else if (mmird.getMmInterface() instanceof ReferenceInterface){					
						MMInterfaceRelDiagram mmirdRef = new MMInterfaceRelDiagram(mmird.getMmInterface(), "", mmird.getOrder(), mmird.getOrderPointer(),patternRelDiagram, info);
						
						if ((PatternUtils.isDirectReflexiveReference(patternRelDiagram,mmird))
								|| (mmird.getToConcreteSubtype()==parent)) 
							mmirdRef.setToConcreteSubtype(info);
						newspatternRelDiagram.add(mmirdRef);
					}
				}
			}
		}
		return newspatternRelDiagram;
	}
	
	/**
	 * Static method that copy into info the children inherited by an abstract class.
	 * @param patternRelDiagram
	 * @param info
	 */
	public static void copyAttRefParentAbstractClasses(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram info){
		
		for (MMInterfaceRelDiagram parent: getSuperTypesAbstract(patternRelDiagram, info)){					
			List<MMInterfaceRelDiagram> source = PatternUtils.getChildren(patternRelDiagram, parent);
			
			for (MMInterfaceRelDiagram mmird : source){
				
				if (!hasSimilarChild(info, mmird)){
					if (mmird.getMmInterface() instanceof FeatureType){
						patternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), "",mmird.getOrder(), patternRelDiagram, info));					
					} else if (mmird.getMmInterface() instanceof FeatureInstance){
						patternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), mmird.getElementDiagram(), mmird.getOrder(),patternRelDiagram, info));
					}
					else if (mmird.getMmInterface() instanceof ReferenceInterface){
						MMInterfaceRelDiagram mmirdRef = new MMInterfaceRelDiagram(mmird.getMmInterface(), "", mmird.getOrder(), mmird.getOrderPointer(),patternRelDiagram, info);
						
						if ((PatternUtils.isDirectReflexiveReference(patternRelDiagram, mmird))
								|| (mmird.getToConcreteSubtype()==parent)) 
							mmirdRef.setToConcreteSubtype(info);
						
						patternRelDiagram.add(mmirdRef);
					}
				}
			}
		}
	}
	
	/**
	 * Static method that copy into info the children info its atts and refs.
	 * @param patternRelDiagram
	 * @param info
	 */
	public static void copyAttRefClassChildren(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram info){
		
		List<MMInterfaceRelDiagram> source = PatternUtils.getChildren(patternRelDiagram, info);
		for (MMInterfaceRelDiagram child: PatternUtils.getSubTypes(patternRelDiagram, info)){
			for (MMInterfaceRelDiagram mmird : source){	
				if (!hasSimilarChild(child, mmird)){
					if (mmird.getMmInterface() instanceof FeatureType){
						patternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), "",mmird.getOrder(), patternRelDiagram, child));					
					} else if (mmird.getMmInterface() instanceof FeatureInstance){
						patternRelDiagram.add(new MMInterfaceRelDiagram(mmird.getMmInterface(), mmird.getElementDiagram(), mmird.getOrder(),patternRelDiagram, child));
					}
					else if (mmird.getMmInterface() instanceof ReferenceInterface){
						MMInterfaceRelDiagram mmirdRef = new MMInterfaceRelDiagram(mmird.getMmInterface(), "", mmird.getOrder(), mmird.getOrderPointer(),patternRelDiagram, child);
						
						if ((PatternUtils.isDirectReflexiveReference(patternRelDiagram,mmird)
								|| (mmird.getToConcreteSubtype()==info))) 
								mmirdRef.setToConcreteSubtype(child);
						
						patternRelDiagram.add(mmirdRef);
					}
				}
			}
		}
	}
	
	/**
	 * Static method that create the references that pointed to the concrete children of the abstract class pointed to
	 * @param patternRelDiagram
	 * @param info
	 */
	public static void createConcreteRefs(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram info){
		
		EObject eRefObject = PatternUtils.getEReference((ReferenceInterface)info.getMmInterface());
		MMInterfaceRelDiagram infoETypeEClass = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, ((EReference)eRefObject).getEType().getName(), info.getOrderPointer());
		
		for (MMInterfaceRelDiagram subType: PatternUtils.getSubTypesConcrete(patternRelDiagram, infoETypeEClass)){
			if (info.getToConcreteSubtype() == null){
				info.setToConcreteSubtype(subType);
			}else{
				MMInterfaceRelDiagram mmird = new MMInterfaceRelDiagram((ReferenceInterface)info.getMmInterface(), "", info.getOrder(), subType.getOrder(), patternRelDiagram, info.getParent());
				mmird.setToConcreteSubtype(subType);
				patternRelDiagram.add(mmird);
			}
		}
	}
	
	/**
	 * Static method that update the concrete refs with the current situation of the pattern.
	 * @param patternRelDiagram
	 * @param info
	 */
	public static void refreshConcreteRefs(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram info){
		
		EObject eRefObject = PatternUtils.getEReference((ReferenceInterface)info.getMmInterface());
		MMInterfaceRelDiagram infoETypeEClass = PatternUtils.getMMInterfaceRelDiagram(patternRelDiagram, ((EReference)eRefObject).getEType().getName(), info.getOrderPointer());
		List<MMInterfaceRelDiagram> infoSib = getConcreteRefsSib(patternRelDiagram, info);
		List<MMInterfaceRelDiagram> subtypes = PatternUtils.getSubTypesConcrete(patternRelDiagram, infoETypeEClass);
		
		//Add new ones.
		for (MMInterfaceRelDiagram subType: subtypes){
			MMInterfaceRelDiagram mmirdSubtype = getMmirdToConcreteSubtype(infoSib, subType);
			if (mmirdSubtype ==  null){
				MMInterfaceRelDiagram mmird = new MMInterfaceRelDiagram((ReferenceInterface)info.getMmInterface(), "", info.getOrder(), subType.getOrder(), patternRelDiagram, info.getParent());
				mmird.setToConcreteSubtype(subType);
				patternRelDiagram.add(mmird);
			}
		}
		//Delete.
		for (MMInterfaceRelDiagram sib: infoSib){
			if (!subtypes.contains(sib.getToConcreteSubtype())) {
				patternRelDiagram.remove(sib);
				sib.getParent().getChildren().remove(sib);
			}
		}
	}
	
	/**
	 * Static method that returns the siblings of a mminterfacereldiagram object, that means the children of its father that pointed to the same interface. 
	 * @param patternRelDiagram
	 * @param info
	 * @return list of MMInterfaceRelDiagram objects
	 */
	private static List<MMInterfaceRelDiagram> getConcreteRefsSib(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram info){
		List<MMInterfaceRelDiagram> list = new LinkedList<MMInterfaceRelDiagram>();
		for (MMInterfaceRelDiagram mmird : info.getParent().getChildren()){
			if (info.getMmInterface().equals(mmird.getMmInterface()))
				list.add(mmird);
		}
		return list;
	}
	
	/**
	 * Static method that returns the mmird object whose concreteSubtype is mmird object.
	 * @param patternRelDiagram
	 * @param mmird
	 * @return MMInterfaceRelDiagram object 
	 */
	private static MMInterfaceRelDiagram getMmirdToConcreteSubtype(List<MMInterfaceRelDiagram> patternRelDiagram, MMInterfaceRelDiagram mmird){
		for (MMInterfaceRelDiagram aux: patternRelDiagram){
			if (aux.getToConcreteSubtype() != null) if (aux.getToConcreteSubtype().equals(mmird)) return aux;
		}
		return null;
	}
	
	/**
	 * Static method that returns the mminterfacereldiagram whose elementDiagram name starts with the given text.
	 * @param patternRelDiagram list of MMInterdaceRelDiagram objects
	 * @param text elementDiagram prefix
	 * @param order 
	 * @return MMInterfaceRelDiagram object 
	 */
	private static MMInterfaceRelDiagram getMMmInterfaceRelDiagramPrefixElement(List<MMInterfaceRelDiagram> patternRelDiagram, String text, int order){
		for (MMInterfaceRelDiagram mmird: patternRelDiagram){
			  if ((mmird.getElementDiagram().startsWith(text))&& (mmird.getOrder()==order)){
				  return mmird;
			  }
		}
		return null;
	}

	/**
	 * Static method that returns the "abstract" supertypes related to a class interface.
	 * @param content
	 * @param classMMI
	 * @return list os supertypes (MMInterfaceRelDiagram)
	 */
	public static List<MMInterfaceRelDiagram> getSuperTypesAbstract(List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI){
		List<MMInterfaceRelDiagram> superTypes = new LinkedList<MMInterfaceRelDiagram>();
		if (classMMI.getMmInterface() instanceof ClassInterface){
			EClass eclass = PatternUtils.getEClass((ClassInterface)classMMI.getMmInterface());
			for (EClass parent: eclass.getESuperTypes()){
				MMInterfaceRelDiagram superType = PatternUtils.getFirstMMInterfaceRelDiagram(content, parent.getName(), classMMI.getOrderPointer());
				
				if (superType==null) superType =  PatternUtils.getFirstMMInterfaceRelDiagram(content, parent.getName(), 0);
				
				if (superType!= null){
					if (PatternUtils.isAbstract(superType, content)) {
						superTypes.addAll(getSuperTypesAbstract(content, superType));
						superTypes.add(superType);
					}
				}
			}
		}return superTypes;
	}

	/**
	 * Static method that returns the (no "abstract") supertypes related to a class interface.
	 * @param content
	 * @param classMMI
	 * @return list os supertypes (MMInterfaceRelDiagram)
	 */
	public static List<MMInterfaceRelDiagram> getSuperTypesConcrete(List<MMInterfaceRelDiagram> content, MMInterfaceRelDiagram classMMI){
		List<MMInterfaceRelDiagram> superTypes = new LinkedList<MMInterfaceRelDiagram>();
		if (classMMI.getMmInterface() instanceof ClassInterface){
			EClass eclass = PatternUtils.getEClass((ClassInterface)classMMI.getMmInterface());
			for (EClass parent: eclass.getESuperTypes()){
				MMInterfaceRelDiagram superType = PatternUtils.getFirstMMInterfaceRelDiagram(content, parent.getName(), classMMI.getOrderPointer());
				if (superType!= null)
					//Multilevel???
					if (PatternUtils.isAbstract(superType, content)) {
						superTypes.addAll(getSuperTypesConcrete(content, superType));
					} else superTypes.add(superType);
			}
		}return superTypes;
	}

	/**
	 * Static method that creates a reference with the information of the given reference into the diagram.
	 * @param diagramBehavior
	 * @param fp - featureProvider
	 * @param contentEClass - source class
	 * @param eRefObject - reference to copy
	 * @param eTypeEClass - target class
	 * @return an ereference object
	 */
	private static EReference createEReference(DiagramBehavior diagramBehavior,IFeatureProvider fp, EObject contentEClass,EObject eRefObject, EObject eTypeEClass) {
		CreateConnectionContext cc = new CreateConnectionContext();
		Anchor sourceAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)contentEClass);
		Anchor targetAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)eTypeEClass);

		cc.setSourceAnchor(sourceAnc);
		cc.setTargetAnchor(targetAnc);
		CreateEReferenceFeature crf = new CreateEReferenceFeature(fp, ((EReference)eRefObject).getName());
		
		cc.putProperty("EREFERENCE", (EReference)eRefObject);

		Connection con = crf.create(cc);

		EReference eReference = (EReference)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
		
		
		return eReference;
	}
	
	/**
	 * Static method that creates an eclass with the information of the given class into the diagram
	 * @param diagramBehavior
	 * @param fp - featureProvider
	 * @param eclass 
	 * @return an eclass object
	 */
	private static EClass createEClass(DiagramBehavior diagramBehavior,IFeatureProvider fp, EClass eclass) {
		CreateContext cc = new CreateContext();
		CreateEClassFeature ccf = new CreateEClassFeature(fp,eclass.getName(), eclass.isAbstract());
		Object[] eClasses = ccf.create(cc);
		
		AddContext ac = new AddContext();
		ac.setLocation(100, 100);
		ac.setTargetContainer(diagramBehavior.getDiagramTypeProvider().getDiagram());
		ac.setNewObject(eClasses[0]);
		fp.getAddFeature(ac).add(ac);
		return (EClass)eClasses[0];
	}
	
	/**
	 * Static method that creates an ereference with the information of the given eattribute.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param contentEClass - containment class
	 * @param eAttObject - attribute 
	 * @return eattribute object
	 */
	private static EAttribute createEAttribute(DiagramBehavior diagramBehavior,IFeatureProvider fp,EObject contentEClass, EAttribute eAttObject) {
		CreateContext cc = new CreateContext();

		ContainerShape cs = DiagramUtils.getTargetContainer(diagramBehavior.getDiagramTypeProvider().getDiagram(), (EClass)contentEClass);
		cc.setTargetContainer(cs);
		CreateEAttributeFeature crf = new CreateEAttributeFeature(fp, eAttObject.getName());
		Object[] atts = crf.create(cc);									
		
		((EAttribute)atts[0]).setEType(eAttObject.getEType());
		((EAttribute)atts[0]).setLowerBound(eAttObject.getLowerBound());
		((EAttribute)atts[0]).setUpperBound(eAttObject.getUpperBound());
		((EAttribute)atts[0]).setUnique(eAttObject.isUnique());
		((EAttribute)atts[0]).setID(eAttObject.isID());
		((EAttribute)atts[0]).setOrdered(eAttObject.isOrdered());

		return (EAttribute)atts[0];
	}
	
	/**
	 * Static method that creates a hierarchical reference between two classes.
	 * @param diagramBehavior
	 * @param fp - feature provider.
	 * @param contentEClass - child class
	 * @param eTypeEClass - parent class
	 */
	private static void createESuperType(DiagramBehavior diagramBehavior,IFeatureProvider fp, EObject contentEClass,EObject eTypeEClass) {
		CreateConnectionContext ccc = new CreateConnectionContext();
		Anchor sourceAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(), ((EClass)contentEClass));
		
		Anchor targetAnc = DiagramUtils.getAnchor(diagramBehavior.getDiagramTypeProvider().getDiagram(),(EClass)eTypeEClass);
		ccc.setSourceAnchor(sourceAnc);
		ccc.setTargetAnchor(targetAnc);
		CreateESuperTypeFeature crf = new CreateESuperTypeFeature(fp);
		crf.create(ccc);
	}

	/**
	 * Static method that creates the supertype references from a MMInterfaceRelDiagram object.
	 * @param patternRelDiagram - list of current MMInterfaceRelDiagram objects.
	 * @param diagramBehavior
	 * @param fp - feature provider
	 * @param info - MMInterfaceRelDiagram to apply
	 */
	private static void createESuperTypes(List<MMInterfaceRelDiagram> patternRelDiagram, DiagramBehavior diagramBehavior,IFeatureProvider fp, MMInterfaceRelDiagram info) {
		//Inheritance association.
		EObject contentEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), info.getElementDiagram());

		for (MMInterfaceRelDiagram infoESuperEClass: getSuperTypesConcrete(patternRelDiagram, info)){
			EObject eTypeEClass = ModelsUtils.getEObject(ModelUtils.getBusinessModel(diagramBehavior.getDiagramTypeProvider().getDiagram()), infoESuperEClass.getElementDiagram());
			//important!! create when it doesn't exist
			if (!((EClass)contentEClass).getEAllSuperTypes().contains(eTypeEClass)){
				createESuperType(diagramBehavior, fp,contentEClass, eTypeEClass);
			}			
		}
	}
}
