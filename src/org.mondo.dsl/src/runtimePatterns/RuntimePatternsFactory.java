/**
 */
package runtimePatterns;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtimePatterns.RuntimePatternsPackage
 * @generated
 */
public interface RuntimePatternsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePatternsFactory eINSTANCE = runtimePatterns.impl.RuntimePatternsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pattern Instances</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Instances</em>'.
	 * @generated
	 */
	PatternInstances createPatternInstances();

	/**
	 * Returns a new object of class '<em>Pattern Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Instance</em>'.
	 * @generated
	 */
	PatternInstance createPatternInstance();

	/**
	 * Returns a new object of class '<em>Class Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Role Instance</em>'.
	 * @generated
	 */
	ClassRoleInstance createClassRoleInstance();

	/**
	 * Returns a new object of class '<em>Instance Feature Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Feature Role Instance</em>'.
	 * @generated
	 */
	InstanceFeatureRoleInstance createInstanceFeatureRoleInstance();

	/**
	 * Returns a new object of class '<em>Type Feature Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Feature Role Instance</em>'.
	 * @generated
	 */
	TypeFeatureRoleInstance createTypeFeatureRoleInstance();

	/**
	 * Returns a new object of class '<em>Reference Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Role Instance</em>'.
	 * @generated
	 */
	ReferenceRoleInstance createReferenceRoleInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RuntimePatternsPackage getRuntimePatternsPackage();

} //RuntimePatternsFactory
