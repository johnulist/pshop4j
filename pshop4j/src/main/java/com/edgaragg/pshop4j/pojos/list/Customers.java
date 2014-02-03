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
@PrestaShopResource(resource = Resources.customers)
@PrestaShopElement(name = "customers")
public class Customers implements PrestaShopPojoList<Customer> {

	@PrestaShopElement(name = "customer")
	@PrestaShopList(type=Customer.class)
	private List<Customer> customers;
	
	/**
	 * 
	 */
	public Customers() {
		this.customers = new ArrayList<Customer>();
	}
	
	public int size(){
		return this.customers.size();
	}

	@Override
	public Customer get(int index) {
		return (this.customers.size() < index) ? null : this.customers.get(index);
	}

	@Override
	public void add(Customer newObject) {
		this.customers.add(newObject);
		
	}
	

}
