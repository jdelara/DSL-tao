package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to create a "Validate Modular Project" option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidateModularProjectFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public ValidateModularProjectFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Validate Modular Project";
    }
 
    @Override
    public String getDescription() {
        return "Validate Modular Project";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {    
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	if (ModelUtils.existsPackage((Diagram) pes[0])){
            		List<EAnnotation> patterns = ModelUtils.getPatterns(getDiagram());
            		String pattern = EvaluateExtensionPoint.getAttributeIPattern(Platform.getExtensionRegistry(),ModelUtils.getBusinessModel((Diagram) pes[0]));
            		if (pattern != null)
            		for (EAnnotation anott : patterns){
            			if (anott.getSource().startsWith(pattern)) return true;
            		}
            	}
            }
        }
        return false;
    }
 
    @Override
    public void execute(ICustomContext context) {   
    	
    	ValidateModelFeature vf = new ValidateModelFeature(getFeatureProvider());
    	if (vf.canExecute(context)) vf.execute(context);
    	
    	if (vf.isValidate()){
    		EPackage mm = ModelUtils.getBusinessModel(getDiagram());
    						
			ValidationInfo vi = EvaluateExtensionPoint.evaluateValidatePattern(Platform.getExtensionRegistry(),"Hierarchical Project", mm);
	    	
			IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
			
			if (dtp instanceof EcoreDiagramTypeProvider){ 
				((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
			}

	    	if (vi != null){
	    		List<PictogramElement> pes = new ArrayList<>();
	    		if (!vi.noErrors()) {
	    			Messages.displayValidateErrorMessage("Modular Project Validation","Errors have been found.");
	    			for (EClass eclass : vi.getErrors().keySet()){
		    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
		    			if (pe != null)	pes.add(pe);
	    			}
	    		}
	    		else if (!vi.noWarnings()){
		    			Messages.displayValidateWarningMessage("Modular Project Validation", "Warnings have been found");
		    			for (EClass eclass : vi.getWarnings().keySet()){
			    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
			    			if (pe != null)	pes.add(pe);
			    		}
		    		}
	    		else Messages.displayValidateSuccessfulMessage("Modular Project Validation"); 

	    		DiagramUtils.selectPictograms(pes);	
	    		
	    	}else Messages.displayValidateSuccessfulMessage("Modular Project Validation");
    	}
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
}