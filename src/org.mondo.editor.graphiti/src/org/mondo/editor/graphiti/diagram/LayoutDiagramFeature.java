package org.mondo.editor.graphiti.diagram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.CompoundDirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.EdgeList;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddBendpointContext;
import org.eclipse.graphiti.features.context.impl.RemoveBendpointContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Class to draw the diagram as a graph.
 * 
 * @author AnaPescador
 *
 */
public class LayoutDiagramFeature extends AbstractCustomFeature {

	//distance between nodes
	private static final int PADDING = 30;


	public LayoutDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getDescription() {
		return "Layout diagram"; 
	}

	@Override
	public String getName() {
		return "Layout Diagram"; 
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		final CompoundDirectedGraph graph = createGraph();
		graph.setDefaultPadding(new Insets(PADDING));
		CompoundDirectedGraphLayout cdgl = new CompoundDirectedGraphLayout();
		cdgl.visit(graph);
		mapDiagram(graph);
	}

	/**
	 * Method that maps the graph coordinates back to the diagram
	 * @param graph
	 * @return
	 */
	private void mapDiagram(CompoundDirectedGraph graph) {
		NodeList myNodes = new NodeList();
		myNodes.addAll(graph.nodes);
		myNodes.addAll(graph.subgraphs);
		for (Object object : myNodes) {
			Node node = (Node) object;
			Shape shape = (Shape) node.data;
			shape.getGraphicsAlgorithm().setX(node.x);
			shape.getGraphicsAlgorithm().setY(node.y);
			shape.getGraphicsAlgorithm().setWidth(node.width);
			shape.getGraphicsAlgorithm().setHeight(node.height);	
		}
		
		Diagram d = getDiagram();
		EList<Connection> connections = d.getConnections();
		for (Connection connection : connections) {
			AnchorContainer source = connection.getStart().getParent();
			AnchorContainer target = connection.getEnd().getParent();
			
			
			Rectangle shape = (Rectangle)source.getGraphicsAlgorithm();
			Rectangle shapeT = (Rectangle)target.getGraphicsAlgorithm();
			
			List<Point> points = ((FreeFormConnection)connection).getBendpoints();
        	while (points.size()!=0){
        		Point bp = points.get(0);
				RemoveBendpointContext rdb = new RemoveBendpointContext((FreeFormConnection)connection,bp);
				getFeatureProvider().getRemoveBendpointFeature(rdb).execute(rdb);
			}
			
			if (shape.equals(shapeT)){
				int x = shape.getX();
	        	int y = shape.getY();
	        	int desp = 50;
	        	
				AddBendpointContext apc1 = new AddBendpointContext((FreeFormConnection)connection, x+shape.getWidth()/2, y-desp, 0);
		    	AddBendpointContext apc2 = new AddBendpointContext((FreeFormConnection)connection,x+shape.getWidth()+desp, y-desp, 0);
		    	AddBendpointContext apc3 = new AddBendpointContext((FreeFormConnection)connection, x+shape.getWidth()+desp, y+shape.getHeight()/2, 0);
		    	
		    	getFeatureProvider().getAddBendpointFeature(apc1).execute(apc1);
		    	getFeatureProvider().getAddBendpointFeature(apc2).execute(apc2);
		    	getFeatureProvider().getAddBendpointFeature(apc3).execute(apc3);
			}
		}
	}

	/**
	 * Method that maps the diagram to a graph
	 * @return CompoundDirectedGraph
	 */
	private CompoundDirectedGraph createGraph() {
		Map<AnchorContainer, Node> shapeToNode = new HashMap<AnchorContainer, Node>();
		Diagram d = getDiagram();
		CompoundDirectedGraph dg = new CompoundDirectedGraph();
		EdgeList edgeList = new EdgeList();
		NodeList nodeList = new NodeList();
		EList<Shape> children = d.getChildren();
		for (Shape shape : children) {
			if (getBusinessObjectForPictogramElement(shape)!= null){
				Node node = new Node();
				GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
				node.x = ga.getX();
				node.y = ga.getY();
				node.width = ga.getWidth();
				node.height = ga.getHeight();
				node.data = shape;
				shapeToNode.put(shape, node);
				nodeList.add(node);
			}
		}
		EList<Connection> connections = d.getConnections();
		for (Connection connection : connections) {
			AnchorContainer source = connection.getStart().getParent();
			AnchorContainer target = connection.getEnd().getParent();
			
			Object eclass = getBusinessObjectForPictogramElement(source);
			Object eclassT = getBusinessObjectForPictogramElement(target);
			
			if (!eclass.equals(eclassT)){
				Edge edge = new Edge(shapeToNode.get(source), shapeToNode.get(target));
				edge.data = connection;
				edgeList.add(edge);
			}
		}
		dg.nodes = nodeList;
		dg.edges = edgeList;
		return dg;
	}
}