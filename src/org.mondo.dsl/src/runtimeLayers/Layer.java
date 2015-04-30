/**
 */
package runtimeLayers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtimeLayers.Layer#getOrder <em>Order</em>}</li>
 *   <li>{@link runtimeLayers.Layer#getName <em>Name</em>}</li>
 *   <li>{@link runtimeLayers.Layer#isActivated <em>Activated</em>}</li>
 *   <li>{@link runtimeLayers.Layer#isVisualised <em>Visualised</em>}</li>
 *   <li>{@link runtimeLayers.Layer#getContent <em>Content</em>}</li>
 *   <li>{@link runtimeLayers.Layer#getPatternRole <em>Pattern Role</em>}</li>
 *   <li>{@link runtimeLayers.Layer#getUse <em>Use</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtimeLayers.RuntimeLayersPackage#getLayer()
 * @model
 * @generated
 */
public interface Layer extends EObject {
	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Order()
	 * @model required="true"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link runtimeLayers.Layer#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link runtimeLayers.Layer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activated</em>' attribute.
	 * @see #setActivated(boolean)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Activated()
	 * @model
	 * @generated
	 */
	boolean isActivated();

	/**
	 * Sets the value of the '{@link runtimeLayers.Layer#isActivated <em>Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activated</em>' attribute.
	 * @see #isActivated()
	 * @generated
	 */
	void setActivated(boolean value);

	/**
	 * Returns the value of the '<em><b>Visualised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visualised</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visualised</em>' attribute.
	 * @see #setVisualised(boolean)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Visualised()
	 * @model
	 * @generated
	 */
	boolean isVisualised();

	/**
	 * Sets the value of the '{@link runtimeLayers.Layer#isVisualised <em>Visualised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visualised</em>' attribute.
	 * @see #isVisualised()
	 * @generated
	 */
	void setVisualised(boolean value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(EObject)
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Content()
	 * @model
	 * @generated
	 */
	EObject getContent();

	/**
	 * Sets the value of the '{@link runtimeLayers.Layer#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(EObject value);

	/**
	 * Returns the value of the '<em><b>Pattern Role</b></em>' reference list.
	 * The list contents are of type {@link runtimeLayers.PatternRoleDependece}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Role</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Role</em>' reference list.
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_PatternRole()
	 * @model
	 * @generated
	 */
	EList<PatternRoleDependece> getPatternRole();

	/**
	 * Returns the value of the '<em><b>Use</b></em>' reference list.
	 * The list contents are of type {@link runtimeLayers.Layer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use</em>' reference list.
	 * @see runtimeLayers.RuntimeLayersPackage#getLayer_Use()
	 * @model
	 * @generated
	 */
	EList<Layer> getUse();

} // Layer
