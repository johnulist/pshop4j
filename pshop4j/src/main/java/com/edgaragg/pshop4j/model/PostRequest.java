/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Edgar Gonzalez
 *
 */
public class PostRequest extends PrestaShopRequest {

private String entityStream;
	
	/**
	 * 
	 */
	public PostRequest() {
		this.setMethod(METHOD_POST);
	}
	
	public PostRequest withResource(Resources resource){
		this.setResource(resource);
		return this;
	}
	
	public PostRequest withEntityStream(InputStream entityStream){
		byte[] buffer = new byte[10240];
		int read = 0;
		StringBuilder builder = new StringBuilder();
		try {
			while((read = entityStream.read(buffer)) >= 0){
				builder.append(new String(buffer, 0, read));
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
		this.entityStream = builder.toString();
		return this;
	}
	
	public PostRequest withEntityStream(String entity){
		this.entityStream = entity;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentBody()
	 */
	@Override
	protected String getContentBody() {
		return this.entityStream;
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
		return "";
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentType()
	 */
	@Override
	protected String getContentType() {
		return "application/x-www-form-urlencoded";
	}
	
	
	
	

}
