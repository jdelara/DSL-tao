/**
 */
package serviceInterfaces.modelingenv.impl;

import dslPatterns.DslPatternsPackage;

import dslPatterns.impl.DslPatternsPackageImpl;

import mindMapDSML.MindMapDSMLPackage;
import mindMapDSML.impl.MindMapDSMLPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import runtimePatterns.RuntimePatternsPackage;
import runtimePatterns.impl.RuntimePatternsPackageImpl;
import runtimeServices.RuntimeServicesPackage;
import runtimeServices.impl.RuntimeServicesPackageImpl;
import serviceInterfaces.ServiceInterfacesPackage;

import serviceInterfaces.codegen.CodegenPackage;

import serviceInterfaces.codegen.impl.CodegenPackageImpl;

import serviceInterfaces.impl.ServiceInterfacesPackageImpl;

import serviceInterfaces.modelingenv.ExtensionPoint;
import serviceInterfaces.modelingenv.InjectionMode;
import serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0;
import serviceInterfaces.modelingenv.JavaClass;
import serviceInterfaces.modelingenv.JavaInterface;
import serviceInterfaces.modelingenv.JavaTypeDeclaration;
import serviceInterfaces.modelingenv.ModelingenvFactory;
import serviceInterfaces.modelingenv.ModelingenvPackage;
import serviceInterfaces.modelingenv.Operation;
import serviceInterfaces.modelingenv.SlotPlugInterfaceL0;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingenvPackageImpl extends EPackageImpl implements ModelingenvPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectorAcceptorInterfaceL0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaTypeDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slotPlugInterfaceL0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum injectionModeEEnum = null;

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
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelingenvPackageImpl() {
		super(eNS_URI, ModelingenvFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelingenvPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelingenvPackage init() {
		if (isInited) return (ModelingenvPackage)EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI);

		// Obtain or create and register package
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelingenvPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);

		// Create package meta-data objects
		theModelingenvPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();

		// Initialize created meta-data
		theModelingenvPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelingenvPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelingenvPackage.eNS_URI, theModelingenvPackage);
		return theModelingenvPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjectorAcceptorInterfaceL0() {
		return injectorAcceptorInterfaceL0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInjectorAcceptorInterfaceL0_InjectorImplements() {
		return (EReference)injectorAcceptorInterfaceL0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInjectorAcceptorInterfaceL0_Mode() {
		return (EAttribute)injectorAcceptorInterfaceL0EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaTypeDeclaration() {
		return javaTypeDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaTypeDeclaration_QualifiedName() {
		return (EAttribute)javaTypeDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInterface() {
		return javaInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaInterface_Operations() {
		return (EReference)javaInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaClass() {
		return javaClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaClass_Operations() {
		return (EReference)javaClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Name() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlotPlugInterfaceL0() {
		return slotPlugInterfaceL0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlotPlugInterfaceL0_Slot() {
		return (EReference)slotPlugInterfaceL0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionPoint() {
		return extensionPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionPoint_Id() {
		return (EAttribute)extensionPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInjectionMode() {
		return injectionModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingenvFactory getModelingenvFactory() {
		return (ModelingenvFactory)getEFactoryInstance();
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
		injectorAcceptorInterfaceL0EClass = createEClass(INJECTOR_ACCEPTOR_INTERFACE_L0);
		createEReference(injectorAcceptorInterfaceL0EClass, INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS);
		createEAttribute(injectorAcceptorInterfaceL0EClass, INJECTOR_ACCEPTOR_INTERFACE_L0__MODE);

		javaTypeDeclarationEClass = createEClass(JAVA_TYPE_DECLARATION);
		createEAttribute(javaTypeDeclarationEClass, JAVA_TYPE_DECLARATION__QUALIFIED_NAME);

		javaInterfaceEClass = createEClass(JAVA_INTERFACE);
		createEReference(javaInterfaceEClass, JAVA_INTERFACE__OPERATIONS);

		javaClassEClass = createEClass(JAVA_CLASS);
		createEReference(javaClassEClass, JAVA_CLASS__OPERATIONS);

		operationEClass = createEClass(OPERATION);
		createEAttribute(operationEClass, OPERATION__NAME);

		slotPlugInterfaceL0EClass = createEClass(SLOT_PLUG_INTERFACE_L0);
		createEReference(slotPlugInterfaceL0EClass, SLOT_PLUG_INTERFACE_L0__SLOT);

		extensionPointEClass = createEClass(EXTENSION_POINT);
		createEAttribute(extensionPointEClass, EXTENSION_POINT__ID);

		// Create enums
		injectionModeEEnum = createEEnum(INJECTION_MODE);
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
		ServiceInterfacesPackage theServiceInterfacesPackage = (ServiceInterfacesPackage)EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		injectorAcceptorInterfaceL0EClass.getESuperTypes().add(theServiceInterfacesPackage.getInterface());
		javaInterfaceEClass.getESuperTypes().add(this.getJavaTypeDeclaration());
		javaClassEClass.getESuperTypes().add(this.getJavaTypeDeclaration());
		slotPlugInterfaceL0EClass.getESuperTypes().add(theServiceInterfacesPackage.getInterface());

		// Initialize classes and features; add operations and parameters
		initEClass(injectorAcceptorInterfaceL0EClass, InjectorAcceptorInterfaceL0.class, "InjectorAcceptorInterfaceL0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInjectorAcceptorInterfaceL0_InjectorImplements(), this.getJavaTypeDeclaration(), null, "injectorImplements", null, 1, -1, InjectorAcceptorInterfaceL0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInjectorAcceptorInterfaceL0_Mode(), this.getInjectionMode(), "mode", null, 0, 1, InjectorAcceptorInterfaceL0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaTypeDeclarationEClass, JavaTypeDeclaration.class, "JavaTypeDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaTypeDeclaration_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 1, -1, JavaTypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaInterfaceEClass, JavaInterface.class, "JavaInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaInterface_Operations(), this.getOperation(), null, "operations", null, 0, -1, JavaInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaClassEClass, JavaClass.class, "JavaClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaClass_Operations(), this.getOperation(), null, "operations", null, 0, -1, JavaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(slotPlugInterfaceL0EClass, SlotPlugInterfaceL0.class, "SlotPlugInterfaceL0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSlotPlugInterfaceL0_Slot(), this.getExtensionPoint(), null, "slot", null, 1, -1, SlotPlugInterfaceL0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionPointEClass, ExtensionPoint.class, "ExtensionPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensionPoint_Id(), ecorePackage.getEString(), "id", null, 0, 1, ExtensionPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(injectionModeEEnum, InjectionMode.class, "InjectionMode");
		addEEnumLiteral(injectionModeEEnum, InjectionMode.GOOGLE_JUICE);
		addEEnumLiteral(injectionModeEEnum, InjectionMode.PLAIN_JAVA);
	}

} //ModelingenvPackageImpl
