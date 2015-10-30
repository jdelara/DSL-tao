/**
 */
package dslPatterns.impl;

import dslPatterns.DslPatternsPackage;
import dslPatterns.MMInterface;

import dslPatterns.MMInterfaceAttached;
import java.math.BigInteger;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MM Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.MMInterfaceImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link dslPatterns.impl.MMInterfaceImpl#getMinCard <em>Min Card</em>}</li>
 *   <li>{@link dslPatterns.impl.MMInterfaceImpl#getMaxCard <em>Max Card</em>}</li>
 *   <li>{@link dslPatterns.impl.MMInterfaceImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MMInterfaceImpl extends EObjectImpl implements MMInterface {
	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinCard() <em>Min Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCard()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_CARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinCard() <em>Min Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCard()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minCard = MIN_CARD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCard() <em>Max Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCard()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_CARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxCard() <em>Max Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCard()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxCard = MAX_CARD_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.MM_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.MM_INTERFACE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinCard() {
		return minCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCard(BigInteger newMinCard) {
		BigInteger oldMinCard = minCard;
		minCard = newMinCard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.MM_INTERFACE__MIN_CARD, oldMinCard, minCard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxCard() {
		return maxCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCard(BigInteger newMaxCard) {
		BigInteger oldMaxCard = maxCard;
		maxCard = newMaxCard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.MM_INTERFACE__MAX_CARD, oldMaxCard, maxCard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.MM_INTERFACE__CONSTRAINT, oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.MM_INTERFACE__ICON:
				return getIcon();
			case DslPatternsPackage.MM_INTERFACE__MIN_CARD:
				return getMinCard();
			case DslPatternsPackage.MM_INTERFACE__MAX_CARD:
				return getMaxCard();
			case DslPatternsPackage.MM_INTERFACE__CONSTRAINT:
				return getConstraint();
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
			case DslPatternsPackage.MM_INTERFACE__ICON:
				setIcon((String)newValue);
				return;
			case DslPatternsPackage.MM_INTERFACE__MIN_CARD:
				setMinCard((BigInteger)newValue);
				return;
			case DslPatternsPackage.MM_INTERFACE__MAX_CARD:
				setMaxCard((BigInteger)newValue);
				return;
			case DslPatternsPackage.MM_INTERFACE__CONSTRAINT:
				setConstraint((String)newValue);
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
			case DslPatternsPackage.MM_INTERFACE__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case DslPatternsPackage.MM_INTERFACE__MIN_CARD:
				setMinCard(MIN_CARD_EDEFAULT);
				return;
			case DslPatternsPackage.MM_INTERFACE__MAX_CARD:
				setMaxCard(MAX_CARD_EDEFAULT);
				return;
			case DslPatternsPackage.MM_INTERFACE__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
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
			case DslPatternsPackage.MM_INTERFACE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case DslPatternsPackage.MM_INTERFACE__MIN_CARD:
				return MIN_CARD_EDEFAULT == null ? minCard != null : !MIN_CARD_EDEFAULT.equals(minCard);
			case DslPatternsPackage.MM_INTERFACE__MAX_CARD:
				return MAX_CARD_EDEFAULT == null ? maxCard != null : !MAX_CARD_EDEFAULT.equals(maxCard);
			case DslPatternsPackage.MM_INTERFACE__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null ? constraint != null : !CONSTRAINT_EDEFAULT.equals(constraint);
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
		result.append(" (icon: ");
		result.append(icon);
		result.append(", minCard: ");
		result.append(minCard);
		result.append(", maxCard: ");
		result.append(maxCard);
		result.append(", constraint: ");
		result.append(constraint);
		result.append(')');
		return result.toString();
	}

} //MMInterfaceImpl
