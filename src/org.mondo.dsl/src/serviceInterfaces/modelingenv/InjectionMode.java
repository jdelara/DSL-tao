/**
 */
package serviceInterfaces.modelingenv;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Injection Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see serviceInterfaces.modelingenv.ModelingenvPackage#getInjectionMode()
 * @model
 * @generated
 */
public enum InjectionMode implements Enumerator {
	/**
	 * The '<em><b>GOOGLE JUICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOOGLE_JUICE_VALUE
	 * @generated
	 * @ordered
	 */
	GOOGLE_JUICE(0, "GOOGLE_JUICE", "GOOGLE_JUICE"),

	/**
	 * The '<em><b>PLAIN JAVA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAIN_JAVA_VALUE
	 * @generated
	 * @ordered
	 */
	PLAIN_JAVA(1, "PLAIN_JAVA", "PLAIN_JAVA");

	/**
	 * The '<em><b>GOOGLE JUICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GOOGLE JUICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GOOGLE_JUICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GOOGLE_JUICE_VALUE = 0;

	/**
	 * The '<em><b>PLAIN JAVA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAIN JAVA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAIN_JAVA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLAIN_JAVA_VALUE = 1;

	/**
	 * An array of all the '<em><b>Injection Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InjectionMode[] VALUES_ARRAY =
		new InjectionMode[] {
			GOOGLE_JUICE,
			PLAIN_JAVA,
		};

	/**
	 * A public read-only list of all the '<em><b>Injection Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InjectionMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Injection Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InjectionMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InjectionMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Injection Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InjectionMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InjectionMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Injection Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InjectionMode get(int value) {
		switch (value) {
			case GOOGLE_JUICE_VALUE: return GOOGLE_JUICE;
			case PLAIN_JAVA_VALUE: return PLAIN_JAVA;
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
	private InjectionMode(int value, String name, String literal) {
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
	
} //InjectionMode
