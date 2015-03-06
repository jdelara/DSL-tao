package org.mondo.editor.ui.utils.services;

import java.util.List;

import runtimeServices.DisconnectedElement;
import runtimeServices.ServiceInstance;
import serviceInterfaces.Interface;

import dslPatterns.Pattern;
import dslPatterns.Service;

/**
 * Model class to work with pattern service info.
 * PatternName : pattern name applied (instance number included)
 * Pattern: pattern object applied
 * Activated: boolean to indicate if the user has decided if the service is going to be used
 * Service: service object 
 * Missing: list with information about missing interfaces and the patterns that implement them
 * 
 * @author miso partner AnaPescador
 * */
public class PatternServiceInfo {
		
	private String patternName;
	private Pattern pattern;
	private ServiceInstance serviceInstance;
	
	public String getPatternName() {
		return patternName;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public boolean isActivated() {
		return serviceInstance.isActivated();
	}

	public void setActivated(boolean activated) {
		serviceInstance.setActivated(activated);
	}
	
	public Service getService() {
		return serviceInstance.getService();
	}

	public ServiceInstance getServiceInstance(){
		return serviceInstance;
	}

	public String getName() {
		return getService().getName();
	}

	public List<DisconnectedElement> getMissing() {
		return serviceInstance.getDisconnectedElements();
	}

	public void addMissing(Interface interf, List<Pattern> patterns) {
		RuntimeServicesModelUtils.addDisconnectedElement(serviceInstance, interf, patterns);
	}
	
	public void removeMissing(DisconnectedElement de) {
		RuntimeServicesModelUtils.removeDisconnectedElement(serviceInstance, de);
	}
	
	public String getMissingText(){
		String cad = "";
		for (DisconnectedElement de : getMissing()){
			cad += (cad.isEmpty()?"":" ,")+de.getInterface().getQName();
		}
		return cad; 
	}
	
	public String getOfferedByText(){
		String cad = "";
		
		for (DisconnectedElement de: getMissing()){
			for (Pattern pattern: de.getPatterns()){
				cad += (cad.isEmpty()?"":" ,")+pattern.getName();
			}
			cad += "("+de.getInterface().getQName()+") ";
		}
		return cad;
	}

	
	public PatternServiceInfo(String patternName, Pattern pattern, ServiceInstance si) {
		this.patternName = patternName;
		this.pattern = pattern;
		this.serviceInstance = si;
	}

}
