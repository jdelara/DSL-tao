package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to edit an EAttribute name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditEAttributeFeature extends AbstractDirectEditingFeature {

	public DirectEditEAttributeFeature(IFeatureProvider fp) {
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
        if (bo instanceof EAttribute && ga instanceof Text) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        EAttribute eAtt = (EAttribute) getBusinessObjectForPictogramElement(pe);
        return eAtt.getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        if (value.length() < 1)
            return "Please enter any text as attribute name.";
        if (value.contains(" "))
            return "Spaces are not allowed in attribute names.";
        if (value.contains("\n"))
            return "Line breakes are not allowed in attribute names.";
        if (!ModelUtils.isIDValid(value))
        	return "The name is not valid.";
        PictogramElement pe = context.getPictogramElement();
        EAttribute eAtt = (EAttribute) getBusinessObjectForPictogramElement(pe);
        if ((eAtt.getName().compareTo(value)!=0) && (ModelUtils.existsAttName((EClass)eAtt.eContainer(), value)))
        	return "Duplicated name";
        
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        EAttribute eAtt = (EAttribute) getBusinessObjectForPictogramElement(pe);
        eAtt.setName(value);
 
        Text text = (Text) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(DiagramUtils.getAttributeText(eAtt));

    }

}
