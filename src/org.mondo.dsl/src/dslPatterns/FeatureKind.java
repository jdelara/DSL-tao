/**
 */
package dslPatterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Feature Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dslPatterns.DslPatternsPackage#getFeatureKind()
 * @model
 * @generated
 */
public enum FeatureKind implements Enumerator {
	/**
	 * The '<em><b>Boolean Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN_FEATURE(0, "BooleanFeature", "BooleanFeature"),

	/**
	 * The '<em><b>Integer Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER_FEATURE(0, "IntegerFeature", "IntegerFeature"),

	/**
	 * The '<em><b>Double Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_FEATURE(0, "DoubleFeature", "DoubleFeature"),

	/**
	 * The '<em><b>String Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	STRING_FEATURE(0, "StringFeature", "StringFeature"),

	/**
	 * The '<em><b>Meta Model Class Feature</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #META_MODEL_CLASS_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	META_MODEL_CLASS_FEATURE(0, "MetaModelClassFeature", "MetaModelClassFeature");

	/**
	 * The '<em><b>Boolean Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_FEATURE
	 * @model name="BooleanFeature"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_FEATURE_VALUE = 0;

	/**
	 * The '<em><b>Integer Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integer Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGER_FEATURE
	 * @model name="IntegerFeature"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_FEATURE_VALUE = 0;

	/**
	 * The '<em><b>Double Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * an Integer feature
	 * <!-- end-model-doc -->
	 * @see #DOUBLE_FEATURE
	 * @model name="DoubleFeature"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_FEATURE_VALUE = 0;

	/**
	 * The '<em><b>String Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_FEATURE
	 * @model name="StringFeature"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_FEATURE_VALUE = 0;

	/**
	 * The '<em><b>Meta Model Class Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meta Model Class Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #META_MODEL_CLASS_FEATURE
	 * @model name="MetaModelClassFeature"
	 * @generated
	 * @ordered
	 */
	public static final int META_MODEL_CLASS_FEATURE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Feature Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FeatureKind[] VALUES_ARRAY =
		new FeatureKind[] {
			BOOLEAN_FEATURE,
			INTEGER_FEATURE,
			DOUBLE_FEATURE,
			STRING_FEATURE,
			META_MODEL_CLASS_FEATURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Feature Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FeatureKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Feature Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureKind get(int value) {
		switch (value) {
			case BOOLEAN_FEATURE_VALUE: return BOOLEAN_FEATURE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FeatureKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FeatureKind
