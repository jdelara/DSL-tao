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
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to resize an EClass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ResizeEClassFeature extends DefaultResizeShapeFeature {

	public ResizeEClassFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
				
		return super.canResizeShape(context) ;
	}
	

	@Override
	public void resizeShape(IResizeShapeContext context) {

		if (context.getWidth()<DiagramStyles.CLASS_MIN_WIDTH) ((ResizeShapeContext)context).setWidth(DiagramStyles.CLASS_MIN_WIDTH);
		if (context.getHeight()<DiagramStyles.CLASS_MIN_HEIGHT) ((ResizeShapeContext)context).setHeight(DiagramStyles.CLASS_MIN_HEIGHT);
		
		super.resizeShape(context);
		
		//new width size
		int width = context.getWidth();	
				
		List<Shape> shapes = ((ContainerShape) context.getShape()).getChildren();
		IGaService gaService = Graphiti.getGaService();
		
		Shape eClassText = shapes.get(0);
		gaService.setLocationAndSize(eClassText.getGraphicsAlgorithm(), 0, 25, width, 20);
		Shape nameText = shapes.get(1);
		gaService.setLocationAndSize(nameText.getGraphicsAlgorithm(), 0, 5, width, 20);
		Shape annotText = shapes.get(2);
		gaService.setLocationAndSize(annotText.getGraphicsAlgorithm(), width/*2/3*/*9/13, 5, width*9/13, 40);
	
		//Collapse references
		Shape collapseReferencesContainer = (Shape)shapes.get(4);
		gaService.setLocationAndSize(collapseReferencesContainer.getGraphicsAlgorithm(), 5,DiagramStyles.CLASS_DEF_HEIGHT, width, collapseReferencesContainer.getGraphicsAlgorithm().getHeight());

		//Attributes
		for (int i=DiagramUtils.POS_ATTRIBUTES;i<shapes.size();i++){
			Shape eAttributeText = shapes.get(i);
			gaService.setLocationAndSize(eAttributeText.getGraphicsAlgorithm(), 0,/* 60+20*(i-3)*/eAttributeText.getGraphicsAlgorithm().getY(), width, 20);
			
			for (Shape shapeEA: ((ContainerShape)eAttributeText).getChildren()){
				gaService.setLocationAndSize(shapeEA.getGraphicsAlgorithm(), 5, 0, width-5, 20);
			}
		}
		
		Shape lineText = shapes.get(3);
		Polyline pl = (Polyline)lineText.getGraphicsAlgorithm();		
		EList<Point> points = pl.getPoints();
		Point p = points.get(1);
		float scaleX = (float) (width / (p.getX()*1.0));	
		points.get(1).setX(Math.round(p.getX()*scaleX));			
	}

}
