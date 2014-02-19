/**
 * 
 */
package com.edgaragg.pshop4j.modeling.exceptions;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopServerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5989377321543105181L;
	private int code;
	
	/**
	 * 
	 */
	public PrestaShopServerException(int code, String message) {
		super(String.format("PrestaShop Server error: %s", message));
		this.setCode(code);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	protected void setCode(int code) {
		this.code = code;
	}



}
