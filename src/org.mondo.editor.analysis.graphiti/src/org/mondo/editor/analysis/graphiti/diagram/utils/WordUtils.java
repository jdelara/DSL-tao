package org.mondo.editor.analysis.graphiti.diagram.utils;

/**
 * Class of utility functions to work with Objects
 * 
 * @author miso partner AnaPescador
 *
 */
public final class WordUtils {
	
	/**
	 * Static method that transforms a string with blank spaces to camel case style.
	 * @param s
	 * @return the changed string
	 */
	public static String toCamelCase(String s, boolean firstUpperCase){
	   String[] parts = s.split(" ");
	   String camelCaseString = "";
	   for (String part : parts){
	      camelCaseString = camelCaseString + toProperCase(part, firstUpperCase);
	      if (!firstUpperCase) firstUpperCase = true;
	   }
	   return camelCaseString;
	}

	/**
	 * Static method that changes the first char to upper case and
	 * the rest to lowerCase
	 * @param s
	 * @return the changed string
	 */
	public static String toProperCase(String s, boolean firstUpperCase) {
	    return (firstUpperCase?s.substring(0, 1).toUpperCase(): s.substring(0, 1).toLowerCase()) +
	               s.substring(1).toLowerCase();
	}

	/**
	 * Static method that returns if a text is plural or not.
	 * @param text
	 * @return boolean, true if it's, false if not.
	 */
	public static boolean isPlural (String text){
		return LexicalInflector.isPlural(text);
	}

	/**
	 * Static method that returns the singular form of a text, if the text is singular returns the text without modifications.
	 * @param text
	 * @return the text in singular.
	 */
	public static String toSingular (String text){
		return LexicalInflector.singularize(text);
	}
	
	/**
	 * Static method that returns the plural form of a text, if the text is plural returns the text without modifications.
	 * @param text
	 * @return the text in plural.
	 */
	public static String toPlural (String text){
		return LexicalInflector.pluralize(text);
	}
}
