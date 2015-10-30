/**
 */
package dslPatterns.impl;

import dslPatterns.ClassInterface;
import dslPatterns.ClassInterfaceAttached;
import dslPatterns.DslPatternsPackage;

import dslPatterns.FeatureInterfaceAttached;
import dslPatterns.ReferenceInterfaceAttached;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Interface Attached</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.ClassInterfaceAttachedImpl#getRefIntAtt <em>Ref Int Att</em>}</li>
 *   <li>{@link dslPatterns.impl.ClassInterfaceAttachedImpl#getFeatIntAtt <em>Feat Int Att</em>}</li>
 *   <li>{@link dslPatterns.impl.ClassInterfaceAttachedImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassInterfaceAttachedImpl extends MMInterfaceAttachedImpl implements ClassInterfaceAttached {
	/**
	 * The cached value of the '{@link #getRefIntAtt() <em>Ref Int Att</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefIntAtt()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceInterfaceAttached> refIntAtt;
	/**
	 * The cached value of the '{@link #getFeatIntAtt() <em>Feat Int Att</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatIntAtt()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureInterfaceAttached> featIntAtt;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EObject value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassInterfaceAttachedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.CLASS_INTERFACE_ATTACHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceInterfaceAttached> getRefIntAtt() {
		if (refIntAtt == null) {
			refIntAtt = new EObjectContainmentEList<ReferenceInterfaceAttached>(ReferenceInterfaceAttached.class, this, DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT);
		}
		return refIntAtt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureInterfaceAttached> getFeatIntAtt() {
		if (featIntAtt == null) {
			featIntAtt = new EObjectContainmentEList<FeatureInterfaceAttached>(FeatureInterfaceAttached.class, this, DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT);
		}
		return featIntAtt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(EObject newValue) {
		EObject oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT:
				return ((InternalEList<?>)getRefIntAtt()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT:
				return ((InternalEList<?>)getFeatIntAtt()).basicRemove(otherEnd, msgs);
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
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT:
				return getRefIntAtt();
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT:
				return getFeatIntAtt();
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
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
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT:
				getRefIntAtt().clear();
				getRefIntAtt().addAll((Collection<? extends ReferenceInterfaceAttached>)newValue);
				return;
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT:
				getFeatIntAtt().clear();
				getFeatIntAtt().addAll((Collection<? extends FeatureInterfaceAttached>)newValue);
				return;
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE:
				setValue((EObject)newValue);
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
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT:
				getRefIntAtt().clear();
				return;
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT:
				getFeatIntAtt().clear();
				return;
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE:
				setValue((EObject)null);
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
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__REF_INT_ATT:
				return refIntAtt != null && !refIntAtt.isEmpty();
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT:
				return featIntAtt != null && !featIntAtt.isEmpty();
			case DslPatternsPackage.CLASS_INTERFACE_ATTACHED__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassInterfaceAttachedImpl
