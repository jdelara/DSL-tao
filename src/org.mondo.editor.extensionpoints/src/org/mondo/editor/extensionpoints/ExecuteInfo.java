package org.mondo.editor.extensionpoints;

/**
 * Model class to work with creation info.
 * ValidationInfo is the result of the validation.
 * Success is a boolean that is true if the creation process has been correct.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ExecuteInfo {

	public ValidationInfo vi = null;
	public boolean success = false;
	
	
	public ValidationInfo getValidationInfo() {
		return vi;
	}


	public void setValidationInfo(ValidationInfo vi) {
		this.vi = vi;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public ExecuteInfo() {
		
	}

}
