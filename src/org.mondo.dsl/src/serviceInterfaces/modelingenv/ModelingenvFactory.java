/**
 */
package serviceInterfaces.modelingenv;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.modelingenv.ModelingenvPackage
 * @generated
 */
public interface ModelingenvFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelingenvFactory eINSTANCE = serviceInterfaces.modelingenv.impl.ModelingenvFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Injector Acceptor Interface L0</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injector Acceptor Interface L0</em>'.
	 * @generated
	 */
	InjectorAcceptorInterfaceL0 createInjectorAcceptorInterfaceL0();

	/**
	 * Returns a new object of class '<em>Java Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Interface</em>'.
	 * @generated
	 */
	JavaInterface createJavaInterface();

	/**
	 * Returns a new object of class '<em>Java Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Class</em>'.
	 * @generated
	 */
	JavaClass createJavaClass();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Slot Plug Interface L0</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot Plug Interface L0</em>'.
	 * @generated
	 */
	SlotPlugInterfaceL0 createSlotPlugInterfaceL0();

	/**
	 * Returns a new object of class '<em>Extension Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Point</em>'.
	 * @generated
	 */
	ExtensionPoint createExtensionPoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelingenvPackage getModelingenvPackage();

} //ModelingenvFactory
