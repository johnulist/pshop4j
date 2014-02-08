/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.util.List;
import java.util.Map;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopMapperResponse<T extends PrestaShopPojo> {

	private T resource;
	private String hash;
	private Map<String, List<String>> headers;
	private Exception exception;
	
	/**
	 * 
	 */
	public PrestaShopMapperResponse() {

	}
	
	protected PrestaShopMapperResponse<T> withResource(T resource){
		this.resource = resource;
		return this;
	}
	
	protected PrestaShopMapperResponse<T> withHeaders(Map<String, List<String>> headers){
		this.headers = headers;
		return this;
	}

	protected PrestaShopMapperResponse<T> withHash(String hash){
		this.hash = hash;
		return this;
	}
	
	protected PrestaShopMapperResponse<T> withException(Exception exception){
		this.exception = exception;
		return this;
	}
	
	/**
	 * @return the resource
	 */
	public T getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(T resource) {
		this.resource = resource;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the headers
	 */
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	

}
