package org.mondo.editor.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

import dslPatterns.MMInterface;

/**
 * Class of utility functions to evaluate extensions.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EvaluateExtensionPoint {

	private static final String IPATTERN_IMPLEMENTATION_ID ="org.mondo.editor.extensionpoints.patternImplementation";
	private static final String IPATTERN_IMPLEMENTATION_ATTRIBUTE = "pattern";
	
	/**
	 * Method that searches the plugins that implement the funcionality and execute the associat
	 * @param registry -> extension registry
 	 * @param pattern -> pattern name
	 * @param ePack -> metamodel initial package.
	 * @param iPath -> IPath diagram 
	 * @return information about the validation and success
	 */
	public static ExecuteInfo evaluateExecutePattern(IExtensionRegistry registry,String pattern, EPackage ePack, IPath iPath) {
		IPatternImplementation o = getInstanceIPattern(registry, pattern, ePack);
		if (o!= null) return executeExecuteExtension(o, ePack, iPath);
		else return null;
	}
	
	
	/**
	 * Method that searches the plug-ins that implement the funcionality and execute "validate pattern."
	 * @param registry -> extension registry
	 * @param pattern -> pattern name
	 * @param ePack -> meta-model initial package.
	 * @return information about the validation
	 */
	public static ValidationInfo evaluateValidatePattern(IExtensionRegistry registry,String pattern, EPackage ePack) {
		IPatternImplementation o = getInstanceIPattern(registry, pattern, ePack);
		if (o!= null) return executeValidateExtension(o, ePack);
		else return null;
	}
	
	/**
	 * Method that searches the plug-ins that implement the funcionality and execute "getOptimalElements"
	 * @param registry -> extension registry
	 * @param pattern -> pattern name
	 * @param ePack  -> meta-model initial package.
	 * @param mmInterface -> mmInterface target
	 * @return List of optimal elements.
	 */
	public static List<ENamedElement> evaluateGetOptimalElementsModularProject(IExtensionRegistry registry, String pattern, EPackage ePack, MMInterface mmInterface) {
		IPatternImplementation o = getInstanceIPattern(registry, pattern, ePack );
		if (o!= null) return executeGetOptimalElementsExtension(o, ePack, mmInterface);
		else return null;
	}
	
	/**
	 * Method that returns the instance that implements the interface "IPattern"
	 * @param registry -> extension registry
	 * @pattern pattern name of the extension.
	 * @param ePack -> meta-model initial package.
	 * @return ICreateModularProject
	 */
	private static IPatternImplementation getInstanceIPattern(IExtensionRegistry registry, String pattern, EPackage ePack){
		IConfigurationElement[] config = registry.getConfigurationElementsFor(IPATTERN_IMPLEMENTATION_ID);
		try {
			for (IConfigurationElement e : config) {				
				if (e.getAttribute(IPATTERN_IMPLEMENTATION_ATTRIBUTE).compareTo(pattern)==0){
					final Object o = e.createExecutableExtension("class");
					if (o instanceof IPatternImplementation) {		
						//one extension
						return (IPatternImplementation)o;
					}
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Method that returns the value of the attribute of the extension that implements the interface "IPattern"
	 * @param registry -> extension registry
	 * @param ePack -> meta-model initial package.
	 * @return String with the attribute value
	 */
	public static String getAttributeIPattern(IExtensionRegistry registry, EPackage ePack){
		IConfigurationElement[] config = registry.getConfigurationElementsFor(IPATTERN_IMPLEMENTATION_ID);
		try {
			for (IConfigurationElement e : config) {				
				final Object o = e.createExecutableExtension("class");
				if (o instanceof IPatternImplementation) {			
					String pattern = e.getAttribute(IPATTERN_IMPLEMENTATION_ATTRIBUTE);
					//one extension
					return pattern;
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Method that executes the method validation and, if it isn't errors, execute the method "execute" of the extension and returns the information about the execution.
	 * @param o -> instance that implements the interface "IPattern"
	 * @param ePack -> meta-model initial package.
	 * @param iPath -> IPath diagram
	 * @return CreationInfo
	 */
	private static ExecuteInfo executeExecuteExtension(final Object o,final EPackage ePack, IPath iPath) {
		ExecutePatternRunnable runnable = new ExecutePatternRunnable((IPatternImplementation)o, ePack, iPath);
		SafeRunner.run(runnable);
		return runnable.getCreationInfo();
		
	}
	
	/**
	 * Method that executes the method validation of the extension and returns the information about the validation.
	 * @param o -> instance that implements the interface "IPattern"
	 * @param ePack -> meta-model initial package.
	 * @return ValidationInfo
	 */
	private static ValidationInfo executeValidateExtension(final Object o,final EPackage ePack) {
		ValidatePatternRunnable runnable = new ValidatePatternRunnable((IPatternImplementation)o, ePack);
		SafeRunner.run(runnable);
		return runnable.getValidationInfo();
	}
	
	/**
	 * Method that executes the method getOptimalElements of the extension and returns a list with the elements.
	 * @param o -> instance that implements the interface "IPattern"
	 * @param ePack -> meta-model initial package.
	 * @param mminterface MMInterface target
	 * @return List<ENamedElement>
	 */
	private static List<ENamedElement> executeGetOptimalElementsExtension(final Object o,final EPackage ePack, MMInterface mminterface) {
		GetOptimalElementsModularProjectRunnable runnable = new GetOptimalElementsModularProjectRunnable((IPatternImplementation)o, ePack, mminterface);
		SafeRunner.run(runnable);
		return runnable.getOptimalElements();
		
	}
	

}
