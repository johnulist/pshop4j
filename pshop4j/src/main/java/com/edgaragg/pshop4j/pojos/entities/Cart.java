/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.util.Date;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAssociationMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElementMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.list.CartRows;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.carts)
@PrestaShopElement(value = "cart")
@PrestaShopAssociationMapping({
	@PrestaShopElementMapping(element = "cart_rows", type = CartRows.class)
})
public class Cart implements PrestaShopPojoEntity {

	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long id;
	
	@PrestaShopText(value = "id_address_delivery", format = PShopFormat.isUnsignedId)
	private long idAddressDelivery;
	
	@PrestaShopText(value = "id_address_invoice", format = PShopFormat.isUnsignedId)
	private long idAddressInvoice;
	
	@PrestaShopText(value = "id_currency", format = PShopFormat.isUnsignedId, required = true)
	private long idCurrency;
	
	@PrestaShopText(value = "id_customer", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long idCustomer;
	
	@PrestaShopText(value = "id_guest", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long idGuest;
	
	@PrestaShopText(value = "id_lang", format = PShopFormat.isUnsignedId, required = true)
	private long idLang;
	
	@PrestaShopText(value = "id_shop_group", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long idShopGroup;
	
	@PrestaShopText(value = "id_shop", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long idShop;
	
	@PrestaShopText(value = "id_carrier", format = PShopFormat.isUnsignedId, nullOnZero = true)
	private long idCarrier;
	
	@PrestaShopText(value = "recyclable", format = PShopFormat.isBool)
	private PShopBoolean recyclable;
	
	@PrestaShopText(value = "gift", format = PShopFormat.isBool)
	private PShopBoolean gift;
	
	@PrestaShopText(value = "gift_message", format = PShopFormat.isMessage)
	private String giftMessage;
	
	@PrestaShopText(value = "mobile_theme", format = PShopFormat.isBool)
	private PShopBoolean mobileTheme;
	
	@PrestaShopText(value = "delivery_option", format = PShopFormat.isString)
	private String deliveryOption;
	
	@PrestaShopText(value = "secure_key", format = PShopFormat.isMd5, maxSize = 32)
	private String secureKey;
	
	@PrestaShopText(value = "allow_seperated_package", format = PShopFormat.isBool)
	private PShopBoolean allowSeparatedPackage;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateAdd;
	
	@PrestaShopText(value = "date_upd", format = PShopFormat.isDate)
	private Date dateUpd;
	
	@PrestaShopElement("associations")
	private Associations associations;
	
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
	 * @return the idAddressDelivery
	 */
	public long getIdAddressDelivery() {
		return idAddressDelivery;
	}

	/**
	 * @param idAddressDelivery the idAddressDelivery to set
	 */
	public void setIdAddressDelivery(long idAddressDelivery) {
		this.idAddressDelivery = idAddressDelivery;
	}

	/**
	 * @return the idAddressInvoice
	 */
	public long getIdAddressInvoice() {
		return idAddressInvoice;
	}

	/**
	 * @param idAddressInvoice the idAddressInvoice to set
	 */
	public void setIdAddressInvoice(long idAddressInvoice) {
		this.idAddressInvoice = idAddressInvoice;
	}

	/**
	 * @return the idCurrency
	 */
	public long getIdCurrency() {
		return idCurrency;
	}

	/**
	 * @param idCurrency the idCurrency to set
	 */
	public void setIdCurrency(long idCurrency) {
		this.idCurrency = idCurrency;
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
	 * @return the idGuest
	 */
	public long getIdGuest() {
		return idGuest;
	}

	/**
	 * @param idGuest the idGuest to set
	 */
	public void setIdGuest(long idGuest) {
		this.idGuest = idGuest;
	}

	/**
	 * @return the idLang
	 */
	public long getIdLang() {
		return idLang;
	}

	/**
	 * @param idLang the idLang to set
	 */
	public void setIdLang(long idLang) {
		this.idLang = idLang;
	}

	/**
	 * @return the idShopGroup
	 */
	public long getIdShopGroup() {
		return idShopGroup;
	}

	/**
	 * @param idShopGroup the idShopGroup to set
	 */
	public void setIdShopGroup(long idShopGroup) {
		this.idShopGroup = idShopGroup;
	}

	/**
	 * @return the idShop
	 */
	public long getIdShop() {
		return idShop;
	}

	/**
	 * @param idShop the idShop to set
	 */
	public void setIdShop(long idShop) {
		this.idShop = idShop;
	}

	/**
	 * @return the idCarrier
	 */
	public long getIdCarrier() {
		return idCarrier;
	}

	/**
	 * @param idCarrier the idCarrier to set
	 */
	public void setIdCarrier(long idCarrier) {
		this.idCarrier = idCarrier;
	}

	/**
	 * @return the recyclable
	 */
	public PShopBoolean getRecyclable() {
		return recyclable;
	}

	/**
	 * @param recyclable the recyclable to set
	 */
	public void setRecyclable(PShopBoolean recyclable) {
		this.recyclable = recyclable;
	}

	/**
	 * @return the gift
	 */
	public PShopBoolean getGift() {
		return gift;
	}

	/**
	 * @param gift the gift to set
	 */
	public void setGift(PShopBoolean gift) {
		this.gift = gift;
	}

	/**
	 * @return the giftMessage
	 */
	public String getGiftMessage() {
		return giftMessage;
	}

	/**
	 * @param giftMessage the giftMessage to set
	 */
	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}

	/**
	 * @return the mobileTheme
	 */
	public PShopBoolean getMobileTheme() {
		return mobileTheme;
	}

	/**
	 * @param mobileTheme the mobileTheme to set
	 */
	public void setMobileTheme(PShopBoolean mobileTheme) {
		this.mobileTheme = mobileTheme;
	}

	/**
	 * @return the deliveryOption
	 */
	public String getDeliveryOption() {
		return deliveryOption;
	}

	/**
	 * @param deliveryOption the deliveryOption to set
	 */
	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	/**
	 * @return the secureKey
	 */
	public String getSecureKey() {
		return secureKey;
	}

	/**
	 * @param secureKey the secureKey to set
	 */
	public void setSecureKey(String secureKey) {
		this.secureKey = secureKey;
	}

	/**
	 * @return the allowSeparatedPackage
	 */
	public PShopBoolean getAllowSeparatedPackage() {
		return allowSeparatedPackage;
	}

	/**
	 * @param allowSeparatedPackage the allowSeparatedPackage to set
	 */
	public void setAllowSeparatedPackage(PShopBoolean allowSeparatedPackage) {
		this.allowSeparatedPackage = allowSeparatedPackage;
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

	/**
	 * @return the associations
	 */
	public Associations getAssociations() {
		return associations;
	}

	/**
	 * @param associations the associations to set
	 */
	public void setAssociations(Associations associations) {
		this.associations = associations;
	}
	
}
