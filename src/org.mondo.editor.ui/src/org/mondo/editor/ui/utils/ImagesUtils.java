package org.mondo.editor.ui.utils;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

/**
 * Class of utility functions to work with Images.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class ImagesUtils {

	static final String PLUGIN_ID = "org.mondo.editor.ui";

	/**
	 * Static method to obtain the plugin images descriptor
	 * @param path
	 * @return ImageDescriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path){
		Bundle plugin = Platform.getBundle(PLUGIN_ID);
	    URL url = FileLocator.find(plugin, new Path(path), null);
	    return  ImageDescriptor.createFromURL(url);

	}
}
