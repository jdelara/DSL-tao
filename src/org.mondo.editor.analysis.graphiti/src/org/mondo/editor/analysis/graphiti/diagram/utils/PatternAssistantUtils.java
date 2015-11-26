package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.ClassInterface;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.Tag;
import dslPatterns.Variant;

/**
 * Class of utility functions to work with the pattern assistant of the plugin
 * 
 * @author miso partner AnaPescador
 *
 */
public final class PatternAssistantUtils {
	
	public static Map<PatternMetaModel,Integer> getPatternsMetamodelRelated (IProject project, String tag){
		Map<PatternMetaModel,Integer> pmtags = new LinkedHashMap<PatternMetaModel,Integer>();
		for (String tagAux: tag.split(" ")){
			for (Pattern pattern : PatternUtils.getAllPatterns(project)){
				if (containsTag(pattern, tagAux)) {
					for (PatternMetaModel pmm : getPatternMetamodel(pattern)){
						if (pmtags.get(pmm) != null) pmtags.put(pmm, pmtags.get(pmm)+1);
						else pmtags.put(pmm, 1);
					}
				} else {
					for (PatternMetaModel pmm : getPatternsRelatedRoles(pattern, tagAux))
						addPatternMetamodel(pmtags, pmm);
				}
			}
		}
		return pmtags;
	}
	
	/**
	 * static method that adds a pattern into the map that collect info about pattern and number of match tags.
	 * @param pmtags
	 * @param pmm
	 */
	private static void addPatternMetamodel (Map<PatternMetaModel,Integer> pmtags, PatternMetaModel pmm){
		for (PatternMetaModel pmmAux: pmtags.keySet()){
			if (((ComplexFeatureMain)pmmAux.eContainer()).getName().compareTo(((ComplexFeatureMain)pmm.eContainer()).getName()) ==0){
				pmtags.put(pmmAux, pmtags.get(pmmAux)+1);
				return;
			}
		}
		pmtags.put(pmm, 1);
	}
	
	/**
	 * Static method that returns a list of patternmetamodel objects that contains the tag.
	 * @param pattern
	 * @param tag
	 * @return the list of PatternMetaModels-
	 */
	public static  List<PatternMetaModel> getPatternsRelatedRoles(Pattern pattern, String tag){
		List<PatternMetaModel> lpmm = new LinkedList<PatternMetaModel>();
		String singular = WordUtils.toSingular(tag);
		for (PatternMetaModel pmm : getPatternMetamodel(pattern)){
			if (!((ComplexFeatureMain)pmm.eContainer()).getName().isEmpty()){
				String name = ((ComplexFeatureMain)pmm.eContainer()).getName();
				for (String nameU : name.split(" ")){
					if ((nameU.compareToIgnoreCase(tag)==0) || (nameU.compareToIgnoreCase(singular)==0)){
						lpmm.add(pmm);
						break;
					}
				}
				for (String role: getRoles(pmm)){
					if ((role.compareToIgnoreCase(tag)==0) || (role.compareToIgnoreCase(singular)==0)){
						lpmm.add(pmm);
						break;
					}
				}
			}
		}
		return lpmm;
	}
	
	/**
	 * Static method that returns the list of roles that contains the patternMetaModel object.
	 * @param pmm
	 * @return list of string.
	 */
	public static List<String> getRoles(PatternMetaModel pmm){
		List<String> roles = new LinkedList<String>();
		for (ClassInterface ci: pmm.getClassInterfaces()){ 
			EClass eclass = PatternUtils.getEClass(ci);
			if (eclass != null)roles.add(eclass.getName());
		}
		return roles;
	}
	
	
	/**
	 * Static method that returns the list of meta-models that are related to the tag.
	 * @param project
	 * @param tag
	 * @return list of pattern meta-models
	 */
	public static  Map<Pattern,Integer> getPatternsRelatedTag(IProject project, String tag){
		Map<Pattern,Integer> pmtags = new LinkedHashMap<Pattern,Integer>();
		for (Pattern pattern : PatternUtils.getAllPatterns(project)){
			int cont = 0;
			for (String tagAux: tag.split(" ")){
				if (containsTag(pattern, tagAux)) {
					pmtags.put(pattern, ++cont);
				}
			}
		}
		return pmtags;
	}
	
	/**
	 * Static method that returns if the meta-model is related to the tag.
	 * @param pattern
	 * @param tag
	 * @return true if it's, false if not
	 */
	private static boolean containsTag (Pattern pattern, String tag){
		for (Tag tagPattern : pattern.getTags()){
			//Improve it!
			if (containsTag(tagPattern, tag)) return true;
		}
		return false;
	}
	
	private static boolean containsTag(Tag tag, String tagText){
		String singular = WordUtils.toSingular(tagText);
		if ((tag.getName().compareToIgnoreCase(tagText)==0) || (tag.getName().compareToIgnoreCase(singular)==0)){
			return true;
		} else {
			if (tag.eContainer() instanceof Tag){
				return containsTag((Tag) tag.eContainer(), tagText);
			} else return false;
		}
	}
	
	
	/**
	 * Static method that returns the list of pattern metaModel objects that contains the pattern.
	 * @param pattern
	 * @return list of pattern meta-models.
	 */
	public static List<PatternMetaModel> getPatternMetamodel (Pattern pattern){
		List<PatternMetaModel> pm = new ArrayList<>();
		ComplexFeatureMain cf = pattern.getRootVariant();
		if (cf != null){
			for (Variant var : cf.getAndChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
			for (Variant var : cf.getOrChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
			for (Variant var : cf.getXorChildren()){
				if (var instanceof ComplexFeatureMain){
					pm.add(((ComplexFeatureMain)var).getMetaModel());
				}
			}
		}
		return pm;
	}
	
	/**
	 * static method that returns the map ordered by the values
	 * @param patterns
	 * @return ordered map of patternMetamodels objects.
	 */
	public static Map<PatternMetaModel, Integer> orderForValues(Map<PatternMetaModel, Integer> patterns){
		LinkedHashMap<PatternMetaModel, Integer> newMap = new LinkedHashMap<PatternMetaModel, Integer>();
		ArrayList<Integer> values = new ArrayList<Integer>(patterns.values());
		Collections.sort(values ,Collections.reverseOrder());
		Iterator<Integer> it = values.iterator();
		Integer tmp=0;
		while(it.hasNext()){
			tmp = it.next();
			for(PatternMetaModel k : patterns.keySet()){
				if(tmp==patterns.get(k)){
					newMap.put(k, patterns.get(k));
				}
			}
		}
		return newMap;
	}

}
