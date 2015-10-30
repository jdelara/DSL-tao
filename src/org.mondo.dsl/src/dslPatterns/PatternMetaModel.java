/**
 */
package dslPatterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Meta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.PatternMetaModel#getClassInterfaces <em>Class Interfaces</em>}</li>
 *   <li>{@link dslPatterns.PatternMetaModel#getAttrInterfaces <em>Attr Interfaces</em>}</li>
 *   <li>{@link dslPatterns.PatternMetaModel#getRefInterfaces <em>Ref Interfaces</em>}</li>
 *   <li>{@link dslPatterns.PatternMetaModel#getImg <em>Img</em>}</li>
 *   <li>{@link dslPatterns.PatternMetaModel#getRootAttachedVariant <em>Root Attached Variant</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel()
 * @model abstract="true"
 * @generated
 */
public interface PatternMetaModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.ClassInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Interfaces</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel_ClassInterfaces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassInterface> getClassInterfaces();

	/**
	 * Returns the value of the '<em><b>Attr Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.FeatureInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr Interfaces</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel_AttrInterfaces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureInterface> getAttrInterfaces();

	/**
	 * Returns the value of the '<em><b>Ref Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link dslPatterns.ReferenceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Interfaces</em>' containment reference list.
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel_RefInterfaces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ReferenceInterface> getRefInterfaces();

	/**
	 * Returns the value of the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Img</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Img</em>' attribute.
	 * @see #setImg(String)
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel_Img()
	 * @model
	 * @generated
	 */
	String getImg();

	/**
	 * Sets the value of the '{@link dslPatterns.PatternMetaModel#getImg <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Img</em>' attribute.
	 * @see #getImg()
	 * @generated
	 */
	void setImg(String value);

	/**
	 * Returns the value of the '<em><b>Root Attached Variant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Attached Variant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Attached Variant</em>' containment reference.
	 * @see #setRootAttachedVariant(ComplexFeatureAttached)
	 * @see dslPatterns.DslPatternsPackage#getPatternMetaModel_RootAttachedVariant()
	 * @model containment="true"
	 * @generated
	 */
	ComplexFeatureAttached getRootAttachedVariant();

	/**
	 * Sets the value of the '{@link dslPatterns.PatternMetaModel#getRootAttachedVariant <em>Root Attached Variant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Attached Variant</em>' containment reference.
	 * @see #getRootAttachedVariant()
	 * @generated
	 */
	void setRootAttachedVariant(ComplexFeatureAttached value);

} // PatternMetaModel
