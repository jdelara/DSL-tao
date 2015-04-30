/**
 */
package serviceInterfaces;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see serviceInterfaces.ServiceInterfacesFactory
 * @model kind="package"
 * @generated
 */
public interface ServiceInterfacesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "serviceInterfaces";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/serviceInterfaces";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "servInt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServiceInterfacesPackage eINSTANCE = serviceInterfaces.impl.ServiceInterfacesPackageImpl.init();

	/**
	 * The meta object id for the '{@link serviceInterfaces.impl.InterfaceRepositoryImpl <em>Interface Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.impl.InterfaceRepositoryImpl
	 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getInterfaceRepository()
	 * @generated
	 */
	int INTERFACE_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REPOSITORY__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>Interface Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link serviceInterfaces.impl.PackageableImpl <em>Packageable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.impl.PackageableImpl
	 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getPackageable()
	 * @generated
	 */
	int PACKAGEABLE = 1;

	/**
	 * The number of structural features of the '<em>Packageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link serviceInterfaces.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.impl.PackageImpl
	 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = PACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CONTENTS = PACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = PACKAGEABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link serviceInterfaces.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see serviceInterfaces.impl.InterfaceImpl
	 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__QNAME = PACKAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DESCRIPTION = PACKAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = PACKAGEABLE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.InterfaceRepository <em>Interface Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Repository</em>'.
	 * @see serviceInterfaces.InterfaceRepository
	 * @generated
	 */
	EClass getInterfaceRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.InterfaceRepository#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see serviceInterfaces.InterfaceRepository#getContents()
	 * @see #getInterfaceRepository()
	 * @generated
	 */
	EReference getInterfaceRepository_Contents();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.Packageable <em>Packageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packageable</em>'.
	 * @see serviceInterfaces.Packageable
	 * @generated
	 */
	EClass getPackageable();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see serviceInterfaces.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.Package#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see serviceInterfaces.Package#getName()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link serviceInterfaces.Package#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see serviceInterfaces.Package#getContents()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Contents();

	/**
	 * Returns the meta object for class '{@link serviceInterfaces.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see serviceInterfaces.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.Interface#getQName <em>QName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QName</em>'.
	 * @see serviceInterfaces.Interface#getQName()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_QName();

	/**
	 * Returns the meta object for the attribute '{@link serviceInterfaces.Interface#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see serviceInterfaces.Interface#getDescription()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServiceInterfacesFactory getServiceInterfacesFactory();

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
		 * The meta object literal for the '{@link serviceInterfaces.impl.InterfaceRepositoryImpl <em>Interface Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.impl.InterfaceRepositoryImpl
		 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getInterfaceRepository()
		 * @generated
		 */
		EClass INTERFACE_REPOSITORY = eINSTANCE.getInterfaceRepository();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_REPOSITORY__CONTENTS = eINSTANCE.getInterfaceRepository_Contents();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.impl.PackageableImpl <em>Packageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.impl.PackageableImpl
		 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getPackageable()
		 * @generated
		 */
		EClass PACKAGEABLE = eINSTANCE.getPackageable();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.impl.PackageImpl
		 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NAME = eINSTANCE.getPackage_Name();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__CONTENTS = eINSTANCE.getPackage_Contents();

		/**
		 * The meta object literal for the '{@link serviceInterfaces.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see serviceInterfaces.impl.InterfaceImpl
		 * @see serviceInterfaces.impl.ServiceInterfacesPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>QName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__QNAME = eINSTANCE.getInterface_QName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__DESCRIPTION = eINSTANCE.getInterface_Description();

	}

} //ServiceInterfacesPackage
