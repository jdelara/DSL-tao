/**
 */
package serviceInterfaces.modelingenv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.JavaTypeDeclaration#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getJavaTypeDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface JavaTypeDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute list.
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getJavaTypeDeclaration_QualifiedName()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getQualifiedName();

} // JavaTypeDeclaration
