/**
 */
package runtimePatterns;

import dslPatterns.ReferenceInterface;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Role Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.ReferenceRoleInstance#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.ReferenceRoleInstance#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getReferenceRoleInstance()
 * @model
 * @generated
 */
public interface ReferenceRoleInstance extends RoleInstance {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(ReferenceInterface)
	 * @see runtimePatterns.RuntimePatternsPackage#getReferenceRoleInstance_Role()
	 * @model
	 * @generated
	 */
	ReferenceInterface getRole();

	/**
	 * Sets the value of the '{@link runtimePatterns.ReferenceRoleInstance#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(ReferenceInterface value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EReference)
	 * @see runtimePatterns.RuntimePatternsPackage#getReferenceRoleInstance_Element()
	 * @model
	 * @generated
	 */
	EReference getElement();

	/**
	 * Sets the value of the '{@link runtimePatterns.ReferenceRoleInstance#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EReference value);

} // ReferenceRoleInstance
