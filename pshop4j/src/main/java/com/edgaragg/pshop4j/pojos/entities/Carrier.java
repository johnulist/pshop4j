/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;

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
@PrestaShopResource(Resources.carriers)
@PrestaShopElement("carrier")
public class Carrier implements PrestaShopPojoEntity {
	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isNullOrUnsignedId, nullOnZero = true)
	private long id;
	
	@PrestaShopText(value = "deleted", format = PShopFormat.isBool)
	private PShopBoolean deleted;
	
	@PrestaShopText(value = "is_module", format = PShopFormat.isBool)
	private PShopBoolean isModule;
	
	@PrestaShopText(value = "id_tax_rules_group", format = PShopFormat.isNullOrUnsignedId, notFilterable = true)
	private long idTaxRulesGroup; 
	
	@PrestaShopText(value = "id_reference", format = PShopFormat.isString)
	private String idReference;
	
	
	@PrestaShopText(value = "name", format = PShopFormat.isCarrierName, required = true)
	private String name;
	
	@PrestaShopText(value = "active", format = PShopFormat.isBool, required = true)
	private PShopBoolean active;
	
	@PrestaShopText(value = "is_free", format = PShopFormat.isBool)
	private PShopBoolean isFree;
	
	@PrestaShopText(value = "url", format = PShopFormat.isAbsoluteUrl)
	private String url;
	
	@PrestaShopText(value = "shipping_handling", format = PShopFormat.isBool)
	private PShopBoolean shippingHandling;
	
	@PrestaShopText(value = "shipping_external", format = PShopFormat.isString)
	private String shippingExternal;
	
	@PrestaShopText(value = "range_behavior", format = PShopFormat.isBool)
	private PShopBoolean rangeBehavior;
	
	@PrestaShopText(value = "shipping_method", format = PShopFormat.isUnsignedInt)
	private long shippingMethod;
	
	
	@PrestaShopText(value = "max_width", format = PShopFormat.isUnsignedInt)
	private long maxWidth;
	
	@PrestaShopText(value = "max_height", format = PShopFormat.isUnsignedInt)
	private long maxHeight;
	
	@PrestaShopText(value = "max_depth", format = PShopFormat.isUnsignedInt)
	private long maxDepth;
	
	@PrestaShopText(value = "max_weight", format = PShopFormat.isUnsignedFloat)
	private BigDecimal maxWeight;
	
	@PrestaShopText(value = "grade", format = PShopFormat.isUnsignedInt, maxSize = 1)
	private short grade;
	
	@PrestaShopText(value = "external_module_name", format = PShopFormat.isString, maxSize = 64)
	private String externalModuleName;
	
	@PrestaShopText(value = "need_range", format = PShopFormat.isUnsignedInt)
	private int needRange;
	
	@PrestaShopText(value = "position", format = PShopFormat.isUnsignedInt)
	private int position;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "delay", format = PShopFormat.isGenericName, required = true, maxSize = 128)
	private LanguageElements delay;
	
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
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
	 * @return the isModule
	 */
	public PShopBoolean getIsModule() {
		return isModule;
	}

	/**
	 * @param isModule the isModule to set
	 */
	public void setIsModule(PShopBoolean isModule) {
		this.isModule = isModule;
	}

	/**
	 * @return the idTaxRulesGroup
	 */
	public long getIdTaxRulesGroup() {
		return idTaxRulesGroup;
	}

	/**
	 * @param idTaxRulesGroup the idTaxRulesGroup to set
	 */
	public void setIdTaxRulesGroup(long idTaxRulesGroup) {
		this.idTaxRulesGroup = idTaxRulesGroup;
	}

	/**
	 * @return the idReference
	 */
	public String getIdReference() {
		return idReference;
	}

	/**
	 * @param idReference the idReference to set
	 */
	public void setIdReference(String idReference) {
		this.idReference = idReference;
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
	 * @return the isFree
	 */
	public PShopBoolean getIsFree() {
		return isFree;
	}

	/**
	 * @param isFree the isFree to set
	 */
	public void setIsFree(PShopBoolean isFree) {
		this.isFree = isFree;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the shippingHandling
	 */
	public PShopBoolean getShippingHandling() {
		return shippingHandling;
	}

	/**
	 * @param shippingHandling the shippingHandling to set
	 */
	public void setShippingHandling(PShopBoolean shippingHandling) {
		this.shippingHandling = shippingHandling;
	}

	/**
	 * @return the shippingExternal
	 */
	public String getShippingExternal() {
		return shippingExternal;
	}

	/**
	 * @param shippingExternal the shippingExternal to set
	 */
	public void setShippingExternal(String shippingExternal) {
		this.shippingExternal = shippingExternal;
	}

	/**
	 * @return the rangeBehavior
	 */
	public PShopBoolean getRangeBehavior() {
		return rangeBehavior;
	}

	/**
	 * @param rangeBehavior the rangeBehavior to set
	 */
	public void setRangeBehavior(PShopBoolean rangeBehavior) {
		this.rangeBehavior = rangeBehavior;
	}

	/**
	 * @return the shippingMethod
	 */
	public long getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * @param shippingMethod the shippingMethod to set
	 */
	public void setShippingMethod(long shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	/**
	 * @return the maxWidth
	 */
	public long getMaxWidth() {
		return maxWidth;
	}

	/**
	 * @param maxWidth the maxWidth to set
	 */
	public void setMaxWidth(long maxWidth) {
		this.maxWidth = maxWidth;
	}

	/**
	 * @return the maxHeight
	 */
	public long getMaxHeight() {
		return maxHeight;
	}

	/**
	 * @param maxHeight the maxHeight to set
	 */
	public void setMaxHeight(long maxHeight) {
		this.maxHeight = maxHeight;
	}

	/**
	 * @return the maxDepth
	 */
	public long getMaxDepth() {
		return maxDepth;
	}

	/**
	 * @param maxDepth the maxDepth to set
	 */
	public void setMaxDepth(long maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * @return the maxWeight
	 */
	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * @return the grade
	 */
	public short getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(short grade) {
		this.grade = grade;
	}

	/**
	 * @return the externalModuleName
	 */
	public String getExternalModuleName() {
		return externalModuleName;
	}

	/**
	 * @param externalModuleName the externalModuleName to set
	 */
	public void setExternalModuleName(String externalModuleName) {
		this.externalModuleName = externalModuleName;
	}

	/**
	 * @return the needRange
	 */
	public int getNeedRange() {
		return needRange;
	}

	/**
	 * @param needRange the needRange to set
	 */
	public void setNeedRange(int needRange) {
		this.needRange = needRange;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the delay
	 */
	public LanguageElements getDelay() {
		return delay;
	}

	/**
	 * @param delay the delay to set
	 */
	public void setDelay(LanguageElements delay) {
		this.delay = delay;
	}
	

}
