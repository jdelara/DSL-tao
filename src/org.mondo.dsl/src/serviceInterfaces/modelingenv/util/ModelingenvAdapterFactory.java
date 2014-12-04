/**
 */
package serviceInterfaces.modelingenv.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import serviceInterfaces.Interface;
import serviceInterfaces.Packageable;

import serviceInterfaces.modelingenv.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.modelingenv.ModelingenvPackage
 * @generated
 */
public class ModelingenvAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelingenvPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingenvAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelingenvPackage.eINSTANCE;
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
	protected ModelingenvSwitch<Adapter> modelSwitch =
		new ModelingenvSwitch<Adapter>() {
			@Override
			public Adapter caseInjectorAcceptorInterfaceL0(InjectorAcceptorInterfaceL0 object) {
				return createInjectorAcceptorInterfaceL0Adapter();
			}
			@Override
			public Adapter caseJavaTypeDeclaration(JavaTypeDeclaration object) {
				return createJavaTypeDeclarationAdapter();
			}
			@Override
			public Adapter caseJavaInterface(JavaInterface object) {
				return createJavaInterfaceAdapter();
			}
			@Override
			public Adapter caseJavaClass(JavaClass object) {
				return createJavaClassAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseSlotPlugInterfaceL0(SlotPlugInterfaceL0 object) {
				return createSlotPlugInterfaceL0Adapter();
			}
			@Override
			public Adapter caseExtensionPoint(ExtensionPoint object) {
				return createExtensionPointAdapter();
			}
			@Override
			public Adapter casePackageable(Packageable object) {
				return createPackageableAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
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
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0 <em>Injector Acceptor Interface L0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.InjectorAcceptorInterfaceL0
	 * @generated
	 */
	public Adapter createInjectorAcceptorInterfaceL0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.JavaTypeDeclaration <em>Java Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.JavaTypeDeclaration
	 * @generated
	 */
	public Adapter createJavaTypeDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.JavaInterface <em>Java Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.JavaInterface
	 * @generated
	 */
	public Adapter createJavaInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.JavaClass <em>Java Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.JavaClass
	 * @generated
	 */
	public Adapter createJavaClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.SlotPlugInterfaceL0 <em>Slot Plug Interface L0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.SlotPlugInterfaceL0
	 * @generated
	 */
	public Adapter createSlotPlugInterfaceL0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.modelingenv.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.modelingenv.ExtensionPoint
	 * @generated
	 */
	public Adapter createExtensionPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.Packageable <em>Packageable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.Packageable
	 * @generated
	 */
	public Adapter createPackageableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
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

} //ModelingenvAdapterFactory
