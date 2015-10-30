/**
 */
package dslPatterns;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.Port#getName <em>Name</em>}</li>
 *   <li>{@link dslPatterns.Port#getMinCard <em>Min Card</em>}</li>
 *   <li>{@link dslPatterns.Port#getMaxCard <em>Max Card</em>}</li>
 *   <li>{@link dslPatterns.Port#getUses <em>Uses</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dslPatterns.DslPatternsPackage#getPort_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dslPatterns.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Min Card</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Card</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Card</em>' attribute.
	 * @see #setMinCard(BigInteger)
	 * @see dslPatterns.DslPatternsPackage#getPort_MinCard()
	 * @model default="0" required="true"
	 * @generated
	 */
	BigInteger getMinCard();

	/**
	 * Sets the value of the '{@link dslPatterns.Port#getMinCard <em>Min Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Card</em>' attribute.
	 * @see #getMinCard()
	 * @generated
	 */
	void setMinCard(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Card</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Card</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Card</em>' attribute.
	 * @see #setMaxCard(BigInteger)
	 * @see dslPatterns.DslPatternsPackage#getPort_MaxCard()
	 * @model default="-1" required="true"
	 * @generated
	 */
	BigInteger getMaxCard();

	/**
	 * Sets the value of the '{@link dslPatterns.Port#getMaxCard <em>Max Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Card</em>' attribute.
	 * @see #getMaxCard()
	 * @generated
	 */
	void setMaxCard(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link serviceInterfaces.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see dslPatterns.DslPatternsPackage#getPort_Uses()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Interface> getUses();

} // Port
