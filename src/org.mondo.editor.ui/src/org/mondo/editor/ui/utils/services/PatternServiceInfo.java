package org.mondo.editor.ui.utils.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import serviceInterfaces.Interface;

import dslPatterns.Pattern;
import dslPatterns.Service;

/**
 * Model class to work with pattern service info.
 * PatternName : pattern name applied (instance number included)
 * Pattern: pattern object applied
 * Activated: boolean to indicate if the user has decided if the service is going to be used
 * Service: service object 
 * Missing: map with information about missing interfaces and the patterns that implement them
 * 
 * @author miso partner AnaPescador
 * */
public class PatternServiceInfo {
	
	private String patternName;
	private Pattern pattern;
	private boolean activated;
	private Service service;
	private Map<Interface, List<Pattern>> missing;
	
	
	
	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String pattern) {
		this.patternName = pattern;
	}
	
	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}



	public String getName() {
		return service.getName();
	}

	public Map<Interface, List<Pattern>> getMissing() {
		return missing;
	}

	public void setMissing(Map<Interface, List<Pattern>> missing) {
		this.missing = missing;
	}

		
	public String getMissingText(){
		String cad = "";
		for (Interface interf : this.getMissing().keySet()){
			cad += (cad.isEmpty()?"":" ,")+interf.getQName();
		}
		return cad; 
	}
	
	public String getOfferedByText(){
		String cad = "";
		for (Interface interf : this.getMissing().keySet()){
			for (Pattern pattern: this.getMissing().get(interf)){
				cad += (cad.isEmpty()?"":" ,")+pattern.getName();
			}
			cad += "("+interf.getQName()+") ";
		}
		return cad;
	}

	
	public PatternServiceInfo() {
		this.missing = new HashMap<Interface, List<Pattern>>();
	}

}
