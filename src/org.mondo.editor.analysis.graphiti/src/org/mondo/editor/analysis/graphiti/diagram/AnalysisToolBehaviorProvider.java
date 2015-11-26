package org.mondo.editor.analysis.graphiti.diagram;


import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;


/**
 * Class to provide different menu options in the diagram editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AnalysisToolBehaviorProvider extends DefaultToolBehaviorProvider{

	public AnalysisToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
   }
	
	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);		
	    PictogramElement pe = context.getPictogramElement();

	    setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE);

	    return data;
	}
	

}
