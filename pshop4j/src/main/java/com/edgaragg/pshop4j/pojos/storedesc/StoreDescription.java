/**
 * 
 */
package com.edgaragg.pshop4j.pojos.storedesc;

import java.lang.reflect.Field;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar González
 *
 */
@PrestaShopResource( Resources.describe)
@PrestaShopElement("api")
public class StoreDescription implements PrestaShopPojo{
	@PrestaShopAttribute("shop_name")
	private String shopName;
	
	@PrestaShopElement("customers")
	private StoreDescriptionItem customers;
	
	@PrestaShopElement("categories")
	private StoreDescriptionItem categories;
	
	/**
	 * 
	 */
	public StoreDescription() {

	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the customers
	 */
	public StoreDescriptionItem getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(StoreDescriptionItem customers) {
		this.customers = customers;
	}

	/**
	 * @return the categories
	 */
	public StoreDescriptionItem getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(StoreDescriptionItem categories) {
		this.categories = categories;
	}
	
	
	public boolean isAllowed(Resources resource, String method){
		
		try {
			Field resourceField = StoreDescription.class.getDeclaredField(resource.name());
			if(resourceField == null) return false;
			resourceField.setAccessible(true);
			StoreDescriptionItem resourceItem = (StoreDescriptionItem)resourceField.get(this);
			resourceField.setAccessible(false);
			
			Field methodField = StoreDescriptionItem.class.getDeclaredField(method.toLowerCase());
			if(methodField == null) return false;
			methodField.setAccessible(true);
			boolean res = methodField.getBoolean(resourceItem);
			methodField.setAccessible(false);
			return res;
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
