/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.PatternSet#getCategories <em>Categories</em>}</li>
 *   <li>{@link dslPatterns.PatternSet#getTagSet <em>Tag Set</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getPatternSet()
 * @model
 * @generated
 */
public interface PatternSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * root class
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternSet_Categories()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Tag Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Set</em>' containment reference.
	 * @see #setTagSet(TagSet)
	 * @see dslPatterns.DslPatternsPackage#getPatternSet_TagSet()
	 * @model containment="true"
	 * @generated
	 */
	TagSet getTagSet();

	/**
	 * Sets the value of the '{@link dslPatterns.PatternSet#getTagSet <em>Tag Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Set</em>' containment reference.
	 * @see #getTagSet()
	 * @generated
	 */
	void setTagSet(TagSet value);

} // PatternSet
