/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.modeling.enums.PriceDisplayMethod;


/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.groups)
@PrestaShopElement("group")
public class Group implements PrestaShopPojoEntity {

	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isUnsignedId)
	private long id;
	
	@PrestaShopText(value = "reduction", format = PShopFormat.isFloat)
	private BigDecimal reduction;
	
	@PrestaShopText(value = "price_display_method", format = PShopFormat.isPriceDisplayMethod, required = true)
	private PriceDisplayMethod priceDisplayMethod;
	
	@PrestaShopText(value = "show_prices", format = PShopFormat.isBool)
	private PShopBoolean show_prices;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateAdd;
	
	@PrestaShopText(value = "date_upd", format = PShopFormat.isDate)
	private Date dateUpd;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "name", format = PShopFormat.isGenericName)
	private List<LanguageElement> name;
	
	
	/**
	 * 
	 */
	public Group() {
		this.name = new ArrayList<LanguageElement>();
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) throws Exception {
		this.id = id;
	}

	/**
	 * @return the reduction
	 */
	public BigDecimal getReduction() {
		return reduction;
	}

	/**
	 * @param reduction the reduction to set
	 */
	public void setReduction(BigDecimal reduction) {
		this.reduction = reduction;
	}

	/**
	 * @return the priceDisplayMethod
	 */
	public PriceDisplayMethod getPriceDisplayMethod() {
		return priceDisplayMethod;
	}

	/**
	 * @param priceDisplayMethod the priceDisplayMethod to set
	 */
	public void setPriceDisplayMethod(PriceDisplayMethod priceDisplayMethod) {
		this.priceDisplayMethod = priceDisplayMethod;
	}

	/**
	 * @return the show_prices
	 */
	public PShopBoolean getShow_prices() {
		return show_prices;
	}

	/**
	 * @param show_prices the show_prices to set
	 */
	public void setShow_prices(PShopBoolean show_prices) {
		this.show_prices = show_prices;
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
	 * @return the name
	 */
	public List<LanguageElement> getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(List<LanguageElement> name) {
		this.name = name;
	}
	
		
}
