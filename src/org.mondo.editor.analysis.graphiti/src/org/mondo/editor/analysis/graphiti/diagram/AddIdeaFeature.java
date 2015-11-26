package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.mondo.editor.analysis.graphiti.diagram.utils.ColorIdeaInfo;
import org.mondo.editor.analysis.graphiti.diagram.utils.ColorIdeaManagement;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

import mindMapDSML.Idea;

/**
 * Class to add idea object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddIdeaFeature extends AbstractAddFeature {
	
	private final int WIDTH = 180;
	private final int HEIGHT = 80;
	public AddIdeaFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return ((context.getNewObject() instanceof Idea) &&
				((context.getTargetContainer() instanceof Diagram) || (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea))); 
	}

	@Override
	public PictogramElement add(IAddContext context) {

		int width = WIDTH, height = HEIGHT;
		int posX = context.getX(), posY = context.getY();
		int tamTex = 16;
		int tamLinea = 10;
		ContainerShape csIdea = null;
		Idea superIdea = null;
		
		if(getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea){
			csIdea = context.getTargetContainer();
			
			width = csIdea.getGraphicsAlgorithm().getWidth()*3/4; 
			height = csIdea.getGraphicsAlgorithm().getHeight()*3/4;
			posX = csIdea.getGraphicsAlgorithm().getX()+(WIDTH-width)/2;
			posY = csIdea.getGraphicsAlgorithm().getY()-HEIGHT;
			tamTex = height/10+6;
			tamLinea =  height/10;
			superIdea = (Idea) getBusinessObjectForPictogramElement(context.getTargetContainer());
		} 
		
		Idea newIdea = (Idea)context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		ContainerShape container = null;
		container = peCreateService.createContainerShape(getDiagram(), true);

		RoundedRectangle figure = gaService.createRoundedRectangle(container, 30, 30);
		figure.setFilled(true);
		
		//get color 
		ColorIdeaInfo color = ColorIdeaManagement.getColorIdea(superIdea, getDiagram());
		
		figure.setBackground(manageColor(color.getBackground()));
		figure.setForeground(manageColor(color.getForeground()));
		figure.setLineWidth(2);
		gaService.setLocationAndSize(figure, posX, posY, width, height);
		
		link(container, newIdea);
		
		Shape shapeOrder = peCreateService.createShape(container, false);
		Text textOrder = gaService.createText(shapeOrder,newIdea.getId());
		textOrder.setForeground(manageColor(color.getOrderText())); 
		textOrder.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		gaService.setLocationAndSize(textOrder, width/7, figure.getHeight()/4-10, figure.getWidth()-width/7, tamTex*2);
		textOrder.setFont(gaService.manageFont(getDiagram(), "Verdana", ((tamTex-4<2)?2:tamTex-4) , false, false));
			
		Property markerOrder = MmFactory.eINSTANCE.createProperty();
		markerOrder.setKey("type");
		markerOrder.setValue("id");		
		textOrder.getProperties().add(markerOrder);
		
		link(shapeOrder, newIdea);

		Shape shapeText = peCreateService.createShape(container, false);
		Text text = gaService.createText(shapeText,newIdea.getName());
		text.setForeground(manageColor(color.getTextName())); 
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, figure.getHeight()/4, figure.getWidth(), tamTex*3);
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", tamTex, false, true));
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_TEXT);		
		text.getProperties().add(marker);
		
		link(shapeText, newIdea);
		
		Shape shapePattern = peCreateService.createShape(container, false);
		Text textPattern = gaService.createText(shapePattern,"");
		textPattern.setForeground(manageColor(color.getPatternText())); 
		textPattern.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(textPattern, width/8, figure.getHeight()/2+10, figure.getWidth()-2*width/8, tamTex*3/4*2);
		textPattern.setFont(gaService.manageFont(getDiagram(), "Verdana", tamTex*3/4, true, false));
		
		Property markerPattern = MmFactory.eINSTANCE.createProperty();
		markerPattern.setKey("type");
		markerPattern.setValue(DiagramUtils.TYPE_INFO_PATTERNS);		
		textPattern.getProperties().add(markerPattern);
			
		link(shapePattern, newIdea);

		peCreateService.createChopboxAnchor(container);
	
		if(csIdea != null){
			Connection connection = null;
			connection = peCreateService.createFreeFormConnection(getDiagram());
			connection.setStart(csIdea.getAnchors().get(0));
			connection.setEnd(container.getAnchors().get(0));

			Property marker2 = MmFactory.eINSTANCE.createProperty();
			marker2.setKey("type");
			marker2.setValue("SUB");		
			connection.getProperties().add(marker2);
			
			Property markerDelete = MmFactory.eINSTANCE.createProperty();
    		markerDelete.setKey("delete");
    		markerDelete.setValue(DiagramUtils.NOT_DELETE);		
    		connection.getProperties().add(markerDelete);
    		
    		Property markerRemove = MmFactory.eINSTANCE.createProperty();
    		markerRemove.setKey("remove");
    		markerRemove.setValue(DiagramUtils.NOT_REMOVE);		
    		connection.getProperties().add(markerRemove);
			
			Polyline polyline = gaService.createPolyline(connection);
	        polyline.setLineWidth(tamLinea);//Configurable
	        polyline.setForeground(manageColor(color.getLine()));
	        
	        link(connection, newIdea);
	        
	        //NAME POS 0
	        ConnectionDecorator textDecoratorC = peCreateService.createConnectionDecorator(connection, true, 0.1,true);
	        Text textDecorator = gaService.createDefaultText(getDiagram(), textDecoratorC);
	        textDecorator.setForeground(manageColor(IColorConstant.BLACK));
	        textDecorator.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.BIG_SIZE_FONT, false, false));
	        gaService.setLocation(textDecorator, 5, -25);
	        textDecorator.setValue(newIdea.getSubText());
	        
	        link(textDecoratorC, newIdea);
	        
		} 
		return container;		
	}

}
