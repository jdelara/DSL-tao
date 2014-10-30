package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;


/**
 * Class to delete an ESupertype object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteESuperTypeFeature extends DeleteEModelElementDefaultFeature {

	public DeleteESuperTypeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		
		Connection con = (Connection) context.getPictogramElement();
		PictogramElement source = con.getStart().getParent();
		PictogramElement target = con.getEnd().getParent();
		
		EClass subType = (EClass)getBusinessObjectForPictogramElement(source);
		EClass superType = (EClass)getBusinessObjectForPictogramElement(target);
		
		subType.getESuperTypes().remove(superType);
	}	
}
