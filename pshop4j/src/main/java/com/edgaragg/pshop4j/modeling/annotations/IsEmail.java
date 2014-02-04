/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

/**
 * @author Edgar Gonzalez
 *
 */
public @interface IsEmail {
	boolean required() default false;
	int maxSize() default 128;
	String regex() default "^[a-z0-9!#$%&\'*+\\/=?^`{}|~_-]+[.a-z0-9!#$%&\'*+\\/=?^`{}|~_-]*@[a-z0-9]+[._a-z0-9-]*\\.[a-z0-9]+$";
}
