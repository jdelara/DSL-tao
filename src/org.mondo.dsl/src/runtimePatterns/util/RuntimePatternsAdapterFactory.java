/**
 */
package runtimePatterns.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import runtimePatterns.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see runtimePatterns.RuntimePatternsPackage
 * @generated
 */
public class RuntimePatternsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RuntimePatternsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePatternsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RuntimePatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimePatternsSwitch<Adapter> modelSwitch =
		new RuntimePatternsSwitch<Adapter>() {
			@Override
			public Adapter casePatternInstances(PatternInstances object) {
				return createPatternInstancesAdapter();
			}
			@Override
			public Adapter casePatternInstance(PatternInstance object) {
				return createPatternInstanceAdapter();
			}
			@Override
			public Adapter caseRoleInstance(RoleInstance object) {
				return createRoleInstanceAdapter();
			}
			@Override
			public Adapter caseClassRoleInstance(ClassRoleInstance object) {
				return createClassRoleInstanceAdapter();
			}
			@Override
			public Adapter caseFeatureRoleInstance(FeatureRoleInstance object) {
				return createFeatureRoleInstanceAdapter();
			}
			@Override
			public Adapter caseInstanceFeatureRoleInstance(InstanceFeatureRoleInstance object) {
				return createInstanceFeatureRoleInstanceAdapter();
			}
			@Override
			public Adapter caseTypeFeatureRoleInstance(TypeFeatureRoleInstance object) {
				return createTypeFeatureRoleInstanceAdapter();
			}
			@Override
			public Adapter caseReferenceRoleInstance(ReferenceRoleInstance object) {
				return createReferenceRoleInstanceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.PatternInstances <em>Pattern Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.PatternInstances
	 * @generated
	 */
	public Adapter createPatternInstancesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.PatternInstance <em>Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.PatternInstance
	 * @generated
	 */
	public Adapter createPatternInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.RoleInstance <em>Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.RoleInstance
	 * @generated
	 */
	public Adapter createRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.ClassRoleInstance <em>Class Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.ClassRoleInstance
	 * @generated
	 */
	public Adapter createClassRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.FeatureRoleInstance <em>Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.FeatureRoleInstance
	 * @generated
	 */
	public Adapter createFeatureRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.InstanceFeatureRoleInstance <em>Instance Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.InstanceFeatureRoleInstance
	 * @generated
	 */
	public Adapter createInstanceFeatureRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.TypeFeatureRoleInstance <em>Type Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.TypeFeatureRoleInstance
	 * @generated
	 */
	public Adapter createTypeFeatureRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link runtimePatterns.ReferenceRoleInstance <em>Reference Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see runtimePatterns.ReferenceRoleInstance
	 * @generated
	 */
	public Adapter createReferenceRoleInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RuntimePatternsAdapterFactory
