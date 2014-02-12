/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.util.List;

import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.modeling.exceptions.FieldNotFoundException;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopPojoValidator {
	<T extends PrestaShopPojo> void checkFilters(Class<T> clazz, List<Filter> filters) throws NotFilterableException, FieldNotFoundException;
}
