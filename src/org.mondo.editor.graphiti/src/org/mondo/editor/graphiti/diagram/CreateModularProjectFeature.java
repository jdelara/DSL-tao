package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
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
import org.mondo.editor.extensionpoints.ExecuteInfo;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create a "Create Modular Project" option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateModularProjectFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
     
    private final String VALIDATION_TITLE = "Modular Project Validation";
    private final String CREATION_TITLE = "Create Modular Project";
    private final String CREATION_SUCCESSFULLY_MSG ="Your project was created successfully";
    private final String CREATION_NOT_SUCCESSFULLY_MSG ="Your project wasn't created successfully";

    public CreateModularProjectFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Create Modular Project";
    }
 
    @Override
    public String getDescription() {
        return "Create Modular Project";
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
    		IPath iPath = null;
    		
    		IFile file = IResourceUtils.getFile(getDiagram().eResource());
    		iPath = file.getLocation();
			ExecuteInfo ci = EvaluateExtensionPoint.evaluateExecutePattern(Platform.getExtensionRegistry(),"Hierarchical Project", mm, iPath);
	    	
			IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
			
			if (dtp instanceof EcoreDiagramTypeProvider){ //no needed
				((EcoreDiagramTypeProvider)dtp).setValidationInfo(ci.getValidationInfo());
			}
			
			if (ci!= null){
		    	if (ci.getValidationInfo() != null){
		    		List<PictogramElement> pes = new ArrayList<>();
		    		if (!ci.getValidationInfo().noErrors()) {
		    			Messages.displayValidateErrorMessage(VALIDATION_TITLE,"Errors have been found.");
		    			for (EClass eclass : ci.getValidationInfo().getErrors().keySet()){
		    				PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass.getEPackage());
			    			if (pe != null)	pes.add(pe);
		    			}
		    		}
		    		else if (!ci.getValidationInfo().noWarnings()){
			    			Messages.displayValidateWarningMessage(VALIDATION_TITLE, "Warnings have been found");
			    			displayCreationInfoResult(ci);
			    			
				    		for (EClass eclass : ci.getValidationInfo().getWarnings().keySet()){
				    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
				    			
				    			if (pe != null)	pes.add(pe);
				    		}
			    	} else displayCreationInfoResult(ci);
		    		
		    		DiagramUtils.selectPictograms(pes);	
		    		
		    	}else displayCreationInfoResult(ci);
			}
    	}
    }

    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    private void displayCreationInfoResult(ExecuteInfo ci){
    	if (ci!= null)
    	if (ci.isSuccess())Messages.displayGeneralMessage(CREATION_TITLE, CREATION_SUCCESSFULLY_MSG);
    	else Messages.displayGeneralErrorMessage(CREATION_TITLE, CREATION_NOT_SUCCESSFULLY_MSG);
    }
    
}