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
public class PutRequest extends PrestaShopRequest {

	private String entityStream;
	private long id;
	
	/**
	 * 
	 */
	public PutRequest() {
		this.setMethod(METHOD_PUT);
	}
	
	public PutRequest withEntityStream(InputStream entityStream){
		byte[] buffer = new byte[10240];
		int read = 0;
		StringBuilder builder = new StringBuilder();
		try {
			while((read = entityStream.read(buffer)) >= 0){
				builder.append(new String(buffer, 0, read));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.entityStream = builder.toString();
		return this;
	}
	
	public PutRequest withEntityStream(String entity){
		this.entityStream = entity;
		return this;
	}
	
	public PutRequest withResource(Resources resource){
		this.setResource(resource);
		return this;
	}
	
	public PutRequest withId(long id){
		this.id = id;
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
