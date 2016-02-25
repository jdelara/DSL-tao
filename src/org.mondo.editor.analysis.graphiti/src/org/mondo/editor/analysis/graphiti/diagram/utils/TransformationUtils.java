package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
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
	
	public static final TransformationOption COMMA_TO_ENUM = new TransformationOption("COMMA_TO_ENUM", "Values separated by comma to Enum", "img/toEnum.jpg");

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
	        case "COMMA_TO_ENUM":
	        	if (eObject instanceof Feature) return  true;
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
		return Pattern.matches("(^|(\\w|\\W)*\\s)(may(-|\\s)be|can(-|\\s)be|is(-|\\s)a)(\\s(\\w|\\W)*|$)", subtext);
	}
	
	/**
	 * Static method that returns if the link could represent an optional reference in a design meta-model.
	 * @param link
	 * @return boolean, true if it could be, false if not.
	 */
	private static boolean isOptionalReference (Link link){
		String text = link.getName();
		return Pattern.matches("(^|(\\w|\\W)*\\s)(can(-|\\s)have|can)(\\s(\\w|\\W)*|$)", text);
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
		return Pattern.matches("(^|(\\w|\\W)*\\s)(can(-|\\s)have|can)(\\s(\\w|\\W)*|$)", subtext);
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
	 * @param commas - boolean that indicate that if the string has commas 
	 * it'll be converted into a enum.
	 * @return eclassifier object
	 */
	public static EClassifier getEType (Feature feature, Boolean commas){
		String text = feature.getValue();
		if ((text.contains("true")) || (text.contains("false")))
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
			if (commas){
				String[] cads = text.split(",");
				if (cads.length >1){
					//Create enum
					EEnum enumerator = EcoreFactory.eINSTANCE.createEEnum();
					enumerator.setName(WordUtils.toCamelCase(feature.getKey(), true)+"Type");
					for (String cad: cads) {
						if (cad.startsWith(" ")) cad = cad.replaceFirst(" ", "");
						if (cad.endsWith(" ")) cad = cad.substring(0, cad.length()-1);
						EEnumLiteral enumL = EcoreFactory.eINSTANCE.createEEnumLiteral();
						enumL.setName(cad);
						enumL.setLiteral(cad);
						enumerator.getELiterals().add(enumL);
					}
					return enumerator;
				}
			}
		}
		//type by name
		if ((text.compareToIgnoreCase("int")==0) || (text.compareToIgnoreCase("integer")==0)) 
			return EcoreFactory.eINSTANCE.getEcorePackage().getEInt();
		else if (text.compareToIgnoreCase("double")==0)  
			return EcoreFactory.eINSTANCE.getEcorePackage().getEDouble();
		else if ((text.compareToIgnoreCase("bool")==0) || (text.compareToIgnoreCase("boolean")==0))  
			return EcoreFactory.eINSTANCE.getEcorePackage().getEBoolean();
				
		return EcoreFactory.eINSTANCE.getEcorePackage().getEString();
	}
	
	/**
	 * Static method that returns the default value of the feature.
	 * @param feature
	 * @param comma 
	 * @return string
	 */
	public static String getDefaultValue (Feature feature, boolean commas){
		String text = feature.getValue();
		if ((text.compareToIgnoreCase("int")==0) || (text.compareToIgnoreCase("integer")==0) 
			|| (text.compareToIgnoreCase("double")==0))
			return "0";
		else if (text.compareToIgnoreCase("string")==0) return "";
		else if ((text.compareToIgnoreCase("bool")==0) || (text.compareToIgnoreCase("boolean")==0))
			return "false";
		else if (commas){ 
			String[] cads = text.split(",");
			if (cads[0].endsWith(" ")) cads[0] = cads[0].substring(0, cads[0].length()-1);
			return cads[0];
		}
		return text;
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
