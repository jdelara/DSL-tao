/**
 */
package dslPatterns;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.SimpleFeature#getFeatureKind <em>Feature Kind</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getSimpleFeature()
 * @model
 * @generated
 */
public interface SimpleFeature extends Variant {
	/**
	 * Returns the value of the '<em><b>Feature Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link dslPatterns.FeatureKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Kind</em>' attribute.
	 * @see dslPatterns.FeatureKind
	 * @see #setFeatureKind(FeatureKind)
	 * @see dslPatterns.DslPatternsPackage#getSimpleFeature_FeatureKind()
	 * @model required="true"
	 * @generated
	 */
	FeatureKind getFeatureKind();

	/**
	 * Sets the value of the '{@link dslPatterns.SimpleFeature#getFeatureKind <em>Feature Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Kind</em>' attribute.
	 * @see dslPatterns.FeatureKind
	 * @see #getFeatureKind()
	 * @generated
	 */
	void setFeatureKind(FeatureKind value);

} // SimpleFeature
