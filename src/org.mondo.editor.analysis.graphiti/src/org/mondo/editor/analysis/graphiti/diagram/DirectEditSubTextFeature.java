package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Class to edit a subtext name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditSubTextFeature extends AbstractDirectEditingFeature {

	public DirectEditSubTextFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
        return TYPE_TEXT;
    }
 
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof Idea && pe instanceof ConnectionDecorator) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Idea idea = (Idea) getBusinessObjectForPictogramElement(pe);
        return idea.getSubText();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Idea idea = (Idea) getBusinessObjectForPictogramElement(pe);
        idea.setSubText(value);
        
        Text text = (Text) ((ConnectionDecorator)pe).getGraphicsAlgorithm();
        text.setValue(value);
        }
}
