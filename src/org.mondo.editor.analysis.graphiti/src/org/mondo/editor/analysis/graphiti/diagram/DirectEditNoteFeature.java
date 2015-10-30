package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Note;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.platform.ICellEditorProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Class to edit a Note text directly, clicking on the diagram object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DirectEditNoteFeature extends AbstractDirectEditingFeature implements ICellEditorProvider {

	
	public DirectEditNoteFeature(IFeatureProvider fp) {
		super(fp);
	}

	public int getEditingType() {
        return TYPE_CUSTOM;
    }
 
    @Override
    public boolean canDirectEdit(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        if (bo instanceof Note && ga instanceof MultiText ) {
            return true;
        }
        return false;
    }
 
    public String getInitialValue(IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Note text = (Note) getBusinessObjectForPictogramElement(pe);
        return text.getText();
    }
 
    @Override
    public String checkValueValid(String value, IDirectEditingContext context) {
        if (value.length() < 1)
            return "Please enter any text.";
        
        return null;
    }
 
    public void setValue(String value, IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Note idea = (Note) getBusinessObjectForPictogramElement(pe);
        idea.setText(value);
        
        MultiText text = (MultiText) ((Shape)pe).getGraphicsAlgorithm();
        text.setValue(value);
    }
    

	@Override
	public CellEditor createCellEditor(Composite parent) {
		TextCellEditor tce = new TextCellEditor(parent, SWT.MULTI | SWT.WRAP );
		return tce;
	}

	@Override
	public void relocate(CellEditor cellEditor, IFigure figure) {
		Rectangle rect = figure.getClientArea().getCopy();
		figure.translateToAbsolute(rect);
		Text text= (Text) cellEditor.getControl();
		text.setBounds(rect.x, rect.y, rect.width, rect.height);
	}   
}
