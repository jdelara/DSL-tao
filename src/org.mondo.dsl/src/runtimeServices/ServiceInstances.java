/**
 */
package runtimeServices;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Instances</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeServices.ServiceInstances#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeServices.RuntimeServicesPackage#getServiceInstances()
 * @model
 * @generated
 */
public interface ServiceInstances extends EObject {
	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link runtimeServices.ServiceInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see runtimeServices.RuntimeServicesPackage#getServiceInstances_Services()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ServiceInstance> getServices();

} // ServiceInstances
