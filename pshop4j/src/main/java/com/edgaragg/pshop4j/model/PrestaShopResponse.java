/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopResponse {

	private int code;
	private long contentLengthLength;
	private InputStream stream;
	private Map<String, List<String>> headers;
	
	/**
	 * 
	 */
	public PrestaShopResponse() {

	}
	
	public PrestaShopResponse withInputStream(InputStream stream){
		this.stream = stream;
		return this;
	}
	
	public PrestaShopResponse withCode(int code){
		this.code = code;
		return this;
	}
	
	public PrestaShopResponse withHeaders(Map<String, List<String>> headers){
		this.headers = headers;
		return this;
	}
	
	public PrestaShopResponse withContentLength(long contentLength){
		this.contentLengthLength = contentLength;
		return this;
	}

	/**
	 * @return the returnCode
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param returnCode the returnCode to set
	 */
	public void setCode(int returnCode) {
		this.code = returnCode;
	}

	/**
	 * @return the stream
	 */
	public InputStream getStream() {
		return stream;
	}

	/**
	 * @param stream the stream to set
	 */
	public void setStream(InputStream stream) {
		this.stream = stream;
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
	 * @return the contentLengthLength
	 */
	public long getContentLengthLength() {
		return contentLengthLength;
	}

	/**
	 * @param contentLengthLength the contentLengthLength to set
	 */
	public void setContentLengthLength(long contentLengthLength) {
		this.contentLengthLength = contentLengthLength;
	}

	
	
}
