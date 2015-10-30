package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EAnnotation object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEAnnotationFeature extends AbstractCreateFeature {
	
	public CreateEAnnotationFeature(IFeatureProvider fp) {
		super(fp, "Annotation", "Create a new Annotations");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		
		return (getBusinessObjectForPictogramElement(context.getTargetContainer())
				instanceof EModelElement)
				|| (getBusinessObjectForPictogramElement(context.getTargetConnection())
						instanceof EModelElement);
	}

	@Override
	public Object[] create(ICreateContext context) {
		EAnnotation newEAnnotation =	EcoreFactory.eINSTANCE.createEAnnotation();			
		EModelElement modelElement = null;
		if (context.getTargetConnection()!=null)
		 modelElement = (EModelElement) getBusinessObjectForPictogramElement(context.getTargetConnection());
		else 
		 modelElement = (EModelElement) getBusinessObjectForPictogramElement(context.getTargetContainer());
		
		newEAnnotation.setSource(ModelUtils.getAnnotationSourceValid(modelElement));
		modelElement.getEAnnotations().add(newEAnnotation);
		
		return new Object[] { newEAnnotation};
	}
}
