package org.mondo.editor.graphiti.diagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.graphiti.IExecutionInfo;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureAndContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ColorDecorator;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.mondo.editor.extensionpoints.ValidationInfo;
import org.mondo.editor.graphiti.diagram.properties.EClassAdditionalInformationSection;
import org.mondo.editor.graphiti.diagram.properties.EPackageAdditionalInformationSection;
import org.mondo.editor.graphiti.diagram.properties.SearchSection;
import org.mondo.editor.graphiti.diagram.utils.DiagramStyles;

/**
 * Class to provide different menu options and decorators in the diagram editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EcoreToolBehaviorProvider extends DefaultToolBehaviorProvider{

	public EcoreToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
   }
	
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
	    ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
	    IContextMenuEntry ret[];
	    ret = new IContextMenuEntry[customFeatures.length];
	    for (int i = 0; i < customFeatures.length; i++) {
	         ICustomFeature customFeature = customFeatures[i];
	         if (customFeature.isAvailable(context)) {
	             ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
	             ret[i]=menuEntry;
	         }
	     }

	     return ret;
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);		
	    PictogramElement pe = context.getPictogramElement();

	    setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE );

	    CustomContext cc = new CustomContext(new PictogramElement[] { pe });
	    
	    //collapse button 
	    CollapseEClassFeature ccf = new CollapseEClassFeature(getFeatureProvider());
	    ContextButtonEntry button0 = new ContextButtonEntry(ccf, cc);
	    
	    CollapseEEnumFeature ccfE = new CollapseEEnumFeature(getFeatureProvider());
	    ContextButtonEntry button0E = new ContextButtonEntry(ccfE, cc);
	    
	    //expand button 
	    ExpandEClassFeature ecf = new ExpandEClassFeature(getFeatureProvider());
	    ContextButtonEntry button = new ContextButtonEntry(ecf, cc);
	    
	    ExpandEEnumFeature ecfE = new ExpandEEnumFeature(getFeatureProvider());
	    ContextButtonEntry buttonE = new ContextButtonEntry(ecfE, cc);
	    
	    //down attribute
	    DownEAttributeFeature daf = new DownEAttributeFeature(getFeatureProvider());	    
	    ContextButtonEntry button2 = new ContextButtonEntry(daf, cc);

	    //up attribute
	    UpEAttributeFeature uaf = new UpEAttributeFeature(getFeatureProvider());
	    ContextButtonEntry button3 = new ContextButtonEntry(uaf, cc);

	    if (ccf.isAvailable(cc) && (ccf.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(button0);
	    if (ccfE.isAvailable(cc) && (ccfE.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(button0E);
	    if (ecf.isAvailable(cc) && (ecf.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(button);
	    if (ecfE.isAvailable(cc) && (ecfE.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(buttonE);
	    if (daf.isAvailable(cc) && (daf.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(button2);
	    if (uaf.isAvailable(cc) && (uaf.canExecute(cc)))
	    	data.getDomainSpecificContextButtons().add(button3);
	    
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
	    ContextButtonEntry button4 = new ContextButtonEntry(null, context);
	    button4.setText("Create association");
	    button4.setIconId(EcoreImageProvider.IMG_EREFERENCE);
        CreateEReferenceFeature feature = new CreateEReferenceFeature(getFeatureProvider());
        if (feature.isAvailable(ccc) && feature.canStartConnection(ccc)){
        	button4.addDragAndDropFeature(feature);
        	data.getDomainSpecificContextButtons().add(button4);
        }
        
        //Create association context button
	    ContextButtonEntry button5 = new ContextButtonEntry(null, context);
	    button5.setText("Create inheritance");
	    button5.setIconId(EcoreImageProvider.IMG_ESUPERTYPE);
        CreateESuperTypeFeature feature2 = new CreateESuperTypeFeature(getFeatureProvider());
        if (feature2.isAvailable(ccc) && feature2.canStartConnection(ccc)){
        	button5.addDragAndDropFeature(feature2);
        	data.getDomainSpecificContextButtons().add(button5);
        }
	    return data;
	}
	
	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();		
		IWorkbenchPart activePart = activePage.getActivePart();	
		
		if (activePart != null){
		
			IDecorator backgroundColor =  null;
			IDecorator imageRenderingDecorator = null;
			
			if ((activePart.getTitle().compareTo("Applied Patterns View")==0) || (iSearchSection(activePart)) || (isEClassAdditionalInformationSection(activePart))
					|| (isEPackageAdditionalInformationSection(activePart))){
				PictogramElement[] pes = getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements();		
				List<PictogramElement> list = new ArrayList<>(Arrays.asList(pes));
				if (list.indexOf(pe)>-1){
					if (getFeatureProvider().getBusinessObjectForPictogramElement(pe) instanceof ENamedElement){
						backgroundColor = new ColorDecorator(null, DiagramStyles.ELEMENT_EMPHASIZED);
					}
				}
			} 
			
			ValidationInfo vi = ((EcoreDiagramTypeProvider)getDiagramTypeProvider()).getValidationInfo();
			if (vi != null) {
				if (pe.isVisible()){
					if (getFeatureProvider().getBusinessObjectForPictogramElement(pe) instanceof EClass){
						EClass eClass = (EClass) getFeatureProvider().getBusinessObjectForPictogramElement(pe);
						if (!vi.noErrors()){
							if (vi.getErrors().get(eClass)!= null){
								imageRenderingDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
								imageRenderingDecorator.setMessage(vi.getErrorMessage(eClass));
							}
						}
						else if (!vi.noWarnings()){
							if (vi.getWarnings().get(eClass)!= null){
								imageRenderingDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
								imageRenderingDecorator.setMessage(vi.getWarningsMessage(eClass));
							}
						}
					} else if (getFeatureProvider().getBusinessObjectForPictogramElement(pe) instanceof EPackage) {
						EPackage ePack = (EPackage) getFeatureProvider().getBusinessObjectForPictogramElement(pe);
						if (!vi.noErrors()){
							if (hasChild(ePack, vi.getErrors().keySet())){
								imageRenderingDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
								imageRenderingDecorator.setMessage("Errors in this package");
							}
						}
						else if (!vi.noWarnings()){
							if (hasChild(ePack, vi.getWarnings().keySet())){
								imageRenderingDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
								imageRenderingDecorator.setMessage("Warnings in this package");
							}
						}
					}	
				}
			}	
			return new IDecorator[]{backgroundColor, imageRenderingDecorator};
		}
	    return super.getDecorators(pe);
	}
	
	/**
	 * Method that returns if the package has a child into the set of classes.
	 * @param pack
	 * @param classes
	 * @return true if the package has a child, false if not
	 */
	private boolean hasChild(EPackage pack, Set<EClass> classes){
		for (EClassifier classif : pack.getEClassifiers()){
			if (classes.contains(classif)) return true;
		}
		boolean enc = false;
		for (EPackage subPack: pack.getESubpackages()){
			enc =  hasChild(subPack,classes);
			if (enc) return true;
		}
		return false;
	}
	
	/**
	 * Returns if  the view belongs to the view "AdditionalInformation" of an EClass
	 * @param activeView
	 * @return true if is the view, false if not.
	 */
	private boolean isEClassAdditionalInformationSection(IWorkbenchPart activeView){
		if (activeView instanceof PropertySheet){
			IPage cp = ((PropertySheet)activeView).getCurrentPage();
			if (cp instanceof TabbedPropertySheetPage)
				return ((TabbedPropertySheetPage)cp).getCurrentTab().getSectionAtIndex(0) instanceof EClassAdditionalInformationSection;
		}
		return false;
	}
	
	/**
	 * Returns if  the view belongs to the view "AdditionalInformation" of an EClass
	 * @param activeView
	 * @return true if is the view, false if not.
	 */
	private boolean iSearchSection(IWorkbenchPart activeView){
		if (activeView instanceof PropertySheet){
			IPage cp = ((PropertySheet)activeView).getCurrentPage();
			if (cp instanceof TabbedPropertySheetPage)
				return ((TabbedPropertySheetPage)cp).getCurrentTab().getSectionAtIndex(0) instanceof SearchSection;
		}
		return false;
	}
	
	
	/**
	 * Returns if  the view belongs to the view "AdditionalInformation" of an EPackage
	 * @param activeView
	 * @return true if is the view, false if not.
	 */
	private boolean isEPackageAdditionalInformationSection(IWorkbenchPart activeView){
		if (activeView instanceof PropertySheet){
			IPage cp = ((PropertySheet)activeView).getCurrentPage();
			if (cp instanceof TabbedPropertySheetPage)
				return ((TabbedPropertySheetPage)cp).getCurrentTab().getSectionAtIndex(0) instanceof EPackageAdditionalInformationSection;
		}
		return false;
	}

	@Override
	public void postExecute(IExecutionInfo executionInfo) {

		super.postExecute(executionInfo);
		for (IFeatureAndContext fc : executionInfo.getExecutionList()){
			if (fc.getFeature() instanceof DrillDownEPackageFeature){
				getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().close();
			}
		}
	}

}
