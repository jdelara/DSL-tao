package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to edit an Idea name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditIdeaFeature extends AbstractDirectEditingFeature {

	public DirectEditIdeaFeature(IFeatureProvider fp) {
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
        if (bo instanceof Idea && ga instanceof Text && DiagramUtils.isText((Text)ga)) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Idea eClass = (Idea) getBusinessObjectForPictogramElement(pe);
        return eClass.getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        if (value.length() < 1)
            return "Please enter any text as idea name.";
        if (value.contains("\n"))
            return "Line breakes are not allowed in idea names.";
        
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Idea idea = (Idea) getBusinessObjectForPictogramElement(pe);
        idea.setName(value);
        
        Text text = (Text) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(value);
    }
}
