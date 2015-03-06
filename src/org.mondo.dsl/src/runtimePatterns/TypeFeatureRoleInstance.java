/**
 */
package runtimePatterns;

import dslPatterns.FeatureType;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Feature Role Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.TypeFeatureRoleInstance#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.TypeFeatureRoleInstance#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getTypeFeatureRoleInstance()
 * @model
 * @generated
 */
public interface TypeFeatureRoleInstance extends FeatureRoleInstance {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(FeatureType)
	 * @see runtimePatterns.RuntimePatternsPackage#getTypeFeatureRoleInstance_Role()
	 * @model
	 * @generated
	 */
	FeatureType getRole();

	/**
	 * Sets the value of the '{@link runtimePatterns.TypeFeatureRoleInstance#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(FeatureType value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EAttribute)
	 * @see runtimePatterns.RuntimePatternsPackage#getTypeFeatureRoleInstance_Element()
	 * @model
	 * @generated
	 */
	EAttribute getElement();

	/**
	 * Sets the value of the '{@link runtimePatterns.TypeFeatureRoleInstance#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EAttribute value);

} // TypeFeatureRoleInstance
