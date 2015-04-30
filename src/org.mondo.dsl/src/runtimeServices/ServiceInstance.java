/**
 */
package runtimeServices;

import dslPatterns.Service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeServices.ServiceInstance#getService <em>Service</em>}</li>
 *   <li>{@link runtimeServices.ServiceInstance#isActivated <em>Activated</em>}</li>
 *   <li>{@link runtimeServices.ServiceInstance#getDisconnectedElements <em>Disconnected Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeServices.RuntimeServicesPackage#getServiceInstance()
 * @model
 * @generated
 */
public interface ServiceInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' reference.
	 * @see #setService(Service)
	 * @see runtimeServices.RuntimeServicesPackage#getServiceInstance_Service()
	 * @model required="true"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link runtimeServices.ServiceInstance#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activated</em>' attribute.
	 * @see #setActivated(boolean)
	 * @see runtimeServices.RuntimeServicesPackage#getServiceInstance_Activated()
	 * @model
	 * @generated
	 */
	boolean isActivated();

	/**
	 * Sets the value of the '{@link runtimeServices.ServiceInstance#isActivated <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activated</em>' attribute.
	 * @see #isActivated()
	 * @generated
	 */
	void setActivated(boolean value);

	/**
	 * Returns the value of the '<em><b>Disconnected Elements</b></em>' containment reference list.
	 * The list contents are of type {@link runtimeServices.DisconnectedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disconnected Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disconnected Elements</em>' containment reference list.
	 * @see runtimeServices.RuntimeServicesPackage#getServiceInstance_DisconnectedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<DisconnectedElement> getDisconnectedElements();

} // ServiceInstance
