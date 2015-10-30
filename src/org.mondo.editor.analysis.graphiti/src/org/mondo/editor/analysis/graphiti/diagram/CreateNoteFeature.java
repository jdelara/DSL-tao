package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.MindMapDSMLFactory;
import mindMapDSML.Note;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

/**
 * Class to create Note objects into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateNoteFeature extends AbstractCreateFeature {
	

	public CreateNoteFeature(IFeatureProvider fp) {
		super(fp, "Note", "Create a new note");
	}


	@Override
	public boolean canCreate(ICreateContext context) {
		return  getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Note newNote =	MindMapDSMLFactory.eINSTANCE.createNote();			
		
		Idea superIdea = null;
		superIdea = (Idea)getBusinessObjectForPictogramElement(context.getTargetContainer());
		newNote.setText("Insert text here..");
		superIdea.getNotes().add(newNote);
			
		addGraphicalRepresentation(context, newNote);
		
		return new Object[] { newNote};
	}
}
