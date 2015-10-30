/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Meta Model Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.PatternMetaModelAttached#getClassIntAtt <em>Class Int Att</em>}</li>
 *   <li>{@link dslPatterns.PatternMetaModelAttached#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getPatternMetaModelAttached()
 * @model
 * @generated
 */
public interface PatternMetaModelAttached extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Int Att</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.ClassInterfaceAttached}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Int Att</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Int Att</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModelAttached_ClassIntAtt()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassInterfaceAttached> getClassIntAtt();

	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(Pattern)
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModelAttached_Content()
	 * @model required="true"
	 * @generated
	 */
	Pattern getContent();

	/**
	 * Sets the value of the '{@link dslPatterns.PatternMetaModelAttached#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(Pattern value);

} // PatternMetaModelAttached
