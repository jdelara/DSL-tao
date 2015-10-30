package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Link;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Class to edit a Link name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditLinkFeature extends AbstractDirectEditingFeature {

	public DirectEditLinkFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
        return TYPE_TEXT;
    }
 
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        if (bo instanceof Link && ga instanceof Text) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Link eClass = (Link) getBusinessObjectForPictogramElement(pe);
        return eClass.getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Link idea = (Link) getBusinessObjectForPictogramElement(pe);
        idea.setName(value);
        
        Text text = (Text) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(value);
    }
}
