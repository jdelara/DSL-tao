package org.mondo.editor.ui.utils.layers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

import runtimeLayers.BackgroundLayer;
import runtimeLayers.Layer;
import runtimeLayers.LayerSet;
import runtimeLayers.RuntimeLayersFactory;

/**
 * Class of utility functions to work with runtime layers.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class RuntimeLayersModelUtils {
	
	/**
	 * Static method that returns the layerSet of the diagram
	 * @param diagramBehavior
	 * @return layerSet object, null if the diagramBehavior is incorrect.
	 */
	public static LayerSet getLayerSet(DiagramBehavior diagramBehavior){
		ResourceSet rs = diagramBehavior.getResourceSet();
		List<Resource> res = rs.getResources();
		if (res.size()>=1){
			for (EObject obj: res.get(0).getContents()){
				if (obj instanceof LayerSet)
					return (LayerSet)obj;
			}
		}
		return null;
	}
	
	/**
	 * Static method that creates the layerSet of the diagram
	 * @param resource
	 */
	public static void createLayerSet(Resource resource){
		LayerSet layerSet = RuntimeLayersFactory.eINSTANCE.createLayerSet();
		BackgroundLayer bl= RuntimeLayersFactory.eINSTANCE.createBackgroundLayer();
		bl.setName("Background");
		bl.setVisualised(true);
		bl.setActivated(true);
		layerSet.setBackground(bl);
		resource.getContents().add(layerSet);
	}
	
	
	/**
	 * Static method that returns the list of layers contained by the specified diagram
	 * @param diagramBehavior
	 * @return list of Layer
	 */
	public static List<Layer> getAllLayers (DiagramBehavior diagramBehavior){
		LinkedList<Layer> layers = new LinkedList<Layer>();
		LayerSet ls = getLayerSet(diagramBehavior);
		if (ls != null){
			layers.addAll(ls.getUserLayers());
			layers.add(ls.getBackground());
		}
		return layers;
	}
}