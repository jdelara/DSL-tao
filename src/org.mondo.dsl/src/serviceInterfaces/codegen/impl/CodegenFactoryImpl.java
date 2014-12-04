/**
 */
package serviceInterfaces.codegen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import serviceInterfaces.codegen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodegenFactoryImpl extends EFactoryImpl implements CodegenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CodegenFactory init() {
		try {
			CodegenFactory theCodegenFactory = (CodegenFactory)EPackage.Registry.INSTANCE.getEFactory(CodegenPackage.eNS_URI);
			if (theCodegenFactory != null) {
				return theCodegenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CodegenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenFactoryImpl() {
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
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1: return createInjectorAcceptorInterfaceL1();
			case CodegenPackage.TRANSFORMATION_LIBRARY: return createTransformationLibrary();
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1: return createSlotPlugInterfaceL1();
			case CodegenPackage.CLASS_POINTCUT: return createClassPointcut();
			case CodegenPackage.METHOD_POINCUT: return createMethodPoincut();
			case CodegenPackage.IMPORT_ELEMENT_POINTCUT: return createImportElementPointcut();
			case CodegenPackage.STATEMENT_POINCUT: return createStatementPoincut();
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
			case CodegenPackage.CODE_GEN_LANGUAGE:
				return createCodeGenLanguageFromString(eDataType, initialValue);
			case CodegenPackage.POINTCUT_TYPE:
				return createPointcutTypeFromString(eDataType, initialValue);
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
			case CodegenPackage.CODE_GEN_LANGUAGE:
				return convertCodeGenLanguageToString(eDataType, instanceValue);
			case CodegenPackage.POINTCUT_TYPE:
				return convertPointcutTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectorAcceptorInterfaceL1 createInjectorAcceptorInterfaceL1() {
		InjectorAcceptorInterfaceL1Impl injectorAcceptorInterfaceL1 = new InjectorAcceptorInterfaceL1Impl();
		return injectorAcceptorInterfaceL1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationLibrary createTransformationLibrary() {
		TransformationLibraryImpl transformationLibrary = new TransformationLibraryImpl();
		return transformationLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPlugInterfaceL1 createSlotPlugInterfaceL1() {
		SlotPlugInterfaceL1Impl slotPlugInterfaceL1 = new SlotPlugInterfaceL1Impl();
		return slotPlugInterfaceL1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPointcut createClassPointcut() {
		ClassPointcutImpl classPointcut = new ClassPointcutImpl();
		return classPointcut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodPoincut createMethodPoincut() {
		MethodPoincutImpl methodPoincut = new MethodPoincutImpl();
		return methodPoincut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportElementPointcut createImportElementPointcut() {
		ImportElementPointcutImpl importElementPointcut = new ImportElementPointcutImpl();
		return importElementPointcut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementPoincut createStatementPoincut() {
		StatementPoincutImpl statementPoincut = new StatementPoincutImpl();
		return statementPoincut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenLanguage createCodeGenLanguageFromString(EDataType eDataType, String initialValue) {
		CodeGenLanguage result = CodeGenLanguage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCodeGenLanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointcutType createPointcutTypeFromString(EDataType eDataType, String initialValue) {
		PointcutType result = PointcutType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPointcutTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenPackage getCodegenPackage() {
		return (CodegenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CodegenPackage getPackage() {
		return CodegenPackage.eINSTANCE;
	}

} //CodegenFactoryImpl
