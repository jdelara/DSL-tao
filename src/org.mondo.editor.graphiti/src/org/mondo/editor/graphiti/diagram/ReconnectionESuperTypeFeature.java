package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to reconnect ESupertypes relations.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ReconnectionESuperTypeFeature extends DefaultReconnectionFeature{

	public ReconnectionESuperTypeFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor oldA = context.getOldAnchor();
		Anchor newA = context.getNewAnchor();
		Anchor start = context.getConnection().getStart();
		Anchor end = context.getConnection().getEnd();
		
		if (newA!=null &&	getBusinessObjectForPictogramElement(newA.getParent()) instanceof EClass)	{
			EClass superType = null;
			EClass subType = null;
			if (oldA.equals(start)){
				PictogramElement parentP = end.getParent();
				superType = (EClass)getBusinessObjectForPictogramElement(parentP);
				PictogramElement newChildP = newA.getParent();
				subType = (EClass)getBusinessObjectForPictogramElement(newChildP);
				
			}else if (oldA.equals(end)){
				PictogramElement newParentP = newA.getParent();
				superType = (EClass)getBusinessObjectForPictogramElement(newParentP);
				PictogramElement childP = start.getParent();
				subType = (EClass)getBusinessObjectForPictogramElement(childP);
			}
		return ((!subType.getEAllSuperTypes().contains(superType)) && (!superType.getEAllSuperTypes().contains(subType))
				&& (!ModelUtils.hasAnyChildren(subType,superType)) && (!ModelUtils.hasAnyChildren(superType,subType)));
		}
		return false;
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		super.preReconnect(context);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {		
		Anchor oldA = context.getOldAnchor();
		Anchor newA = context.getNewAnchor();
		
		Anchor start = context.getConnection().getStart();
		Anchor end = context.getConnection().getEnd();

		if (newA.equals(start)){
			//change child
			//parent 
			PictogramElement parentP = end.getParent();
			EClass superType = (EClass)getBusinessObjectForPictogramElement(parentP);
			
			//old child
			PictogramElement oldChildP = oldA.getParent();
			EClass oldSubType = (EClass)getBusinessObjectForPictogramElement(oldChildP);
			
			//new child
			PictogramElement newChildP = newA.getParent();
			EClass newSubType = (EClass)getBusinessObjectForPictogramElement(newChildP);
			
			oldSubType.getESuperTypes().remove(superType);
			newSubType.getESuperTypes().add(superType);
			
		}else if (newA.equals(end)){
			//change parent
			//child
			PictogramElement childP = start.getParent();
			EClass subType = (EClass)getBusinessObjectForPictogramElement(childP);
			
			//old Parent
			PictogramElement oldParentP = oldA.getParent();
			EClass oldSuperType = (EClass)getBusinessObjectForPictogramElement(oldParentP);
			
			//new Parent
			PictogramElement newParentP = newA.getParent();
			EClass newSuperType = (EClass)getBusinessObjectForPictogramElement(newParentP);
			
			subType.getESuperTypes().remove(oldSuperType);
			subType.getESuperTypes().add(newSuperType);
			
		}
		
		
	}
}
