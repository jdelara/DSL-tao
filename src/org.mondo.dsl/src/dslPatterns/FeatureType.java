/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.FeatureType#isIDMatters <em>ID Matters</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getFeatureType()
 * @model
 * @generated
 */
public interface FeatureType extends FeatureInterface, CardinalityInterface {

	/**
	 * Returns the value of the '<em><b>ID Matters</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID Matters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID Matters</em>' attribute.
	 * @see #setIDMatters(boolean)
	 * @see dslPatterns.DslPatternsPackage#getFeatureType_IDMatters()
	 * @model default="true"
	 * @generated
	 */
	boolean isIDMatters();

	/**
	 * Sets the value of the '{@link dslPatterns.FeatureType#isIDMatters <em>ID Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID Matters</em>' attribute.
	 * @see #isIDMatters()
	 * @generated
	 */
	void setIDMatters(boolean value);
} // FeatureType
