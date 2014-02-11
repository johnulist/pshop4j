/**
 * 
 */
package com.edgaragg.pshop4j.modeling.exceptions;


import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class FieldNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2153202784256590692L;

	/**
	 * 
	 * @param pojo
	 * @param field
	 */
	public <T extends PrestaShopPojo> FieldNotFoundException(Class<T> pojo, String field) {
		super(String.format("Field %s does not exists in %s", field, pojo.getSimpleName()));
	}

	
}
