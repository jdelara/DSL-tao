package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EClass object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEClassFeature extends AbstractCreateFeature {

	public CreateEClassFeature(IFeatureProvider fp) {
		super(fp, "Class", "Create a new class");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		EClass newEClass =	EcoreFactory.eINSTANCE.createEClass();			
		
		EPackage pack = null;
		if (!ModelUtils.existsPackage(getDiagram())){
			pack = ModelUtils.getBusinessModel(getDiagram());
			link(getDiagram(), pack);
		} else pack = ModelUtils.getBusinessModel(getDiagram());
		
		
		String name = null;
		name = ModelUtils.getClassNameValid(getDiagram());
		newEClass.setName(name);
		newEClass.setAbstract(false);

		pack.getEClassifiers().add(newEClass);
		
		addGraphicalRepresentation(context, newEClass);
		
		return new Object[] { newEClass};
	}

}
