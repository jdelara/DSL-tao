/**
 */
package serviceInterfaces.codegen;

import serviceInterfaces.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injector Acceptor Interface L1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link serviceInterfaces.codegen.InjectorAcceptorInterfaceL1#getInjectorProvides <em>Injector Provides</em>}</li>
 * </ul>
 *
 * @see serviceInterfaces.codegen.CodegenPackage#getInjectorAcceptorInterfaceL1()
 * @model
 * @generated
 */
public interface InjectorAcceptorInterfaceL1 extends Interface {
	/**
	 * Returns the value of the '<em><b>Injector Provides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injector Provides</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injector Provides</em>' reference.
	 * @see #setInjectorProvides(TransformationLibrary)
	 * @see serviceInterfaces.codegen.CodegenPackage#getInjectorAcceptorInterfaceL1_InjectorProvides()
	 * @model
	 * @generated
	 */
	TransformationLibrary getInjectorProvides();

	/**
	 * Sets the value of the '{@link serviceInterfaces.codegen.InjectorAcceptorInterfaceL1#getInjectorProvides <em>Injector Provides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Injector Provides</em>' reference.
	 * @see #getInjectorProvides()
	 * @generated
	 */
	void setInjectorProvides(TransformationLibrary value);

} // InjectorAcceptorInterfaceL1
