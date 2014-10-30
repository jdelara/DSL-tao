package org.mondo.editor.graphiti.diagram;


import org.eclipse.emf.ecore.EEnum;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to add an EEnum object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddEEnumFeature extends AbstractAddFeature {
	public AddEEnumFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof EEnum && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		int width = DiagramStyles.ENUM_WIDTH, height = DiagramStyles.ENUM_HEIGHT, lineGap = 55;
				
		EEnum newEEnum = (EEnum)context.getNewObject();
		
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape container = null;
		
		container = peCreateService.createContainerShape(targetDiagram, true);
		
		Rectangle figure = gaService.createRectangle(container);
		figure.setForeground(manageColor(DiagramStyles.ENUM_FOREGROUND));
		figure.setBackground(manageColor(DiagramStyles.ENUM_BACKGROUND));

		figure.setLineWidth(2);
		gaService.setLocationAndSize(figure, context.getX(), context.getY(), width, height);
		figure.setFilled(true);		
		link(container, newEEnum);
		
		Shape shapeText = peCreateService.createShape(container, false);
		Text text = gaService.createText(shapeText,newEEnum.getName());
		text.setForeground(manageColor(DiagramStyles.ENUM_TEXT_FOREGROUND)); 
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 30, figure.getWidth(), 20);
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.EXTRA_BIG_SIZE_FONT, false, true));
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_TEXT);		
		text.getProperties().add(marker);
		
		Shape shapeEnum = peCreateService.createShape(container, false);
		Text textEnum = gaService.createText(shapeEnum, "<<enum>>");
		textEnum.setForeground(manageColor(DiagramStyles.TAG_TEXT));		
		textEnum.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		textEnum.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.MEDIUM_SIZE_FONT, false, false));
		gaService.setLocationAndSize(textEnum, 0, 10, figure.getWidth(), 20);
		
		Property marker2 = MmFactory.eINSTANCE.createProperty();
		marker2.setKey("type");
		marker2.setValue(DiagramUtils.TYPE_TAG);		
		textEnum.getProperties().add(marker2);
		
		Shape shapeLine = peCreateService.createShape(container, false); 
		Polyline polyline = gaService.createPolyline(shapeLine, new int[] { 0, lineGap, width, lineGap });
		polyline.setForeground(manageColor(DiagramStyles.ENUM_FOREGROUND));
		polyline.setLineWidth(2);
				
		link(shapeText, newEEnum);
		link(shapeEnum, newEEnum);
		peCreateService.createChopboxAnchor(container);
		
		DiagramUtils.initMode(container);
		
		return container;
	}

}
