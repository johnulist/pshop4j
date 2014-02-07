/**
 * 
 */
package com.edgaragg.pshop4j;

import java.io.IOException;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URISyntaxException;
import java.net.URL;

import com.edgaragg.pshop4j.model.PrestaShopRequest;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.pojos.storedesc.StoreDescription;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopWebservice {
	private String url;
	private String key;
	private StoreDescription description;
	

	/**
	 * PrestaShopWebservice constructor
	 * @param url
	 * @param key
	 */
	public PrestaShopWebservice(final String url, final String key) {
		this.setUrl(url);
		this.setKey(key);
		Authenticator.setDefault (new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(key, "".toCharArray());
		    }
		});
	}
	
	protected String getConnectionUrl(PrestaShopRequest request){
		String url = this.url;
		if(!url.startsWith("http")){
			url = String.format("http://%s", url);
		}
		String resource = "";
		if(request.getResource() != null && !request.getResource().equals(Resources.describe)){
			resource = request.getResource().name().concat("/");
		}
		return String.format("%s/api/%s%s", url, resource, request.getQuery());	
	}
	
	protected HttpURLConnection getConnection(PrestaShopRequest request) throws IOException{
		URL prestashopURL = new URL(this.getConnectionUrl(request));
		try {
			System.out.printf("URL: %s\n", prestashopURL.toURI().toASCIIString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection httpCon = (HttpURLConnection) prestashopURL.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod(request.getMethod());
		return httpCon;
	}
	
	public PrestaShopResponse executeRequest(PrestaShopRequest request) throws ConnectException, IOException{		
		if(request.getMethod() == PrestaShopRequest.METHOD_GET){
			return this.executeGet(request);
		}
		return null;
	}

	protected PrestaShopResponse executeGet(PrestaShopRequest request) throws ConnectException, IOException{
		//if(request.getResource())
		HttpURLConnection connection = this.getConnection(request);
		//connection.getInputStream();
		return new PrestaShopResponse()
			.withHeaders(connection.getHeaderFields())
			.withInputStream(connection.getInputStream())
			.withCode(connection.getResponseCode())
			.withContentLength(connection.getContentLengthLong());
	}
	

	/**
	 * @return the description
	 */
	public StoreDescription getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(StoreDescription description) {
		this.description = description;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
