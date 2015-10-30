/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Interface Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ClassInterfaceAttached#getRefIntAtt <em>Ref Int Att</em>}</li>
 *   <li>{@link dslPatterns.ClassInterfaceAttached#getFeatIntAtt <em>Feat Int Att</em>}</li>
 *   <li>{@link dslPatterns.ClassInterfaceAttached#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getClassInterfaceAttached()
 * @model
 * @generated
 */
public interface ClassInterfaceAttached extends MMInterfaceAttached {
	/**
	 * Returns the value of the '<em><b>Ref Int Att</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.ReferenceInterfaceAttached}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Int Att</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Int Att</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getClassInterfaceAttached_RefIntAtt()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceInterfaceAttached> getRefIntAtt();

	/**
	 * Returns the value of the '<em><b>Feat Int Att</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.FeatureInterfaceAttached}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feat Int Att</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feat Int Att</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getClassInterfaceAttached_FeatIntAtt()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureInterfaceAttached> getFeatIntAtt();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see dslPatterns.DslPatternsPackage#getClassInterfaceAttached_Value()
	 * @model
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link dslPatterns.ClassInterfaceAttached#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // ClassInterfaceAttached
