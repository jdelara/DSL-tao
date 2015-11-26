package org.mondo.editor.graphiti.diagram;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;


/**
 * Class to create an EAttribute object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEAttributeFeature extends DeleteEModelElementDefaultFeature {

	public DeleteEAttributeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		Shape attShape = (Shape)context.getPictogramElement();
		
		ContainerShape attContainer = attShape.getContainer();
		
		List<Shape> shapes = attContainer.getChildren();
		IGaService gaService = Graphiti.getGaService();
		
		//Attributes
		int i = DiagramUtils.POS_ATTRIBUTES, pos = 0;
		while (i<shapes.size()){
			Shape eAttributeText = shapes.get(i);
			if (attShape!=eAttributeText){
				gaService.setLocationAndSize(eAttributeText.getGraphicsAlgorithm(), 0, DiagramStyles.CLASS_DEF_HEIGHT+20*pos, eAttributeText.getGraphicsAlgorithm().getWidth(),20);
				pos++;
			}
			i++;
		}
	}
	
}
