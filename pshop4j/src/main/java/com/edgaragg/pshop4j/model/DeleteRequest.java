/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class DeleteRequest extends PrestaShopRequest {

	private long id;
	
	/**
	 * 
	 */
	public DeleteRequest() {
		this.setMethod(METHOD_DELETE);
	}

	/**
	 * Assign the resource
	 * @param resource the resource to set
	 * @return current PrestaShopRequest object
	 */
	public DeleteRequest withResource(Resources resource){
		this.setResource(resource);
		return this;
	}
	
	public DeleteRequest withId(long id){
		this.setId(id);
		return this;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentBody()
	 */
	@Override
	protected String getContentBody() {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getQuery()
	 */
	@Override
	protected String getQuery() {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getIdentifier()
	 */
	@Override
	protected String getIdentifier() {
		return Long.toString(this.id);
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentType()
	 */
	@Override
	protected String getContentType() {
		return "";
	}
	
	

}
