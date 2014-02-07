/**
 * 
 */
package com.edgaragg.pshop4j.modeling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.edgaragg.pshop4j.modeling.enums.LanguageCodeType;

/**
 * @author Edgar Gonzalez
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsLanguageCode {
	LanguageCodeType type();
	boolean required() default false;
	int maxSize() default 5;
}
