package org.mondo.editor.analysis.graphiti.diagram;

import java.util.List;

import mindMapDSML.Idea;
import mindMapDSML.Note;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.mondo.editor.analysis.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.DeleteEModelElementDefaultFeature;

/**
 * Class to delete Idea objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteIdeaFeature extends DeleteEModelElementDefaultFeature {
	
	EObject parent = null;
	
	public DeleteIdeaFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		Idea idea = (Idea)getBusinessObjectForPictogramElement(pe);
		if (idea != null){
			
			parent = idea.eContainer();
			
			if (parent instanceof Idea){
				List<Idea> lc = idea.getContains();
				for (int i = 0; i<lc.size();i=0){
					Idea child = lc.get(i);	
					for (PictogramElement peChild: Graphiti.getLinkService().getPictogramElements(getDiagram(),child))
					if (peChild instanceof ContainerShape){
						DeleteContext contextChild = new DeleteContext(peChild);
						DeleteIdeaFeature dif = new DeleteIdeaFeature(getFeatureProvider());
						contextChild.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
						dif.delete(contextChild);
					}
				}
			}
			List<Note> lc = idea.getNotes();
				for (int i = 0; i<lc.size();i=0){
					Note note = lc.get(i);	
					for (PictogramElement notePe: Graphiti.getLinkService().getPictogramElements(getDiagram(),note))
						if (notePe instanceof ContainerShape){
							DeleteContext contextNote = new DeleteContext(notePe);
							DeleteEModelElementDefaultFeature element = new DeleteEModelElementDefaultFeature(getFeatureProvider());
							contextNote.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
							element.delete(contextNote);
						}
			}
			
			//Control the incomming links.
			for (Anchor anchor : ((ContainerShape)pe).getAnchors()){
				EList<Connection> connections = anchor.getIncomingConnections();
				while (!connections.isEmpty()){
					DeleteContext connectionContext = new DeleteContext(connections.get(0));
					DeleteEModelElementDefaultFeature element = new DeleteEModelElementDefaultFeature(getFeatureProvider());
					connectionContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
					element.delete(connectionContext);
				}
			}
			super.preDelete(context);
		}
	}

	@Override
	public void postDelete(IDeleteContext context) {
		DiagramUtils.updateSubIdeas(parent, getFeatureProvider(), false);
		super.postDelete(context);
	}
}
