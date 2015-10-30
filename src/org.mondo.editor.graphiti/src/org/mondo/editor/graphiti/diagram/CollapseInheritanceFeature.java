package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to collapse all the elements of the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CollapseInheritanceFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public CollapseInheritanceFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Collapse Inheritance";
    }
 
    @Override
    public String getDescription() {
        return "Collapse Inheritance";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
        		if (!DiagramUtils.isCollapseInheritance(getDiagram()))  
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
				if (eClassif instanceof EClass){
					//DiagramUtils.collapseEClass((ContainerShape)pe, getFeatureProvider());
					DiagramUtils.collapseEClassInheritance((EClass)eClassif,(Diagram)pes[0], getFeatureProvider());
				}
				
        	}
        	hasDoneChanges = true;
        	DiagramUtils.setCollapseInheritance(getDiagram(), true);
        }    	
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}