package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Idea;
import mindMapDSML.MindMap;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.mondo.editor.analysis.graphiti.diagram.utils.ColorIdeaInfo;
import org.mondo.editor.analysis.graphiti.diagram.utils.ColorIdeaManagement;
import org.mondo.editor.analysis.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;

/**
 * Class to update an idea values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class UpdateConceptFeature extends AbstractUpdateFeature {
 
    public UpdateConceptFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof Idea);
    }
 
    public IReason updateNeeded(IUpdateContext context) {
    	String pictogramValue = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        if (pictogramElement  instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pictogramElement;
            for (Shape shape : cs.getChildren()) {
            	if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    for (Property p: text.getProperties()) 
						if (p.getKey().equals("type") && p.getValue().equals("id")){
		                    pictogramValue = text.getValue();
						}
                }
            }

 
	        String businessName = null;
	        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	        if (bo instanceof Idea) {
	            businessName = ModelUtils.getIdeaID(getDiagram(), (Idea)bo);
	        }
	 
	        boolean updateNameNeeded =
	            ((pictogramValue == null && businessName != null) || 
	                (pictogramValue != null && !pictogramValue.equals(businessName)));
	        if (updateNameNeeded) {
	            return Reason.createTrueReason("ID idea is out of date");
	        } else { 
	        	//check colors
	        	boolean updatedColorNeeded = false;
	        	if (((Idea)bo).eContainer() instanceof Idea){
	        		Idea parent = (Idea)((Idea)bo).eContainer();
	        		updatedColorNeeded =(((ModelUtils.isFirstLevel(parent) && (ColorIdeaManagement.isUsedColorForAnotherIdea(getDiagram(), (Idea)bo))) 
	        				|| ((!ModelUtils.isFirstLevel((Idea)bo) && (ColorIdeaManagement.isDefaultColor(getDiagram(), (Idea)bo))))));
	        		if (updatedColorNeeded){
	        			return Reason.createTrueReason("Color idea is used");	
	            		
	        		}else {
	        			updatedColorNeeded = ((!(ModelUtils.isFirstLevel((Idea)bo))) && (!(ModelUtils.isFirstLevel(parent))) && (!ColorIdeaManagement.isUsedColorForMyParent(getDiagram(), (Idea)bo)));
	        			if (updatedColorNeeded)
	                		return Reason.createTrueReason("No parent color idea");
	        			else {
	        				boolean updatedTamNeeded = (!(ModelUtils.isFirstLevel((Idea)bo))) && cs.getGraphicsAlgorithm().getWidth()!= DiagramUtils.getIdeaWidth(parent, getFeatureProvider())*3/4;
	        				updatedTamNeeded = updatedTamNeeded && "reconnection".equals(context.getProperty("type"));
	        				if (updatedTamNeeded)
		                		return Reason.createTrueReason("No size idea");
	        			}		    			
	        		}
	        	}
	        }
        }
        return Reason.createFalseReason();	
    }
 
    public boolean update(IUpdateContext context) {
    	String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Idea) {
        	Idea idea = (Idea) bo;
            businessName = ModelUtils.getIdeaID(getDiagram(), idea);
 
            ColorIdeaInfo newColor = ColorIdeaManagement.getDefaultColor();
            int newWidth = 180;
            int newHeight = 80;
            boolean changeColor =false;
            boolean changeSize = false;
            if (((Idea)bo).eContainer() instanceof Idea){
        		Idea parent = (Idea)((Idea)bo).eContainer();
        		if (((ModelUtils.isFirstLevel(parent) && (ColorIdeaManagement.isUsedColorForAnotherIdea(getDiagram(), (Idea)bo))))
        				|| (!ModelUtils.isFirstLevel((Idea)bo) && (ColorIdeaManagement.isDefaultColor(getDiagram(), (Idea)bo)))
        				|| ((!(ModelUtils.isFirstLevel((Idea)bo))) && (!(ModelUtils.isFirstLevel(parent))) && (!ColorIdeaManagement.isUsedColorForMyParent(getDiagram(), (Idea)bo)))){
        			newColor = ColorIdeaManagement.getColorIdea(parent, getDiagram());
        			changeColor = true;
        		}
        		ContainerShape parentCS = DiagramUtils.getContainerShape(parent, getFeatureProvider());
        		if ((!(ModelUtils.isFirstLevel((Idea)bo))) && (pictogramElement.getGraphicsAlgorithm().getWidth()!= parentCS.getGraphicsAlgorithm().getWidth()*3/4) && ("reconnection".equals(context.getProperty("type")))){
        			//New size
        			newWidth = parentCS.getGraphicsAlgorithm().getWidth()*3/4; 
        			newHeight = parentCS.getGraphicsAlgorithm().getHeight()*3/4;     
        			changeSize = true;
        		}
        	} else {
        		//changeColor = true;
        		//changeSize = true;
        	}

            //Order
	        if (pictogramElement instanceof ContainerShape) {
	            ContainerShape cs = (ContainerShape) pictogramElement;
	    		IGaService gaService = Graphiti.getGaService();
	    		int tamTex = newHeight/10+6;
	    		RoundedRectangle figure = null;
	            if (cs.getGraphicsAlgorithm() instanceof RoundedRectangle){
	            	figure = ((RoundedRectangle)cs.getGraphicsAlgorithm());
	            	if (changeColor){
            			figure.setBackground(manageColor(newColor.getBackground()));
            			figure.setForeground(manageColor(newColor.getForeground()));
            		}
	            	if (changeSize){
	            		figure.setHeight(newHeight);
            			figure.setWidth(newWidth);
	            	}

	            	            
		            for (Shape shape : cs.getChildren()) {
		            	if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
		                    Text text = (Text) shape.getGraphicsAlgorithm();
		                    for (Property p: text.getProperties()) 
								if (p.getKey().equals("type") && p.getValue().equals("id")){
									idea.setId(businessName);
									text.setValue(businessName);
									if (changeColor)
										text.setForeground(manageColor(newColor.getOrderText())); 
									if (changeSize) {
										gaService.setLocationAndSize(text, newWidth/7, figure.getHeight()/4-10, figure.getWidth()-newWidth/7, tamTex*2);
										text.setFont(gaService.manageFont(getDiagram(), text.getFont().getName(), ((tamTex-4<2)?2:tamTex-4), text.getFont().isItalic(), text.getFont().isBold()));
									}
								} else if (p.getKey().equals("type") && p.getValue().equals(org.mondo.editor.graphiti.diagram.utils.DiagramUtils.TYPE_TEXT)){
									if (changeColor)
										text.setForeground(manageColor(newColor.getTextName())); 
									if (changeSize) {
										gaService.setLocationAndSize(text, 0, figure.getHeight()/4, figure.getWidth(), tamTex*3);
										text.setFont(gaService.manageFont(getDiagram(), text.getFont().getName(), tamTex, text.getFont().isItalic(), text.getFont().isBold()));
									}
								} else if (p.getKey().equals("type") && p.getValue().equals(org.mondo.editor.graphiti.diagram.utils.DiagramUtils.TYPE_INFO_PATTERNS)){
									if (changeColor)
										text.setForeground(manageColor(newColor.getPatternText())); 
									if (changeSize) {
										gaService.setLocationAndSize(text, newWidth/8, figure.getHeight()/2+10, figure.getWidth()-2*newWidth/8, tamTex*2);
										text.setFont(gaService.manageFont(getDiagram(), "Verdana", ((tamTex-5<2)?2:tamTex-5), true, false));
									}
								}
		                }
		            }
            	} 
	            
	            //get line
		        for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(getDiagram(), idea)){
		        	if (pe instanceof Connection){
		        		if (((Idea)bo).eContainer() instanceof MindMap){
		        			Graphiti.getPeService().deletePictogramElement(pe);
		        		} else {
		        			if (changeColor) ((Connection)pe).getGraphicsAlgorithm().setForeground(manageColor(newColor.getLine()));
		        			if (changeSize)  ((Connection)pe).getGraphicsAlgorithm().setLineWidth(newHeight/10);
		        		}
		        	}
		        }
            } 
        }
        return false;
    }
} 
 
