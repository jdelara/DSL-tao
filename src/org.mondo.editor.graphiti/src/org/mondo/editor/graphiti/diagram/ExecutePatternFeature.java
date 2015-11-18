package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
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
import org.mondo.editor.extensionpoints.ExecuteInfo;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.extensionpoints.IPatternImplementation;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

import dslPatterns.Pattern;
import runtimePatterns.PatternInstance;


/**
 * Class to create a Create Pattern option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExecutePatternFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
     
    private final String EXECUTION_SUCCESSFULLY_MSG ="Your execution was successful";
    private final String EXECUTION_NOT_SUCCESSFULLY_MSG ="Your execution wasn't successful";
    
    private String patternName;
    private IPatternImplementation pi = null;
    private boolean execute = false;
    private boolean individualMode = true;
    private Pattern pattern = null;
    
    

	/**
     * @param fp
     * @param patternName - name of the pattern 
     * @param individualMode boolean that says if the execution is isolated or not.
     */
    public ExecutePatternFeature(IFeatureProvider fp, String patternName, boolean individualMode) {
        super(fp);
        this.patternName = patternName;
        this.individualMode = individualMode;
        PatternInstance patternI = ModelUtils.getPatternInstance(getDiagram(), this.patternName);
        if (patternI!=null) this.pattern = patternI.getPattern();

    }
    
    public Pattern getPattern() {
		return pattern;
	}
 
    @Override
    public String getName() {
        return "Execute "+patternName;
    }
 
    @Override
    public String getDescription() {
        return "Execute "+patternName;
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {    	
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	if (ModelUtils.existsPackage((Diagram) pes[0])){
            		if (pattern != null){
            			this.pi = EvaluateExtensionPoint.getInstanceIPattern(Platform.getExtensionRegistry(), pattern.getName());	
            			return this.pi != null;
            		}
            	}
            }
        }
        return false;
    }
 
    @Override
    public void execute(ICustomContext context) {   

		EPackage mm = ModelUtils.getBusinessModel(getDiagram());
		IPath iPath = null;
		
		IFile file = IResourceUtils.getFile(getDiagram().eResource());
		iPath = file.getLocation();
		
		EObject patterns = ModelUtils.getPatternsModel(getDiagram());
		
		ExecuteInfo ci = EvaluateExtensionPoint.evaluateExecutePattern(this.pi,patterns,patternName, mm, iPath);
    	
		IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
		
		List<PictogramElement> pes = new ArrayList<>();
		if (ci!= null){
	    	if (ci.getValidationInfo() != null){
	    		if (!ci.getValidationInfo().noErrors()) {
	    			Messages.displayValidateErrorMessage(this.patternName+" Validation","Errors have been found.");
	    			if (dtp instanceof EcoreDiagramTypeProvider){ //no needed
	    				((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
		    			for (EClass eclass : ci.getValidationInfo().getErrors().keySet()){
		    				PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass.getEPackage());
			    			if (pe != null)	pes.add(pe);
		    			}
	    			}
	    		}else if (!ci.getValidationInfo().noWarnings()){
	    			if (individualMode){
		    			Messages.displayValidateWarningMessage(this.patternName+" Validation", "Warnings have been found");
		    			displayCreationInfoResult(ci);
		    			if (dtp instanceof EcoreDiagramTypeProvider){ 
	    					((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
				    		for (EClass eclass : ci.getValidationInfo().getWarnings().keySet()){
				    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
				    			if (pe != null)	pes.add(pe);
				    		}
		    			}
	    			} else {
	    				if (ci.isSuccess()) this.execute = true;
	    				if (dtp instanceof EcoreDiagramTypeProvider){ 
	    					ValidationInfo viOld = ((EcoreDiagramTypeProvider)dtp).getValidationInfo();
			    			if (viOld== null) ((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
			    			else {
			    				if (viOld.noWarnings())
			    					viOld.setWarnings(ci.getValidationInfo().getWarnings());
			    				else for (EClass eclass:viOld.getWarnings().keySet()){
			    					if (ci.getValidationInfo().getWarnings().keySet().contains(eclass)){
			    						viOld.getWarnings().get(eclass).addAll(ci.getValidationInfo().getWarnings().get(eclass));
			    						ci.getValidationInfo().getWarnings().remove(eclass);
			    					}
			    					viOld.getWarnings().putAll(ci.getValidationInfo().getWarnings());
			    				}
			    			}
	    				}
	    			}	
		    	} else {
		    		displayCreationInfoResult(ci);
		    		if (individualMode){
			    		((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
			    		pes.add(getDiagram());
		    		}
		    	}	
	    	}else {
	    		displayCreationInfoResult(ci);
	    		if (individualMode){
		    		((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
		    		pes.add(getDiagram());
	    		}
	    	}
    		DiagramUtils.selectPictograms(pes);	

		}
    }

    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    private void displayCreationInfoResult(ExecuteInfo ci){
    	if (ci!= null)
    	if (ci.isSuccess()){
    		this.execute = true;
    		if (this.individualMode)
    		Messages.displayGeneralMessage("Execute "+patternName, EXECUTION_SUCCESSFULLY_MSG);
    	}
    	else Messages.displayGeneralErrorMessage("Execute "+patternName, EXECUTION_NOT_SUCCESSFULLY_MSG);
    }
    
    public boolean isExecute(){
    	return this.execute;
    }
    
}