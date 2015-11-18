package org.mondo.editor.graphiti.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.utils.Messages;

/**
 * Class to define the specific behavior of the "mondo" diagrams.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EcoreDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	public EcoreDiagramTypeProvider() {
		super();
		setFeatureProvider(new EcoreFeatureProvider(this));
	}
	
	 @Override
	 public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new EcoreToolBehaviorProvider(this) };
        }
        return toolBehaviorProviders;
	 }

	 private ValidationInfo vi = null;
	
	 public ValidationInfo getValidationInfo() {
		 return vi;
	 }
	
	 public void setValidationInfo(ValidationInfo vi) {
		 this.vi = vi;
	 }
	 
	
	private Object patternServicesInfo = null;
	
	public Object getPatternServicesInfo() {		
		return patternServicesInfo;
		
	}

	public void setPatternServicesInfo(Object patternServicesInfo) {
		this.patternServicesInfo = patternServicesInfo;
	}
	
	private Object interfaceModel = null;
	
	

	public Object getInterfaceModel() {
		return interfaceModel;
	}

	public void setInterfaceModel(Object interfaceModel) {
		this.interfaceModel = interfaceModel;
	}

	@Override
	public void postInit() {
		super.postInit();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		if (window.getShell().getVisible()){
		String currentPerspective = window.getActivePage().getPerspective().getId();
		// open perspective
		if (currentPerspective.compareTo("org.mondo.editor.perspective.mondoDesign")!=0){
			String message = "This kind of diagrams is associated with the DSL-tao Design Perspective. Do you want to open this perspective now?";
			boolean answer = MessageDialog.openQuestion(Messages.getShell(), "Open Associated Perspective?", message);
			
			if (answer) try {
				workbench.showPerspective("org.mondo.editor.perspective.mondoDesign", window);
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
		}
		}
	}

}
