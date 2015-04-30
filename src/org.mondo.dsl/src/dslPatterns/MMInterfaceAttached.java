/**
 */
package dslPatterns;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MM Interface Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dslPatterns.MMInterfaceAttached#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see dslPatterns.DslPatternsPackage#getMMInterfaceAttached()
 * @model
 * @generated
 */
public interface MMInterfaceAttached extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(MMInterface)
	 * @see dslPatterns.DslPatternsPackage#getMMInterfaceAttached_Type()
	 * @model required="true"
	 * @generated
	 */
	MMInterface getType();

	/**
	 * Sets the value of the '{@link dslPatterns.MMInterfaceAttached#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(MMInterface value);

} // MMInterfaceAttached
