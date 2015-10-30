/**
 */
package mindMapDSML.impl;

import dslPatterns.DslPatternsPackage;

import dslPatterns.impl.DslPatternsPackageImpl;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.Link;
import mindMapDSML.MindMap;
import mindMapDSML.MindMapDSMLFactory;
import mindMapDSML.MindMapDSMLPackage;

import mindMapDSML.Note;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import serviceInterfaces.ServiceInterfacesPackage;

import serviceInterfaces.codegen.CodegenPackage;

import serviceInterfaces.codegen.impl.CodegenPackageImpl;

import serviceInterfaces.impl.ServiceInterfacesPackageImpl;

import serviceInterfaces.modelingenv.ModelingenvPackage;

import serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MindMapDSMLPackageImpl extends EPackageImpl implements MindMapDSMLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mindMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ideaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see mindMapDSML.MindMapDSMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MindMapDSMLPackageImpl() {
		super(eNS_URI, MindMapDSMLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MindMapDSMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MindMapDSMLPackage init() {
		if (isInited) return (MindMapDSMLPackage)EPackage.Registry.INSTANCE.getEPackage(MindMapDSMLPackage.eNS_URI);

		// Obtain or create and register package
		MindMapDSMLPackageImpl theMindMapDSMLPackage = (MindMapDSMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MindMapDSMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MindMapDSMLPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theMindMapDSMLPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theMindMapDSMLPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMindMapDSMLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MindMapDSMLPackage.eNS_URI, theMindMapDSMLPackage);
		return theMindMapDSMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMindMap() {
		return mindMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMindMap_Ideas() {
		return (EReference)mindMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMindMap_Name() {
		return (EAttribute)mindMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdea() {
		return ideaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdea_Id() {
		return (EAttribute)ideaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdea_Name() {
		return (EAttribute)ideaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdea_Description() {
		return (EAttribute)ideaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdea_Contains() {
		return (EReference)ideaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdea_Links() {
		return (EReference)ideaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdea_Pattern() {
		return (EReference)ideaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdea_Notes() {
		return (EReference)ideaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdea_SubText() {
		return (EAttribute)ideaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdea_Features() {
		return (EReference)ideaEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Name() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Target() {
		return (EReference)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNote() {
		return noteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Text() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Key() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Value() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindMapDSMLFactory getMindMapDSMLFactory() {
		return (MindMapDSMLFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mindMapEClass = createEClass(MIND_MAP);
		createEReference(mindMapEClass, MIND_MAP__IDEAS);
		createEAttribute(mindMapEClass, MIND_MAP__NAME);

		ideaEClass = createEClass(IDEA);
		createEAttribute(ideaEClass, IDEA__ID);
		createEAttribute(ideaEClass, IDEA__NAME);
		createEAttribute(ideaEClass, IDEA__DESCRIPTION);
		createEReference(ideaEClass, IDEA__CONTAINS);
		createEReference(ideaEClass, IDEA__LINKS);
		createEReference(ideaEClass, IDEA__PATTERN);
		createEReference(ideaEClass, IDEA__NOTES);
		createEAttribute(ideaEClass, IDEA__SUB_TEXT);
		createEReference(ideaEClass, IDEA__FEATURES);

		linkEClass = createEClass(LINK);
		createEAttribute(linkEClass, LINK__NAME);
		createEReference(linkEClass, LINK__TARGET);

		noteEClass = createEClass(NOTE);
		createEAttribute(noteEClass, NOTE__TEXT);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__KEY);
		createEAttribute(featureEClass, FEATURE__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DslPatternsPackage theDslPatternsPackage = (DslPatternsPackage)EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(mindMapEClass, MindMap.class, "MindMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMindMap_Ideas(), this.getIdea(), null, "ideas", null, 0, -1, MindMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMindMap_Name(), ecorePackage.getEString(), "name", null, 0, 1, MindMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ideaEClass, Idea.class, "Idea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdea_Id(), ecorePackage.getEString(), "id", null, 0, 1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdea_Name(), ecorePackage.getEString(), "name", null, 0, 1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdea_Description(), ecorePackage.getEString(), "description", null, 0, 1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdea_Contains(), this.getIdea(), null, "contains", null, 0, -1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdea_Links(), this.getLink(), null, "links", null, 0, -1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdea_Pattern(), theDslPatternsPackage.getPatternMetaModel(), null, "pattern", null, 0, 1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdea_Notes(), this.getNote(), null, "notes", null, 0, -1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdea_SubText(), ecorePackage.getEString(), "subText", null, 0, 1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdea_Features(), this.getFeature(), null, "features", null, 0, -1, Idea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLink_Name(), ecorePackage.getEString(), "name", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLink_Target(), this.getIdea(), null, "target", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noteEClass, Note.class, "Note", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNote_Text(), ecorePackage.getEString(), "text", null, 0, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Key(), ecorePackage.getEString(), "key", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Value(), ecorePackage.getEString(), "value", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MindMapDSMLPackageImpl
