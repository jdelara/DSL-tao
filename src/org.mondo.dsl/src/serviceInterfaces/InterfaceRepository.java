/**
 */
package serviceInterfaces;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.InterfaceRepository#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.ServiceInterfacesPackage#getInterfaceRepository()
 * @model
 * @generated
 */
public interface InterfaceRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link serviceInterfaces.Packageable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * root class
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see serviceInterfaces.ServiceInterfacesPackage#getInterfaceRepository_Contents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Packageable> getContents();

} // InterfaceRepository
