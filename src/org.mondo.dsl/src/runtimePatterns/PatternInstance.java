/**
 */
package runtimePatterns;

import dslPatterns.Pattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import runtimeServices.ServiceInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.PatternInstance#getIdent <em>Ident</em>}</li>
 *   <li>{@link runtimePatterns.PatternInstance#getPattern <em>Pattern</em>}</li>
 *   <li>{@link runtimePatterns.PatternInstance#getClassInstances <em>Class Instances</em>}</li>
 *   <li>{@link runtimePatterns.PatternInstance#getServiceInstances <em>Service Instances</em>}</li>
 *   <li>{@link runtimePatterns.PatternInstance#isAttached <em>Attached</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance()
 * @model
 * @generated
 */
public interface PatternInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' attribute.
	 * @see #setIdent(String)
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance_Ident()
	 * @model required="true"
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link runtimePatterns.PatternInstance#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' reference.
	 * @see #setPattern(Pattern)
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance_Pattern()
	 * @model
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link runtimePatterns.PatternInstance#getPattern <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Class Instances</b></em>' containment reference list.
	 * The list contents are of type {@link runtimePatterns.ClassRoleInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Instances</em>' containment reference list.
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance_ClassInstances()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassRoleInstance> getClassInstances();

	/**
	 * Returns the value of the '<em><b>Service Instances</b></em>' containment reference list.
	 * The list contents are of type {@link runtimeServices.ServiceInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Instances</em>' containment reference list.
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance_ServiceInstances()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ServiceInstance> getServiceInstances();

	/**
	 * Returns the value of the '<em><b>Attached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached</em>' attribute.
	 * @see #setAttached(boolean)
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstance_Attached()
	 * @model
	 * @generated
	 */
	boolean isAttached();

	/**
	 * Sets the value of the '{@link runtimePatterns.PatternInstance#isAttached <em>Attached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attached</em>' attribute.
	 * @see #isAttached()
	 * @generated
	 */
	void setAttached(boolean value);

} // PatternInstance
