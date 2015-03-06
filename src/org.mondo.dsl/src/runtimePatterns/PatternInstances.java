/**
 */
package runtimePatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Instances</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimePatterns.PatternInstances#getAppliedPatterns <em>Applied Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstances()
 * @model
 * @generated
 */
public interface PatternInstances extends EObject {
	/**
	 * Returns the value of the '<em><b>Applied Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link runtimePatterns.PatternInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Patterns</em>' containment reference list.
	 * @see runtimePatterns.RuntimePatternsPackage#getPatternInstances_AppliedPatterns()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PatternInstance> getAppliedPatterns();

} // PatternInstances
