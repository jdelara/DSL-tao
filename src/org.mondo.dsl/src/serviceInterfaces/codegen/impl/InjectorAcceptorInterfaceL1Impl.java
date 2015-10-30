/**
 */
package serviceInterfaces.codegen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import serviceInterfaces.codegen.CodegenPackage;
import serviceInterfaces.codegen.InjectorAcceptorInterfaceL1;
import serviceInterfaces.codegen.TransformationLibrary;

import serviceInterfaces.impl.InterfaceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Injector Acceptor Interface L1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.codegen.impl.InjectorAcceptorInterfaceL1Impl#getInjectorProvides <em>Injector Provides</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InjectorAcceptorInterfaceL1Impl extends InterfaceImpl implements InjectorAcceptorInterfaceL1 {
	/**
	 * The cached value of the '{@link #getInjectorProvides() <em>Injector Provides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjectorProvides()
	 * @generated
	 * @ordered
	 */
	protected TransformationLibrary injectorProvides;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InjectorAcceptorInterfaceL1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.INJECTOR_ACCEPTOR_INTERFACE_L1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationLibrary getInjectorProvides() {
		if (injectorProvides != null && injectorProvides.eIsProxy()) {
			InternalEObject oldInjectorProvides = (InternalEObject)injectorProvides;
			injectorProvides = (TransformationLibrary)eResolveProxy(oldInjectorProvides);
			if (injectorProvides != oldInjectorProvides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES, oldInjectorProvides, injectorProvides));
			}
		}
		return injectorProvides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationLibrary basicGetInjectorProvides() {
		return injectorProvides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInjectorProvides(TransformationLibrary newInjectorProvides) {
		TransformationLibrary oldInjectorProvides = injectorProvides;
		injectorProvides = newInjectorProvides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES, oldInjectorProvides, injectorProvides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES:
				if (resolve) return getInjectorProvides();
				return basicGetInjectorProvides();
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
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES:
				setInjectorProvides((TransformationLibrary)newValue);
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
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES:
				setInjectorProvides((TransformationLibrary)null);
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
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1__INJECTOR_PROVIDES:
				return injectorProvides != null;
		}
		return super.eIsSet(featureID);
	}

} //InjectorAcceptorInterfaceL1Impl
