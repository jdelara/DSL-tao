package org.mondo.editor.analysis.graphiti.diagram.utils;

import mindMapDSML.Idea;
import mindMapDSML.MindMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class DiagramUtils {
	
	/**
	 * Static method that updates subideas of the superidea parameter.
	 * @param idea 
	 * @param fp
	 */
	public static void updateSubIdeas (EObject idea, IFeatureProvider fp, boolean updateSize){
		if (idea != null)
		for (Idea ideaAux: (idea instanceof MindMap) ?((MindMap)idea).getIdeas(): ((Idea)idea).getContains()){
			updateIdea(ideaAux, fp, updateSize);
		}
	}
	
	/**
	 * Static method that modified an idea and its subideas.
	 * @param idea
	 * @param fp
	 * @param updateSize - boolean to indicate if it´s necessary to modify the size
	 */
	public static void updateIdea(EObject idea, IFeatureProvider fp, boolean updateSize){
		for (PictogramElement pe2: Graphiti.getLinkService().getPictogramElements(fp.getDiagramTypeProvider().getDiagram(),idea)){
			if (pe2 instanceof ContainerShape){
				IReason ret = Reason.createFalseReason();
				IUpdateContext updateCtx = new UpdateContext(pe2);
				if (updateSize) updateCtx.putProperty("type", "reconnection");
				IUpdateFeature updateFeature = fp.getUpdateFeature(updateCtx);
				if (updateFeature != null) {
					ret = updateFeature.updateNeeded(updateCtx);
					if (ret.toBoolean()){
						updateFeature.update(updateCtx);
						updateSubIdeas(idea, fp, updateSize);
					}
				}
			}
		}
	}
	
	/**
	 * Static method that returns the width of an idea.
	 * @param idea
	 * @param fp
	 * @return integer
	 */
	public static int getIdeaWidth(Idea idea, IFeatureProvider fp){
		for (PictogramElement pe2: Graphiti.getLinkService().getPictogramElements(fp.getDiagramTypeProvider().getDiagram(),idea)){
			if (pe2 instanceof ContainerShape){
				return ((ContainerShape)pe2).getGraphicsAlgorithm().getWidth();
			}
		} return 0;
	}
	
	/**
	 * Static method that returns container shape that is related to the idea.
	 * @param idea
	 * @param fp
	 * @return container shape 
	 */
	public static ContainerShape getContainerShape(Idea idea, IFeatureProvider fp){
		for (PictogramElement pe2: Graphiti.getLinkService().getPictogramElements(fp.getDiagramTypeProvider().getDiagram(),idea)){
			if (pe2 instanceof ContainerShape){
				return (ContainerShape)pe2;
			}
		} return null;
	}
}
