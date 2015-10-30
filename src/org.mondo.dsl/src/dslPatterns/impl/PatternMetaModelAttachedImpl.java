/**
 */
package dslPatterns.impl;

import dslPatterns.ClassInterfaceAttached;
import dslPatterns.DslPatternsPackage;
import dslPatterns.FeatureInterfaceAttached;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModelAttached;
import dslPatterns.ReferenceInterfaceAttached;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Meta Model Attached</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PatternMetaModelAttachedImpl#getClassIntAtt <em>Class Int Att</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternMetaModelAttachedImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternMetaModelAttachedImpl extends EObjectImpl implements PatternMetaModelAttached {
	/**
	 * The cached value of the '{@link #getClassIntAtt() <em>Class Int Att</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassIntAtt()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassInterfaceAttached> classIntAtt;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected Pattern content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternMetaModelAttachedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PATTERN_META_MODEL_ATTACHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassInterfaceAttached> getClassIntAtt() {
		if (classIntAtt == null) {
			classIntAtt = new EObjectContainmentEList<ClassInterfaceAttached>(ClassInterfaceAttached.class, this, DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT);
		}
		return classIntAtt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getContent() {
		if (content != null && content.eIsProxy()) {
			InternalEObject oldContent = (InternalEObject)content;
			content = (Pattern)eResolveProxy(oldContent);
			if (content != oldContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT, oldContent, content));
			}
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(Pattern newContent) {
		Pattern oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT:
				return ((InternalEList<?>)getClassIntAtt()).basicRemove(otherEnd, msgs);
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
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT:
				return getClassIntAtt();
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
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
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT:
				getClassIntAtt().clear();
				getClassIntAtt().addAll((Collection<? extends ClassInterfaceAttached>)newValue);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT:
				setContent((Pattern)newValue);
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
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT:
				getClassIntAtt().clear();
				return;
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT:
				setContent((Pattern)null);
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
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT:
				return classIntAtt != null && !classIntAtt.isEmpty();
			case DslPatternsPackage.PATTERN_META_MODEL_ATTACHED__CONTENT:
				return content != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternMetaModelAttachedImpl
