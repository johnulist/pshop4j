/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.InputStream;

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
	public InputStream getContentBody() {
		return null;
	}
	
	

}
