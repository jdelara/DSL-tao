package org.mondo.editor.graphiti.diagram;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.Messages;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Class to import a meta-model on the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ImportMetamodelFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public ImportMetamodelFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Import Meta-model...";
    }
 
    @Override
    public String getDescription() {
        return "Import Meta-model";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
        		return true;
            }
        }
        return ret;
    }
    
 
    @Override
    public void execute(ICustomContext context) {    
    	FileDialog fileDialog=new FileDialog(Messages.getShell(),SWT.OPEN);
    	fileDialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
    	fileDialog.setFilterExtensions(new String[]{"*.ecore"});
    	try{ 
    		String path=fileDialog.open();
  		  	if (path != null) {
  		  		path = new File(path).toURI().toString();

  		  		//delete old package and erase diagram
  		  		EPackage packOld = ModelUtils.getBusinessModel(getDiagram());
  		  		DiagramUtils.deleteDiagramContent(getFeatureProvider());
  		  		getDiagram().eResource().getContents().remove(packOld);
  		  		getDiagram().eResource().getContents().remove(ModelUtils.getPatternsModel(getDiagram()));		
  		  		link(getDiagram(), null);

  		  		//add new package and paint diagram
  		  		EPackage pack= ModelUtils.openModel(path);
				getDiagram().eResource().getContents().add(pack);
				link(getDiagram(), pack);
				
				DiagramUtils.initPatternInfo(getDiagram());
		        DiagramUtils.initCollapseInheritance(getDiagram());
		    	
		        DiagramUtils.drawDiagram(getFeatureProvider(), getDiagram());
		    	
		    	hasDoneChanges = true;
				Messages.displayGeneralMessage("Import Meta-model", "Your meta-model was imported successfully");
			} 
    	}catch (Exception ex){ 
    	 Messages.displayGeneralErrorMessage("Import Meta-model", "Your meta-model wasn't imported successfully");
    	 ex.printStackTrace(); 
    	} 
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}