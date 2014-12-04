/**
 */
package serviceInterfaces.codegen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.codegen.CodegenPackage
 * @generated
 */
public interface CodegenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenFactory eINSTANCE = serviceInterfaces.codegen.impl.CodegenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Injector Acceptor Interface L1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injector Acceptor Interface L1</em>'.
	 * @generated
	 */
	InjectorAcceptorInterfaceL1 createInjectorAcceptorInterfaceL1();

	/**
	 * Returns a new object of class '<em>Transformation Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Library</em>'.
	 * @generated
	 */
	TransformationLibrary createTransformationLibrary();

	/**
	 * Returns a new object of class '<em>Slot Plug Interface L1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot Plug Interface L1</em>'.
	 * @generated
	 */
	SlotPlugInterfaceL1 createSlotPlugInterfaceL1();

	/**
	 * Returns a new object of class '<em>Class Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Pointcut</em>'.
	 * @generated
	 */
	ClassPointcut createClassPointcut();

	/**
	 * Returns a new object of class '<em>Method Poincut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Poincut</em>'.
	 * @generated
	 */
	MethodPoincut createMethodPoincut();

	/**
	 * Returns a new object of class '<em>Import Element Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Element Pointcut</em>'.
	 * @generated
	 */
	ImportElementPointcut createImportElementPointcut();

	/**
	 * Returns a new object of class '<em>Statement Poincut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Poincut</em>'.
	 * @generated
	 */
	StatementPoincut createStatementPoincut();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodegenPackage getCodegenPackage();

} //CodegenFactory
