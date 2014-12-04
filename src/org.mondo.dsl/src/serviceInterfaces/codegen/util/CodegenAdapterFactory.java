/**
 */
package serviceInterfaces.codegen.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import serviceInterfaces.Interface;
import serviceInterfaces.Packageable;

import serviceInterfaces.codegen.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.codegen.CodegenPackage
 * @generated
 */
public class CodegenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodegenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CodegenPackage.eINSTANCE;
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
	protected CodegenSwitch<Adapter> modelSwitch =
		new CodegenSwitch<Adapter>() {
			@Override
			public Adapter caseInjectorAcceptorInterfaceL1(InjectorAcceptorInterfaceL1 object) {
				return createInjectorAcceptorInterfaceL1Adapter();
			}
			@Override
			public Adapter caseTransformationLibrary(TransformationLibrary object) {
				return createTransformationLibraryAdapter();
			}
			@Override
			public Adapter caseSlotPlugInterfaceL1(SlotPlugInterfaceL1 object) {
				return createSlotPlugInterfaceL1Adapter();
			}
			@Override
			public Adapter casePointcut(Pointcut object) {
				return createPointcutAdapter();
			}
			@Override
			public Adapter caseClassPointcut(ClassPointcut object) {
				return createClassPointcutAdapter();
			}
			@Override
			public Adapter caseMethodPoincut(MethodPoincut object) {
				return createMethodPoincutAdapter();
			}
			@Override
			public Adapter caseImportElementPointcut(ImportElementPointcut object) {
				return createImportElementPointcutAdapter();
			}
			@Override
			public Adapter caseStatementPoincut(StatementPoincut object) {
				return createStatementPoincutAdapter();
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
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.InjectorAcceptorInterfaceL1 <em>Injector Acceptor Interface L1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.InjectorAcceptorInterfaceL1
	 * @generated
	 */
	public Adapter createInjectorAcceptorInterfaceL1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.TransformationLibrary <em>Transformation Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.TransformationLibrary
	 * @generated
	 */
	public Adapter createTransformationLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.SlotPlugInterfaceL1 <em>Slot Plug Interface L1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.SlotPlugInterfaceL1
	 * @generated
	 */
	public Adapter createSlotPlugInterfaceL1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.Pointcut <em>Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.Pointcut
	 * @generated
	 */
	public Adapter createPointcutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.ClassPointcut <em>Class Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.ClassPointcut
	 * @generated
	 */
	public Adapter createClassPointcutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.MethodPoincut <em>Method Poincut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.MethodPoincut
	 * @generated
	 */
	public Adapter createMethodPoincutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.ImportElementPointcut <em>Import Element Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.ImportElementPointcut
	 * @generated
	 */
	public Adapter createImportElementPointcutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link serviceInterfaces.codegen.StatementPoincut <em>Statement Poincut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see serviceInterfaces.codegen.StatementPoincut
	 * @generated
	 */
	public Adapter createStatementPoincutAdapter() {
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

} //CodegenAdapterFactory
