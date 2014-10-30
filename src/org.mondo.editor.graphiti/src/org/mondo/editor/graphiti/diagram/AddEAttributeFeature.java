package org.mondo.editor.graphiti.diagram;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to add an EAttribute object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddEAttributeFeature extends AbstractAddFeature {
	
	private final int NUM_FIGURES = 5;
	public AddEAttributeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof EAttribute &&
			getBusinessObjectForPictogramElement(context.getTargetContainer())
			instanceof EClass;
	}

	@Override
	public PictogramElement add(IAddContext context) {
	
		EAttribute newEAtt = (EAttribute)context.getNewObject();

		ContainerShape targetClass = context.getTargetContainer();

		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape container = null;
		container = peCreateService.createContainerShape(targetClass, true);
		Rectangle figure = gaService.createRectangle(container);
		figure.setLineVisible(false);
		int numAtt = targetClass.getChildren().size()-NUM_FIGURES;
		
		gaService.setLocationAndSize(figure, 0, DiagramStyles.CLASS_DEF_HEIGHT+20*(numAtt-1),targetClass.getGraphicsAlgorithm().getWidth(), 20);
		figure.setFilled(false);
		
		Shape shape = peCreateService.createShape(container, false);
		
		Text text = gaService.createText(shape, DiagramUtils.getAttributeText(newEAtt));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		text.setForeground(manageColor(ColorConstant.BLACK));
		text.setFont(gaService.manageFont(getDiagram(), "Verdana",DiagramStyles.MEDIUM_SIZE_FONT, false, false));
		
		gaService.setLocationAndSize(text, 5, 0, targetClass.getGraphicsAlgorithm().getWidth()-5, 20);
			
		link(shape, newEAtt);
		link(container, newEAtt);
		return container;
		
	}

}
