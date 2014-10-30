package org.mondo.editor.extensionpoints;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;

/**
 * Model class to work with validation info.
 * Errors is a list that contains the classes with errors and their messages
 * Warnings is a list that contains the classes with warnings and their messages
 * 
 * @author miso partner AnaPescador
 *
 */
public class ValidationInfo {
	public Map<EClass,List<String>> errors = null;
	public Map<EClass,List<String>> warnings = null;
	
	public Map<EClass, List<String>> getErrors() {
		return errors;
	}

	public void setErrors(Map<EClass, List<String>> errors) {
		this.errors = errors;
	}

	public Map<EClass, List<String>> getWarnings() {
		return warnings;
	}

	public void setWarnings(Map<EClass, List<String>> warnings) {
		this.warnings = warnings;
	}

	public ValidationInfo( ) {
	}

	public ValidationInfo( Map<EClass,List<String>> errors,Map<EClass,List<String>> warnings ) {
		this.errors = errors;
		this.warnings = warnings;
	}
	
	public boolean noErrors(){
		if (this.errors != null)
			return this.errors.size() == 0;
		else return true;
	}
	
	public boolean noWarnings(){
		if (this.warnings != null)
			return this.warnings.size() == 0;
		else return true;
	}
	
	public String getErrorMessage(EClass eClass){
		String message = "";
		for (String cad: this.getErrors().get(eClass)){
			if (!message.isEmpty()) message += "\n";
			message += cad;
		}
		return message;
	}
	
	public String getWarningsMessage(EClass eClass){
		String message = "";
		for (String cad: this.getWarnings().get(eClass)){
			if (!message.isEmpty()) message += "\n";
			message += cad;
		}
		return message;
	}

}
