/**
 */
package runtimePatterns.impl;

import dslPatterns.DslPatternsPackage;

import dslPatterns.impl.DslPatternsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.FeatureRoleInstance;
import runtimePatterns.InstanceFeatureRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.PatternInstances;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.RoleInstance;
import runtimePatterns.RuntimePatternsFactory;
import runtimePatterns.RuntimePatternsPackage;
import runtimePatterns.TypeFeatureRoleInstance;

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
public class RuntimePatternsPackageImpl extends EPackageImpl implements RuntimePatternsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternInstancesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classRoleInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureRoleInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceFeatureRoleInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeFeatureRoleInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceRoleInstanceEClass = null;

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
	 * @see runtimePatterns.RuntimePatternsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimePatternsPackageImpl() {
		super(eNS_URI, RuntimePatternsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimePatternsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimePatternsPackage init() {
		if (isInited) return (RuntimePatternsPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePatternsPackage.eNS_URI);

		// Obtain or create and register package
		RuntimePatternsPackageImpl theRuntimePatternsPackage = (RuntimePatternsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimePatternsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimePatternsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		RuntimeServicesPackageImpl theRuntimeServicesPackage = (RuntimeServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI) instanceof RuntimeServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI) : RuntimeServicesPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theRuntimePatternsPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theRuntimeServicesPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimePatternsPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theRuntimeServicesPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimePatternsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimePatternsPackage.eNS_URI, theRuntimePatternsPackage);
		return theRuntimePatternsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternInstances() {
		return patternInstancesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternInstances_AppliedPatterns() {
		return (EReference)patternInstancesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternInstance() {
		return patternInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternInstance_Ident() {
		return (EAttribute)patternInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternInstance_Pattern() {
		return (EReference)patternInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternInstance_ClassInstances() {
		return (EReference)patternInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternInstance_ServiceInstances() {
		return (EReference)patternInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternInstance_Attached() {
		return (EAttribute)patternInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleInstance() {
		return roleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassRoleInstance() {
		return classRoleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassRoleInstance_Role() {
		return (EReference)classRoleInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassRoleInstance_Element() {
		return (EReference)classRoleInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassRoleInstance_FeatureInstances() {
		return (EReference)classRoleInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassRoleInstance_ReferenceInstances() {
		return (EReference)classRoleInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureRoleInstance() {
		return featureRoleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceFeatureRoleInstance() {
		return instanceFeatureRoleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceFeatureRoleInstance_Role() {
		return (EReference)instanceFeatureRoleInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceFeatureRoleInstance_Value() {
		return (EAttribute)instanceFeatureRoleInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeFeatureRoleInstance() {
		return typeFeatureRoleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeFeatureRoleInstance_Role() {
		return (EReference)typeFeatureRoleInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeFeatureRoleInstance_Element() {
		return (EReference)typeFeatureRoleInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceRoleInstance() {
		return referenceRoleInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRoleInstance_Role() {
		return (EReference)referenceRoleInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRoleInstance_Element() {
		return (EReference)referenceRoleInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePatternsFactory getRuntimePatternsFactory() {
		return (RuntimePatternsFactory)getEFactoryInstance();
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
		patternInstancesEClass = createEClass(PATTERN_INSTANCES);
		createEReference(patternInstancesEClass, PATTERN_INSTANCES__APPLIED_PATTERNS);

		patternInstanceEClass = createEClass(PATTERN_INSTANCE);
		createEAttribute(patternInstanceEClass, PATTERN_INSTANCE__IDENT);
		createEReference(patternInstanceEClass, PATTERN_INSTANCE__PATTERN);
		createEReference(patternInstanceEClass, PATTERN_INSTANCE__CLASS_INSTANCES);
		createEReference(patternInstanceEClass, PATTERN_INSTANCE__SERVICE_INSTANCES);
		createEAttribute(patternInstanceEClass, PATTERN_INSTANCE__ATTACHED);

		roleInstanceEClass = createEClass(ROLE_INSTANCE);

		classRoleInstanceEClass = createEClass(CLASS_ROLE_INSTANCE);
		createEReference(classRoleInstanceEClass, CLASS_ROLE_INSTANCE__ROLE);
		createEReference(classRoleInstanceEClass, CLASS_ROLE_INSTANCE__ELEMENT);
		createEReference(classRoleInstanceEClass, CLASS_ROLE_INSTANCE__FEATURE_INSTANCES);
		createEReference(classRoleInstanceEClass, CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES);

		featureRoleInstanceEClass = createEClass(FEATURE_ROLE_INSTANCE);

		instanceFeatureRoleInstanceEClass = createEClass(INSTANCE_FEATURE_ROLE_INSTANCE);
		createEReference(instanceFeatureRoleInstanceEClass, INSTANCE_FEATURE_ROLE_INSTANCE__ROLE);
		createEAttribute(instanceFeatureRoleInstanceEClass, INSTANCE_FEATURE_ROLE_INSTANCE__VALUE);

		typeFeatureRoleInstanceEClass = createEClass(TYPE_FEATURE_ROLE_INSTANCE);
		createEReference(typeFeatureRoleInstanceEClass, TYPE_FEATURE_ROLE_INSTANCE__ROLE);
		createEReference(typeFeatureRoleInstanceEClass, TYPE_FEATURE_ROLE_INSTANCE__ELEMENT);

		referenceRoleInstanceEClass = createEClass(REFERENCE_ROLE_INSTANCE);
		createEReference(referenceRoleInstanceEClass, REFERENCE_ROLE_INSTANCE__ROLE);
		createEReference(referenceRoleInstanceEClass, REFERENCE_ROLE_INSTANCE__ELEMENT);
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
		RuntimeServicesPackage theRuntimeServicesPackage = (RuntimeServicesPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classRoleInstanceEClass.getESuperTypes().add(this.getRoleInstance());
		featureRoleInstanceEClass.getESuperTypes().add(this.getRoleInstance());
		instanceFeatureRoleInstanceEClass.getESuperTypes().add(this.getFeatureRoleInstance());
		typeFeatureRoleInstanceEClass.getESuperTypes().add(this.getFeatureRoleInstance());
		referenceRoleInstanceEClass.getESuperTypes().add(this.getRoleInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(patternInstancesEClass, PatternInstances.class, "PatternInstances", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternInstances_AppliedPatterns(), this.getPatternInstance(), null, "appliedPatterns", null, 0, -1, PatternInstances.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternInstanceEClass, PatternInstance.class, "PatternInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPatternInstance_Ident(), ecorePackage.getEString(), "ident", null, 1, 1, PatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternInstance_Pattern(), theDslPatternsPackage.getPattern(), null, "pattern", null, 0, 1, PatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternInstance_ClassInstances(), this.getClassRoleInstance(), null, "classInstances", null, 0, -1, PatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPatternInstance_ServiceInstances(), theRuntimeServicesPackage.getServiceInstance(), null, "serviceInstances", null, 0, -1, PatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPatternInstance_Attached(), ecorePackage.getEBoolean(), "attached", null, 0, 1, PatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleInstanceEClass, RoleInstance.class, "RoleInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classRoleInstanceEClass, ClassRoleInstance.class, "ClassRoleInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassRoleInstance_Role(), theDslPatternsPackage.getClassInterface(), null, "role", null, 0, 1, ClassRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassRoleInstance_Element(), ecorePackage.getEClass(), null, "element", null, 0, 1, ClassRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassRoleInstance_FeatureInstances(), this.getFeatureRoleInstance(), null, "featureInstances", null, 0, -1, ClassRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassRoleInstance_ReferenceInstances(), this.getReferenceRoleInstance(), null, "referenceInstances", null, 0, -1, ClassRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureRoleInstanceEClass, FeatureRoleInstance.class, "FeatureRoleInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceFeatureRoleInstanceEClass, InstanceFeatureRoleInstance.class, "InstanceFeatureRoleInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceFeatureRoleInstance_Role(), theDslPatternsPackage.getFeatureInterface(), null, "role", null, 0, 1, InstanceFeatureRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceFeatureRoleInstance_Value(), ecorePackage.getEString(), "value", "", 0, 1, InstanceFeatureRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeFeatureRoleInstanceEClass, TypeFeatureRoleInstance.class, "TypeFeatureRoleInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeFeatureRoleInstance_Role(), theDslPatternsPackage.getFeatureType(), null, "role", null, 0, 1, TypeFeatureRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeFeatureRoleInstance_Element(), ecorePackage.getEAttribute(), null, "element", null, 0, 1, TypeFeatureRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceRoleInstanceEClass, ReferenceRoleInstance.class, "ReferenceRoleInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceRoleInstance_Role(), theDslPatternsPackage.getReferenceInterface(), null, "role", null, 0, 1, ReferenceRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceRoleInstance_Element(), ecorePackage.getEReference(), null, "element", null, 0, 1, ReferenceRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });
	}

} //RuntimePatternsPackageImpl
