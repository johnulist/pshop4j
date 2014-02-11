/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class SingleValueFilter extends Filter{

	private Object value;
	
	/**
	 * 
	 */
	public SingleValueFilter(String field, Object value) {
		super(field);
		this.setValue(value);
	}

	@Override
	public String getFilterString() {
		return String.format("filter[%s]=[%s]", this.getField(), this.getValue().toString());
	}

	/**
	 * @return the value
	 */
	private Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	private void setValue(Object value) {
		this.value = value;
	}
	
	

}
