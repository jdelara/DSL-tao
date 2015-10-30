package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.MindMap;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.mondo.editor.analysis.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;

/**
 * Class that not allows to move Idea objects within other ideas.
 * 
 * @author miso partner AnaPescador
 *
 */
public class MoveIdeaFeature extends DefaultMoveShapeFeature {

	public MoveIdeaFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		PictogramElement pe = context.getPictogramElement();	
		ContainerShape cs = context.getTargetContainer();
		
		Object source = getBusinessObjectForPictogramElement(pe);
		Object target = getBusinessObjectForPictogramElement(cs);
		
		if ((source instanceof Idea) && (target instanceof Idea))
			return ModelUtils.isFirstLevel((Idea)source);
		return (target instanceof MindMap) ;
	}

	@Override
	public void moveShape(IMoveShapeContext context) {
		PictogramElement pe = context.getPictogramElement();	
		ContainerShape cs = context.getTargetContainer();
		
		Object source = getBusinessObjectForPictogramElement(pe);
		Object target = getBusinessObjectForPictogramElement(cs);
		
		if ((source instanceof Idea) && (target instanceof Idea)){
			//new superIdea
			((Idea)target).getContains().add((Idea)source);
			MindMap mm = ModelUtils.getBusinessModel(getDiagram());
			mm.getIdeas().remove((Idea)source);
			
			((Idea)target).getContains().add((Idea)source);
			
			Connection connection = null;
			IPeCreateService peCreateService = Graphiti.getPeCreateService();
			IGaService gaService = Graphiti.getGaService();
			connection = peCreateService.createFreeFormConnection(getDiagram());
			connection.setEnd(((ContainerShape)pe).getAnchors().get(0));
			connection.setStart(cs.getAnchors().get(0));
			
			Property marker2 = MmFactory.eINSTANCE.createProperty();
			marker2.setKey("type");
			marker2.setValue("SUB");		
			connection.getProperties().add(marker2);
			
	        link(connection, (Idea)source);
	        
	        //NAME POS 0
	        ConnectionDecorator textDecoratorC = peCreateService.createConnectionDecorator(connection, true, 0.1,true);
	        Text textDecorator = gaService.createDefaultText(getDiagram(), textDecoratorC);
	        textDecorator.setForeground(manageColor(IColorConstant.BLACK));
	        textDecorator.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
	        gaService.setLocation(textDecorator, 5, -25);
	        textDecorator.setValue(((Idea)source).getSubText());
	        
	        link(textDecoratorC, (Idea)source);
			
			DiagramUtils.updateIdea((Idea)source, getFeatureProvider(), true);
			
		} else if (target instanceof MindMap) {
			super.moveShape(context);
		}
		
	}

}
