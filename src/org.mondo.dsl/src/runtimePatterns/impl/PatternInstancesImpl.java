/**
 */
package runtimePatterns.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtimePatterns.PatternInstance;
import runtimePatterns.PatternInstances;
import runtimePatterns.RuntimePatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Instances</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimePatterns.impl.PatternInstancesImpl#getAppliedPatterns <em>Applied Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternInstancesImpl extends EObjectImpl implements PatternInstances {
	/**
	 * The cached value of the '{@link #getAppliedPatterns() <em>Applied Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternInstance> appliedPatterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternInstancesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePatternsPackage.Literals.PATTERN_INSTANCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternInstance> getAppliedPatterns() {
		if (appliedPatterns == null) {
			appliedPatterns = new EObjectContainmentEList<PatternInstance>(PatternInstance.class, this, RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS);
		}
		return appliedPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS:
				return ((InternalEList<?>)getAppliedPatterns()).basicRemove(otherEnd, msgs);
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
			case RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS:
				return getAppliedPatterns();
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
			case RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS:
				getAppliedPatterns().clear();
				getAppliedPatterns().addAll((Collection<? extends PatternInstance>)newValue);
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
			case RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS:
				getAppliedPatterns().clear();
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
			case RuntimePatternsPackage.PATTERN_INSTANCES__APPLIED_PATTERNS:
				return appliedPatterns != null && !appliedPatterns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternInstancesImpl
