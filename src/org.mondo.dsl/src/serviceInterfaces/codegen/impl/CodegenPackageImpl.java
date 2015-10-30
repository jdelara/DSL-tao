/**
 */
package serviceInterfaces.codegen.impl;

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

import serviceInterfaces.codegen.ClassPointcut;
import serviceInterfaces.codegen.CodeGenLanguage;
import serviceInterfaces.codegen.CodegenFactory;
import serviceInterfaces.codegen.CodegenPackage;
import serviceInterfaces.codegen.ImportElementPointcut;
import serviceInterfaces.codegen.InjectorAcceptorInterfaceL1;
import serviceInterfaces.codegen.MethodPoincut;
import serviceInterfaces.codegen.Pointcut;
import serviceInterfaces.codegen.PointcutType;
import serviceInterfaces.codegen.SlotPlugInterfaceL1;
import serviceInterfaces.codegen.StatementPoincut;
import serviceInterfaces.codegen.TransformationLibrary;

import serviceInterfaces.impl.ServiceInterfacesPackageImpl;

import serviceInterfaces.modelingenv.ModelingenvPackage;

import serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodegenPackageImpl extends EPackageImpl implements CodegenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectorAcceptorInterfaceL1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slotPlugInterfaceL1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointcutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPointcutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodPoincutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importElementPointcutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementPoincutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum codeGenLanguageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pointcutTypeEEnum = null;

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
	 * @see serviceInterfaces.codegen.CodegenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CodegenPackageImpl() {
		super(eNS_URI, CodegenFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CodegenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CodegenPackage init() {
		if (isInited) return (CodegenPackage)EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI);

		// Obtain or create and register package
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CodegenPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI) : DslPatternsPackage.eINSTANCE);
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theCodegenPackage.createPackageContents();
		theDslPatternsPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theCodegenPackage.initializePackageContents();
		theDslPatternsPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodegenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodegenPackage.eNS_URI, theCodegenPackage);
		return theCodegenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjectorAcceptorInterfaceL1() {
		return injectorAcceptorInterfaceL1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInjectorAcceptorInterfaceL1_InjectorProvides() {
		return (EReference)injectorAcceptorInterfaceL1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationLibrary() {
		return transformationLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationLibrary_Name() {
		return (EAttribute)transformationLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationLibrary_Language() {
		return (EAttribute)transformationLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlotPlugInterfaceL1() {
		return slotPlugInterfaceL1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSlotPlugInterfaceL1_Pointcuts() {
		return (EReference)slotPlugInterfaceL1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPointcut() {
		return pointcutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPointcut_Type() {
		return (EAttribute)pointcutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassPointcut() {
		return classPointcutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodPoincut() {
		return methodPoincutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportElementPointcut() {
		return importElementPointcutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementPoincut() {
		return statementPoincutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCodeGenLanguage() {
		return codeGenLanguageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPointcutType() {
		return pointcutTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenFactory getCodegenFactory() {
		return (CodegenFactory)getEFactoryInstance();
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
		injectorAcceptorInterfaceL1EClass = createEClass(INJECTOR_ACCEPTOR_INTERFACE_L1);
		createEReference(injectorAcceptorInterfaceL1EClass, INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES);

		transformationLibraryEClass = createEClass(TRANSFORMATION_LIBRARY);
		createEAttribute(transformationLibraryEClass, TRANSFORMATION_LIBRARY__NAME);
		createEAttribute(transformationLibraryEClass, TRANSFORMATION_LIBRARY__LANGUAGE);

		slotPlugInterfaceL1EClass = createEClass(SLOT_PLUG_INTERFACE_L1);
		createEReference(slotPlugInterfaceL1EClass, SLOT_PLUG_INTERFACE_L1__POINTCUTS);

		pointcutEClass = createEClass(POINTCUT);
		createEAttribute(pointcutEClass, POINTCUT__TYPE);

		classPointcutEClass = createEClass(CLASS_POINTCUT);

		methodPoincutEClass = createEClass(METHOD_POINCUT);

		importElementPointcutEClass = createEClass(IMPORT_ELEMENT_POINTCUT);

		statementPoincutEClass = createEClass(STATEMENT_POINCUT);

		// Create enums
		codeGenLanguageEEnum = createEEnum(CODE_GEN_LANGUAGE);
		pointcutTypeEEnum = createEEnum(POINTCUT_TYPE);
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
		injectorAcceptorInterfaceL1EClass.getESuperTypes().add(theServiceInterfacesPackage.getInterface());
		slotPlugInterfaceL1EClass.getESuperTypes().add(theServiceInterfacesPackage.getInterface());
		classPointcutEClass.getESuperTypes().add(this.getPointcut());
		methodPoincutEClass.getESuperTypes().add(this.getPointcut());
		importElementPointcutEClass.getESuperTypes().add(this.getPointcut());
		statementPoincutEClass.getESuperTypes().add(this.getPointcut());

		// Initialize classes and features; add operations and parameters
		initEClass(injectorAcceptorInterfaceL1EClass, InjectorAcceptorInterfaceL1.class, "InjectorAcceptorInterfaceL1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInjectorAcceptorInterfaceL1_InjectorProvides(), this.getTransformationLibrary(), null, "injectorProvides", null, 0, 1, InjectorAcceptorInterfaceL1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationLibraryEClass, TransformationLibrary.class, "TransformationLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransformationLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransformationLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationLibrary_Language(), this.getCodeGenLanguage(), "language", null, 0, 1, TransformationLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(slotPlugInterfaceL1EClass, SlotPlugInterfaceL1.class, "SlotPlugInterfaceL1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSlotPlugInterfaceL1_Pointcuts(), this.getPointcut(), null, "pointcuts", null, 0, 1, SlotPlugInterfaceL1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointcutEClass, Pointcut.class, "Pointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPointcut_Type(), this.getPointcutType(), "type", null, 0, 1, Pointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classPointcutEClass, ClassPointcut.class, "ClassPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodPoincutEClass, MethodPoincut.class, "MethodPoincut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(importElementPointcutEClass, ImportElementPointcut.class, "ImportElementPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(statementPoincutEClass, StatementPoincut.class, "StatementPoincut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(codeGenLanguageEEnum, CodeGenLanguage.class, "CodeGenLanguage");
		addEEnumLiteral(codeGenLanguageEEnum, CodeGenLanguage.ACCELEO);

		initEEnum(pointcutTypeEEnum, PointcutType.class, "PointcutType");
		addEEnumLiteral(pointcutTypeEEnum, PointcutType.BEFORE);
		addEEnumLiteral(pointcutTypeEEnum, PointcutType.AFTER);
		addEEnumLiteral(pointcutTypeEEnum, PointcutType.BEFORE_BODY);
		addEEnumLiteral(pointcutTypeEEnum, PointcutType.AFTER_BODY);
	}

} //CodegenPackageImpl
