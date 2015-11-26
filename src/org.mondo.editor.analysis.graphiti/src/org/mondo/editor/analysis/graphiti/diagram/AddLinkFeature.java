package org.mondo.editor.analysis.graphiti.diagram;

import mindMapDSML.Link;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.mondo.editor.analysis.graphiti.diagram.utils.ColorIdeaManagement;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorFigure;

/**
 * Class to add link objects between ideas.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddLinkFeature extends AbstractAddFeature {

	public AddLinkFeature(IFeatureProvider fp) { super(fp); }
	
	@Override
	public boolean canAdd(IAddContext context) {
		return context instanceof IAddConnectionContext;
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
		
        Link addedConnection = (Link) context.getNewObject();

		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue("LINK");		
		connection.getProperties().add(marker);
		
		
		Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(ColorIdeaManagement.getDefaultColor().getForeground()));
        
        link(connection, addedConnection);
        
        //DIRECTION ARROW POS 0
        DiagramUtils.createDirDecorator(getDiagram(), connection, 1.0,DecoratorFigure.EREF_DECORATOR_DIR, ColorIdeaManagement.getDefaultColor().getForeground());
       
        //NAME POS 1
        ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.7,true);
        Text text = gaService.createDefaultText(getDiagram(), textDecorator);
        text.setForeground(manageColor(ColorIdeaManagement.getDefaultColor().getForeground()));
        text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.BIG_SIZE_FONT, false, true));
        gaService.setLocation(text, 5, -25);
        text.setValue(addedConnection.getName());
        
        link(textDecorator, addedConnection);
     
		return connection;
	}
}
