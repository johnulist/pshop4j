/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.util.List;

import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.modeling.exceptions.FieldNotFoundException;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopPojoValidator {
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @throws NotFilterableException
	 * @throws FieldNotFoundException
	 */
	<T extends PrestaShopPojo> void checkFilters(Class<T> clazz, List<Filter> filters) throws NotFilterableException, FieldNotFoundException;
	/**
	 * Validate an object against some specification
	 * @param opaque specification for the field to validate
	 * @param fieldValue value of the field
	 * @return true if the field is validated against its specification, false otherwise
	 * @throws InvalidValueException 
	 */
	void validate(Object opaque, Object fieldValue) throws InvalidValueException;
	
	/**
	 * Check in the specification of the field if it will be included in the result
	 * @param opaque contains the specification for the field
	 * @return true if the field should be included in the result, false otherwise
	 */
	boolean includeInResult(Object opaque);
}
