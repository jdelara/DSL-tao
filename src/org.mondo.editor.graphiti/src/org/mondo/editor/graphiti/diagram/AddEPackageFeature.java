package org.mondo.editor.graphiti.diagram;


import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.graphiti.diagram.utils.Utils;

/**
 * Class to add an EPackage object into the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */

public class AddEPackageFeature extends AbstractAddFeature {
	public AddEPackageFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof EPackage && context.getTargetContainer() instanceof Diagram;
	}
	
	private Diagram newDiagram = null;

	public Diagram getNewDiagram() {
		return newDiagram;
	}

	public void setNewDiagram(Diagram newDiagram) {
		this.newDiagram = newDiagram;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		int width = DiagramStyles.PACKAGE_WIDTH, height = DiagramStyles.PACKAGE_HEIGHT;
				
		final EPackage newEPackage = (EPackage)context.getNewObject();
		
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape container = null;
		
		container = peCreateService.createContainerShape(targetDiagram, true);
		
		int tabWidth = 100;
		int tabHeight = 25;
		
		int xy[] = new int[] {0,0, tabWidth,0, tabWidth,tabHeight, width,tabHeight, width,height, 0,height};
        Polygon figure = gaService.createPolygon(container, xy);
		figure.setForeground(manageColor(DiagramStyles.PACKAGE_FOREGROUND));
		figure.setBackground(manageColor(DiagramStyles.PACKAGE_BACKGROUND));

		figure.setLineWidth(2);
		gaService.setLocationAndSize(figure, context.getX(), context.getY(),width, height);
		figure.setFilled(true);	
		
		Shape shapeLine = peCreateService.createShape(container, false); 
		Polyline polyline = gaService.createPolyline(shapeLine, new int[] { 0, tabHeight, tabWidth, tabHeight});
		polyline.setForeground(manageColor(DiagramStyles.PACKAGE_FOREGROUND));
		polyline.setLineWidth(2);
		
		link(container, newEPackage);
		
		
		Shape shapeText = peCreateService.createShape(container, false);
		Text text = gaService.createText(shapeText,newEPackage.getName());
		text.setForeground(manageColor(DiagramStyles.PACKAGE_TEXT_FOREGROUND)); 
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, /*75*/55, width, 20);
		text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.EXTRA_BIG_SIZE_FONT, false, true));
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DiagramUtils.TYPE_TEXT);		
		text.getProperties().add(marker);
		
		link(shapeText, newEPackage);
		peCreateService.createChopboxAnchor(container);
		
		//Related diagram
		String diagramName = "."+getDiagram().getName().replaceAll(".diagram", "") +newEPackage.getName();
		final Diagram diagram = Graphiti.getPeCreateService().createDiagram("mondo", diagramName, true);
		setNewDiagram(diagram);
		Resource resource = getDiagram().eResource();
		URI uriTrimmed = resource.getURI().trimFragment();
		
		String platformString = uriTrimmed.toPlatformString(true);
		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			
		String uriS =(new File(fileResource.getParent().getLocation().append(diagramName+".diagram").toString())).toURI().toString();
		
		ResourceSet metaResourceSet = new ResourceSetImpl();
	 
		final Resource metaResource = metaResourceSet.createResource(URI.createURI(uriS));	
		
		final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();
		dp.init(diagram, dp.getDiagramBehavior());
		
		TransactionalEditingDomain editingDomain = GraphitiUi.getEmfService().createResourceSetAndEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
	
			@Override
			protected void doExecute() {
				DiagramUtils.initPatternInfo(diagram);
				
				metaResource.getContents().add(diagram);
				dp.getFeatureProvider().link(diagram, newEPackage);	
				
				Object[] pics = getFeatureProvider().getAllBusinessObjectsForPictogramElement(getDiagram());
				Object[] businessObjects = Utils.addObjectArray(pics, newEPackage);
				link(getDiagram(), businessObjects);	
			}
		});
		try {
			IResourceUtils.saveResource(metaResource);
			fileResource.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return container;
	}
}
