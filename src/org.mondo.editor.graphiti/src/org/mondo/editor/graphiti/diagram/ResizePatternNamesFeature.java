package org.mondo.editor.graphiti.diagram;

import java.util.List;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

/**
 * Class to resize PatternNames text box.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ResizePatternNamesFeature extends DefaultResizeShapeFeature {

	public ResizePatternNamesFeature(IFeatureProvider fp) {
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
		
		for (Shape shape: shapes){
			gaService.setLocationAndSize(shape.getGraphicsAlgorithm(), 0, 0, context.getWidth(), context.getHeight());	
		}
	}

}
