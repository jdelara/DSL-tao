/**
 */
package runtimePatterns;

import dslPatterns.ClassInterface;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Role Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.ClassRoleInstance#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.ClassRoleInstance#getElement <em>Element</em>}</li>
 *   <li>{@link runtimePatterns.ClassRoleInstance#getFeatureInstances <em>Feature Instances</em>}</li>
 *   <li>{@link runtimePatterns.ClassRoleInstance#getReferenceInstances <em>Reference Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getClassRoleInstance()
 * @model
 * @generated
 */
public interface ClassRoleInstance extends RoleInstance {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(ClassInterface)
	 * @see runtimePatterns.RuntimePatternsPackage#getClassRoleInstance_Role()
	 * @model
	 * @generated
	 */
	ClassInterface getRole();

	/**
	 * Sets the value of the '{@link runtimePatterns.ClassRoleInstance#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(ClassInterface value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EClass)
	 * @see runtimePatterns.RuntimePatternsPackage#getClassRoleInstance_Element()
	 * @model
	 * @generated
	 */
	EClass getElement();

	/**
	 * Sets the value of the '{@link runtimePatterns.ClassRoleInstance#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EClass value);

	/**
	 * Returns the value of the '<em><b>Feature Instances</b></em>' containment reference list.
	 * The list contents are of type {@link runtimePatterns.FeatureRoleInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Instances</em>' containment reference list.
	 * @see runtimePatterns.RuntimePatternsPackage#getClassRoleInstance_FeatureInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureRoleInstance> getFeatureInstances();

	/**
	 * Returns the value of the '<em><b>Reference Instances</b></em>' containment reference list.
	 * The list contents are of type {@link runtimePatterns.ReferenceRoleInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Instances</em>' containment reference list.
	 * @see runtimePatterns.RuntimePatternsPackage#getClassRoleInstance_ReferenceInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceRoleInstance> getReferenceInstances();

} // ClassRoleInstance
