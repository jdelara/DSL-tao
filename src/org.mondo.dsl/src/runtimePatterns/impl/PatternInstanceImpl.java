/**
 */
package runtimePatterns.impl;

import dslPatterns.Pattern;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.RuntimePatternsPackage;

import runtimeServices.ServiceInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimePatterns.impl.PatternInstanceImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link runtimePatterns.impl.PatternInstanceImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link runtimePatterns.impl.PatternInstanceImpl#getClassInstances <em>Class Instances</em>}</li>
 *   <li>{@link runtimePatterns.impl.PatternInstanceImpl#getServiceInstances <em>Service Instances</em>}</li>
 *   <li>{@link runtimePatterns.impl.PatternInstanceImpl#isAttached <em>Attached</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternInstanceImpl extends EObjectImpl implements PatternInstance {
	/**
	 * The default value of the '{@link #getIdent() <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdent()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdent() <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdent()
	 * @generated
	 * @ordered
	 */
	protected String ident = IDENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern pattern;

	/**
	 * The cached value of the '{@link #getClassInstances() <em>Class Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassRoleInstance> classInstances;

	/**
	 * The cached value of the '{@link #getServiceInstances() <em>Service Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceInstance> serviceInstances;

	/**
	 * The default value of the '{@link #isAttached() <em>Attached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttached()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTACHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAttached() <em>Attached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttached()
	 * @generated
	 * @ordered
	 */
	protected boolean attached = ATTACHED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePatternsPackage.Literals.PATTERN_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent) {
		String oldIdent = ident;
		ident = newIdent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.PATTERN_INSTANCE__IDENT, oldIdent, ident));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		if (pattern != null && pattern.eIsProxy()) {
			InternalEObject oldPattern = (InternalEObject)pattern;
			pattern = (Pattern)eResolveProxy(oldPattern);
			if (pattern != oldPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN, oldPattern, pattern));
			}
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		Pattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassRoleInstance> getClassInstances() {
		if (classInstances == null) {
			classInstances = new EObjectContainmentEList<ClassRoleInstance>(ClassRoleInstance.class, this, RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES);
		}
		return classInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceInstance> getServiceInstances() {
		if (serviceInstances == null) {
			serviceInstances = new EObjectContainmentEList<ServiceInstance>(ServiceInstance.class, this, RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES);
		}
		return serviceInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttached() {
		return attached;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttached(boolean newAttached) {
		boolean oldAttached = attached;
		attached = newAttached;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.PATTERN_INSTANCE__ATTACHED, oldAttached, attached));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES:
				return ((InternalEList<?>)getClassInstances()).basicRemove(otherEnd, msgs);
			case RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES:
				return ((InternalEList<?>)getServiceInstances()).basicRemove(otherEnd, msgs);
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
			case RuntimePatternsPackage.PATTERN_INSTANCE__IDENT:
				return getIdent();
			case RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN:
				if (resolve) return getPattern();
				return basicGetPattern();
			case RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES:
				return getClassInstances();
			case RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES:
				return getServiceInstances();
			case RuntimePatternsPackage.PATTERN_INSTANCE__ATTACHED:
				return isAttached();
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
			case RuntimePatternsPackage.PATTERN_INSTANCE__IDENT:
				setIdent((String)newValue);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN:
				setPattern((Pattern)newValue);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES:
				getClassInstances().clear();
				getClassInstances().addAll((Collection<? extends ClassRoleInstance>)newValue);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES:
				getServiceInstances().clear();
				getServiceInstances().addAll((Collection<? extends ServiceInstance>)newValue);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__ATTACHED:
				setAttached((Boolean)newValue);
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
			case RuntimePatternsPackage.PATTERN_INSTANCE__IDENT:
				setIdent(IDENT_EDEFAULT);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN:
				setPattern((Pattern)null);
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES:
				getClassInstances().clear();
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES:
				getServiceInstances().clear();
				return;
			case RuntimePatternsPackage.PATTERN_INSTANCE__ATTACHED:
				setAttached(ATTACHED_EDEFAULT);
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
			case RuntimePatternsPackage.PATTERN_INSTANCE__IDENT:
				return IDENT_EDEFAULT == null ? ident != null : !IDENT_EDEFAULT.equals(ident);
			case RuntimePatternsPackage.PATTERN_INSTANCE__PATTERN:
				return pattern != null;
			case RuntimePatternsPackage.PATTERN_INSTANCE__CLASS_INSTANCES:
				return classInstances != null && !classInstances.isEmpty();
			case RuntimePatternsPackage.PATTERN_INSTANCE__SERVICE_INSTANCES:
				return serviceInstances != null && !serviceInstances.isEmpty();
			case RuntimePatternsPackage.PATTERN_INSTANCE__ATTACHED:
				return attached != ATTACHED_EDEFAULT;
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
		result.append(" (ident: ");
		result.append(ident);
		result.append(", attached: ");
		result.append(attached);
		result.append(')');
		return result.toString();
	}

} //PatternInstanceImpl
