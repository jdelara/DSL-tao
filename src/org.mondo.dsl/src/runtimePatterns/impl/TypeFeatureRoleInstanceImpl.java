/**
 */
package runtimePatterns.impl;

import dslPatterns.FeatureType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.RuntimePatternsPackage;
import runtimePatterns.TypeFeatureRoleInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Feature Role Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimePatterns.impl.TypeFeatureRoleInstanceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.impl.TypeFeatureRoleInstanceImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeFeatureRoleInstanceImpl extends FeatureRoleInstanceImpl implements TypeFeatureRoleInstance {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected FeatureType role;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EAttribute element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeFeatureRoleInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePatternsPackage.Literals.TYPE_FEATURE_ROLE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (FeatureType)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(FeatureType newRole) {
		FeatureType oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (EAttribute)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EAttribute newElement) {
		if (newElement != null){
			EAttribute oldElement = element;
			element = newElement;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT, oldElement, element));
		} else {
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
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT:
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
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE:
				setRole((FeatureType)newValue);
				return;
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT:
				setElement((EAttribute)newValue);
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
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE:
				setRole((FeatureType)null);
				return;
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT:
				setElement((EAttribute)null);
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
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ROLE:
				return role != null;
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

} //TypeFeatureRoleInstanceImpl
