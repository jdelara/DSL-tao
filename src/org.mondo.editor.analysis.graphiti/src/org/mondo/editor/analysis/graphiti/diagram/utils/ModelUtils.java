package org.mondo.editor.analysis.graphiti.diagram.utils;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.MindMap;
import mindMapDSML.MindMapDSMLFactory;

/**
 * Class of utility functions to work with mindMapDSML ecore.
 * 
 * @author miso partner AnaPescador
 *
 */
public  class ModelUtils {
	
	/**
	 * Static method that returns the main ePackage of the diagram.If it doesn't exist, the EPackage is created.
	 * @param diagram 
	 * @return EPackage.
	 */
	public static MindMap getBusinessModel (Diagram diagram) {
		MindMap mm = null;
        if (diagram!=null) {
        	mm = (MindMap)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
            // if mindMap does not exist, create new one
            if (mm == null) {
            	mm = MindMapDSMLFactory.eINSTANCE.createMindMap();
            	mm.setName("");
	            diagram.eResource().getContents().add(mm);
            }
        }
        return mm;
    }
	
	/**
	 * Static method that returns if the mind map has been created.
	 * @param diagram 
	 * @return boolean - true created, false not created.
	 */
	public static boolean existsMindMap(Diagram diagram) {
		MindMap pack = null;
        if (diagram!=null) {
        	pack = (MindMap)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
        }
        return pack!=null;	
	}
	
	/**
	 * Static method that returns a valid idea name.
	 * @param diagram
	 * @param idea
	 * @return String - name.
	 */
	public static String getIdeaNameValid(Diagram diagram, Idea superIdea){
		String name = "Idea";
		return getIdeaNameValid(diagram, name, superIdea);
	}
	
	/**
	 * Static method that returns a valid eClass name.
	 * @param diagram
	 * @param name rootName
	 * @param idea
	 * @return String - name.
	 */
	public static String getIdeaNameValid(Diagram diagram, String name, Idea superIdea){
		boolean enc = true;
		int cont = 0;
		while (enc){
			cont++;
			enc = existsIdeaName(diagram, name+cont, superIdea);
		}
		return name+cont;
	}
	
	/**
	 * Static method that returns if the specified eClass exists on the diagram argument.
	 * @param diagram
	 * @param name
	 * @param idea
	 * @return boolean - true exists, false not exists
	 */
	public static boolean existsIdeaName(Diagram diagram, String name, Idea superIdea){
		if (superIdea != null){
			for (Idea idea : superIdea.getContains()){
				if (idea.getName().compareTo(name)==0)
					return true;
			}
		}else {
			MindMap mm = getBusinessModel(diagram);
			for (Idea idea : mm.getIdeas()){
				if (idea.getName().compareTo(name)==0)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Static method that returns if the idea id to assign.
	 * @param diagram
	 * @param idea
	 * @return String - id value
	 */
	public static String getIdeaID(Diagram diagram, Idea idea){
		if (idea.eContainer() instanceof Idea){
			Idea superIdea = (Idea)idea.eContainer();
			return superIdea.getId()+"."+(superIdea.getContains().indexOf(idea)+1);	
		}else {
			MindMap mm = getBusinessModel(diagram);
			return String.valueOf(mm.getIdeas().indexOf(idea)+1);
		}
	}
	
	/**
	 * Static method that returns if the idea doesn't have parents.
	 * @param idea
	 * @return "true" if it has, "false" if it doesn't have
	 */
	public static boolean isFirstLevel ( Idea idea){
		return (idea.eContainer() instanceof MindMap);
	}
	
	/**
	 * Static method that returns if the ideas are the same or parent-child.
	 * @param parent
	 * @param child
	 * @return  "true" if they are, "false" if they aren't
	 */
	public static boolean isChild(Idea parent, Idea child){
		return child.getId().startsWith(parent.getId());
	}
	
	/**
	 * Static method that returns an feature valid key for the specified element.
	 * @param element
	 * @return String key.
	 */
	public static String getFeatureKeyValid(Idea element){
		String name = "feature";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsFeatureKey(element, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
	/**
	 * Static method that returns if the specified feature key exists in the element argument.
	 * @param element - Idea
	 * @param key
	 * @return boolean - true exists, false doesn't exist.
	 */
	public static boolean existsFeatureKey(Idea element, String key){
		for (Feature feat: element.getFeatures()){
			if (feat.getKey().compareTo(key)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the key (name) exists on the note annotation argument.
	 * @param annot - eAnnotation
	 * @param name
	 * @return boolean - true exists, false doesn't exist.
	 */
	public static boolean existsNoteKey(EAnnotation annot, String name){
		for (int i = 0; i<annot.getDetails().size();i++){
			if (annot.getDetails().get(i).getKey().compareTo(name) ==0) 
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns an eAnnotation valid key for the note eannotation given.
	 * @param annot - eAnnotation
	 * @return String - name
	 */
	public static String getNoteKeyValid(EAnnotation annot){
		String name = "note";
		boolean enc = true;
		int cont = -1;
		while (enc){
			cont++;
			enc = existsNoteKey(annot, name+(cont==0?"":cont));
		}
		return name+(cont==0?"":cont);
	}
	
}
