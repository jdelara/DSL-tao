package org.mondo.editor.graphiti.diagram;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;


/**
 * Class to delete an EEnumLiteral object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEEnumLiteralFeature extends DeleteEModelElementDefaultFeature {

	public DeleteEEnumLiteralFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		Shape litShape = (Shape)context.getPictogramElement();
		
		ContainerShape litContainer = litShape.getContainer();
		
		List<Shape> shapes = litContainer.getChildren();
		IGaService gaService = Graphiti.getGaService();
		
		//EnumLiterals
		int i = 3, pos = 0;
		while (i<shapes.size()){
			Shape eEnumLiteralText = shapes.get(i);
			if (litShape!=eEnumLiteralText){
				gaService.setLocationAndSize(eEnumLiteralText.getGraphicsAlgorithm(), 0, 60+20*pos, eEnumLiteralText.getGraphicsAlgorithm().getWidth(),20);
				pos++;
			}
			i++;
		}
	}
}
