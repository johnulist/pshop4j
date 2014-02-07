/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

/**
 * @author Edgar Gonzalez
 *
 */
public @interface IsBarcode {
	String regex() ;
	int maxSize();
}
