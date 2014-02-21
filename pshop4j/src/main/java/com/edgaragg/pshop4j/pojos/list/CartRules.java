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
import com.edgaragg.pshop4j.pojos.entities.CartRule;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.cart_rules)
@PrestaShopElement("cart_rules")
public class CartRules extends PrestaShopPojoList<CartRule> {
	@PrestaShopElement("carrier")
	@PrestaShopList(CartRule.class)
	private List<CartRule> rules;
	
	@Override
	protected List<CartRule> createInnerList() {
		this.rules = new ArrayList<CartRule>();
		return this.rules;
	}

}
