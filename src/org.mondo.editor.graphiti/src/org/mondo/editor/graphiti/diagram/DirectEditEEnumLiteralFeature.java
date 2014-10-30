package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to edit an EEnumLiternal name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditEEnumLiteralFeature extends AbstractDirectEditingFeature {

	public DirectEditEEnumLiteralFeature(IFeatureProvider fp) {
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
        if (bo instanceof EEnumLiteral && ga instanceof Text) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        EEnumLiteral eEnumLit = (EEnumLiteral) getBusinessObjectForPictogramElement(pe);
        return eEnumLit.getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {  
        PictogramElement pe = context.getPictogramElement();
        EEnumLiteral enumLit = (EEnumLiteral) getBusinessObjectForPictogramElement(pe);
        if ((enumLit.getName().compareTo(value)!=0) && (ModelUtils.existsEnumLitName((EEnum)enumLit.eContainer(), value)))
        	return "Duplicated name";
        if (!ModelUtils.isIDValid(value))
        	return "The name is not valid.";
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        // set the new literal for the EnumLiteral
        PictogramElement pe = context.getPictogramElement();
        EEnumLiteral enumLit = (EEnumLiteral) getBusinessObjectForPictogramElement(pe);
        
        if (enumLit.getName().compareTo(enumLit.getLiteral())==0) 
        	enumLit.setLiteral(value);
        enumLit.setName(value);

        Text text = (Text) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(value);
    }

}
