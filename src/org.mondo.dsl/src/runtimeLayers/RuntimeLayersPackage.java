/**
 */
package runtimeLayers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see runtimeLayers.RuntimeLayersFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import rtpat='http://mondo.org/runtimePatterns#/'"
 * @generated
 */
public interface RuntimeLayersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtimeLayers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/runtimeLayers";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rtlay";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeLayersPackage eINSTANCE = runtimeLayers.impl.RuntimeLayersPackageImpl.init();

	/**
	 * The meta object id for the '{@link runtimeLayers.impl.LayerSetImpl <em>Layer Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeLayers.impl.LayerSetImpl
	 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getLayerSet()
	 * @generated
	 */
	int LAYER_SET = 0;

	/**
	 * The feature id for the '<em><b>Background</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_SET__BACKGROUND = 0;

	/**
	 * The feature id for the '<em><b>User Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_SET__USER_LAYERS = 1;

	/**
	 * The number of structural features of the '<em>Layer Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link runtimeLayers.impl.LayerImpl <em>Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeLayers.impl.LayerImpl
	 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getLayer()
	 * @generated
	 */
	int LAYER = 3;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__ORDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__ACTIVATED = 2;

	/**
	 * The feature id for the '<em><b>Visualised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__VISUALISED = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__CONTENT = 4;

	/**
	 * The feature id for the '<em><b>Pattern Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__PATTERN_ROLE = 5;

	/**
	 * The feature id for the '<em><b>Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__USE = 6;

	/**
	 * The number of structural features of the '<em>Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link runtimeLayers.impl.BackgroundLayerImpl <em>Background Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeLayers.impl.BackgroundLayerImpl
	 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getBackgroundLayer()
	 * @generated
	 */
	int BACKGROUND_LAYER = 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__ORDER = LAYER__ORDER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__NAME = LAYER__NAME;

	/**
	 * The feature id for the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__ACTIVATED = LAYER__ACTIVATED;

	/**
	 * The feature id for the '<em><b>Visualised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__VISUALISED = LAYER__VISUALISED;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__CONTENT = LAYER__CONTENT;

	/**
	 * The feature id for the '<em><b>Pattern Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__PATTERN_ROLE = LAYER__PATTERN_ROLE;

	/**
	 * The feature id for the '<em><b>Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER__USE = LAYER__USE;

	/**
	 * The number of structural features of the '<em>Background Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_LAYER_FEATURE_COUNT = LAYER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link runtimeLayers.impl.UserLayerImpl <em>User Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeLayers.impl.UserLayerImpl
	 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getUserLayer()
	 * @generated
	 */
	int USER_LAYER = 2;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__ORDER = LAYER__ORDER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__NAME = LAYER__NAME;

	/**
	 * The feature id for the '<em><b>Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__ACTIVATED = LAYER__ACTIVATED;

	/**
	 * The feature id for the '<em><b>Visualised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__VISUALISED = LAYER__VISUALISED;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__CONTENT = LAYER__CONTENT;

	/**
	 * The feature id for the '<em><b>Pattern Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__PATTERN_ROLE = LAYER__PATTERN_ROLE;

	/**
	 * The feature id for the '<em><b>Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER__USE = LAYER__USE;

	/**
	 * The number of structural features of the '<em>User Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LAYER_FEATURE_COUNT = LAYER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link runtimeLayers.impl.PatternRoleDependeceImpl <em>Pattern Role Dependece</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimeLayers.impl.PatternRoleDependeceImpl
	 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getPatternRoleDependece()
	 * @generated
	 */
	int PATTERN_ROLE_DEPENDECE = 4;

	/**
	 * The feature id for the '<em><b>Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_DEPENDECE__USE = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_DEPENDECE__PATTERN = 1;

	/**
	 * The number of structural features of the '<em>Pattern Role Dependece</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_DEPENDECE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link runtimeLayers.LayerSet <em>Layer Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Set</em>'.
	 * @see runtimeLayers.LayerSet
	 * @generated
	 */
	EClass getLayerSet();

	/**
	 * Returns the meta object for the containment reference '{@link runtimeLayers.LayerSet#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background</em>'.
	 * @see runtimeLayers.LayerSet#getBackground()
	 * @see #getLayerSet()
	 * @generated
	 */
	EReference getLayerSet_Background();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimeLayers.LayerSet#getUserLayers <em>User Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Layers</em>'.
	 * @see runtimeLayers.LayerSet#getUserLayers()
	 * @see #getLayerSet()
	 * @generated
	 */
	EReference getLayerSet_UserLayers();

	/**
	 * Returns the meta object for class '{@link runtimeLayers.BackgroundLayer <em>Background Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Background Layer</em>'.
	 * @see runtimeLayers.BackgroundLayer
	 * @generated
	 */
	EClass getBackgroundLayer();

	/**
	 * Returns the meta object for class '{@link runtimeLayers.UserLayer <em>User Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Layer</em>'.
	 * @see runtimeLayers.UserLayer
	 * @generated
	 */
	EClass getUserLayer();

	/**
	 * Returns the meta object for class '{@link runtimeLayers.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer</em>'.
	 * @see runtimeLayers.Layer
	 * @generated
	 */
	EClass getLayer();

	/**
	 * Returns the meta object for the attribute '{@link runtimeLayers.Layer#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see runtimeLayers.Layer#getOrder()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Order();

	/**
	 * Returns the meta object for the attribute '{@link runtimeLayers.Layer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see runtimeLayers.Layer#getName()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Name();

	/**
	 * Returns the meta object for the attribute '{@link runtimeLayers.Layer#isActivated <em>Activated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activated</em>'.
	 * @see runtimeLayers.Layer#isActivated()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Activated();

	/**
	 * Returns the meta object for the attribute '{@link runtimeLayers.Layer#isVisualised <em>Visualised</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visualised</em>'.
	 * @see runtimeLayers.Layer#isVisualised()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Visualised();

	/**
	 * Returns the meta object for the reference '{@link runtimeLayers.Layer#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see runtimeLayers.Layer#getContent()
	 * @see #getLayer()
	 * @generated
	 */
	EReference getLayer_Content();

	/**
	 * Returns the meta object for the reference list '{@link runtimeLayers.Layer#getPatternRole <em>Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pattern Role</em>'.
	 * @see runtimeLayers.Layer#getPatternRole()
	 * @see #getLayer()
	 * @generated
	 */
	EReference getLayer_PatternRole();

	/**
	 * Returns the meta object for the reference list '{@link runtimeLayers.Layer#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use</em>'.
	 * @see runtimeLayers.Layer#getUse()
	 * @see #getLayer()
	 * @generated
	 */
	EReference getLayer_Use();

	/**
	 * Returns the meta object for class '{@link runtimeLayers.PatternRoleDependece <em>Pattern Role Dependece</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Role Dependece</em>'.
	 * @see runtimeLayers.PatternRoleDependece
	 * @generated
	 */
	EClass getPatternRoleDependece();

	/**
	 * Returns the meta object for the reference list '{@link runtimeLayers.PatternRoleDependece#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use</em>'.
	 * @see runtimeLayers.PatternRoleDependece#getUse()
	 * @see #getPatternRoleDependece()
	 * @generated
	 */
	EReference getPatternRoleDependece_Use();

	/**
	 * Returns the meta object for the reference '{@link runtimeLayers.PatternRoleDependece#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pattern</em>'.
	 * @see runtimeLayers.PatternRoleDependece#getPattern()
	 * @see #getPatternRoleDependece()
	 * @generated
	 */
	EReference getPatternRoleDependece_Pattern();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeLayersFactory getRuntimeLayersFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link runtimeLayers.impl.LayerSetImpl <em>Layer Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeLayers.impl.LayerSetImpl
		 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getLayerSet()
		 * @generated
		 */
		EClass LAYER_SET = eINSTANCE.getLayerSet();

		/**
		 * The meta object literal for the '<em><b>Background</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_SET__BACKGROUND = eINSTANCE.getLayerSet_Background();

		/**
		 * The meta object literal for the '<em><b>User Layers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_SET__USER_LAYERS = eINSTANCE.getLayerSet_UserLayers();

		/**
		 * The meta object literal for the '{@link runtimeLayers.impl.BackgroundLayerImpl <em>Background Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeLayers.impl.BackgroundLayerImpl
		 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getBackgroundLayer()
		 * @generated
		 */
		EClass BACKGROUND_LAYER = eINSTANCE.getBackgroundLayer();

		/**
		 * The meta object literal for the '{@link runtimeLayers.impl.UserLayerImpl <em>User Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeLayers.impl.UserLayerImpl
		 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getUserLayer()
		 * @generated
		 */
		EClass USER_LAYER = eINSTANCE.getUserLayer();

		/**
		 * The meta object literal for the '{@link runtimeLayers.impl.LayerImpl <em>Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeLayers.impl.LayerImpl
		 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getLayer()
		 * @generated
		 */
		EClass LAYER = eINSTANCE.getLayer();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__ORDER = eINSTANCE.getLayer_Order();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__NAME = eINSTANCE.getLayer_Name();

		/**
		 * The meta object literal for the '<em><b>Activated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__ACTIVATED = eINSTANCE.getLayer_Activated();

		/**
		 * The meta object literal for the '<em><b>Visualised</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__VISUALISED = eINSTANCE.getLayer_Visualised();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER__CONTENT = eINSTANCE.getLayer_Content();

		/**
		 * The meta object literal for the '<em><b>Pattern Role</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER__PATTERN_ROLE = eINSTANCE.getLayer_PatternRole();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER__USE = eINSTANCE.getLayer_Use();

		/**
		 * The meta object literal for the '{@link runtimeLayers.impl.PatternRoleDependeceImpl <em>Pattern Role Dependece</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimeLayers.impl.PatternRoleDependeceImpl
		 * @see runtimeLayers.impl.RuntimeLayersPackageImpl#getPatternRoleDependece()
		 * @generated
		 */
		EClass PATTERN_ROLE_DEPENDECE = eINSTANCE.getPatternRoleDependece();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_ROLE_DEPENDECE__USE = eINSTANCE.getPatternRoleDependece_Use();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_ROLE_DEPENDECE__PATTERN = eINSTANCE.getPatternRoleDependece_Pattern();

	}

} //RuntimeLayersPackage
