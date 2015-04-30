/**
 */
package runtimeLayers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtimeLayers.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeLayersFactoryImpl extends EFactoryImpl implements RuntimeLayersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeLayersFactory init() {
		try {
			RuntimeLayersFactory theRuntimeLayersFactory = (RuntimeLayersFactory)EPackage.Registry.INSTANCE.getEFactory("http://mondo.org/runtimeLayers"); 
			if (theRuntimeLayersFactory != null) {
				return theRuntimeLayersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeLayersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeLayersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RuntimeLayersPackage.LAYER_SET: return createLayerSet();
			case RuntimeLayersPackage.BACKGROUND_LAYER: return createBackgroundLayer();
			case RuntimeLayersPackage.USER_LAYER: return createUserLayer();
			case RuntimeLayersPackage.LAYER: return createLayer();
			case RuntimeLayersPackage.PATTERN_ROLE_DEPENDECE: return createPatternRoleDependece();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerSet createLayerSet() {
		LayerSetImpl layerSet = new LayerSetImpl();
		return layerSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BackgroundLayer createBackgroundLayer() {
		BackgroundLayerImpl backgroundLayer = new BackgroundLayerImpl();
		return backgroundLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserLayer createUserLayer() {
		UserLayerImpl userLayer = new UserLayerImpl();
		return userLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer createLayer() {
		LayerImpl layer = new LayerImpl();
		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRoleDependece createPatternRoleDependece() {
		PatternRoleDependeceImpl patternRoleDependece = new PatternRoleDependeceImpl();
		return patternRoleDependece;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeLayersPackage getRuntimeLayersPackage() {
		return (RuntimeLayersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimeLayersPackage getPackage() {
		return RuntimeLayersPackage.eINSTANCE;
	}

} //RuntimeLayersFactoryImpl
