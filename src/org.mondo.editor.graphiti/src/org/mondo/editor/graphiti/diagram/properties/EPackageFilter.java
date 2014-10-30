package org.mondo.editor.graphiti.diagram.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

/**
 * Filter for EPackage objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EPackageFilter extends AbstractPropertySectionFilter {
	 
    @Override
    protected boolean accept(PictogramElement pe) {
        if (pe instanceof Diagram){
        	if (ModelUtils.existsPackage((Diagram) pe))
        	return true;
        }else {
        	EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            if (eObject instanceof EPackage) {
                return true;
            }
        }
        return false;
    }
}
