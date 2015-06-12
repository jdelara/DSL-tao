package org.mondo.editor.ui.utils.services;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.mondo.editor.ui.utils.patterns.RuntimePatternsModelUtils;

import dslPatterns.Pattern;
import dslPatterns.Service;
import runtimePatterns.PatternInstance;
import runtimeServices.DisconnectedElement;
import runtimeServices.RuntimeServicesFactory;
import runtimeServices.ServiceInstance;
import serviceInterfaces.Interface;

/**
 * Class of utility functions to work with runtime services.
 * 
 * @author miso partner AnaPescador
 *
 */
public final class RuntimeServicesModelUtils {
	
	/**
	 * Static method that returns a list of information about the current pattern services.
	 * @param db - DiagramBehavior
	 * @return list of PatternServiceInfo
	 */
	public static List<PatternServiceInfo> getPatternServicesInfo(DiagramBehavior db){
		List<PatternServiceInfo> psil = new LinkedList<PatternServiceInfo>();
		for (PatternInstance pi : RuntimePatternsModelUtils.getAllAppliedPatterns(db)){
			for (ServiceInstance si : pi.getServiceInstances()){
				PatternServiceInfo psi = new PatternServiceInfo(pi.getIdent(), pi.getPattern(), si);
				psil.add(psi);
			}
		}
		return psil;
	}
	
	/**
	 * Static method that adds a service instance into the patternInstance
	 * @param pi - patternInstance
	 * @param service
	 * @param activated 
	 * @return a serviceInstance object
	 */
	public static ServiceInstance addPatternServiceInfo(PatternInstance pi, Service service, boolean activated){
		ServiceInstance si = RuntimeServicesFactory.eINSTANCE.createServiceInstance();
		si.setActivated(activated);
		si.setService(service);
		
		pi.getServiceInstances().add(si);
		
		return si;
	}
	
	/**
	 * Static method that add a disconnected element into the service instance.
	 * @param si - service instance
	 * @param interf - interface
	 * @param patterns - list of patterns
	 */
	public static void addDisconnectedElement(ServiceInstance si, Interface interf, List<Pattern> patterns){	
		DisconnectedElement de = RuntimeServicesFactory.eINSTANCE.createDisconnectedElement();
		de.setInterface(interf);
		de.getPatterns().addAll(patterns);
		si.getDisconnectedElements().add(de);
	}
	
	/**
	 * Static method that removes a disconnected element from a service instance.
	 * @param si - service instance
	 * @param de - disconnected element
	 */
	public static void removeDisconnectedElement(ServiceInstance si,DisconnectedElement de){			
		si.getDisconnectedElements().remove(de);
	}
}