/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public abstract class Filter {

	private String field;
	
	/**
	 * 
	 */
	public Filter(String field) {
		this.setField(field);
	}

	public abstract String getFilterString();

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
}
