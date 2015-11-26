package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
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
import org.eclipse.graphiti.util.ColorConstant;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to add an EClass object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddEClassFeature extends AbstractAddFeature {
	
	public AddEClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof EClass &&
				context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public PictogramElement add(IAddContext context) {

		int width = DiagramStyles.CLASS_WIDTH, height = DiagramStyles.CLASS_HEIGHT, lineGap = /*55*/45;
		
		EClass newEClass = (EClass)context.getNewObject();
		
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape container = null;
		
		container = peCreateService.createContainerShape(targetDiagram, true);
		
		Rectangle figure = gaService.createRectangle(container);
		figure.setFilled(true);
		figure.setBackground(manageColor(DiagramStyles.CLASS_BACKGROUND));
		figure.setForeground(manageColor(DiagramStyles.CLASS_FOREGROUND));
		figure.setLineWidth(2);
		gaService.setLocationAndSize(figure, context.getX(), context.getY(), width, height);
		
		link(container, newEClass);
		
		Shape shapeText = peCreateService.createShape(container, false);
		Text text = gaService.createText(shapeText,newEClass.getName());
		text.setForeground(manageColor(DiagramStyles.CLASS_TEXT_FOREGROUND)); 
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 25, figure.getWidth(), 20);
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.EXTRA_BIG_SIZE_FONT, false, true));
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_TEXT);		
		text.getProperties().add(marker);
		
		//<<abstract>>
		Shape shapeTag = peCreateService.createShape(container, false);
		Text textTag = gaService.createText(shapeTag, (newEClass.isAbstract()?"<<abstract>>" : ""));
		textTag.setForeground(manageColor(DiagramStyles.TAG_TEXT));		
		textTag.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		textTag.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.MEDIUM_SIZE_FONT, false, false));
		gaService.setLocationAndSize(textTag, 0, 5, figure.getWidth(), 20);
		
		Property marker2 = MmFactory.eINSTANCE.createProperty();
		marker2.setKey("type");
		marker2.setValue(DiagramUtils.TYPE_TAG);		
		textTag.getProperties().add(marker2);
		
		//@annotation
		Shape shapeAnn = peCreateService.createShape(container, false);
		Text textAnn = gaService.createText(shapeAnn, "");
		
		textAnn.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		textAnn.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, true));
		textAnn.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
		textAnn.setForeground(manageColor(DiagramStyles.ANNOTATION_FOREGROUND));

		gaService.setLocationAndSize(textAnn, figure.getWidth()*9/13, 5, figure.getWidth()*9/13, 40);
		
		Property marker3 = MmFactory.eINSTANCE.createProperty();
		marker3.setKey("type");
		marker3.setValue(DiagramUtils.TYPE_INFO_PATTERNS);		
		textAnn.getProperties().add(marker3);
		
		shapeAnn.setVisible(DiagramUtils.isPatternInfo(getDiagram()));
		
		Shape shapeLine = peCreateService.createShape(container, false); 
		Polyline polyline = gaService.createPolyline(shapeLine, new int[] { 0, lineGap, width, lineGap});
		polyline.setForeground(manageColor(DiagramStyles.CLASS_FOREGROUND));
		polyline.setLineWidth(2);
		
		
		//Collapse
		Shape shapeCollapse = peCreateService.createShape(container, false);
		
		Text textcollapse = gaService.createText(shapeCollapse, "");
		textcollapse.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		textcollapse.setForeground(manageColor(ColorConstant.BLACK));
		textcollapse.setFont(gaService.manageFont(getDiagram(), "Verdana",DiagramStyles.MEDIUM_SIZE_FONT, false, false));
		gaService.setLocationAndSize(textcollapse, 5, figure.getHeight(), figure.getWidth(), 0);
		shapeCollapse.setVisible(false);
		
		Property marker4 = MmFactory.eINSTANCE.createProperty();
		marker4.setKey("type");
		marker4.setValue(DiagramUtils.TYPE_COLLAPSE_INFO_REF);		
		shapeCollapse.getProperties().add(marker4);
		
		link(shapeText, newEClass);
		link(shapeTag, newEClass);
		link(shapeAnn, newEClass);
		
		link(shapeCollapse, newEClass);
		
		peCreateService.createChopboxAnchor(container);
		
		DiagramUtils.initMode(container);
	
		return container;
		
	}

}
