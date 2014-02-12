/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.lang.reflect.Field;
import java.util.List;

import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.modeling.PrestaShopPojoValidator;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.exceptions.FieldNotFoundException;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.util.Tools;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopValidator implements PrestaShopPojoValidator {

	/**
	 * 
	 */
	public PrestaShopValidator() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends PrestaShopPojo> void checkFilters(Class<T> clazz,
			List<Filter> filters) throws NotFilterableException,
			FieldNotFoundException {
		Class<T> innerClass = clazz;
		// clazz is a pojo list, we need to know the internal type of this list
		// to do that, we apply simple english rules
		//TODO: improve this, see http://www.yorku.ca/jmason/EnglishNoun.java 
		if(PrestaShopPojoList.class.isAssignableFrom(clazz)){
			String listClassName = clazz.getSimpleName();
			String entityClassName = "";
		
			if(listClassName.endsWith("sses") || listClassName.endsWith("shes") || listClassName.endsWith("ches")
					|| listClassName.endsWith("xes")){
				entityClassName = listClassName.substring(0, listClassName.length() - 2);
			}else if(listClassName.endsWith("ies")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("y");
			}else if(listClassName.endsWith("ves")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("f");
			}else if(listClassName.endsWith("ses")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("sis");
			}else{
				entityClassName = listClassName.substring(0, listClassName.length() - 1);	
			}
			
			try {
				innerClass = (Class<T>) Class.forName("com.edgaragg.pshop4j.pojos.entities." + entityClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		for(Filter filter : filters){
			Field field = Tools.getFieldForElement(innerClass, filter.getField());
			if(field == null) throw new FieldNotFoundException(innerClass, filter.getField());
			if(field.isAnnotationPresent(PrestaShopText.class)){
				PrestaShopText text = field.getAnnotation(PrestaShopText.class);
				if(text.notFilterable()){
					throw new NotFilterableException(filter);
				}
			}
		}
		
	}

}
