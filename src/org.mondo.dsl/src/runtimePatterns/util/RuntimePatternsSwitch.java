/**
 */
package runtimePatterns.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import runtimePatterns.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see runtimePatterns.RuntimePatternsPackage
 * @generated
 */
public class RuntimePatternsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RuntimePatternsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePatternsSwitch() {
		if (modelPackage == null) {
			modelPackage = RuntimePatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RuntimePatternsPackage.PATTERN_INSTANCES: {
				PatternInstances patternInstances = (PatternInstances)theEObject;
				T result = casePatternInstances(patternInstances);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.PATTERN_INSTANCE: {
				PatternInstance patternInstance = (PatternInstance)theEObject;
				T result = casePatternInstance(patternInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.ROLE_INSTANCE: {
				RoleInstance roleInstance = (RoleInstance)theEObject;
				T result = caseRoleInstance(roleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.CLASS_ROLE_INSTANCE: {
				ClassRoleInstance classRoleInstance = (ClassRoleInstance)theEObject;
				T result = caseClassRoleInstance(classRoleInstance);
				if (result == null) result = caseRoleInstance(classRoleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.FEATURE_ROLE_INSTANCE: {
				FeatureRoleInstance featureRoleInstance = (FeatureRoleInstance)theEObject;
				T result = caseFeatureRoleInstance(featureRoleInstance);
				if (result == null) result = caseRoleInstance(featureRoleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.INSTANCE_FEATURE_ROLE_INSTANCE: {
				InstanceFeatureRoleInstance instanceFeatureRoleInstance = (InstanceFeatureRoleInstance)theEObject;
				T result = caseInstanceFeatureRoleInstance(instanceFeatureRoleInstance);
				if (result == null) result = caseFeatureRoleInstance(instanceFeatureRoleInstance);
				if (result == null) result = caseRoleInstance(instanceFeatureRoleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.TYPE_FEATURE_ROLE_INSTANCE: {
				TypeFeatureRoleInstance typeFeatureRoleInstance = (TypeFeatureRoleInstance)theEObject;
				T result = caseTypeFeatureRoleInstance(typeFeatureRoleInstance);
				if (result == null) result = caseFeatureRoleInstance(typeFeatureRoleInstance);
				if (result == null) result = caseRoleInstance(typeFeatureRoleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePatternsPackage.REFERENCE_ROLE_INSTANCE: {
				ReferenceRoleInstance referenceRoleInstance = (ReferenceRoleInstance)theEObject;
				T result = caseReferenceRoleInstance(referenceRoleInstance);
				if (result == null) result = caseRoleInstance(referenceRoleInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Instances</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Instances</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternInstances(PatternInstances object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternInstance(PatternInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleInstance(RoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassRoleInstance(ClassRoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureRoleInstance(FeatureRoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Feature Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Feature Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceFeatureRoleInstance(InstanceFeatureRoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Feature Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Feature Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeFeatureRoleInstance(TypeFeatureRoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Role Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Role Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceRoleInstance(ReferenceRoleInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RuntimePatternsSwitch
