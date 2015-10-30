/**
 */
package serviceInterfaces.modelingenv.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import serviceInterfaces.impl.InterfaceImpl;

import serviceInterfaces.modelingenv.InjectionMode;
import serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0;
import serviceInterfaces.modelingenv.JavaTypeDeclaration;
import serviceInterfaces.modelingenv.ModelingenvPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Injector Acceptor Interface L0</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl#getInjectorImplements <em>Injector Implements</em>}</li>
 *   <li>{@link serviceInterfaces.modelingenv.impl.InjectorAcceptorInterfaceL0Impl#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InjectorAcceptorInterfaceL0Impl extends InterfaceImpl implements InjectorAcceptorInterfaceL0 {
	/**
	 * The cached value of the '{@link #getInjectorImplements() <em>Injector Implements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjectorImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaTypeDeclaration> injectorImplements;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final InjectionMode MODE_EDEFAULT = InjectionMode.GOOGLE_JUICE;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected InjectionMode mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InjectorAcceptorInterfaceL0Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelingenvPackage.Literals.INJECTOR_ACCEPTOR_INTERFACE_L0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaTypeDeclaration> getInjectorImplements() {
		if (injectorImplements == null) {
			injectorImplements = new EObjectContainmentEList<JavaTypeDeclaration>(JavaTypeDeclaration.class, this, ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS);
		}
		return injectorImplements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectionMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(InjectionMode newMode) {
		InjectionMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS:
				return ((InternalEList<?>)getInjectorImplements()).basicRemove(otherEnd, msgs);
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
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS:
				return getInjectorImplements();
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__MODE:
				return getMode();
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
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS:
				getInjectorImplements().clear();
				getInjectorImplements().addAll((Collection<? extends JavaTypeDeclaration>)newValue);
				return;
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__MODE:
				setMode((InjectionMode)newValue);
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
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS:
				getInjectorImplements().clear();
				return;
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__MODE:
				setMode(MODE_EDEFAULT);
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
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__INJECTOR_IMPLEMENTS:
				return injectorImplements != null && !injectorImplements.isEmpty();
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0__MODE:
				return mode != MODE_EDEFAULT;
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
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //InjectorAcceptorInterfaceL0Impl
