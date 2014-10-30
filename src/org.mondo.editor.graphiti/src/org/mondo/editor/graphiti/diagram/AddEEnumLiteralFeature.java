package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;

/**
 * Class to add an EEnumLiteral object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddEEnumLiteralFeature extends AbstractAddFeature {
	
	private final int NUM_FIGURES = 3;

	public AddEEnumLiteralFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof EEnumLiteral &&
				getBusinessObjectForPictogramElement(context.getTargetContainer())
				instanceof EEnum;
	}

	@Override
	public PictogramElement add(IAddContext context) {
	
		EEnumLiteral newEEnumLiteral = (EEnumLiteral)context.getNewObject();
		
		ContainerShape targetEnum = context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape container = null;
		container = peCreateService.createContainerShape(targetEnum, true);
		Rectangle figure = gaService.createRectangle(container);
		figure.setLineVisible(false);
		
		int numLit = targetEnum.getChildren().size()-NUM_FIGURES;
		
		
		gaService.setLocationAndSize(figure, 0, 60+20*(numLit-1),targetEnum.getGraphicsAlgorithm().getWidth(), 20);
		figure.setFilled(false);
		
		Shape shape = peCreateService.createShape(container, false);
		
		Text text = gaService.createText(shape, newEEnumLiteral.getName());
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		text.setForeground(manageColor(ColorConstant.BLACK));
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.MEDIUM_SIZE_FONT, false, false));
		
		gaService.setLocationAndSize(text, 5, 0, targetEnum.getGraphicsAlgorithm().getWidth()-5, 20);
					
		link(shape, newEEnumLiteral);
		link(container, newEEnumLiteral);
		return container;
		
	}

}
