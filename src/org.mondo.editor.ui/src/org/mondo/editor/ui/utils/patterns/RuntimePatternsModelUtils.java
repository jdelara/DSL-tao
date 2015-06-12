package org.mondo.editor.ui.utils.patterns;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

import dslPatterns.ClassInterface;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureType;
import dslPatterns.Pattern;
import dslPatterns.ReferenceInterface;
import runtimePatterns.ClassRoleInstance;
import runtimePatterns.FeatureRoleInstance;
import runtimePatterns.InstanceFeatureRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.PatternInstances;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.RoleInstance;
import runtimePatterns.RuntimePatternsFactory;
import runtimePatterns.TypeFeatureRoleInstance;

/**
 * Class of utility functions to work with runtime patterns.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class RuntimePatternsModelUtils {
	
	/**
	 * Static method that returns the patternInstances of the diagram, if it doesn't exist this is created.
	 * @param diagramBehavior
	 * @return PatternInstaces object, null if the diagramBehavior is incorrect.
	 */
	public static PatternInstances getPatternInstances(final DiagramBehavior diagramBehavior, boolean create){
		ResourceSet rs = diagramBehavior.getResourceSet();
		List<Resource> res = rs.getResources();
		if (res.size()>=1){
			for (EObject obj: res.get(0).getContents()){
				if (obj instanceof PatternInstances)
					return (PatternInstances)obj;
			}
			if (create){
				diagramBehavior.getEditingDomain().getCommandStack().execute(new RecordingCommand(diagramBehavior.getEditingDomain()) {
					@Override
					protected void doExecute() {
						PatternInstances pis = RuntimePatternsFactory.eINSTANCE.createPatternInstances();
						saveRuntimePatternsInstances(diagramBehavior, pis);
					}	
				});
				
				return getPatternInstances(diagramBehavior, false);
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the list of pattern instances applied to the specified diagram
	 * @param diagramBehavior
	 * @return list of PatternInstance
	 */
	public static List<PatternInstance> getAllAppliedPatterns (DiagramBehavior diagramBehavior){
		PatternInstances pis = getPatternInstances(diagramBehavior, false);
		if (pis != null) return pis.getAppliedPatterns();
		else return new LinkedList<>();
	}
	
	/**
	 * Static method that creates PatternInstace for the given PatternInstances
	 * @param pis PatternInstances
	 * @param ident identifier
	 * @return PatternceInstace object
	 */
	public static PatternInstance createPatternInstance(PatternInstances pis, String ident, Pattern pattern){
		
		PatternInstance pi = RuntimePatternsFactory.eINSTANCE.createPatternInstance();
		pi.setIdent(ident);
		pi.setPattern(pattern);
		pis.getAppliedPatterns().add(pi);
		return pi;
	}
	
	/**
	 * Static method that creates a ClassRoleInstance for the given PatternInstance
	 * @param pi PatternInstance
	 * @param eclass EClass
	 * @param ci ClassInterface
	 * @return ClassRoleInstance object
	 */
	public static ClassRoleInstance createClassRoleInstance(PatternInstance pi, EClass eclass, ClassInterface ci){
		ClassRoleInstance cri = RuntimePatternsFactory.eINSTANCE.createClassRoleInstance();
		cri.setElement(eclass);
		cri.setRole(ci);
		pi.getClassInstances().add(cri);
		return cri;
	}
	
	/**
	 * Static method that creates a ReferenceRoleInstance for the given ClassRoleInstance
	 * @param cri ClassRoleInstance
	 * @param eRef EReference
	 * @param ri ReferenceInterface
	 * @return ReferenceRoleInstance object
	 */
	public static ReferenceRoleInstance createReferenceRoleInstance(ClassRoleInstance cri, EReference eRef, ReferenceInterface ri){
		ReferenceRoleInstance rri = RuntimePatternsFactory.eINSTANCE.createReferenceRoleInstance();
		rri.setElement(eRef);
		rri.setRole(ri);
		cri.getReferenceInstances().add(rri);
		return rri;
	}
	
	/**
	 * Static method that creates TypeFeatureRoleInstance for the given ClassRoleInstance
	 * @param cri ClassRoleInstance
	 * @param eAttr EAttribute
	 * @param ft FeatureType
	 * @return TypeFeatureRoleInstance object
	 */
	public static TypeFeatureRoleInstance createTypeFeatureRoleInstance(ClassRoleInstance cri, EAttribute eAttr, FeatureType ft){
		TypeFeatureRoleInstance tfri = RuntimePatternsFactory.eINSTANCE.createTypeFeatureRoleInstance();
		tfri.setElement(eAttr);
		tfri.setRole(ft);
		cri.getFeatureInstances().add(tfri);
		return tfri;
	}
	
	/**
	 * Static method that creates InstanceFeatureRoleInstance for the given ClassRoleInstance
	 * @param cri ClassRoleInstance
	 * @param fi FeatureInstance
	 * @param value 
	 * @return InstanceFeatureRoleInstance object
	 */
	public static InstanceFeatureRoleInstance createInstanceFeatureRoleInstance(ClassRoleInstance cri, FeatureInstance fi, String value){
		InstanceFeatureRoleInstance ifri = RuntimePatternsFactory.eINSTANCE.createInstanceFeatureRoleInstance();
		ifri.setRole(fi);
		ifri.setValue(value);
		cri.getFeatureInstances().add(ifri);
		return ifri;
	}
	
	/**
	 * Static method that paints on the diagram the information about the pattern.
	 * @param diagramBehavior
	 * @param element
	 * @param patternText
	 */
	public static void paintPatternInformation (DiagramBehavior diagramBehavior, EModelElement element, String patternText){
		
		Diagram diagram = diagramBehavior.getDiagramTypeProvider().getDiagram();
		if (patternText != null){
			String textPic = DiagramUtils.getPatternPictogramText(diagram, element);
			if (textPic != null){
				if ((!textPic.isEmpty())&&(!textPic.endsWith("\n"))) textPic += "\n";
				textPic += "@"+patternText;
				DiagramUtils.paintPatternInfoText(diagramBehavior, element, textPic);
				
			} else if (element instanceof EPackage) {
		    		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		            IGaService gaService = Graphiti.getGaService();
		            
		            ContainerShape container = null;
		    		container = peCreateService.createContainerShape(diagram, true);
		    		
		    		Property markerDelete = MmFactory.eINSTANCE.createProperty();
		    		markerDelete.setKey("delete");
		    		markerDelete.setValue(DiagramUtils.NOT_DELETE);		
		    		container.getProperties().add(markerDelete);
		    		
		    		Property markerRemove = MmFactory.eINSTANCE.createProperty();
		    		markerRemove.setKey("remove");
		    		markerRemove.setValue(DiagramUtils.NOT_REMOVE);		
		    		container.getProperties().add(markerRemove);
		    		
		    		Property markerType = MmFactory.eINSTANCE.createProperty();
		    		markerType.setKey("type");
		    		markerType.setValue(DiagramUtils.TYPE_PATTERN_NAMES);		
		    		container.getProperties().add(markerType);
		    		
		    		Rectangle figure = gaService.createRectangle(container);
		    		figure.setFilled(false);
		    		figure.setLineVisible(false);
		    		gaService.setLocationAndSize(figure, 0, 0, 300, 75);
		    		
		            Shape shapeText = peCreateService.createShape(container, false);
		    		Text text = gaService.createText(shapeText,"@"+patternText);
		    		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		    		gaService.setLocationAndSize(text, 0, 0, 300, 75);
		    		text.setFont(gaService.manageFont(diagram, "Verdana", DiagramStyles.BIG_SIZE_FONT, false, true));
	    		
		    		Property marker = MmFactory.eINSTANCE.createProperty();
		    		marker.setKey("type");
		    		marker.setValue(DiagramUtils.TYPE_INFO_PATTERNS);		
		    		text.getProperties().add(marker);
		    		
		    		shapeText.setVisible(DiagramUtils.isPatternInfo(diagram));		
		    		
		    		diagramBehavior.getDiagramTypeProvider().getFeatureProvider().link(shapeText, element);
		    		
			}
		}
	}
	
	/**
	 * Static method that deletes from the diagram all the information about the pattern
	 * @param diagramB - diagramBehavior
	 * @param pi - patternInstance
	 */
	public static void deletePaintedPatternInformation(DiagramBehavior diagramB, PatternInstance pi){
		Diagram diagram = diagramB.getDiagramTypeProvider().getDiagram();
		for (ClassRoleInstance cri: pi.getClassInstances())
			deletePaintedPatternInformation(diagramB, cri);
		EPackage pack = ModelUtils.getBusinessModel(diagram);
		deletePaintedPatternInformationText(diagramB, pack,  pi.getIdent());
	}
	
	/**
	 * Static method that deletes from the diagram the information about the classRoleInstance
	 * @param diagramB - diagramBehavior
	 * @param ri - classRoleInstance
	 */
	public static void deletePaintedPatternInformation(DiagramBehavior diagramB, ClassRoleInstance ri){
		ClassRoleInstance cri = (ClassRoleInstance)ri;
		for (ReferenceRoleInstance rri: cri.getReferenceInstances())
			deletePaintedPatternInformation(diagramB, cri, rri);
		deletePaintedPatternInformationText(diagramB, cri.getElement(), RuntimePatternsModelUtils.getPatternRoleName(cri));
		
	}
	
	/**
	 * Static method that deletes from the diagram the information about the referenceRoleInstance
	 * @param diagramB - diagramBehavior
	 * @param cri - classRoleInstance
	 * @param ri - referenceRoleInstance
	 */
	public static void deletePaintedPatternInformation(DiagramBehavior diagramB, ClassRoleInstance cri, ReferenceRoleInstance ri){
		String patternText = RuntimePatternsModelUtils.getPatternRoleName(cri)+"/"+RuntimePatternsModelUtils.getPatternRoleName(ri);
		deletePaintedPatternInformationText(diagramB,ri.getElement(),patternText);
	}

	/**
	 * Static method that deletes from the element the given text
	 * @param diagramB - diagramBehavior
	 * @param element - eModelElement
	 * @param patternText
	 */
	private static void deletePaintedPatternInformationText(DiagramBehavior diagramB, EModelElement element, String patternText){
		Diagram diagram = diagramB.getDiagramTypeProvider().getDiagram();
		if ((Graphiti.getLinkService().getPictogramElements(diagram, element).size()>0) || (element instanceof EReference)){
			String text = DiagramUtils.getPatternPictogramText(diagram, element);
			if (text.contains("@"+patternText+"\n"))
			text = text.replaceFirst("@"+patternText+"\n", "");
			else if (text.endsWith("@"+patternText))
				text = text.substring(0,text.length() - (patternText.length()+1));//it's the last one.
			
			DiagramUtils.paintPatternInfoText(diagramB, element, text);
			
		}
	}

	/**
	 * Static method that returns the ClassRoleInstance of the given PatternInstance
	 * @param pi PatternInstance
	 * @param ci ClassInterface
	 * @return ClassRoleInstance, null if doesn't exist.
	 */
	public static ClassRoleInstance getClassRoleInstance (PatternInstance pi, ClassInterface ci, EClass eclass){
		for (ClassRoleInstance cri: pi.getClassInstances()){
			if ((cri.getRole().equals(ci)) && (cri.getElement().equals(eclass))) return cri;
		}
		return null;
	}
	
	/**
	 * Static method that saves the specified PatternInstances within the diagram.
	 * @param diagramBehavior
	 * @param pis PatternInstances
	 */
	public static void saveRuntimePatternsInstances(DiagramBehavior diagramBehavior, PatternInstances pis){
		ResourceSet rs = diagramBehavior.getResourceSet();
		List<Resource> res = rs.getResources();
		if (res.size()>=1){
			res.get(0).getContents().add(pis);
			IResourceUtils.saveResource(res.get(0));
		}
	}
	
	/**
	 * Static method that returns the element related to the the roleInstance
	 * @param ri RoleInstance
	 * @return ENamedElement
	 */
	public static ENamedElement getElement(RoleInstance ri){
		if (ri instanceof ClassRoleInstance)
			return ((ClassRoleInstance) ri).getElement();
		else if (ri instanceof ReferenceRoleInstance)
			return ((ReferenceRoleInstance)ri).getElement();
		else if (ri instanceof TypeFeatureRoleInstance)
			return ((TypeFeatureRoleInstance)ri).getElement();
		return null;
	}
	
	/**
	 * Static method that returns the name of the role
	 * @param ri RoleInstance
	 * @return String
	 */
	public static String getPatternRoleName(RoleInstance ri){
		if (ri instanceof ClassRoleInstance){
			EClass eclass = PatternUtils.getEClass(((ClassRoleInstance)ri).getRole());
			if (eclass!=null)return eclass.getName();
		}
		else if (ri instanceof ReferenceRoleInstance){
			EReference eref = PatternUtils.getEReference(((ReferenceRoleInstance)ri).getRole());
			if (eref!=null)return eref.getName();
		}
		else if (ri instanceof TypeFeatureRoleInstance){
			EAttribute eatt = PatternUtils.getEAttribute(((TypeFeatureRoleInstance)ri).getRole());
			if(eatt!=null)return eatt.getName();
		}
		else if (ri instanceof InstanceFeatureRoleInstance){
			EAttribute eatt = PatternUtils.getEAttribute(((InstanceFeatureRoleInstance)ri).getRole());
			if(eatt!=null)return eatt.getName();
		}
		return "";
	}
	
	/**
	 * Static method to remove a PatternInstance
	 * @param db DiagramBehavior
	 * @param pi PatternInstance
	 * @return operation success
	 */
	public static boolean deletePatternInstance (DiagramBehavior db, PatternInstance pi){
		PatternInstances pis = getPatternInstances(db, false);
		if (pis!=null){
			return pis.getAppliedPatterns().remove(pi);
		}
		return false;
	}
	
	/**
	 * Static method to remove a ClassRoleInstances from its PatternInstance
	 * @param pi PatternInstance
	 * @param cri ClassRoleInstance
	 * @return operation success
	 */
	public static boolean deleteClassRoleInstance (PatternInstance pi, ClassRoleInstance cri ){
		if (pi!=null){
			return pi.getClassInstances().remove(cri);
		}
		return false;
	}
	
	/**
	 * Static method to remove ReferenceRoleInstances from its ClassRoleInstance
	 * @param cri ClassRoleInstance
	 * @param rri ReferenceRoleInstance
	 * @return operation success 
	 */
	public static boolean deleteReferenceRoleInstance (ClassRoleInstance cri, ReferenceRoleInstance rri ){
		if (cri!=null){
			return cri.getReferenceInstances().remove(rri);
		}
		return false;
	}
	
	/**
	 * Static method to remove TypeFeatureRoleInstances from its ClassRoleInstance
	 * @param cri ClassRoleInstance
	 * @param tri TypeFeatureRoleInstance
	 * @return operation success
	 */
	public static boolean deleteTypeFeatureRoleInstance (ClassRoleInstance cri, TypeFeatureRoleInstance tri ){
		if (cri!=null){
			return cri.getFeatureInstances().remove(tri);
		}
		return false;
	}
	
	/**
	 * Static method to remove InstanceFeatureRoleInstance
	 * @param iri InstanceFeatureRoleInstance
	 * @return operation success
	 */
	public static boolean deleteInstanceFeatureRoleInstance (InstanceFeatureRoleInstance iri ){
		if (iri.eContainer()instanceof ClassRoleInstance){
			return ((ClassRoleInstance)iri.eContainer()).getFeatureInstances().remove(iri);
		}
		return false;
	}
	
	/**
	 * Static method that returns if the pattern name has been used
	 * @param pis patternInstances
	 * @param name - pattern name root
	 * @return true if exists, false if not
	 */
	public static boolean existsPatternName(PatternInstances pis, String name){
		for (PatternInstance pi: pis.getAppliedPatterns()){
			if (pi.getIdent().compareTo(name)==0)
        		return true;
		}
		return false;
	}
	
	/**
	 * Static method that provides a valid name for the pattern 
	 * @param pis patternInstances
	 * @param name - pattern name root
	 * @return a string with the name
	 */
	public static String getPatternNameValid(PatternInstances pis, String name){
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsPatternName(pis, (cont!=0?name+cont:name));
		}
		return (cont!=0?name+cont:name);
	}
	
	public static int getNumPatternInstances (DiagramBehavior db, Pattern pattern){
		int cont = 0;
		PatternInstances pis = getPatternInstances(db, false);
		if (pis!=null)
		for (PatternInstance pi: pis.getAppliedPatterns()){
			if (pi.getPattern().getName().compareTo(pattern.getName())==0)
        		cont++;
		}		
		return cont;
	}
	
	public static List<InstanceFeatureRoleInstance> getInstanceFeatureRolesInstances (ClassRoleInstance cri){
		List<InstanceFeatureRoleInstance> ifril = new LinkedList<InstanceFeatureRoleInstance>();
		for (FeatureRoleInstance fi : cri.getFeatureInstances()){
			if (fi instanceof InstanceFeatureRoleInstance)
				ifril.add((InstanceFeatureRoleInstance)fi);
		}
		return ifril;
	}
	
}
