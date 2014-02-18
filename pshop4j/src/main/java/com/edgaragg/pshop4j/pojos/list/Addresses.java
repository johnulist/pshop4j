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
import com.edgaragg.pshop4j.pojos.entities.Address;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.addresses)
@PrestaShopElement("addresses")
public class Addresses extends PrestaShopPojoList<Address> {
	@PrestaShopElement("address")
	@PrestaShopList(Address.class)
	private List<Address> addresses;
	
	@Override
	protected List<Address> createInnerList() {
		this.addresses = new ArrayList<Address>();
		return this.addresses;
	}

}
