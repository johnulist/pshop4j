/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.edgaragg.pshop4j.PlatformTarget;
import com.edgaragg.pshop4j.PrestaShopWebservice;



/**
 * @author Edgar Gonzalez
 *
 */
public abstract class PrestaShopRequest {
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

	
	public HttpURLConnection getConnection(String url) throws IOException{
		URL prestashopURL = new URL(this.getConnectionUrl(url));
		String contentType = this.getContentType();
		HttpURLConnection httpCon = (HttpURLConnection) prestashopURL.openConnection();
		
		// Http connection configuration is different under android
		if(PrestaShopWebservice.getTarget().equals(PlatformTarget.ANDROID)){
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod(this.getMethod());	
		}else{
			String method = this.getMethod();
			if(!method.equals("GET")){
				if(method.equals("POST")){
					httpCon.setDoInput(true);	
				}else{
					httpCon.setRequestMethod(method);
				}
			}
		}
				
		if(contentType.length() > 0){
			httpCon.setRequestProperty("Content-Type", contentType);
		}

		String body = this.getContentBody();
		// writes content to output if there is a body stream
		if(body != null && body.length() > 0){
			httpCon.setDoInput(true);
			httpCon.setRequestProperty("Content-Length", Integer.toString(body.length()));
			OutputStream output = httpCon.getOutputStream();
			output.write(body.getBytes());
			output.flush();
			output.close();
		}
		
		
		return httpCon;
	}
	

	protected abstract String getContentBody();
	
	protected abstract String getQuery();
	
	protected abstract String getIdentifier();
	
	protected abstract String getContentType();
	
	/**
	 * @param method the method to set
	 */
	protected void setMethod(String method) {
		this.method = method;
	}
	
	
	private String getConnectionUrl(String url){
		if(!url.startsWith("http")){
			url = String.format("http://%s", url);
		}
		String resource = "";
		if(this.getResource() != null && !this.getResource().equals(Resources.describe)){
			resource = this.getResource().name().concat("/");
		}
		return String.format("%s/api/%s%s%s", url, resource, this.getIdentifier(), this.getQuery());	
	}
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_HEAD = "HEAD";
	
	private Resources resource;
	private String method;

}
