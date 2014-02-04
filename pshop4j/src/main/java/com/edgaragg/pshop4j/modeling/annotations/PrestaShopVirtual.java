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
 * A virtual field is any read only field.  That means, we can read it, but we can not assign a value or change it. 
 * This value can't be sent via POST or PUT. <br/>
 * Any missing field in the synopsis is considered virtual. <br/>  
 * The id is a virtual field
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrestaShopVirtual {
	
}
