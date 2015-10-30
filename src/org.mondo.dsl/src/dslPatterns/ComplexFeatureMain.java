/**
 */
package dslPatterns;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Feature Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dslPatterns.ComplexFeatureMain#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 *
 * @see dslPatterns.DslPatternsPackage#getComplexFeatureMain()
 * @model
 * @generated
 */
public interface ComplexFeatureMain extends ComplexFeature {
	/**
	 * Returns the value of the '<em><b>Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model</em>' containment reference.
	 * @see #setMetaModel(PatternMetaModel)
	 * @see dslPatterns.DslPatternsPackage#getComplexFeatureMain_MetaModel()
	 * @model containment="true"
	 * @generated
	 */
	PatternMetaModel getMetaModel();

	/**
	 * Sets the value of the '{@link dslPatterns.ComplexFeatureMain#getMetaModel <em>Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model</em>' containment reference.
	 * @see #getMetaModel()
	 * @generated
	 */
	void setMetaModel(PatternMetaModel value);

} // ComplexFeatureMain
