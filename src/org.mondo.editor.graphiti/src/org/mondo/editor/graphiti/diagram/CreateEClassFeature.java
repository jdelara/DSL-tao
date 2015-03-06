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
	
	private String rootName = null;
	private boolean abstractAtt = false;
	public CreateEClassFeature(IFeatureProvider fp) {
		super(fp, "Class", "Create a new class");
	}
	
	public CreateEClassFeature(IFeatureProvider fp, String rootName, boolean abstractAtt) {
		super(fp, "Class", "Create a new class");
		this.rootName = rootName;
		this.abstractAtt = abstractAtt;
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
		
		String name = "";
		if (this.rootName == null) name = ModelUtils.getClassNameValid(getDiagram());
		else name = ModelUtils.getClassNameValid(getDiagram(), rootName);
		
		newEClass.setName(name);
		newEClass.setAbstract(abstractAtt);

		pack.getEClassifiers().add(newEClass);
		
		addGraphicalRepresentation(context, newEClass);
		
		return new Object[] { newEClass};
	}

}
