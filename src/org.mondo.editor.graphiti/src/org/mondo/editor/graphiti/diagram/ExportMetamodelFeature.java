package org.mondo.editor.graphiti.diagram;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to export the current meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExportMetamodelFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public ExportMetamodelFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Export Meta-model...";
    }
 
    @Override
    public String getDescription() {
        return "Export Meta-model";
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
    	
    	ValidateAllFeature vf = new ValidateAllFeature(getFeatureProvider());
    	if (vf.canExecute(context)) vf.execute(context);
    	
    	if (vf.isValidate()){
	    	PictogramElement[] pes = context.getPictogramElements();
	    	EPackage pack = ModelUtils.getBusinessModel((Diagram)pes[0]);
	    	
	    	FileDialog fileDialog=new FileDialog(Messages.getShell(),SWT.SAVE);	    	
	    	   	
    		String name = getDiagram().getName().replace(".diagram", "");
	    	fileDialog.setFileName(name+".ecore");
	    	fileDialog.setFilterExtensions(new String[]{"*.ecore"});
	    	try{ 
	    		String path=fileDialog.open();
	  		  	if (path != null) {
	  		  		path = new File(path).toURI().toString();
					
	  		  		Copier copier = new Copier();
	  		  		EObject result = copier.copy(pack);
	  		  		copier.copyReferences();
	  			
	  		  		ModelUtils.saveModel(path, result);				
					//((Diagram)pes[0]).eResource().getContents().add(pack);
					Messages.displayGeneralMessage("Export Meta-model", "Your meta-model was exported successfully");
				} 
	    	}catch (Exception ex){ 
	    	 Messages.displayGeneralErrorMessage("Export Meta-model", "Your meta-model wasn`t exported successfully");
	    	 ex.printStackTrace(); 
	    	} 
    	}
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}