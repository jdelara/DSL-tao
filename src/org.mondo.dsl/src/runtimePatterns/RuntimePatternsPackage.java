/**
 */
package runtimePatterns;

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
 * @see runtimePatterns.RuntimePatternsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface RuntimePatternsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtimePatterns";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mondo.org/runtimePatterns";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rtpat";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePatternsPackage eINSTANCE = runtimePatterns.impl.RuntimePatternsPackageImpl.init();

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.PatternInstancesImpl <em>Pattern Instances</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.PatternInstancesImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getPatternInstances()
	 * @generated
	 */
	int PATTERN_INSTANCES = 0;

	/**
	 * The feature id for the '<em><b>Applied Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCES__APPLIED_PATTERNS = 0;

	/**
	 * The number of structural features of the '<em>Pattern Instances</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.PatternInstanceImpl <em>Pattern Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.PatternInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getPatternInstance()
	 * @generated
	 */
	int PATTERN_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE__IDENT = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE__PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Class Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE__CLASS_INSTANCES = 2;

	/**
	 * The feature id for the '<em><b>Service Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE__SERVICE_INSTANCES = 3;

	/**
	 * The feature id for the '<em><b>Attached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE__ATTACHED = 4;

	/**
	 * The number of structural features of the '<em>Pattern Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_INSTANCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.RoleInstanceImpl <em>Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.RoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getRoleInstance()
	 * @generated
	 */
	int ROLE_INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_INSTANCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.ClassRoleInstanceImpl <em>Class Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.ClassRoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getClassRoleInstance()
	 * @generated
	 */
	int CLASS_ROLE_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ROLE_INSTANCE__ROLE = ROLE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ROLE_INSTANCE__ELEMENT = ROLE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ROLE_INSTANCE__FEATURE_INSTANCES = ROLE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES = ROLE_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ROLE_INSTANCE_FEATURE_COUNT = ROLE_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.FeatureRoleInstanceImpl <em>Feature Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.FeatureRoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getFeatureRoleInstance()
	 * @generated
	 */
	int FEATURE_ROLE_INSTANCE = 4;

	/**
	 * The number of structural features of the '<em>Feature Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ROLE_INSTANCE_FEATURE_COUNT = ROLE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.InstanceFeatureRoleInstanceImpl <em>Instance Feature Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.InstanceFeatureRoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getInstanceFeatureRoleInstance()
	 * @generated
	 */
	int INSTANCE_FEATURE_ROLE_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_ROLE_INSTANCE__ROLE = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_ROLE_INSTANCE__VALUE = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Feature Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_ROLE_INSTANCE_FEATURE_COUNT = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.TypeFeatureRoleInstanceImpl <em>Type Feature Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.TypeFeatureRoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getTypeFeatureRoleInstance()
	 * @generated
	 */
	int TYPE_FEATURE_ROLE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_ROLE_INSTANCE__ROLE = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_ROLE_INSTANCE__ELEMENT = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Feature Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_ROLE_INSTANCE_FEATURE_COUNT = FEATURE_ROLE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link runtimePatterns.impl.ReferenceRoleInstanceImpl <em>Reference Role Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see runtimePatterns.impl.ReferenceRoleInstanceImpl
	 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getReferenceRoleInstance()
	 * @generated
	 */
	int REFERENCE_ROLE_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ROLE_INSTANCE__ROLE = ROLE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ROLE_INSTANCE__ELEMENT = ROLE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Role Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ROLE_INSTANCE_FEATURE_COUNT = ROLE_INSTANCE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link runtimePatterns.PatternInstances <em>Pattern Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Instances</em>'.
	 * @see runtimePatterns.PatternInstances
	 * @generated
	 */
	EClass getPatternInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimePatterns.PatternInstances#getAppliedPatterns <em>Applied Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applied Patterns</em>'.
	 * @see runtimePatterns.PatternInstances#getAppliedPatterns()
	 * @see #getPatternInstances()
	 * @generated
	 */
	EReference getPatternInstances_AppliedPatterns();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.PatternInstance <em>Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Instance</em>'.
	 * @see runtimePatterns.PatternInstance
	 * @generated
	 */
	EClass getPatternInstance();

	/**
	 * Returns the meta object for the attribute '{@link runtimePatterns.PatternInstance#getIdent <em>Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ident</em>'.
	 * @see runtimePatterns.PatternInstance#getIdent()
	 * @see #getPatternInstance()
	 * @generated
	 */
	EAttribute getPatternInstance_Ident();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.PatternInstance#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pattern</em>'.
	 * @see runtimePatterns.PatternInstance#getPattern()
	 * @see #getPatternInstance()
	 * @generated
	 */
	EReference getPatternInstance_Pattern();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimePatterns.PatternInstance#getClassInstances <em>Class Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Instances</em>'.
	 * @see runtimePatterns.PatternInstance#getClassInstances()
	 * @see #getPatternInstance()
	 * @generated
	 */
	EReference getPatternInstance_ClassInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimePatterns.PatternInstance#getServiceInstances <em>Service Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Instances</em>'.
	 * @see runtimePatterns.PatternInstance#getServiceInstances()
	 * @see #getPatternInstance()
	 * @generated
	 */
	EReference getPatternInstance_ServiceInstances();

	/**
	 * Returns the meta object for the attribute '{@link runtimePatterns.PatternInstance#isAttached <em>Attached</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attached</em>'.
	 * @see runtimePatterns.PatternInstance#isAttached()
	 * @see #getPatternInstance()
	 * @generated
	 */
	EAttribute getPatternInstance_Attached();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.RoleInstance <em>Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Instance</em>'.
	 * @see runtimePatterns.RoleInstance
	 * @generated
	 */
	EClass getRoleInstance();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.ClassRoleInstance <em>Class Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Role Instance</em>'.
	 * @see runtimePatterns.ClassRoleInstance
	 * @generated
	 */
	EClass getClassRoleInstance();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.ClassRoleInstance#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see runtimePatterns.ClassRoleInstance#getRole()
	 * @see #getClassRoleInstance()
	 * @generated
	 */
	EReference getClassRoleInstance_Role();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.ClassRoleInstance#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see runtimePatterns.ClassRoleInstance#getElement()
	 * @see #getClassRoleInstance()
	 * @generated
	 */
	EReference getClassRoleInstance_Element();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimePatterns.ClassRoleInstance#getFeatureInstances <em>Feature Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Instances</em>'.
	 * @see runtimePatterns.ClassRoleInstance#getFeatureInstances()
	 * @see #getClassRoleInstance()
	 * @generated
	 */
	EReference getClassRoleInstance_FeatureInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link runtimePatterns.ClassRoleInstance#getReferenceInstances <em>Reference Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Instances</em>'.
	 * @see runtimePatterns.ClassRoleInstance#getReferenceInstances()
	 * @see #getClassRoleInstance()
	 * @generated
	 */
	EReference getClassRoleInstance_ReferenceInstances();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.FeatureRoleInstance <em>Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Role Instance</em>'.
	 * @see runtimePatterns.FeatureRoleInstance
	 * @generated
	 */
	EClass getFeatureRoleInstance();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.InstanceFeatureRoleInstance <em>Instance Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Feature Role Instance</em>'.
	 * @see runtimePatterns.InstanceFeatureRoleInstance
	 * @generated
	 */
	EClass getInstanceFeatureRoleInstance();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.InstanceFeatureRoleInstance#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see runtimePatterns.InstanceFeatureRoleInstance#getRole()
	 * @see #getInstanceFeatureRoleInstance()
	 * @generated
	 */
	EReference getInstanceFeatureRoleInstance_Role();

	/**
	 * Returns the meta object for the attribute '{@link runtimePatterns.InstanceFeatureRoleInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see runtimePatterns.InstanceFeatureRoleInstance#getValue()
	 * @see #getInstanceFeatureRoleInstance()
	 * @generated
	 */
	EAttribute getInstanceFeatureRoleInstance_Value();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.TypeFeatureRoleInstance <em>Type Feature Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Feature Role Instance</em>'.
	 * @see runtimePatterns.TypeFeatureRoleInstance
	 * @generated
	 */
	EClass getTypeFeatureRoleInstance();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.TypeFeatureRoleInstance#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see runtimePatterns.TypeFeatureRoleInstance#getRole()
	 * @see #getTypeFeatureRoleInstance()
	 * @generated
	 */
	EReference getTypeFeatureRoleInstance_Role();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.TypeFeatureRoleInstance#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see runtimePatterns.TypeFeatureRoleInstance#getElement()
	 * @see #getTypeFeatureRoleInstance()
	 * @generated
	 */
	EReference getTypeFeatureRoleInstance_Element();

	/**
	 * Returns the meta object for class '{@link runtimePatterns.ReferenceRoleInstance <em>Reference Role Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Role Instance</em>'.
	 * @see runtimePatterns.ReferenceRoleInstance
	 * @generated
	 */
	EClass getReferenceRoleInstance();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.ReferenceRoleInstance#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see runtimePatterns.ReferenceRoleInstance#getRole()
	 * @see #getReferenceRoleInstance()
	 * @generated
	 */
	EReference getReferenceRoleInstance_Role();

	/**
	 * Returns the meta object for the reference '{@link runtimePatterns.ReferenceRoleInstance#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see runtimePatterns.ReferenceRoleInstance#getElement()
	 * @see #getReferenceRoleInstance()
	 * @generated
	 */
	EReference getReferenceRoleInstance_Element();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimePatternsFactory getRuntimePatternsFactory();

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
		 * The meta object literal for the '{@link runtimePatterns.impl.PatternInstancesImpl <em>Pattern Instances</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.PatternInstancesImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getPatternInstances()
		 * @generated
		 */
		EClass PATTERN_INSTANCES = eINSTANCE.getPatternInstances();

		/**
		 * The meta object literal for the '<em><b>Applied Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_INSTANCES__APPLIED_PATTERNS = eINSTANCE.getPatternInstances_AppliedPatterns();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.PatternInstanceImpl <em>Pattern Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.PatternInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getPatternInstance()
		 * @generated
		 */
		EClass PATTERN_INSTANCE = eINSTANCE.getPatternInstance();

		/**
		 * The meta object literal for the '<em><b>Ident</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_INSTANCE__IDENT = eINSTANCE.getPatternInstance_Ident();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_INSTANCE__PATTERN = eINSTANCE.getPatternInstance_Pattern();

		/**
		 * The meta object literal for the '<em><b>Class Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_INSTANCE__CLASS_INSTANCES = eINSTANCE.getPatternInstance_ClassInstances();

		/**
		 * The meta object literal for the '<em><b>Service Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_INSTANCE__SERVICE_INSTANCES = eINSTANCE.getPatternInstance_ServiceInstances();

		/**
		 * The meta object literal for the '<em><b>Attached</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_INSTANCE__ATTACHED = eINSTANCE.getPatternInstance_Attached();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.RoleInstanceImpl <em>Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.RoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getRoleInstance()
		 * @generated
		 */
		EClass ROLE_INSTANCE = eINSTANCE.getRoleInstance();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.ClassRoleInstanceImpl <em>Class Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.ClassRoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getClassRoleInstance()
		 * @generated
		 */
		EClass CLASS_ROLE_INSTANCE = eINSTANCE.getClassRoleInstance();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ROLE_INSTANCE__ROLE = eINSTANCE.getClassRoleInstance_Role();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ROLE_INSTANCE__ELEMENT = eINSTANCE.getClassRoleInstance_Element();

		/**
		 * The meta object literal for the '<em><b>Feature Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ROLE_INSTANCE__FEATURE_INSTANCES = eINSTANCE.getClassRoleInstance_FeatureInstances();

		/**
		 * The meta object literal for the '<em><b>Reference Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ROLE_INSTANCE__REFERENCE_INSTANCES = eINSTANCE.getClassRoleInstance_ReferenceInstances();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.FeatureRoleInstanceImpl <em>Feature Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.FeatureRoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getFeatureRoleInstance()
		 * @generated
		 */
		EClass FEATURE_ROLE_INSTANCE = eINSTANCE.getFeatureRoleInstance();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.InstanceFeatureRoleInstanceImpl <em>Instance Feature Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.InstanceFeatureRoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getInstanceFeatureRoleInstance()
		 * @generated
		 */
		EClass INSTANCE_FEATURE_ROLE_INSTANCE = eINSTANCE.getInstanceFeatureRoleInstance();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_FEATURE_ROLE_INSTANCE__ROLE = eINSTANCE.getInstanceFeatureRoleInstance_Role();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_FEATURE_ROLE_INSTANCE__VALUE = eINSTANCE.getInstanceFeatureRoleInstance_Value();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.TypeFeatureRoleInstanceImpl <em>Type Feature Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.TypeFeatureRoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getTypeFeatureRoleInstance()
		 * @generated
		 */
		EClass TYPE_FEATURE_ROLE_INSTANCE = eINSTANCE.getTypeFeatureRoleInstance();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_FEATURE_ROLE_INSTANCE__ROLE = eINSTANCE.getTypeFeatureRoleInstance_Role();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_FEATURE_ROLE_INSTANCE__ELEMENT = eINSTANCE.getTypeFeatureRoleInstance_Element();

		/**
		 * The meta object literal for the '{@link runtimePatterns.impl.ReferenceRoleInstanceImpl <em>Reference Role Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see runtimePatterns.impl.ReferenceRoleInstanceImpl
		 * @see runtimePatterns.impl.RuntimePatternsPackageImpl#getReferenceRoleInstance()
		 * @generated
		 */
		EClass REFERENCE_ROLE_INSTANCE = eINSTANCE.getReferenceRoleInstance();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ROLE_INSTANCE__ROLE = eINSTANCE.getReferenceRoleInstance_Role();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ROLE_INSTANCE__ELEMENT = eINSTANCE.getReferenceRoleInstance_Element();

	}

} //RuntimePatternsPackage
