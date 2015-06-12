package org.mondo.editor.graphiti.diagram.utils;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Class of utility functions to work with IResources. 
 * 
 * @author miso partner AnaPescador
 *
 */
public class IResourceUtils {

	/**
	 * Static method that returns the uri by IFile and ResourceSet.
	 * @param file
	 * @param resourceSet
	 * @return URI
	 */
	public static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}

	/**
	 * Static method that returns the Ifile of the specified resource
	 * @param resource
	 * @return IFile
	 */
	public static IFile getFile(Resource resource) {
	    if (resource != null) { 
			URI uri = resource.getURI(); 
			uri = resource.getResourceSet().getURIConverter().normalize(uri); 
			String scheme = uri.scheme(); 
			if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) { 
				StringBuffer platformResourcePath = new StringBuffer(); 
				for (int j = 1, size = uri.segmentCount(); j < size; ++j) { 
					platformResourcePath.append('/'); 
					platformResourcePath.append(uri.segment(j)); 
				} 
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString())); 
			} 
	    } 
	    return null; 
	 }


	
	
	/**
	 * Static method that returns the IProject contained on the specified resource.
	 * @param resource
	 * @return IProject
	 */
	public static IProject getProject(Resource resource){
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		
		if (uriTrimmed.isPlatformResource()){
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		
			if (fileResource != null){
				IProject project = fileResource.getProject();
				return project;
			}
		}
		return null;
	}
	
	/**
	 * Static method for turning and unformatted the specified object into an IFile instance.
	 * @param object - the object
	 * @return IFile, null if it's not possible.
	 */
	public static IFile convertObjectToIFile(Object object) {
		if (object instanceof IFile) {
			return (IFile) object;
		}
		if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			IFile file = (IFile) adaptable.getAdapter(IFile.class);

			if (file != null) {
				return file;
			}
		}
		return null;
	}
	
	public static String getValidDiagramIFileName (IContainer container, String initName){
		String[] initNameV = initName.split(".diagram");
		String possibleName = initNameV[0]+".diagram";
		
		int cont = 1;
		while (true){
		if (!container.exists(new Path(possibleName)))
			return possibleName;
		else possibleName = initNameV[0]+"("+cont+")"+ ".diagram";
		cont++;
		}
	}
	
	public static boolean saveResource(Resource resource){
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
