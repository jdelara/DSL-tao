/**
 */
package runtimeLayers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtimeLayers.RuntimeLayersPackage
 * @generated
 */
public interface RuntimeLayersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeLayersFactory eINSTANCE = runtimeLayers.impl.RuntimeLayersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Layer Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Set</em>'.
	 * @generated
	 */
	LayerSet createLayerSet();

	/**
	 * Returns a new object of class '<em>Background Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Background Layer</em>'.
	 * @generated
	 */
	BackgroundLayer createBackgroundLayer();

	/**
	 * Returns a new object of class '<em>User Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Layer</em>'.
	 * @generated
	 */
	UserLayer createUserLayer();

	/**
	 * Returns a new object of class '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer</em>'.
	 * @generated
	 */
	Layer createLayer();

	/**
	 * Returns a new object of class '<em>Pattern Role Dependece</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Role Dependece</em>'.
	 * @generated
	 */
	PatternRoleDependece createPatternRoleDependece();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RuntimeLayersPackage getRuntimeLayersPackage();

} //RuntimeLayersFactory
