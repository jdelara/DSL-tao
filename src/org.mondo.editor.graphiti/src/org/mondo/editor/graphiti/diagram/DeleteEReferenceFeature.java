package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

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
		
		PictogramElement pe = context.getPictogramElement();
		EReference ref = (EReference)getBusinessObjectForPictogramElement(pe);
		if (ref != null){
			DiagramUtils.deleteCollapseReferenceText(getDiagram(), ((EReference)ref));
			if (ref.getEOpposite() != null) 
				DiagramUtils.deleteCollapseReferenceText(getDiagram(), ((EReference)ref).getEOpposite());
		}
		
	}
}