/**
 */
package mindMapDSML.impl;

import mindMapDSML.*;

import org.eclipse.emf.ecore.EClass;
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
public class MindMapDSMLFactoryImpl extends EFactoryImpl implements MindMapDSMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MindMapDSMLFactory init() {
		try {
			MindMapDSMLFactory theMindMapDSMLFactory = (MindMapDSMLFactory)EPackage.Registry.INSTANCE.getEFactory(MindMapDSMLPackage.eNS_URI);
			if (theMindMapDSMLFactory != null) {
				return theMindMapDSMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MindMapDSMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindMapDSMLFactoryImpl() {
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
			case MindMapDSMLPackage.MIND_MAP: return createMindMap();
			case MindMapDSMLPackage.IDEA: return createIdea();
			case MindMapDSMLPackage.LINK: return createLink();
			case MindMapDSMLPackage.NOTE: return createNote();
			case MindMapDSMLPackage.FEATURE: return createFeature();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindMap createMindMap() {
		MindMapImpl mindMap = new MindMapImpl();
		return mindMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Idea createIdea() {
		IdeaImpl idea = new IdeaImpl();
		return idea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Note createNote() {
		NoteImpl note = new NoteImpl();
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindMapDSMLPackage getMindMapDSMLPackage() {
		return (MindMapDSMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MindMapDSMLPackage getPackage() {
		return MindMapDSMLPackage.eINSTANCE;
	}

} //MindMapDSMLFactoryImpl
