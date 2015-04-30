/**
 */
package dslPatterns;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Type Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dslPatterns.FeatureTypeAttached#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see dslPatterns.DslPatternsPackage#getFeatureTypeAttached()
 * @model
 * @generated
 */
public interface FeatureTypeAttached extends FeatureInterfaceAttached {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(FeatureType)
	 * @see dslPatterns.DslPatternsPackage#getFeatureTypeAttached_Content()
	 * @model required="true"
	 * @generated
	 */
	FeatureType getContent();

	/**
	 * Sets the value of the '{@link dslPatterns.FeatureTypeAttached#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(FeatureType value);

} // FeatureTypeAttached
