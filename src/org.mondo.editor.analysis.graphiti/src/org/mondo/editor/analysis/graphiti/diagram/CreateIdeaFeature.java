package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.MindMap;
import mindMapDSML.MindMapDSMLFactory;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create Idea objects into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateIdeaFeature extends AbstractCreateFeature {
	

	public CreateIdeaFeature(IFeatureProvider fp) {
		super(fp, "Idea", "Create a new idea");
	}


	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram 
				|| getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Idea newIdea =	MindMapDSMLFactory.eINSTANCE.createIdea();			
		String name = "";
		
		MindMap mm = null;
		Idea superIdea = null;
		if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea){
			superIdea = (Idea)getBusinessObjectForPictogramElement(context.getTargetContainer());
			name = ModelUtils.getIdeaNameValid(getDiagram(), superIdea);
			newIdea.setName(name);
			superIdea.getContains().add(newIdea);
			newIdea.setSubText("");
			
		}else {
			if (!ModelUtils.existsMindMap(getDiagram())){
				mm = ModelUtils.getBusinessModel(getDiagram());	
				link(getDiagram(), mm);
			} else mm = ModelUtils.getBusinessModel(getDiagram());
			name = ModelUtils.getIdeaNameValid(getDiagram(), null);
			newIdea.setName(name);
			newIdea.setSubText("");
			
			mm.getIdeas().add(newIdea);
		}
		newIdea.setId(ModelUtils.getIdeaID(getDiagram(), newIdea));
		addGraphicalRepresentation(context, newIdea);
		
		return new Object[] { newIdea};
	}
}
