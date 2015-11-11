package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;


/**
 * Class to delete an eclass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEClassFeature extends DeleteEModelElementDefaultFeature {

	public DeleteEClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		
		//Control the incomming references.
		PictogramElement pe = context.getPictogramElement();		
		for (Anchor anchor : ((ContainerShape)pe).getAnchors()){
			EList<Connection> connections = anchor.getIncomingConnections();
			while (!connections.isEmpty()){
				DeleteEReferenceFeature delete = new DeleteEReferenceFeature(this.getFeatureProvider());
				DeleteContext dc = new DeleteContext(connections.get(0));
				dc.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
				delete.delete(dc);	
			}
		}
	}
	
}
