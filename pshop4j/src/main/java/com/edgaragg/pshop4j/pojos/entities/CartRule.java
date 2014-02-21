/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.cart_rules)
@PrestaShopElement("cart_rule")
public class CartRule implements PrestaShopPojoEntity {

	private long id;
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#getId()
	 */
	@Override
	public long getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

}
