/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
//		try {
//			System.out.printf("URL: %s\n", prestashopURL.toURI().toASCIIString());
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		HttpURLConnection httpCon = (HttpURLConnection) prestashopURL.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod(this.getMethod());
		return httpCon;
	}
	

	protected abstract InputStream getContentBody();
	
	protected abstract String getQuery();
	
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
		return String.format("%s/api/%s%s", url, resource, this.getQuery());	
	}
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_HEAD = "HEAD";
	
	private Resources resource;
	private String method;

}
