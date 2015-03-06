package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;


/**
 * Class to create an EAnnotationEntry object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEAnnotationEntryFeature extends AbstractCreateFeature {
	
	private EAnnotation annotation = null;
	private String key = null;

	
	/**
	 * Normal EAnnotation (value is null)
	 * @param fp - feature provider
	 * @param annotation - EAnnotation
	 * @param key - String that contains the key of the EStringToStringMapEntry
	 */
	public CreateEAnnotationEntryFeature(IFeatureProvider fp, EAnnotation annotation, String key) {
		super(fp, "Annotation Entry", "Create a new Annotation entry");
		this.annotation = annotation;
		this.key = key;		
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return ((annotation != null) && (annotation.getDetails().get(key)==null));
	}

	@Override
	public Object[] create(ICreateContext context) {
		
		EClass entryClass = EcoreFactory.eINSTANCE.getEcorePackage().getEStringToStringMapEntry();
		EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(entryClass);
		entry.setKey(key);
		entry.setValue(key.replace("Key", "Value"));
		
		annotation.getDetails().add(entry);
		
		return new Object[] { entry};
	}
}
