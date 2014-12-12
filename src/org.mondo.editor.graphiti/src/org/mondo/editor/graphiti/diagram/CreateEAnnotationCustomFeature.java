package org.mondo.editor.graphiti.diagram;


import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.Utils;

/**
 * Class to create an EAnnotation object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEAnnotationCustomFeature extends AbstractCustomFeature {
 
    private EModelElement object;
    private String text = null;
    private EAnnotation annotation = null;
    
    public EAnnotation getAnnotation() {
		return annotation;
	}
    
    /**
     * Pattern EAnnotation
     * @param fp - feature provider
     * @param obj - EModelElement
     * @param text - string that contains the annotation text.
     */
	public CreateEAnnotationCustomFeature(IFeatureProvider fp, EModelElement obj, String text) {
        super(fp);
        this.object = obj;
        this.text = text;
    }
    
	/**
	 * Normal EAnnotation
	 * @param fp - feature provider
	 * @param obj - EModelElement
	 */
    public CreateEAnnotationCustomFeature(IFeatureProvider fp, EModelElement obj) {
        super(fp);
        this.object = obj;
    }
 
   
 
    @Override
    public boolean canExecute(ICustomContext context) {
        return true;
    }
    
    
    
	@Override
    public void execute(ICustomContext context) {    
    	
    	annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		if (text==null)annotation.setSource(ModelUtils.getAnnotationSourceValid(object));
		else annotation.setSource(text);
		this.object.getEAnnotations().add(annotation);
		
		if (text != null){
			String textPic = DiagramUtils.getEAnnotationPictogramText(getDiagram(), annotation);
			if (textPic != null){

				if ((!textPic.isEmpty())&&(!textPic.endsWith("\n"))) textPic += "\n";
				textPic += "@"+this.text;
				PictogramElement pe = DiagramUtils.paintEAnnotationText(getDiagram(), annotation, textPic);
				
				if (pe!=null) {
					Object[] pics = getFeatureProvider().getAllBusinessObjectsForPictogramElement(pe);
					Object[] businessObjects = Utils.addObjectArray(pics, annotation);
					link(pe, businessObjects);
				}
				
			} else if (annotation.getEModelElement() instanceof EPackage) {
	    		IPeCreateService peCreateService = Graphiti.getPeCreateService();
	            IGaService gaService = Graphiti.getGaService();
	            
	            ContainerShape container = null;
	    		container = peCreateService.createContainerShape(getDiagram(), true);
	    		
	    		Property markerDelete = MmFactory.eINSTANCE.createProperty();
	    		markerDelete.setKey("delete");
	    		markerDelete.setValue(DiagramUtils.NOT_DELETE);		
	    		container.getProperties().add(markerDelete);
	    		
	    		Property markerRemove = MmFactory.eINSTANCE.createProperty();
	    		markerRemove.setKey("remove");
	    		markerRemove.setValue(DiagramUtils.NOT_REMOVE);		
	    		container.getProperties().add(markerRemove);
	    		
	    		Property markerType = MmFactory.eINSTANCE.createProperty();
	    		markerType.setKey("type");
	    		markerType.setValue(DiagramUtils.TYPE_PATTERN_NAMES);		
	    		container.getProperties().add(markerType);
	    		
	    		Rectangle figure = gaService.createRectangle(container);
	    		figure.setFilled(false);
	    		figure.setLineVisible(false);
	    		gaService.setLocationAndSize(figure, 0, 0, 300, 75);
	    		
	            Shape shapeText = peCreateService.createShape(container, false);
	    		Text text = gaService.createText(shapeText,"@"+annotation.getSource());
	    		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
	    		gaService.setLocationAndSize(text, 0, 0, 300, 75);
	    		text.setFont(gaService.manageFont(getDiagram(), "Verdana", DiagramStyles.BIG_SIZE_FONT, false, true));
	    		text.setForeground(manageColor(DiagramStyles.ANNOTATION_FOREGROUND));

    		
	    		Property marker = MmFactory.eINSTANCE.createProperty();
	    		marker.setKey("type");
	    		marker.setValue(DiagramUtils.TYPE_ANNOTATION);		
	    		text.getProperties().add(marker);
	    		
	    		shapeText.setVisible(DiagramUtils.isShowAnnotations(getDiagram()));
    		
	    		Object[] businessObjects ={annotation.getEModelElement(), annotation};
				link(shapeText, businessObjects);
				
			} 
		}
    }

}