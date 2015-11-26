package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.mondo.editor.graphiti.diagram.utils.Messages;

/**
 * Class to define the specific behavior of the analysis diagrams.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AnalysisDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	public AnalysisDiagramTypeProvider() {
		super(); 
		setFeatureProvider(new AnalysisFeatureProvider(this));
	}
	
	 @Override
	 public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
       if (toolBehaviorProviders == null) {
           toolBehaviorProviders = new IToolBehaviorProvider[] { new AnalysisToolBehaviorProvider(this) };
       }
       return toolBehaviorProviders;
	 }
	@Override
	public void postInit() {
		super.postInit();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		if (window.getShell().getVisible()){
		String currentPerspective = window.getActivePage().getPerspective().getId();
		// open perspective
		if (currentPerspective.compareTo("org.mondo.editor.perspective.mondoAnalysis")!=0){
			String message = "This kind of diagrams is associated with the DSL-tao Analysis Perspective. Do you want to open this perspective now?";
			boolean answer = MessageDialog.openQuestion(Messages.getShell(), "Open Associated Perspective?", message);
			
			if (answer) try {
				workbench.showPerspective("org.mondo.editor.perspective.mondoAnalysis", window);
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
		}
		}
	}
}