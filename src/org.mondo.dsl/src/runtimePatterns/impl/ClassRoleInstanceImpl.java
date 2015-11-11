/**
 */
package runtimePatterns.impl;

import dslPatterns.ClassInterface;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtimePatterns.ClassRoleInstance;
import runtimePatterns.FeatureRoleInstance;
import runtimePatterns.PatternInstance;
import runtimePatterns.ReferenceRoleInstance;
import runtimePatterns.RuntimePatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Role Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimePatterns.impl.ClassRoleInstanceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link runtimePatterns.impl.ClassRoleInstanceImpl#getElement <em>Element</em>}</li>
 *   <li>{@link runtimePatterns.impl.ClassRoleInstanceImpl#getFeatureInstances <em>Feature Instances</em>}</li>
 *   <li>{@link runtimePatterns.impl.ClassRoleInstanceImpl#getReferenceInstances <em>Reference Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassRoleInstanceImpl extends RoleInstanceImpl implements ClassRoleInstance {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected ClassInterface role;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EClass element;

	/**
	 * The cached value of the '{@link #getFeatureInstances() <em>Feature Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureRoleInstance> featureInstances;

	/**
	 * The cached value of the '{@link #getReferenceInstances() <em>Reference Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceRoleInstance> referenceInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassRoleInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePatternsPackage.Literals.CLASS_ROLE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassInterface getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (ClassInterface)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassInterface basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(ClassInterface newRole) {
		ClassInterface oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (EClass)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EClass newElement) {
		if (newElement!=null){
			EClass oldElement = element;
			element = newElement;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT, oldElement, element));
		} else {
			PatternInstance pi = (PatternInstance)this.eContainer();
			pi.getClassInstances().remove(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureRoleInstance> getFeatureInstances() {
		if (featureInstances == null) {
			featureInstances = new EObjectContainmentEList<FeatureRoleInstance>(FeatureRoleInstance.class, this, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES);
		}
		return featureInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceRoleInstance> getReferenceInstances() {
		if (referenceInstances == null) {
			referenceInstances = new EObjectContainmentEList<ReferenceRoleInstance>(ReferenceRoleInstance.class, this, RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES);
		}
		return referenceInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES:
				return ((InternalEList<?>)getFeatureInstances()).basicRemove(otherEnd, msgs);
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES:
				return ((InternalEList<?>)getReferenceInstances()).basicRemove(otherEnd, msgs);
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
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES:
				return getFeatureInstances();
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES:
				return getReferenceInstances();
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
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE:
				setRole((ClassInterface)newValue);
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT:
				setElement((EClass)newValue);
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES:
				getFeatureInstances().clear();
				getFeatureInstances().addAll((Collection<? extends FeatureRoleInstance>)newValue);
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES:
				getReferenceInstances().clear();
				getReferenceInstances().addAll((Collection<? extends ReferenceRoleInstance>)newValue);
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
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE:
				setRole((ClassInterface)null);
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT:
				setElement((EClass)null);
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES:
				getFeatureInstances().clear();
				return;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES:
				getReferenceInstances().clear();
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
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ROLE:
				return role != null;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__ELEMENT:
				return element != null;
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__FEATURE_INSTANCES:
				return featureInstances != null && !featureInstances.isEmpty();
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES:
				return referenceInstances != null && !referenceInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassRoleInstanceImpl
