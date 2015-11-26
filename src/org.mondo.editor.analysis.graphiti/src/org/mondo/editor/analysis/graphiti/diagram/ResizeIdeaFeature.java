package org.mondo.editor.analysis.graphiti.diagram;

import java.util.List;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

/**
 * Class to resize idea text box.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ResizeIdeaFeature extends DefaultResizeShapeFeature {

	public ResizeIdeaFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		boolean canResize = super.canResizeShape(context);
		return canResize;
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		super.resizeShape(context);

		List<Shape> shapes = ((ContainerShape) context.getShape()).getChildren();
		IGaService gaService = Graphiti.getGaService();
		
		Shape orderText = shapes.get(0);
		gaService.setLocationAndSize(orderText.getGraphicsAlgorithm(),context.getWidth()/7, context.getHeight()/4-10, context.getWidth()-context.getWidth()/7,orderText.getGraphicsAlgorithm().getHeight());
		
		Shape nameText = shapes.get(1);
		gaService.setLocationAndSize(nameText.getGraphicsAlgorithm(), 0, context.getHeight()/4, context.getWidth(),nameText.getGraphicsAlgorithm().getHeight());
	
		Shape patternText = shapes.get(2);
		gaService.setLocationAndSize(patternText.getGraphicsAlgorithm(), context.getWidth()/8, context.getHeight()/2+10, context.getWidth()-2*context.getWidth()/8, patternText.getGraphicsAlgorithm().getHeight());
	}
}
