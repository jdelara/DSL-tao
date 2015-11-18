package org.mondo.editor.ui.decorators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.mondo.editor.ui.MondoNature;
import org.mondo.editor.ui.utils.ImagesUtils;

/**
 * Class to decorate DSL-tao diagram icon.
 * 
 * @author miso partner AnaPescador
 *
 */
public class MondoDiagramDecorator implements ILightweightLabelDecorator {

	private String iconPathMondo = "icons/mondo.gif";
	private String iconPathAnalysisMondo = "icons/analysisMondo.gif";
	private String iconPathDesignMondo = "icons/designMondo.gif";
	
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public void decorate(Object element, IDecoration decoration) {
	
		IResource resource = (IResource) element;
		if(resource instanceof IFile){
			IFile file = (IFile) resource;
			
			String type= "";
			ResourceSet metaResourceSet = new ResourceSetImpl();
			
			IPath path = file.getFullPath();
			
			if (path != null){ 
				try{
					Resource metaResource = metaResourceSet.getResource(URI.createURI(path.toString()), true);	
					if (metaResource != null){
						for (EObject obj: metaResource.getContents()){
							if (obj instanceof Diagram) 
								type = (((Diagram)obj).getDiagramTypeId());
						}
						ImageDescriptor descriptor=null;
						if ((type.compareToIgnoreCase("mondo")==0)) 
							descriptor = ImagesUtils.getImageDescriptor(iconPathDesignMondo);
						else  if (type.compareToIgnoreCase("mmDSML")==0)
							descriptor = ImagesUtils.getImageDescriptor(iconPathAnalysisMondo);	
						int quadrant = IDecoration.TOP_RIGHT;
						decoration.addOverlay(descriptor,quadrant);
					}
				}catch(Exception e){
					
				}
			}
		} else if (resource instanceof IProject){
			IProject project= (IProject) resource;
			try {
				if (project.getNature(MondoNature.ID)!= null){
					ImageDescriptor descriptor = ImagesUtils.getImageDescriptor(iconPathMondo);
					int quadrant = IDecoration.TOP_RIGHT;
					decoration.addOverlay(descriptor,quadrant);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
		}
	}

}
