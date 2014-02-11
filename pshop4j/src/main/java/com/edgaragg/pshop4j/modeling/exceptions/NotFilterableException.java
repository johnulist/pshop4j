/**
 * 
 */
package com.edgaragg.pshop4j.modeling.exceptions;

import com.edgaragg.pshop4j.model.Filter;

/**
 * @author Edgar Gonzalez
 *
 */
public class NotFilterableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2973795888527098663L;

	/**
	 * 
	 */
	public NotFilterableException(Filter invalidFilter) {
		super(String.format("Prestashop can not filter using the attribute %s", invalidFilter.getField()));
	}

}
