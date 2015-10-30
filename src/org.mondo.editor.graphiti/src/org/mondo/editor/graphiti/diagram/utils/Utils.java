package org.mondo.editor.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class of utility functions to work with Objects
 * 
 * @author miso partner AnaPescador
 *
 */
public final class Utils {

	/**
	 * Static method that add an object to an array
	 * @param array
	 * @param object
	 * @return the new array
	 */
	public static Object[] addObjectArray(Object[] array, Object object){
		
		List<Object> list = new ArrayList<>(Arrays.asList(array));
		list.add(object);
		return list.toArray();
	}
	
	/**
	 * Static method that remove an object from an array.
	 * @param array
	 * @param object
	 * @return the new array
	 */
	public static Object[] removeObjectArray(Object[] array, Object object){
		
		List<Object> list = new ArrayList<>(Arrays.asList(array));
		list.removeAll(Arrays.asList(object));
		return list.toArray();
	}
	
}
