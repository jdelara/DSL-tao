/**
 */
package dslPatterns.impl;

import dslPatterns.Acceptor;
import dslPatterns.Category;
import dslPatterns.ClassInterface;
import dslPatterns.ClassInterfaceAttached;
import dslPatterns.ComplexFeature;
import dslPatterns.ComplexFeatureAttached;
import dslPatterns.ComplexFeatureMain;
import dslPatterns.DslPatternsFactory;
import dslPatterns.DslPatternsPackage;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInstanceAttached;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureInterfaceAttached;
import dslPatterns.FeatureKind;
import dslPatterns.FeatureType;
import dslPatterns.FeatureTypeAttached;
import dslPatterns.Injector;
import dslPatterns.MMInterface;
import dslPatterns.MMInterfaceAttached;
import dslPatterns.MetaModel;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.PatternMetaModelAttached;
import dslPatterns.PatternMetaModelReference;
import dslPatterns.PatternSet;
import dslPatterns.Plug;
import dslPatterns.Port;
import dslPatterns.ReferenceInterface;
import dslPatterns.ReferenceInterfaceAttached;
import dslPatterns.Service;
import dslPatterns.SimpleFeature;
import dslPatterns.Slot;
import dslPatterns.Variant;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import serviceInterfaces.ServiceInterfacesPackage;
import serviceInterfaces.codegen.CodegenPackage;
import serviceInterfaces.codegen.impl.CodegenPackageImpl;
import serviceInterfaces.impl.ServiceInterfacesPackageImpl;
import serviceInterfaces.modelingenv.ModelingenvPackage;
import serviceInterfaces.modelingenv.impl.ModelingenvPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslPatternsPackageImpl extends EPackageImpl implements DslPatternsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plugEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acceptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternMetaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternMetaModelReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mmInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexFeatureMainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexFeatureAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternMetaModelAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classInterfaceAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInterfaceAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceInterfaceAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTypeAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInstanceAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mmInterfaceAttachedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dslPatterns.DslPatternsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DslPatternsPackageImpl() {
		super(eNS_URI, DslPatternsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DslPatternsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DslPatternsPackage init() {
		if (isInited) return (DslPatternsPackage)EPackage.Registry.INSTANCE.getEPackage(DslPatternsPackage.eNS_URI);

		// Obtain or create and register package
		DslPatternsPackageImpl theDslPatternsPackage = (DslPatternsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DslPatternsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DslPatternsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ServiceInterfacesPackageImpl theServiceInterfacesPackage = (ServiceInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) instanceof ServiceInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI) : ServiceInterfacesPackage.eINSTANCE);
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		ModelingenvPackageImpl theModelingenvPackage = (ModelingenvPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) instanceof ModelingenvPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelingenvPackage.eNS_URI) : ModelingenvPackage.eINSTANCE);

		// Create package meta-data objects
		theDslPatternsPackage.createPackageContents();
		theServiceInterfacesPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theModelingenvPackage.createPackageContents();

		// Initialize created meta-data
		theDslPatternsPackage.initializePackageContents();
		theServiceInterfacesPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theModelingenvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDslPatternsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DslPatternsPackage.eNS_URI, theDslPatternsPackage);
		return theDslPatternsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternSet() {
		return patternSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternSet_Categories() {
		return (EReference)patternSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Name() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Description() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_Subcategories() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_Patterns() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_RootVariant() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPattern_Name() {
		return (EAttribute)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPattern_Description() {
		return (EAttribute)patternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Services() {
		return (EReference)patternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPattern_MaxInstances() {
		return (EAttribute)patternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Description() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Mandatory() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Ports() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Name() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_MinCard() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_MaxCard() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Uses() {
		return (EReference)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlug() {
		return plugEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlot() {
		return slotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjector() {
		return injectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAcceptor() {
		return acceptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariant() {
		return variantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariant_Name() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariant_Description() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleFeature() {
		return simpleFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleFeature_FeatureKind() {
		return (EAttribute)simpleFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexFeature() {
		return complexFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexFeature_AndChildren() {
		return (EReference)complexFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexFeature_OrChildren() {
		return (EReference)complexFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexFeature_XorChildren() {
		return (EReference)complexFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternMetaModel() {
		return patternMetaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModel_ClassInterfaces() {
		return (EReference)patternMetaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModel_AttrInterfaces() {
		return (EReference)patternMetaModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModel_RefInterfaces() {
		return (EReference)patternMetaModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternMetaModel_Img() {
		return (EAttribute)patternMetaModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModel_RootAttachedVariant() {
		return (EReference)patternMetaModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternMetaModelReference() {
		return patternMetaModelReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModelReference_Mmreference() {
		return (EReference)patternMetaModelReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaModel() {
		return metaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaModel_Mmreference() {
		return (EReference)metaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMInterface() {
		return mmInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMInterface_Icon() {
		return (EAttribute)mmInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMInterface_MinCard() {
		return (EAttribute)mmInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMInterface_MaxCard() {
		return (EAttribute)mmInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMInterface_Constraint() {
		return (EAttribute)mmInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassInterface() {
		return classInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassInterface_Ref() {
		return (EReference)classInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassInterface_Abstract() {
		return (EAttribute)classInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInterface() {
		return featureInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureInterface_Ref() {
		return (EReference)featureInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureType() {
		return featureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInstance() {
		return featureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceInterface() {
		return referenceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceInterface_Ref() {
		return (EReference)referenceInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexFeatureMain() {
		return complexFeatureMainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexFeatureMain_MetaModel() {
		return (EReference)complexFeatureMainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexFeatureAttached() {
		return complexFeatureAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexFeatureAttached_MetaModelAttached() {
		return (EReference)complexFeatureAttachedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternMetaModelAttached() {
		return patternMetaModelAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModelAttached_ClassIntAtt() {
		return (EReference)patternMetaModelAttachedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternMetaModelAttached_Content() {
		return (EReference)patternMetaModelAttachedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassInterfaceAttached() {
		return classInterfaceAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassInterfaceAttached_RefIntAtt() {
		return (EReference)classInterfaceAttachedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassInterfaceAttached_FeatIntAtt() {
		return (EReference)classInterfaceAttachedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassInterfaceAttached_Value() {
		return (EReference)classInterfaceAttachedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInterfaceAttached() {
		return featureInterfaceAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceInterfaceAttached() {
		return referenceInterfaceAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureTypeAttached() {
		return featureTypeAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInstanceAttached() {
		return featureInstanceAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMInterfaceAttached() {
		return mmInterfaceAttachedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMMInterfaceAttached_Type() {
		return (EReference)mmInterfaceAttachedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMMInterfaceAttached_Attached() {
		return (EReference)mmInterfaceAttachedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureKind() {
		return featureKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DslPatternsFactory getDslPatternsFactory() {
		return (DslPatternsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		patternSetEClass = createEClass(PATTERN_SET);
		createEReference(patternSetEClass, PATTERN_SET__CATEGORIES);

		categoryEClass = createEClass(CATEGORY);
		createEAttribute(categoryEClass, CATEGORY__NAME);
		createEAttribute(categoryEClass, CATEGORY__DESCRIPTION);
		createEReference(categoryEClass, CATEGORY__SUBCATEGORIES);
		createEReference(categoryEClass, CATEGORY__PATTERNS);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__ROOT_VARIANT);
		createEAttribute(patternEClass, PATTERN__NAME);
		createEAttribute(patternEClass, PATTERN__DESCRIPTION);
		createEReference(patternEClass, PATTERN__SERVICES);
		createEAttribute(patternEClass, PATTERN__MAX_INSTANCES);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__NAME);
		createEAttribute(serviceEClass, SERVICE__DESCRIPTION);
		createEAttribute(serviceEClass, SERVICE__MANDATORY);
		createEReference(serviceEClass, SERVICE__PORTS);

		portEClass = createEClass(PORT);
		createEAttribute(portEClass, PORT__NAME);
		createEAttribute(portEClass, PORT__MIN_CARD);
		createEAttribute(portEClass, PORT__MAX_CARD);
		createEReference(portEClass, PORT__USES);

		plugEClass = createEClass(PLUG);

		slotEClass = createEClass(SLOT);

		injectorEClass = createEClass(INJECTOR);

		acceptorEClass = createEClass(ACCEPTOR);

		variantEClass = createEClass(VARIANT);
		createEAttribute(variantEClass, VARIANT__NAME);
		createEAttribute(variantEClass, VARIANT__DESCRIPTION);

		simpleFeatureEClass = createEClass(SIMPLE_FEATURE);
		createEAttribute(simpleFeatureEClass, SIMPLE_FEATURE__FEATURE_KIND);

		complexFeatureEClass = createEClass(COMPLEX_FEATURE);
		createEReference(complexFeatureEClass, COMPLEX_FEATURE__AND_CHILDREN);
		createEReference(complexFeatureEClass, COMPLEX_FEATURE__OR_CHILDREN);
		createEReference(complexFeatureEClass, COMPLEX_FEATURE__XOR_CHILDREN);

		patternMetaModelEClass = createEClass(PATTERN_META_MODEL);
		createEReference(patternMetaModelEClass, PATTERN_META_MODEL__CLASS_INTERFACES);
		createEReference(patternMetaModelEClass, PATTERN_META_MODEL__ATTR_INTERFACES);
		createEReference(patternMetaModelEClass, PATTERN_META_MODEL__REF_INTERFACES);
		createEAttribute(patternMetaModelEClass, PATTERN_META_MODEL__IMG);
		createEReference(patternMetaModelEClass, PATTERN_META_MODEL__ROOT_ATTACHED_VARIANT);

		patternMetaModelReferenceEClass = createEClass(PATTERN_META_MODEL_REFERENCE);
		createEReference(patternMetaModelReferenceEClass, PATTERN_META_MODEL_REFERENCE__MMREFERENCE);

		metaModelEClass = createEClass(META_MODEL);
		createEReference(metaModelEClass, META_MODEL__MMREFERENCE);

		mmInterfaceEClass = createEClass(MM_INTERFACE);
		createEAttribute(mmInterfaceEClass, MM_INTERFACE__ICON);
		createEAttribute(mmInterfaceEClass, MM_INTERFACE__MIN_CARD);
		createEAttribute(mmInterfaceEClass, MM_INTERFACE__MAX_CARD);
		createEAttribute(mmInterfaceEClass, MM_INTERFACE__CONSTRAINT);

		classInterfaceEClass = createEClass(CLASS_INTERFACE);
		createEReference(classInterfaceEClass, CLASS_INTERFACE__REF);
		createEAttribute(classInterfaceEClass, CLASS_INTERFACE__ABSTRACT);

		featureInterfaceEClass = createEClass(FEATURE_INTERFACE);
		createEReference(featureInterfaceEClass, FEATURE_INTERFACE__REF);

		featureTypeEClass = createEClass(FEATURE_TYPE);

		featureInstanceEClass = createEClass(FEATURE_INSTANCE);

		referenceInterfaceEClass = createEClass(REFERENCE_INTERFACE);
		createEReference(referenceInterfaceEClass, REFERENCE_INTERFACE__REF);

		complexFeatureMainEClass = createEClass(COMPLEX_FEATURE_MAIN);
		createEReference(complexFeatureMainEClass, COMPLEX_FEATURE_MAIN__META_MODEL);

		complexFeatureAttachedEClass = createEClass(COMPLEX_FEATURE_ATTACHED);
		createEReference(complexFeatureAttachedEClass, COMPLEX_FEATURE_ATTACHED__META_MODEL_ATTACHED);

		patternMetaModelAttachedEClass = createEClass(PATTERN_META_MODEL_ATTACHED);
		createEReference(patternMetaModelAttachedEClass, PATTERN_META_MODEL_ATTACHED__CLASS_INT_ATT);
		createEReference(patternMetaModelAttachedEClass, PATTERN_META_MODEL_ATTACHED__CONTENT);

		classInterfaceAttachedEClass = createEClass(CLASS_INTERFACE_ATTACHED);
		createEReference(classInterfaceAttachedEClass, CLASS_INTERFACE_ATTACHED__REF_INT_ATT);
		createEReference(classInterfaceAttachedEClass, CLASS_INTERFACE_ATTACHED__FEAT_INT_ATT);
		createEReference(classInterfaceAttachedEClass, CLASS_INTERFACE_ATTACHED__VALUE);

		featureInterfaceAttachedEClass = createEClass(FEATURE_INTERFACE_ATTACHED);

		referenceInterfaceAttachedEClass = createEClass(REFERENCE_INTERFACE_ATTACHED);

		featureTypeAttachedEClass = createEClass(FEATURE_TYPE_ATTACHED);

		featureInstanceAttachedEClass = createEClass(FEATURE_INSTANCE_ATTACHED);

		mmInterfaceAttachedEClass = createEClass(MM_INTERFACE_ATTACHED);
		createEReference(mmInterfaceAttachedEClass, MM_INTERFACE_ATTACHED__TYPE);
		createEReference(mmInterfaceAttachedEClass, MM_INTERFACE_ATTACHED__ATTACHED);

		// Create enums
		featureKindEEnum = createEEnum(FEATURE_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ServiceInterfacesPackage theServiceInterfacesPackage = (ServiceInterfacesPackage)EPackage.Registry.INSTANCE.getEPackage(ServiceInterfacesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		plugEClass.getESuperTypes().add(this.getPort());
		slotEClass.getESuperTypes().add(this.getPort());
		injectorEClass.getESuperTypes().add(this.getPort());
		acceptorEClass.getESuperTypes().add(this.getPort());
		simpleFeatureEClass.getESuperTypes().add(this.getVariant());
		complexFeatureEClass.getESuperTypes().add(this.getVariant());
		patternMetaModelReferenceEClass.getESuperTypes().add(this.getPatternMetaModel());
		metaModelEClass.getESuperTypes().add(this.getPatternMetaModel());
		classInterfaceEClass.getESuperTypes().add(this.getMMInterface());
		featureInterfaceEClass.getESuperTypes().add(this.getMMInterface());
		featureTypeEClass.getESuperTypes().add(this.getFeatureInterface());
		featureInstanceEClass.getESuperTypes().add(this.getFeatureInterface());
		referenceInterfaceEClass.getESuperTypes().add(this.getMMInterface());
		complexFeatureMainEClass.getESuperTypes().add(this.getComplexFeature());
		complexFeatureAttachedEClass.getESuperTypes().add(this.getComplexFeature());
		classInterfaceAttachedEClass.getESuperTypes().add(this.getMMInterfaceAttached());
		featureInterfaceAttachedEClass.getESuperTypes().add(this.getMMInterfaceAttached());
		referenceInterfaceAttachedEClass.getESuperTypes().add(this.getMMInterfaceAttached());
		featureTypeAttachedEClass.getESuperTypes().add(this.getFeatureInterfaceAttached());
		featureInstanceAttachedEClass.getESuperTypes().add(this.getFeatureInterfaceAttached());

		// Initialize classes and features; add operations and parameters
		initEClass(patternSetEClass, PatternSet.class, "PatternSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternSet_Categories(), this.getCategory(), null, "categories", null, 0, -1, PatternSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Description(), ecorePackage.getEString(), "description", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_Subcategories(), this.getCategory(), null, "subcategories", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCategory_Patterns(), this.getPattern(), null, "patterns", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_RootVariant(), this.getComplexFeatureMain(), null, "rootVariant", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPattern_Name(), ecorePackage.getEString(), "name", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPattern_Description(), ecorePackage.getEString(), "description", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Services(), this.getService(), null, "services", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPattern_MaxInstances(), ecorePackage.getEInt(), "maxInstances", "-1", 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Description(), ecorePackage.getEString(), "description", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "true", 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Ports(), this.getPort(), null, "ports", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPort_Name(), ecorePackage.getEString(), "name", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_MinCard(), ecorePackage.getEBigInteger(), "minCard", "0", 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_MaxCard(), ecorePackage.getEBigInteger(), "maxCard", "-1", 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_Uses(), theServiceInterfacesPackage.getInterface(), null, "uses", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(plugEClass, Plug.class, "Plug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(slotEClass, Slot.class, "Slot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(injectorEClass, Injector.class, "Injector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(acceptorEClass, Acceptor.class, "Acceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variantEClass, Variant.class, "Variant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariant_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariant_Description(), ecorePackage.getEString(), "description", null, 0, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleFeatureEClass, SimpleFeature.class, "SimpleFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleFeature_FeatureKind(), this.getFeatureKind(), "featureKind", null, 1, 1, SimpleFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexFeatureEClass, ComplexFeature.class, "ComplexFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexFeature_AndChildren(), this.getVariant(), null, "andChildren", null, 0, -1, ComplexFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComplexFeature_OrChildren(), this.getVariant(), null, "orChildren", null, 0, -1, ComplexFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComplexFeature_XorChildren(), this.getVariant(), null, "xorChildren", null, 0, -1, ComplexFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternMetaModelEClass, PatternMetaModel.class, "PatternMetaModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternMetaModel_ClassInterfaces(), this.getClassInterface(), null, "classInterfaces", null, 0, -1, PatternMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPatternMetaModel_AttrInterfaces(), this.getFeatureInterface(), null, "attrInterfaces", null, 0, -1, PatternMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPatternMetaModel_RefInterfaces(), this.getReferenceInterface(), null, "refInterfaces", null, 0, -1, PatternMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPatternMetaModel_Img(), ecorePackage.getEString(), "img", null, 0, 1, PatternMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternMetaModel_RootAttachedVariant(), this.getComplexFeatureAttached(), null, "rootAttachedVariant", null, 0, 1, PatternMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternMetaModelReferenceEClass, PatternMetaModelReference.class, "PatternMetaModelReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternMetaModelReference_Mmreference(), ecorePackage.getEPackage(), null, "mmreference", null, 0, -1, PatternMetaModelReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(metaModelEClass, MetaModel.class, "MetaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaModel_Mmreference(), ecorePackage.getEPackage(), null, "mmreference", null, 0, -1, MetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mmInterfaceEClass, MMInterface.class, "MMInterface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMMInterface_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, MMInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMInterface_MinCard(), ecorePackage.getEBigInteger(), "minCard", null, 1, 1, MMInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMInterface_MaxCard(), ecorePackage.getEBigInteger(), "maxCard", null, 1, 1, MMInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMInterface_Constraint(), ecorePackage.getEString(), "constraint", null, 0, 1, MMInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classInterfaceEClass, ClassInterface.class, "ClassInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassInterface_Ref(), ecorePackage.getEClass(), null, "ref", null, 0, -1, ClassInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassInterface_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, ClassInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureInterfaceEClass, FeatureInterface.class, "FeatureInterface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureInterface_Ref(), ecorePackage.getEAttribute(), null, "ref", null, 0, -1, FeatureInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(featureTypeEClass, FeatureType.class, "FeatureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureInstanceEClass, FeatureInstance.class, "FeatureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceInterfaceEClass, ReferenceInterface.class, "ReferenceInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceInterface_Ref(), ecorePackage.getEReference(), null, "ref", null, 1, 1, ReferenceInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexFeatureMainEClass, ComplexFeatureMain.class, "ComplexFeatureMain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexFeatureMain_MetaModel(), this.getPatternMetaModel(), null, "metaModel", null, 0, 1, ComplexFeatureMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexFeatureAttachedEClass, ComplexFeatureAttached.class, "ComplexFeatureAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexFeatureAttached_MetaModelAttached(), this.getPatternMetaModelAttached(), null, "metaModelAttached", null, 0, 1, ComplexFeatureAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternMetaModelAttachedEClass, PatternMetaModelAttached.class, "PatternMetaModelAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternMetaModelAttached_ClassIntAtt(), this.getClassInterfaceAttached(), null, "classIntAtt", null, 0, -1, PatternMetaModelAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternMetaModelAttached_Content(), this.getPattern(), null, "content", null, 1, 1, PatternMetaModelAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classInterfaceAttachedEClass, ClassInterfaceAttached.class, "ClassInterfaceAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassInterfaceAttached_RefIntAtt(), this.getReferenceInterfaceAttached(), null, "refIntAtt", null, 0, -1, ClassInterfaceAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassInterfaceAttached_FeatIntAtt(), this.getFeatureInterfaceAttached(), null, "featIntAtt", null, 0, -1, ClassInterfaceAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassInterfaceAttached_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, ClassInterfaceAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureInterfaceAttachedEClass, FeatureInterfaceAttached.class, "FeatureInterfaceAttached", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceInterfaceAttachedEClass, ReferenceInterfaceAttached.class, "ReferenceInterfaceAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureTypeAttachedEClass, FeatureTypeAttached.class, "FeatureTypeAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureInstanceAttachedEClass, FeatureInstanceAttached.class, "FeatureInstanceAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mmInterfaceAttachedEClass, MMInterfaceAttached.class, "MMInterfaceAttached", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMMInterfaceAttached_Type(), this.getMMInterface(), null, "type", null, 1, 1, MMInterfaceAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMMInterfaceAttached_Attached(), this.getMMInterface(), null, "attached", null, 0, -1, MMInterfaceAttached.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(featureKindEEnum, FeatureKind.class, "FeatureKind");
		addEEnumLiteral(featureKindEEnum, FeatureKind.BOOLEAN_FEATURE);
		addEEnumLiteral(featureKindEEnum, FeatureKind.INTEGER_FEATURE);
		addEEnumLiteral(featureKindEEnum, FeatureKind.DOUBLE_FEATURE);
		addEEnumLiteral(featureKindEEnum, FeatureKind.STRING_FEATURE);
		addEEnumLiteral(featureKindEEnum, FeatureKind.META_MODEL_CLASS_FEATURE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });		
	}

} //DslPatternsPackageImpl
