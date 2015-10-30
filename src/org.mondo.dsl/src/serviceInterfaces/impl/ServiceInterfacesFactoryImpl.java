/**
 */
package serviceInterfaces.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import serviceInterfaces.InterfaceRepository;
import serviceInterfaces.ServiceInterfacesFactory;
import serviceInterfaces.ServiceInterfacesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceInterfacesFactoryImpl extends EFactoryImpl implements ServiceInterfacesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceInterfacesFactory init() {
		try {
			ServiceInterfacesFactory theServiceInterfacesFactory = (ServiceInterfacesFactory)EPackage.Registry.INSTANCE.getEFactory(ServiceInterfacesPackage.eNS_URI);
			if (theServiceInterfacesFactory != null) {
				return theServiceInterfacesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServiceInterfacesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfacesFactoryImpl() {
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
			case ServiceInterfacesPackage.INTERFACE_REPOSITORY: return createInterfaceRepository();
			case ServiceInterfacesPackage.PACKAGE: return createPackage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRepository createInterfaceRepository() {
		InterfaceRepositoryImpl interfaceRepository = new InterfaceRepositoryImpl();
		return interfaceRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public serviceInterfaces.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfacesPackage getServiceInterfacesPackage() {
		return (ServiceInterfacesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServiceInterfacesPackage getPackage() {
		return ServiceInterfacesPackage.eINSTANCE;
	}

} //ServiceInterfacesFactoryImpl
