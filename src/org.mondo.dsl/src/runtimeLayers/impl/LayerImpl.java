/**
 */
package runtimeLayers.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import runtimeLayers.Layer;
import runtimeLayers.PatternRoleDependece;
import runtimeLayers.RuntimeLayersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimeLayers.impl.LayerImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#isActivated <em>Activated</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#isVisualised <em>Visualised</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#getContent <em>Content</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#getPatternRole <em>Pattern Role</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerImpl#getUse <em>Use</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerImpl extends EObjectImpl implements Layer {
	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

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
	 * The default value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActivated() <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivated()
	 * @generated
	 * @ordered
	 */
	protected boolean activated = ACTIVATED_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisualised() <em>Visualised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisualised()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISUALISED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVisualised() <em>Visualised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisualised()
	 * @generated
	 * @ordered
	 */
	protected boolean visualised = VISUALISED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EObject content;

	/**
	 * The cached value of the '{@link #getPatternRole() <em>Pattern Role</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternRole()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternRoleDependece> patternRole;

	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected EList<Layer> use;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeLayersPackage.Literals.LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER__ORDER, oldOrder, order));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivated(boolean newActivated) {
		boolean oldActivated = activated;
		activated = newActivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER__ACTIVATED, oldActivated, activated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisualised() {
		return visualised;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualised(boolean newVisualised) {
		boolean oldVisualised = visualised;
		visualised = newVisualised;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER__VISUALISED, oldVisualised, visualised));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContent() {
		if (content != null && content.eIsProxy()) {
			InternalEObject oldContent = (InternalEObject)content;
			content = eResolveProxy(oldContent);
			if (content != oldContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimeLayersPackage.LAYER__CONTENT, oldContent, content));
			}
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(EObject newContent) {
		EObject oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternRoleDependece> getPatternRole() {
		if (patternRole == null) {
			patternRole = new EObjectResolvingEList<PatternRoleDependece>(PatternRoleDependece.class, this, RuntimeLayersPackage.LAYER__PATTERN_ROLE);
		}
		return patternRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Layer> getUse() {
		if (use == null) {
			use = new EObjectResolvingEList<Layer>(Layer.class, this, RuntimeLayersPackage.LAYER__USE);
		}
		return use;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimeLayersPackage.LAYER__ORDER:
				return getOrder();
			case RuntimeLayersPackage.LAYER__NAME:
				return getName();
			case RuntimeLayersPackage.LAYER__ACTIVATED:
				return isActivated();
			case RuntimeLayersPackage.LAYER__VISUALISED:
				return isVisualised();
			case RuntimeLayersPackage.LAYER__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
			case RuntimeLayersPackage.LAYER__PATTERN_ROLE:
				return getPatternRole();
			case RuntimeLayersPackage.LAYER__USE:
				return getUse();
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
			case RuntimeLayersPackage.LAYER__ORDER:
				setOrder((Integer)newValue);
				return;
			case RuntimeLayersPackage.LAYER__NAME:
				setName((String)newValue);
				return;
			case RuntimeLayersPackage.LAYER__ACTIVATED:
				setActivated((Boolean)newValue);
				return;
			case RuntimeLayersPackage.LAYER__VISUALISED:
				setVisualised((Boolean)newValue);
				return;
			case RuntimeLayersPackage.LAYER__CONTENT:
				setContent((EObject)newValue);
				return;
			case RuntimeLayersPackage.LAYER__PATTERN_ROLE:
				getPatternRole().clear();
				getPatternRole().addAll((Collection<? extends PatternRoleDependece>)newValue);
				return;
			case RuntimeLayersPackage.LAYER__USE:
				getUse().clear();
				getUse().addAll((Collection<? extends Layer>)newValue);
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
			case RuntimeLayersPackage.LAYER__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case RuntimeLayersPackage.LAYER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RuntimeLayersPackage.LAYER__ACTIVATED:
				setActivated(ACTIVATED_EDEFAULT);
				return;
			case RuntimeLayersPackage.LAYER__VISUALISED:
				setVisualised(VISUALISED_EDEFAULT);
				return;
			case RuntimeLayersPackage.LAYER__CONTENT:
				setContent((EObject)null);
				return;
			case RuntimeLayersPackage.LAYER__PATTERN_ROLE:
				getPatternRole().clear();
				return;
			case RuntimeLayersPackage.LAYER__USE:
				getUse().clear();
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
			case RuntimeLayersPackage.LAYER__ORDER:
				return order != ORDER_EDEFAULT;
			case RuntimeLayersPackage.LAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RuntimeLayersPackage.LAYER__ACTIVATED:
				return activated != ACTIVATED_EDEFAULT;
			case RuntimeLayersPackage.LAYER__VISUALISED:
				return visualised != VISUALISED_EDEFAULT;
			case RuntimeLayersPackage.LAYER__CONTENT:
				return content != null;
			case RuntimeLayersPackage.LAYER__PATTERN_ROLE:
				return patternRole != null && !patternRole.isEmpty();
			case RuntimeLayersPackage.LAYER__USE:
				return use != null && !use.isEmpty();
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
		result.append(" (order: ");
		result.append(order);
		result.append(", name: ");
		result.append(name);
		result.append(", activated: ");
		result.append(activated);
		result.append(", visualised: ");
		result.append(visualised);
		result.append(')');
		return result.toString();
	}

} //LayerImpl
