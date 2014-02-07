package com.edgaragg.pshop4j.modeling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.edgaragg.pshop4j.model.Resources;

/**
 * @author Edgar Gonzalez
 * Indicates the PrestaShop resource associated with this type
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrestaShopResource {
	Resources value();
}

