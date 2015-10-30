/**
 */
package serviceInterfaces.modelingenv;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.JavaClass#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getJavaClass()
 * @model
 * @generated
 */
public interface JavaClass extends JavaTypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link serviceInterfaces.modelingenv.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getJavaClass_Operations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Operation> getOperations();

} // JavaClass
