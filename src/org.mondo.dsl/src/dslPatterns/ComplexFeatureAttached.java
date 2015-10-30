/**
 */
package dslPatterns;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Feature Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ComplexFeatureAttached#getMetaModelAttached <em>Meta Model Attached</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getComplexFeatureAttached()
 * @model
 * @generated
 */
public interface ComplexFeatureAttached extends ComplexFeature {
	/**
	 * Returns the value of the '<em><b>Meta Model Attached</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Attached</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Attached</em>' containment reference.
	 * @see #setMetaModelAttached(PatternMetaModelAttached)
	 * @see dslPatterns.DslPatternsPackage#getComplexFeatureAttached_MetaModelAttached()
	 * @model containment="true"
	 * @generated
	 */
	PatternMetaModelAttached getMetaModelAttached();

	/**
	 * Sets the value of the '{@link dslPatterns.ComplexFeatureAttached#getMetaModelAttached <em>Meta Model Attached</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Attached</em>' containment reference.
	 * @see #getMetaModelAttached()
	 * @generated
	 */
	void setMetaModelAttached(PatternMetaModelAttached value);

} // ComplexFeatureAttached
