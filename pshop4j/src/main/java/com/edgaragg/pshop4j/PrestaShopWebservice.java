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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.edgaragg.pshop4j.model.PrestaShopRequest;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
import com.edgaragg.pshop4j.modeling.exceptions.PrestaShopServerException;
import com.edgaragg.pshop4j.pojos.storedesc.StoreDescription;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopWebservice {
	
	private static final Pattern ERROR_PATTERN = Pattern.compile("[\\w\\W\\n]*<code><!\\[CDATA\\[(\\d*)\\]\\]></code>[\\w\\W\\n]*<message><!\\[CDATA\\[(.*)\\]\\]></message>[\\w\\W\\n]*");
	private static PlatformTarget target = PlatformTarget.OTHER;
	
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
	 * @throws PrestaShopServerException 
	 */
	public PrestaShopResponse executeRequest(PrestaShopRequest request) throws ConnectException, IOException, PrestaShopServerException{
		HttpURLConnection connection = request.getConnection(this.url);
		try{
			return new PrestaShopResponse()
			.withHeaders(connection.getHeaderFields())
			.withInputStream(connection.getInputStream())
			.withCode(connection.getResponseCode())
			.withContentLength(connection.getContentLengthLong());	
		}catch(IOException ex){
			InputStream stream = connection.getErrorStream();
			if(stream == null){
				throw ex;
			}else{
				this.createPrestaShopException(stream);
			}
		}
		return null;
	}

	/**
	 * @param stream
	 * @throws PrestaShopServerException 
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	private void createPrestaShopException(InputStream stream) throws PrestaShopServerException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder builder = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null){
			builder.append(line);
		}
		
		Matcher matcher = ERROR_PATTERN.matcher(builder.toString());
		if(matcher.matches()){
			throw new PrestaShopServerException(Integer.parseInt(matcher.group(1)), matcher.group(2));
		}else{
			throw new PrestaShopServerException(Integer.MIN_VALUE, "Unknown exception");
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
	
	
	public static void setTarget(PlatformTarget t){
		PrestaShopWebservice.target = t;
	}
	
	public static PlatformTarget getTarget(){
		return PrestaShopWebservice.target;
	}
}
