/**
 */
package serviceInterfaces.codegen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.codegen.TransformationLibrary#getName <em>Name</em>}</li>
 *   <li>{@link serviceInterfaces.codegen.TransformationLibrary#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.codegen.CodegenPackage#getTransformationLibrary()
 * @model
 * @generated
 */
public interface TransformationLibrary extends EObject {
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
	 * @see serviceInterfaces.codegen.CodegenPackage#getTransformationLibrary_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link serviceInterfaces.codegen.TransformationLibrary#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link serviceInterfaces.codegen.CodeGenLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see serviceInterfaces.codegen.CodeGenLanguage
	 * @see #setLanguage(CodeGenLanguage)
	 * @see serviceInterfaces.codegen.CodegenPackage#getTransformationLibrary_Language()
	 * @model
	 * @generated
	 */
	CodeGenLanguage getLanguage();

	/**
	 * Sets the value of the '{@link serviceInterfaces.codegen.TransformationLibrary#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see serviceInterfaces.codegen.CodeGenLanguage
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(CodeGenLanguage value);

} // TransformationLibrary
