/**
 */
package dslPatterns.impl;

import dslPatterns.DslPatternsPackage;
import dslPatterns.FeatureKind;
import dslPatterns.SimpleFeature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.SimpleFeatureImpl#getFeatureKind <em>Feature Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleFeatureImpl extends VariantImpl implements SimpleFeature {
	/**
	 * The default value of the '{@link #getFeatureKind() <em>Feature Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureKind()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureKind FEATURE_KIND_EDEFAULT = FeatureKind.BOOLEAN_FEATURE;

	/**
	 * The cached value of the '{@link #getFeatureKind() <em>Feature Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureKind()
	 * @generated
	 * @ordered
	 */
	protected FeatureKind featureKind = FEATURE_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.SIMPLE_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureKind getFeatureKind() {
		return featureKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureKind(FeatureKind newFeatureKind) {
		FeatureKind oldFeatureKind = featureKind;
		featureKind = newFeatureKind == null ? FEATURE_KIND_EDEFAULT : newFeatureKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.SIMPLE_FEATURE__FEATURE_KIND, oldFeatureKind, featureKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.SIMPLE_FEATURE__FEATURE_KIND:
				return getFeatureKind();
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
			case DslPatternsPackage.SIMPLE_FEATURE__FEATURE_KIND:
				setFeatureKind((FeatureKind)newValue);
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
			case DslPatternsPackage.SIMPLE_FEATURE__FEATURE_KIND:
				setFeatureKind(FEATURE_KIND_EDEFAULT);
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
			case DslPatternsPackage.SIMPLE_FEATURE__FEATURE_KIND:
				return featureKind != FEATURE_KIND_EDEFAULT;
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
		result.append(" (featureKind: ");
		result.append(featureKind);
		result.append(')');
		return result.toString();
	}

} //SimpleFeatureImpl
