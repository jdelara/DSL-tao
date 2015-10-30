package org.mondo.editor.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;


/**
 * Class to create an EReference object into the meta-model.
 * 
 * @author miso partner AnaPescador
 *
 */
public class CreateEReferenceFeature extends AbstractCreateConnectionFeature {
	
	private String rootName = null;
	public CreateEReferenceFeature(IFeatureProvider fp) {
		super(fp, "Association", "adds a new association");
	}
	
	public CreateEReferenceFeature(IFeatureProvider fp, String rootName) {
		super(fp, "Association", "adds a new association");
		this.rootName = rootName;
	}
	
	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		
		Anchor source = context.getSourceAnchor();
		Anchor target = context.getTargetAnchor();
		
		if (source!=null && target!=null &&
		getBusinessObjectForPictogramElement(source.getParent())
		instanceof EClass &&
		getBusinessObjectForPictogramElement(target.getParent())
		instanceof EClass)		
			return true;
		
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {	
		
		Connection newConnection = null;

		PictogramElement source = context.getSourceAnchor().getParent();
		PictogramElement target = context.getTargetAnchor().getParent();
		
		EClass sourceC = (EClass)getBusinessObjectForPictogramElement(source);
		EClass targetC = (EClass)getBusinessObjectForPictogramElement(target);
 
        if (sourceC != null && targetC != null) {
            EReference eReference = null;
            EReference originalRef = (EReference)context.getProperty("EREFERENCE");
            
            if (originalRef == null)  eReference = createEReference(sourceC, targetC);
            else  eReference = createEReference(sourceC, targetC, originalRef);
            	
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context
                    .getTargetAnchor());
            addContext.setNewObject(eReference);
            newConnection =
                (Connection) getFeatureProvider().addIfPossible(addContext);
        }
        
        return newConnection;
	}
	
    private EReference createEReference(EClass source, EClass target) {
        EReference eReference = EcoreFactory.eINSTANCE.createEReference();
        
		String name = "";
		if (this.rootName == null) name = ModelUtils.getRefNameValid(source);
		else name = ModelUtils.getRefNameValid(source, rootName);
        
        eReference.setName(name);
        
        /////TEMPORAL-> cambiado
        //Default values
        //eReference.setOrdered(false);
        //eReference.setUnique(false);
        ////
        
        eReference.setEType(target);
        source.getEStructuralFeatures().add(eReference);
        return eReference;
   }
    
    private EReference createEReference(EClass source, EClass target, EReference ref) {
        EReference eReference = EcoreFactory.eINSTANCE.createEReference();
        
        String name = "";
		if (this.rootName == null) name = ModelUtils.getRefNameValid(source);
		else name = ModelUtils.getRefNameValid(source, rootName);
        eReference.setName(name);
        
        eReference.setEType(target);
        
        eReference.setContainment(ref.isContainment());
        eReference.setLowerBound(ref.getLowerBound());
        eReference.setUpperBound(ref.getUpperBound());
        
        /////TEMPORAL->cambiado
        //eReference.setOrdered(false);
        //eReference.setUnique(false);
        eReference.setOrdered(ref.isOrdered());
        eReference.setUnique(ref.isUnique());
        ////
        
        
        source.getEStructuralFeatures().add(eReference);
        return eReference;
   }
    
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		return source!=null && getBusinessObjectForPictogramElement(source.getParent())
		instanceof EClass;
	}
}