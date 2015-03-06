/**
 */
package runtimePatterns;

import dslPatterns.FeatureInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Feature Role Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.InstanceFeatureRoleInstance#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.InstanceFeatureRoleInstance#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getInstanceFeatureRoleInstance()
 * @model
 * @generated
 */
public interface InstanceFeatureRoleInstance extends FeatureRoleInstance {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(FeatureInterface)
	 * @see runtimePatterns.RuntimePatternsPackage#getInstanceFeatureRoleInstance_Role()
	 * @model
	 * @generated
	 */
	FeatureInterface getRole();

	/**
	 * Sets the value of the '{@link runtimePatterns.InstanceFeatureRoleInstance#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(FeatureInterface value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see runtimePatterns.RuntimePatternsPackage#getInstanceFeatureRoleInstance_Value()
	 * @model default=""
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link runtimePatterns.InstanceFeatureRoleInstance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // InstanceFeatureRoleInstance
