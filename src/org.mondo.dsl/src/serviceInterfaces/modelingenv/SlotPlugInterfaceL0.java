/**
 */
package serviceInterfaces.modelingenv;

import org.eclipse.emf.common.util.EList;

import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot Plug Interface L0</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.modelingenv.SlotPlugInterfaceL0#getSlot <em>Slot</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getSlotPlugInterfaceL0()
 * @model
 * @generated
 */
public interface SlotPlugInterfaceL0 extends Interface {
	/**
	 * Returns the value of the '<em><b>Slot</b></em>' containment reference list.
	 * The list contents are of type {@link serviceInterfaces.modelingenv.ExtensionPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' containment reference list.
	 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getSlotPlugInterfaceL0_Slot()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExtensionPoint> getSlot();

} // SlotPlugInterfaceL0
