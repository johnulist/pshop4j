/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class Sort extends Filter {

	public static final String ASCENDING = "ASC";
	public static final String DESCENDING = "DESC";
	public static final Sort EMPTY_SORT = new Sort("", "");
	
	private String order;
	
	/**
	 * @param field
	 */
	public Sort(String field, String order) {
		super(field);
		this.setOrder(order);
		if(!order.equals(ASCENDING) && !order.equals(DESCENDING)){
			this.setOrder(ASCENDING);
		}
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.Filter#getFilterString()
	 */
	@Override
	public String getFilterString() {
		return String.format("sort=[%s_%s]", this.getField(), this.getOrder());
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

}
