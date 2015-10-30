/**
 */
package serviceInterfaces.codegen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.codegen.Pointcut#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.codegen.CodegenPackage#getPointcut()
 * @model abstract="true"
 * @generated
 */
public interface Pointcut extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link serviceInterfaces.codegen.PointcutType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see serviceInterfaces.codegen.PointcutType
	 * @see #setType(PointcutType)
	 * @see serviceInterfaces.codegen.CodegenPackage#getPointcut_Type()
	 * @model
	 * @generated
	 */
	PointcutType getType();

	/**
	 * Sets the value of the '{@link serviceInterfaces.codegen.Pointcut#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see serviceInterfaces.codegen.PointcutType
	 * @see #getType()
	 * @generated
	 */
	void setType(PointcutType value);

} // Pointcut
