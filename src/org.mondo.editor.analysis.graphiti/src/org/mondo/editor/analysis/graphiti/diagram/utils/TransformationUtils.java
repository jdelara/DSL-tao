package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.Link;

public final class TransformationUtils {

	public static final TransformationOption IDEA_TO_SINGULAR  = new TransformationOption("IDEA_TO_SINGULAR", "Idea names to singular ", "img/pluralToSingular.jpg");
	public static final TransformationOption FEATURE_TO = new TransformationOption("FEATURE_TO", "Features to:  ", "img/toClasstoAttribute.jpg");
	public static final TransformationOption BIDIRECTIONAL_CONTAINMENT = new TransformationOption("BI_CONTAINMENT", "Bidirectional Containment", "img/biContainment.jpg");
	public static final TransformationOption OPTIONAL_REFERENCE = new TransformationOption("OPTIONAL_REFERENCE", "Optional Reference", "img/optional.jpg");
	public static final TransformationOption MULTIPLICITY = new TransformationOption("MULTIPLICITY", "Multiplicity Reference","img/multiplicity.jpg");
	public static final TransformationOption INHERITANCE = new TransformationOption("INHERITANCE", "Inheritance", "img/inheritance.jpg");
	public static final TransformationOption NOTE_TO_ANNOTATION = new TransformationOption("NOTE_TO_ANNOTATION", "Note to Annotation", "img/noteToAnnotation.jpg");

	public static final String IMAGES_FOLDER = "img";
	
	public static boolean fulfillCondition(TransformationOption transformationOption, EObject eObject, Map<String, Boolean> options){
		Boolean selected = options.get(transformationOption.getKey());
		if (selected)
			switch (transformationOption.getKey()) {
	        case "IDEA_TO_SINGULAR": return true;
	        case "FEATURE_TO": return true;
	        case "BI_CONTAINMENT": return true;
	        case "OPTIONAL_REFERENCE": 
	        	if (eObject instanceof Link) return isOptionalReference((Link)eObject);
	        	else if (eObject instanceof Idea) return isOptionalReference((Idea)eObject);
	        case "MULTIPLICITY": 
	        	if (eObject instanceof Link) return isMultipleReference((Link)eObject);
	        	else if (eObject instanceof Idea) return isMultipleReference((Idea)eObject);
	        case "INHERITANCE": 
	        	if (eObject instanceof Idea) return canBeInheritance((Idea)eObject);
	        case "NOTE_TO_ANNOTATION": 
	        	if (eObject instanceof Idea) return !((Idea)eObject).getNotes().isEmpty();
	        default: return false;
			} 
		return false;
	}
	
	/**
	 * Static method that returns if the idea could represent an inherited class in a design meta-model.
	 * @param idea
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean canBeInheritance (Idea idea){
		String subtext = idea.getSubText();
		return Pattern.matches("(^|(\\w|\\s)*\\s)(may(-|\\s)be|can(-|\\s)be|is(-|\\s)a)(\\s(\\w|\\s)*|$)", subtext);
	}
	
	/**
	 * Static method that returns if the link could represent an optional reference in a design meta-model.
	 * @param link
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean isOptionalReference (Link link){
		String text = link.getName();
		return Pattern.matches("(^|(\\w|\\s)*\\s)(can(-|\\s)have|can)(\\s(\\w|\\s)*|$)", text);
	}
	
	/**
	 * Static method that returns if the link could represent a reference with upper bound "-1" in a design meta-model.
	 * @param link
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean isMultipleReference (Link link){
		Idea idea = link.getTarget();
		String text = idea.getName();
		return WordUtils.isPlural(text);
	}
	
	/**
	 * Static method that returns if the idea could represent an optional reference in a design meta-model.
	 * @param idea
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean isOptionalReference (Idea idea){
		String subtext = idea.getSubText();
		return Pattern.matches("(^|(\\w|\\s)*\\s)(can(-|\\s)have|can)(\\s(\\w|\\s)*|$)", subtext);
	}
	
	/**
	 * Static method that returns if the idea could represent a reference with upper bound "-1" in a design meta-model.
	 * @param idea
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean isMultipleReference (Idea idea){
		String text = idea.getName();
		return WordUtils.isPlural(text);
	}
	
	/**
	 * Static method that returns the type for the eattribute.
	 * @param feature
	 * @return eclassifier object
	 */
	public static EClassifier getEType (Feature feature){
		String text = feature.getValue();
		if ((text.contains("true"))
			|| (text.contains("false")))
			return EcoreFactory.eINSTANCE.getEcorePackage().getEBoolean();
		else {
			try {
		        Integer.parseInt( text );
		        return EcoreFactory.eINSTANCE.getEcorePackage().getEInt();
		    }
		    catch( Exception e ) {
		    	try {
			        Double.parseDouble( text );
			        return EcoreFactory.eINSTANCE.getEcorePackage().getEDouble();
			    }
			    catch( Exception e2 ) {
			    }
		    }
		}
		//literalmente establecemos el tipo
		if ((text.compareToIgnoreCase("int")==0) || (text.compareToIgnoreCase("integer")==0)) 
			return EcoreFactory.eINSTANCE.getEcorePackage().getEInt();
		else if (text.compareToIgnoreCase("double")==0)  
			return EcoreFactory.eINSTANCE.getEcorePackage().getEDouble();
		
		
		return EcoreFactory.eINSTANCE.getEcorePackage().getEString();
	}
	
	/**
	 * Static method that returns the reference name related to the idea
	 * @param idea
	 * @return reference name
	 */
	public static String getNameRef (Idea idea){
		String text = idea.getSubText();
		if (!text.isEmpty()) return WordUtils.toCamelCase(text, false);
		else return WordUtils.toPlural(WordUtils.toCamelCase(idea.getName(), false));
	}
	
	/**
	 * Static method that returns the reference name related to the link
	 * @param link
	 * @return reference name
	 */
	public static String getNameRef(Link link){
		String text = link.getName();
		if (!text.isEmpty()) return WordUtils.toCamelCase(text, false);
		else return WordUtils.toPlural(WordUtils.toCamelCase((link.getTarget()!=null?link.getTarget().getName():"ref"), false));
	}
	
	/**
	 * Static method that returns the opposite reference name related to the idea
	 * @param idea
	 * @return opposite ref name
	 */
	public static String getNameRefOpp (Idea idea){
		if (idea.eContainer() instanceof Idea){
			Idea parent = (Idea)idea.eContainer();
			return WordUtils.toSingular(WordUtils.toCamelCase(parent.getName(), false));
		}
		return "opp";	
	}
	
}
