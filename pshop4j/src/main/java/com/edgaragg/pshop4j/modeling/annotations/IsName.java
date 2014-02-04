/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

/**
 * @author Edgar
 *
 */
public @interface IsName {
	boolean required() default false;
	int maxSize() default 32;
}
