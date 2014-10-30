package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to validate the Meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidateModelFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
    private boolean validate = false;
      
    public ValidateModelFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Validate";
    }
 
    @Override
    public String getDescription() {
        return "Diagram validation";
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
    	for (EClassifier classif : pack.getEClassifiers()){
			if (classif instanceof EClass)	msg += ModelUtils.isEClassValid((EClass)classif);
		}
    	
    	validate = msg.isEmpty();
		if (!validate) Messages.displayValidateErrorMessage("Metamodel Validation", msg);
		else Messages.displayValidateSuccessfulMessage("Metamodel Validation");

    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    public boolean isValidate(){
    	return this.validate;
    }
}