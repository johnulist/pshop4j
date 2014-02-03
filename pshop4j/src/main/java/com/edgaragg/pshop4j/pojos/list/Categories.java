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
public class Categories implements PrestaShopPojoList<Category> {

	private List<Category> categories;
	/**
	 * 
	 */
	public Categories() {
		this.categories = new ArrayList<Category>();
	}

	@Override
	public Category get(int index) {
		return this.categories.size() < index ? null : this.categories.get(index);
	}

	@Override
	public void add(Category newObject) {
		this.categories.add(newObject);		
	}

	@Override
	public int size() {
		return this.categories.size();
	}

}
