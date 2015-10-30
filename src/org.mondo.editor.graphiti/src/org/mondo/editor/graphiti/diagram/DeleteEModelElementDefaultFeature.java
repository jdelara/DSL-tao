package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;


/**
 * Class to delete an EModelElement object in general.
 * it's checked if the EModelElement object can be deleted.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEModelElementDefaultFeature extends DefaultDeleteFeature {
	public DeleteEModelElementDefaultFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		 if (pictogramElement.getProperties().size()>0) {
				for (Property p: pictogramElement.getProperties()) {
					if (p.getKey().equals("delete") && p.getValue().equals(DiagramUtils.NOT_DELETE))
						return false;
				}	
		 }
		 return !(pictogramElement instanceof Diagram);
	}	
}
