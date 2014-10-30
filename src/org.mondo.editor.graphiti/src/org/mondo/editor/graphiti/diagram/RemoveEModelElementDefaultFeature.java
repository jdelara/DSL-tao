package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to remove an EModelElement in general.
 * it's checked if the EModelElement can be removed.
 * 
 * @author miso partner AnaPescador
 *
 */
public class RemoveEModelElementDefaultFeature extends DefaultRemoveFeature {
	public RemoveEModelElementDefaultFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canRemove(IRemoveContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		 if (pictogramElement.getProperties().size()>0) {
				for (Property p: pictogramElement.getProperties()) {
					if (p.getKey().equals("remove") && p.getValue().equals(DiagramUtils.NOT_REMOVE))
						return false;
				}	
		 }
		 return false;

	}
	
}
