/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.edgaragg.pshop4j.modeling.enums.PShopFormat;

/**
 * Associates the text of the element with any field on the object
 * @author Edgar Gonzalez
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrestaShopText {
	String value();
	PShopFormat format();
	boolean notFilterable() default false;
	boolean required() default false;
	boolean isVirtual() default false;
	/**
	 * When making a POST or PUT request, sent an empty tag (null value) if
	 * the value of the field is 0<br/>
	 * nullOnZero = true is not compatible with required = true
	 * @return
	 */
	boolean nullOnZero() default false;
	int maxSize() default Integer.MAX_VALUE;
}
