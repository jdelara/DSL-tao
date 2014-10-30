package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EEnumLiteral object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEEnumLiteralFeature extends AbstractCreateFeature {

	public CreateEEnumLiteralFeature(IFeatureProvider fp) {
		super(fp, "Enum Literal", "Create a new enum literal");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return getBusinessObjectForPictogramElement(context.getTargetContainer())
				instanceof EEnum;
	}

	@Override
	public Object[] create(ICreateContext context) {
		EEnumLiteral newEEnumLiteral =	EcoreFactory.eINSTANCE.createEEnumLiteral();			
		EEnum eEnum = (EEnum) getBusinessObjectForPictogramElement(context.getTargetContainer());

		newEEnumLiteral.setName(ModelUtils.getEnumLitNameValid(eEnum));
		newEEnumLiteral.setLiteral(ModelUtils.getEnumLitLitNameValid(eEnum));
		eEnum.getELiterals().add(newEEnumLiteral);
		
		addGraphicalRepresentation(context, newEEnumLiteral);
		
		return new Object[] { newEEnumLiteral};
	}
}
