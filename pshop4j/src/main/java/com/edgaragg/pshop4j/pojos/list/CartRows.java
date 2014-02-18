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
import com.edgaragg.pshop4j.pojos.entities.CartRow;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.cart_row)
@PrestaShopElement("cart_rows")
public class CartRows extends PrestaShopPojoList<CartRow> {

	@PrestaShopElement("cart_row")
	@PrestaShopList(CartRow.class)
	private List<CartRow> rows;
	
	@Override
	protected List<CartRow> createInnerList() {
		this.rows = new ArrayList<CartRow>();
		return this.rows;
	}

}
