package com.edgaragg.pshop4j.model;

public class BetweenFilter extends Filter {

	private Object valueFrom, valueTo;
	
	public BetweenFilter(String field, Object valueFrom, Object valueTo) {
		super(field);
		this.setValueFrom(valueFrom); 
		this.setValueTo(valueTo);
	}

	@Override
	public String getFilterString() {
		return String.format("filter[%s]=[%s,%s]", this.getField(), this.getValueFrom().toString(), this.getValueTo().toString());
	}

	/**
	 * @return the valueFrom
	 */
	public Object getValueFrom() {
		return valueFrom;
	}

	/**
	 * @param valueFrom the valueFrom to set
	 */
	public void setValueFrom(Object valueFrom) {
		this.valueFrom = valueFrom;
	}

	/**
	 * @return the valueTo
	 */
	public Object getValueTo() {
		return valueTo;
	}

	/**
	 * @param valueTo the valueTo to set
	 */
	public void setValueTo(Object valueTo) {
		this.valueTo = valueTo;
	}

}
