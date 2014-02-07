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
import com.edgaragg.pshop4j.pojos.entities.Customer;


/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.customers)
@PrestaShopElement("customers")
public class Customers extends PrestaShopPojoList<Customer> {

	@PrestaShopElement("customer")
	@PrestaShopList(Customer.class)
	private List<Customer> customers;
	
	/**
	 * 
	 */
	public Customers() {
		super();
	}

	@Override
	protected List<Customer> createInnerList() {
		this.customers = new ArrayList<Customer>();
		return this.customers;
	}
	

}
