package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.MindMap;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.analysis.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;

/**
 * Class to reconnect idea relations.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ReconnectionIdeaFeature extends DefaultReconnectionFeature{

	public ReconnectionIdeaFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor oldA = context.getOldAnchor();
		Anchor newA = context.getNewAnchor();	
		Anchor start = context.getConnection().getStart();		
		if( oldA==start) {
			Anchor end = context.getConnection().getEnd();
			PictogramElement subIdeaP = end.getParent();
			Idea subIdea = (Idea)getBusinessObjectForPictogramElement(subIdeaP);
			if (newA!=null){
				if (getBusinessObjectForPictogramElement(newA.getParent()) instanceof Idea) return !ModelUtils.isChild(subIdea, (Idea)getBusinessObjectForPictogramElement(newA.getParent()));
			}else return true;
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
		
		Anchor end = context.getConnection().getEnd();
		PictogramElement subIdeaP = end.getParent();
		Idea subIdea = (Idea)getBusinessObjectForPictogramElement(subIdeaP);
		
		//old superIdea
		PictogramElement oldSuperIdeaP = oldA.getParent();
		Idea oldSuperIdea = (Idea)getBusinessObjectForPictogramElement(oldSuperIdeaP);
		
		//new superIdea
		if (newA != null){
			PictogramElement newSuperIdeaP = newA.getParent();
			oldSuperIdea.getContains().remove(subIdea);
			Object newSuper = getBusinessObjectForPictogramElement(newSuperIdeaP);
			if (newSuper instanceof Idea)((Idea)newSuper).getContains().add(subIdea);
		}else {
			 Object newSuper = ModelUtils.getBusinessModel(getDiagram());
			((MindMap)newSuper).getIdeas().add(subIdea);
		}
		
		DiagramUtils.updateIdea(subIdea, getFeatureProvider(), true);
		DiagramUtils.updateSubIdeas(oldSuperIdea, getFeatureProvider(), false);
	}
}
