package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.Link;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.services.Graphiti;

/**
 * Class to reconnect link objects.
 *  
 * @author miso partner AnaPescador
 *
 */
public class ReconnectionLinkFeature extends DefaultReconnectionFeature{

	public ReconnectionLinkFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor newA = context.getNewAnchor();
		if (newA != null)
			return (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(newA.getParent()) instanceof Idea);
		else return false;
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		super.preReconnect(context);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {
		Connection con = context.getConnection();
		Link link = (Link)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
		
		Anchor oldA = context.getOldAnchor();
		Anchor newA = context.getNewAnchor();
		Idea oldC = (Idea)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(oldA.getParent());
		Idea newC = (Idea)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(newA.getParent());

		if (context.getReconnectType() == ReconnectionContext.RECONNECT_TARGET)
			link.setTarget(newC);			
		else {
			oldC.getLinks().remove(link);
			newC.getLinks().add(link);
		}
	}
}
