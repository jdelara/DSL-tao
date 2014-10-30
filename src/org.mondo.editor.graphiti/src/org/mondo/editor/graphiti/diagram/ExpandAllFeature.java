package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;


/**
 * Class to expand all the diagram elements.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExpandAllFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public ExpandAllFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Expand All";
    }
 
    @Override
    public String getDescription() {
        return "Expand All";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	ret = true;
            }
        }
        return ret;
    }
    
 
    @Override
    public void execute(ICustomContext context) {    
    	PictogramElement[] pes = context.getPictogramElements();
    	Object bo = getBusinessObjectForPictogramElement(pes[0]);
        if (bo instanceof EPackage) {
        	for (EClassifier eClassif: ((EPackage)bo).getEClassifiers()){
        		for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements((Diagram) pes[0], eClassif)){
        			if (pe instanceof ContainerShape){
        				if (DiagramUtils.isCollapse((ContainerShape)pe)){
        					if (eClassif instanceof EClass){
        						DiagramUtils.expandEClass((ContainerShape)pe, getFeatureProvider());			
        					} else if (eClassif instanceof EEnum) DiagramUtils.expandEEnum((ContainerShape)pe, getFeatureProvider());
        					hasDoneChanges = true;
        					break;
        				}
        			}
        		}
        	}
        }
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}