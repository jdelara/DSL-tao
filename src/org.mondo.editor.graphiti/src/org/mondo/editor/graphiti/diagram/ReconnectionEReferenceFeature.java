package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.services.Graphiti;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to reconnect EReference objects.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ReconnectionEReferenceFeature extends DefaultReconnectionFeature{

	public ReconnectionEReferenceFeature(IFeatureProvider fp) {
        super(fp);
    }

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Anchor newA = context.getNewAnchor();
		if (newA != null)
			return (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(newA.getParent()) instanceof EClass);
		else return false;
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		super.preReconnect(context);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {
		Connection con = context.getConnection();
		EReference ref = (EReference)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
		
		Anchor oldA = context.getOldAnchor();
		Anchor newA = context.getNewAnchor();
		EClass oldC = (EClass)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(oldA.getParent());
		EClass newC = (EClass)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(newA.getParent());

		if (context.getReconnectType() == ReconnectionContext.RECONNECT_TARGET){
			String oldKey = DiagramUtils.getCollapseReferenceTextKey(ref);
			ref.setEType(newC);			
			DiagramUtils.updateCollapseReferenceText(getDiagram(), oldKey, ref);

		}else {
			DiagramUtils.deleteCollapseReferenceText(getDiagram(), ref);
			
			oldC.getEStructuralFeatures().remove(ref);
			newC.getEStructuralFeatures().add(ref);
			
			DiagramUtils.addCollapseReferenceText(getDiagram(), ref);			
		}
		
		//EOpposite
		EReference op = ref.getEOpposite();
		if (op!=null){
			if (context.getReconnectType() == ReconnectionContext.RECONNECT_SOURCE){
				String oldKey = DiagramUtils.getCollapseReferenceTextKey(op);
				op.setEType(newC);	
				DiagramUtils.updateCollapseReferenceText(getDiagram(), oldKey, op);
			}else {
				DiagramUtils.deleteCollapseReferenceText(getDiagram(), op);
				
				oldC.getEStructuralFeatures().remove(op);
				newC.getEStructuralFeatures().add(op);
				
				DiagramUtils.addCollapseReferenceText(getDiagram(), op);
			}
		}
		
		
	}
}
