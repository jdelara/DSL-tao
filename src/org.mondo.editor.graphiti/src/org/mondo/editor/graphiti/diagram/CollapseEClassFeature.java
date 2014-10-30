package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to collapse an EClass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CollapseEClassFeature extends AbstractCustomFeature {

	public CollapseEClassFeature(IFeatureProvider fp) {
        super(fp);
	}
	
	@Override
    public boolean canExecute(ICustomContext context) {
          boolean ret = false;
          PictogramElement[] pes = context.getPictogramElements();
          if (pes != null && pes.length == 1) {
                Object bo = getBusinessObjectForPictogramElement(pes[0]);
                if (bo instanceof EClass) {
                	if (DiagramUtils.isExpand((Shape)pes[0])){
                		ret = true;
                	}
                }
          }
          return ret;
    }

    @Override
    public String getName() {
          return "Collapse";
    }

    @Override
    public String getDescription() {
          return "Collapse EClass";
    }

    @Override
    public String getImageId() {
          return IPlatformImageConstants.IMG_EDIT_COLLAPSE;
    }

    
    @Override
    public boolean isAvailable(IContext context) {
          return true;
    }

    @Override
    public void execute(ICustomContext context) {   
    	PictogramElement[] pes = context.getPictogramElements();
    	DiagramUtils.collapseEClass((ContainerShape)pes[0], getFeatureProvider());
    }
	
}
