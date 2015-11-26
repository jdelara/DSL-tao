package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.Link;
import mindMapDSML.Note;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.mondo.editor.graphiti.diagram.DeleteEModelElementDefaultFeature;

/**
 * Class to provide the functionalities available in the diagram editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AnalysisFeatureProvider extends DefaultFeatureProvider {

	public AnalysisFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		if (context.getPictogramElements()[0] instanceof Diagram){
			return new ICustomFeature[] { new CreateMondoDesignDiagram(this)};
		}return new ICustomFeature[]{new PatternAssistantFeature(this)};
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreateIdeaFeature(this), new CreateNoteFeature(this) };
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[]{ new CreateLinkFeature(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) { 
		if (context.getNewObject() instanceof Idea) {
			return new AddIdeaFeature(this);
		} else if (context.getNewObject() instanceof Note) {
			return new AddNoteFeature(this);
		}
		return new AddLinkFeature(this);
	}
	
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Idea){
        	return new DeleteIdeaFeature(this);
        }
		return new DeleteEModelElementDefaultFeature(this);
	}
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
	    PictogramElement pe = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pe);
	    if (bo instanceof Idea){
	    	if (pe instanceof ConnectionDecorator) return new DirectEditSubTextFeature(this);
	    	else return new DirectEditIdeaFeature(this);
	    }  
	    else if (bo instanceof Link)
	    	 return new DirectEditLinkFeature(this);
	    else if (bo instanceof Note)
	    	return new DirectEditNoteFeature(this);
	    return super.getDirectEditingFeature(context);
	 }
	
	@Override
    public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof Idea){
            return new ResizeIdeaFeature(this);
        } else if(bo instanceof Note)
        	return new ResizeNoteFeature(this);
		return super.getResizeShapeFeature(context);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if (pictogramElement  instanceof ContainerShape) {
	       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	       if (bo instanceof Idea) {
	           return new UpdateConceptFeature(this);
	       } 
	   }
	   return super.getUpdateFeature(context);
	 }
	
	@Override
	public IReconnectionFeature getReconnectionFeature(
			IReconnectionContext context) {
		Connection con = context.getConnection();
	    Object bo = getBusinessObjectForPictogramElement(con);
	    if (bo instanceof Idea) 
	        return new ReconnectionIdeaFeature(this);  
	    else if (bo instanceof Link)
	    	return new ReconnectionLinkFeature(this);
	    else if (bo instanceof Note)
	    	return new ReconnectionNoteFeature(this);
	    return super.getReconnectionFeature(context);
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof Idea)
			return new MoveIdeaFeature(this);
		return super.getMoveShapeFeature(context);
	}	
}
