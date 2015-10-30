/**
 */
package dslPatterns;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dslPatterns.DslPatternsPackage
 * @generated
 */
public interface DslPatternsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DslPatternsFactory eINSTANCE = dslPatterns.impl.DslPatternsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pattern Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Set</em>'.
	 * @generated
	 */
	PatternSet createPatternSet();

	/**
	 * Returns a new object of class '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category</em>'.
	 * @generated
	 */
	Category createCategory();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Plug</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plug</em>'.
	 * @generated
	 */
	Plug createPlug();

	/**
	 * Returns a new object of class '<em>Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot</em>'.
	 * @generated
	 */
	Slot createSlot();

	/**
	 * Returns a new object of class '<em>Injector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injector</em>'.
	 * @generated
	 */
	Injector createInjector();

	/**
	 * Returns a new object of class '<em>Acceptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acceptor</em>'.
	 * @generated
	 */
	Acceptor createAcceptor();

	/**
	 * Returns a new object of class '<em>Simple Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Feature</em>'.
	 * @generated
	 */
	SimpleFeature createSimpleFeature();

	/**
	 * Returns a new object of class '<em>Pattern Meta Model Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Meta Model Reference</em>'.
	 * @generated
	 */
	PatternMetaModelReference createPatternMetaModelReference();

	/**
	 * Returns a new object of class '<em>Meta Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Model</em>'.
	 * @generated
	 */
	MetaModel createMetaModel();

	/**
	 * Returns a new object of class '<em>Class Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Interface</em>'.
	 * @generated
	 */
	ClassInterface createClassInterface();

	/**
	 * Returns a new object of class '<em>Feature Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Type</em>'.
	 * @generated
	 */
	FeatureType createFeatureType();

	/**
	 * Returns a new object of class '<em>Feature Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Instance</em>'.
	 * @generated
	 */
	FeatureInstance createFeatureInstance();

	/**
	 * Returns a new object of class '<em>Reference Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Interface</em>'.
	 * @generated
	 */
	ReferenceInterface createReferenceInterface();

	/**
	 * Returns a new object of class '<em>Complex Feature Main</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Feature Main</em>'.
	 * @generated
	 */
	ComplexFeatureMain createComplexFeatureMain();

	/**
	 * Returns a new object of class '<em>Complex Feature Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Feature Attached</em>'.
	 * @generated
	 */
	ComplexFeatureAttached createComplexFeatureAttached();

	/**
	 * Returns a new object of class '<em>Pattern Meta Model Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Meta Model Attached</em>'.
	 * @generated
	 */
	PatternMetaModelAttached createPatternMetaModelAttached();

	/**
	 * Returns a new object of class '<em>Class Interface Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Interface Attached</em>'.
	 * @generated
	 */
	ClassInterfaceAttached createClassInterfaceAttached();

	/**
	 * Returns a new object of class '<em>Reference Interface Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Interface Attached</em>'.
	 * @generated
	 */
	ReferenceInterfaceAttached createReferenceInterfaceAttached();

	/**
	 * Returns a new object of class '<em>Feature Type Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Type Attached</em>'.
	 * @generated
	 */
	FeatureTypeAttached createFeatureTypeAttached();

	/**
	 * Returns a new object of class '<em>Feature Instance Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Instance Attached</em>'.
	 * @generated
	 */
	FeatureInstanceAttached createFeatureInstanceAttached();

	/**
	 * Returns a new object of class '<em>MM Interface Attached</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MM Interface Attached</em>'.
	 * @generated
	 */
	MMInterfaceAttached createMMInterfaceAttached();

	/**
	 * Returns a new object of class '<em>Tag Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Set</em>'.
	 * @generated
	 */
	TagSet createTagSet();

	/**
	 * Returns a new object of class '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag</em>'.
	 * @generated
	 */
	Tag createTag();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DslPatternsPackage getDslPatternsPackage();

} //DslPatternsFactory
