/**
 */
package dslPatterns.impl;

import dslPatterns.DslPatternsPackage;
import dslPatterns.Port;
import java.math.BigInteger;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link dslPatterns.impl.PortImpl#getMinCard <em>Min Card</em>}</li>
 *   <li>{@link dslPatterns.impl.PortImpl#getMaxCard <em>Max Card</em>}</li>
 *   <li>{@link dslPatterns.impl.PortImpl#getUses <em>Uses</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PortImpl extends EObjectImpl implements Port {
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
	 * The default value of the '{@link #getMinCard() <em>Min Card</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCard()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_CARD_EDEFAULT = new BigInteger("0");

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
	protected static final BigInteger MAX_CARD_EDEFAULT = new BigInteger("-1");

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
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> uses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PORT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PORT__MIN_CARD, oldMinCard, minCard));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPatternsPackage.PORT__MAX_CARD, oldMaxCard, maxCard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getUses() {
		if (uses == null) {
			uses = new EObjectResolvingEList<Interface>(Interface.class, this, DslPatternsPackage.PORT__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.PORT__NAME:
				return getName();
			case DslPatternsPackage.PORT__MIN_CARD:
				return getMinCard();
			case DslPatternsPackage.PORT__MAX_CARD:
				return getMaxCard();
			case DslPatternsPackage.PORT__USES:
				return getUses();
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
			case DslPatternsPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case DslPatternsPackage.PORT__MIN_CARD:
				setMinCard((BigInteger)newValue);
				return;
			case DslPatternsPackage.PORT__MAX_CARD:
				setMaxCard((BigInteger)newValue);
				return;
			case DslPatternsPackage.PORT__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends Interface>)newValue);
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
			case DslPatternsPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DslPatternsPackage.PORT__MIN_CARD:
				setMinCard(MIN_CARD_EDEFAULT);
				return;
			case DslPatternsPackage.PORT__MAX_CARD:
				setMaxCard(MAX_CARD_EDEFAULT);
				return;
			case DslPatternsPackage.PORT__USES:
				getUses().clear();
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
			case DslPatternsPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DslPatternsPackage.PORT__MIN_CARD:
				return MIN_CARD_EDEFAULT == null ? minCard != null : !MIN_CARD_EDEFAULT.equals(minCard);
			case DslPatternsPackage.PORT__MAX_CARD:
				return MAX_CARD_EDEFAULT == null ? maxCard != null : !MAX_CARD_EDEFAULT.equals(maxCard);
			case DslPatternsPackage.PORT__USES:
				return uses != null && !uses.isEmpty();
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
		result.append(", minCard: ");
		result.append(minCard);
		result.append(", maxCard: ");
		result.append(maxCard);
		result.append(')');
		return result.toString();
	}

} //PortImpl
