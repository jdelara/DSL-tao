/**
 */
package serviceInterfaces.modelingenv.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import serviceInterfaces.impl.InterfaceImpl;

import serviceInterfaces.modelingenv.ExtensionPoint;
import serviceInterfaces.modelingenv.ModelingenvPackage;
import serviceInterfaces.modelingenv.SlotPlugInterfaceL0;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Plug Interface L0</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.impl.SlotPlugInterfaceL0Impl#getSlot <em>Slot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlotPlugInterfaceL0Impl extends InterfaceImpl implements SlotPlugInterfaceL0 {
	/**
	 * The cached value of the '{@link #getSlot() <em>Slot</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionPoint> slot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotPlugInterfaceL0Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelingenvPackage.Literals.SLOT_PLUG_INTERFACE_L0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionPoint> getSlot() {
		if (slot == null) {
			slot = new EObjectContainmentEList<ExtensionPoint>(ExtensionPoint.class, this, ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT);
		}
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT:
				return ((InternalEList<?>)getSlot()).basicRemove(otherEnd, msgs);
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
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT:
				return getSlot();
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
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT:
				getSlot().clear();
				getSlot().addAll((Collection<? extends ExtensionPoint>)newValue);
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
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT:
				getSlot().clear();
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
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0__SLOT:
				return slot != null && !slot.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SlotPlugInterfaceL0Impl
