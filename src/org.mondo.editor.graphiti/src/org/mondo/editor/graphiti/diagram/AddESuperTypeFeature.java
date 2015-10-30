package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to add an ESuperType object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddESuperTypeFeature extends AbstractAddFeature {

	public AddESuperTypeFeature(IFeatureProvider fp) { super(fp); }
	
	@Override
	public boolean canAdd(IAddContext context) {
		return context instanceof IAddConnectionContext;
	}
	
	private Polyline createArrowClosed(GraphicsAlgorithmContainer gaContainer) {
	       
        IGaService gaService = Graphiti.getGaService();
        Polygon polygon =
            gaService.createPolygon(gaContainer, new int[] { -15, 10, 1, 0, -15,
                -10 });
        polygon.setForeground(manageColor(IColorConstant.BLACK));
        polygon.setBackground(manageColor(IColorConstant.WHITE));
        polygon.setLineWidth(2);
        polygon.setFilled(true);
        return polygon;
    }

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		Connection connection = null;
		connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_INHERITANCE);		
		connection.getProperties().add(marker);
		
		
		Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(IColorConstant.BLACK));
 
        ConnectionDecorator cd;
        cd = peCreateService
              .createConnectionDecorator(connection, false, 1.0, true);
        createArrowClosed(cd);
		
        connection.setVisible(!DiagramUtils.isCollapseInheritance(getDiagram()));
        
		return connection;
	}
}
