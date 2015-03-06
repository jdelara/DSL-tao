/**
 */
package runtimeServices.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtimeServices.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeServicesFactoryImpl extends EFactoryImpl implements RuntimeServicesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeServicesFactory init() {
		try {
			RuntimeServicesFactory theRuntimeServicesFactory = (RuntimeServicesFactory)EPackage.Registry.INSTANCE.getEFactory("http://mondo.org/runtimeServices"); 
			if (theRuntimeServicesFactory != null) {
				return theRuntimeServicesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeServicesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeServicesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RuntimeServicesPackage.SERVICE_INSTANCES: return createServiceInstances();
			case RuntimeServicesPackage.SERVICE_INSTANCE: return createServiceInstance();
			case RuntimeServicesPackage.DISCONNECTED_ELEMENT: return createDisconnectedElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInstances createServiceInstances() {
		ServiceInstancesImpl serviceInstances = new ServiceInstancesImpl();
		return serviceInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInstance createServiceInstance() {
		ServiceInstanceImpl serviceInstance = new ServiceInstanceImpl();
		return serviceInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisconnectedElement createDisconnectedElement() {
		DisconnectedElementImpl disconnectedElement = new DisconnectedElementImpl();
		return disconnectedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeServicesPackage getRuntimeServicesPackage() {
		return (RuntimeServicesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimeServicesPackage getPackage() {
		return RuntimeServicesPackage.eINSTANCE;
	}

} //RuntimeServicesFactoryImpl
