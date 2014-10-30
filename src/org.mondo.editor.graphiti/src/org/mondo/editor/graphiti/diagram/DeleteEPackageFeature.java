package org.mondo.editor.graphiti.diagram;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;


/**
 * Class to deleten an EPackage object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeleteEPackageFeature extends DeleteEModelElementDefaultFeature {
	
	public DeleteEPackageFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		EPackage epack = (EPackage)getBusinessObjectForPictogramElement(pe);
		Collection<Diagram> diagrams = DiagramUtils.getRecursiveLinkedDiagrams(this.getFeatureProvider(), epack);
		for (Diagram diagram: diagrams){
			IFile file = IResourceUtils.getFile(diagram.eResource());
			
			try {
				file.delete(true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		super.preDelete(context);
	}
	
	@Override
	public void postDelete(IDeleteContext context) {
		super.postDelete(context);
	}
		
}
