/**
 */
package serviceInterfaces.codegen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import serviceInterfaces.codegen.CodegenPackage;
import serviceInterfaces.codegen.Pointcut;
import serviceInterfaces.codegen.SlotPlugInterfaceL1;

import serviceInterfaces.impl.InterfaceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Plug Interface L1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.codegen.impl.SlotPlugInterfaceL1Impl#getPointcuts <em>Pointcuts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlotPlugInterfaceL1Impl extends InterfaceImpl implements SlotPlugInterfaceL1 {
	/**
	 * The cached value of the '{@link #getPointcuts() <em>Pointcuts</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointcuts()
	 * @generated
	 * @ordered
	 */
	protected Pointcut pointcuts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotPlugInterfaceL1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.SLOT_PLUG_INTERFACE_L1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pointcut getPointcuts() {
		if (pointcuts != null && pointcuts.eIsProxy()) {
			InternalEObject oldPointcuts = (InternalEObject)pointcuts;
			pointcuts = (Pointcut)eResolveProxy(oldPointcuts);
			if (pointcuts != oldPointcuts) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS, oldPointcuts, pointcuts));
			}
		}
		return pointcuts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pointcut basicGetPointcuts() {
		return pointcuts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointcuts(Pointcut newPointcuts) {
		Pointcut oldPointcuts = pointcuts;
		pointcuts = newPointcuts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS, oldPointcuts, pointcuts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS:
				if (resolve) return getPointcuts();
				return basicGetPointcuts();
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
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS:
				setPointcuts((Pointcut)newValue);
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
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS:
				setPointcuts((Pointcut)null);
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
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1__POINTCUTS:
				return pointcuts != null;
		}
		return super.eIsSet(featureID);
	}

} //SlotPlugInterfaceL1Impl
