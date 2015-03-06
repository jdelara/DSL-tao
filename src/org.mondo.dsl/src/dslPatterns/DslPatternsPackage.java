/**
 */
package dslPatterns;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see dslPatterns.DslPatternsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface DslPatternsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dslPatterns";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/dslPatterns";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dslpat";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DslPatternsPackage eINSTANCE = dslPatterns.impl.DslPatternsPackageImpl.init();

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PatternSetImpl <em>Pattern Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PatternSetImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternSet()
	 * @generated
	 */
	int PATTERN_SET = 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SET__CATEGORIES = 0;

	/**
	 * The number of structural features of the '<em>Pattern Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.CategoryImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Subcategories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SUBCATEGORIES = 2;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PATTERNS = 3;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PatternImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Root Variant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ROOT_VARIANT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__SERVICES = 3;

	/**
	 * The feature id for the '<em><b>Max Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__MAX_INSTANCES = 4;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.ServiceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__MANDATORY = 2;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PORTS = 3;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PortImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MIN_CARD = 1;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MAX_CARD = 2;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__USES = 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PlugImpl <em>Plug</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PlugImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPlug()
	 * @generated
	 */
	int PLUG = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__MIN_CARD = PORT__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__MAX_CARD = PORT__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__USES = PORT__USES;

	/**
	 * The number of structural features of the '<em>Plug</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.SlotImpl <em>Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.SlotImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getSlot()
	 * @generated
	 */
	int SLOT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__MIN_CARD = PORT__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__MAX_CARD = PORT__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__USES = PORT__USES;

	/**
	 * The number of structural features of the '<em>Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.InjectorImpl <em>Injector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.InjectorImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getInjector()
	 * @generated
	 */
	int INJECTOR = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR__MIN_CARD = PORT__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR__MAX_CARD = PORT__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR__USES = PORT__USES;

	/**
	 * The number of structural features of the '<em>Injector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTOR_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.AcceptorImpl <em>Acceptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.AcceptorImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getAcceptor()
	 * @generated
	 */
	int ACCEPTOR = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTOR__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTOR__MIN_CARD = PORT__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTOR__MAX_CARD = PORT__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTOR__USES = PORT__USES;

	/**
	 * The number of structural features of the '<em>Acceptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTOR_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.VariantImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.SimpleFeatureImpl <em>Simple Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.SimpleFeatureImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getSimpleFeature()
	 * @generated
	 */
	int SIMPLE_FEATURE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE__NAME = VARIANT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE__DESCRIPTION = VARIANT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Feature Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE__FEATURE_KIND = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.ComplexFeatureImpl <em>Complex Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.ComplexFeatureImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getComplexFeature()
	 * @generated
	 */
	int COMPLEX_FEATURE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__NAME = VARIANT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__DESCRIPTION = VARIANT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__META_MODEL = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>And Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__AND_CHILDREN = VARIANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Or Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__OR_CHILDREN = VARIANT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Xor Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE__XOR_CHILDREN = VARIANT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Complex Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PatternMetaModelImpl <em>Pattern Meta Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PatternMetaModelImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternMetaModel()
	 * @generated
	 */
	int PATTERN_META_MODEL = 12;

	/**
	 * The feature id for the '<em><b>Class Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL__CLASS_INTERFACES = 0;

	/**
	 * The feature id for the '<em><b>Attr Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL__ATTR_INTERFACES = 1;

	/**
	 * The feature id for the '<em><b>Ref Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL__REF_INTERFACES = 2;

	/**
	 * The feature id for the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL__IMG = 3;

	/**
	 * The number of structural features of the '<em>Pattern Meta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.PatternMetaModelReferenceImpl <em>Pattern Meta Model Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.PatternMetaModelReferenceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternMetaModelReference()
	 * @generated
	 */
	int PATTERN_META_MODEL_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Class Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE__CLASS_INTERFACES = PATTERN_META_MODEL__CLASS_INTERFACES;

	/**
	 * The feature id for the '<em><b>Attr Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE__ATTR_INTERFACES = PATTERN_META_MODEL__ATTR_INTERFACES;

	/**
	 * The feature id for the '<em><b>Ref Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE__REF_INTERFACES = PATTERN_META_MODEL__REF_INTERFACES;

	/**
	 * The feature id for the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE__IMG = PATTERN_META_MODEL__IMG;

	/**
	 * The feature id for the '<em><b>Mmreference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE__MMREFERENCE = PATTERN_META_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Meta Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_META_MODEL_REFERENCE_FEATURE_COUNT = PATTERN_META_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.MetaModelImpl <em>Meta Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.MetaModelImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getMetaModel()
	 * @generated
	 */
	int META_MODEL = 14;

	/**
	 * The feature id for the '<em><b>Class Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__CLASS_INTERFACES = PATTERN_META_MODEL__CLASS_INTERFACES;

	/**
	 * The feature id for the '<em><b>Attr Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__ATTR_INTERFACES = PATTERN_META_MODEL__ATTR_INTERFACES;

	/**
	 * The feature id for the '<em><b>Ref Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__REF_INTERFACES = PATTERN_META_MODEL__REF_INTERFACES;

	/**
	 * The feature id for the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__IMG = PATTERN_META_MODEL__IMG;

	/**
	 * The feature id for the '<em><b>Mmreference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL__MMREFERENCE = PATTERN_META_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_MODEL_FEATURE_COUNT = PATTERN_META_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.MMInterfaceImpl <em>MM Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.MMInterfaceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getMMInterface()
	 * @generated
	 */
	int MM_INTERFACE = 15;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_INTERFACE__ICON = 0;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_INTERFACE__MIN_CARD = 1;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_INTERFACE__MAX_CARD = 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_INTERFACE__CONSTRAINT = 3;

	/**
	 * The number of structural features of the '<em>MM Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MM_INTERFACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.ClassInterfaceImpl <em>Class Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.ClassInterfaceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getClassInterface()
	 * @generated
	 */
	int CLASS_INTERFACE = 16;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE__ICON = MM_INTERFACE__ICON;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE__MIN_CARD = MM_INTERFACE__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE__MAX_CARD = MM_INTERFACE__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE__CONSTRAINT = MM_INTERFACE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE__REF = MM_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_INTERFACE_FEATURE_COUNT = MM_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.FeatureInterfaceImpl <em>Feature Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.FeatureInterfaceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureInterface()
	 * @generated
	 */
	int FEATURE_INTERFACE = 17;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE__ICON = MM_INTERFACE__ICON;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE__MIN_CARD = MM_INTERFACE__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE__MAX_CARD = MM_INTERFACE__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE__CONSTRAINT = MM_INTERFACE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE__REF = MM_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INTERFACE_FEATURE_COUNT = MM_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.FeatureTypeImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__ICON = FEATURE_INTERFACE__ICON;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__MIN_CARD = FEATURE_INTERFACE__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__MAX_CARD = FEATURE_INTERFACE__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__CONSTRAINT = FEATURE_INTERFACE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__REF = FEATURE_INTERFACE__REF;

	/**
	 * The number of structural features of the '<em>Feature Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_FEATURE_COUNT = FEATURE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.FeatureInstanceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureInstance()
	 * @generated
	 */
	int FEATURE_INSTANCE = 19;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__ICON = FEATURE_INTERFACE__ICON;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__MIN_CARD = FEATURE_INTERFACE__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__MAX_CARD = FEATURE_INTERFACE__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__CONSTRAINT = FEATURE_INTERFACE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE__REF = FEATURE_INTERFACE__REF;

	/**
	 * The number of structural features of the '<em>Feature Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSTANCE_FEATURE_COUNT = FEATURE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dslPatterns.impl.ReferenceInterfaceImpl <em>Reference Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.impl.ReferenceInterfaceImpl
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getReferenceInterface()
	 * @generated
	 */
	int REFERENCE_INTERFACE = 20;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE__ICON = MM_INTERFACE__ICON;

	/**
	 * The feature id for the '<em><b>Min Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE__MIN_CARD = MM_INTERFACE__MIN_CARD;

	/**
	 * The feature id for the '<em><b>Max Card</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE__MAX_CARD = MM_INTERFACE__MAX_CARD;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE__CONSTRAINT = MM_INTERFACE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE__REF = MM_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INTERFACE_FEATURE_COUNT = MM_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dslPatterns.FeatureKind <em>Feature Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dslPatterns.FeatureKind
	 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureKind()
	 * @generated
	 */
	int FEATURE_KIND = 21;


	/**
	 * Returns the meta object for class '{@link dslPatterns.PatternSet <em>Pattern Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Set</em>'.
	 * @see dslPatterns.PatternSet
	 * @generated
	 */
	EClass getPatternSet();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.PatternSet#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see dslPatterns.PatternSet#getCategories()
	 * @see #getPatternSet()
	 * @generated
	 */
	EReference getPatternSet_Categories();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see dslPatterns.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dslPatterns.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Category#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see dslPatterns.Category#getDescription()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.Category#getSubcategories <em>Subcategories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcategories</em>'.
	 * @see dslPatterns.Category#getSubcategories()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Subcategories();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.Category#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Patterns</em>'.
	 * @see dslPatterns.Category#getPatterns()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Patterns();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see dslPatterns.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference '{@link dslPatterns.Pattern#getRootVariant <em>Root Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Variant</em>'.
	 * @see dslPatterns.Pattern#getRootVariant()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_RootVariant();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Pattern#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dslPatterns.Pattern#getName()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Name();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Pattern#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see dslPatterns.Pattern#getDescription()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.Pattern#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see dslPatterns.Pattern#getServices()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Services();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Pattern#getMaxInstances <em>Max Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Instances</em>'.
	 * @see dslPatterns.Pattern#getMaxInstances()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_MaxInstances();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see dslPatterns.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dslPatterns.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see dslPatterns.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Service#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see dslPatterns.Service#isMandatory()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Mandatory();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.Service#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see dslPatterns.Service#getPorts()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Ports();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see dslPatterns.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dslPatterns.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Port#getMinCard <em>Min Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Card</em>'.
	 * @see dslPatterns.Port#getMinCard()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_MinCard();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Port#getMaxCard <em>Max Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Card</em>'.
	 * @see dslPatterns.Port#getMaxCard()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_MaxCard();

	/**
	 * Returns the meta object for the reference list '{@link dslPatterns.Port#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see dslPatterns.Port#getUses()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Uses();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Plug <em>Plug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plug</em>'.
	 * @see dslPatterns.Plug
	 * @generated
	 */
	EClass getPlug();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Slot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot</em>'.
	 * @see dslPatterns.Slot
	 * @generated
	 */
	EClass getSlot();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Injector <em>Injector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injector</em>'.
	 * @see dslPatterns.Injector
	 * @generated
	 */
	EClass getInjector();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Acceptor <em>Acceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acceptor</em>'.
	 * @see dslPatterns.Acceptor
	 * @generated
	 */
	EClass getAcceptor();

	/**
	 * Returns the meta object for class '{@link dslPatterns.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see dslPatterns.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Variant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dslPatterns.Variant#getName()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_Name();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.Variant#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see dslPatterns.Variant#getDescription()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_Description();

	/**
	 * Returns the meta object for class '{@link dslPatterns.SimpleFeature <em>Simple Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Feature</em>'.
	 * @see dslPatterns.SimpleFeature
	 * @generated
	 */
	EClass getSimpleFeature();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.SimpleFeature#getFeatureKind <em>Feature Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Kind</em>'.
	 * @see dslPatterns.SimpleFeature#getFeatureKind()
	 * @see #getSimpleFeature()
	 * @generated
	 */
	EAttribute getSimpleFeature_FeatureKind();

	/**
	 * Returns the meta object for class '{@link dslPatterns.ComplexFeature <em>Complex Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Feature</em>'.
	 * @see dslPatterns.ComplexFeature
	 * @generated
	 */
	EClass getComplexFeature();

	/**
	 * Returns the meta object for the containment reference '{@link dslPatterns.ComplexFeature#getMetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta Model</em>'.
	 * @see dslPatterns.ComplexFeature#getMetaModel()
	 * @see #getComplexFeature()
	 * @generated
	 */
	EReference getComplexFeature_MetaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.ComplexFeature#getAndChildren <em>And Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>And Children</em>'.
	 * @see dslPatterns.ComplexFeature#getAndChildren()
	 * @see #getComplexFeature()
	 * @generated
	 */
	EReference getComplexFeature_AndChildren();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.ComplexFeature#getOrChildren <em>Or Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Or Children</em>'.
	 * @see dslPatterns.ComplexFeature#getOrChildren()
	 * @see #getComplexFeature()
	 * @generated
	 */
	EReference getComplexFeature_OrChildren();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.ComplexFeature#getXorChildren <em>Xor Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Xor Children</em>'.
	 * @see dslPatterns.ComplexFeature#getXorChildren()
	 * @see #getComplexFeature()
	 * @generated
	 */
	EReference getComplexFeature_XorChildren();

	/**
	 * Returns the meta object for class '{@link dslPatterns.PatternMetaModel <em>Pattern Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Meta Model</em>'.
	 * @see dslPatterns.PatternMetaModel
	 * @generated
	 */
	EClass getPatternMetaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.PatternMetaModel#getClassInterfaces <em>Class Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Interfaces</em>'.
	 * @see dslPatterns.PatternMetaModel#getClassInterfaces()
	 * @see #getPatternMetaModel()
	 * @generated
	 */
	EReference getPatternMetaModel_ClassInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.PatternMetaModel#getAttrInterfaces <em>Attr Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attr Interfaces</em>'.
	 * @see dslPatterns.PatternMetaModel#getAttrInterfaces()
	 * @see #getPatternMetaModel()
	 * @generated
	 */
	EReference getPatternMetaModel_AttrInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.PatternMetaModel#getRefInterfaces <em>Ref Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ref Interfaces</em>'.
	 * @see dslPatterns.PatternMetaModel#getRefInterfaces()
	 * @see #getPatternMetaModel()
	 * @generated
	 */
	EReference getPatternMetaModel_RefInterfaces();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.PatternMetaModel#getImg <em>Img</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Img</em>'.
	 * @see dslPatterns.PatternMetaModel#getImg()
	 * @see #getPatternMetaModel()
	 * @generated
	 */
	EAttribute getPatternMetaModel_Img();

	/**
	 * Returns the meta object for class '{@link dslPatterns.PatternMetaModelReference <em>Pattern Meta Model Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Meta Model Reference</em>'.
	 * @see dslPatterns.PatternMetaModelReference
	 * @generated
	 */
	EClass getPatternMetaModelReference();

	/**
	 * Returns the meta object for the reference list '{@link dslPatterns.PatternMetaModelReference#getMmreference <em>Mmreference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mmreference</em>'.
	 * @see dslPatterns.PatternMetaModelReference#getMmreference()
	 * @see #getPatternMetaModelReference()
	 * @generated
	 */
	EReference getPatternMetaModelReference_Mmreference();

	/**
	 * Returns the meta object for class '{@link dslPatterns.MetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Model</em>'.
	 * @see dslPatterns.MetaModel
	 * @generated
	 */
	EClass getMetaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dslPatterns.MetaModel#getMmreference <em>Mmreference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mmreference</em>'.
	 * @see dslPatterns.MetaModel#getMmreference()
	 * @see #getMetaModel()
	 * @generated
	 */
	EReference getMetaModel_Mmreference();

	/**
	 * Returns the meta object for class '{@link dslPatterns.MMInterface <em>MM Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MM Interface</em>'.
	 * @see dslPatterns.MMInterface
	 * @generated
	 */
	EClass getMMInterface();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.MMInterface#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see dslPatterns.MMInterface#getIcon()
	 * @see #getMMInterface()
	 * @generated
	 */
	EAttribute getMMInterface_Icon();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.MMInterface#getMinCard <em>Min Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Card</em>'.
	 * @see dslPatterns.MMInterface#getMinCard()
	 * @see #getMMInterface()
	 * @generated
	 */
	EAttribute getMMInterface_MinCard();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.MMInterface#getMaxCard <em>Max Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Card</em>'.
	 * @see dslPatterns.MMInterface#getMaxCard()
	 * @see #getMMInterface()
	 * @generated
	 */
	EAttribute getMMInterface_MaxCard();

	/**
	 * Returns the meta object for the attribute '{@link dslPatterns.MMInterface#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see dslPatterns.MMInterface#getConstraint()
	 * @see #getMMInterface()
	 * @generated
	 */
	EAttribute getMMInterface_Constraint();

	/**
	 * Returns the meta object for class '{@link dslPatterns.ClassInterface <em>Class Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Interface</em>'.
	 * @see dslPatterns.ClassInterface
	 * @generated
	 */
	EClass getClassInterface();

	/**
	 * Returns the meta object for the reference list '{@link dslPatterns.ClassInterface#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref</em>'.
	 * @see dslPatterns.ClassInterface#getRef()
	 * @see #getClassInterface()
	 * @generated
	 */
	EReference getClassInterface_Ref();

	/**
	 * Returns the meta object for class '{@link dslPatterns.FeatureInterface <em>Feature Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Interface</em>'.
	 * @see dslPatterns.FeatureInterface
	 * @generated
	 */
	EClass getFeatureInterface();

	/**
	 * Returns the meta object for the reference list '{@link dslPatterns.FeatureInterface#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref</em>'.
	 * @see dslPatterns.FeatureInterface#getRef()
	 * @see #getFeatureInterface()
	 * @generated
	 */
	EReference getFeatureInterface_Ref();

	/**
	 * Returns the meta object for class '{@link dslPatterns.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Type</em>'.
	 * @see dslPatterns.FeatureType
	 * @generated
	 */
	EClass getFeatureType();

	/**
	 * Returns the meta object for class '{@link dslPatterns.FeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Instance</em>'.
	 * @see dslPatterns.FeatureInstance
	 * @generated
	 */
	EClass getFeatureInstance();

	/**
	 * Returns the meta object for class '{@link dslPatterns.ReferenceInterface <em>Reference Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Interface</em>'.
	 * @see dslPatterns.ReferenceInterface
	 * @generated
	 */
	EClass getReferenceInterface();

	/**
	 * Returns the meta object for the reference '{@link dslPatterns.ReferenceInterface#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see dslPatterns.ReferenceInterface#getRef()
	 * @see #getReferenceInterface()
	 * @generated
	 */
	EReference getReferenceInterface_Ref();

	/**
	 * Returns the meta object for enum '{@link dslPatterns.FeatureKind <em>Feature Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Kind</em>'.
	 * @see dslPatterns.FeatureKind
	 * @generated
	 */
	EEnum getFeatureKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DslPatternsFactory getDslPatternsFactory();

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
		 * The meta object literal for the '{@link dslPatterns.impl.PatternSetImpl <em>Pattern Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PatternSetImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternSet()
		 * @generated
		 */
		EClass PATTERN_SET = eINSTANCE.getPatternSet();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_SET__CATEGORIES = eINSTANCE.getPatternSet_Categories();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.CategoryImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

		/**
		 * The meta object literal for the '<em><b>Subcategories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__SUBCATEGORIES = eINSTANCE.getCategory_Subcategories();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__PATTERNS = eINSTANCE.getCategory_Patterns();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PatternImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Root Variant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__ROOT_VARIANT = eINSTANCE.getPattern_RootVariant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__NAME = eINSTANCE.getPattern_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__DESCRIPTION = eINSTANCE.getPattern_Description();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__SERVICES = eINSTANCE.getPattern_Services();

		/**
		 * The meta object literal for the '<em><b>Max Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__MAX_INSTANCES = eINSTANCE.getPattern_MaxInstances();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.ServiceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__MANDATORY = eINSTANCE.getService_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__PORTS = eINSTANCE.getService_Ports();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PortImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Min Card</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__MIN_CARD = eINSTANCE.getPort_MinCard();

		/**
		 * The meta object literal for the '<em><b>Max Card</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__MAX_CARD = eINSTANCE.getPort_MaxCard();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__USES = eINSTANCE.getPort_Uses();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.PlugImpl <em>Plug</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PlugImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPlug()
		 * @generated
		 */
		EClass PLUG = eINSTANCE.getPlug();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.SlotImpl <em>Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.SlotImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getSlot()
		 * @generated
		 */
		EClass SLOT = eINSTANCE.getSlot();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.InjectorImpl <em>Injector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.InjectorImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getInjector()
		 * @generated
		 */
		EClass INJECTOR = eINSTANCE.getInjector();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.AcceptorImpl <em>Acceptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.AcceptorImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getAcceptor()
		 * @generated
		 */
		EClass ACCEPTOR = eINSTANCE.getAcceptor();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.VariantImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__NAME = eINSTANCE.getVariant_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__DESCRIPTION = eINSTANCE.getVariant_Description();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.SimpleFeatureImpl <em>Simple Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.SimpleFeatureImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getSimpleFeature()
		 * @generated
		 */
		EClass SIMPLE_FEATURE = eINSTANCE.getSimpleFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_FEATURE__FEATURE_KIND = eINSTANCE.getSimpleFeature_FeatureKind();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.ComplexFeatureImpl <em>Complex Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.ComplexFeatureImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getComplexFeature()
		 * @generated
		 */
		EClass COMPLEX_FEATURE = eINSTANCE.getComplexFeature();

		/**
		 * The meta object literal for the '<em><b>Meta Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_FEATURE__META_MODEL = eINSTANCE.getComplexFeature_MetaModel();

		/**
		 * The meta object literal for the '<em><b>And Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_FEATURE__AND_CHILDREN = eINSTANCE.getComplexFeature_AndChildren();

		/**
		 * The meta object literal for the '<em><b>Or Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_FEATURE__OR_CHILDREN = eINSTANCE.getComplexFeature_OrChildren();

		/**
		 * The meta object literal for the '<em><b>Xor Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_FEATURE__XOR_CHILDREN = eINSTANCE.getComplexFeature_XorChildren();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.PatternMetaModelImpl <em>Pattern Meta Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PatternMetaModelImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternMetaModel()
		 * @generated
		 */
		EClass PATTERN_META_MODEL = eINSTANCE.getPatternMetaModel();

		/**
		 * The meta object literal for the '<em><b>Class Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_META_MODEL__CLASS_INTERFACES = eINSTANCE.getPatternMetaModel_ClassInterfaces();

		/**
		 * The meta object literal for the '<em><b>Attr Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_META_MODEL__ATTR_INTERFACES = eINSTANCE.getPatternMetaModel_AttrInterfaces();

		/**
		 * The meta object literal for the '<em><b>Ref Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_META_MODEL__REF_INTERFACES = eINSTANCE.getPatternMetaModel_RefInterfaces();

		/**
		 * The meta object literal for the '<em><b>Img</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_META_MODEL__IMG = eINSTANCE.getPatternMetaModel_Img();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.PatternMetaModelReferenceImpl <em>Pattern Meta Model Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.PatternMetaModelReferenceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getPatternMetaModelReference()
		 * @generated
		 */
		EClass PATTERN_META_MODEL_REFERENCE = eINSTANCE.getPatternMetaModelReference();

		/**
		 * The meta object literal for the '<em><b>Mmreference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_META_MODEL_REFERENCE__MMREFERENCE = eINSTANCE.getPatternMetaModelReference_Mmreference();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.MetaModelImpl <em>Meta Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.MetaModelImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getMetaModel()
		 * @generated
		 */
		EClass META_MODEL = eINSTANCE.getMetaModel();

		/**
		 * The meta object literal for the '<em><b>Mmreference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_MODEL__MMREFERENCE = eINSTANCE.getMetaModel_Mmreference();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.MMInterfaceImpl <em>MM Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.MMInterfaceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getMMInterface()
		 * @generated
		 */
		EClass MM_INTERFACE = eINSTANCE.getMMInterface();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_INTERFACE__ICON = eINSTANCE.getMMInterface_Icon();

		/**
		 * The meta object literal for the '<em><b>Min Card</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_INTERFACE__MIN_CARD = eINSTANCE.getMMInterface_MinCard();

		/**
		 * The meta object literal for the '<em><b>Max Card</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_INTERFACE__MAX_CARD = eINSTANCE.getMMInterface_MaxCard();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MM_INTERFACE__CONSTRAINT = eINSTANCE.getMMInterface_Constraint();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.ClassInterfaceImpl <em>Class Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.ClassInterfaceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getClassInterface()
		 * @generated
		 */
		EClass CLASS_INTERFACE = eINSTANCE.getClassInterface();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_INTERFACE__REF = eINSTANCE.getClassInterface_Ref();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.FeatureInterfaceImpl <em>Feature Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.FeatureInterfaceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureInterface()
		 * @generated
		 */
		EClass FEATURE_INTERFACE = eINSTANCE.getFeatureInterface();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INTERFACE__REF = eINSTANCE.getFeatureInterface_Ref();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.FeatureTypeImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureType()
		 * @generated
		 */
		EClass FEATURE_TYPE = eINSTANCE.getFeatureType();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.FeatureInstanceImpl <em>Feature Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.FeatureInstanceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureInstance()
		 * @generated
		 */
		EClass FEATURE_INSTANCE = eINSTANCE.getFeatureInstance();

		/**
		 * The meta object literal for the '{@link dslPatterns.impl.ReferenceInterfaceImpl <em>Reference Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.impl.ReferenceInterfaceImpl
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getReferenceInterface()
		 * @generated
		 */
		EClass REFERENCE_INTERFACE = eINSTANCE.getReferenceInterface();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_INTERFACE__REF = eINSTANCE.getReferenceInterface_Ref();

		/**
		 * The meta object literal for the '{@link dslPatterns.FeatureKind <em>Feature Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dslPatterns.FeatureKind
		 * @see dslPatterns.impl.DslPatternsPackageImpl#getFeatureKind()
		 * @generated
		 */
		EEnum FEATURE_KIND = eINSTANCE.getFeatureKind();

	}

} //DslPatternsPackage
