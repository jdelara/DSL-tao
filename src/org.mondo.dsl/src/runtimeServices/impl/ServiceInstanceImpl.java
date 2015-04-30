/**
 */
package runtimeServices.impl;

import dslPatterns.Service;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtimeServices.DisconnectedElement;
import runtimeServices.RuntimeServicesPackage;
import runtimeServices.ServiceInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimeServices.impl.ServiceInstanceImpl#getService <em>Service</em>}</li>
 *   <li>{@link runtimeServices.impl.ServiceInstanceImpl#isActivated <em>Activated</em>}</li>
 *   <li>{@link runtimeServices.impl.ServiceInstanceImpl#getDisconnectedElements <em>Disconnected Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceInstanceImpl extends EObjectImpl implements ServiceInstance {
	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Service service;

	/**
	 * The default value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected boolean activated = ACTIVATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDisconnectedElements() <em>Disconnected Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisconnectedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DisconnectedElement> disconnectedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeServicesPackage.Literals.SERVICE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		if (service != null && service.eIsProxy()) {
			InternalEObject oldService = (InternalEObject)service;
			service = (Service)eResolveProxy(oldService);
			if (service != oldService) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE, oldService, service));
			}
		}
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service basicGetService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		Service oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivated(boolean newActivated) {
		boolean oldActivated = activated;
		activated = newActivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeServicesPackage.SERVICE_INSTANCE__ACTIVATED, oldActivated, activated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisconnectedElement> getDisconnectedElements() {
		if (disconnectedElements == null) {
			disconnectedElements = new EObjectContainmentEList<DisconnectedElement>(DisconnectedElement.class, this, RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS);
		}
		return disconnectedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS:
				return ((InternalEList<?>)getDisconnectedElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE:
				if (resolve) return getService();
				return basicGetService();
			case RuntimeServicesPackage.SERVICE_INSTANCE__ACTIVATED:
				return isActivated();
			case RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS:
				return getDisconnectedElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE:
				setService((Service)newValue);
				return;
			case RuntimeServicesPackage.SERVICE_INSTANCE__ACTIVATED:
				setActivated((Boolean)newValue);
				return;
			case RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS:
				getDisconnectedElements().clear();
				getDisconnectedElements().addAll((Collection<? extends DisconnectedElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE:
				setService((Service)null);
				return;
			case RuntimeServicesPackage.SERVICE_INSTANCE__ACTIVATED:
				setActivated(ACTIVATED_EDEFAULT);
				return;
			case RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS:
				getDisconnectedElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RuntimeServicesPackage.SERVICE_INSTANCE__SERVICE:
				return service != null;
			case RuntimeServicesPackage.SERVICE_INSTANCE__ACTIVATED:
				return activated != ACTIVATED_EDEFAULT;
			case RuntimeServicesPackage.SERVICE_INSTANCE__DISCONNECTED_ELEMENTS:
				return disconnectedElements != null && !disconnectedElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (activated: ");
		result.append(activated);
		result.append(')');
		return result.toString();
	}

} //ServiceInstanceImpl
