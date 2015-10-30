/**
 */
package dslPatterns.impl;

import dslPatterns.CardinalityInterface;
import dslPatterns.DslPatternsPackage;
import dslPatterns.ReferenceInterface;

import dslPatterns.ReferenceInterfaceAttached;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#isAnyMin <em>Any Min</em>}</li>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#isAnyMax <em>Any Max</em>}</li>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#isAnyOrdering <em>Any Ordering</em>}</li>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#isUniqueMatters <em>Unique Matters</em>}</li>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link dslPatterns.impl.ReferenceInterfaceImpl#isFlexibleComposite <em>Flexible Composite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceInterfaceImpl extends MMInterfaceImpl implements ReferenceInterface {
	/**
	 * The default value of the '{@link #isAnyMin() <em>Any Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyMin()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_MIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnyMin() <em>Any Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyMin()
	 * @generated
	 * @ordered
	 */
	protected boolean anyMin = ANY_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #isAnyMax() <em>Any Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyMax()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_MAX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnyMax() <em>Any Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyMax()
	 * @generated
	 * @ordered
	 */
	protected boolean anyMax = ANY_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #isAnyOrdering() <em>Any Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyOrdering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_ORDERING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAnyOrdering() <em>Any Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyOrdering()
	 * @generated
	 * @ordered
	 */
	protected boolean anyOrdering = ANY_ORDERING_EDEFAULT;

	/**
	 * The default value of the '{@link #isUniqueMatters() <em>Unique Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUniqueMatters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNIQUE_MATTERS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUniqueMatters() <em>Unique Matters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUniqueMatters()
	 * @generated
	 * @ordered
	 */
	protected boolean uniqueMatters = UNIQUE_MATTERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EReference ref;

	/**
	 * The default value of the '{@link #isFlexibleComposite() <em>Flexible Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlexibleComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLEXIBLE_COMPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlexibleComposite() <em>Flexible Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlexibleComposite()
	 * @generated
	 * @ordered
	 */
	protected boolean flexibleComposite = FLEXIBLE_COMPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.REFERENCE_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnyMin() {
		return anyMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnyMin(boolean newAnyMin) {
		boolean oldAnyMin = anyMin;
		anyMin = newAnyMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN, oldAnyMin, anyMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnyMax() {
		return anyMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnyMax(boolean newAnyMax) {
		boolean oldAnyMax = anyMax;
		anyMax = newAnyMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX, oldAnyMax, anyMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (EReference)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPatternsPackage.REFERENCE_INTERFACE__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(EReference newRef) {
		EReference oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlexibleComposite() {
		return flexibleComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlexibleComposite(boolean newFlexibleComposite) {
		boolean oldFlexibleComposite = flexibleComposite;
		flexibleComposite = newFlexibleComposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__FLEXIBLE_COMPOSITE, oldFlexibleComposite, flexibleComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnyOrdering() {
		return anyOrdering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnyOrdering(boolean newAnyOrdering) {
		boolean oldAnyOrdering = anyOrdering;
		anyOrdering = newAnyOrdering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING, oldAnyOrdering, anyOrdering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUniqueMatters() {
		return uniqueMatters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUniqueMatters(boolean newUniqueMatters) {
		boolean oldUniqueMatters = uniqueMatters;
		uniqueMatters = newUniqueMatters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS, oldUniqueMatters, uniqueMatters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN:
				return isAnyMin();
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX:
				return isAnyMax();
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING:
				return isAnyOrdering();
			case DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS:
				return isUniqueMatters();
			case DslPatternsPackage.REFERENCE_INTERFACE__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case DslPatternsPackage.REFERENCE_INTERFACE__FLEXIBLE_COMPOSITE:
				return isFlexibleComposite();
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
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN:
				setAnyMin((Boolean)newValue);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX:
				setAnyMax((Boolean)newValue);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING:
				setAnyOrdering((Boolean)newValue);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS:
				setUniqueMatters((Boolean)newValue);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__REF:
				setRef((EReference)newValue);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__FLEXIBLE_COMPOSITE:
				setFlexibleComposite((Boolean)newValue);
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
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN:
				setAnyMin(ANY_MIN_EDEFAULT);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX:
				setAnyMax(ANY_MAX_EDEFAULT);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING:
				setAnyOrdering(ANY_ORDERING_EDEFAULT);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS:
				setUniqueMatters(UNIQUE_MATTERS_EDEFAULT);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__REF:
				setRef((EReference)null);
				return;
			case DslPatternsPackage.REFERENCE_INTERFACE__FLEXIBLE_COMPOSITE:
				setFlexibleComposite(FLEXIBLE_COMPOSITE_EDEFAULT);
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
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN:
				return anyMin != ANY_MIN_EDEFAULT;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX:
				return anyMax != ANY_MAX_EDEFAULT;
			case DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING:
				return anyOrdering != ANY_ORDERING_EDEFAULT;
			case DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS:
				return uniqueMatters != UNIQUE_MATTERS_EDEFAULT;
			case DslPatternsPackage.REFERENCE_INTERFACE__REF:
				return ref != null;
			case DslPatternsPackage.REFERENCE_INTERFACE__FLEXIBLE_COMPOSITE:
				return flexibleComposite != FLEXIBLE_COMPOSITE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CardinalityInterface.class) {
			switch (derivedFeatureID) {
				case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN: return DslPatternsPackage.CARDINALITY_INTERFACE__ANY_MIN;
				case DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX: return DslPatternsPackage.CARDINALITY_INTERFACE__ANY_MAX;
				case DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING: return DslPatternsPackage.CARDINALITY_INTERFACE__ANY_ORDERING;
				case DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS: return DslPatternsPackage.CARDINALITY_INTERFACE__UNIQUE_MATTERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CardinalityInterface.class) {
			switch (baseFeatureID) {
				case DslPatternsPackage.CARDINALITY_INTERFACE__ANY_MIN: return DslPatternsPackage.REFERENCE_INTERFACE__ANY_MIN;
				case DslPatternsPackage.CARDINALITY_INTERFACE__ANY_MAX: return DslPatternsPackage.REFERENCE_INTERFACE__ANY_MAX;
				case DslPatternsPackage.CARDINALITY_INTERFACE__ANY_ORDERING: return DslPatternsPackage.REFERENCE_INTERFACE__ANY_ORDERING;
				case DslPatternsPackage.CARDINALITY_INTERFACE__UNIQUE_MATTERS: return DslPatternsPackage.REFERENCE_INTERFACE__UNIQUE_MATTERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (anyMin: ");
		result.append(anyMin);
		result.append(", anyMax: ");
		result.append(anyMax);
		result.append(", anyOrdering: ");
		result.append(anyOrdering);
		result.append(", uniqueMatters: ");
		result.append(uniqueMatters);
		result.append(", flexibleComposite: ");
		result.append(flexibleComposite);
		result.append(')');
		return result.toString();
	}

} //ReferenceInterfaceImpl
