package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.ClassInterface;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.Tag;

/**
 * Class of utility functions to work with the pattern assistant of the plugin
 * 
 * @author miso partner AnaPescador
 *
 */
public final class PatternAssistantUtils {
	
	public static Map<PatternMetaModel,Integer> getPatternsMetamodelRelated (IProject project, String tag){
		Map<PatternMetaModel,Integer> pmtags = new LinkedHashMap<PatternMetaModel,Integer>();
		//Patterns var contains all patterns.
		List<Pattern> patterns = PatternUtils.getAllPatterns(project);
		for (String tagAux: tag.split(" ")){
			String[] tagsAuxCamel =  StringUtils.splitByCharacterTypeCamelCase(tagAux);
			for (int i = 0; i<tagsAuxCamel.length;i++){
				String tagAuxCamel = tagsAuxCamel[i];
				if (tagAuxCamel.equals("-") && (i>0)&&(i+1<tagsAuxCamel.length)) 
					tagAuxCamel = tagsAuxCamel[i-1]+"-"+tagsAuxCamel[i+1];
				for (Pattern pattern : patterns){
					//Pattern
					if (containsTag(pattern, tagAuxCamel)) {
						for (PatternMetaModel pmm : PatternUtils.getPatternMetamodel(pattern)){
							if (pmtags.get(pmm) != null) 
								pmtags.put(pmm, pmtags.get(pmm)+1);
							else pmtags.put(pmm, 1);
						}
					} 
					//Pattern variant
					for (PatternMetaModel pmm : getPatternsRelatedRoles(pattern, tagAuxCamel))
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
		for (PatternMetaModel pmm : PatternUtils.getPatternMetamodel(pattern)){
			if (!((ComplexFeatureMain)pmm.eContainer()).getName().isEmpty()){
				String name = ((ComplexFeatureMain)pmm.eContainer()).getName();
				if (isTagInRole(tag, name)){
					lpmm.add(pmm);
				}
				for (String role: getRoles(pmm)){
					if (isTagInRole(tag, role)){
						lpmm.add(pmm);
					}
				}
			}
		}
		return lpmm;
	}
	
	/**
	 * Static method that returns if a tag is in the role.
	 * @param tag
	 * @param role
	 * @return boolean, true if it's contained, false if not.
	 */
	public static boolean isTagInRole (String tag, String role){
		String singular = WordUtils.toSingular(tag);
		
		String[] rolesAux =  StringUtils.splitByCharacterTypeCamelCase(role);
		rolesAux  = Arrays.copyOf(rolesAux, rolesAux.length + 1);
		rolesAux[rolesAux.length - 1] = role;

		for (int i = 0; i<rolesAux.length;i++){
			String roleAux = rolesAux[i];
			if (roleAux.equals("-") && (i>0)&&(i+1<rolesAux.length)) roleAux = rolesAux[i-1]+"-"+rolesAux[i+1];
			if ((WordNet.getInstance().areSynonyms(roleAux,tag)) || WordNet.getInstance().areSynonyms(roleAux,singular)){
				 return true;
			}
		}
		return false;
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
	 * Static method that returns the role that contains the patternMetaModel object.
	 * @param pmm
	 * @return list of string.
	 */
	public static ClassInterface getRole(PatternMetaModel pmm, String name){
		for (ClassInterface ci: pmm.getClassInterfaces()){ 
			EClass eclass = PatternUtils.getEClass(ci);
			if (eclass!= null)
				if (isTagInRole(name, eclass.getName()))	
					return ci;
		}
		return null;
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
				String[] tagsAux =  StringUtils.splitByCharacterTypeCamelCase(tagAux);
				for (int i = 0; i<tagsAux.length;i++){
					String tagAuxCamel = tagsAux[i];
					if (tagAuxCamel.equals("-") && (i>0)&&(i+1<tagsAux.length)) tagAuxCamel = tagsAux[i-1]+"-"+tagsAux[i+1];
				
					if (containsTag(pattern, tagAuxCamel)) {
						pmtags.put(pattern, ++cont);
					}
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
		if (containsTag(pattern.getName(), tag)){
			return true; 
		}
		for (Tag tagPattern : pattern.getTags()){
			if (containsTag(tagPattern, tag)) return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the tags are synonyms
	 * @param tag
	 * @param tagText
	 * @return
	 */
	private static boolean containsTag(Tag tag, String tagText){
		String singular = WordUtils.toSingular(tagText);
		if ((WordNet.getInstance().areSynonyms(tagText, tag.getName())) || (WordNet.getInstance().areSynonyms(singular, tag.getName())))
			return true;
		else {
			if (tag.eContainer() instanceof Tag){
				return containsTag((Tag) tag.eContainer(), tagText);
			} else return false;
		}
	}
	
	/**
	 * Static method that returns if the tags are synonyms
	 * @param tag
	 * @param tagText
	 * @return
	 */
	private static boolean containsTag(String tag, String tagText){
		String singular = WordUtils.toSingular(tagText);
		if ((WordNet.getInstance().areSynonyms(tagText, tag)) || (WordNet.getInstance().areSynonyms(singular, tag)))
			return true;
		return false;
	}
	
	/**
	 * Static method that returns if the metamodel is contained in the list of metamodels
	 * @param tag
	 * @param tagText
	 * @return
	 */
	public static boolean containsMetamodel(List<PatternMetaModel> metamodels, PatternMetaModel metamodel){
		for (PatternMetaModel pmmaux : metamodels){
			if (!((ComplexFeatureMain)pmmaux.eContainer()).getName().isEmpty()){
				String name = ((ComplexFeatureMain)pmmaux.eContainer()).getName();
				if (name.compareTo(((ComplexFeatureMain)metamodel.eContainer()).getName()) ==0){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Static method that returns the map ordered by the values
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
