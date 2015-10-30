/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.FeatureInterface#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getFeatureInterface()
 * @model abstract="true"
 * @generated
 */
public interface FeatureInterface extends MMInterface {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference list.
	 * @see dslPatterns.DslPatternsPackage#getFeatureInterface_Ref()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EAttribute> getRef();

} // FeatureInterface
