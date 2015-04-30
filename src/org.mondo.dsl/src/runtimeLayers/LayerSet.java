/**
 */
package runtimeLayers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeLayers.LayerSet#getBackground <em>Background</em>}</li>
 *   <li>{@link runtimeLayers.LayerSet#getUserLayers <em>User Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeLayers.RuntimeLayersPackage#getLayerSet()
 * @model
 * @generated
 */
public interface LayerSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Background</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background</em>' containment reference.
	 * @see #setBackground(BackgroundLayer)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayerSet_Background()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BackgroundLayer getBackground();

	/**
	 * Sets the value of the '{@link runtimeLayers.LayerSet#getBackground <em>Background</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background</em>' containment reference.
	 * @see #getBackground()
	 * @generated
	 */
	void setBackground(BackgroundLayer value);

	/**
	 * Returns the value of the '<em><b>User Layers</b></em>' containment reference list.
	 * The list contents are of type {@link runtimeLayers.UserLayer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Layers</em>' containment reference list.
	 * @see runtimeLayers.RuntimeLayersPackage#getLayerSet_UserLayers()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserLayer> getUserLayers();

} // LayerSet
