package org.mondo.editor.graphiti.diagram;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;

/**
 * Class to resize an EEnum object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ResizeEEnumFeature extends DefaultResizeShapeFeature {

	public ResizeEEnumFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		boolean canResize = super.canResizeShape(context);
		return canResize;
	}


	@Override
	public void resizeShape(IResizeShapeContext context) {
		
		if (context.getWidth()<DiagramStyles.ENUM_MIN_WIDTH) ((ResizeShapeContext)context).setWidth(DiagramStyles.ENUM_MIN_WIDTH);
		if (context.getHeight()<DiagramStyles.ENUM_MIN_HEIGHT) ((ResizeShapeContext)context).setHeight(DiagramStyles.ENUM_MIN_HEIGHT);
		
		super.resizeShape(context);
		
		//new width size
		int width = context.getWidth();	

		List<Shape> shapes = ((ContainerShape) context.getShape()).getChildren();
		IGaService gaService = Graphiti.getGaService();
		
		Shape enumText = shapes.get(0);
		gaService.setLocationAndSize(enumText.getGraphicsAlgorithm(), 0, 30, width, 20);
		Shape nameText = shapes.get(1);
		gaService.setLocationAndSize(nameText.getGraphicsAlgorithm(), 0, 10, width, 20);
		
		//Literals
		for (int i=3;i<shapes.size();i++){
			Shape eEnumLiteralText = shapes.get(i);
			gaService.setLocationAndSize(eEnumLiteralText.getGraphicsAlgorithm(), 0, 60+20*(i-3), width, 20);
			
			for (Shape shapeEA: ((ContainerShape)eEnumLiteralText).getChildren()){
				gaService.setLocationAndSize(shapeEA.getGraphicsAlgorithm(), 5, 0, width-5, 20);
			}
		}
		
		Shape lineText = shapes.get(2);
		Polyline pl = (Polyline)lineText.getGraphicsAlgorithm();		
		EList<Point> points = pl.getPoints();

		Point p = points.get(1);		
		float scaleX = (float) (width / (p.getX()*1.0));			
		points.get(1).setX(Math.round(p.getX()*scaleX));		
	}

}
