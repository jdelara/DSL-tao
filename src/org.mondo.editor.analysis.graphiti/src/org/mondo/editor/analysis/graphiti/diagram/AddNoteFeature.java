package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

import mindMapDSML.Idea;
import mindMapDSML.Note;

/**
 * Class to add Note objects into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddNoteFeature extends AbstractAddFeature {
	
	public AddNoteFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return ((context.getNewObject() instanceof Note) && (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Idea)); 
	}

	@Override
	public PictogramElement add(IAddContext context) {

		ContainerShape csIdea = context.getTargetContainer();

		int width = 150; 
		int height = 150;
		int posX = csIdea.getGraphicsAlgorithm().getX()-(csIdea.getGraphicsAlgorithm().getWidth()+width);
		int posY = csIdea.getGraphicsAlgorithm().getY();
		int tamTex = 10; 	
		
		Note newNote = (Note)context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		ContainerShape container = null;
		container = peCreateService.createContainerShape(getDiagram(), true);

		Rectangle figure = gaService.createRectangle(container);
		figure.setFilled(true);
		
		
		IColorConstant lightYellow = new ColorConstant(255, 255, 153);
		IColorConstant darkYellow = new ColorConstant(255, 255, 102);

		figure.setBackground(manageColor(lightYellow));
		figure.setForeground(manageColor(darkYellow));
		figure.setLineWidth(1);
		gaService.setLocationAndSize(figure, posX, posY, width, height);
		
		link(container, newNote);
			
		Shape shapeText = peCreateService.createShape(container, false);
		MultiText text = gaService.createMultiText(shapeText,newNote.getText());
		text.setForeground(manageColor(ColorConstant.BLACK)); 
		text.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
		gaService.setLocationAndSize(text, 5, 5, figure.getWidth()-10, figure.getHeight());
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", tamTex, false, false));
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_TEXT);		
		text.getProperties().add(marker);
		
		link(shapeText, newNote);
	
		peCreateService.createChopboxAnchor(container);

		Connection connection = null;
		connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(csIdea.getAnchors().get(0));
		connection.setEnd(container.getAnchors().get(0));
			
		Property marker2 = MmFactory.eINSTANCE.createProperty();
		marker2.setKey("type");
		marker2.setValue("connection");		
		connection.getProperties().add(marker2);
			
		Polyline polyline = gaService.createPolyline(connection);
	    polyline.setLineWidth(2);
	    polyline.setLineStyle(LineStyle.DOT);
	    polyline.setForeground(manageColor(IColorConstant.GRAY));
	    
	    link(connection, newNote);
	    
		return container;		
	}

}
