package org.mondo.editor.graphiti.diagram;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to take an EAttribute object within the EClass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class UpEAttributeFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public UpEAttributeFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Take up ...";
    }
 
    @Override
    public String getDescription() {
        return "Take up the attribute";
    }
    
    
 
    @Override
	public String getImageId() {
		return EcoreImageProvider.IMG_UP;
	}

	@Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (getBusinessObjectForPictogramElement(pes[0]) instanceof EAttribute) 
        		if (hasPrevious((Shape)pes[0]))
        		ret = true;
        }
        return ret;
    }
    
    @Override
    public void execute(ICustomContext context) {    
    	
    	PictogramElement[] pes = context.getPictogramElements();
    	EAttribute att = (EAttribute) getBusinessObjectForPictogramElement(pes[0]);
    	ContainerShape classContainer = ((ContainerShape)pes[0]).getContainer();
    	
    	List<Shape> shapes = classContainer.getChildren();

		//Attributes
		int i = DiagramUtils.POS_ATTRIBUTES;
		while ((i<shapes.size())|| (!hasDoneChanges)){
			if (pes[0].equals(shapes.get(i))){
				ContainerShape contShape = (ContainerShape)shapes.get(i);
				String text = readTextShape(contShape);
				ContainerShape contShape2 = (ContainerShape)shapes.get(i-1);
				EAttribute att2 = (EAttribute)getBusinessObjectForPictogramElement(contShape2);
				Shape shape = writeTextShape(contShape,readTextShape(contShape2));
				Shape shape2 = writeTextShape(contShape2,text);
				
				link(contShape2, att);
				link(shape2, att);
				link(contShape, att2);
				link(shape, att2);
				
				DiagramUtils.selectPictogram(contShape2);
				hasDoneChanges = true;
			}
			i++;
		}
    }
    
    private boolean hasPrevious(Shape shape){
    	ContainerShape classContainer = ((ContainerShape)shape).getContainer();
    	List<Shape> shapes = classContainer.getChildren();
    	return shapes.indexOf(shape) != DiagramUtils.POS_ATTRIBUTES;
    }
    
    private Shape writeTextShape(ContainerShape shape, String text){
    	for (Shape shapeAux : shape.getChildren()) {
            if (shapeAux.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
                org.eclipse.graphiti.mm.algorithms.Text textshape = (org.eclipse.graphiti.mm.algorithms.Text) shapeAux.getGraphicsAlgorithm();
                textshape.setValue(text);
                return shapeAux;
            }
        }
    	return null;
    }
    
    private String readTextShape(ContainerShape shape){
    	for (Shape shapeAux : shape.getChildren()) {
            if (shapeAux.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
                org.eclipse.graphiti.mm.algorithms.Text textshape = (org.eclipse.graphiti.mm.algorithms.Text) shapeAux.getGraphicsAlgorithm();
                return textshape.getValue();
            }
        }
    	return null;
    }
    	
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}