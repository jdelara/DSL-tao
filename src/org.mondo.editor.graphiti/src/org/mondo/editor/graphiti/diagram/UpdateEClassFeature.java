package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to update an EAttribute values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class UpdateEClassFeature extends AbstractUpdateFeature {
 
    public UpdateEClassFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof EClass);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        if (DiagramUtils.isCollapseInheritance(getDiagram())){
	    	String pictogramValue = null;
	        PictogramElement pictogramElement = context.getPictogramElement();
	        if (pictogramElement  instanceof ContainerShape) {
	            ContainerShape cs = (ContainerShape) pictogramElement;
	            for (Shape shape : cs.getChildren()) {
	            	if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
	                    Text text = (Text) shape.getGraphicsAlgorithm();
	                    for (Property p: text.getProperties()) 
							if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_TEXT)){
			                    pictogramValue = text.getValue();
							}
	                }
	            }
	        }
	 
	        String businessName = null;
	        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	        if (bo instanceof EClass) {
	            businessName = DiagramUtils.getHeritageEDN((EClass)bo, 0);
	        }
	 
	        boolean updateNameNeeded =
	            ((pictogramValue == null && businessName != null) || 
	                (pictogramValue != null && !pictogramValue.equals(businessName)));
	        if (updateNameNeeded) {
	            return Reason.createTrueReason("Class text is out of date");
	        } else {
	            return Reason.createFalseReason();
	        }
        }
        return Reason.createFalseReason();
    }
 
    public boolean update(IUpdateContext context) {
    	String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof EClass) {
        	EClass eclass = (EClass) bo;
            businessName = DiagramUtils.getHeritageEDN(eclass, 0);
 
	        if (pictogramElement instanceof ContainerShape) {
	            ContainerShape cs = (ContainerShape) pictogramElement;
	            for (Shape shape : cs.getChildren()) {
	            	if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
	                    Text text = (Text) shape.getGraphicsAlgorithm();
	                    for (Property p: text.getProperties()) 
							if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_TEXT)){
								text.setValue(businessName);
								if (eclass.getESuperTypes().size()==0) 
									text.setFont(Graphiti.getGaService().manageFont(getDiagram(), "Verdana",DiagramStyles.EXTRA_BIG_SIZE_FONT, false, true));
								else text.setFont(Graphiti.getGaService().manageFont(getDiagram(), "Verdana",DiagramStyles.MEDIUM_SIZE_FONT, false, true));
							}
	                }
	            }
	        }
        }
        return false;
    }
} 
 
