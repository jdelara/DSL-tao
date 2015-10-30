package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.Link;
import mindMapDSML.MindMapDSMLFactory;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Class to create Link objects into the mind map.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateLinkFeature extends AbstractCreateConnectionFeature  {
	
	public CreateLinkFeature(IFeatureProvider fp) {
		super(fp, "Link", "link ideas");
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		Anchor target = context.getTargetAnchor();
		
		if (source!=null && target!=null &&	getBusinessObjectForPictogramElement(source.getParent()) instanceof Idea
				&&	getBusinessObjectForPictogramElement(target.getParent()) instanceof Idea)	{	
			return true;
		}
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		PictogramElement source = context.getSourceAnchor().getParent();
		PictogramElement target = context.getTargetAnchor().getParent();
		
		Idea sourceIdea = (Idea)getBusinessObjectForPictogramElement(source);
		Idea targetIdea = (Idea)getBusinessObjectForPictogramElement(target);
		
		Link newLink = MindMapDSMLFactory.eINSTANCE.createLink();			
		newLink.setName("link");
		newLink.setTarget(targetIdea);
		
		sourceIdea.getLinks().add(newLink);
		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),context.getTargetAnchor());
		
		addContext.setNewObject(newLink);		
		
		Connection newConnection = (Connection)getFeatureProvider().addIfPossible(addContext);
			
		return newConnection;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		return source!=null && getBusinessObjectForPictogramElement(source.getParent())
		instanceof Idea;
	}
}
