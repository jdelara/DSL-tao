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
    public static final String IMG_EREFERENCE= PREFIX + "eReference";
    public static final String IMG_ESUPERTYPE= PREFIX + "eSuperType";
 
    @Override
    protected void addAvailableImages() {
        addImageFilePath(IMG_DOWN, "icons/down.gif");
        addImageFilePath(IMG_UP, "icons/up.gif");
        addImageFilePath(IMG_EREFERENCE, "icons/eReference.gif");
        addImageFilePath(IMG_ESUPERTYPE, "icons/eSuperType.gif");
    }
    
    public void addImage (String id, String path){
    	addImageFilePath(id, path);
    }
    
}
