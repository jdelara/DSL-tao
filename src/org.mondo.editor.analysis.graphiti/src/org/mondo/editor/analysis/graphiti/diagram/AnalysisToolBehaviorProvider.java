package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
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
	    
		 //delete pattern role button 
	    CustomContext cc = new CustomContext(new PictogramElement[] { pe });
	    DeletePatternRoleFeature dpr = new DeletePatternRoleFeature(getFeatureProvider());
	    ContextButtonEntry deletePRButton = new ContextButtonEntry(dpr, cc);
	    deletePRButton.setIconId(MapsImageProvider.IMG_DELETE_PATTERN_ROLE);
	    
	    if (dpr.isAvailable(cc) && (dpr.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(deletePRButton);
	    
	    //Create new CreateConnectionContext
	    CreateConnectionContext ccc = new CreateConnectionContext();
	    ccc.setSourcePictogramElement(pe);
	    Anchor anchor = null;
	    if (pe instanceof Anchor) {
	        anchor = (Anchor) pe;
	    } else if (pe instanceof AnchorContainer) {
	        anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
	    }
	    ccc.setSourceAnchor(anchor);
	    
	    //Create association context button
	    ContextButtonEntry buttonConn = new ContextButtonEntry(null, context);
	    buttonConn.setText("Create link");
	    buttonConn.setIconId(MapsImageProvider.IMG_LINK);
        CreateLinkFeature feature = new CreateLinkFeature(getFeatureProvider());
        if (feature.isAvailable(ccc) && feature.canStartConnection(ccc)){
        	buttonConn.addDragAndDropFeature(feature);
        	data.getDomainSpecificContextButtons().add(buttonConn);
        }
	    return data;
	}
}
