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
 * @author Edgar Gonzalez
 * Matches any element in the XML with any object field
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrestaShopElement {
	String value();
	PShopFormat format() default PShopFormat.isUndefined;
	boolean required() default false;
	int maxSize() default Integer.MAX_VALUE;
}
