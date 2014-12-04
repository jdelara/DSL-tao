package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an ESuperType object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateESuperTypeFeature extends AbstractCreateConnectionFeature {

	public CreateESuperTypeFeature(IFeatureProvider fp) {
		super(fp, "Inheritance", "adds a new parent to a given class");
	}
	
	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		Anchor target = context.getTargetAnchor();
		
		if (source!=null && target!=null &&	getBusinessObjectForPictogramElement(source.getParent()) instanceof EClass
				&&	getBusinessObjectForPictogramElement(target.getParent()) instanceof EClass)	{	
			EClass subType = (EClass)getBusinessObjectForPictogramElement(source.getParent());
			EClass superType = (EClass)getBusinessObjectForPictogramElement(target.getParent());
			
			return ((!subType.getEAllSuperTypes().contains(superType)) && (!superType.getEAllSuperTypes().contains(subType))
					&& (!ModelUtils.hasAnyChildren(subType,superType)) && (!ModelUtils.hasAnyChildren(superType,subType)));
		}
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {	
		PictogramElement source = context.getSourceAnchor().getParent();
		PictogramElement target = context.getTargetAnchor().getParent();
		
		EClass subType = (EClass)getBusinessObjectForPictogramElement(source);
		EClass superType = (EClass)getBusinessObjectForPictogramElement(target);
		
		subType.getESuperTypes().add(superType);
			
		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),context.getTargetAnchor());
		Connection newConnection = (Connection)getFeatureProvider().addIfPossible(addContext);
			
		return newConnection;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		return source!=null && getBusinessObjectForPictogramElement(source.getParent())
		instanceof EClass;
	}
}