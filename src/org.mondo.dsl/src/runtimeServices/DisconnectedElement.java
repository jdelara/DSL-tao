/**
 */
package runtimeServices;

import dslPatterns.Pattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disconnected Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeServices.DisconnectedElement#getInterface <em>Interface</em>}</li>
 *   <li>{@link runtimeServices.DisconnectedElement#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeServices.RuntimeServicesPackage#getDisconnectedElement()
 * @model
 * @generated
 */
public interface DisconnectedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' reference.
	 * @see #setInterface(Interface)
	 * @see runtimeServices.RuntimeServicesPackage#getDisconnectedElement_Interface()
	 * @model
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link runtimeServices.DisconnectedElement#getInterface <em>Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' reference list.
	 * The list contents are of type {@link dslPatterns.Pattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patterns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' reference list.
	 * @see runtimeServices.RuntimeServicesPackage#getDisconnectedElement_Patterns()
	 * @model
	 * @generated
	 */
	EList<Pattern> getPatterns();

} // DisconnectedElement
