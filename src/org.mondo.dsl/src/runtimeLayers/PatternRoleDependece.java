/**
 */
package runtimeLayers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import runtimePatterns.PatternInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Role Dependece</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeLayers.PatternRoleDependece#getUse <em>Use</em>}</li>
 *   <li>{@link runtimeLayers.PatternRoleDependece#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeLayers.RuntimeLayersPackage#getPatternRoleDependece()
 * @model
 * @generated
 */
public interface PatternRoleDependece extends EObject {
	/**
	 * Returns the value of the '<em><b>Use</b></em>' reference list.
	 * The list contents are of type {@link runtimeLayers.Layer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use</em>' reference list.
	 * @see runtimeLayers.RuntimeLayersPackage#getPatternRoleDependece_Use()
	 * @model
	 * @generated
	 */
	EList<Layer> getUse();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' reference.
	 * @see #setPattern(PatternInstance)
	 * @see runtimeLayers.RuntimeLayersPackage#getPatternRoleDependece_Pattern()
	 * @model required="true"
	 * @generated
	 */
	PatternInstance getPattern();

	/**
	 * Sets the value of the '{@link runtimeLayers.PatternRoleDependece#getPattern <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(PatternInstance value);

} // PatternRoleDependece
