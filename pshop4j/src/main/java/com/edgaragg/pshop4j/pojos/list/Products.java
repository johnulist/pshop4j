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
import com.edgaragg.pshop4j.pojos.entities.Product;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.products)
@PrestaShopElement("products")
public class Products extends PrestaShopPojoList<Product>{

	@PrestaShopElement("product")
	@PrestaShopList(Product.class)
	private List<Product> products;
	
	/**
	 * 
	 */
	public Products() {
		super();
	}

	@Override
	protected List<Product> createInnerList() {
		this.products = new ArrayList<Product>();
		return this.products;
	}
}
