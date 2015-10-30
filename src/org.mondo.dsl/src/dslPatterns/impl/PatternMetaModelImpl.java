/**
 */
package dslPatterns.impl;

import dslPatterns.ClassInterface;
import dslPatterns.ComplexFeatureAttached;
import dslPatterns.DslPatternsPackage;
import dslPatterns.FeatureInterface;
import dslPatterns.PatternMetaModel;
import dslPatterns.ReferenceInterface;
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
 * An implementation of the model object '<em><b>Pattern Meta Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PatternMetaModelImpl#getClassInterfaces <em>Class Interfaces</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternMetaModelImpl#getAttrInterfaces <em>Attr Interfaces</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternMetaModelImpl#getRefInterfaces <em>Ref Interfaces</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternMetaModelImpl#getImg <em>Img</em>}</li>
 *   <li>{@link dslPatterns.impl.PatternMetaModelImpl#getRootAttachedVariant <em>Root Attached Variant</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PatternMetaModelImpl extends EObjectImpl implements PatternMetaModel {
	/**
	 * The cached value of the '{@link #getClassInterfaces() <em>Class Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassInterface> classInterfaces;

	/**
	 * The cached value of the '{@link #getAttrInterfaces() <em>Attr Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureInterface> attrInterfaces;

	/**
	 * The cached value of the '{@link #getRefInterfaces() <em>Ref Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceInterface> refInterfaces;

	/**
	 * The default value of the '{@link #getImg() <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImg()
	 * @generated
	 * @ordered
	 */
	protected static final String IMG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImg() <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImg()
	 * @generated
	 * @ordered
	 */
	protected String img = IMG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRootAttachedVariant() <em>Root Attached Variant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootAttachedVariant()
	 * @generated
	 * @ordered
	 */
	protected ComplexFeatureAttached rootAttachedVariant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternMetaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PATTERN_META_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassInterface> getClassInterfaces() {
		if (classInterfaces == null) {
			classInterfaces = new EObjectContainmentEList<ClassInterface>(ClassInterface.class, this, DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES);
		}
		return classInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureInterface> getAttrInterfaces() {
		if (attrInterfaces == null) {
			attrInterfaces = new EObjectContainmentEList<FeatureInterface>(FeatureInterface.class, this, DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES);
		}
		return attrInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceInterface> getRefInterfaces() {
		if (refInterfaces == null) {
			refInterfaces = new EObjectContainmentEList<ReferenceInterface>(ReferenceInterface.class, this, DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES);
		}
		return refInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImg() {
		return img;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImg(String newImg) {
		String oldImg = img;
		img = newImg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_META_MODEL__IMG, oldImg, img));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexFeatureAttached getRootAttachedVariant() {
		return rootAttachedVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootAttachedVariant(ComplexFeatureAttached newRootAttachedVariant, NotificationChain msgs) {
		ComplexFeatureAttached oldRootAttachedVariant = rootAttachedVariant;
		rootAttachedVariant = newRootAttachedVariant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT, oldRootAttachedVariant, newRootAttachedVariant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootAttachedVariant(ComplexFeatureAttached newRootAttachedVariant) {
		if (newRootAttachedVariant != rootAttachedVariant) {
			NotificationChain msgs = null;
			if (rootAttachedVariant != null)
				msgs = ((InternalEObject)rootAttachedVariant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT, null, msgs);
			if (newRootAttachedVariant != null)
				msgs = ((InternalEObject)newRootAttachedVariant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT, null, msgs);
			msgs = basicSetRootAttachedVariant(newRootAttachedVariant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT, newRootAttachedVariant, newRootAttachedVariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES:
				return ((InternalEList<?>)getClassInterfaces()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES:
				return ((InternalEList<?>)getAttrInterfaces()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES:
				return ((InternalEList<?>)getRefInterfaces()).basicRemove(otherEnd, msgs);
			case DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT:
				return basicSetRootAttachedVariant(null, msgs);
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
			case DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES:
				return getClassInterfaces();
			case DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES:
				return getAttrInterfaces();
			case DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES:
				return getRefInterfaces();
			case DslPatternsPackage.PATTERN_META_MODEL__IMG:
				return getImg();
			case DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT:
				return getRootAttachedVariant();
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
			case DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES:
				getClassInterfaces().clear();
				getClassInterfaces().addAll((Collection<? extends ClassInterface>)newValue);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES:
				getAttrInterfaces().clear();
				getAttrInterfaces().addAll((Collection<? extends FeatureInterface>)newValue);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES:
				getRefInterfaces().clear();
				getRefInterfaces().addAll((Collection<? extends ReferenceInterface>)newValue);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__IMG:
				setImg((String)newValue);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT:
				setRootAttachedVariant((ComplexFeatureAttached)newValue);
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
			case DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES:
				getClassInterfaces().clear();
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES:
				getAttrInterfaces().clear();
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES:
				getRefInterfaces().clear();
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__IMG:
				setImg(IMG_EDEFAULT);
				return;
			case DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT:
				setRootAttachedVariant((ComplexFeatureAttached)null);
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
			case DslPatternsPackage.PATTERN_META_MODEL__CLASS_INTERFACES:
				return classInterfaces != null && !classInterfaces.isEmpty();
			case DslPatternsPackage.PATTERN_META_MODEL__ATTR_INTERFACES:
				return attrInterfaces != null && !attrInterfaces.isEmpty();
			case DslPatternsPackage.PATTERN_META_MODEL__REF_INTERFACES:
				return refInterfaces != null && !refInterfaces.isEmpty();
			case DslPatternsPackage.PATTERN_META_MODEL__IMG:
				return IMG_EDEFAULT == null ? img != null : !IMG_EDEFAULT.equals(img);
			case DslPatternsPackage.PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT:
				return rootAttachedVariant != null;
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
		result.append(" (img: ");
		result.append(img);
		result.append(')');
		return result.toString();
	}

} //PatternMetaModelImpl
