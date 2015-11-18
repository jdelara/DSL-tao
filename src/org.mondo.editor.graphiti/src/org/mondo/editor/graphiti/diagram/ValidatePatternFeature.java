package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.extensionpoints.IPatternImplementation;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

import dslPatterns.Pattern;
import runtimePatterns.PatternInstance;

/**
 * Class to create a Validate Pattern option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidatePatternFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
     
    private String patternName;
    private IPatternImplementation pi = null;
    private boolean validate = false;
    private boolean individualMode = true;
    private Pattern pattern = null;
    
    /**
     * @param fp - feature provider
     * @param patternName - name of the pattern 
     * @param individualMode boolean that says if the execution is isolated or not.
     */
    public ValidatePatternFeature(IFeatureProvider fp, String patternName, boolean individualMode) {
        super(fp);
        this.patternName = patternName;
        this.individualMode = individualMode;
        PatternInstance patternI = ModelUtils.getPatternInstance(getDiagram(), this.patternName);
        if (patternI!=null) pattern = patternI.getPattern();
    }
 
    @Override
    public String getName() {
        return "Validate "+this.patternName;
    }
 
    @Override
    public String getDescription() {
        return "Validate "+this.patternName;
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {    
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	if (ModelUtils.existsPackage((Diagram) pes[0])){
            		if (pattern!=null){
            			this.pi = EvaluateExtensionPoint.getInstanceIPattern(Platform.getExtensionRegistry(), pattern.getName());
            			return this.pi != null;
            		}
            	}
            }
        }
        return false;
    }
 
    public Pattern getPattern() {
		return pattern;
	}

	@Override
    public void execute(ICustomContext context) {   

		EPackage mm = ModelUtils.getBusinessModel(getDiagram());
		EObject patterns = ModelUtils.getPatternsModel(getDiagram());				
		ValidationInfo vi = EvaluateExtensionPoint.evaluateValidatePattern(this.pi, patterns, patternName, mm);
    	
		IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
		List<PictogramElement> pes = new ArrayList<>();


    	if (vi != null){
    		if (!vi.noErrors()) {
    			Messages.displayValidateErrorMessage(this.patternName+" Validation","Errors have been found.");
    			if (dtp instanceof EcoreDiagramTypeProvider){ 
					((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
	    			for (EClass eclass : vi.getErrors().keySet()){
		    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
		    			if (pe != null)	pes.add(pe);
	    			}
    			}
    		}
    		else if (!vi.noWarnings()){
	    			if (individualMode){
	    				Messages.displayValidateWarningMessage(this.patternName+" Validation", "Warnings have been found");
	    				if (dtp instanceof EcoreDiagramTypeProvider){ 
	    					((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
			    			for (EClass eclass : vi.getWarnings().keySet()){
				    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
				    			if (pe != null)	pes.add(pe);
				    		}
	    				}
	    			} else {
	    				this.validate = true;
	    				if (dtp instanceof EcoreDiagramTypeProvider){ 
	    					ValidationInfo viOld = ((EcoreDiagramTypeProvider)dtp).getValidationInfo();
			    			if (viOld== null) ((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
			    			else {
			    				if (viOld.noWarnings())
			    					viOld.setWarnings(vi.getWarnings());
			    				else for (EClass eclass:viOld.getWarnings().keySet()){
			    					if (vi.getWarnings().keySet().contains(eclass)){
			    						viOld.getWarnings().get(eclass).addAll(vi.getWarnings().get(eclass));
			    						vi.getWarnings().remove(eclass);
			    					}
			    					viOld.getWarnings().putAll(vi.getWarnings());
			    				}
			    			}
	    				}
	    			}
	    		}
    		else {
    			validate = true;
    			if (individualMode) {
    				Messages.displayValidateSuccessfulMessage(this.patternName+" Validation"); 
    				((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
        			pes.add(getDiagram());
    			}
    			
    		}
    		
    	}else {
    		validate = true;
    		if (individualMode) {
    			Messages.displayValidateSuccessfulMessage(this.patternName+" Validation");
    			((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
        		pes.add(getDiagram());
    		}
    		
    	}
		DiagramUtils.selectPictograms(pes);	

    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    public boolean isValidate(){
    	return this.validate;
    }
    
}