package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an eAttribute object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEAttributeFeature extends AbstractCreateFeature {

	public CreateEAttributeFeature(IFeatureProvider fp) {
		super(fp, "Attribute", "Create a new Attribute");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return getBusinessObjectForPictogramElement(context.getTargetContainer())
				instanceof EClass;
	}

	@Override
	public Object[] create(ICreateContext context) {
		EAttribute newEAttribute =	EcoreFactory.eINSTANCE.createEAttribute();			
		EClass eClass = (EClass) getBusinessObjectForPictogramElement(context.getTargetContainer());
		
		String name = null;
		name = ModelUtils.getAttNameValid(eClass);
		newEAttribute.setName(name);
		
		newEAttribute.setEType(EcoreFactory.eINSTANCE.getEcorePackage().getEString());
		
		eClass.getEStructuralFeatures().add(newEAttribute);
	
		addGraphicalRepresentation(context, newEAttribute);

		return new Object[] { newEAttribute};
	}
}
