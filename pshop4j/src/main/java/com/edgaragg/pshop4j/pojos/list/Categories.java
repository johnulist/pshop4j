/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.entities.Category;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(resource = Resources.categories)
@PrestaShopElement(name = "categories")
public class Categories extends PrestaShopPojoList<Category> {

	private List<Category> categories;
	/**
	 * 
	 */
	public Categories() {
		super();
		this.categories = new ArrayList<Category>();
		this.setList(this.categories);
	}
}
