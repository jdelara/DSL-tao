package org.mondo.editor.analysis.graphiti.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutBendPoint;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.BendPoint;
import org.eclipse.zest.layouts.exampleStructures.SimpleNode;
import org.mondo.editor.analysis.graphiti.diagram.utils.ModelUtils;

import mindMapDSML.Idea;

/**
 * Class to apply radial layout.
 * 
 * @author miso partner AnaPescador
 *
 */
public class LayoutMapFeature extends AbstractCustomFeature {

	/**
	 * Constructor
	 */
	public LayoutMapFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getDescription() {
		return "Layout diagram";
	}


	@Override
	public String getName() {
		return "Layout diagram";
	}


	@Override
	public boolean canExecute(ICustomContext context) {
	 boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
        	if (pes[0] instanceof Diagram){
        		if (ModelUtils.existsMindMap((Diagram) pes[0]))
                	ret = true;
            }
        }
        return ret;
	}


	@Override
	public void execute(ICustomContext context) {
		//connections and anchor
		final Map<Connection, Point> consPoint = getSelfConnections();

		// get the LayoutAlgorithmn instance
		int style = LayoutStyles.NO_LAYOUT_NODE_RESIZING;
		LayoutAlgorithm layoutAlgorithm = new RadialLayoutAlgorithm(style);

		if (layoutAlgorithm != null) {
			try {

				// Shapes and simpleNodes.
				Map<Shape, SimpleNode> map = getLayoutEntities();

				// connections
				LayoutRelationship[] connections = getConnectionEntities(map);

				//array of Shape LayoutEntity
				LayoutEntity[] entities = map.values().toArray(new LayoutEntity[0]);
				
				//Real dimensions
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorPart editor = activePage.getActiveEditor();
				IDiagramContainerUI dc = (IDiagramContainerUI)editor;
				FigureCanvas canvas = (FigureCanvas) dc.getGraphicalViewer().getControl();
				int viewWidth = canvas.getViewport().getSize().width;
				int viewHeight = canvas.getViewport().getSize().height;
				
				// Apply the LayoutAlgorithmn
				layoutAlgorithm.applyLayout(entities, connections, 0,0,viewWidth, viewHeight, false, false);
				
				// Update the Graphiti Shapes and Connections locations
				updateGraphCoordinates(entities, connections);

				// adapt bendpoints:
				adaptSelfBendPoints(consPoint);

			} catch (InvalidLayoutConfiguration e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * Method that returns the conections of the diagram.
	 * @return Map<Connection, Point>
	 */
	private Map<Connection, Point> getSelfConnections() {
		IGaService gaService = Graphiti.getGaService();
		Map<Connection, Point> selves = new HashMap<Connection, Point>();
		EList<Connection> connections = getDiagram().getConnections();
		for (Connection connection : connections) {
			AnchorContainer source = connection.getStart().getParent();
			AnchorContainer target = connection.getEnd().getParent();
			if (source == target) {
				GraphicsAlgorithm p = source.getGraphicsAlgorithm();
				Point start = gaService.createPoint(p.getX(), p.getY());
				selves.put(connection, start);
			}
		}
		return selves;
	}
	
	/**
	 * Method that returns the shapes and their node.
	 * @return
	 */
	private Map<Shape, SimpleNode> getLayoutEntities() {
		Map<Shape, SimpleNode> map = new HashMap<Shape, SimpleNode>();
		EList<Shape> children = getDiagram().getChildren();
		for (Shape shape : children) {
			GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			SimpleNode entity = new SimpleNode(shape, ga.getX(), ga.getY(), ga.getWidth(), ga.getHeight());
			map.put(shape, entity);
		}
		return map;
	}
	
	/**
	 * Method that returns the layout relationships.
	 * @param map Map<Shape, SimpleNode>
	 * @return
	 */
	private LayoutRelationship[] getConnectionEntities(Map<Shape, SimpleNode> map) {
		List<LayoutRelationship> layoutR = new ArrayList<LayoutRelationship>();
		EList<Connection> connections = getDiagram().getConnections();
		for (Connection connection : connections) {
			EObject obj = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(connection);
			if (obj instanceof Idea){
				String label = null;
				EList<ConnectionDecorator> decorators = connection.getConnectionDecorators();
				for (ConnectionDecorator decorator : decorators) {
					if (decorator.getGraphicsAlgorithm() instanceof Text) {
						label = ((Text)decorator.getGraphicsAlgorithm()).getValue();
					}
				}
	
				Shape source = (Shape) connection.getStart().getParent();
				SimpleNode sourceEntity = map.get(source);
				Shape target = (Shape) connection.getEnd().getParent();
				SimpleNode targetEntity = map.get(target);
	
				if (source != target) { // avoiding Cycle errors
					SimpleRelationship relationship = new SimpleRelationship(sourceEntity, targetEntity, (source != target));
					relationship.setGraphData(connection);
					relationship.clearBendPoints();
					relationship.setLabel(label);
					FreeFormConnection ffcon = (FreeFormConnection) connection;
	
					EList<Point> pointList = ffcon.getBendpoints();
					List<LayoutBendPoint> bendPoints = new ArrayList<LayoutBendPoint>();
					for (int i = 0; i < pointList.size(); i++) {
						Point point = pointList.get(i);
						boolean isControlPoint = (i != 0) && (i != pointList.size()-1);
						LayoutBendPoint bendPoint = new BendPoint(point.getX(), point.getY(), isControlPoint);
						bendPoints.add(bendPoint);
					}
					relationship.setBendPoints(bendPoints.toArray(new LayoutBendPoint[0]));
					layoutR.add(relationship);
					sourceEntity.addRelationship(relationship);
					targetEntity.addRelationship(relationship);
				}
			}
		}
		return layoutR.toArray(new LayoutRelationship[0]);
	}
	
	/**
	 * Method that updates the coordinates.
	 * @param entities
	 * @param connections
	 */
	private void updateGraphCoordinates(LayoutEntity[] entities, LayoutRelationship[] connections) {
		for (LayoutEntity entity : entities) {
			SimpleNode node = (SimpleNode) entity;
			Shape shape = (Shape) node.getRealObject();
			Double x = node.getX();
			Double y = node.getY();
			shape.getGraphicsAlgorithm().setX(x.intValue());
			shape.getGraphicsAlgorithm().setY(y.intValue());
			Double width = node.getWidth();
			Double height = node.getHeight();
			shape.getGraphicsAlgorithm().setWidth(width.intValue());
			shape.getGraphicsAlgorithm().setHeight(height.intValue());
		}

		IGaService gaService = Graphiti.getGaService();
		for (LayoutRelationship relationship : connections) {
			SimpleRelationship rel = (SimpleRelationship)relationship;
			FreeFormConnection connection = (FreeFormConnection) rel.getGraphData();
			connection.getBendpoints().clear();
			LayoutBendPoint[] bendPoints = rel.getBendPoints();
			for (LayoutBendPoint bendPoint : bendPoints) {
				Double x = bendPoint.getX();
				Double y = bendPoint.getY();
				Point p = gaService.createPoint(x.intValue(), y.intValue());
				connection.getBendpoints().add(p);
			}
		}
	}
	
	/**
	 * Method that adapts the bendpoints.
	 * @param selves map of connections and points.
	 */
	private void adaptSelfBendPoints(Map<Connection, Point> selves) {
		for (Connection connection : selves.keySet()) {
			Point p = selves.get(connection);
			FreeFormConnection ffcon = (FreeFormConnection) connection;
			EList<Point> pointList = ffcon.getBendpoints();
			AnchorContainer source = connection.getStart().getParent();
			GraphicsAlgorithm start = source.getGraphicsAlgorithm();
			int deltaX = start.getX() - p.getX();
			int deltaY = start.getY() - p.getY();
			for (int i = 0; i < pointList.size(); i++) {
				Point bendPoint = pointList.get(i);
				int x = bendPoint.getX();
				bendPoint.setX(x + deltaX);
				int y = bendPoint.getY();
				bendPoint.setY(y + deltaY);
			}
		}
	}


	/**
	 * Subclass used to hold the connection references
	 * 
	 * @author miso partner AnaPescador
	 *
	 */
	private class SimpleRelationship extends
		org.eclipse.zest.layouts.exampleStructures.SimpleRelationship {

		private Object graphData;

		public SimpleRelationship(LayoutEntity sourceEntity,
				LayoutEntity destinationEntity, boolean bidirectional) {
			super(sourceEntity, destinationEntity, bidirectional);
		}

		@Override
		public Object getGraphData() {
			return graphData;
		}

		@Override
		public void setGraphData(Object o) {
			this.graphData = o;
		}
	}

}