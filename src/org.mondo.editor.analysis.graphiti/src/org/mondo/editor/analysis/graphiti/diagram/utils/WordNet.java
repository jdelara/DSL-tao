package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class WordNet {
	 private WordNetDatabase database = null;
	 private static WordNet INSTANCE = null;
	 static final String PLUGIN_DSL_ID = "org.mondo.editor.analysis.graphiti";

	   public WordNet(){
		   super();
		   String wordnetLocation = getPathDict();  
		   File f = new File(wordnetLocation);
		   if(!f.exists()){  
		   }
		   System.setProperty("wordnet.database.dir", wordnetLocation);
		   database = WordNetDatabase.getFileInstance();
	   }
	   
	   private static void createInstance() {
	   	 if (INSTANCE == null) {
	            synchronized(WordNet.class) {
	                if (INSTANCE == null) { 
	                    INSTANCE = new WordNet();
	                }
	            }
	        }
	   }

	   public static WordNet getInstance() {
	       if (INSTANCE == null){
	       	createInstance();
	       }
	       return INSTANCE;
	   }
		   
	   public Object clone() throws CloneNotSupportedException {
	   	throw new CloneNotSupportedException(); 
	   }
	   
	   private static String getPathDict(){
		   Bundle plugin = Platform.getBundle(PLUGIN_DSL_ID);
			IPath relativeIPath = new Path("dict"+File.separator);	
			URL fileInPlugin = FileLocator.find(plugin, relativeIPath, null);			
			URL srcUrl;
			try {
				srcUrl = FileLocator.toFileURL(fileInPlugin);
				File src = new File(srcUrl.getPath());	
				return src.getPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
	   }

	   public WordNetDatabase getDatabase() {
	       return database;
	   }

	   public void setDatabase(WordNetDatabase database) {
	       this.database = database;
	   }
	   
	   public List<String> getDefinitions(String concept){
		   List<String> definitions = new ArrayList<String>();
		   Synset[] synsets = database.getSynsets(concept);
		   
		   if(synsets.length > 0){
			   for (int i = 0; i < synsets.length; i++){
				   definitions.add(synsets[i].getDefinition());
			   }
		   }else return null;
		   return definitions;
	   }
	   
	   public List<List<String>> getSynonymsProposal(String concept){
		   List<List<String>> synonyms = new ArrayList<List<String>>();
		   Synset[] synsets = database.getSynsets(concept);
		   
		   if(synsets.length > 0){
			   for (int i = 0; i < synsets.length; i++){
				   List<String> wordforms = new ArrayList<String>();
				   String[] words = synsets[i].getWordForms();
				   for (int j = 0; j < words.length; j++){
					   wordforms.add(words[j]);
				   }
				   synonyms.add(wordforms);
			   }
		   }else return null;
		   return synonyms;
	   }
	   
	   public List<String> getSynonymsByDefition(String concept, String definition){
		   List<String> synonyms = new ArrayList<String>();
		   Synset[] synsets = database.getSynsets(concept);
		   if(synsets.length > 0){
			   for (int i = 0; i < synsets.length; i++){
				   if(synsets[i].getDefinition().equals(definition)){
					   String[] words = synsets[i].getWordForms();
					   for (int j = 0; j < words.length; j++){
						   synonyms.add(words[j]);
					   }
					   break;
				   }
			   }
		   }else return null;
		   return synonyms;
		   }
	   
	   public boolean areSynonyms(String word1, String word2){
		  
		   WordNet wordnet = new WordNet();
		   List<String> wordnetProposalsWord1 =  new ArrayList<String>();
		   wordnetProposalsWord1.add(word1);
			
		   if(wordnet.isNoun(word1)){
			   List<List<String>> synonymsByName = wordnet.getSynonymsProposal(word1);
				
			   if(synonymsByName.size() > 0){
				   for(List<String> partial : synonymsByName)
					   wordnetProposalsWord1.addAll(partial);
					}
				}
			
		   if (wordnetProposalsWord1.stream().anyMatch(prop1->prop1.compareToIgnoreCase(word2)==0)){
			   //System.out.println(word1+" and "+word2+" are synonyms");
			   return true;
		   }
			
		   return false;
	   }
	   
	   public boolean isNoun(String word){
		   for(Synset s : database.getSynsets(word))
			   if(s.getType().equals(SynsetType.NOUN))
				   return true;
		   
		   if(LexicalInflector.isPlural(word))
			   return isNoun(LexicalInflector.singularize(word));
		   
		   return false;
	   }
	   
	   public boolean isVerb(String word){
		   for(Synset s : database.getSynsets(word))
			   if(s.getType().equals(SynsetType.VERB))
				   return true;
		   
		   return false;
	   }
	   
	   public boolean isAdjective(String word){
		   for(Synset s : database.getSynsets(word))
			   if(s.getType().equals(SynsetType.ADJECTIVE))
				   return true;
		   
		   return false;
	   }
}
