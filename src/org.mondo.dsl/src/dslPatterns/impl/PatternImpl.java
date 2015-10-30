/**
 */
package dslPatterns.impl;

import dslPatterns.ComplexFeatureAttached;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.ComplexFeature;
import dslPatterns.DslPatternsPackage;
import dslPatterns.Pattern;

import dslPatterns.Service;
import dslPatterns.Tag;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PatternImpl#getRootVariant <em>Root Variant</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternImpl#getServices <em>Services</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternImpl#getMaxInstances <em>Max Instances</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternImpl#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends EObjectImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getRootVariant() <em>Root Variant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootVariant()
	 * @generated
	 * @ordered
	 */
	protected ComplexFeatureMain rootVariant;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The default value of the '{@link #getMaxInstances() <em>Max Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInstances()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_INSTANCES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMaxInstances() <em>Max Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInstances()
	 * @generated
	 * @ordered
	 */
	protected int maxInstances = MAX_INSTANCES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexFeatureMain getRootVariant() {
		return rootVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootVariant(ComplexFeatureMain newRootVariant, NotificationChain msgs) {
		ComplexFeatureMain oldRootVariant = rootVariant;
		rootVariant = newRootVariant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN__ROOT_VARIANT, oldRootVariant, newRootVariant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootVariant(ComplexFeatureMain newRootVariant) {
		if (newRootVariant != rootVariant) {
			NotificationChain msgs = null;
			if (rootVariant != null)
				msgs = ((InternalEObject)rootVariant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN__ROOT_VARIANT, null, msgs);
			if (newRootVariant != null)
				msgs = ((InternalEObject)newRootVariant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN__ROOT_VARIANT, null, msgs);
			msgs = basicSetRootVariant(newRootVariant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN__ROOT_VARIANT, newRootVariant, newRootVariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<Service>(Service.class, this, DslPatternsPackage.PATTERN__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxInstances() {
		return maxInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInstances(int newMaxInstances) {
		int oldMaxInstances = maxInstances;
		maxInstances = newMaxInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN__MAX_INSTANCES, oldMaxInstances, maxInstances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectResolvingEList<Tag>(Tag.class, this, DslPatternsPackage.PATTERN__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN__ROOT_VARIANT:
				return basicSetRootVariant(null, msgs);
			case DslPatternsPackage.PATTERN__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
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
			case DslPatternsPackage.PATTERN__ROOT_VARIANT:
				return getRootVariant();
			case DslPatternsPackage.PATTERN__NAME:
				return getName();
			case DslPatternsPackage.PATTERN__DESCRIPTION:
				return getDescription();
			case DslPatternsPackage.PATTERN__SERVICES:
				return getServices();
			case DslPatternsPackage.PATTERN__MAX_INSTANCES:
				return getMaxInstances();
			case DslPatternsPackage.PATTERN__TAGS:
				return getTags();
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
			case DslPatternsPackage.PATTERN__ROOT_VARIANT:
				setRootVariant((ComplexFeatureMain)newValue);
				return;
			case DslPatternsPackage.PATTERN__NAME:
				setName((String)newValue);
				return;
			case DslPatternsPackage.PATTERN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DslPatternsPackage.PATTERN__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case DslPatternsPackage.PATTERN__MAX_INSTANCES:
				setMaxInstances((Integer)newValue);
				return;
			case DslPatternsPackage.PATTERN__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
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
			case DslPatternsPackage.PATTERN__ROOT_VARIANT:
				setRootVariant((ComplexFeatureMain)null);
				return;
			case DslPatternsPackage.PATTERN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DslPatternsPackage.PATTERN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DslPatternsPackage.PATTERN__SERVICES:
				getServices().clear();
				return;
			case DslPatternsPackage.PATTERN__MAX_INSTANCES:
				setMaxInstances(MAX_INSTANCES_EDEFAULT);
				return;
			case DslPatternsPackage.PATTERN__TAGS:
				getTags().clear();
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
			case DslPatternsPackage.PATTERN__ROOT_VARIANT:
				return rootVariant != null;
			case DslPatternsPackage.PATTERN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DslPatternsPackage.PATTERN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DslPatternsPackage.PATTERN__SERVICES:
				return services != null && !services.isEmpty();
			case DslPatternsPackage.PATTERN__MAX_INSTANCES:
				return maxInstances != MAX_INSTANCES_EDEFAULT;
			case DslPatternsPackage.PATTERN__TAGS:
				return tags != null && !tags.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", maxInstances: ");
		result.append(maxInstances);
		result.append(')');
		return result.toString();
	}

} //PatternImpl
