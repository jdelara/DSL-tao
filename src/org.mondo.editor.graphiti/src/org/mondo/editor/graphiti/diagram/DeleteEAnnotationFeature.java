package org.mondo.editor.graphiti.diagram;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.Utils;


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
		
		if (Graphiti.getLinkService().getPictogramElements(getDiagram(), eAnnotation).size()>0){
			String text = DiagramUtils.getEAnnotationPictogramText(getDiagram(), eAnnotation);
			if (text.contains("@"+eAnnotation.getSource()+"\n"))
			text = text.replaceFirst("@"+eAnnotation.getSource()+"\n", "");
			else if (text.endsWith("@"+eAnnotation.getSource()))
				text = text.substring(0,text.length() - (eAnnotation.getSource().length()+1));//it's the last one.
			
			PictogramElement pe = DiagramUtils.paintEAnnotationText(getDiagram(), eAnnotation, text);
			
			if (pe!=null) {
				Object[] businessObjects = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(pe);
				Object[] newBusinessObjects = Utils.removeObjectArray(businessObjects, eAnnotation);
				
				if (eAnnotation.getEModelElement() instanceof EClass){
					for (Map.Entry<String,String> entry: eAnnotation.getDetails()){
						newBusinessObjects = Utils.removeObjectArray(newBusinessObjects, (EStringToStringMapEntryImpl)entry);
					}
				}

				link(pe, newBusinessObjects);
				
				//Pattern text. if is the last one, we delete the pictogram.
				if (eAnnotation.getEModelElement() instanceof EPackage){
					if (newBusinessObjects.length == 1){
						link(pe, null);
						DeleteContext dc = new DeleteContext(((Shape)pe).getContainer());
						DefaultDeleteFeature ddf = new DefaultDeleteFeature(getFeatureProvider());
						ddf.execute(dc);
					}
				}
			}
			
		}
		(eAnnotation.getEModelElement()).getEAnnotations().remove(eAnnotation);
	}

}
