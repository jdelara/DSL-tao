package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EEnum object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEEnumFeature extends AbstractCreateFeature {

	public CreateEEnumFeature(IFeatureProvider fp) {
		super(fp, "Enum", "Create a new enumerate type");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		EEnum newEEnum =	EcoreFactory.eINSTANCE.createEEnum();			
		
		EPackage pack = null;
		if (!ModelUtils.existsPackage(getDiagram())){
			pack = ModelUtils.getBusinessModel(getDiagram());
			link(getDiagram(), pack);
		} else pack = ModelUtils.getBusinessModel(getDiagram());
		
		String name = null;
		name = ModelUtils.getEnumNameValid(getDiagram());
		newEEnum.setName(name);		

		pack.getEClassifiers().add(newEEnum);
		
		addGraphicalRepresentation(context, newEEnum);

		return new Object[] { newEEnum};
	}

}
