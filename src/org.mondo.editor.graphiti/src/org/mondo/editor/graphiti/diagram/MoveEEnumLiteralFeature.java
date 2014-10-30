package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;

/**
 * Class that not allows to move EEnumLiterals object within the EEnum object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class MoveEEnumLiteralFeature extends DefaultMoveShapeFeature {

	public MoveEEnumLiteralFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		return false;
	}

}
