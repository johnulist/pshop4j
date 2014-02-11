/**
 * 
 */
package com.edgaragg.pshop4j.modeling.exceptions;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class InvalidResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1500049905307227993L;

	/**
	 * @param <T>
	 * 
	 */
	public <T extends PrestaShopPojo> InvalidResourceException(Class<T> clazz) {
		super(String.format("Resource not found in %s", clazz.getSimpleName()));
	}


}
