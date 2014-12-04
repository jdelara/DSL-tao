/**
 */
package serviceInterfaces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.ServiceInterfacesPackage
 * @generated
 */
public interface ServiceInterfacesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServiceInterfacesFactory eINSTANCE = serviceInterfaces.impl.ServiceInterfacesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Interface Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Repository</em>'.
	 * @generated
	 */
	InterfaceRepository createInterfaceRepository();

	/**
	 * Returns a new object of class '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
	Package createPackage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServiceInterfacesPackage getServiceInterfacesPackage();

} //ServiceInterfacesFactory
