/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.languages)
@PrestaShopElement("language")
public class Language implements PrestaShopPojoEntity {

	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isUnsignedId)
	private long id;
	
	@PrestaShopText(value = "name", format = PShopFormat.isGenericName, required = true, maxSize = 32)
	private String name;
	
	@PrestaShopText(value = "iso_code", format = PShopFormat.isNumericIsoCode, required = true, maxSize = 2)
	private String isoCode;

	@PrestaShopText(value = "language_code", format = PShopFormat.isLanguageCode, maxSize = 5)
	private String languageCode;
	
	@PrestaShopText(value = "active", format = PShopFormat.isBool)
	private PShopBoolean active;
	
	@PrestaShopText(value = "is_rtl", format = PShopFormat.isBool)
	private PShopBoolean isRTL;
	
	@PrestaShopText(value = "date_format_lite", format = PShopFormat.isPhpDateFormat, required = true, maxSize = 32)
	private String dateFormatLite;
	
	@PrestaShopText(value = "date_format_full", format = PShopFormat.isPhpDateFormat, required = true, maxSize = 32)
	private String dateFormatFull;
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity#setId(long)
	 */
	@Override
	public void setId(long id) throws Exception {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
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
	 * @return the isRTL
	 */
	public PShopBoolean getIsRTL() {
		return isRTL;
	}

	/**
	 * @param isRTL the isRTL to set
	 */
	public void setIsRTL(PShopBoolean isRTL) {
		this.isRTL = isRTL;
	}

	/**
	 * @return the dateFormatLite
	 */
	public String getDateFormatLite() {
		return dateFormatLite;
	}

	/**
	 * @param dateFormatLite the dateFormatLite to set
	 */
	public void setDateFormatLite(String dateFormatLite) {
		this.dateFormatLite = dateFormatLite;
	}

	/**
	 * @return the dateFormatFull
	 */
	public String getDateFormatFull() {
		return dateFormatFull;
	}

	/**
	 * @param dateFormatFull the dateFormatFull to set
	 */
	public void setDateFormatFull(String dateFormatFull) {
		this.dateFormatFull = dateFormatFull;
	}
	
	

}
