/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.pojos.entities.Cart;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.carts)
@PrestaShopElement("carts")
public class Carts extends PrestaShopPojoList<Cart> {
	@PrestaShopElement("cart")
	@PrestaShopList(Cart.class)
	List<Cart> carts;
	
	@Override
	protected List<Cart> createInnerList() {
		this.carts = new ArrayList<Cart>();
		return this.carts;
	}

}
