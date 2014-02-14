/**
 * 
 */
package com.edgaragg.pshop4j.model;

/**
 * @author Edgar Gonzalez
 *
 */
public class DescribeRequest extends PrestaShopRequest {

	/**
	 * 
	 */
	public DescribeRequest() {
		this.setResource(Resources.describe);
		this.setMethod(METHOD_GET);
	}

	@Override
	public String getQuery() {
		return "";
	}

	@Override
	public String getContentBody() {
		return null;
	}

	@Override
	protected String getIdentifier() {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentType()
	 */
	@Override
	protected String getContentType() {
		return "";
	}
	

}
