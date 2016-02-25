package org.mondo.editor.analysis.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.Variant;
import mindMapDSML.Idea;

/**
 * Class to collapse an EClass object.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DeletePatternRoleFeature extends AbstractCustomFeature {

	public DeletePatternRoleFeature(IFeatureProvider fp) {
        super(fp);
	}
	
	@Override
    public boolean canExecute(ICustomContext context) {
          boolean ret = false;
          PictogramElement[] pes = context.getPictogramElements();
          if (pes != null && pes.length == 1) {
                Object bo = getBusinessObjectForPictogramElement(pes[0]);
                if (bo instanceof Idea) {
                	if (((Idea)bo).getPattern()!=null){
                		ret = true;
                	}
                }
          }
          return ret;
    }

    @Override
    public String getName() {
          return "Delete Pattern Role";
    }

    @Override
    public String getDescription() {
          return "Delete Pattern Role";
    }

    @Override
    public String getImageId() {
          return IPlatformImageConstants.IMG_EDIT_COLLAPSE;
    }

    
    @Override
    public boolean isAvailable(IContext context) {
          return true;
    }

    @Override
    public void execute(ICustomContext context) {   
    	PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
              Object bo = getBusinessObjectForPictogramElement(pes[0]);
              if (bo instanceof Idea) {
              	((Idea)bo).setPattern(null);
              	((Idea)bo).setPatternRole(null);
              	writePattern((Idea)bo, pes[0]);
              }
        }
    }
    
    /**
	 * Method that paints in the given pictogram the pattern and role associated to the idea.
	 * @param idea
	 * @param pe
	 */
	private void writePattern(Idea idea, final PictogramElement pe){
		String role = "";
		if (idea.getPatternRole()!= null){
			EClass eclass = PatternUtils.getEClass(idea.getPatternRole());
			if (eclass!= null) role = "."+eclass.getName();
		}

		final String name = ((idea.getPattern()!=null)?((Variant)idea.getPattern().eContainer()).getName(): "")+role;

		if (pe instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) pe;
            for (Shape shape : cs.getChildren()) {
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    if ((text.getValue().compareTo(name)!=0)&& (DiagramUtils.isInfoPatterns(text))){
                		text.setValue(name);
        }}}}
	}
	
}
