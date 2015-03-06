/**
 */
package runtimeServices;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtimeServices.RuntimeServicesPackage
 * @generated
 */
public interface RuntimeServicesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeServicesFactory eINSTANCE = runtimeServices.impl.RuntimeServicesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Service Instances</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Instances</em>'.
	 * @generated
	 */
	ServiceInstances createServiceInstances();

	/**
	 * Returns a new object of class '<em>Service Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Instance</em>'.
	 * @generated
	 */
	ServiceInstance createServiceInstance();

	/**
	 * Returns a new object of class '<em>Disconnected Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disconnected Element</em>'.
	 * @generated
	 */
	DisconnectedElement createDisconnectedElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RuntimeServicesPackage getRuntimeServicesPackage();

} //RuntimeServicesFactory
