package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to delete an EAnnotation object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEAnnotationFeature extends DeleteEModelElementDefaultFeature {
	private EAnnotation eAnnotation;
	public DeleteEAnnotationFeature(IFeatureProvider fp, EAnnotation annotation) {
		super(fp);
		eAnnotation = annotation;
	}

	@Override
	public void delete(IDeleteContext context){
		if (eAnnotation.getEModelElement() instanceof EClass){
			EPackage pack = ModelUtils.getBusinessModel(getDiagram());
			for (EAnnotation anot : pack.getEAnnotations()){
				anot.getReferences().remove(eAnnotation);
			}
			
		} else if ((eAnnotation.getEModelElement() instanceof EStructuralFeature)){
			EStructuralFeature ef = (EStructuralFeature)eAnnotation.getEModelElement();
			EClass eClass = ef.getEContainingClass();
			for (EAnnotation anot : eClass.getEAnnotations()){
				anot.getReferences().remove(eAnnotation);
			}
			
			//Supertypes
			for (EClass superClass : eClass.getEAllSuperTypes()){
				for (EAnnotation anot : superClass.getEAnnotations()){
					anot.getReferences().remove(eAnnotation);
				}
			}
			
			//Children
			for (EClass child : ModelUtils.getAllChildren(eClass)){
				for (EAnnotation anot : child.getEAnnotations()){
					anot.getReferences().remove(eAnnotation);
				}
			}
		}
		
		(eAnnotation.getEModelElement()).getEAnnotations().remove(eAnnotation);
	}

}
