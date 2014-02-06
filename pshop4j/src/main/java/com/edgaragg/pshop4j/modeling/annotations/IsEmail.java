/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Edgar Gonzalez
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsEmail {
	boolean required() default false;
	int maxSize() default 128;
	String regex() default "^[a-z0-9!#$%&\'*+\\/=?^`{}|~_-]+[.a-z0-9!#$%&\'*+\\/=?^`{}|~_-]*@[a-z0-9]+[._a-z0-9-]*\\.[a-z0-9]+$";
}
