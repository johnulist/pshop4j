/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class BeginsFilter extends Filter{

	private String value;
	/**
	 * 
	 */
	public BeginsFilter(String field, String value) {
		super(field);
	}
	
	@Override
	public String getFilterString() {
		return String.format("filter[%s]=[%s]%", this.getField(), this.getValue());
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
