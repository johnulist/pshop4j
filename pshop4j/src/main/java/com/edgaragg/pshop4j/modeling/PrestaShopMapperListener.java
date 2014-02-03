/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopMapperListener {

	
	public void sendException(Exception ex);
	
	public void sendResponseHash(String hash);
	
	
	
}
