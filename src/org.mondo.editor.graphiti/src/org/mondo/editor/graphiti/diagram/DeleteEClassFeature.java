package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;


/**
 * Class to create an EClass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEClassFeature extends DeleteEModelElementDefaultFeature {
	
	List<EReference> refs = new ArrayList<EReference>();
	public DeleteEClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		PictogramElement pe = context.getPictogramElement();
		EObject eclass = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (eclass instanceof EClass) 
			refs = DiagramUtils.getEReferencesIncoming(getDiagram(), (EClass)eclass);
		for (EReference ref: refs){
			DiagramUtils.deleteCollapseReferenceText(getDiagram(), ref);
		}
	}

	@Override
	public void postDelete(IDeleteContext context) {
		super.postDelete(context);
		for (int i = 0; i<refs.size(); i++){
			EReference ref = refs.get(i);
			
			for (int j = 0; j<ref.getEAnnotations().size(); j++){

				EAnnotation eAnnotation = ref.getEAnnotations().get(j);
				
				DeleteEAnnotationFeature daf = new DeleteEAnnotationFeature(getFeatureProvider(), eAnnotation);
				daf.delete(null);

			}		
			
			ref.getEContainingClass().getEStructuralFeatures().remove(ref);
		}
	}
	
}
