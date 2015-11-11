/**
 */
package runtimePatterns.impl;

import dslPatterns.ReferenceInterface;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.RuntimePatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Role Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimePatterns.impl.ReferenceRoleInstanceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.impl.ReferenceRoleInstanceImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceRoleInstanceImpl extends RoleInstanceImpl implements ReferenceRoleInstance {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected ReferenceInterface role;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EReference element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceRoleInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePatternsPackage.Literals.REFERENCE_ROLE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceInterface getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (ReferenceInterface)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceInterface basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(ReferenceInterface newRole) {
		ReferenceInterface oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (EReference)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EReference newElement) {
		if (newElement != null){
			EReference oldElement = element;
			element = newElement;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT, oldElement, element));
		}else {
			ClassRoleInstance pi = (ClassRoleInstance)this.eContainer();
			pi.getReferenceInstances().remove(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE:
				setRole((ReferenceInterface)newValue);
				return;
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT:
				setElement((EReference)newValue);
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
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE:
				setRole((ReferenceInterface)null);
				return;
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT:
				setElement((EReference)null);
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
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ROLE:
				return role != null;
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceRoleInstanceImpl
