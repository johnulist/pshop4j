/**
 * 
 */
package com.edgaragg.pshop4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;

import com.edgaragg.pshop4j.model.PrestaShopRequest;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
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
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws IOException
	 */
	public PrestaShopResponse executeRequest(PrestaShopRequest request) throws ConnectException, IOException{
		HttpURLConnection connection = request.getConnection(this.url);
		try{
			return new PrestaShopResponse()
			.withHeaders(connection.getHeaderFields())
			.withInputStream(connection.getInputStream())
			.withCode(connection.getResponseCode())
			.withContentLength(connection.getContentLengthLong());	
		}catch(IOException ex){
			InputStream stream = connection.getErrorStream();
			if(stream != null){
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				String line;
				while((line = reader.readLine()) != null){
					System.out.println(line);
				}
			}
			
			
			throw ex;
		}
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
