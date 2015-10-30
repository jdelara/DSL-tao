/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.MetaModel#getMmreference <em>Mmreference</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getMetaModel()
 * @model
 * @generated
 */
public interface MetaModel extends PatternMetaModel {
	/**
	 * Returns the value of the '<em><b>Mmreference</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mmreference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mmreference</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getMetaModel_Mmreference()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EPackage> getMmreference();

} // MetaModel
