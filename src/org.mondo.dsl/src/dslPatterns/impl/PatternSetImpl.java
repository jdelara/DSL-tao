/**
 */
package dslPatterns.impl;

import dslPatterns.Category;
import dslPatterns.DslPatternsPackage;
import dslPatterns.PatternSet;

import dslPatterns.Tag;
import dslPatterns.TagSet;
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
 * An implementation of the model object '<em><b>Pattern Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PatternSetImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternSetImpl#getTagSet <em>Tag Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternSetImpl extends EObjectImpl implements PatternSet {
	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

	/**
	 * The cached value of the '{@link #getTagSet() <em>Tag Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagSet()
	 * @generated
	 * @ordered
	 */
	protected TagSet tagSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PATTERN_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<Category>(Category.class, this, DslPatternsPackage.PATTERN_SET__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagSet getTagSet() {
		return tagSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTagSet(TagSet newTagSet, NotificationChain msgs) {
		TagSet oldTagSet = tagSet;
		tagSet = newTagSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_SET__TAG_SET, oldTagSet, newTagSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTagSet(TagSet newTagSet) {
		if (newTagSet != tagSet) {
			NotificationChain msgs = null;
			if (tagSet != null)
				msgs = ((InternalEObject)tagSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN_SET__TAG_SET, null, msgs);
			if (newTagSet != null)
				msgs = ((InternalEObject)newTagSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN_SET__TAG_SET, null, msgs);
			msgs = basicSetTagSet(newTagSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_SET__TAG_SET, newTagSet, newTagSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_SET__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.PATTERN_SET__TAG_SET:
				return basicSetTagSet(null, msgs);
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
			case DslPatternsPackage.PATTERN_SET__CATEGORIES:
				return getCategories();
			case DslPatternsPackage.PATTERN_SET__TAG_SET:
				return getTagSet();
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
			case DslPatternsPackage.PATTERN_SET__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case DslPatternsPackage.PATTERN_SET__TAG_SET:
				setTagSet((TagSet)newValue);
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
			case DslPatternsPackage.PATTERN_SET__CATEGORIES:
				getCategories().clear();
				return;
			case DslPatternsPackage.PATTERN_SET__TAG_SET:
				setTagSet((TagSet)null);
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
			case DslPatternsPackage.PATTERN_SET__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case DslPatternsPackage.PATTERN_SET__TAG_SET:
				return tagSet != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternSetImpl
