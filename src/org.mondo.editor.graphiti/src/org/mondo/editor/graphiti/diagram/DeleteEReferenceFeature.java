package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;

/**
 * Class to delete an EReference object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEReferenceFeature extends DeleteEModelElementDefaultFeature {

	public DeleteEReferenceFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
	}
}
