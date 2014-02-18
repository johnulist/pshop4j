/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;


import java.util.Date;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.addresses)
@PrestaShopElement(value = "address")
public class Address implements PrestaShopPojoEntity {

	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long id;
	
	@PrestaShopText(value = "id_customer", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long idCustomer;
	
	@PrestaShopText(value = "id_manufacturer", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long idManufacturer;
	
	@PrestaShopText(value = "id_supplier", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long idSupplier;
	
	@PrestaShopText(value = "id_warehouse", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long idWarehouse;
	
	@PrestaShopText(value = "id_country", format = PShopFormat.isUnsignedId, required = true)
	private long idCountry;
	
	@PrestaShopText(value = "id_state", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long idState;
	
	@PrestaShopText(value = "alias", format = PShopFormat.isGenericName, required = true, maxSize = 32)
	private String alias;
	
	@PrestaShopText(value = "company", format = PShopFormat.isGenericName, maxSize = 64)
	private String company;
	
	@PrestaShopText(value = "lastname", format = PShopFormat.isName, maxSize = 32, required = true)
	private String lastname;
	
	@PrestaShopText(value = "firstname", format = PShopFormat.isName, maxSize = 32, required = true)
	private String firstname;
	
	@PrestaShopText(value = "vat_number", format = PShopFormat.isGenericName)
	private String vatNumber;
	
	@PrestaShopText(value = "address1", format = PShopFormat.isAddress, required = true, maxSize = 128)
	private String address1;
	
	@PrestaShopText(value = "address2", format = PShopFormat.isAddress, maxSize = 128)
	private String address2;
	
	@PrestaShopText(value = "postcode", format = PShopFormat.isPostCode, maxSize = 12)
	private String postCode;
	
	@PrestaShopText(value = "city", format = PShopFormat.isCityName, required = true, maxSize = 64)
	private String city;	
	
	@PrestaShopText(value = "other", format = PShopFormat.isMessage, maxSize = 300)
	private String other;	
	
	@PrestaShopText(value = "phone", format = PShopFormat.isPhoneNumber, maxSize = 32)
	private String phone;
		
	@PrestaShopText(value = "phone_mobile", format = PShopFormat.isPhoneNumber, maxSize = 32)
	private String phoneMobile;
		
	@PrestaShopText(value = "dni", format = PShopFormat.isDniLite, maxSize = 16)
	private String dni;
		
	@PrestaShopText(value = "deleted", format = PShopFormat.isBool)
	private PShopBoolean deleted;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateAdd;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateUpd;
	
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the idCustomer
	 */
	public long getIdCustomer() {
		return idCustomer;
	}

	/**
	 * @param idCustomer the idCustomer to set
	 */
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	/**
	 * @return the idManufacturer
	 */
	public long getIdManufacturer() {
		return idManufacturer;
	}

	/**
	 * @param idManufacturer the idManufacturer to set
	 */
	public void setIdManufacturer(long idManufacturer) {
		this.idManufacturer = idManufacturer;
	}

	/**
	 * @return the idSupplier
	 */
	public long getIdSupplier() {
		return idSupplier;
	}

	/**
	 * @param idSupplier the idSupplier to set
	 */
	public void setIdSupplier(long idSupplier) {
		this.idSupplier = idSupplier;
	}

	/**
	 * @return the idWarehouse
	 */
	public long getIdWarehouse() {
		return idWarehouse;
	}

	/**
	 * @param idWarehouse the idWarehouse to set
	 */
	public void setIdWarehouse(long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	/**
	 * @return the idCountry
	 */
	public long getIdCountry() {
		return idCountry;
	}

	/**
	 * @param idCountry the idCountry to set
	 */
	public void setIdCountry(long idCountry) {
		this.idCountry = idCountry;
	}

	/**
	 * @return the idState
	 */
	public long getIdState() {
		return idState;
	}

	/**
	 * @param idState the idState to set
	 */
	public void setIdState(long idState) {
		this.idState = idState;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the vatNumber
	 */
	public String getVatNumber() {
		return vatNumber;
	}

	/**
	 * @param vatNumber the vatNumber to set
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the phoneMobile
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}

	/**
	 * @param phoneMobile the phoneMobile to set
	 */
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the deleted
	 */
	public PShopBoolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(PShopBoolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the dateAdd
	 */
	public Date getDateAdd() {
		return dateAdd;
	}

	/**
	 * @param dateAdd the dateAdd to set
	 */
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	/**
	 * @return the dateUpd
	 */
	public Date getDateUpd() {
		return dateUpd;
	}

	/**
	 * @param dateUpd the dateUpd to set
	 */
	public void setDateUpd(Date dateUpd) {
		this.dateUpd = dateUpd;
	}
	
	
}
