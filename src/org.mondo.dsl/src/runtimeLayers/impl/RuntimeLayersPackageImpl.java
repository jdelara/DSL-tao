/**
 */
package runtimeLayers.impl;

import dslPatterns.DslPatternsPackage;

import dslPatterns.impl.DslPatternsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import runtimeLayers.BackgroundLayer;
import runtimeLayers.Layer;
import runtimeLayers.LayerSet;
import runtimeLayers.PatternRoleDependece;
import runtimeLayers.RuntimeLayersFactory;
import runtimeLayers.RuntimeLayersPackage;
import runtimeLayers.UserLayer;

import runtimePatterns.RuntimePatternsPackage;

import runtimePatterns.impl.RuntimePatternsPackageImpl;

import runtimeServices.RuntimeServicesPackage;

import runtimeServices.impl.RuntimeServicesPackageImpl;

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
public class RuntimeLayersPackageImpl extends EPackageImpl implements RuntimeLayersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass backgroundLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternRoleDependeceEClass = null;

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
	 * @see runtimeLayers.RuntimeLayersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimeLayersPackageImpl() {
		super(eNS_URI, RuntimeLayersFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimeLayersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimeLayersPackage init() {
		if (isInited) return (RuntimeLayersPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimeLayersPackage.eNS_URI);

		// Obtain or create and register package
		RuntimeLayersPackageImpl theRuntimeLayersPackage = (RuntimeLayersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimeLayersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimeLayersPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		RuntimePatternsPackageImpl theRuntimePatternsPackage = (RuntimePatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimePatternsPackage.eNS_URI) instanceof RuntimePatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimePatternsPackage.eNS_URI) : RuntimePatternsPackage.eINSTANCE);
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		RuntimeServicesPackageImpl theRuntimeServicesPackage = (RuntimeServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI) instanceof RuntimeServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI) : RuntimeServicesPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theRuntimeLayersPackage.createPackageContents();
		theRuntimePatternsPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theRuntimeServicesPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimeLayersPackage.initializePackageContents();
		theRuntimePatternsPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theRuntimeServicesPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimeLayersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimeLayersPackage.eNS_URI, theRuntimeLayersPackage);
		return theRuntimeLayersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerSet() {
		return layerSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerSet_Background() {
		return (EReference)layerSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerSet_UserLayers() {
		return (EReference)layerSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBackgroundLayer() {
		return backgroundLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserLayer() {
		return userLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayer() {
		return layerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_Order() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_Name() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_Activated() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_Visualised() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayer_Content() {
		return (EReference)layerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayer_PatternRole() {
		return (EReference)layerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayer_Use() {
		return (EReference)layerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternRoleDependece() {
		return patternRoleDependeceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternRoleDependece_Use() {
		return (EReference)patternRoleDependeceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternRoleDependece_Pattern() {
		return (EReference)patternRoleDependeceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeLayersFactory getRuntimeLayersFactory() {
		return (RuntimeLayersFactory)getEFactoryInstance();
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
		layerSetEClass = createEClass(LAYER_SET);
		createEReference(layerSetEClass, LAYER_SET__BACKGROUND);
		createEReference(layerSetEClass, LAYER_SET__USER_LAYERS);

		backgroundLayerEClass = createEClass(BACKGROUND_LAYER);

		userLayerEClass = createEClass(USER_LAYER);

		layerEClass = createEClass(LAYER);
		createEAttribute(layerEClass, LAYER__ORDER);
		createEAttribute(layerEClass, LAYER__NAME);
		createEAttribute(layerEClass, LAYER__ACTIVATED);
		createEAttribute(layerEClass, LAYER__VISUALISED);
		createEReference(layerEClass, LAYER__CONTENT);
		createEReference(layerEClass, LAYER__PATTERN_ROLE);
		createEReference(layerEClass, LAYER__USE);

		patternRoleDependeceEClass = createEClass(PATTERN_ROLE_DEPENDECE);
		createEReference(patternRoleDependeceEClass, PATTERN_ROLE_DEPENDECE__USE);
		createEReference(patternRoleDependeceEClass, PATTERN_ROLE_DEPENDECE__PATTERN);
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
		RuntimePatternsPackage theRuntimePatternsPackage = (RuntimePatternsPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePatternsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		backgroundLayerEClass.getESuperTypes().add(this.getLayer());
		userLayerEClass.getESuperTypes().add(this.getLayer());

		// Initialize classes and features; add operations and parameters
		initEClass(layerSetEClass, LayerSet.class, "LayerSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerSet_Background(), this.getBackgroundLayer(), null, "background", null, 1, 1, LayerSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayerSet_UserLayers(), this.getUserLayer(), null, "userLayers", null, 0, -1, LayerSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(backgroundLayerEClass, BackgroundLayer.class, "BackgroundLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userLayerEClass, UserLayer.class, "UserLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(layerEClass, Layer.class, "Layer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayer_Order(), ecorePackage.getEInt(), "order", null, 1, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayer_Activated(), ecorePackage.getEBoolean(), "activated", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayer_Visualised(), ecorePackage.getEBoolean(), "visualised", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayer_Content(), ecorePackage.getEObject(), null, "content", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayer_PatternRole(), this.getPatternRoleDependece(), null, "patternRole", null, 0, -1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayer_Use(), this.getLayer(), null, "use", null, 0, -1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternRoleDependeceEClass, PatternRoleDependece.class, "PatternRoleDependece", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternRoleDependece_Use(), this.getLayer(), null, "use", null, 0, -1, PatternRoleDependece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternRoleDependece_Pattern(), theRuntimePatternsPackage.getPatternInstance(), null, "pattern", null, 1, 1, PatternRoleDependece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "rtpat", "http://mondo.org/runtimePatterns#/"
		   });
	}

} //RuntimeLayersPackageImpl
