package org.mondo.editor.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.graphiti.diagram.AddEPackageFeature;
import org.mondo.editor.graphiti.diagram.DeleteEPackageFeature;
import org.mondo.editor.graphiti.diagram.EcoreDiagramTypeProvider;
import org.mondo.editor.graphiti.diagram.ResizeEClassFeature;
import org.mondo.editor.graphiti.diagram.ResizeEEnumFeature;

/**
 * Class of utility functions to work with DSL-tao diagrams.
 * 
 * @author miso partner AnaPescador
 *
 */
public  class DiagramUtils {
	
	public static final String TYPE_TEXT = "text";
	public static final String TYPE_TAG = "tag";
	public static final String TYPE_INFO_PATTERNS = "infoPatterns";
	public static final String TYPE_COLLAPSE_INFO_REF = "collapseInfoRef";
	public static final String TYPE_PATTERN_NAMES = "patternNames";
	public static final String TYPE_INHERITANCE = "inheritance";

	public static final String MODE = "mode";
	public static final String COLLAPSE = "collapse";
	public static final String EXPAND = "expand";
	public static final String SHOW_PATTERN_INFO = "showPatternInfo";
	public static final String COLLAPSE_INHERITANCE = "collapseInheritance";
	public static final String NOT_DELETE = "notDelete";
	public static final String NOT_REMOVE = "notRemove";
	
	public static final int POS_ATTRIBUTES = 5;

	public static enum DecoratorText{ 
		EREF_DECORATOR_NAME(1),
		EREF_DECORATOR_BOUNDS(2),
		EREF_DECORATOR_ORUNI(3),
		EREF_DECORATOR_PATTERN(4),
		EREF_DECORATOR_NAME_OP(5),
		EREF_DECORATOR_BOUNDS_OP(6),
		EREF_DECORATOR_ORUNI_OP(7),
		EREF_DECORATOR_PATTERN_OP(8);
		
		private final int pos; 
	    
		DecoratorText(int pos) {
	        this.pos = pos;
	    }
	    
	    public final int getPos(){
	    	return this.pos;
	    }
	}
	
	public static enum DecoratorFigure{ 
		EREF_DECORATOR_DIR,
		EREF_DECORATOR_OPPOSITE_DIR,
		EREF_DECORATOR_CONTAINMENT;
	}

	/**
	 * Static method that returns if an algorithm.text contains the specified text.
	 * @param text
	 * @return boolean - true is a text, false not.
	 */
	public static boolean isText (Text text){
		for (Property property: text.getProperties()){
			if ((property.getKey().equals("type")) && (property.getValue().equals(TYPE_TEXT)))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if an algorithm.text is a tag.
	 * @param text
	 * @return boolean - true is a tag, false not.
	 */
	public static boolean isTag (Text text){
		for (Property property: text.getProperties()){
			if ((property.getKey().equals("type")) && (property.getValue().equals(TYPE_TAG)))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if an algorithm.text is info about patterns.
	 * @param text
	 * @return boolean - true is patterns info, false not.
	 */
	public static boolean isInfoPatterns (Text text){
		for (Property property: text.getProperties()){
			if ((property.getKey().equals("type")) && (property.getValue().equals(TYPE_INFO_PATTERNS)))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the specified pictogram is a shape with collapse information.
	 * @param pe
	 * @return boolean - true  is a collapse, false not.
	 */
	public static boolean isCollapseInformationRef (PictogramElement pe ){
		for (Property property: pe.getProperties()){
			if ((property.getKey().equals("type")) && (property.getValue().equals(TYPE_COLLAPSE_INFO_REF)))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that deletes the diagram content.
	 * @param fp
	 */
	public static void deleteDiagramContent(final IFeatureProvider fp){	
		final Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		final EPackage pack = ModelUtils.getBusinessModel(diagram);
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EPackage)pack);
        domain.getCommandStack().execute(new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
  		  		DiagramUtils.paintPatternInfoText((DiagramBehavior)fp.getDiagramTypeProvider().getDiagramBehavior(), pack, "");

				List<EClassifier> lc = pack.getEClassifiers();
				for (int i = 0; i<lc.size();i=0){
					EClassifier classif = lc.get(i);
					DefaultDeleteFeature dc = new DefaultDeleteFeature(fp);
					List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, classif);
					for (PictogramElement pe : pes)	{
						DeleteContext context = new DeleteContext(pe);
						context.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
						dc.execute(context);
					}
				}
				
				for (EPackage subPack : pack.getESubpackages()){
					List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, subPack);
					DeleteEPackageFeature dpf = new DeleteEPackageFeature(fp);
					for (PictogramElement pe: pes){
						if (!(pe instanceof Diagram)){
							IDeleteContext context = new DeleteContext(pe);
							dpf.execute(context);
						}
					}
				}
				
			}
		});
	}
	
	/**
	 * Static method to draw a diagram from the specified ecore diagram.
	 * @param fp
	 * @param ecoreDiagram
	 */
	public static void drawDiagram(final IFeatureProvider fp, final Diagram ecoreDiagram){		
		final Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		
		EObject packObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);

		if (packObject.eIsProxy()) 
			packObject = EcoreUtil.resolve(packObject, ecoreDiagram); 
		else {
			EObject packObjectDiagram = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ecoreDiagram);
			packObject = ModelUtils.getEPackageDiagram((EPackage)packObjectDiagram, (EPackage) packObject);
		}
		final EPackage pack =(EPackage)packObject;
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EPackage)pack);
        domain.getCommandStack().execute(new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
				
	            DiagramUtils.initPatternInfo(diagram);
				int x = 100, y= 100, lim_x = 1100;
				
				for (EClassifier classif: pack.getEClassifiers()){
						if ((classif instanceof EClass) || (classif instanceof EEnum)) {
						
						AddContext ac = new AddContext();
						ac.setLocation(x, y);
						ac.setTargetContainer(diagram);
						PictogramElement pe = paint (fp, ac, classif);
						if (x<lim_x)x += 500;
						else {
							x=100;y +=200;
						}
						AddContext acAtt= new AddContext();
						acAtt.setTargetContainer(((ContainerShape)pe));
						if (classif instanceof EClass){
							for (EAttribute att: ((EClass)classif).getEAttributes())
								paint(fp, acAtt, att);
						}else if (classif instanceof EEnum){
							for (EEnumLiteral lit: ((EEnum)classif).getELiterals())
								paint(fp, acAtt, lit);
						}
					}
				}
				//connections
				List<EReference> paintedReferences = new ArrayList<EReference>();
				for (EClassifier classif: pack.getEClassifiers()){
					if (classif instanceof EClass){
						for (EClass superType:((EClass) classif).getESuperTypes()){
							AddConnectionContext acc = new AddConnectionContext(getAnchor(diagram, (EClass)classif), getAnchor(diagram, (EClass)superType))	;
							paint(fp, acc, null);
						}
						for (EReference reference :((EClass) classif).getEReferences()){
							if (!paintedReferences.contains(reference.getEOpposite())){
								AddConnectionContext acc = new AddConnectionContext(getAnchor(diagram, (EClass)classif), getAnchor(diagram, reference.getEReferenceType()))	;
								paint(fp, acc, reference);
								paintedReferences.add(reference);
							}
						}
					}
				}
				
				//packages
				for (EPackage subPack : pack.getESubpackages()){
					AddContext ac = new AddContext();
					ac.setLocation(x, y);
					ac.setTargetContainer(diagram);
					ac.setNewObject(subPack);
					/*paint(fp, ac, subPack);
				
					final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();
					Collection<Diagram> linkedDiagrams = getLinkedDiagrams(fp, subPack, ecoreDiagram);
					*/
					AddEPackageFeature packf = new AddEPackageFeature(fp);
					packf.add(ac);
					
					final EcoreDiagramTypeProvider dp = new EcoreDiagramTypeProvider();
					//for (Diagram diagram: linkedDiagrams){
					Diagram newDiagram = packf.getNewDiagram();	
					dp.init(newDiagram, dp.getDiagramBehavior());
						drawDiagram(dp.getFeatureProvider(), newDiagram); //ecoreDiagram
						IResourceUtils.saveResource(newDiagram.eResource());
						
					//}
					
					if (x<lim_x)x += 500;
					else {
						x=100;y +=300;
					}
				}
				
			}
		});
	}
	
	/**
	 * Static method that returns an anchor element of the specified eclass.
	 * @param diagram
	 * @param eClass
	 * @return anchor
	 */
	public static Anchor getAnchor(Diagram diagram, EClass eClass){
		for (PictogramElement pes : Graphiti.getLinkService().getPictogramElements(diagram, eClass)){
			if (pes instanceof ContainerShape){
				return ((ContainerShape) pes).getAnchors().get(0);
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the container shape of the specified eclass
	 * @param diagram
	 * @param eClass
	 * @return targer containerShape
	 */
	public static ContainerShape getTargetContainer(Diagram diagram, EClass eClass){
		for (PictogramElement pes : Graphiti.getLinkService().getPictogramElements(diagram, eClass)){
			if (pes instanceof ContainerShape){
				return (ContainerShape) pes;
			}
		}
		return null;
	}
	
	/**
	 * Static method that paint the specified eobject
	 * @param fp
	 * @param context
	 * @param object
	 * @return the painted pictogram element 
	 */
	private static PictogramElement paint (IFeatureProvider fp, AddContext context, Object object){
		context.setNewObject(object);
		return fp.getAddFeature(context).add(context);
	}
	
	/**
	 * Static method that returns the "ordered and unique" text of the specified estructuralfeature. 
	 * @param esf
	 * @return text
	 */
	public static String getOrderedUniqueText(EStructuralFeature esf){
		String cad;
        if (esf instanceof EAttribute){
        	cad = "{"+(esf.isOrdered()?"ordered, ":"")+(esf.isUnique()?"unique, ":"")+(((EAttribute)esf).isID()?"id":"" )+"}";
        	cad = (cad.compareTo("{}")==0?"":cad);
        	cad = cad.replace(", }", "}");
        }
        else {
        	/*EReference*/ 
        	cad= "{"+(esf.isOrdered()?"ordered,\n":"")+(esf.isUnique()?"unique":"")+"}";
        	cad = (cad.compareTo("{}")==0?"":cad);
        	cad = cad.replace(",\n}", "}");
        }
        return cad;
	}
	
	/**
	 * Static method that returns text that is show for the specified eattribute.
	 * @param eAtt
	 * @return text
	 */
	public static String getAttributeText(EAttribute eAtt){
		return eAtt.getName()+(eAtt.getEType()!=null ? " : "+eAtt.getEType().getName():"")+" ["+eAtt.getLowerBound()+".."+(eAtt.getUpperBound()==-1?"*":eAtt.getUpperBound())+"]"+getOrderedUniqueText(eAtt);
	}
	
	/**
	 * Static method that returns the bound text related to the specified ereference.
	 * @param eRef
	 * @return text
	 */
	public static String getBoundReferenceText(EReference eRef){
        int lbound = eRef.getLowerBound();
        int ubound = eRef.getUpperBound();
        return lbound+".."+(ubound == -1 ? "*" : ubound);
	}
	
	/**
	 * Static method that updates the attributes of the specified diagram (it`s used by EditEnum, the name of the edatatype can change)
	 * @param fp
	 * @param diagram
	 */
	public static void refreshAtts(IFeatureProvider fp, Diagram diagram){
		for (EClass eClassAux: ModelUtils.getEClasses(diagram)){
			for (EAttribute eAttAux: eClassAux.getEAttributes()){
				for (PictogramElement pe: Graphiti.getLinkService().getPictogramElements(diagram, eAttAux)){
					IReason ret = Reason.createFalseReason();
					IUpdateContext updateCtx = new UpdateContext(pe);
					IUpdateFeature updateFeature = fp.getUpdateFeature(updateCtx);
					if (updateFeature != null) {
						ret = updateFeature.updateNeeded(updateCtx);
						if (ret.toBoolean())
							updateFeature.update(updateCtx);
					}
				}
			}
		}	
	}
	
	/**
	 * Static method that returns the list of EReferences that pointed to the specified eclass.
	 * @param diagram
	 * @param eclass
	 * @return list of EReferences
	 */
	public static List<EReference> getEReferencesIncoming(Diagram diagram, EClass eclass){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eclass);
		List<EReference> refs = new ArrayList<EReference>();
		for (PictogramElement pe : pes){	
			if (pe instanceof ContainerShape){
				((ContainerShape) pe).getAnchors(); 
				for (Anchor anchor : ((ContainerShape) pe).getAnchors()) {
					for (Connection con : anchor.getIncomingConnections()){
						EObject ref = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
						if (ref instanceof EReference){
							refs.add((EReference)ref);				
						}
					}
					for (Connection con : anchor.getOutgoingConnections()){
						EObject ref = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
						if (ref instanceof EReference){
							if (((EReference)ref).getEOpposite() != null)
							refs.add(((EReference)ref).getEOpposite());				
						}
					}
				}
			}
		}
		return refs;
	}
	
	/**
	 * Static method that set the visibility of an eNamedElement.
	 * @param diagram
	 * @param element - eNamedElement
	 * @param visibility - true show, false hide.
	 * @param otherElements - to know if we can modify these elements
	 */
	public static void setElementVisibility (Diagram diagram, ENamedElement element, boolean visibility, List<ENamedElement> otherElements){
		if (element instanceof EReference) {
			Connection con = getConnection(diagram, (EReference) element);
			if (con !=  null) con.setVisible(visibility);
		}
		else if (element instanceof EClass){
			ContainerShape cs = getContainerShape(diagram, element);
			cs.setVisible(visibility);
			//connections
			for (EReference ref : ((EClass)element).getEReferences()){
				if (!visibility)collapseEReference (diagram, ref);
				else expandEReference(diagram, ref);
			}
			
			for (EReference ref: DiagramUtils.getEReferencesIncoming(diagram,(EClass)element)){
				if (!otherElements.contains(ref))
				if (!visibility)collapseEReference (diagram, ref);
				else expandEReference(diagram, ref);
			}
			for (Anchor anchor: cs.getAnchors()){
				for (Connection con : anchor.getOutgoingConnections()){
					EObject ref = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
					if (!otherElements.contains(ref))
					if (con.isVisible()!= visibility) con.setVisible(visibility);
				}
				for (Connection con : anchor.getIncomingConnections()) {
					EObject ref = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(con);
					if (!otherElements.contains(ref))
					if (con.isVisible()!= visibility) con.setVisible(visibility);
				}
			}

		}else {
			ContainerShape cs = getContainerShape(diagram, element);
			if (cs != null) cs.setVisible(visibility);
		}
	}

	/**
	 * Static method that inserts a collapse reference text into the box that contains all the collapse references of the specified eclass.
	 * @param diagram
	 * @param ref
	 */
	public static void addCollapseReferenceText(Diagram diagram, EReference ref){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, ref.getEContainingClass());
		for (PictogramElement pe : pes){
			if (DiagramUtils.isCollapseInformationRef(pe)){
				Text textcollapseInfo = (Text)((Shape)pe).getGraphicsAlgorithm();
				if (textcollapseInfo.getValue().isEmpty())  
				textcollapseInfo.setValue(DiagramUtils.getCollapseReferenceText(ref));
				else textcollapseInfo.setValue(textcollapseInfo.getValue()+"\n"+DiagramUtils.getCollapseReferenceText(ref));
				Graphiti.getGaService().setLocationAndSize(textcollapseInfo, 5, DiagramStyles.CLASS_DEF_HEIGHT, textcollapseInfo.getWidth(), DiagramUtils.getHeightCollapseReferencesText(textcollapseInfo));
			}
		}
	}
	
	/**
	 * Static method that deletes a collapse reference text from the box that contains all the collapse references of the containg eclass of the specified ereference.
	 * @param diagram
	 * @param ref
	 */
	public static void deleteCollapseReferenceText(Diagram diagram, EReference ref){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, (ref.getEContainingClass()));
		for (PictogramElement pe : pes){
			if (DiagramUtils.isCollapseInformationRef(pe)){
				org.eclipse.graphiti.mm.algorithms.Text textcollapseInfo = (org.eclipse.graphiti.mm.algorithms.Text)((Shape)pe).getGraphicsAlgorithm();
				
				String cadOpp = DiagramUtils.getCollapseReferenceTextFromText(textcollapseInfo.getValue(), ref);
				textcollapseInfo.setValue(textcollapseInfo.getValue().replace(cadOpp, ""));
				Graphiti.getGaService().setLocationAndSize(textcollapseInfo, 5, DiagramStyles.CLASS_DEF_HEIGHT, textcollapseInfo.getWidth(), DiagramUtils.getHeightCollapseReferencesText(textcollapseInfo));
			}
		}
	}

	/**
	 * Static method that updates a collapse reference text on the box that contains all the collapse references of the containing eclass of the specified ereference.
	 * @param diagram
	 * @param oldKey -> key used by identify the entry.
	 * @param refNew -> reference after the change
	 */
	public static void updateCollapseReferenceText(Diagram diagram, String oldKey, EReference refNew){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, refNew.getEContainingClass());
		for (PictogramElement pe : pes){
			if (DiagramUtils.isCollapseInformationRef(pe)){
				org.eclipse.graphiti.mm.algorithms.Text textcollapseInfo = (org.eclipse.graphiti.mm.algorithms.Text)((Shape)pe).getGraphicsAlgorithm();
	
				String cadOld = DiagramUtils.getCollapseReferenceTextFromTextByKey(textcollapseInfo.getValue(), oldKey);
				cadOld = cadOld.replace("\n", "");
				String cadNew = DiagramUtils.getCollapseReferenceText(refNew);
				String textCollapseInfoValue = textcollapseInfo.getValue();
				cadOld = cadOld.replace("[", "\\[");
				cadOld = cadOld.replace("]", "\\]");
				textcollapseInfo.setValue(textCollapseInfoValue.replaceFirst(cadOld, cadNew));				
				Graphiti.getGaService().setLocationAndSize(textcollapseInfo, 5, 60, textcollapseInfo.getWidth(), DiagramUtils.getHeightCollapseReferencesText(textcollapseInfo));
			}
		}		
	}
	
	/**
	 * Static method that returns the collapse text key (unique) related to the specified reference.
	 * @param ref
	 * @return text
	 */
	public static String getCollapseReferenceTextKey(EReference ref){
		return ref.getName()+(ref.getEType()!= null?":"+ref.getEType().getName(): "")+"["+getBoundReferenceText(ref)+"]";
	}
	
	/**
	 * Static method that returns the collapse text related to the specified reference.
	 * @param eRef
	 * @return text
	 */
	private static String getCollapseReferenceText(EReference eRef){
		return eRef.getName()+(eRef.getEType()!= null?":"+eRef.getEType().getName(): "")+"["+getBoundReferenceText(eRef)+"]";
	}
	
	/**
	 * Static method that returns the height space for a collapse referenceS text.
	 * @param text
	 * @return height
	 */
	private static int getHeightCollapseReferencesText(Text text){
		return text.getValue().split("\n").length*15;
	}
	
	/**
	 * Static method that returns the collapse reference text from the specified collapse referenceS text by the specified ereference. 
	 * @param collapseReferencesText - String
	 * @param eRef - EReference.
	 * @return text
	 */
	private static String getCollapseReferenceTextFromText(String collapseReferencesText,EReference eRef){
			
		String key = getCollapseReferenceTextKey(eRef);
		return getCollapseReferenceTextFromTextByKey(collapseReferencesText,key);
	}
	
	/**
	 * Static method that returns the collapse reference text from the specified collapse referenceS text by key
	 * @param collapseReferencesText
	 * @param key
	 * @return text
	 */
	private static String getCollapseReferenceTextFromTextByKey(String collapseReferencesText,String key){
		String[] crs = collapseReferencesText.split("\n");
		int i = 0;		
		while (i<crs.length){
			if (crs[i].contains(key))
				return ((i != 0)? "\n": "") + crs[i] + ((i == 0)&& (crs.length!=1)? "\n": "");
			i++;
		}
		return "";
	}
	
	/**
	 * Static method that returns if the specified shape is collapsed or not.
	 * @param shape
	 * @return true if is collapsed, false if not
	 */
	public static boolean isCollapse (Shape shape){
		for (Property property: shape.getProperties()){
			if ((property.getKey().equals(MODE)) && (property.getValue().equals(COLLAPSE)))
				return true;
		}
		return false;
	}
	
	/**
	 * static method that returns if the specified EClass is showed collapsed or not.
	 * @param diagram
	 * @param eClass
	 * @return true if is collapsed, false if not
	 */
	public static boolean isCollapse (Diagram diagram, EClass eClass){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eClass);
		
		for (PictogramElement pe : pes){
			if (pe instanceof ContainerShape)
				return isCollapse((ContainerShape) pe);
		}
		return false;

	}
	
	/**
	 * Static method that returns if the specified shape is expanded or not.
	 * @param shape
	 * @return true if is expanded, false if not
	 */
	public static boolean isExpand (Shape shape){
		for (Property property: shape.getProperties()){
			if ((property.getKey().equals(MODE)) && (property.getValue().equals(EXPAND)))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that sets the mode collapse in the specified shape.
	 * @param shape
	 */
	private static void setIsCollapseMode (Shape shape){
		for (Property p : shape.getProperties()){
			if (p.getKey().compareTo(MODE)==0){
				p.setValue(COLLAPSE);
				break;
			}
		}
	}
	
	/**
	 * Static method that sets the mode collapse in the specified shape.
	 * @param shape
	 */
	private static void setIsExpandMode (Shape shape){
		for (Property p : shape.getProperties()){
			if (p.getKey().compareTo(MODE)==0){
				p.setValue(EXPAND);
				break;
			}
		}
	}
	
	/**
	 * Static method that initialises the mode expand in the specified shape.
	 * @param shape
	 */
	public static void initMode (Shape shape){
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey(MODE);
		marker.setValue(DiagramUtils.EXPAND);		
		shape.getProperties().add(marker);
	}	
	
	/**
	 * Static method that collapses a the specified shape of an EEnum
	 * @param shape
	 * @param fp
	 */
	public static void collapseEEnum (ContainerShape shape, IFeatureProvider fp){
		ResizeEEnumFeature ref = new ResizeEEnumFeature(fp);
        ResizeShapeContext rsContext = new ResizeShapeContext(shape);
        rsContext.setWidth(DiagramStyles.ENUM_MIN_WIDTH);
        rsContext.setHeight(DiagramStyles.ENUM_MIN_HEIGHT);
        rsContext.setX((shape).getGraphicsAlgorithm().getX());
        rsContext.setY((shape).getGraphicsAlgorithm().getY());
        ref.resizeShape(rsContext);
        
        List<Shape> shapes = shape.getChildren();    		
		
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(false);
        
		for (int i=3;i<shapes.size();i++){
			Shape eEnumLiteralText = shapes.get(i);
			eEnumLiteralText.setVisible(false);
		}
		
		setIsCollapseMode(shape);
	}	
	
	/**
	 * Static method that expands the specified shape of an EEnum
	 * @param shape
	 * @param fp
	 */
	public static void expandEEnum (ContainerShape shape, IFeatureProvider fp){
		ResizeEEnumFeature ref = new ResizeEEnumFeature(fp);
        ResizeShapeContext rsContext = new ResizeShapeContext(shape);
        rsContext.setWidth(DiagramStyles.ENUM_WIDTH);
        rsContext.setHeight(DiagramStyles.ENUM_HEIGHT);
        rsContext.setX((shape).getGraphicsAlgorithm().getX());
        rsContext.setY((shape).getGraphicsAlgorithm().getY());
        ref.resizeShape(rsContext);
        
        //Hide EnumLiterals
        List<Shape> shapes = shape.getChildren();    		
		
        //LINEA
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(true);
              
        //Attributes
		for (int i=3;i<shapes.size();i++){
			Shape eEnumLiteralText = shapes.get(i);
			eEnumLiteralText.setVisible(true);
		}
		
		setIsExpandMode(shape);
	}
	
	/**
	 * Static method that collapses the specified ereference.
	 * @param eRef
	 */
	public static void collapseEReference (Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));	
			
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_NAME).setVisible(false);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_BOUNDS).setVisible(false);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_ORUNI).setVisible(false);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_PATTERN).setVisible(false);
			
			getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_DIR).setVisible(false);
			if (eRef.isContainment()){
				ConnectionDecorator cd = getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
				if (cd != null) cd.setVisible(false);
			}	
			if (eRef.getEOpposite() != null){
				if (!getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR).isVisible())
						con.setVisible(false);
			}else con.setVisible(false);
		
		} else {
			List<PictogramElement> pesOp = Graphiti.getLinkService().getPictogramElements(diagram, eRef.getEOpposite());
			Connection conOp = null;
			if (pesOp.size()>0) {
				conOp = ((Connection)pesOp.get(0));	
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_NAME_OP).setVisible(false);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_BOUNDS_OP).setVisible(false);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_ORUNI_OP).setVisible(false);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_PATTERN_OP).setVisible(false);
				
				getConnectionDecorator(conOp, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR).setVisible(false);
				if (eRef.getEOpposite().isContainment()){
					ConnectionDecorator cd = getConnectionDecorator(conOp, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
					if (cd != null) cd.setVisible(false);
				}
				if (isCollapse(diagram, (EClass)eRef.getEType()))
					conOp.setVisible(false);
			
			}
		}
	}
		
	/**
	 * Static method that expands the specified EReference.
	 * @param diagram
	 * @param eRef
	 */
	public static void expandEReference (Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));	
			
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_NAME).setVisible(true);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_BOUNDS).setVisible(true);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_ORUNI).setVisible(true);
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_PATTERN).setVisible(isPatternInfo(diagram));
			
			getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_DIR).setVisible(true);
			if (eRef.isContainment()){
				ConnectionDecorator cd = getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
				if (cd != null) cd.setVisible(true);
			}
			
			con.setVisible(true);
		} else {
			List<PictogramElement> pesOp = Graphiti.getLinkService().getPictogramElements(diagram, eRef.getEOpposite());
			Connection conOp = null;
			if (pesOp.size()>0) {
				conOp = ((Connection)pesOp.get(0));	
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_NAME_OP).setVisible(true);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_BOUNDS_OP).setVisible(true);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_ORUNI_OP).setVisible(true);
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_PATTERN_OP).setVisible(isPatternInfo(diagram));
				
				getConnectionDecorator(conOp, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR).setVisible(true);
				if (eRef.getEOpposite().isContainment()){
					ConnectionDecorator cd = getConnectionDecorator(conOp, DecoratorFigure.EREF_DECORATOR_CONTAINMENT);
					if (cd != null) cd.setVisible(true);
				}
				conOp.setVisible(true);
			}
		}
	}
	
	/**
	 * Static method that collapses the specified shape.
	 * @param shape
	 * @param fp
	 */
	public static void collapseEClass (ContainerShape shape, IFeatureProvider fp){
        List<Shape> shapes = shape.getChildren();    		
		
        //Annotations
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(false);
        
        Shape collapseReferenceText = shapes.get(4);
        int heightReferences = collapseReferenceText.getGraphicsAlgorithm().getHeight();
        collapseReferenceText.setVisible(true);
        
        //Attributes
		for (int i=DiagramUtils.POS_ATTRIBUTES;i<shapes.size();i++){
			Shape eAttributeText = shapes.get(i);
			eAttributeText.setVisible(false);
		}
		
		ResizeEClassFeature ref = new ResizeEClassFeature(fp);
        ResizeShapeContext rsContext = new ResizeShapeContext(shape);
        rsContext.setWidth(shape.getGraphicsAlgorithm().getWidth());
        rsContext.setHeight(DiagramStyles.CLASS_DEF_HEIGHT+heightReferences+5);
        rsContext.setX((shape).getGraphicsAlgorithm().getX());
        rsContext.setY((shape).getGraphicsAlgorithm().getY());
        ref.resizeShape(rsContext);
		
        for (EReference eRef : ((EClass)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape)).getEReferences()){
			DiagramUtils.collapseEReference(fp.getDiagramTypeProvider().getDiagram(), eRef);
		}
        
		setIsCollapseMode(shape);
	}
	
	/**
	 * Static method that collapses the inheritance information of a shape.
	 * @param shape
	 * @param fp
	 */
	public static void collapseEClassInheritance (EClass eclass, Diagram diagram, IFeatureProvider fp){
		Boolean heritage = false;
		for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, eclass)){
			if (pe instanceof ContainerShape){
				for (Anchor anchor: ((ContainerShape)pe).getAnchors()){
					for (Connection con : anchor.getOutgoingConnections()){
						for (Property p: con.getProperties()) {
							if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_INHERITANCE)){
								heritage = true;
								con.setVisible(false);
							}
						}
					}
				}
				if (heritage) {
		            for (Shape shape : ((ContainerShape)pe).getChildren()) {
		                if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
		                    org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) shape.getGraphicsAlgorithm();
		                    for (Property p: text.getProperties()) 
								if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_TEXT)){
									text.setValue(getHeritageEDN(eclass, 0));
									text.setFont(Graphiti.getGaService().manageFont(diagram, "Verdana",DiagramStyles.MEDIUM_SIZE_FONT, false, true));
								}
		                }
		            }
				}
			}
			
		}
	}
	
	public static String getHeritageEDN(EClass eclass, int level){
		String text = "";
		int numSuperTypes=eclass.getESuperTypes().size();
		if (numSuperTypes>0){
			if (numSuperTypes>1)text += "[";
			for (int i=0; i<numSuperTypes; i++){
				EClass superType = eclass.getESuperTypes().get(i);
				text += (i==0?"":",")+getHeritageEDN(superType, ((numSuperTypes>1)?1:level+1));
			}
			if (numSuperTypes>1) 
				text += "]";
			if (!text.startsWith("<<"))text="<"+text;

		}
		return (level<2?eclass.getName()+text:(numSuperTypes==0)?eclass.getName()+text:text);
	}
	
	/**
	 * Static method that expands the inheritance information of a shape.
	 * @param shape
	 * @param fp
	 */
	public static void expandEClassInheritance (EClass eclass, Diagram diagram, IFeatureProvider fp){
		Boolean heritage = false;
		for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, eclass)){
			if (pe instanceof ContainerShape){
		        //Escondemos la conexión
				for (Anchor anchor: ((ContainerShape)pe).getAnchors()){
					for (Connection con : anchor.getOutgoingConnections()){
						for (Property p: con.getProperties()) {
							if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_INHERITANCE)){
								heritage = true;
								con.setVisible(true);
							}
						}
					}
				}
				if (heritage) {
		            for (Shape shape : ((ContainerShape)pe).getChildren()) {
		                if (shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Text) {
		                    org.eclipse.graphiti.mm.algorithms.Text text = (org.eclipse.graphiti.mm.algorithms.Text) shape.getGraphicsAlgorithm();
		                    for (Property p: text.getProperties()) 
								if (p.getKey().equals("type") && p.getValue().equals(DiagramUtils.TYPE_TEXT)){
									text.setValue(eclass.getName());
									text.setFont(Graphiti.getGaService().manageFont(diagram, "Verdana",DiagramStyles.EXTRA_BIG_SIZE_FONT, false, true));
								}
		                }
		            }
				}
			}
			
		}
	}
	
	
	
	
	/**
	 * Static method that expands the specified shape.
	 * @param shape
	 * @param fp
	 */
	public static void expandEClass (ContainerShape shape, IFeatureProvider fp){
		ResizeEClassFeature ref = new ResizeEClassFeature(fp);
        ResizeShapeContext rsContext = new ResizeShapeContext(shape);
        rsContext.setWidth(shape.getGraphicsAlgorithm().getWidth());
        rsContext.setHeight(DiagramStyles.CLASS_HEIGHT);
        rsContext.setX((shape).getGraphicsAlgorithm().getX());
        rsContext.setY((shape).getGraphicsAlgorithm().getY());
        ref.resizeShape(rsContext);
        
        List<Shape> shapes = shape.getChildren();    		
		
        //Annotations.
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(isPatternInfo(fp.getDiagramTypeProvider().getDiagram()));
        
        Shape collapseReferenceText = shapes.get(4);
        collapseReferenceText.setVisible(false);
        
        //Attributes
		for (int i=DiagramUtils.POS_ATTRIBUTES;i<shapes.size();i++){
			Shape eAttributeText = shapes.get(i);
			eAttributeText.setVisible(true);
		}
		
		for (EReference eRef : ((EClass)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape)).getEReferences()){
			DiagramUtils.expandEReference(fp.getDiagramTypeProvider().getDiagram(), eRef);
		}
		
		setIsExpandMode(shape);
		
	}
	
	/**
	 * Static method that returns a connection by the specified eReference.
	 * @param diagram
	 * @param eRef
	 * @return connection
	 */
	private static Connection getConnection(Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		if (pes.size()>0) {
		  return ((Connection)pes.get(0));
		}else {
			EReference opp = eRef.getEOpposite();
			List<PictogramElement> pesOpp = Graphiti.getLinkService().getPictogramElements(diagram, opp);
			if (pesOpp.size()>0){
				return ((Connection)pesOpp.get(0));
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the pictogram element to select by ENamedElement.
	 * @param diagram
	 * @param element
	 * @return pictogram element
	 */
	public static PictogramElement getPictogramToSelect(Diagram diagram, ENamedElement element){
		if (element instanceof EReference) return getConnection(diagram, (EReference) element);
		else return getContainerShape(diagram, element);
	}
	
	/**
	 * Static method that returns the pictogram element related to the package that contains the ENamedElement.
	 * @param diagram
	 * @param element
	 * @return pictogram element
	 */
	public static PictogramElement getPictogramEPackageToSelect(Diagram diagram, ENamedElement element){
		if (element instanceof EClassifier){ 
			if (((EClassifier)element).eContainer() instanceof EPackage){
				PictogramElement pePack = DiagramUtils.getPictogramToSelect(diagram, (EPackage)((EClassifier)element).eContainer());
				return pePack;
			}
		}else if (element instanceof EStructuralFeature)
			return getPictogramEPackageToSelect(diagram, ((EStructuralFeature)element).getEContainingClass());
		return null;
	}

	
	/**
	 * Static method that returns the pictogram to select in a validation by ENamedElement.
	 * if the element is an epackage it's returned the shape, not the diagram.
	 * @param diagram
	 * @param element
	 * @return pictogram element
	 */
    public static PictogramElement getPictogramToSelectValidation(Diagram diagram, ENamedElement element){
    	if (element != null){
    		PictogramElement pe = DiagramUtils.getPictogramToSelect(diagram, element);
    		if (pe != null) return pe;
    		else if (element instanceof EPackage) return getPictogramToSelectValidation(diagram, ((EPackage)element).getESuperPackage());
    		else if (element instanceof EClassifier) return  getPictogramToSelectValidation(diagram, ((EClassifier) element).getEPackage());
    	}return null;
    }
	
    /**
     * Static method that returns the container shape related to the specified ENamedElement. 
     * @param diagram
     * @param element
     * @return container shape
     */
	private static ContainerShape getContainerShape(Diagram diagram, ENamedElement element){
		List<PictogramElement> pictograms = Graphiti.getLinkService().getPictogramElements(diagram, element);
		for (PictogramElement pe : pictograms)
			if ((pe instanceof ContainerShape)&& !(pe instanceof Diagram))
				return (ContainerShape)pe;
		return null;
	} 
	
	/**
	 * Static method that selects the specified list of pictogram elements.
	 * @param peList
	 */
	public static void selectPictograms(List<PictogramElement> peList){		
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();
		
		if (editor instanceof IDiagramContainerUI){
			PictogramElement[] pes = peList.toArray(new PictogramElement[peList.size()]);
			((IDiagramContainerUI)editor).selectPictogramElements(pes);
			((IDiagramContainerUI)editor).getDiagramBehavior().refresh();
		}
	}
	
	/**
	 * Static method that selects the specified pictogram element
	 * @param pe
	 */
	public static void selectPictogram(PictogramElement pe){	
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = (IEditorPart)activePage.getActiveEditor();		
		if (editor instanceof IDiagramContainerUI){		
			PictogramElement[] pes = new PictogramElement[]{pe};
			((IDiagramContainerUI)editor).selectPictogramElements(pes);
			((IDiagramContainerUI)editor).getDiagramBehavior().refresh();
		}
	}
	
	/**
	 * Static method that updates the editor.
	 */
	public static void refreshEditor(){
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = activePage.getActiveEditor();	
		if (editor instanceof IDiagramContainerUI) ((IDiagramContainerUI)editor).getDiagramBehavior().refresh();
	}
	
	/**
	 * Static method that create a epposite reference of the given reference.
	 * @param reference
	 * @param diagram
	 * @return created EReference
	 */
	public static EReference createEOppositeReference(EReference reference, Diagram diagram){
		EReference eOpposite = EcoreFactory.eINSTANCE.createEReference();
		EClass sourceOpC = (EClass)reference.getEType();
		EClass targetOpC = (EClass)reference.getEContainingClass();
		eOpposite.setName(ModelUtils.getRefOpNameValid(sourceOpC));
		eOpposite.setEType(targetOpC);
		
		/////TEMPORAL 
		//Default values
		//eOpposite.setOrdered(false);
		//eOpposite.setUnique(false);
        ////
		
		
		sourceOpC.getEStructuralFeatures().add(eOpposite);
		reference.setEOpposite(eOpposite);
		eOpposite.setEOpposite(reference);
		
		Connection con = null;
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, reference);
		for (PictogramElement pe: pes){
			if (pe instanceof Connection)
				con = (Connection)pe;
		}
		if (con!= null){
			DiagramUtils.setDecoratorText(con, eOpposite.getName(), DecoratorText.EREF_DECORATOR_NAME_OP);
			DiagramUtils.setDecoratorText(con, eOpposite.getLowerBound()+".."+((eOpposite.getUpperBound() == -1 ? "*" : eOpposite.getUpperBound())), DecoratorText.EREF_DECORATOR_BOUNDS_OP);
			DiagramUtils.setDecoratorText(con, DiagramUtils.getOrderedUniqueText(eOpposite), DecoratorText.EREF_DECORATOR_ORUNI_OP);
			DiagramUtils.createDirDecorator(diagram, con, 0, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR, ColorConstant.BLACK);	
		}
		DiagramUtils.addCollapseReferenceText(diagram, eOpposite);
		return eOpposite;
	}
	
	/**
	 * Static method that create a epposite reference of the given reference with the opposite values
	 * @param reference
	 * @param opposite
	 * @param diagram
	 * @return created EReference
	 */
	public static EReference createEOppositeReference(EReference reference, EReference opposite, Diagram diagram){
		EReference eOpposite = EcoreFactory.eINSTANCE.createEReference();
		EClass sourceOpC = (EClass)reference.getEType();
		EClass targetOpC = (EClass)reference.getEContainingClass();
		eOpposite.setName(ModelUtils.getRefNameValid(sourceOpC, opposite.getName()));
		eOpposite.setEType(targetOpC);
		eOpposite.setLowerBound(opposite.getLowerBound());
		eOpposite.setUpperBound(opposite.getUpperBound());
		eOpposite.setContainment(opposite.isContainment());
		
		eOpposite.setOrdered(opposite.isOrdered());
		eOpposite.setUnique(opposite.isOrdered());
		
		
		sourceOpC.getEStructuralFeatures().add(eOpposite);
		reference.setEOpposite(eOpposite);
		eOpposite.setEOpposite(reference);
		
		Connection con = null;
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, reference);
		for (PictogramElement pe: pes){
			if (pe instanceof Connection)
				con = (Connection)pe;
		}
		if (con!= null){
			DiagramUtils.setDecoratorText(con, eOpposite.getName(), DecoratorText.EREF_DECORATOR_NAME_OP);
			DiagramUtils.setDecoratorText(con, eOpposite.getLowerBound()+".."+((eOpposite.getUpperBound() == -1 ? "*" : eOpposite.getUpperBound())), DecoratorText.EREF_DECORATOR_BOUNDS_OP);
			DiagramUtils.setDecoratorText(con, DiagramUtils.getOrderedUniqueText(eOpposite), DecoratorText.EREF_DECORATOR_ORUNI_OP);
			DiagramUtils.createDirDecorator(diagram, con, 0, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR, ColorConstant.BLACK);	
			if (eOpposite.isContainment()) DiagramUtils.createContainmentDecorator(diagram, con, 1);	
		}
		DiagramUtils.addCollapseReferenceText(diagram, eOpposite);
		return eOpposite;
	}

	/**
	 * Static method that inserts the specified text into the specified decorator.
	 * @param pe
	 * @param text
	 * @param dec
	 * @return connection decorator
	 */
	public static ConnectionDecorator setDecoratorText(Connection pe, String text, DecoratorText dec){
		ConnectionDecorator cd = pe.getConnectionDecorators().get(dec.getPos());
	   	((Text)cd.getGraphicsAlgorithm()).setValue(text);
	   	return cd;
	}
	
	/**
	 * Static method that returns the text of a connection by decoratorText.
	 * @param pe - connection.
	 * @param dec - DecoratorText
	 * @return text
	 */
	public static String getDecoratorText(Connection pe, DecoratorText dec){
		ConnectionDecorator cd = getConnectionDecorator(pe, dec);
	   	return ((Text)cd.getGraphicsAlgorithm()).getValue();
	}
	
	/**
	 * Static method that returns the connection decorator of the specified connection by decoratorText
	 * @param pe
	 * @param dec
	 * @return connection decorator
	 */
	private static ConnectionDecorator getConnectionDecorator(Connection pe, DecoratorText dec){
		return  pe.getConnectionDecorators().get(dec.getPos());
	}
	
	/**
	 * Static method that draw an arrow figure on the specified gacontainer.
	 * @param diagram
	 * @param gaContainer
	 * @return the polyline (arrow)
	 */
	private static Polyline createArrowFigure(Diagram diagram, GraphicsAlgorithmContainer gaContainer, IColorConstant color) {
		IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15,-10 });
        polyline.setForeground(gaService.manageColor(diagram,color));
        polyline.setLineWidth(2);
        return polyline;
    }
	
	/**
	 * Static method that returns the connection decorator of the specified connection by DecoratorFigure
	 * @param pe
	 * @param df
	 * @return connection decorator
	 */
	private static ConnectionDecorator getConnectionDecorator(Connection pe, DecoratorFigure df){
		for (ConnectionDecorator dec: pe.getConnectionDecorators()){
			for (Property prop: dec.getProperties()){
				if (prop.getValue().compareTo(df.toString())==0){
					return dec;
				}
			}
		}
		return null;
	}
	
	/**
	 * Static method that draw the direction on the specified connection.
	 * @param diagram
	 * @param pe - connection
	 * @param location 
	 * @param df - DecoratorFigure.
	 */
	public static void createDirDecorator(Diagram diagram, Connection pe, double location, DecoratorFigure df, IColorConstant color){
		ConnectionDecorator cd;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		cd = peCreateService.createConnectionDecorator(pe, false, location, true);
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(df.toString());		
		cd.getProperties().add(marker);
		
		createArrowFigure(diagram, cd, color);
	}
	
	/**
	 * Static method that draw a rombus figure on the specified gacontainer
	 * @param diagram
	 * @param gaContainer
	 * @return Polygon (rombus)
	 */
	private static Polygon createRhombusFigure(Diagram diagram, GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		 int xy[] = new int[] {  -15, 10, 0, 0, -15,-10,-30,0 };
		 Polygon polygon = gaService.createPolygon(gaContainer, xy);
		 polygon.setBackground(gaService.manageColor(diagram, ColorConstant.BLACK));
		 
       return polygon;
    }
	
	/**
	 * Static method that draws the containment decorator on the specified connection.
	 * @param diagram
	 * @param pe
	 * @param location
	 */
	public static void createContainmentDecorator(Diagram diagram, Connection pe, double location){
		ConnectionDecorator cd;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		cd = peCreateService.createConnectionDecorator(pe, false, location, true);
		
		Property marker = MmFactory.eINSTANCE.createProperty();
		marker.setKey("type");
		marker.setValue(DecoratorFigure.EREF_DECORATOR_CONTAINMENT.toString());		
		cd.getProperties().add(marker);
		
		createRhombusFigure(diagram, cd);
	}
	
	/**
	 * static method that deletes a decorator from the specified connection by DecoratorFigure.
	 * @param pe - connection.
	 * @param df - DeleteFigure.
	 */
	public static void deleteDecorator(Connection pe, DecoratorFigure df){
		for (ConnectionDecorator dec: pe.getConnectionDecorators()){
			for (Property prop: dec.getProperties()){
				if (prop.getValue().compareTo(df.toString())==0){
					pe.getConnectionDecorators().remove(dec);
					return;
				}
			}
		}
	}
	
	/**
	 * Static method that returns the connection decorator related to the specified EReference.
	 * @param diagram
	 * @param eRef
	 * @return connection decorator
	 */
	public static ConnectionDecorator getConnectionDecoratorDir(Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));
			return  getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_DIR);
		}else {
			EReference opp = eRef.getEOpposite();
			List<PictogramElement> pesOpp = Graphiti.getLinkService().getPictogramElements(diagram, opp);
			if (pesOpp.size()>0){
				con = ((Connection)pesOpp.get(0));
				return  getConnectionDecorator(con, DecoratorFigure.EREF_DECORATOR_OPPOSITE_DIR);
			}
		}
		return null;
	}
	
	/**
	 * Static method that insert the specified pattern text into a decorator related to the specified EReference.
	 * @param diagram
	 * @param eRef
	 * @param text - annotations text
	 * @return connection decorator
	 */
	public static ConnectionDecorator setDecoratorPatternInfoText(Diagram diagram, EReference eRef, String text){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));
			return setDecoratorText(con, text, DecoratorText.EREF_DECORATOR_PATTERN);
		}else {
			EReference opp = eRef.getEOpposite();
			List<PictogramElement> pesOpp = Graphiti.getLinkService().getPictogramElements(diagram, opp);
			if (pesOpp.size()>0){
				con = ((Connection)pesOpp.get(0));
				return setDecoratorText(con, text, DecoratorText.EREF_DECORATOR_PATTERN_OP);
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns the annotations text related to the specified EReference.
	 * @param diagram
	 * @param eRef
	 * @return text
	 */
	public static String getDecoratorPatternInfoText(Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));
			return getDecoratorText(con, DecoratorText.EREF_DECORATOR_PATTERN);
		}else {
			EReference opp = eRef.getEOpposite();
			List<PictogramElement> pesOpp = Graphiti.getLinkService().getPictogramElements(diagram, opp);
			if (pesOpp.size()>0){
				con = ((Connection)pesOpp.get(0));
				return getDecoratorText(con, DecoratorText.EREF_DECORATOR_PATTERN_OP);
			}
		}
		return null;
	}
	
	/**
	 * RUNTIMEPATTERNS
	 * Static method that returns the pattern text related to the specified element.
	 * @param diagram
	 * @param element EModelElement
	 * @return text
	 */
	public static String getPatternPictogramText (Diagram diagram, EModelElement element){	
		if ((element instanceof EClass) ||(element instanceof EPackage)){
			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, element)){
                if (pe instanceof Shape) {
                	if (pe.getGraphicsAlgorithm() instanceof Text){
	                	Text textShape = (Text) pe.getGraphicsAlgorithm();					                   
	                    if (DiagramUtils.isInfoPatterns(textShape)){
	                    	return textShape.getValue();
	                    }   
                	}
				}
			}
		} else if (element instanceof EReference){
			return DiagramUtils.getDecoratorPatternInfoText(diagram, (EReference)element);
			
		} else if (element instanceof EAttribute){
			return "";
		} 
		return null;
	}
	
	/**
	 * Static method that returns the pictogram element to draw the specified annotation text.
	 * @param diagram
	 * @param element EModelElement
	 * @return pictogram element
	 */
	public static PictogramElement getPatternInfoPictogram (Diagram diagram, EModelElement element){	
		if (((element instanceof EClass)||(element instanceof EPackage))){
			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, element)){
                if (pe instanceof Shape) {
                	if (pe.getGraphicsAlgorithm() instanceof Text){
                	Text textShape = (Text) pe.getGraphicsAlgorithm();					                   
	                    if (DiagramUtils.isInfoPatterns(textShape)){
	                    	return pe;
	                    }  
                	}
				}
			}
		} else if (element instanceof EAttribute){
			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, element)){
                if (pe instanceof ContainerShape) return pe;
			}
		} 
		return null;
	}
	
	/**
	 * Static method that draw the text on the specified element.
	 * @param diagramB - diagram behaviour
	 * @param element EModelElement
	 * @param text pattern text
	 * @return pictogramElement
	 */
	public static PictogramElement paintPatternInfoText (DiagramBehavior diagramB, EModelElement element, String text){	
		Diagram diagram = diagramB.getDiagramTypeProvider().getDiagram();
		if (((element instanceof EClass)||(element instanceof EPackage))&& (text!=null)){
			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, element)){
                if (pe instanceof Shape) {
                	if (pe.getGraphicsAlgorithm() instanceof Text){
                	Text textShape = (Text) pe.getGraphicsAlgorithm();					                   
	                    if (DiagramUtils.isInfoPatterns(textShape)){
	                    	textShape.setValue(text);
	                    	if ((element instanceof EPackage)&& (text.isEmpty())){
	                    		DeleteContext dc = new DeleteContext(((Shape)pe).getContainer());
	                    		DefaultDeleteFeature ddf = new DefaultDeleteFeature(diagramB.getDiagramTypeProvider().getFeatureProvider());
	                    		ddf.execute(dc);
	                    	}
	                    	return pe;
	                    }  
                	}
				}
			}
		} else if ((element instanceof EReference) && (text != null)){
			ConnectionDecorator cd = DiagramUtils.setDecoratorPatternInfoText(diagram, (EReference)element, text);
			return cd;
			
		}else if (element instanceof EAttribute){
			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, element)){
                if (pe instanceof ContainerShape) return pe;
			}
		} 
		return null;
	}
	
	/**
	 * Static method that initialises the mode show_pattern_info in the specified shape.
	 * @param shape
	 */
	public static void initPatternInfo (Shape shape){
		
		if (!existsProperty(shape, SHOW_PATTERN_INFO)){
			Property marker  = MmFactory.eINSTANCE.createProperty();
			marker.setKey(SHOW_PATTERN_INFO);
			marker.setValue(String.valueOf(true));		
			shape.getProperties().add(marker);
		}
	}
	
	public static boolean existsProperty (Shape shape, String propertyName){
		for (Property property: shape.getProperties()){
			if (property.getKey().equals(propertyName))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that returns if the specified shape is showing the pattern information.
	 * @param shape
	 * @return true if the pattern information is showed, false it not.
	 */
	public static boolean isPatternInfo (Shape shape){
		for (Property property: shape.getProperties()){
			if ((property.getKey().equals(SHOW_PATTERN_INFO)) && (property.getValue().equals(String.valueOf(true))))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that inserts the mode show_pattern_info (true/false)into the specified shape
	 * @param shape
	 * @param show
	 */
	public static void setPatternInfo (Shape shape, boolean show){
		for (Property p : shape.getProperties()){
			if (p.getKey().compareTo(SHOW_PATTERN_INFO)==0){
				p.setValue(String.valueOf(show));
				break;
			}
		}
	}
	
	
	/**
	 * Static method that initialises the mode COLLAPSE_INHERITANCE in the specified shape.
	 * @param shape
	 */
	public static void initCollapseInheritance (Shape shape){
		if (!existsProperty(shape, COLLAPSE_INHERITANCE)){
			Property marker  = MmFactory.eINSTANCE.createProperty();
			marker.setKey(COLLAPSE_INHERITANCE);
			marker.setValue(String.valueOf(false));		
			shape.getProperties().add(marker);
		}
	}
	/**
	 * Static method that returns if the specified shape is inheritance collapsed.
	 * @param shape
	 * @return true if the inheritance is collapsed, false it not.
	 */
	public static boolean isCollapseInheritance (Shape shape){
		for (Property property: shape.getProperties()){
			if ((property.getKey().equals(COLLAPSE_INHERITANCE)) && (property.getValue().equals(String.valueOf(true))))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method that inserts the mode collapse_inheritance_info (true/false)into the specified shape
	 * @param shape
	 * @param show
	 */
	public static void setCollapseInheritance (Shape shape, boolean collapse){
		for (Property p : shape.getProperties()){
			if (p.getKey().compareTo(COLLAPSE_INHERITANCE)==0){
				p.setValue(String.valueOf(collapse));
				break;
			}
		}
	}
	
	
	
	
	/**
	 * Static method that hides the pattern information of the specified shape of an Eclass
	 * @param shape
	 * @param fp
	 */
	public static void hidePatternInfoEClass (ContainerShape shape, IFeatureProvider fp){        
        List<Shape> shapes = shape.getChildren();    			
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(false);  
	}

	/**
	 * Static method that shows the pattern information of the specified shape of an Eclass
	 * @param shape
	 * @param fp
	 */
	public static void showPatternInfoEClass (ContainerShape shape, IFeatureProvider fp){
        List<Shape> shapes = shape.getChildren();    		
		
        Shape eAnnotationText = shapes.get(2);
        eAnnotationText.setVisible(true);
        
	}
	
	/**
	 * static method that hides the pattern information of the specified EReference.
	 * @param eRef
	 */
	public static void hidePatternInfoEReference (Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));	
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_PATTERN).setVisible(false);
			
		} else {
			List<PictogramElement> pesOp = Graphiti.getLinkService().getPictogramElements(diagram, eRef.getEOpposite());
			Connection conOp = null;
			if (pesOp.size()>0) {
				conOp = ((Connection)pesOp.get(0));	
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_PATTERN_OP).setVisible(false);
			}
		}
	}
		
	/**
	 * Static method that shows the pattern information of the specified EReference
	 * @param diagram
	 * @param eRef
	 */
	public static void showPatternInfoEReference (Diagram diagram, EReference eRef){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, eRef);
		Connection con = null;
		if (pes.size()>0) {
			con = ((Connection)pes.get(0));			
			getConnectionDecorator(con, DecoratorText.EREF_DECORATOR_PATTERN).setVisible(true);
		} else {
			List<PictogramElement> pesOp = Graphiti.getLinkService().getPictogramElements(diagram, eRef.getEOpposite());
			Connection conOp = null;
			if (pesOp.size()>0) {
				conOp = ((Connection)pesOp.get(0));	
				getConnectionDecorator(conOp, DecoratorText.EREF_DECORATOR_PATTERN_OP).setVisible(true);
			}
		}
	}

	/**
	 * Static method that returns the diagrams contained on the specified iprojetc.
	 * @param p
	 * @return collection of diagrams.
	 */
	public static Collection<Diagram> getDiagrams(IProject p) {
		final List<Diagram> diagramList = new ArrayList<Diagram>();
		final List<IFile> files = getDiagramFiles(p);
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Diagram diagram = getDiagramFromFile(file, rSet);
			if (diagram != null) {
				diagramList.add(diagram);
			}
		}
		return diagramList;
	}
	
	/**
	 * Static methos that returns the ifiles contained on the specified IContainer.
	 * @param folder
	 * @return list of IFiles
	 */
	private static List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) {
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Static method that returns the diagram by IFile and ResourceSet
	 * @param file
	 * @param resourceSet
	 * @return diagram
	 */
	private static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
		//URI of the model file.
		final URI resourceURI = IResourceUtils.getFileURI(file, resourceSet);
		//load the resource for this file.
		Resource resource;
		try {
		resource = resourceSet.getResource(resourceURI, true);
		if (resource != null) {
			final EList<EObject> contents = resource.getContents();
				for (final EObject object : contents) {
					if (object instanceof Diagram) {
					return (Diagram) object;
					}
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Static method that returns the diagrams linked to the specified epackage.
	 * @param fp
	 * @param epack
	 * @return collection of diagrams.
	 */
	public static Collection<Diagram> getRecursiveLinkedDiagrams(IFeatureProvider fp, EPackage epack){	
		Collection<Diagram> diagrams = new HashSet<Diagram>();
		for (EPackage subPack : epack.getESubpackages()){
			Collection<Diagram> diagramsSub = getRecursiveLinkedDiagrams(fp, subPack);
			for (Diagram diagramAux:diagramsSub )
				if (!existsDiagram(diagrams,diagramAux))diagrams.add(diagramAux);
		}
		Collection<Diagram> diagramsMine = getLinkedDiagrams(fp, epack);
		for (Diagram diagramAux:diagramsMine )
			if (!existsDiagram(diagrams,diagramAux))diagrams.add(diagramAux);
		return diagrams;
	}
	
	/**
	 * Static methos that return a hashmap that relates diagrams and objects to update.
	 * @param fp
	 * @param epack
	 * @param current
	 * @return a hashmap with the diagrams and its related objects.
	 */
	public static HashMap<Diagram,Object[]> getRecursiveLinkedDiagramsNewObjects(IFeatureProvider fp, EPackage epack, Diagram current){	
		HashMap<Diagram,Object[]> diagramsLinks = new HashMap<Diagram,Object[]>();
		for (EPackage subPack : epack.getESubpackages()){
			HashMap<Diagram,Object[]> diagramsSub = getRecursiveLinkedDiagramsNewObjects(fp, subPack, current);
			diagramsLinks.putAll(diagramsSub);
		}
		Collection<Diagram> diagramsMine = getAllLinkedDiagrams(fp, epack);
		for (Diagram diagram: diagramsMine){
			if (!EcoreUtil.equals(current, diagram)){
				Diagram diagramAux = getDiagram(diagramsLinks.keySet(), diagram);
				if (diagramAux== null){
					EPackage[] epacks = new EPackage[]{epack};
					diagramsLinks.put(diagram, epacks);
				} else{
					diagramsLinks.put(diagramAux, Utils.addObjectArray(diagramsLinks.get(diagramAux), epack));
				}
			}
			
		}
		return diagramsLinks;
	}
	
	/**
	 * Static method that returns if the specified diagram exists in a collection of diagrams.
	 * @param diagrams
	 * @param diagram
	 * @return true if the diagram exists, false if not.
	 */
	private static boolean existsDiagram (Collection<Diagram> diagrams, Diagram diagram){
		for (Diagram diagramAux: diagrams)
			if(diagramAux.getName().compareTo(diagram.getName()) == 0)
				return true;
		return false;
	}
	
	/**
	 * Static method that returns the diagram from the specified collection of diagrams by name (diagram.getName()).
	 * @param diagrams
	 * @param diagram
	 * @return diagram
	 */
	private static Diagram getDiagram (Collection<Diagram> diagrams, Diagram diagram){
		for (Diagram diagramAux: diagrams)
			if(diagramAux.getName().compareTo(diagram.getName()) == 0)
				return diagramAux;
		return null;
	}
	
	/**
	 * Static method that returns the element from the specified collection of elements by name (element.getName())
	 * @param elements
	 * @param element
	 * @return ENamedElement
	 */
	public static ENamedElement getElement (Object[] elements, ENamedElement element){
		for (Object objAux: elements)
			if (objAux instanceof ENamedElement){
				if (((ENamedElement)objAux).getName().compareTo(element.getName())==0)
				return (ENamedElement)objAux;
			}	
		return null;
	}
	
	/**
	 * Static method that returns the collection of diagrams linked to the specified epackage.
	 * @param fp
	 * @param epack
	 * @return collection fo diagrams
	 */
	public static Collection<Diagram> getAllLinkedDiagrams(IFeatureProvider fp, EPackage epack) {
		Collection<Diagram> ret = new HashSet<Diagram>();
		Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		IProject project = IResourceUtils.getProject(diagram.eResource());
		Collection<Diagram> allDiagrams = DiagramUtils.getDiagrams(project);
		for (Diagram d : allDiagrams) {
			final Object[] businessObjectsForDiagram = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(d);
			for (int i = 0; i < businessObjectsForDiagram.length; i++) {
				final Object diagramBo = businessObjectsForDiagram[i];
				if (fp.getDiagramTypeProvider().getCurrentToolBehaviorProvider()
						.equalsBusinessObjects(epack, diagramBo)) {
					ret.add(d);
				}
			}
		}
		return ret;
	}
	
	/**
	 * Static method that returns the collection of diagrams linked to the specified EPackage. (the collection don't contain the current, the diagram where the epackage is painted.)
	 * @param fp
	 * @param epack
	 * @return collection of diagrams
	 */
	public static Collection<Diagram> getLinkedDiagrams(IFeatureProvider fp, EPackage epack) {
		Collection<Diagram> ret = new HashSet<Diagram>();
		Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		IProject project = IResourceUtils.getProject(diagram.eResource());
		Collection<Diagram> allDiagrams = DiagramUtils.getDiagrams(project);
		for (Diagram d : allDiagrams) {
			if (!isCurrentDiagram(d, epack)) { 
				final Object[] businessObjectsForDiagram = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(d);
				for (int i = 0; i < businessObjectsForDiagram.length; i++) {
					final Object diagramBo = businessObjectsForDiagram[i];
					if (fp.getDiagramTypeProvider().getCurrentToolBehaviorProvider()
							.equalsBusinessObjects(epack, diagramBo)) {
						ret.add(d);
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Static method that returns the collection of diagrams linked to the specified epackage using the proxy.
	 * @param fp
	 * @param epack
	 * @param ecoreDiagram
	 * @return collection of diagrams
	 */
	public static Collection<Diagram> getLinkedDiagrams(IFeatureProvider fp, EPackage epack, Diagram ecoreDiagram) {
		Collection<Diagram> ret = new HashSet<Diagram>();
		Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		IProject project = IResourceUtils.getProject(diagram.eResource());
		Collection<Diagram> allDiagrams = DiagramUtils.getDiagrams(project);
		for (Diagram d : allDiagrams) {
			if (!isCurrentDiagram(d, epack)) { 
				Object[] businessObjectsForDiagram = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(d);
				for (int i = 0; i < businessObjectsForDiagram.length; i++) {
					EObject diagramBo = (EObject)businessObjectsForDiagram[i];
					
					if (diagramBo.eIsProxy()){
						diagramBo = EcoreUtil.resolve(diagramBo, ecoreDiagram);
					}
					
					if (fp.getDiagramTypeProvider().getCurrentToolBehaviorProvider()
							.equalsBusinessObjects(epack, diagramBo)) {
						ret.add(d);
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Static method that returns if the specified epackage is painted on the specified diagram.
	 * @param d
	 * @param epack
	 * @return true if is the current diagram, false if not
	 */
	private static boolean isCurrentDiagram (Diagram d, EPackage epack){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(d, epack);
		for (PictogramElement pe: pes){
			if (!(pe instanceof Diagram)) return true;
		}
		return false;
	}
		
}
