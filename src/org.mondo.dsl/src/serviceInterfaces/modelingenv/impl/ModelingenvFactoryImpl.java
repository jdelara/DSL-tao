/**
 */
package serviceInterfaces.modelingenv.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import serviceInterfaces.modelingenv.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingenvFactoryImpl extends EFactoryImpl implements ModelingenvFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelingenvFactory init() {
		try {
			ModelingenvFactory theModelingenvFactory = (ModelingenvFactory)EPackage.Registry.INSTANCE.getEFactory(ModelingenvPackage.eNS_URI);
			if (theModelingenvFactory != null) {
				return theModelingenvFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelingenvFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingenvFactoryImpl() {
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
			case ModelingenvPackage.INJECTOR_ACCEPTOR_INTERFACE_L0: return createInjectorAcceptorInterfaceL0();
			case ModelingenvPackage.JAVA_INTERFACE: return createJavaInterface();
			case ModelingenvPackage.JAVA_CLASS: return createJavaClass();
			case ModelingenvPackage.OPERATION: return createOperation();
			case ModelingenvPackage.SLOT_PLUG_INTERFACE_L0: return createSlotPlugInterfaceL0();
			case ModelingenvPackage.EXTENSION_POINT: return createExtensionPoint();
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
			case ModelingenvPackage.INJECTION_MODE:
				return createInjectionModeFromString(eDataType, initialValue);
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
			case ModelingenvPackage.INJECTION_MODE:
				return convertInjectionModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectorAcceptorInterfaceL0 createInjectorAcceptorInterfaceL0() {
		InjectorAcceptorInterfaceL0Impl injectorAcceptorInterfaceL0 = new InjectorAcceptorInterfaceL0Impl();
		return injectorAcceptorInterfaceL0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaInterface createJavaInterface() {
		JavaInterfaceImpl javaInterface = new JavaInterfaceImpl();
		return javaInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClass createJavaClass() {
		JavaClassImpl javaClass = new JavaClassImpl();
		return javaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPlugInterfaceL0 createSlotPlugInterfaceL0() {
		SlotPlugInterfaceL0Impl slotPlugInterfaceL0 = new SlotPlugInterfaceL0Impl();
		return slotPlugInterfaceL0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionPoint createExtensionPoint() {
		ExtensionPointImpl extensionPoint = new ExtensionPointImpl();
		return extensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectionMode createInjectionModeFromString(EDataType eDataType, String initialValue) {
		InjectionMode result = InjectionMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInjectionModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingenvPackage getModelingenvPackage() {
		return (ModelingenvPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelingenvPackage getPackage() {
		return ModelingenvPackage.eINSTANCE;
	}

} //ModelingenvFactoryImpl
