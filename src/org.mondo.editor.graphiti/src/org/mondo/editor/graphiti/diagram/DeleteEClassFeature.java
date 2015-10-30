package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;


/**
 * Class to delete an eclass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEClassFeature extends DeleteEModelElementDefaultFeature {

	public DeleteEClassFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		super.preDelete(context);
		
		//Control the incomming references.
		PictogramElement pe = context.getPictogramElement();		
		for (Anchor anchor : ((ContainerShape)pe).getAnchors()){
			for (Connection con: anchor.getIncomingConnections()){
				Object object = getBusinessObjectForPictogramElement(con);
				if (object instanceof EReference){
					DiagramUtils.deleteCollapseReferenceText(getDiagram(), (EReference)object);
					EClass eclass = ((EReference)object).getEContainingClass();
					eclass.getEStructuralFeatures().remove((EReference)object);
				}
			}
		}
		
		
	}
	
}
