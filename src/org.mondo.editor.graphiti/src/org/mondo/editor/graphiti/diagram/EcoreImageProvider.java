package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

/**
 * Class to provide images used in the diagram editor. 
 * 
 * @author miso partner AnaPescador
 *
 */
public class EcoreImageProvider extends AbstractImageProvider {
	 
    protected static final String PREFIX = 
             "org.mondo.editor.graphiti.diagram.";
 
    public static final String IMG_DOWN= PREFIX + "down";
    public static final String IMG_UP= PREFIX + "up";
 
    @Override
    protected void addAvailableImages() {
        addImageFilePath(IMG_DOWN, "icons/down.gif");
        addImageFilePath(IMG_UP, "icons/up.gif");
    }
    
    public void addImage (String id, String path){
    	addImageFilePath(id, path);
    }
    
}
