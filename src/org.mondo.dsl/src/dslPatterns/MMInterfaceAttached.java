/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MM Interface Attached</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.MMInterfaceAttached#getType <em>Type</em>}</li>
 *   <li>{@link dslPatterns.MMInterfaceAttached#getAttached <em>Attached</em>}</li>
 * </ul>
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

	/**
	 * Returns the value of the '<em><b>Attached</b></em>' reference list.
	 * The list contents are of type {@link dslPatterns.MMInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached</em>' reference list.
	 * @see dslPatterns.DslPatternsPackage#getMMInterfaceAttached_Attached()
	 * @model
	 * @generated
	 */
	EList<MMInterface> getAttached();

} // MMInterfaceAttached
