/**
 */
package runtimePatterns.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtimePatterns.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimePatternsFactoryImpl extends EFactoryImpl implements RuntimePatternsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimePatternsFactory init() {
		try {
			RuntimePatternsFactory theRuntimePatternsFactory = (RuntimePatternsFactory)EPackage.Registry.INSTANCE.getEFactory("http://mondo.org/runtimePatterns"); 
			if (theRuntimePatternsFactory != null) {
				return theRuntimePatternsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimePatternsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePatternsFactoryImpl() {
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
			case RuntimePatternsPackage.PATTERN_INSTANCES: return createPatternInstances();
			case RuntimePatternsPackage.PATTERN_INSTANCE: return createPatternInstance();
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE: return createClassRoleInstance();
			case RuntimePatternsPackage.INSTANCE_FEATURE_ROLE_INSTANCE: return createInstanceFeatureRoleInstance();
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE: return createTypeFeatureRoleInstance();
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE: return createReferenceRoleInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternInstances createPatternInstances() {
		PatternInstancesImpl patternInstances = new PatternInstancesImpl();
		return patternInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternInstance createPatternInstance() {
		PatternInstanceImpl patternInstance = new PatternInstanceImpl();
		return patternInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassRoleInstance createClassRoleInstance() {
		ClassRoleInstanceImpl classRoleInstance = new ClassRoleInstanceImpl();
		return classRoleInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFeatureRoleInstance createInstanceFeatureRoleInstance() {
		InstanceFeatureRoleInstanceImpl instanceFeatureRoleInstance = new InstanceFeatureRoleInstanceImpl();
		return instanceFeatureRoleInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeFeatureRoleInstance createTypeFeatureRoleInstance() {
		TypeFeatureRoleInstanceImpl typeFeatureRoleInstance = new TypeFeatureRoleInstanceImpl();
		return typeFeatureRoleInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRoleInstance createReferenceRoleInstance() {
		ReferenceRoleInstanceImpl referenceRoleInstance = new ReferenceRoleInstanceImpl();
		return referenceRoleInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePatternsPackage getRuntimePatternsPackage() {
		return (RuntimePatternsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimePatternsPackage getPackage() {
		return RuntimePatternsPackage.eINSTANCE;
	}

} //RuntimePatternsFactoryImpl
