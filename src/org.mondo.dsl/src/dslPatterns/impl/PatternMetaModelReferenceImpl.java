/**
 */
package dslPatterns.impl;

import dslPatterns.DslPatternsPackage;
import dslPatterns.PatternMetaModelReference;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Meta Model Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.impl.PatternMetaModelReferenceImpl#getMmreference <em>Mmreference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternMetaModelReferenceImpl extends PatternMetaModelImpl implements PatternMetaModelReference {
	/**
	 * The cached value of the '{@link #getMmreference() <em>Mmreference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMmreference()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> mmreference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternMetaModelReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPatternsPackage.Literals.PATTERN_META_MODEL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getMmreference() {
		if (mmreference == null) {
			mmreference = new EObjectResolvingEList<EPackage>(EPackage.class, this, DslPatternsPackage.PATTERN_META_MODEL_REFERENCE__MMREFERENCE);
		}
		return mmreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL_REFERENCE__MMREFERENCE:
				return getMmreference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL_REFERENCE__MMREFERENCE:
				getMmreference().clear();
				getMmreference().addAll((Collection<? extends EPackage>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL_REFERENCE__MMREFERENCE:
				getMmreference().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DslPatternsPackage.PATTERN_META_MODEL_REFERENCE__MMREFERENCE:
				return mmreference != null && !mmreference.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternMetaModelReferenceImpl
