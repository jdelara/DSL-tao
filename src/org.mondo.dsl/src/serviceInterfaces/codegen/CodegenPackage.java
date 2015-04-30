/**
 */
package serviceInterfaces.codegen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import serviceInterfaces.ServiceInterfacesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see serviceInterfaces.codegen.CodegenFactory
 * @model kind="package"
 * @generated
 */
public interface CodegenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codegen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/serviceInterfaces/codegen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "servInt_codegen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenPackage eINSTANCE = serviceInterfaces.codegen.impl.CodegenPackageImpl.init();

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.InjectorAcceptorInterfaceL1Impl <em>Injector Acceptor Interface L1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.InjectorAcceptorInterfaceL1Impl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getInjectorAcceptorInterfaceL1()
	 * @generated
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L1 = 0;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L1__QNAME = ServiceInterfacesPackage.INTERFACE__QNAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L1__DESCRIPTION = ServiceInterfacesPackage.INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Injector Provides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Injector Acceptor Interface L1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L1_FEATURE_COUNT = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.TransformationLibraryImpl <em>Transformation Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.TransformationLibraryImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getTransformationLibrary()
	 * @generated
	 */
	int TRANSFORMATION_LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_LIBRARY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_LIBRARY__LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>Transformation Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.SlotPlugInterfaceL1Impl <em>Slot Plug Interface L1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.SlotPlugInterfaceL1Impl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getSlotPlugInterfaceL1()
	 * @generated
	 */
	int SLOT_PLUG_INTERFACE_L1 = 2;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L1__QNAME = ServiceInterfacesPackage.INTERFACE__QNAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L1__DESCRIPTION = ServiceInterfacesPackage.INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Pointcuts</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L1__POINTCUTS = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Slot Plug Interface L1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L1_FEATURE_COUNT = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.PointcutImpl <em>Pointcut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.PointcutImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getPointcut()
	 * @generated
	 */
	int POINTCUT = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTCUT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Pointcut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTCUT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.ClassPointcutImpl <em>Class Pointcut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.ClassPointcutImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getClassPointcut()
	 * @generated
	 */
	int CLASS_POINTCUT = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_POINTCUT__TYPE = POINTCUT__TYPE;

	/**
	 * The number of structural features of the '<em>Class Pointcut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_POINTCUT_FEATURE_COUNT = POINTCUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.MethodPoincutImpl <em>Method Poincut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.MethodPoincutImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getMethodPoincut()
	 * @generated
	 */
	int METHOD_POINCUT = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_POINCUT__TYPE = POINTCUT__TYPE;

	/**
	 * The number of structural features of the '<em>Method Poincut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_POINCUT_FEATURE_COUNT = POINTCUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.ImportElementPointcutImpl <em>Import Element Pointcut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.ImportElementPointcutImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getImportElementPointcut()
	 * @generated
	 */
	int IMPORT_ELEMENT_POINTCUT = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ELEMENT_POINTCUT__TYPE = POINTCUT__TYPE;

	/**
	 * The number of structural features of the '<em>Import Element Pointcut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ELEMENT_POINTCUT_FEATURE_COUNT = POINTCUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.impl.StatementPoincutImpl <em>Statement Poincut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.impl.StatementPoincutImpl
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getStatementPoincut()
	 * @generated
	 */
	int STATEMENT_POINCUT = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_POINCUT__TYPE = POINTCUT__TYPE;

	/**
	 * The number of structural features of the '<em>Statement Poincut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_POINCUT_FEATURE_COUNT = POINTCUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.CodeGenLanguage <em>Code Gen Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.CodeGenLanguage
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getCodeGenLanguage()
	 * @generated
	 */
	int CODE_GEN_LANGUAGE = 8;

	/**
	 * The meta object id for the '{@link serviceInterfaces.codegen.PointcutType <em>Pointcut Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.codegen.PointcutType
	 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getPointcutType()
	 * @generated
	 */
	int POINTCUT_TYPE = 9;


	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.InjectorAcceptorInterfaceL1 <em>Injector Acceptor Interface L1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injector Acceptor Interface L1</em>'.
	 * @see serviceInterfaces.codegen.InjectorAcceptorInterfaceL1
	 * @generated
	 */
	EClass getInjectorAcceptorInterfaceL1();

	/**
	 * Returns the meta object for the reference '{@link serviceInterfaces.codegen.InjectorAcceptorInterfaceL1#getInjectorProvides <em>Injector Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Injector Provides</em>'.
	 * @see serviceInterfaces.codegen.InjectorAcceptorInterfaceL1#getInjectorProvides()
	 * @see #getInjectorAcceptorInterfaceL1()
	 * @generated
	 */
	EReference getInjectorAcceptorInterfaceL1_InjectorProvides();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.TransformationLibrary <em>Transformation Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Library</em>'.
	 * @see serviceInterfaces.codegen.TransformationLibrary
	 * @generated
	 */
	EClass getTransformationLibrary();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.codegen.TransformationLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see serviceInterfaces.codegen.TransformationLibrary#getName()
	 * @see #getTransformationLibrary()
	 * @generated
	 */
	EAttribute getTransformationLibrary_Name();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.codegen.TransformationLibrary#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see serviceInterfaces.codegen.TransformationLibrary#getLanguage()
	 * @see #getTransformationLibrary()
	 * @generated
	 */
	EAttribute getTransformationLibrary_Language();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.SlotPlugInterfaceL1 <em>Slot Plug Interface L1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Plug Interface L1</em>'.
	 * @see serviceInterfaces.codegen.SlotPlugInterfaceL1
	 * @generated
	 */
	EClass getSlotPlugInterfaceL1();

	/**
	 * Returns the meta object for the reference '{@link serviceInterfaces.codegen.SlotPlugInterfaceL1#getPointcuts <em>Pointcuts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pointcuts</em>'.
	 * @see serviceInterfaces.codegen.SlotPlugInterfaceL1#getPointcuts()
	 * @see #getSlotPlugInterfaceL1()
	 * @generated
	 */
	EReference getSlotPlugInterfaceL1_Pointcuts();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.Pointcut <em>Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pointcut</em>'.
	 * @see serviceInterfaces.codegen.Pointcut
	 * @generated
	 */
	EClass getPointcut();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.codegen.Pointcut#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see serviceInterfaces.codegen.Pointcut#getType()
	 * @see #getPointcut()
	 * @generated
	 */
	EAttribute getPointcut_Type();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.ClassPointcut <em>Class Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Pointcut</em>'.
	 * @see serviceInterfaces.codegen.ClassPointcut
	 * @generated
	 */
	EClass getClassPointcut();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.MethodPoincut <em>Method Poincut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Poincut</em>'.
	 * @see serviceInterfaces.codegen.MethodPoincut
	 * @generated
	 */
	EClass getMethodPoincut();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.ImportElementPointcut <em>Import Element Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Element Pointcut</em>'.
	 * @see serviceInterfaces.codegen.ImportElementPointcut
	 * @generated
	 */
	EClass getImportElementPointcut();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.codegen.StatementPoincut <em>Statement Poincut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement Poincut</em>'.
	 * @see serviceInterfaces.codegen.StatementPoincut
	 * @generated
	 */
	EClass getStatementPoincut();

	/**
	 * Returns the meta object for enum '{@link serviceInterfaces.codegen.CodeGenLanguage <em>Code Gen Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Code Gen Language</em>'.
	 * @see serviceInterfaces.codegen.CodeGenLanguage
	 * @generated
	 */
	EEnum getCodeGenLanguage();

	/**
	 * Returns the meta object for enum '{@link serviceInterfaces.codegen.PointcutType <em>Pointcut Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pointcut Type</em>'.
	 * @see serviceInterfaces.codegen.PointcutType
	 * @generated
	 */
	EEnum getPointcutType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CodegenFactory getCodegenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.InjectorAcceptorInterfaceL1Impl <em>Injector Acceptor Interface L1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.InjectorAcceptorInterfaceL1Impl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getInjectorAcceptorInterfaceL1()
		 * @generated
		 */
		EClass INJECTOR_ACCEPTOR_INTERFACE_L1 = eINSTANCE.getInjectorAcceptorInterfaceL1();

		/**
		 * The meta object literal for the '<em><b>Injector Provides</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES = eINSTANCE.getInjectorAcceptorInterfaceL1_InjectorProvides();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.TransformationLibraryImpl <em>Transformation Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.TransformationLibraryImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getTransformationLibrary()
		 * @generated
		 */
		EClass TRANSFORMATION_LIBRARY = eINSTANCE.getTransformationLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_LIBRARY__NAME = eINSTANCE.getTransformationLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_LIBRARY__LANGUAGE = eINSTANCE.getTransformationLibrary_Language();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.SlotPlugInterfaceL1Impl <em>Slot Plug Interface L1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.SlotPlugInterfaceL1Impl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getSlotPlugInterfaceL1()
		 * @generated
		 */
		EClass SLOT_PLUG_INTERFACE_L1 = eINSTANCE.getSlotPlugInterfaceL1();

		/**
		 * The meta object literal for the '<em><b>Pointcuts</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PLUG_INTERFACE_L1__POINTCUTS = eINSTANCE.getSlotPlugInterfaceL1_Pointcuts();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.PointcutImpl <em>Pointcut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.PointcutImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getPointcut()
		 * @generated
		 */
		EClass POINTCUT = eINSTANCE.getPointcut();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINTCUT__TYPE = eINSTANCE.getPointcut_Type();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.ClassPointcutImpl <em>Class Pointcut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.ClassPointcutImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getClassPointcut()
		 * @generated
		 */
		EClass CLASS_POINTCUT = eINSTANCE.getClassPointcut();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.MethodPoincutImpl <em>Method Poincut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.MethodPoincutImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getMethodPoincut()
		 * @generated
		 */
		EClass METHOD_POINCUT = eINSTANCE.getMethodPoincut();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.ImportElementPointcutImpl <em>Import Element Pointcut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.ImportElementPointcutImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getImportElementPointcut()
		 * @generated
		 */
		EClass IMPORT_ELEMENT_POINTCUT = eINSTANCE.getImportElementPointcut();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.impl.StatementPoincutImpl <em>Statement Poincut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.impl.StatementPoincutImpl
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getStatementPoincut()
		 * @generated
		 */
		EClass STATEMENT_POINCUT = eINSTANCE.getStatementPoincut();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.CodeGenLanguage <em>Code Gen Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.CodeGenLanguage
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getCodeGenLanguage()
		 * @generated
		 */
		EEnum CODE_GEN_LANGUAGE = eINSTANCE.getCodeGenLanguage();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.codegen.PointcutType <em>Pointcut Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.codegen.PointcutType
		 * @see serviceInterfaces.codegen.impl.CodegenPackageImpl#getPointcutType()
		 * @generated
		 */
		EEnum POINTCUT_TYPE = eINSTANCE.getPointcutType();

	}

} //CodegenPackage
