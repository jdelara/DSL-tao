/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ComplexFeature#getAndChildren <em>And Children</em>}</li>
 *   <li>{@link dslPatterns.ComplexFeature#getOrChildren <em>Or Children</em>}</li>
 *   <li>{@link dslPatterns.ComplexFeature#getXorChildren <em>Xor Children</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getComplexFeature()
 * @model abstract="true"
 * @generated
 */
public interface ComplexFeature extends Variant {
	/**
	 * Returns the value of the '<em><b>And Children</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>And Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>And Children</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getComplexFeature_AndChildren()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variant> getAndChildren();

	/**
	 * Returns the value of the '<em><b>Or Children</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Or Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Or Children</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getComplexFeature_OrChildren()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variant> getOrChildren();

	/**
	 * Returns the value of the '<em><b>Xor Children</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xor Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xor Children</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getComplexFeature_XorChildren()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variant> getXorChildren();

} // ComplexFeature
