package org.mondo.editor.analysis.graphiti.diagram.properties;

import mindMapDSML.Link;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

/**
 * Filter for Link objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class LinkFilter extends AbstractPropertySectionFilter {
	 
    @Override
    protected boolean accept(PictogramElement pe) {
    	EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof Link) {
            return true;
        }
        return false;
    }
}
