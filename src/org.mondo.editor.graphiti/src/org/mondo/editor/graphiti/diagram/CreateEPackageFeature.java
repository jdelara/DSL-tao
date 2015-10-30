package org.mondo.editor.graphiti.diagram;


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EPackage object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEPackageFeature extends AbstractCreateFeature {

	public CreateEPackageFeature(IFeatureProvider fp) {
		super(fp, "Package", "Create a new package");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		final EPackage newEPackage =	EcoreFactory.eINSTANCE.createEPackage();			
		
		EPackage pack = null;
		if (!ModelUtils.existsPackage(getDiagram())){
			pack = ModelUtils.getBusinessModel(getDiagram());
			link(getDiagram(), pack);
		} else pack = ModelUtils.getBusinessModel(getDiagram());
		
		String name = null;
		
		name = Messages.askForEPackageName(getDiagram(), "EPackage Name");
		
		if (!name.isEmpty()){
			newEPackage.setName(name.replace(" ",""));
			newEPackage.setNsPrefix(name.replace(" ","").toLowerCase());
			newEPackage.setNsURI("http://mondo.org/"+name.replace(" ",""));
			
			pack.getESubpackages().add(newEPackage);
			
			addGraphicalRepresentation(context, newEPackage);

			return new Object[] { newEPackage};
		}
		return null;
	}
}
