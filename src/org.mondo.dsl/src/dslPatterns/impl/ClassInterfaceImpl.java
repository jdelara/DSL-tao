/**
 */
package dslPatterns.impl;

import dslPatterns.ClassInterface;
import dslPatterns.ClassInterfaceAttached;
import dslPatterns.DslPatternsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.ClassInterfaceImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link dslPatterns.impl.ClassInterfaceImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link dslPatterns.impl.ClassInterfaceImpl#isAbstractMatters <em>Abstract Matters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassInterfaceImpl extends MMInterfaceImpl implements ClassInterface {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> ref;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstractMatters() <em>Abstract Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstractMatters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_MATTERS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAbstractMatters() <em>Abstract Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstractMatters()
	 * @generated
	 * @ordered
	 */
	protected boolean abstractMatters = ABSTRACT_MATTERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.CLASS_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getRef() {
		if (ref == null) {
			ref = new EObjectResolvingEList<EClass>(EClass.class, this, DslPatternsPackage.CLASS_INTERFACE__REF);
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.CLASS_INTERFACE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstractMatters() {
		return abstractMatters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractMatters(boolean newAbstractMatters) {
		boolean oldAbstractMatters = abstractMatters;
		abstractMatters = newAbstractMatters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.CLASS_INTERFACE__ABSTRACT_MATTERS, oldAbstractMatters, abstractMatters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.CLASS_INTERFACE__REF:
				return getRef();
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT:
				return isAbstract();
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT_MATTERS:
				return isAbstractMatters();
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
			case DslPatternsPackage.CLASS_INTERFACE__REF:
				getRef().clear();
				getRef().addAll((Collection<? extends EClass>)newValue);
				return;
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT_MATTERS:
				setAbstractMatters((Boolean)newValue);
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
			case DslPatternsPackage.CLASS_INTERFACE__REF:
				getRef().clear();
				return;
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT_MATTERS:
				setAbstractMatters(ABSTRACT_MATTERS_EDEFAULT);
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
			case DslPatternsPackage.CLASS_INTERFACE__REF:
				return ref != null && !ref.isEmpty();
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case DslPatternsPackage.CLASS_INTERFACE__ABSTRACT_MATTERS:
				return abstractMatters != ABSTRACT_MATTERS_EDEFAULT;
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(", abstractMatters: ");
		result.append(abstractMatters);
		result.append(')');
		return result.toString();
	}

} //ClassInterfaceImpl
