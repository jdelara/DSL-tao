/**
 */
package dslPatterns;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.CardinalityInterface#isAnyMin <em>Any Min</em>}</li>
 *   <li>{@link dslPatterns.CardinalityInterface#isAnyMax <em>Any Max</em>}</li>
 *   <li>{@link dslPatterns.CardinalityInterface#isAnyOrdering <em>Any Ordering</em>}</li>
 *   <li>{@link dslPatterns.CardinalityInterface#isUniqueMatters <em>Unique Matters</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getCardinalityInterface()
 * @model abstract="true"
 * @generated
 */
public interface CardinalityInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Any Min</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Min</em>' attribute.
	 * @see #setAnyMin(boolean)
	 * @see dslPatterns.DslPatternsPackage#getCardinalityInterface_AnyMin()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnyMin();

	/**
	 * Sets the value of the '{@link dslPatterns.CardinalityInterface#isAnyMin <em>Any Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any Min</em>' attribute.
	 * @see #isAnyMin()
	 * @generated
	 */
	void setAnyMin(boolean value);

	/**
	 * Returns the value of the '<em><b>Any Max</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Max</em>' attribute.
	 * @see #setAnyMax(boolean)
	 * @see dslPatterns.DslPatternsPackage#getCardinalityInterface_AnyMax()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnyMax();

	/**
	 * Sets the value of the '{@link dslPatterns.CardinalityInterface#isAnyMax <em>Any Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any Max</em>' attribute.
	 * @see #isAnyMax()
	 * @generated
	 */
	void setAnyMax(boolean value);

	/**
	 * Returns the value of the '<em><b>Any Ordering</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Ordering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Ordering</em>' attribute.
	 * @see #setAnyOrdering(boolean)
	 * @see dslPatterns.DslPatternsPackage#getCardinalityInterface_AnyOrdering()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnyOrdering();

	/**
	 * Sets the value of the '{@link dslPatterns.CardinalityInterface#isAnyOrdering <em>Any Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any Ordering</em>' attribute.
	 * @see #isAnyOrdering()
	 * @generated
	 */
	void setAnyOrdering(boolean value);

	/**
	 * Returns the value of the '<em><b>Unique Matters</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Matters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Matters</em>' attribute.
	 * @see #setUniqueMatters(boolean)
	 * @see dslPatterns.DslPatternsPackage#getCardinalityInterface_UniqueMatters()
	 * @model default="true"
	 * @generated
	 */
	boolean isUniqueMatters();

	/**
	 * Sets the value of the '{@link dslPatterns.CardinalityInterface#isUniqueMatters <em>Unique Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Matters</em>' attribute.
	 * @see #isUniqueMatters()
	 * @generated
	 */
	void setUniqueMatters(boolean value);

} // CardinalityInterface
