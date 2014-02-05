/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.IsBirthDate;
import com.edgaragg.pshop4j.modeling.annotations.IsBool;
import com.edgaragg.pshop4j.modeling.annotations.IsCleanHtml;
import com.edgaragg.pshop4j.modeling.annotations.IsFloat;
import com.edgaragg.pshop4j.modeling.annotations.IsGenericName;
import com.edgaragg.pshop4j.modeling.annotations.IsMD5;
import com.edgaragg.pshop4j.modeling.annotations.IsName;
import com.edgaragg.pshop4j.modeling.annotations.IsPasswd;
import com.edgaragg.pshop4j.modeling.annotations.IsUnsignedId;
import com.edgaragg.pshop4j.modeling.annotations.IsUnsignedInt;
import com.edgaragg.pshop4j.modeling.annotations.IsUrl;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAssociationMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElementMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.list.Groups;


/**
 * @author Edgar Gonzalez
 * Customer entity
 */
@PrestaShopResource(resource = Resources.customers)
@PrestaShopElement(name = "customers")
@PrestaShopAssociationMapping({
	@PrestaShopElementMapping(element = "groups", type = Groups.class)
})
//@PrestaShopIgnore(elements="associations")
public class Customer implements PrestaShopPojo {

	@PrestaShopVirtual()
	@PrestaShopAttribute(name = "id")
	@PrestaShopText(element = "id")
	private long id;
	
	@PrestaShopText(element = "id_default_group")
	private long idDefaultGroup;
	
	@IsUnsignedId
	@PrestaShopText(element = "id_lang")
	private long idLang;
	
	@PrestaShopText(element = "newsletter_date_add")
	private Date newsletterDateAdd;
	
	@PrestaShopText(element = "ip_registration_newsletter")
	private String ipRegistrationNewsletter;
	
	@PrestaShopText(element = "last_passwd_gen")
	private Date lastPasswdGen;
	
	@IsMD5
	@PrestaShopText(element = "secure_key")
	private String secureKey;
	
	@IsBool
	@PrestaShopText(element = "deleted")
	private short deleted;
	
	@IsPasswd(required = true, maxSize = 32)
	@PrestaShopText(element = "passwd")
	private String passwd;
	
	@IsName(required = true, maxSize = 32)
	@PrestaShopText(element = "lastname")
	private String lastName;
	
	@IsName(required = true, maxSize = 32)
	@PrestaShopText(element = "firstname")
	private String firstName;
	
	@PrestaShopText(element = "email")
	private String email;
	
	@IsUnsignedId
	@PrestaShopText(element = "id_gender")
	private short idGender;
	
	@IsBirthDate
	@PrestaShopText(element = "birthday")
	private Date birthday;
	
	@PrestaShopText(element = "newsletter")
	private int newsletter;
	
	@IsBool
	@PrestaShopText(element = "optin")
	private short optin;
	
	@IsUrl
	@PrestaShopText(element = "website")
	private String website;
	
	@IsGenericName
	@PrestaShopText(element = "company")
	private String company;
	
	@PrestaShopText(element = "siret")
	private String siret;
	
	@PrestaShopText(element = "ape")
	private String ape;

	@IsFloat
	@PrestaShopText(element = "outstanding_allow_amount")
	BigDecimal outstandingAllowAmount;
	
	@IsBool
	@PrestaShopText(element = "show_public_prices")
	private short showPublicPrices;
	
	@IsUnsignedInt
	@PrestaShopText(element = "id_risk")
	private short idRisk;
	
	@IsUnsignedInt
	@PrestaShopText(element = "max_payment_days")
	private int maxPaymentDays;
	
	@IsBool
	@PrestaShopText(element = "active")
	private short active;
	
	@IsCleanHtml(maxSize = 65000)
	@PrestaShopText(element = "note")
	private String note;
	
	@IsBool
	@PrestaShopText(element = "is_guest")
	private short isGuest;
	
	@IsUnsignedId
	@PrestaShopText(element = "id_shop")
	private long idShop;
	
	@IsUnsignedId
	@PrestaShopText(element = "id_shop_group")
	private long idShopGroup;
	
	@PrestaShopText(element = "date_add")
	private Date dateAdd;
	
	@PrestaShopText(element = "date_upd")
	private Date dateUpd;
	
	@PrestaShopElement(name = "associations")
	private Associations associations;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the idDefaultGroup
	 */
	public long getIdDefaultGroup() {
		return idDefaultGroup;
	}
	/**
	 * @param idDefaultGroup the idDefaultGroup to set
	 */
	public void setIdDefaultGroup(long idDefaultGroup) {
		this.idDefaultGroup = idDefaultGroup;
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
	 * @return the newsletterDateAdd
	 */
	public Date getNewsletterDateAdd() {
		return newsletterDateAdd;
	}
	/**
	 * @param newsletterDateAdd the newsletterDateAdd to set
	 */
	public void setNewsletterDateAdd(Date newsletterDateAdd) {
		this.newsletterDateAdd = newsletterDateAdd;
	}
	/**
	 * @return the ipRegistrationNewsletter
	 */
	public String getIpRegistrationNewsletter() {
		return ipRegistrationNewsletter;
	}
	/**
	 * @param ipRegistrationNewsletter the ipRegistrationNewsletter to set
	 */
	public void setIpRegistrationNewsletter(String ipRegistrationNewsletter) {
		this.ipRegistrationNewsletter = ipRegistrationNewsletter;
	}
	/**
	 * @return the lastPasswdGen
	 */
	public Date getLastPasswdGen() {
		return lastPasswdGen;
	}
	/**
	 * @param lastPasswdGen the lastPasswdGen to set
	 */
	public void setLastPasswdGen(Date lastPasswdGen) {
		this.lastPasswdGen = lastPasswdGen;
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
	 * @return the deleted
	 */
	public short getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(short deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @return the idGender
	 */
	public short getIdGender() {
		return idGender;
	}
	/**
	 * @param idGender the idGender to set
	 */
	public void setIdGender(short idGender) {
		this.idGender = idGender;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the newsletter
	 */
	public int getNewsletter() {
		return newsletter;
	}
	/**
	 * @param newsletter the newsletter to set
	 */
	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}
	/**
	 * @return the optin
	 */
	public short getOptin() {
		return optin;
	}
	/**
	 * @param optin the optin to set
	 */
	public void setOptin(short optin) {
		this.optin = optin;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
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
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}
	/**
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}
	/**
	 * @return the ape
	 */
	public String getApe() {
		return ape;
	}
	/**
	 * @param ape the ape to set
	 */
	public void setApe(String ape) {
		this.ape = ape;
	}
	/**
	 * @return the outstandingAllowAmount
	 */
	public BigDecimal getOutstandingAllowAmount() {
		return outstandingAllowAmount;
	}
	/**
	 * @param outstandingAllowAmount the outstandingAllowAmount to set
	 */
	public void setOutstandingAllowAmount(BigDecimal outstandingAllowAmount) {
		this.outstandingAllowAmount = outstandingAllowAmount;
	}
	/**
	 * @return the showPublicPrices
	 */
	public short getShowPublicPrices() {
		return showPublicPrices;
	}
	/**
	 * @param showPublicPrices the showPublicPrices to set
	 */
	public void setShowPublicPrices(short showPublicPrices) {
		this.showPublicPrices = showPublicPrices;
	}
	/**
	 * @return the idRisk
	 */
	public short getIdRisk() {
		return idRisk;
	}
	/**
	 * @param idRisk the idRisk to set
	 */
	public void setIdRisk(short idRisk) {
		this.idRisk = idRisk;
	}
	/**
	 * @return the maxPaymentDays
	 */
	public int getMaxPaymentDays() {
		return maxPaymentDays;
	}
	/**
	 * @param maxPaymentDays the maxPaymentDays to set
	 */
	public void setMaxPaymentDays(int maxPaymentDays) {
		this.maxPaymentDays = maxPaymentDays;
	}
	/**
	 * @return the active
	 */
	public short getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(short active) {
		this.active = active;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the isGuest
	 */
	public short getIsGuest() {
		return isGuest;
	}
	/**
	 * @param isGuest the isGuest to set
	 */
	public void setIsGuest(short isGuest) {
		this.isGuest = isGuest;
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
