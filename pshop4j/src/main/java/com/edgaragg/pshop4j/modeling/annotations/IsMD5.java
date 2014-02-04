/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Edgar González
 * Indicates that this field is MD5
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMD5 {
	String regex() default "^[a-f0-9A-F]{32}$";
}
