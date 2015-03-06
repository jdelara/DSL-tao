package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
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
 * Class to validate the Meta-model and the applied patterns.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidateAllFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
    private boolean validate = false;
      
    public ValidateAllFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Validate All";
    }
 
    @Override
    public String getDescription() {
        return "Meta-model and patterns validation";
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
    	PictogramElement[] pes = context.getPictogramElements();
    	EPackage pack = ModelUtils.getBusinessModel((Diagram)pes[0]);
    	String msg = "";
    	msg += ModelUtils.isPackageValid(pack);
    	
    	ValidationInfo vi = new ValidationInfo();
    	
    	Map<EClass, List<String>> errors = new HashMap<EClass, List<String>>();
    	
		List<PictogramElement> pesToSelect = new ArrayList<>();

    	for (EClassifier classif : pack.getEClassifiers()){
			if (classif instanceof EClass){
				String msgClass = ModelUtils.isEClassValid((EClass)classif);
				if (!msgClass.isEmpty()){
					List<String> msgs = new LinkedList<>();
					msgs.add(msgClass);
					errors.put((EClass)classif, msgs);
					PictogramElement pe = DiagramUtils.getPictogramToSelectValidation(getDiagram(), (EClass)classif);
	    			if (pe != null)	pesToSelect.add(pe);
				}
			}
		}
    	vi.setErrors(errors);
    	IDiagramTypeProvider dtp = getFeatureProvider().getDiagramTypeProvider();
		if (dtp instanceof EcoreDiagramTypeProvider){ 
			((EcoreDiagramTypeProvider)dtp).setValidationInfo(vi);
		}
		DiagramUtils.selectPictograms(pesToSelect);	
		
    	validate = msg.isEmpty() && vi.noErrors();
		if (!validate) Messages.displayValidateErrorMessage("Meta-model Validation", msg+(!vi.noErrors()?"Errors have been detected.":""));
		else {
			//Pattern Validations.
			//Initial validationInfo
			if (dtp instanceof EcoreDiagramTypeProvider){ 
				((EcoreDiagramTypeProvider)dtp).setValidationInfo(null);
			}
			for (String pattern : ModelUtils.getAppliedPatternNames(getDiagram())){			
				ValidatePatternFeature vpf = new ValidatePatternFeature(getFeatureProvider(), pattern, false);
				CustomContext cc = new CustomContext(new PictogramElement[]{getDiagram()});
				if (vpf.canExecute(cc)){
					vpf.execute(null);
					if (!vpf.isValidate()) {
						validate = false;
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
					return;
				}
			}
			Messages.displayValidateSuccessfulMessage("Validation");
		}
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    public boolean isValidate(){
    	return this.validate;
    }
}