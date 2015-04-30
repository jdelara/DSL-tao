/**
 */
package runtimeLayers.impl;

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

import runtimeLayers.BackgroundLayer;
import runtimeLayers.LayerSet;
import runtimeLayers.RuntimeLayersPackage;
import runtimeLayers.UserLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtimeLayers.impl.LayerSetImpl#getBackground <em>Background</em>}</li>
 *   <li>{@link runtimeLayers.impl.LayerSetImpl#getUserLayers <em>User Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerSetImpl extends EObjectImpl implements LayerSet {
	/**
	 * The cached value of the '{@link #getBackground() <em>Background</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected BackgroundLayer background;

	/**
	 * The cached value of the '{@link #getUserLayers() <em>User Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<UserLayer> userLayers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeLayersPackage.Literals.LAYER_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BackgroundLayer getBackground() {
		return background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackground(BackgroundLayer newBackground, NotificationChain msgs) {
		BackgroundLayer oldBackground = background;
		background = newBackground;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER_SET__BACKGROUND, oldBackground, newBackground);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackground(BackgroundLayer newBackground) {
		if (newBackground != background) {
			NotificationChain msgs = null;
			if (background != null)
				msgs = ((InternalEObject)background).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RuntimeLayersPackage.LAYER_SET__BACKGROUND, null, msgs);
			if (newBackground != null)
				msgs = ((InternalEObject)newBackground).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RuntimeLayersPackage.LAYER_SET__BACKGROUND, null, msgs);
			msgs = basicSetBackground(newBackground, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeLayersPackage.LAYER_SET__BACKGROUND, newBackground, newBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserLayer> getUserLayers() {
		if (userLayers == null) {
			userLayers = new EObjectContainmentEList<UserLayer>(UserLayer.class, this, RuntimeLayersPackage.LAYER_SET__USER_LAYERS);
		}
		return userLayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimeLayersPackage.LAYER_SET__BACKGROUND:
				return basicSetBackground(null, msgs);
			case RuntimeLayersPackage.LAYER_SET__USER_LAYERS:
				return ((InternalEList<?>)getUserLayers()).basicRemove(otherEnd, msgs);
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
			case RuntimeLayersPackage.LAYER_SET__BACKGROUND:
				return getBackground();
			case RuntimeLayersPackage.LAYER_SET__USER_LAYERS:
				return getUserLayers();
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
			case RuntimeLayersPackage.LAYER_SET__BACKGROUND:
				setBackground((BackgroundLayer)newValue);
				return;
			case RuntimeLayersPackage.LAYER_SET__USER_LAYERS:
				getUserLayers().clear();
				getUserLayers().addAll((Collection<? extends UserLayer>)newValue);
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
			case RuntimeLayersPackage.LAYER_SET__BACKGROUND:
				setBackground((BackgroundLayer)null);
				return;
			case RuntimeLayersPackage.LAYER_SET__USER_LAYERS:
				getUserLayers().clear();
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
			case RuntimeLayersPackage.LAYER_SET__BACKGROUND:
				return background != null;
			case RuntimeLayersPackage.LAYER_SET__USER_LAYERS:
				return userLayers != null && !userLayers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayerSetImpl
