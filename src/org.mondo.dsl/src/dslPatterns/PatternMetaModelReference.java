/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Meta Model Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.PatternMetaModelReference#getMmreference <em>Mmreference</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getPatternMetaModelReference()
 * @model
 * @generated
 */
public interface PatternMetaModelReference extends PatternMetaModel {
	/**
	 * Returns the value of the '<em><b>Mmreference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mmreference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mmreference</em>' reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModelReference_Mmreference()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EPackage> getMmreference();

} // PatternMetaModelReference
