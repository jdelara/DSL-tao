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
 * Class to resize note textbox.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ResizeNoteFeature extends DefaultResizeShapeFeature {

	public ResizeNoteFeature(IFeatureProvider fp) {
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
		
		Shape text = shapes.get(0);
		gaService.setLocationAndSize(text.getGraphicsAlgorithm(),5, 5, context.getWidth()-10, context.getHeight()-10);
	}
}
