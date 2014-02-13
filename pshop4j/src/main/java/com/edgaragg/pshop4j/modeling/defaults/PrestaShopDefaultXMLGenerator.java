/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.IOException;
import java.io.InputStream;

import com.edgaragg.pshop4j.modeling.PrestaShopPojoValidator;
import com.edgaragg.pshop4j.modeling.PrestaShopXMLGenerator;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopDefaultXMLGenerator implements PrestaShopXMLGenerator,
		PrestaShopPojo {
	
	private PrestaShopPojoValidator validator;
	
	/**
	 * 
	 */
	public PrestaShopDefaultXMLGenerator() {
		this.validator = new PrestaShopValidator();
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.modeling.PrestaShopXMLGenerator#generate(com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity)
	 */
	@Override
	public InputStream generate(PrestaShopPojoEntity entity) throws IOException, InvalidValueException {
		InternalEntityReader reader = new InternalEntityReader(entity, this.validator);
		return new InternalXMLInputStream(reader.readAll());
	}
	
}
