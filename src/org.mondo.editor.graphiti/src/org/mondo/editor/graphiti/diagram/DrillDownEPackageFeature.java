package org.mondo.editor.graphiti.diagram;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;
import org.mondo.editor.graphiti.diagram.utils.DiagramUtils;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;

/**
 * Class to open the EPackage content.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DrillDownEPackageFeature extends AbstractDrillDownFeature {

	public DrillDownEPackageFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Open Associated Diagram";
	}


	@Override
	public String getDescription() {
		return "Open the diagram associated with this EPackage";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof EPackage) {
				if (!getDiagramBehavior().getDiagramContainer().isDirty()){
					return super.canExecute(context);
				}
			}
		}
		return false;
	}

	@Override
	protected Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		IProject project = IResourceUtils.getProject(getDiagram().eResource());
		if (project != null)	result = DiagramUtils.getDiagrams(project);
		
		return result;
	}

	@Override
	protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
		final Collection<Diagram> ret = new HashSet<Diagram>();
		final Collection<Diagram> allDiagrams = getDiagrams();
		for (final Diagram d : allDiagrams) {
			final Diagram currentDiagram = getDiagram();
			if (!EcoreUtil.equals(currentDiagram, d)) { 
				final Object[] businessObjectsForDiagram = getAllBusinessObjectsForPictogramElement(d);
				for (int i = 0; i < businessObjectsForDiagram.length; i++) {
					final Object diagramBo = businessObjectsForDiagram[i];
					final Object currentBo = getBusinessObjectForPictogramElement(pe);
					if (getFeatureProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider()
							.equalsBusinessObjects(currentBo, diagramBo)) {
						ret.add(d);
					}
				}
			}
		}
		
		return ret;
	}
	
}
