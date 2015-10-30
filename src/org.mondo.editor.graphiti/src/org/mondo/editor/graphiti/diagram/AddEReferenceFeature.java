package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.AddBendpointContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorFigure;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils.DecoratorText;

/**
 * Class to add an EReference object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AddEReferenceFeature extends AbstractAddFeature {

	public AddEReferenceFeature(IFeatureProvider fp) { super(fp); }
	
	@Override
	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext
	            && context.getNewObject() instanceof EReference) {
	            return true;
	        }
	   return false;
	}

	
	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
        EReference addedEReference = (EReference) context.getNewObject();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        
        Connection connection = peCreateService.createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
                
        Anchor anchor = addConContext.getSourceAnchor();
        ContainerShape cc = (ContainerShape) anchor.eContainer();
        
        if (addConContext.getSourceAnchor() == addConContext.getTargetAnchor()){
        	int x = cc.getGraphicsAlgorithm().getX();
        	int y = cc.getGraphicsAlgorithm().getY();
        	int desp = 50;
        	
        	AddBendpointContext apc1 = new AddBendpointContext((FreeFormConnection)connection, x+cc.getGraphicsAlgorithm().getWidth()/2, y-desp, 0);
        	AddBendpointContext apc2 = new AddBendpointContext((FreeFormConnection)connection,x+cc.getGraphicsAlgorithm().getWidth()+desp, y-desp, 0);
        	AddBendpointContext apc3 = new AddBendpointContext((FreeFormConnection)connection, x+cc.getGraphicsAlgorithm().getWidth()+desp, y+cc.getGraphicsAlgorithm().getHeight()/2, 0);
        	
        	getFeatureProvider().getAddBendpointFeature(apc1).execute(apc1);
        	getFeatureProvider().getAddBendpointFeature(apc2).execute(apc2);
        	getFeatureProvider().getAddBendpointFeature(apc3).execute(apc3);
        	
        }
        
 
        IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(IColorConstant.BLACK));
 
        link(connection, addedEReference);
 
        //ARROW POS 0
        DiagramUtils.createDirDecorator(getDiagram(), connection, 1.0,DecoratorFigure.EREF_DECORATOR_DIR, ColorConstant.BLACK);
       
        
        //NAME POS 1
        ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.7,true);
        Text text = gaService.createDefaultText(getDiagram(), textDecorator);
        text.setForeground(manageColor(IColorConstant.BLACK));
        text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(text, 5, -25);
        text.setValue(addedEReference.getName());
        
        // BOUNDS POS 2
        ConnectionDecorator textDecoratorCard = peCreateService.createConnectionDecorator(connection, true, 0.85,true);
        Text textCard = gaService.createDefaultText(getDiagram(), textDecoratorCard);
        textCard.setForeground(manageColor(IColorConstant.BLACK));
        textCard.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textCard, 5, -25);
        
        textCard.setValue(DiagramUtils.getBoundReferenceText(addedEReference));
        
        //ORDERED Y UNIQUE POS 3
        ConnectionDecorator textDecoratorOU = peCreateService.createConnectionDecorator(connection, true, 0.85,true);
        Text textOU = gaService.createDefaultText(getDiagram(), textDecoratorOU);
        textOU.setForeground(manageColor(IColorConstant.BLACK));
        textOU.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textOU, -75, 5);
        textOU.setValue(DiagramUtils.getOrderedUniqueText(addedEReference));
        
        //ANNOTATION POS 4
        ConnectionDecorator textDecoratorAn = peCreateService.createConnectionDecorator(connection, true, 0.85,true);
        Text textAn = gaService.createDefaultText(getDiagram(), textDecoratorAn);
        textAn.setForeground(manageColor(DiagramStyles.ANNOTATION_FOREGROUND));
        textAn.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textOU, -75, 25);
        textDecoratorAn.setVisible(DiagramUtils.isPatternInfo(getDiagram()));
       
		DiagramUtils.addCollapseReferenceText(getDiagram(), addedEReference);

		//Opposite
        //NAME POS 5
        ConnectionDecorator textDecoratorOp = peCreateService.createConnectionDecorator(connection, true, 0.3,true);
        Text textOp = gaService.createDefaultText(getDiagram(), textDecoratorOp);
        textOp.setForeground(manageColor(IColorConstant.BLACK));
        textOp.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textOp, 5, -25);
        
        //BOUNDS POS 6
        ConnectionDecorator textDecoratorCardOp = peCreateService.createConnectionDecorator(connection, true, 0.15,true);
        Text textCardOp = gaService.createDefaultText(getDiagram(), textDecoratorCardOp);
        textCardOp.setForeground(manageColor(IColorConstant.BLACK));
        textCardOp.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textCardOp, 5, -25);
        
        
        //ORDERED Y UNIQUE POS 7
        ConnectionDecorator textDecoratorOUOp = peCreateService.createConnectionDecorator(connection, true, 0.15,true);
        Text textOUOp = gaService.createDefaultText(getDiagram(), textDecoratorOUOp);
        textOUOp.setForeground(manageColor(IColorConstant.BLACK));
        textOUOp.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textOUOp, -75, 5);
        
        //ANNOTATION. POS 8
        ConnectionDecorator textDecoratorAnOp = peCreateService.createConnectionDecorator(connection, true, 0.15,true);
        Text textAnOp = gaService.createDefaultText(getDiagram(), textDecoratorAnOp);
        textAnOp.setForeground(manageColor(DiagramStyles.ANNOTATION_FOREGROUND));
        textAnOp.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.SMALL_SIZE_FONT, false, false));
        gaService.setLocation(textOUOp, -75, 25);
        textDecoratorAnOp.setVisible(DiagramUtils.isPatternInfo(getDiagram()));

		if (addedEReference.isContainment()) DiagramUtils.createContainmentDecorator(getDiagram(), connection, 0);
        if (addedEReference.getEOpposite()!=null){
        	DiagramUtils.createDirDecorator(getDiagram(), connection, 0, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR, ColorConstant.BLACK);
        	DiagramUtils.setDecoratorText(connection,addedEReference.getEOpposite().getName() , DecoratorText.EREF_DECORATOR_NAME_OP);
        	DiagramUtils.setDecoratorText(connection,addedEReference.getEOpposite().getLowerBound()+".."+((addedEReference.getEOpposite().getUpperBound() == -1 ? "*" : addedEReference.getEOpposite().getUpperBound())) , DecoratorText.EREF_DECORATOR_BOUNDS_OP);
        	DiagramUtils.setDecoratorText(connection,DiagramUtils.getOrderedUniqueText(addedEReference.getEOpposite()), DecoratorText.EREF_DECORATOR_ORUNI_OP);
            if (addedEReference.getEOpposite().isContainment()) DiagramUtils.createContainmentDecorator(getDiagram(), connection, 1.0);
        }
        
        return connection;
	}
}
