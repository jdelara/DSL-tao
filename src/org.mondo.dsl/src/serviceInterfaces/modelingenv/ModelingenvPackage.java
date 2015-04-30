/**
 */
package serviceInterfaces.modelingenv;

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
 * @see serviceInterfaces.modelingenv.ModelingenvFactory
 * @model kind="package"
 * @generated
 */
public interface ModelingenvPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelingenv";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/serviceInterfaces/modelingenv";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "servInt_modelingenv";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelingenvPackage eINSTANCE = serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl.init();

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl <em>Injector Acceptor Interface L0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getInjectorAcceptorInterfaceL0()
	 * @generated
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0 = 0;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0__QNAME = ServiceInterfacesPackage.INTERFACE__QNAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0__DESCRIPTION = ServiceInterfacesPackage.INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Injector Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0__MODE = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Injector Acceptor Interface L0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_ACCEPTOR_INTERFACE_L0_FEATURE_COUNT = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.JavaTypeDeclarationImpl <em>Java Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.JavaTypeDeclarationImpl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaTypeDeclaration()
	 * @generated
	 */
	int JAVA_TYPE_DECLARATION = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TYPE_DECLARATION__QUALIFIED_NAME = 0;

	/**
	 * The number of structural features of the '<em>Java Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TYPE_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.JavaInterfaceImpl <em>Java Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.JavaInterfaceImpl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaInterface()
	 * @generated
	 */
	int JAVA_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INTERFACE__QUALIFIED_NAME = JAVA_TYPE_DECLARATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INTERFACE__OPERATIONS = JAVA_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INTERFACE_FEATURE_COUNT = JAVA_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.JavaClassImpl <em>Java Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.JavaClassImpl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaClass()
	 * @generated
	 */
	int JAVA_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__QUALIFIED_NAME = JAVA_TYPE_DECLARATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS__OPERATIONS = JAVA_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_FEATURE_COUNT = JAVA_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.OperationImpl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.SlotPlugInterfaceL0Impl <em>Slot Plug Interface L0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.SlotPlugInterfaceL0Impl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getSlotPlugInterfaceL0()
	 * @generated
	 */
	int SLOT_PLUG_INTERFACE_L0 = 5;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L0__QNAME = ServiceInterfacesPackage.INTERFACE__QNAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L0__DESCRIPTION = ServiceInterfacesPackage.INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L0__SLOT = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Slot Plug Interface L0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PLUG_INTERFACE_L0_FEATURE_COUNT = ServiceInterfacesPackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.impl.ExtensionPointImpl
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getExtensionPoint()
	 * @generated
	 */
	int EXTENSION_POINT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT__ID = 0;

	/**
	 * The number of structural features of the '<em>Extension Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.modelingenv.InjectionMode <em>Injection Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.modelingenv.InjectionMode
	 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getInjectionMode()
	 * @generated
	 */
	int INJECTION_MODE = 7;


	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0 <em>Injector Acceptor Interface L0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injector Acceptor Interface L0</em>'.
	 * @see serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0
	 * @generated
	 */
	EClass getInjectorAcceptorInterfaceL0();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getInjectorImplements <em>Injector Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Injector Implements</em>'.
	 * @see serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getInjectorImplements()
	 * @see #getInjectorAcceptorInterfaceL0()
	 * @generated
	 */
	EReference getInjectorAcceptorInterfaceL0_InjectorImplements();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getMode()
	 * @see #getInjectorAcceptorInterfaceL0()
	 * @generated
	 */
	EAttribute getInjectorAcceptorInterfaceL0_Mode();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.JavaTypeDeclaration <em>Java Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Type Declaration</em>'.
	 * @see serviceInterfaces.modelingenv.JavaTypeDeclaration
	 * @generated
	 */
	EClass getJavaTypeDeclaration();

	/**
	 * Returns the meta object for the attribute list '{@link serviceInterfaces.modelingenv.JavaTypeDeclaration#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualified Name</em>'.
	 * @see serviceInterfaces.modelingenv.JavaTypeDeclaration#getQualifiedName()
	 * @see #getJavaTypeDeclaration()
	 * @generated
	 */
	EAttribute getJavaTypeDeclaration_QualifiedName();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.JavaInterface <em>Java Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Interface</em>'.
	 * @see serviceInterfaces.modelingenv.JavaInterface
	 * @generated
	 */
	EClass getJavaInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.modelingenv.JavaInterface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see serviceInterfaces.modelingenv.JavaInterface#getOperations()
	 * @see #getJavaInterface()
	 * @generated
	 */
	EReference getJavaInterface_Operations();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.JavaClass <em>Java Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Class</em>'.
	 * @see serviceInterfaces.modelingenv.JavaClass
	 * @generated
	 */
	EClass getJavaClass();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.modelingenv.JavaClass#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see serviceInterfaces.modelingenv.JavaClass#getOperations()
	 * @see #getJavaClass()
	 * @generated
	 */
	EReference getJavaClass_Operations();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see serviceInterfaces.modelingenv.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.modelingenv.Operation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see serviceInterfaces.modelingenv.Operation#getName()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Name();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.SlotPlugInterfaceL0 <em>Slot Plug Interface L0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Plug Interface L0</em>'.
	 * @see serviceInterfaces.modelingenv.SlotPlugInterfaceL0
	 * @generated
	 */
	EClass getSlotPlugInterfaceL0();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.modelingenv.SlotPlugInterfaceL0#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slot</em>'.
	 * @see serviceInterfaces.modelingenv.SlotPlugInterfaceL0#getSlot()
	 * @see #getSlotPlugInterfaceL0()
	 * @generated
	 */
	EReference getSlotPlugInterfaceL0_Slot();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.modelingenv.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Point</em>'.
	 * @see serviceInterfaces.modelingenv.ExtensionPoint
	 * @generated
	 */
	EClass getExtensionPoint();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.modelingenv.ExtensionPoint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see serviceInterfaces.modelingenv.ExtensionPoint#getId()
	 * @see #getExtensionPoint()
	 * @generated
	 */
	EAttribute getExtensionPoint_Id();

	/**
	 * Returns the meta object for enum '{@link serviceInterfaces.modelingenv.InjectionMode <em>Injection Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Injection Mode</em>'.
	 * @see serviceInterfaces.modelingenv.InjectionMode
	 * @generated
	 */
	EEnum getInjectionMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelingenvFactory getModelingenvFactory();

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
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl <em>Injector Acceptor Interface L0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getInjectorAcceptorInterfaceL0()
		 * @generated
		 */
		EClass INJECTOR_ACCEPTOR_INTERFACE_L0 = eINSTANCE.getInjectorAcceptorInterfaceL0();

		/**
		 * The meta object literal for the '<em><b>Injector Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS = eINSTANCE.getInjectorAcceptorInterfaceL0_InjectorImplements();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INJECTOR_ACCEPTOR_INTERFACE_L0__MODE = eINSTANCE.getInjectorAcceptorInterfaceL0_Mode();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.JavaTypeDeclarationImpl <em>Java Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.JavaTypeDeclarationImpl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaTypeDeclaration()
		 * @generated
		 */
		EClass JAVA_TYPE_DECLARATION = eINSTANCE.getJavaTypeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_TYPE_DECLARATION__QUALIFIED_NAME = eINSTANCE.getJavaTypeDeclaration_QualifiedName();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.JavaInterfaceImpl <em>Java Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.JavaInterfaceImpl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaInterface()
		 * @generated
		 */
		EClass JAVA_INTERFACE = eINSTANCE.getJavaInterface();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_INTERFACE__OPERATIONS = eINSTANCE.getJavaInterface_Operations();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.JavaClassImpl <em>Java Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.JavaClassImpl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getJavaClass()
		 * @generated
		 */
		EClass JAVA_CLASS = eINSTANCE.getJavaClass();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_CLASS__OPERATIONS = eINSTANCE.getJavaClass_Operations();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.OperationImpl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.SlotPlugInterfaceL0Impl <em>Slot Plug Interface L0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.SlotPlugInterfaceL0Impl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getSlotPlugInterfaceL0()
		 * @generated
		 */
		EClass SLOT_PLUG_INTERFACE_L0 = eINSTANCE.getSlotPlugInterfaceL0();

		/**
		 * The meta object literal for the '<em><b>Slot</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PLUG_INTERFACE_L0__SLOT = eINSTANCE.getSlotPlugInterfaceL0_Slot();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.impl.ExtensionPointImpl
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getExtensionPoint()
		 * @generated
		 */
		EClass EXTENSION_POINT = eINSTANCE.getExtensionPoint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_POINT__ID = eINSTANCE.getExtensionPoint_Id();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.modelingenv.InjectionMode <em>Injection Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.modelingenv.InjectionMode
		 * @see serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl#getInjectionMode()
		 * @generated
		 */
		EEnum INJECTION_MODE = eINSTANCE.getInjectionMode();

	}

} //ModelingenvPackage
