/**
 */
package runtimeServices.impl;

import dslPatterns.DslPatternsPackage;

import dslPatterns.impl.DslPatternsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import runtimePatterns.RuntimePatternsPackage;
import runtimePatterns.impl.RuntimePatternsPackageImpl;
import runtimeServices.DisconnectedElement;
import runtimeServices.RuntimeServicesFactory;
import runtimeServices.RuntimeServicesPackage;
import runtimeServices.ServiceInstance;
import runtimeServices.ServiceInstances;

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
public class RuntimeServicesPackageImpl extends EPackageImpl implements RuntimeServicesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceInstancesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disconnectedElementEClass = null;

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
	 * @see runtimeServices.RuntimeServicesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimeServicesPackageImpl() {
		super(eNS_URI, RuntimeServicesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimeServicesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimeServicesPackage init() {
		if (isInited) return (RuntimeServicesPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimeServicesPackage.eNS_URI);

		// Obtain or create and register package
		RuntimeServicesPackageImpl theRuntimeServicesPackage = (RuntimeServicesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimeServicesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimeServicesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theRuntimeServicesPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimeServicesPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimeServicesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimeServicesPackage.eNS_URI, theRuntimeServicesPackage);
		return theRuntimeServicesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceInstances() {
		return serviceInstancesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceInstances_Services() {
		return (EReference)serviceInstancesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceInstance() {
		return serviceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceInstance_Service() {
		return (EReference)serviceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceInstance_Activated() {
		return (EAttribute)serviceInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceInstance_DisconnectedElements() {
		return (EReference)serviceInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisconnectedElement() {
		return disconnectedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisconnectedElement_Interface() {
		return (EReference)disconnectedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisconnectedElement_Patterns() {
		return (EReference)disconnectedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeServicesFactory getRuntimeServicesFactory() {
		return (RuntimeServicesFactory)getEFactoryInstance();
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
		serviceInstancesEClass = createEClass(SERVICE_INSTANCES);
		createEReference(serviceInstancesEClass, SERVICE_INSTANCES__SERVICES);

		serviceInstanceEClass = createEClass(SERVICE_INSTANCE);
		createEReference(serviceInstanceEClass, SERVICE_INSTANCE__SERVICE);
		createEAttribute(serviceInstanceEClass, SERVICE_INSTANCE__ACTIVATED);
		createEReference(serviceInstanceEClass, SERVICE_INSTANCE__DISCONNECTED_ELEMENTS);

		disconnectedElementEClass = createEClass(DISCONNECTED_ELEMENT);
		createEReference(disconnectedElementEClass, DISCONNECTED_ELEMENT__INTERFACE);
		createEReference(disconnectedElementEClass, DISCONNECTED_ELEMENT__PATTERNS);
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
		ServiceInterfacesPackage theServiceInterfacesPackage = (ServiceInterfacesPackage)EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(serviceInstancesEClass, ServiceInstances.class, "ServiceInstances", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceInstances_Services(), this.getServiceInstance(), null, "services", null, 0, -1, ServiceInstances.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceInstanceEClass, ServiceInstance.class, "ServiceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceInstance_Service(), theDslPatternsPackage.getService(), null, "service", null, 1, 1, ServiceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceInstance_Activated(), ecorePackage.getEBoolean(), "activated", null, 0, 1, ServiceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceInstance_DisconnectedElements(), this.getDisconnectedElement(), null, "disconnectedElements", null, 0, -1, ServiceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(disconnectedElementEClass, DisconnectedElement.class, "DisconnectedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisconnectedElement_Interface(), theServiceInterfacesPackage.getInterface(), null, "interface", null, 0, 1, DisconnectedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDisconnectedElement_Patterns(), theDslPatternsPackage.getPattern(), null, "patterns", null, 0, -1, DisconnectedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

} //RuntimeServicesPackageImpl
