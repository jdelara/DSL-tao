package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;

/**
 * Class to provide the functionalities available in the diagram editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EcoreFeatureProvider extends DefaultFeatureProvider {

	public EcoreFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreateEPackageFeature(this), new CreateEClassFeature(this), new CreateEEnumFeature(this), new CreateEAttributeFeature(this), new CreateEEnumLiteralFeature(this), new CreateEAnnotationFeature(this) };
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature []{ new CreateESuperTypeFeature(this), new CreateEReferenceFeature(this)};
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) { 
		if (context.getNewObject() instanceof EClass) {
			return new AddEClassFeature(this);
		} else if (context.getNewObject() instanceof EEnum) {
			return new AddEEnumFeature(this);
		} else if (context.getNewObject() instanceof EReference) {
			return new AddEReferenceFeature(this);
		} else if (context.getNewObject() instanceof EAttribute) {
			return new AddEAttributeFeature(this);
		} else if (context.getNewObject() instanceof EEnumLiteral) {
			return new AddEEnumLiteralFeature(this);
		} else if (context.getNewObject() instanceof EPackage){
			return new AddEPackageFeature(this);
		}
		return new AddESuperTypeFeature(this);		
	}
	
	@Override
    public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof EEnum){
            return new ResizeEEnumFeature(this);
        } else if (bo instanceof EClass){
        	return new ResizeEClassFeature(this);
        } else if (bo == null && shape.getProperties().size()>0) {
			for (Property p: shape.getProperties()) {
				if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_PATTERN_NAMES))
					return new ResizePatternNamesFeature(this);	
			}
		}
		return super.getResizeShapeFeature(context);
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof EPackage){
        	return new DeleteEPackageFeature(this);
        }else if (bo instanceof EAttribute) {
	        return new DeleteEAttributeFeature(this);
	    } if (bo instanceof EEnumLiteral) {
	        return new DeleteEEnumLiteralFeature(this);
	    }  if (bo instanceof EReference) {
	        return new DeleteEReferenceFeature(this);
	    } if (bo instanceof EClass){
	    	return new DeleteEClassFeature(this);
	    } else if (bo == null && pictogramElement.getProperties().size()>0) {
			for (Property p: pictogramElement.getProperties()) {
				if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_INHERITANCE))
					return new DeleteESuperTypeFeature(this);		
			}
		}
		return new DeleteEModelElementDefaultFeature(this);
	}
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
	    PictogramElement pe = context.getPictogramElement();
	    Object bo = getBusinessObjectForPictogramElement(pe);
	    if (bo instanceof EClass) {
	        return new DirectEditEClassFeature(this);
	    } else if (bo instanceof EEnum){
	    	return new DirectEditEEnumFeature(this);
	    } else if (bo instanceof EAttribute){
	    	return new DirectEditEAttributeFeature(this);
	    } else if (bo instanceof EEnumLiteral){
	    	return new DirectEditEEnumLiteralFeature(this);
	    } 
	    return super.getDirectEditingFeature(context);
	 }

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);
	    if (bo instanceof EAttribute) {
	        return new MoveEAttributeFeature(this);
	    }else if (bo instanceof EEnumLiteral)
	    	return new MoveEEnumLiteralFeature(this);	
		return super.getMoveShapeFeature(context);
	}
	
	@Override
	public IReconnectionFeature getReconnectionFeature(
			IReconnectionContext context) {
		Connection con = context.getConnection();
	    Object bo = getBusinessObjectForPictogramElement(con);
	    if (bo instanceof EReference) 
	        return new ReconnectionEReferenceFeature(this);
	    else if (bo == null && con.getProperties().size()>0) {
			for (Property p: con.getProperties()) {
				if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_INHERITANCE))
					return new ReconnectionESuperTypeFeature(this);
			}
	    }
	    return super.getReconnectionFeature(context);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if (pictogramElement  instanceof ContainerShape) {
	       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	       if (bo instanceof EAttribute) {
	           return new UpdateEAttributeFeature(this);
	       } else if (bo instanceof EPackage){
	    	   if (!(pictogramElement instanceof Diagram))
	    		   return new UpdateEPackageFeature(this);
	       } else if (bo instanceof EClass){
	    	   return new UpdateEClassFeature(this); 
	       }
	   }
	   return super.getUpdateFeature(context);
	 }
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		
		if (context.getPictogramElements()[0] instanceof Diagram){
			ICustomFeature[] basicCf =  new ICustomFeature[] { new ValidateAllFeature(this), 
				new ImportMetamodelFeature(this), 
				new ExportMetamodelFeature(this), 
				new ExportMetamodelPatternsFeature(this),
		    	new ProcessMetaModelFeature(this),
		    	new CollapseAllFeature(this), new ExpandAllFeature(this), 
	    		new CollapseInheritanceFeature(this), new ExpandInheritanceFeature(this),
	    		new ShowPatternInfoFeature(this),new HidePatternInfoFeature(this),
	    		new DrillDownEPackageFeature(this),
	    		new LayoutDiagramFeature(this)};
		
		List<ICustomFeature> list = new ArrayList<ICustomFeature>(Arrays.asList(basicCf));
		
		
		ICustomFeature[] cfs = new ICustomFeature[list.size()];
		for (int i=0; i<list.size(); i++){
			cfs[i] = list.get(i);
		}
		return cfs;
		} return new ICustomFeature[]{new DrillDownEPackageFeature(this)}; 
	}

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return new RemoveEModelElementDefaultFeature(this);
	} 	
}
