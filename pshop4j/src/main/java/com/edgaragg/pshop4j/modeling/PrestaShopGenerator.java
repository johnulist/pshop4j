/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.IOException;
import java.io.InputStream;

import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopGenerator {
	InputStream generate(PrestaShopPojoEntity entity) throws IOException, InvalidValueException;
}
