/**
 */
package dslPatterns.impl;

import dslPatterns.ComplexFeatureAttached;
import dslPatterns.DslPatternsPackage;
import dslPatterns.PatternMetaModelAttached;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Feature Attached</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.ComplexFeatureAttachedImpl#getMetaModelAttached <em>Meta Model Attached</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexFeatureAttachedImpl extends ComplexFeatureImpl implements ComplexFeatureAttached {
	/**
	 * The cached value of the '{@link #getMetaModelAttached() <em>Meta Model Attached</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelAttached()
	 * @generated
	 * @ordered
	 */
	protected PatternMetaModelAttached metaModelAttached;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexFeatureAttachedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.COMPLEX_FEATURE_ATTACHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMetaModelAttached getMetaModelAttached() {
		return metaModelAttached;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaModelAttached(PatternMetaModelAttached newMetaModelAttached, NotificationChain msgs) {
		PatternMetaModelAttached oldMetaModelAttached = metaModelAttached;
		metaModelAttached = newMetaModelAttached;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED, oldMetaModelAttached, newMetaModelAttached);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelAttached(PatternMetaModelAttached newMetaModelAttached) {
		if (newMetaModelAttached != metaModelAttached) {
			NotificationChain msgs = null;
			if (metaModelAttached != null)
				msgs = ((InternalEObject)metaModelAttached).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED, null, msgs);
			if (newMetaModelAttached != null)
				msgs = ((InternalEObject)newMetaModelAttached).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED, null, msgs);
			msgs = basicSetMetaModelAttached(newMetaModelAttached, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED, newMetaModelAttached, newMetaModelAttached));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED:
				return basicSetMetaModelAttached(null, msgs);
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
			case DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED:
				return getMetaModelAttached();
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
			case DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED:
				setMetaModelAttached((PatternMetaModelAttached)newValue);
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
			case DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED:
				setMetaModelAttached((PatternMetaModelAttached)null);
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
			case DslPatternsPackage.COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED:
				return metaModelAttached != null;
		}
		return super.eIsSet(featureID);
	}

} //ComplexFeatureAttachedImpl
