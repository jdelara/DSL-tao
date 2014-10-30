package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to update an EAttribute values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class UpdateEAttributeFeature extends AbstractUpdateFeature {
 
    public UpdateEAttributeFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof EAttribute);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        String pictogramValue = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement  instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    pictogramValue = text.getValue();
                }
            }
        }
 
        String businessName = null;
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof EAttribute) {
            EAttribute eAttribute = (EAttribute) bo;
            businessName = DiagramUtils.getAttributeText(eAttribute);
        }
 
        boolean updateNameNeeded =
            ((pictogramValue == null && businessName != null) || 
                (pictogramValue != null && !pictogramValue.equals(businessName)));
        if (updateNameNeeded) {
            return Reason.createTrueReason("Att text is out of date");
        } else {
            return Reason.createFalseReason();
        }
    }
 
    public boolean update(IUpdateContext context) {
    	String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof EAttribute) {
        	EAttribute eAttribute = (EAttribute) bo;
            businessName = DiagramUtils.getAttributeText(eAttribute);
        }
 
        if (pictogramElement instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
                }
            }
        }
 
        return false;
    }
} 
 
