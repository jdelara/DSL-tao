/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ReferenceInterface#getRef <em>Ref</em>}</li>
 *   <li>{@link dslPatterns.ReferenceInterface#isFlexibleComposite <em>Flexible Composite</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getReferenceInterface()
 * @model
 * @generated
 */
public interface ReferenceInterface extends MMInterface, CardinalityInterface {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EReference)
	 * @see dslPatterns.DslPatternsPackage#getReferenceInterface_Ref()
	 * @model required="true"
	 * @generated
	 */
	EReference getRef();

	/**
	 * Sets the value of the '{@link dslPatterns.ReferenceInterface#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EReference value);

	/**
	 * Returns the value of the '<em><b>Flexible Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flexible Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flexible Composite</em>' attribute.
	 * @see #setFlexibleComposite(boolean)
	 * @see dslPatterns.DslPatternsPackage#getReferenceInterface_FlexibleComposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isFlexibleComposite();

	/**
	 * Sets the value of the '{@link dslPatterns.ReferenceInterface#isFlexibleComposite <em>Flexible Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flexible Composite</em>' attribute.
	 * @see #isFlexibleComposite()
	 * @generated
	 */
	void setFlexibleComposite(boolean value);

} // ReferenceInterface
