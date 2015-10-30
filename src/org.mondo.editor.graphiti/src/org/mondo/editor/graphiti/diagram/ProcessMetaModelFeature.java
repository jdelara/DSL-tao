package org.mondo.editor.graphiti.diagram;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.extensionpoints.ExecuteInfo;
import org.mondo.editor.extensionpoints.EvaluateExtensionPoint;
import org.mondo.editor.extensionpoints.IProcessMetaModelImplementation;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to create a Process a meta-model option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ProcessMetaModelFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
     
    private final String EXECUTION_SUCCESSFULLY_MSG ="Your execution was successful";
    private final String EXECUTION_NOT_SUCCESSFULLY_MSG ="Your execution wasn't successful";
    
    private IProcessMetaModelImplementation pi = null;
    private boolean execute = false;
    
    /**
     * @param fp
     */
    public ProcessMetaModelFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Process Meta-model";
    }
 
    @Override
    public String getDescription() {
        return "Process Meta-model";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {    	
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	if (ModelUtils.existsPackage((Diagram) pes[0])){
            		this.pi = EvaluateExtensionPoint.getInstanceIProcessMetaModel(Platform.getExtensionRegistry());
            		return this.pi != null;
            	}
            }
        }
        return false;
    }
 
    @Override
    public void execute(ICustomContext context) {   

		EPackage mm = ModelUtils.getBusinessModel(getDiagram());
				
		ExecuteInfo ci = EvaluateExtensionPoint.evaluateProcessMetaModel(this.pi,mm);
		displayCreationInfoResult(ci);
		
    }

    private void displayCreationInfoResult(ExecuteInfo ci){
    	if (ci!= null)
    	if (ci.isSuccess()){
    		this.execute = true;
    		Messages.displayGeneralMessage("Process MetaModel", EXECUTION_SUCCESSFULLY_MSG);
    	}
    	else Messages.displayGeneralErrorMessage("Process MetaModel", EXECUTION_NOT_SUCCESSFULLY_MSG);
    }
    
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
   
    
    public boolean isExecute(){
    	return this.execute;
    }
    
}