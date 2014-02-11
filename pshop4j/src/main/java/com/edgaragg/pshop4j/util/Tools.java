/**
 * 
 */
package com.edgaragg.pshop4j.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopIntegerEnum;
import com.edgaragg.pshop4j.modeling.enums.PriceDisplayMethod;

/**
 * @author Edgar Gonzalez
 *
 */
public class Tools {

	/**
	 * Map for PShop enum values.  The key is the class name and the value is an array with the enum values
	 */
	private static Map<String, PShopIntegerEnum[]> pshopEnumsValues;
	
	static{
		pshopEnumsValues = new HashMap<String, PShopIntegerEnum[]>();
		pshopEnumsValues.put("PShopBoolean", PShopBoolean.values());
		pshopEnumsValues.put("PriceDisplayMethod", PriceDisplayMethod.values());
	}
	
	
//	public static String encrypt(String textToEncrypt){
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(textToEncrypt.getBytes());
//			byte[] digest = md.digest();
//			StringBuffer sb = new StringBuffer();
//			for (byte b : digest) {
//				sb.append(Integer.toHexString(0x100 | (b & 0xff)).substring(1));
//			}
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//	
	
	public static <T> PShopIntegerEnum intToPShopIntegerEnum(Class<T> clazz, int value){
		if(!clazz.isEnum() || !PShopIntegerEnum.class.isAssignableFrom(clazz)) 
			return null;
		String key = clazz.getSimpleName();		
		return pshopEnumsValues.get(key)[value];
	}
	
	
	/**
	 * 
	 * @param searchClazz
	 * @param element
	 * @return
	 */
	public static Field getFieldForElement(Class<?> searchClazz, String element){
		Field[] fields = searchClazz.getDeclaredFields();
		for(Field field : fields){
			PrestaShopElement fieldElement = field.getAnnotation(PrestaShopElement.class);
			PrestaShopText fieldText = field.getAnnotation(PrestaShopText.class);
			
			if((fieldElement != null && fieldElement.value().equals(element)) || 
					(fieldText != null && fieldText.value().equals(element))){
				return field;
			}
		}
		return null;
	}

}
