/**
 */
package mindMapDSML;

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
 * @see mindMapDSML.MindMapDSMLFactory
 * @model kind="package"
 * @generated
 */
public interface MindMapDSMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mindMapDSML";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/mindMapDSML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mmdsml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MindMapDSMLPackage eINSTANCE = mindMapDSML.impl.MindMapDSMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link mindMapDSML.impl.MindMapImpl <em>Mind Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindMapDSML.impl.MindMapImpl
	 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getMindMap()
	 * @generated
	 */
	int MIND_MAP = 0;

	/**
	 * The feature id for the '<em><b>Ideas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIND_MAP__IDEAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIND_MAP__NAME = 1;

	/**
	 * The number of structural features of the '<em>Mind Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIND_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mindMapDSML.impl.IdeaImpl <em>Idea</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindMapDSML.impl.IdeaImpl
	 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getIdea()
	 * @generated
	 */
	int IDEA = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__CONTAINS = 3;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__LINKS = 4;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__PATTERN = 5;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__NOTES = 6;

	/**
	 * The feature id for the '<em><b>Sub Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__SUB_TEXT = 7;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA__FEATURES = 8;

	/**
	 * The number of structural features of the '<em>Idea</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEA_FEATURE_COUNT = 9;


	/**
	 * The meta object id for the '{@link mindMapDSML.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindMapDSML.impl.LinkImpl
	 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link mindMapDSML.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindMapDSML.impl.NoteImpl
	 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link mindMapDSML.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindMapDSML.impl.FeatureImpl
	 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link mindMapDSML.MindMap <em>Mind Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mind Map</em>'.
	 * @see mindMapDSML.MindMap
	 * @generated
	 */
	EClass getMindMap();

	/**
	 * Returns the meta object for the containment reference list '{@link mindMapDSML.MindMap#getIdeas <em>Ideas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ideas</em>'.
	 * @see mindMapDSML.MindMap#getIdeas()
	 * @see #getMindMap()
	 * @generated
	 */
	EReference getMindMap_Ideas();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.MindMap#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mindMapDSML.MindMap#getName()
	 * @see #getMindMap()
	 * @generated
	 */
	EAttribute getMindMap_Name();

	/**
	 * Returns the meta object for class '{@link mindMapDSML.Idea <em>Idea</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Idea</em>'.
	 * @see mindMapDSML.Idea
	 * @generated
	 */
	EClass getIdea();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Idea#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see mindMapDSML.Idea#getId()
	 * @see #getIdea()
	 * @generated
	 */
	EAttribute getIdea_Id();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Idea#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mindMapDSML.Idea#getName()
	 * @see #getIdea()
	 * @generated
	 */
	EAttribute getIdea_Name();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Idea#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see mindMapDSML.Idea#getDescription()
	 * @see #getIdea()
	 * @generated
	 */
	EAttribute getIdea_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link mindMapDSML.Idea#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see mindMapDSML.Idea#getContains()
	 * @see #getIdea()
	 * @generated
	 */
	EReference getIdea_Contains();

	/**
	 * Returns the meta object for the containment reference list '{@link mindMapDSML.Idea#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see mindMapDSML.Idea#getLinks()
	 * @see #getIdea()
	 * @generated
	 */
	EReference getIdea_Links();

	/**
	 * Returns the meta object for the reference '{@link mindMapDSML.Idea#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pattern</em>'.
	 * @see mindMapDSML.Idea#getPattern()
	 * @see #getIdea()
	 * @generated
	 */
	EReference getIdea_Pattern();

	/**
	 * Returns the meta object for the containment reference list '{@link mindMapDSML.Idea#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notes</em>'.
	 * @see mindMapDSML.Idea#getNotes()
	 * @see #getIdea()
	 * @generated
	 */
	EReference getIdea_Notes();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Idea#getSubText <em>Sub Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Text</em>'.
	 * @see mindMapDSML.Idea#getSubText()
	 * @see #getIdea()
	 * @generated
	 */
	EAttribute getIdea_SubText();

	/**
	 * Returns the meta object for the containment reference list '{@link mindMapDSML.Idea#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see mindMapDSML.Idea#getFeatures()
	 * @see #getIdea()
	 * @generated
	 */
	EReference getIdea_Features();

	/**
	 * Returns the meta object for class '{@link mindMapDSML.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see mindMapDSML.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Link#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mindMapDSML.Link#getName()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Name();

	/**
	 * Returns the meta object for the reference '{@link mindMapDSML.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see mindMapDSML.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for class '{@link mindMapDSML.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see mindMapDSML.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Note#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see mindMapDSML.Note#getText()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Text();

	/**
	 * Returns the meta object for class '{@link mindMapDSML.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see mindMapDSML.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Feature#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see mindMapDSML.Feature#getKey()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Key();

	/**
	 * Returns the meta object for the attribute '{@link mindMapDSML.Feature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mindMapDSML.Feature#getValue()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MindMapDSMLFactory getMindMapDSMLFactory();

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
		 * The meta object literal for the '{@link mindMapDSML.impl.MindMapImpl <em>Mind Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindMapDSML.impl.MindMapImpl
		 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getMindMap()
		 * @generated
		 */
		EClass MIND_MAP = eINSTANCE.getMindMap();

		/**
		 * The meta object literal for the '<em><b>Ideas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIND_MAP__IDEAS = eINSTANCE.getMindMap_Ideas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIND_MAP__NAME = eINSTANCE.getMindMap_Name();

		/**
		 * The meta object literal for the '{@link mindMapDSML.impl.IdeaImpl <em>Idea</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindMapDSML.impl.IdeaImpl
		 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getIdea()
		 * @generated
		 */
		EClass IDEA = eINSTANCE.getIdea();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEA__ID = eINSTANCE.getIdea_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEA__NAME = eINSTANCE.getIdea_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEA__DESCRIPTION = eINSTANCE.getIdea_Description();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDEA__CONTAINS = eINSTANCE.getIdea_Contains();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDEA__LINKS = eINSTANCE.getIdea_Links();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDEA__PATTERN = eINSTANCE.getIdea_Pattern();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDEA__NOTES = eINSTANCE.getIdea_Notes();

		/**
		 * The meta object literal for the '<em><b>Sub Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDEA__SUB_TEXT = eINSTANCE.getIdea_SubText();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDEA__FEATURES = eINSTANCE.getIdea_Features();

		/**
		 * The meta object literal for the '{@link mindMapDSML.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindMapDSML.impl.LinkImpl
		 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__NAME = eINSTANCE.getLink_Name();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '{@link mindMapDSML.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindMapDSML.impl.NoteImpl
		 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__TEXT = eINSTANCE.getNote_Text();

		/**
		 * The meta object literal for the '{@link mindMapDSML.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindMapDSML.impl.FeatureImpl
		 * @see mindMapDSML.impl.MindMapDSMLPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__KEY = eINSTANCE.getFeature_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__VALUE = eINSTANCE.getFeature_Value();

	}

} //MindMapDSMLPackage
