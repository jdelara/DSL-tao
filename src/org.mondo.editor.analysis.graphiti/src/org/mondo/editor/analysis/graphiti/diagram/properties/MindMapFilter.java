package org.mondo.editor.analysis.graphiti.diagram.properties;

import mindMapDSML.MindMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

/**
 * Filter for mind map objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class MindMapFilter extends AbstractPropertySectionFilter {
	 
    @Override
    protected boolean accept(PictogramElement pe) {
    	EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof MindMap) {
            return true;
        }
        return false;
    }
}
