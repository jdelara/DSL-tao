package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create a Create Pattern option in the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExecuteAllPatternsFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
     
    @Override
    public String getName() {
        return "Execute all patterns";
    }
 
    @Override
    public String getDescription() {
        return "Execute all patterns";
    }
    
    public ExecuteAllPatternsFeature(IFeatureProvider fp) {
        super(fp);
    }
 
 
    @Override
    public boolean canExecute(ICustomContext context) {    	
    	boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
            	if (ModelUtils.existsPackage((Diagram) pes[0]))
            	ret = true;
            }
        }
        return ret;
    }
 
    @Override
    public void execute(ICustomContext context) {   
    	IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
    	if (dtp instanceof EcoreDiagramTypeProvider){ 
			((EcoreDiagramTypeProvider)dtp).setValidationInfo(null);
		}
    	for (String pattern : ModelUtils.getAppliedPatternNames(getDiagram())){			
    		ExecutePatternFeature epf = new ExecutePatternFeature(getFeatureProvider(), pattern, false);
			CustomContext cc = new CustomContext(new PictogramElement[]{getDiagram()});
			if (epf.canExecute(cc)){
				epf.execute(cc);
				if (!epf.isExecute()) {
					return;
				}
			}
		}
    	if (dtp instanceof EcoreDiagramTypeProvider){ 
			ValidationInfo viAll = ((EcoreDiagramTypeProvider)dtp).getValidationInfo();
			if (viAll!=null){
				Messages.displayValidateWarningMessage("All Pattern Validation", "Warnings have been found");
				List<PictogramElement> pesAll = new ArrayList<>();
				for (EClass eclass : viAll.getWarnings().keySet()){
	    			PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), eclass);
	    			if (pe != null)	pesAll.add(pe);
	    		}
			}
		}
    	Messages.displayGeneralErrorMessage("Execute All Patterns", "Your execution was successful");
    }

    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    
}