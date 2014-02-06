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
public @interface IsPhpDateFormat {
	boolean required() default true;
	int maxSize() default 32;
}
