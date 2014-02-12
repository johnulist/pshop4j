/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.InputStream;

import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopXMLGenerator {
	InputStream generate(PrestaShopPojoEntity entity);
}
