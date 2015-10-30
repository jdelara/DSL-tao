package org.mondo.editor.analysis.graphiti.diagram.properties;

import mindMapDSML.Idea;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

/**
 * Filter for concept objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class IdeaFilter extends AbstractPropertySectionFilter {
	 
    @Override
    protected boolean accept(PictogramElement pe) {
    	EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof Idea) {
            return true;
        }
        return false;
    }
}
