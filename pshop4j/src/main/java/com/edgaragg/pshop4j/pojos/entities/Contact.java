/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.contacts)
@PrestaShopElement("contact")
public class Contact implements PrestaShopPojoEntity {

	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long id;
	
	@PrestaShopText(value = "email", format = PShopFormat.isEmail)
	private String email;
	
	@PrestaShopText(value = "customer_service", format = PShopFormat.isBool)
	private PShopBoolean customerService;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "name", format = PShopFormat.isGenericName, required = true)
	private LanguageElements name;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "description", format = PShopFormat.isCleanHtml)
	private LanguageElements description;
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#getId()
	 */
	@Override
	public long getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the customerService
	 */
	public PShopBoolean getCustomerService() {
		return customerService;
	}

	/**
	 * @param customerService the customerService to set
	 */
	public void setCustomerService(PShopBoolean customerService) {
		this.customerService = customerService;
	}

	/**
	 * @return the name
	 */
	public LanguageElements getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(LanguageElements name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public LanguageElements getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(LanguageElements description) {
		this.description = description;
	}
	
}
