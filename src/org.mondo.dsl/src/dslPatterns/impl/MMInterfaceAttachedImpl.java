/**
 */
package dslPatterns.impl;

import dslPatterns.DslPatternsPackage;
import dslPatterns.MMInterface;
import dslPatterns.MMInterfaceAttached;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MM Interface Attached</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.MMInterfaceAttachedImpl#getType <em>Type</em>}</li>
 *   <li>{@link dslPatterns.impl.MMInterfaceAttachedImpl#getAttached <em>Attached</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MMInterfaceAttachedImpl extends EObjectImpl implements MMInterfaceAttached {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MMInterface type;

	/**
	 * The cached value of the '{@link #getAttached() <em>Attached</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttached()
	 * @generated
	 * @ordered
	 */
	protected EList<MMInterface> attached;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMInterfaceAttachedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.MM_INTERFACE_ATTACHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MMInterface getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (MMInterface)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MMInterface basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(MMInterface newType) {
		MMInterface oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MMInterface> getAttached() {
		if (attached == null) {
			attached = new EObjectResolvingEList<MMInterface>(MMInterface.class, this, DslPatternsPackage.MM_INTERFACE_ATTACHED__ATTACHED);
		}
		return attached;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__ATTACHED:
				return getAttached();
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
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE:
				setType((MMInterface)newValue);
				return;
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__ATTACHED:
				getAttached().clear();
				getAttached().addAll((Collection<? extends MMInterface>)newValue);
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
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE:
				setType((MMInterface)null);
				return;
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__ATTACHED:
				getAttached().clear();
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
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__TYPE:
				return type != null;
			case DslPatternsPackage.MM_INTERFACE_ATTACHED__ATTACHED:
				return attached != null && !attached.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MMInterfaceAttachedImpl
