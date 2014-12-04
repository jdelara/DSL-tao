/**
 */
package dslPatterns.impl;

import dslPatterns.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslPatternsFactoryImpl extends EFactoryImpl implements DslPatternsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DslPatternsFactory init() {
		try {
			DslPatternsFactory theDslPatternsFactory = (DslPatternsFactory)EPackage.Registry.INSTANCE.getEFactory(DslPatternsPackage.eNS_URI);
			if (theDslPatternsFactory != null) {
				return theDslPatternsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DslPatternsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DslPatternsFactoryImpl() {
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
			case DslPatternsPackage.PATTERN_SET: return createPatternSet();
			case DslPatternsPackage.CATEGORY: return createCategory();
			case DslPatternsPackage.PATTERN: return createPattern();
			case DslPatternsPackage.SERVICE: return createService();
			case DslPatternsPackage.PLUG: return createPlug();
			case DslPatternsPackage.SLOT: return createSlot();
			case DslPatternsPackage.INJECTOR: return createInjector();
			case DslPatternsPackage.ACCEPTOR: return createAcceptor();
			case DslPatternsPackage.SIMPLE_FEATURE: return createSimpleFeature();
			case DslPatternsPackage.COMPLEX_FEATURE: return createComplexFeature();
			case DslPatternsPackage.PATTERN_META_MODEL_REFERENCE: return createPatternMetaModelReference();
			case DslPatternsPackage.META_MODEL: return createMetaModel();
			case DslPatternsPackage.CLASS_INTERFACE: return createClassInterface();
			case DslPatternsPackage.FEATURE_TYPE: return createFeatureType();
			case DslPatternsPackage.FEATURE_INSTANCE: return createFeatureInstance();
			case DslPatternsPackage.REFERENCE_INTERFACE: return createReferenceInterface();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DslPatternsPackage.FEATURE_KIND:
				return createFeatureKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DslPatternsPackage.FEATURE_KIND:
				return convertFeatureKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternSet createPatternSet() {
		PatternSetImpl patternSet = new PatternSetImpl();
		return patternSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plug createPlug() {
		PlugImpl plug = new PlugImpl();
		return plug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot createSlot() {
		SlotImpl slot = new SlotImpl();
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Injector createInjector() {
		InjectorImpl injector = new InjectorImpl();
		return injector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Acceptor createAcceptor() {
		AcceptorImpl acceptor = new AcceptorImpl();
		return acceptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleFeature createSimpleFeature() {
		SimpleFeatureImpl simpleFeature = new SimpleFeatureImpl();
		return simpleFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexFeature createComplexFeature() {
		ComplexFeatureImpl complexFeature = new ComplexFeatureImpl();
		return complexFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMetaModelReference createPatternMetaModelReference() {
		PatternMetaModelReferenceImpl patternMetaModelReference = new PatternMetaModelReferenceImpl();
		return patternMetaModelReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel createMetaModel() {
		MetaModelImpl metaModel = new MetaModelImpl();
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassInterface createClassInterface() {
		ClassInterfaceImpl classInterface = new ClassInterfaceImpl();
		return classInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType createFeatureType() {
		FeatureTypeImpl featureType = new FeatureTypeImpl();
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance createFeatureInstance() {
		FeatureInstanceImpl featureInstance = new FeatureInstanceImpl();
		return featureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceInterface createReferenceInterface() {
		ReferenceInterfaceImpl referenceInterface = new ReferenceInterfaceImpl();
		return referenceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureKind createFeatureKindFromString(EDataType eDataType, String initialValue) {
		FeatureKind result = FeatureKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DslPatternsPackage getDslPatternsPackage() {
		return (DslPatternsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DslPatternsPackage getPackage() {
		return DslPatternsPackage.eINSTANCE;
	}

} //DslPatternsFactoryImpl
