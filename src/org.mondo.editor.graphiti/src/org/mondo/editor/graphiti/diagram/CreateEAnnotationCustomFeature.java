package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;

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
		
    }

}