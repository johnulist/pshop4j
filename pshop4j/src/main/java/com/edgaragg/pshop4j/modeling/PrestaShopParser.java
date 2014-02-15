/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.InputStream;
import java.util.List;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopParser {

	<T extends PrestaShopPojo> T parse(Class<T> clazz, InputStream stream);
	<T extends PrestaShopPojo> List<T> parseList(Class<T> clazz, InputStream stream);
	
}
