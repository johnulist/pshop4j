/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.IsBool;
import com.edgaragg.pshop4j.modeling.annotations.IsGenericName;
import com.edgaragg.pshop4j.modeling.annotations.IsLanguageCode;
import com.edgaragg.pshop4j.modeling.annotations.IsPhpDateFormat;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.enums.LanguageCodeType;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.languages)
@PrestaShopElement("language")
public class Language implements PrestaShopPojoEntity {

	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText("id")
	private long id;
	
	@IsGenericName(required = true, maxSize = 32)
	@PrestaShopText("name")
	private String name;
	
	@IsLanguageCode(type = LanguageCodeType.ISO, required = true, maxSize=2)
	@PrestaShopText("iso_code")
	private String isoCode;
	
	@IsLanguageCode(type = LanguageCodeType.NORMAL)
	@PrestaShopText("language_code")
	private String languageCode;
	
	@IsBool()
	@PrestaShopText("active")
	private short active;
	
	@IsBool()
	@PrestaShopText("is_rtl")
	private short isRTL;
	
	@IsPhpDateFormat(required = true, maxSize = 32)
	@PrestaShopText("date_format_lite")
	private String dateFormatLite;
	
	@IsPhpDateFormat(required = true, maxSize = 32)
	@PrestaShopText("date_format_full")
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
	 * @return the isRTL
	 */
	public short getIsRTL() {
		return isRTL;
	}

	/**
	 * @param isRTL the isRTL to set
	 */
	public void setIsRTL(short isRTL) {
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
