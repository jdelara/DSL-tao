package org.mondo.editor.graphiti.diagram;

import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
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
 * Class to edit an EClass name directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditEClassFeature extends AbstractDirectEditingFeature {

	public DirectEditEClassFeature(IFeatureProvider fp) {
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
        if (bo instanceof EClass && ga instanceof Text && DiagramUtils.isText((Text)ga)) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        EClass eClass = (EClass) getBusinessObjectForPictogramElement(pe);
        return eClass.getName();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        if (value.length() < 1)
            return "Please enter any text as class name.";
        if (value.contains(" "))
            return "Spaces are not allowed in class names.";
        if (value.contains("\n"))
            return "Line breakes are not allowed in class names.";
        if (!ModelUtils.isIDValid(value))
        	return "The name is not valid.";
        PictogramElement pe = context.getPictogramElement();
        EClass eClass = (EClass) getBusinessObjectForPictogramElement(pe);
        if ((eClass.getName().compareTo(value)!=0) && (ModelUtils.existsClassName(getDiagram(), value)))
        	return "Duplicated name";
        
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        EClass eClass = (EClass) getBusinessObjectForPictogramElement(pe);
      
		List<EReference> refs = DiagramUtils.getEReferencesIncoming(getDiagram(), eClass);
		LinkedHashMap<EReference, String> refsKeys= new LinkedHashMap<>();
		for (EReference ref: refs){
			refsKeys.put(ref, DiagramUtils.getCollapseReferenceTextKey(ref));
		}
        
        eClass.setName(value);
        
		for (EReference ref : refs){
			DiagramUtils.updateCollapseReferenceText(getDiagram(), refsKeys.get(ref), ref);
		}

        Text text = (Text) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(value);
    }
}
