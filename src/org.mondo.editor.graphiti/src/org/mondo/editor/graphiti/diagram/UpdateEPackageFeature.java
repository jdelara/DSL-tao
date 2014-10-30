package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Class to update an EPackage.
 * 
 * @author miso partner AnaPescador
 *
 */
public class UpdateEPackageFeature extends AbstractUpdateFeature {
 
    public UpdateEPackageFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        boolean can = ((bo instanceof EPackage)&& !(context.getPictogramElement() instanceof Diagram));
        return can;
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
        if (bo instanceof EPackage) {
        	EPackage ePackage = (EPackage) bo;
            businessName = ePackage.getName();
        }
 
        boolean updateNameNeeded =
            ((pictogramValue == null && businessName != null) || 
                (pictogramValue != null && !pictogramValue.equals(businessName)));
        if (updateNameNeeded) {
            return Reason.createTrueReason("EPackage text is out of date");
        } else {
            return Reason.createFalseReason();
        }
    }
 
    public boolean update(IUpdateContext context) {
    	String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof EPackage) {
        	EPackage ePackage = (EPackage) bo;
            businessName = ePackage.getName();
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
 
