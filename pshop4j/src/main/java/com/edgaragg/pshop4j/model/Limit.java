/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class Limit extends Filter {

	public static final Limit EMPTY_LIMIT = new Limit("", 0);
	
	private int limit;
	private int start = -1;
	
	/**
	 * @param field
	 * @param limit
	 */
	public Limit(String field, int limit) {
		super(field);
	}
	
	/**
	 * @param field
	 * @param start
	 */
	public Limit(String field, int limit, int start) {
		super(field);
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.Filter#getFilterString()
	 */
	@Override
	public String getFilterString() {
		if(this.start < 0){
			return String.format("limit=%d", this.getLimit());
		}
		else{
			return String.format("limit=%d,%d", this.start, this.getLimit());
		}
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

}
