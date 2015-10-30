/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ClassInterface#getRef <em>Ref</em>}</li>
 *   <li>{@link dslPatterns.ClassInterface#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link dslPatterns.ClassInterface#isAbstractMatters <em>Abstract Matters</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getClassInterface()
 * @model
 * @generated
 */
public interface ClassInterface extends MMInterface {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference list.
	 * @see dslPatterns.DslPatternsPackage#getClassInterface_Ref()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EClass> getRef();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see dslPatterns.DslPatternsPackage#getClassInterface_Abstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link dslPatterns.ClassInterface#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract Matters</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Matters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Matters</em>' attribute.
	 * @see #setAbstractMatters(boolean)
	 * @see dslPatterns.DslPatternsPackage#getClassInterface_AbstractMatters()
	 * @model default="true"
	 * @generated
	 */
	boolean isAbstractMatters();

	/**
	 * Sets the value of the '{@link dslPatterns.ClassInterface#isAbstractMatters <em>Abstract Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Matters</em>' attribute.
	 * @see #isAbstractMatters()
	 * @generated
	 */
	void setAbstractMatters(boolean value);

} // ClassInterface
