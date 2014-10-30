package org.mondo.editor.graphiti.diagram.utils;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Class of utility functions to work with messages.
 * 
 * @author miso partner AnaPescador
 *
 */

public  class Messages {

	/**
	 * Static method that opens an error message dialog and shows the specified message 
	 * @param msg
	 */
	public static void displayEditErrorMessage(String msg){
		MessageDialog.openError(getShell(), "Can not edit value", msg);
	}
	
	/**
	 * Static method that opens an error message dialog  whose title is cadValidationType+"Problems" and shows the specified message.
	 * @param cadValidationType - title
	 * @param msg
	 */
	public static void displayValidateErrorMessage(String cadValidationType,String msg){
		MessageDialog.openError(getShell(), cadValidationType+" Problems", msg);
	}
	
	/**
	 * Static method that opens  an warning message dialog and shows the specified message 
	 * @param cadValidationType - title
	 * @param msg
	 */
	public static void displayValidateWarningMessage(String cadValidationType,String msg){
		MessageDialog.openWarning(getShell(), cadValidationType+" Warnings", msg);
	}
	
	/**
	 * Static method that opens an information message dialog and shows a message of successful validation
	 * @param cadValidationType
	 */
	public static void displayValidateSuccessfulMessage(String cadValidationType){
		MessageDialog.openInformation(getShell(), cadValidationType+" Information", "Validation completed successfully");
		
	}
	
	/**
	 * Static method that opens an information message dialog with the specified title and shows the specifies message
	 * @param title
	 * @param msg
	 */
	public static void displayGeneralMessage(String title, String msg){
		MessageDialog.openInformation(getShell(), title, msg);
	}
	
	/**
	 * Static method that opens an error information message dialog with the specified title and shows the specifies message
	 * @param title
	 * @param msg
	 */
	public static void displayGeneralErrorMessage(String title, String msg){
		MessageDialog.openInformation(getShell(), title, msg);
	}
	
	/**
	 * Static method that opens an input dialog to ask the name of a package
	 * @param diagram
	 * @param title
	 * @return name
	 */
	public static String askForEPackageName(final Diagram diagram, String title){
		
		IInputValidator iv = new IInputValidator() {
			@Override
			public String isValid(String newText) {
				if (newText.length() < 1)
		            return "Please enter any text name.";
				else if (newText.contains(" "))
		            return "Spaces are not allowed in names.";
				else if (newText.contains("\n"))
		            return "Line breakes are not allowed in names.";
				else if (!ModelUtils.isIDValid(newText))
					return "Invalid ID";
				else if (ModelUtils.existsEPackageName(diagram, newText))
					return "Duplicated name";
				
		        return null;
			}
		};
		
		InputDialog id = new InputDialog(getShell(), title, "Name:", "",iv);
		id.open();
		return id.getValue();
	}

	
	public static Shell getShell(){
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

}
