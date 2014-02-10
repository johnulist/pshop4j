/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.IsBirthDate;
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
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.list.Groups;
//index.php?controller=authentication&email=email&passwd=pwd&back=my-account&SubmitLogin=Autentificaci%C3%B3n

/**
 * @author Edgar Gonzalez
 * Customer entity
 */
@PrestaShopResource(Resources.customers)
@PrestaShopElement("customers")
@PrestaShopAssociationMapping({
	@PrestaShopElementMapping(element = "groups", type = Groups.class)
})
public class Customer implements PrestaShopPojoEntity {

	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText("id")
	private long id;
	
	@PrestaShopText("id_default_group")
	private long idDefaultGroup;
	
	@IsUnsignedId
	@PrestaShopText("id_lang")
	private long idLang;
	
	@PrestaShopText("newsletter_date_add")
	private Date newsletterDateAdd;
	
	@PrestaShopText("ip_registration_newsletter")
	private String ipRegistrationNewsletter;
	
	@PrestaShopText("last_passwd_gen")
	private Date lastPasswdGen;
	
	@IsMD5
	@PrestaShopText("secure_key")
	private String secureKey;
	
	@PrestaShopText("deleted")
	private PShopBoolean deleted;
	
	@IsPasswd(required = true, maxSize = 32)
	@PrestaShopText("passwd")
	private String passwd;
	
	@IsName(required = true, maxSize = 32)
	@PrestaShopText("lastname")
	private String lastName;
	
	@IsName(required = true, maxSize = 32)
	@PrestaShopText("firstname")
	private String firstName;
	
	@PrestaShopText("email")
	private String email;
	
	@IsUnsignedId
	@PrestaShopText("id_gender")
	private short idGender;
	
	@IsBirthDate
	@PrestaShopText("birthday")
	private Date birthday;
	
	@PrestaShopText("newsletter")
	private int newsletter;
	
	@PrestaShopText("optin")
	private PShopBoolean optin;
	
	@IsUrl
	@PrestaShopText("website")
	private String website;
	
	@IsGenericName
	@PrestaShopText("company")
	private String company;
	
	@PrestaShopText("siret")
	private String siret;
	
	@PrestaShopText("ape")
	private String ape;

	@IsFloat
	@PrestaShopText("outstanding_allow_amount")
	BigDecimal outstandingAllowAmount;
	
	@PrestaShopText("show_public_prices")
	private PShopBoolean showPublicPrices;
	
	@IsUnsignedInt
	@PrestaShopText("id_risk")
	private short idRisk;
	
	@IsUnsignedInt
	@PrestaShopText("max_payment_days")
	private int maxPaymentDays;
	
	@PrestaShopText("active")
	private PShopBoolean active;
	
	@IsCleanHtml(maxSize = 65000)
	@PrestaShopText("note")
	private String note;
	
	@PrestaShopText("is_guest")
	private PShopBoolean isGuest;
	
	@IsUnsignedId
	@PrestaShopText("id_shop")
	private long idShop;
	
	@IsUnsignedId
	@PrestaShopText("id_shop_group")
	private long idShopGroup;
	
	@PrestaShopText("date_add")
	private Date dateAdd;
	
	@PrestaShopText("date_upd")
	private Date dateUpd;
	
	@PrestaShopElement("associations")
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
	public PShopBoolean getOptin() {
		return optin;
	}
	/**
	 * @param optin the optin to set
	 */
	public void setOptin(PShopBoolean optin) {
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
	public PShopBoolean getShowPublicPrices() {
		return showPublicPrices;
	}
	/**
	 * @param showPublicPrices the showPublicPrices to set
	 */
	public void setShowPublicPrices(PShopBoolean showPublicPrices) {
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
	public PShopBoolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(PShopBoolean active) {
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
	public PShopBoolean getIsGuest() {
		return isGuest;
	}
	/**
	 * @param isGuest the isGuest to set
	 */
	public void setIsGuest(PShopBoolean isGuest) {
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
