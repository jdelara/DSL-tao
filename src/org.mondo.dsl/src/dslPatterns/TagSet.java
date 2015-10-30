/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.TagSet#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getTagSet()
 * @model
 * @generated
 */
public interface TagSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getTagSet_Tags()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tag> getTags();

} // TagSet
