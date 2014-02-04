/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

/**
 * @author Edgar Gonzalez
 *
 */
public @interface IsPasswd {
	boolean required() default false;
	int maxSize() default 32;
}
