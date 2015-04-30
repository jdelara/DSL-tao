/**
 */
package runtimeLayers.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import runtimeLayers.Layer;
import runtimeLayers.PatternRoleDependece;
import runtimeLayers.RuntimeLayersPackage;

import runtimePatterns.PatternInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Role Dependece</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimeLayers.impl.PatternRoleDependeceImpl#getUse <em>Use</em>}</li>
 *   <li>{@link runtimeLayers.impl.PatternRoleDependeceImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternRoleDependeceImpl extends EObjectImpl implements PatternRoleDependece {
	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected EList<Layer> use;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected PatternInstance pattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternRoleDependeceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeLayersPackage.Literals.PATTERN_ROLE_DEPENDECE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Layer> getUse() {
		if (use == null) {
			use = new EObjectResolvingEList<Layer>(Layer.class, this, RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__USE);
		}
		return use;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternInstance getPattern() {
		if (pattern != null && pattern.eIsProxy()) {
			InternalEObject oldPattern = (InternalEObject)pattern;
			pattern = (PatternInstance)eResolveProxy(oldPattern);
			if (pattern != oldPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN, oldPattern, pattern));
			}
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternInstance basicGetPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(PatternInstance newPattern) {
		PatternInstance oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__USE:
				return getUse();
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN:
				if (resolve) return getPattern();
				return basicGetPattern();
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
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__USE:
				getUse().clear();
				getUse().addAll((Collection<? extends Layer>)newValue);
				return;
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN:
				setPattern((PatternInstance)newValue);
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
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__USE:
				getUse().clear();
				return;
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN:
				setPattern((PatternInstance)null);
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
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__USE:
				return use != null && !use.isEmpty();
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE__PATTERN:
				return pattern != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternRoleDependeceImpl
