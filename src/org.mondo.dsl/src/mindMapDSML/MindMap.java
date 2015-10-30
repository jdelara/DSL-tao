/**
 */
package mindMapDSML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mind Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindMapDSML.MindMap#getIdeas <em>Ideas</em>}</li>
 *   <li>{@link mindMapDSML.MindMap#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see mindMapDSML.MindMapDSMLPackage#getMindMap()
 * @model
 * @generated
 */
public interface MindMap extends EObject {
	/**
	 * Returns the value of the '<em><b>Ideas</b></em>' containment reference list.
	 * The list contents are of type {@link mindMapDSML.Idea}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ideas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ideas</em>' containment reference list.
	 * @see mindMapDSML.MindMapDSMLPackage#getMindMap_Ideas()
	 * @model containment="true"
	 * @generated
	 */
	EList<Idea> getIdeas();

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
	 * @see mindMapDSML.MindMapDSMLPackage#getMindMap_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mindMapDSML.MindMap#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MindMap
