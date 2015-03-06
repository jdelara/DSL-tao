/**
 */
package runtimeServices;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see runtimeServices.RuntimeServicesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface RuntimeServicesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtimeServices";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/runtimeServices";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rtServ";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeServicesPackage eINSTANCE = runtimeServices.impl.RuntimeServicesPackageImpl.init();

	/**
	 * The meta object id for the '{@link runtimeServices.impl.ServiceInstancesImpl <em>Service Instances</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeServices.impl.ServiceInstancesImpl
	 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getServiceInstances()
	 * @generated
	 */
	int SERVICE_INSTANCES = 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCES__SERVICES = 0;

	/**
	 * The number of structural features of the '<em>Service Instances</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link runtimeServices.impl.ServiceInstanceImpl <em>Service Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeServices.impl.ServiceInstanceImpl
	 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getServiceInstance()
	 * @generated
	 */
	int SERVICE_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCE__SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCE__ACTIVATED = 1;

	/**
	 * The feature id for the '<em><b>Disconnected Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCE__DISCONNECTED_ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Service Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link runtimeServices.impl.DisconnectedElementImpl <em>Disconnected Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeServices.impl.DisconnectedElementImpl
	 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getDisconnectedElement()
	 * @generated
	 */
	int DISCONNECTED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTED_ELEMENT__INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTED_ELEMENT__PATTERNS = 1;

	/**
	 * The number of structural features of the '<em>Disconnected Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCONNECTED_ELEMENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link runtimeServices.ServiceInstances <em>Service Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Instances</em>'.
	 * @see runtimeServices.ServiceInstances
	 * @generated
	 */
	EClass getServiceInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimeServices.ServiceInstances#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see runtimeServices.ServiceInstances#getServices()
	 * @see #getServiceInstances()
	 * @generated
	 */
	EReference getServiceInstances_Services();

	/**
	 * Returns the meta object for class '{@link runtimeServices.ServiceInstance <em>Service Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Instance</em>'.
	 * @see runtimeServices.ServiceInstance
	 * @generated
	 */
	EClass getServiceInstance();

	/**
	 * Returns the meta object for the reference '{@link runtimeServices.ServiceInstance#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see runtimeServices.ServiceInstance#getService()
	 * @see #getServiceInstance()
	 * @generated
	 */
	EReference getServiceInstance_Service();

	/**
	 * Returns the meta object for the attribute '{@link runtimeServices.ServiceInstance#isActivated <em>Activated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activated</em>'.
	 * @see runtimeServices.ServiceInstance#isActivated()
	 * @see #getServiceInstance()
	 * @generated
	 */
	EAttribute getServiceInstance_Activated();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimeServices.ServiceInstance#getDisconnectedElements <em>Disconnected Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Disconnected Elements</em>'.
	 * @see runtimeServices.ServiceInstance#getDisconnectedElements()
	 * @see #getServiceInstance()
	 * @generated
	 */
	EReference getServiceInstance_DisconnectedElements();

	/**
	 * Returns the meta object for class '{@link runtimeServices.DisconnectedElement <em>Disconnected Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disconnected Element</em>'.
	 * @see runtimeServices.DisconnectedElement
	 * @generated
	 */
	EClass getDisconnectedElement();

	/**
	 * Returns the meta object for the reference '{@link runtimeServices.DisconnectedElement#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface</em>'.
	 * @see runtimeServices.DisconnectedElement#getInterface()
	 * @see #getDisconnectedElement()
	 * @generated
	 */
	EReference getDisconnectedElement_Interface();

	/**
	 * Returns the meta object for the reference list '{@link runtimeServices.DisconnectedElement#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Patterns</em>'.
	 * @see runtimeServices.DisconnectedElement#getPatterns()
	 * @see #getDisconnectedElement()
	 * @generated
	 */
	EReference getDisconnectedElement_Patterns();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeServicesFactory getRuntimeServicesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link runtimeServices.impl.ServiceInstancesImpl <em>Service Instances</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeServices.impl.ServiceInstancesImpl
		 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getServiceInstances()
		 * @generated
		 */
		EClass SERVICE_INSTANCES = eINSTANCE.getServiceInstances();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INSTANCES__SERVICES = eINSTANCE.getServiceInstances_Services();

		/**
		 * The meta object literal for the '{@link runtimeServices.impl.ServiceInstanceImpl <em>Service Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeServices.impl.ServiceInstanceImpl
		 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getServiceInstance()
		 * @generated
		 */
		EClass SERVICE_INSTANCE = eINSTANCE.getServiceInstance();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INSTANCE__SERVICE = eINSTANCE.getServiceInstance_Service();

		/**
		 * The meta object literal for the '<em><b>Activated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_INSTANCE__ACTIVATED = eINSTANCE.getServiceInstance_Activated();

		/**
		 * The meta object literal for the '<em><b>Disconnected Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INSTANCE__DISCONNECTED_ELEMENTS = eINSTANCE.getServiceInstance_DisconnectedElements();

		/**
		 * The meta object literal for the '{@link runtimeServices.impl.DisconnectedElementImpl <em>Disconnected Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeServices.impl.DisconnectedElementImpl
		 * @see runtimeServices.impl.RuntimeServicesPackageImpl#getDisconnectedElement()
		 * @generated
		 */
		EClass DISCONNECTED_ELEMENT = eINSTANCE.getDisconnectedElement();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISCONNECTED_ELEMENT__INTERFACE = eINSTANCE.getDisconnectedElement_Interface();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISCONNECTED_ELEMENT__PATTERNS = eINSTANCE.getDisconnectedElement_Patterns();

	}

} //RuntimeServicesPackage
