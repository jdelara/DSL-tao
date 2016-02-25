package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

/**
 * Class to provide images used in the diagram editor. 
 * 
 * @author miso partner AnaPescador
 *
 */
public class MapsImageProvider extends AbstractImageProvider {
	 
    protected static final String PREFIX = 
             "org.mondo.editor.analysis.graphiti.diagram.";
 
    public static final String IMG_LINK= PREFIX + "link";
    public static final String IMG_DELETE_PATTERN_ROLE= PREFIX + "deletePatternRole";
 
    @Override
    protected void addAvailableImages() {
        addImageFilePath(IMG_LINK, "icons/link.gif");
        addImageFilePath(IMG_DELETE_PATTERN_ROLE, "icons/deletePatternRole.gif");
    }
    
    public void addImage (String id, String path){
    	addImageFilePath(id, path);
    }
    
    
}
