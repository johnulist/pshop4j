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
import com.edgaragg.pshop4j.pojos.entities.Contact;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.contacts)
@PrestaShopElement("contacts")
public class Contacts extends PrestaShopPojoList<Contact> {

	@PrestaShopElement("contact")
	@PrestaShopList(Contact.class)
	private List<Contact> contacts;
	
	@Override
	protected List<Contact> createInnerList() {
		this.contacts = new ArrayList<Contact>();
		return this.contacts;
	}

}
