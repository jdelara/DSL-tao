/**
 */
package dslPatterns;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MM Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.MMInterface#getIcon <em>Icon</em>}</li>
 *   <li>{@link dslPatterns.MMInterface#getMinCard <em>Min Card</em>}</li>
 *   <li>{@link dslPatterns.MMInterface#getMaxCard <em>Max Card</em>}</li>
 *   <li>{@link dslPatterns.MMInterface#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getMMInterface()
 * @model abstract="true"
 * @generated
 */
public interface MMInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see dslPatterns.DslPatternsPackage#getMMInterface_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link dslPatterns.MMInterface#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Card</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Card</em>' attribute.
	 * @see #setMinCard(BigInteger)
	 * @see dslPatterns.DslPatternsPackage#getMMInterface_MinCard()
	 * @model required="true"
	 * @generated
	 */
	BigInteger getMinCard();

	/**
	 * Sets the value of the '{@link dslPatterns.MMInterface#getMinCard <em>Min Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Card</em>' attribute.
	 * @see #getMinCard()
	 * @generated
	 */
	void setMinCard(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Card</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Card</em>' attribute.
	 * @see #setMaxCard(BigInteger)
	 * @see dslPatterns.DslPatternsPackage#getMMInterface_MaxCard()
	 * @model required="true"
	 * @generated
	 */
	BigInteger getMaxCard();

	/**
	 * Sets the value of the '{@link dslPatterns.MMInterface#getMaxCard <em>Max Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Card</em>' attribute.
	 * @see #getMaxCard()
	 * @generated
	 */
	void setMaxCard(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see dslPatterns.DslPatternsPackage#getMMInterface_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link dslPatterns.MMInterface#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

} // MMInterface
