/**
 */
package serviceInterfaces.codegen.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import serviceInterfaces.Interface;
import serviceInterfaces.Packageable;

import serviceInterfaces.codegen.*;

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
 * @see serviceInterfaces.codegen.CodegenPackage
 * @generated
 */
public class CodegenSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodegenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenSwitch() {
		if (modelPackage == null) {
			modelPackage = CodegenPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case CodegenPackage.INJECTOR_ACCEPTOR_INTERFACE_L1: {
				InjectorAcceptorInterfaceL1 injectorAcceptorInterfaceL1 = (InjectorAcceptorInterfaceL1)theEObject;
				T result = caseInjectorAcceptorInterfaceL1(injectorAcceptorInterfaceL1);
				if (result == null) result = caseInterface(injectorAcceptorInterfaceL1);
				if (result == null) result = casePackageable(injectorAcceptorInterfaceL1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.TRANSFORMATION_LIBRARY: {
				TransformationLibrary transformationLibrary = (TransformationLibrary)theEObject;
				T result = caseTransformationLibrary(transformationLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.SLOT_PLUG_INTERFACE_L1: {
				SlotPlugInterfaceL1 slotPlugInterfaceL1 = (SlotPlugInterfaceL1)theEObject;
				T result = caseSlotPlugInterfaceL1(slotPlugInterfaceL1);
				if (result == null) result = caseInterface(slotPlugInterfaceL1);
				if (result == null) result = casePackageable(slotPlugInterfaceL1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.POINTCUT: {
				Pointcut pointcut = (Pointcut)theEObject;
				T result = casePointcut(pointcut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.CLASS_POINTCUT: {
				ClassPointcut classPointcut = (ClassPointcut)theEObject;
				T result = caseClassPointcut(classPointcut);
				if (result == null) result = casePointcut(classPointcut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.METHOD_POINCUT: {
				MethodPoincut methodPoincut = (MethodPoincut)theEObject;
				T result = caseMethodPoincut(methodPoincut);
				if (result == null) result = casePointcut(methodPoincut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.IMPORT_ELEMENT_POINTCUT: {
				ImportElementPointcut importElementPointcut = (ImportElementPointcut)theEObject;
				T result = caseImportElementPointcut(importElementPointcut);
				if (result == null) result = casePointcut(importElementPointcut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.STATEMENT_POINCUT: {
				StatementPoincut statementPoincut = (StatementPoincut)theEObject;
				T result = caseStatementPoincut(statementPoincut);
				if (result == null) result = casePointcut(statementPoincut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Injector Acceptor Interface L1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Injector Acceptor Interface L1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInjectorAcceptorInterfaceL1(InjectorAcceptorInterfaceL1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationLibrary(TransformationLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slot Plug Interface L1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot Plug Interface L1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlotPlugInterfaceL1(SlotPlugInterfaceL1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pointcut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointcut(Pointcut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Pointcut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassPointcut(ClassPointcut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Poincut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Poincut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodPoincut(MethodPoincut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Element Pointcut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Element Pointcut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportElementPointcut(ImportElementPointcut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Poincut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Poincut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementPoincut(StatementPoincut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packageable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packageable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageable(Packageable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface(Interface object) {
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

} //CodegenSwitch
