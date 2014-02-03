/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.InputStream;

/**
 * @author Edgar Gonzalez
 *
 */
public abstract class PrestaShopRequest {
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_HEAD = "HEAD";
	
	private Resources resource;
	private String method;


	/**
	 * @return the resource
	 */
	public Resources getResource() {
		return resource;
	}


	/**
	 * @param resource the resource to set
	 */
	public void setResource(Resources resource) {
		this.resource = resource;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	protected void setMethod(String method) {
		this.method = method;
	}
	
	
	public abstract String getQuery();
	
	public abstract InputStream getContentBody();

}
