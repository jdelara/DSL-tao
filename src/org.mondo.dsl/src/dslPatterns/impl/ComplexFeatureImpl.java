/**
 */
package dslPatterns.impl;

import dslPatterns.ComplexFeature;
import dslPatterns.DslPatternsPackage;
import dslPatterns.PatternMetaModel;
import dslPatterns.Variant;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.ComplexFeatureImpl#getAndChildren <em>And Children</em>}</li>
 *   <li>{@link dslPatterns.impl.ComplexFeatureImpl#getOrChildren <em>Or Children</em>}</li>
 *   <li>{@link dslPatterns.impl.ComplexFeatureImpl#getXorChildren <em>Xor Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComplexFeatureImpl extends VariantImpl implements ComplexFeature {
	/**
	 * The cached value of the '{@link #getAndChildren() <em>And Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAndChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Variant> andChildren;

	/**
	 * The cached value of the '{@link #getOrChildren() <em>Or Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Variant> orChildren;

	/**
	 * The cached value of the '{@link #getXorChildren() <em>Xor Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXorChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Variant> xorChildren;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.COMPLEX_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variant> getAndChildren() {
		if (andChildren == null) {
			andChildren = new EObjectContainmentEList<Variant>(Variant.class, this, DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN);
		}
		return andChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variant> getOrChildren() {
		if (orChildren == null) {
			orChildren = new EObjectContainmentEList<Variant>(Variant.class, this, DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN);
		}
		return orChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variant> getXorChildren() {
		if (xorChildren == null) {
			xorChildren = new EObjectContainmentEList<Variant>(Variant.class, this, DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN);
		}
		return xorChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN:
				return ((InternalEList<?>)getAndChildren()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN:
				return ((InternalEList<?>)getOrChildren()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN:
				return ((InternalEList<?>)getXorChildren()).basicRemove(otherEnd, msgs);
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
			case DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN:
				return getAndChildren();
			case DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN:
				return getOrChildren();
			case DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN:
				return getXorChildren();
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
			case DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN:
				getAndChildren().clear();
				getAndChildren().addAll((Collection<? extends Variant>)newValue);
				return;
			case DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN:
				getOrChildren().clear();
				getOrChildren().addAll((Collection<? extends Variant>)newValue);
				return;
			case DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN:
				getXorChildren().clear();
				getXorChildren().addAll((Collection<? extends Variant>)newValue);
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
			case DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN:
				getAndChildren().clear();
				return;
			case DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN:
				getOrChildren().clear();
				return;
			case DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN:
				getXorChildren().clear();
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
			case DslPatternsPackage.COMPLEX_FEATURE__AND_CHILDREN:
				return andChildren != null && !andChildren.isEmpty();
			case DslPatternsPackage.COMPLEX_FEATURE__OR_CHILDREN:
				return orChildren != null && !orChildren.isEmpty();
			case DslPatternsPackage.COMPLEX_FEATURE__XOR_CHILDREN:
				return xorChildren != null && !xorChildren.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexFeatureImpl
