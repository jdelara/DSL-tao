/**
 */
package dslPatterns;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Instance Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dslPatterns.FeatureInstanceAttached#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see dslPatterns.DslPatternsPackage#getFeatureInstanceAttached()
 * @model
 * @generated
 */
public interface FeatureInstanceAttached extends FeatureInterfaceAttached {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(FeatureInstance)
	 * @see dslPatterns.DslPatternsPackage#getFeatureInstanceAttached_Content()
	 * @model required="true"
	 * @generated
	 */
	FeatureInstance getContent();

	/**
	 * Sets the value of the '{@link dslPatterns.FeatureInstanceAttached#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(FeatureInstance value);

} // FeatureInstanceAttached
