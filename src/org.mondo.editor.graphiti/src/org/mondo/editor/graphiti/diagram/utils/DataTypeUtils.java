package org.mondo.editor.graphiti.diagram.utils;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * Class of utility functions to work with DataTypes.
 * 
 * @author miso partner AnaPescador
 *
 */

public class DataTypeUtils {

	public enum DataType {
		EBIGDECIMAL(EcoreFactory.eINSTANCE.getEcorePackage().getEBigDecimal()), 
		EBIGINTEGER (EcoreFactory.eINSTANCE.getEcorePackage().getEBigInteger()),
		EBOOLEAN (EcoreFactory.eINSTANCE.getEcorePackage().getEBoolean()),
		EBOOLEANOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEBooleanObject()),
		EBYTE (EcoreFactory.eINSTANCE.getEcorePackage().getEByte()),
		EBYTEARRAY (EcoreFactory.eINSTANCE.getEcorePackage().getEByteArray()),
	    EBYTEOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEByteObject()),
	    ECHAR (EcoreFactory.eINSTANCE.getEcorePackage().getEChar()),
	    ECHARACTEROBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getECharacterObject()),
	    EDATE (EcoreFactory.eINSTANCE.getEcorePackage().getEDate()),
	    EDIAGNOSTICCHAIN (EcoreFactory.eINSTANCE.getEcorePackage().getEDiagnosticChain()),
		EDOUBLE (EcoreFactory.eINSTANCE.getEcorePackage().getEDouble()),
		EDOUBLEOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEDoubleObject()),	
		EELIST (EcoreFactory.eINSTANCE.getEcorePackage().getEEList()),	
		EENUMERATOR (EcoreFactory.eINSTANCE.getEcorePackage().getEEnumerator()),	
		EFEATUREMAP (EcoreFactory.eINSTANCE.getEcorePackage().getEFeatureMap()),
		EFEATUREMAPENTRY (EcoreFactory.eINSTANCE.getEcorePackage().getEFeatureMapEntry()),
		EFLOAT (EcoreFactory.eINSTANCE.getEcorePackage().getEFloat()),
		EFLOATOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEFloatObject()),
		EINT (EcoreFactory.eINSTANCE.getEcorePackage().getEInt()),
		EINTEGEROBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEIntegerObject()),	
		EJAVACLASS (EcoreFactory.eINSTANCE.getEcorePackage().getEJavaClass()),	
		EJAVAOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEJavaObject()),
		ELONG (EcoreFactory.eINSTANCE.getEcorePackage().getELong()),
		ELONGOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getELongObject()),
		EMAP (EcoreFactory.eINSTANCE.getEcorePackage().getEMap()),
		ERESOURCE (EcoreFactory.eINSTANCE.getEcorePackage().getEResource()),
		ERESOURCESET (EcoreFactory.eINSTANCE.getEcorePackage().getEResourceSet()),
		EINVOCATIONTARGETEXCEPTION (EcoreFactory.eINSTANCE.getEcorePackage().getEInvocationTargetException()),
		ESHORT (EcoreFactory.eINSTANCE.getEcorePackage().getEShort()),
		ESHORTOBJECT (EcoreFactory.eINSTANCE.getEcorePackage().getEShortObject()),
		ESTRING (EcoreFactory.eINSTANCE.getEcorePackage().getEString()),
		ETREEITERATOR (EcoreFactory.eINSTANCE.getEcorePackage().getETreeIterator()); 
		
		private final EDataType eDataType;   
	    private final String text; 
	    
	    DataType(EDataType eDataType) {
	        this.eDataType = eDataType;
	        this.text = eDataType.getName()+" ["+eDataType.getInstanceClassName()+"]";
	    }
	    
	    public final EDataType getEDataType(){
	    	return this.eDataType;
	    }
	    
	    public final String getText(){
	    	return this.text;
	    }
	}
	
	/**
	 * Static method that returns the DataType related to the specified text
	 * @param text - String
	 * @return DataType
	 */
	public static DataType getDataType(String text){
		for (DataType dt: DataType.values()){
			if (dt.getText().compareTo(text)==0)
				return dt;
		}
		return null;		
	}
	
	/**
	 * Static method that returns the DataType related to the specified EDataType
	 * @param edt - EDataType
	 * @return - DataType
	 */
	public static DataType getDataType(EDataType edt){
		for (DataType dt: DataType.values()){
			if (dt.getEDataType().equals(edt))
				return dt;
		}
		return null;		
	}
	
	/**
	 * Static method that returns the DataType index
	 * @param dt - DataType
	 * @return ordinal of the datatype.
	 */
	public static int getIndex(DataType dt){
		return dt.ordinal();		
	}
	

}
