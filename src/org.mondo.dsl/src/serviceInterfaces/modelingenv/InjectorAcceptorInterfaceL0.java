/**
 */
package serviceInterfaces.modelingenv;

import org.eclipse.emf.common.util.EList;

import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injector Acceptor Interface L0</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getInjectorImplements <em>Injector Implements</em>}</li>
 *   <li>{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getInjectorAcceptorInterfaceL0()
 * @model
 * @generated
 */
public interface InjectorAcceptorInterfaceL0 extends Interface {
	/**
	 * Returns the value of the '<em><b>Injector Implements</b></em>' containment reference list.
	 * The list contents are of type {@link serviceInterfaces.modelingenv.JavaTypeDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injector Implements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injector Implements</em>' containment reference list.
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getInjectorAcceptorInterfaceL0_InjectorImplements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<JavaTypeDeclaration> getInjectorImplements();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link serviceInterfaces.modelingenv.InjectionMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see serviceInterfaces.modelingenv.InjectionMode
	 * @see #setMode(InjectionMode)
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getInjectorAcceptorInterfaceL0_Mode()
	 * @model
	 * @generated
	 */
	InjectionMode getMode();

	/**
	 * Sets the value of the '{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see serviceInterfaces.modelingenv.InjectionMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(InjectionMode value);

} // InjectorAcceptorInterfaceL0
