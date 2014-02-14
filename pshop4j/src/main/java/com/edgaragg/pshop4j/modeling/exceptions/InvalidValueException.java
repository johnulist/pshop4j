/**
 * 
 */
package com.edgaragg.pshop4j.modeling.exceptions;


/**
 * @author Edgar Gonzalez
 *
 */
public class InvalidValueException extends Exception {

	public static final String REASON_REQUIRED = "Field is required";
	public static final String REASON_MAX_SIZE = "Field length is larger than its max size";
	public static final String REASON_REGEX = "Field doesn't match its regular expression";
	public static final String REASON_NON_COMPATIBLE_OPTIONS = "Field options not compatible. (required and nullOnZero are both true)";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7870622201204238626L;

	/**
	 * 
	 */
	public InvalidValueException(String field, String reason) {
		super(String.format("Invalid value for field \"%s\".  Reason: %s", field, reason));
	}

}