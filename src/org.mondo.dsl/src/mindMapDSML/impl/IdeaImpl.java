/**
 */
package mindMapDSML.impl;

import dslPatterns.PatternMetaModel;

import java.util.Collection;

import mindMapDSML.Feature;
import mindMapDSML.Idea;
import mindMapDSML.Link;
import mindMapDSML.MindMapDSMLPackage;

import mindMapDSML.Note;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Idea</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getId <em>Id</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getName <em>Name</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getContains <em>Contains</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getSubText <em>Sub Text</em>}</li>
 *   <li>{@link mindMapDSML.impl.IdeaImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdeaImpl extends EObjectImpl implements Idea {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContains() <em>Contains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContains()
	 * @generated
	 * @ordered
	 */
	protected EList<Idea> contains;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected PatternMetaModel pattern;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList<Note> notes;

	/**
	 * The default value of the '{@link #getSubText() <em>Sub Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubText()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubText() <em>Sub Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubText()
	 * @generated
	 * @ordered
	 */
	protected String subText = SUB_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdeaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MindMapDSMLPackage.Literals.IDEA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindMapDSMLPackage.IDEA__ID, oldId, id));
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindMapDSMLPackage.IDEA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindMapDSMLPackage.IDEA__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Idea> getContains() {
		if (contains == null) {
			contains = new EObjectContainmentEList<Idea>(Idea.class, this, MindMapDSMLPackage.IDEA__CONTAINS);
		}
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, MindMapDSMLPackage.IDEA__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMetaModel getPattern() {
		if (pattern != null && pattern.eIsProxy()) {
			InternalEObject oldPattern = (InternalEObject)pattern;
			pattern = (PatternMetaModel)eResolveProxy(oldPattern);
			if (pattern != oldPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MindMapDSMLPackage.IDEA__PATTERN, oldPattern, pattern));
			}
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMetaModel basicGetPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(PatternMetaModel newPattern) {
		PatternMetaModel oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindMapDSMLPackage.IDEA__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Note> getNotes() {
		if (notes == null) {
			notes = new EObjectContainmentEList<Note>(Note.class, this, MindMapDSMLPackage.IDEA__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubText() {
		return subText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubText(String newSubText) {
		String oldSubText = subText;
		subText = newSubText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindMapDSMLPackage.IDEA__SUB_TEXT, oldSubText, subText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, MindMapDSMLPackage.IDEA__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindMapDSMLPackage.IDEA__CONTAINS:
				return ((InternalEList<?>)getContains()).basicRemove(otherEnd, msgs);
			case MindMapDSMLPackage.IDEA__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case MindMapDSMLPackage.IDEA__NOTES:
				return ((InternalEList<?>)getNotes()).basicRemove(otherEnd, msgs);
			case MindMapDSMLPackage.IDEA__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindMapDSMLPackage.IDEA__ID:
				return getId();
			case MindMapDSMLPackage.IDEA__NAME:
				return getName();
			case MindMapDSMLPackage.IDEA__DESCRIPTION:
				return getDescription();
			case MindMapDSMLPackage.IDEA__CONTAINS:
				return getContains();
			case MindMapDSMLPackage.IDEA__LINKS:
				return getLinks();
			case MindMapDSMLPackage.IDEA__PATTERN:
				if (resolve) return getPattern();
				return basicGetPattern();
			case MindMapDSMLPackage.IDEA__NOTES:
				return getNotes();
			case MindMapDSMLPackage.IDEA__SUB_TEXT:
				return getSubText();
			case MindMapDSMLPackage.IDEA__FEATURES:
				return getFeatures();
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
			case MindMapDSMLPackage.IDEA__ID:
				setId((String)newValue);
				return;
			case MindMapDSMLPackage.IDEA__NAME:
				setName((String)newValue);
				return;
			case MindMapDSMLPackage.IDEA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case MindMapDSMLPackage.IDEA__CONTAINS:
				getContains().clear();
				getContains().addAll((Collection<? extends Idea>)newValue);
				return;
			case MindMapDSMLPackage.IDEA__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case MindMapDSMLPackage.IDEA__PATTERN:
				setPattern((PatternMetaModel)newValue);
				return;
			case MindMapDSMLPackage.IDEA__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection<? extends Note>)newValue);
				return;
			case MindMapDSMLPackage.IDEA__SUB_TEXT:
				setSubText((String)newValue);
				return;
			case MindMapDSMLPackage.IDEA__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case MindMapDSMLPackage.IDEA__ID:
				setId(ID_EDEFAULT);
				return;
			case MindMapDSMLPackage.IDEA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MindMapDSMLPackage.IDEA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MindMapDSMLPackage.IDEA__CONTAINS:
				getContains().clear();
				return;
			case MindMapDSMLPackage.IDEA__LINKS:
				getLinks().clear();
				return;
			case MindMapDSMLPackage.IDEA__PATTERN:
				setPattern((PatternMetaModel)null);
				return;
			case MindMapDSMLPackage.IDEA__NOTES:
				getNotes().clear();
				return;
			case MindMapDSMLPackage.IDEA__SUB_TEXT:
				setSubText(SUB_TEXT_EDEFAULT);
				return;
			case MindMapDSMLPackage.IDEA__FEATURES:
				getFeatures().clear();
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
			case MindMapDSMLPackage.IDEA__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MindMapDSMLPackage.IDEA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MindMapDSMLPackage.IDEA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case MindMapDSMLPackage.IDEA__CONTAINS:
				return contains != null && !contains.isEmpty();
			case MindMapDSMLPackage.IDEA__LINKS:
				return links != null && !links.isEmpty();
			case MindMapDSMLPackage.IDEA__PATTERN:
				return pattern != null;
			case MindMapDSMLPackage.IDEA__NOTES:
				return notes != null && !notes.isEmpty();
			case MindMapDSMLPackage.IDEA__SUB_TEXT:
				return SUB_TEXT_EDEFAULT == null ? subText != null : !SUB_TEXT_EDEFAULT.equals(subText);
			case MindMapDSMLPackage.IDEA__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", subText: ");
		result.append(subText);
		result.append(')');
		return result.toString();
	}

} //IdeaImpl
