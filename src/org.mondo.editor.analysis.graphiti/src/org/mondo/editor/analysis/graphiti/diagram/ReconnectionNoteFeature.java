package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.Note;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Class to reconnect note relations.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ReconnectionNoteFeature extends DefaultReconnectionFeature{

	public ReconnectionNoteFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor oldA = context.getOldAnchor();
		Anchor start = context.getConnection().getStart();	
		Anchor newA = context.getNewAnchor();	

		if( oldA==start) {	
			if (newA != null){
				PictogramElement objectP = newA.getParent();
				return (getBusinessObjectForPictogramElement(objectP) instanceof Idea);
			}
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
		
		Anchor start = context.getConnection().getStart();
		Anchor end = context.getConnection().getEnd();
		
		PictogramElement noteP = end.getParent();
		Note note = (Note)getBusinessObjectForPictogramElement(noteP);
		
		PictogramElement newIdeaP = start.getParent();
		Idea newIdea = (Idea)getBusinessObjectForPictogramElement(newIdeaP);
			
		//old idea
		PictogramElement oldIdeaP = oldA.getParent();
		Idea oldIdea = (Idea)getBusinessObjectForPictogramElement(oldIdeaP);

		oldIdea.getNotes().remove(note);
		newIdea.getNotes().add(note);
	}
}
