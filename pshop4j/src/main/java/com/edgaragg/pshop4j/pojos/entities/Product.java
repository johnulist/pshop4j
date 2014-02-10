/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.IsCatalogName;
import com.edgaragg.pshop4j.modeling.annotations.IsCleanHtml;
import com.edgaragg.pshop4j.modeling.annotations.IsReference;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.annotations.IsLinkRewrite;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.modeling.enums.ProductVisibility;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.products)
@PrestaShopElement("product")
@PrestaShopIgnore(elements = "associations")
public class Product implements PrestaShopPojoEntity {
	
	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isUnsignedId)
	private long id;
	
	@PrestaShopText(value = "id_manufacturer", format = PShopFormat.isUnsignedId)
	private long idManufacturer;
	
	@PrestaShopText(value = "id_category_default", format = PShopFormat.isUnsignedId)
	private long idCategoryDefault;
	
	@PrestaShopText(value = "id_supplier", format = PShopFormat.isUnsignedId)
	private long idSupplier;
	
	@PrestaShopText(value = "new", format = PShopFormat.isString)
	private String _new;
	
	@PrestaShopText(value = "cache_default_attribute", format = PShopFormat.isInt)
	private long cacheDefaultAttribute;
	
	@PrestaShopText(value = "id_default_image", format = PShopFormat.isUnsignedId, notFilterable = true)
	private long idDefaultImage;
	
	@PrestaShopText(value = "id_default_combination", format = PShopFormat.isUnsignedId, notFilterable = true)
	private long idDefaultCombination;
	
	@PrestaShopText(value = "id_tax_rules_group", format = PShopFormat.isUnsignedId)
	private long idTaxRulesGroup;
	
	@PrestaShopText(value = "position_in_category", format = PShopFormat.isInt, notFilterable = true)
	private long positionInCategory;
	
	@PrestaShopText(value = "manufacturer_name", format = PShopFormat.isString, notFilterable = true)
	private String manufacturerName;
	
	@PrestaShopText(value = "quantity", format = PShopFormat.isUnsignedInt, notFilterable = true)
	private long quantity;
	
	@PrestaShopText(value = "type", format = PShopFormat.isString, notFilterable = true)
	private String type;
	
	@PrestaShopText(value = "id_shop_default", format = PShopFormat.isUnsignedId)
	private long idShopDefault;
	
	@PrestaShopText(value = "reference", format = PShopFormat.isReference, maxSize = 32)
	private String reference;
	
	@IsReference
	@PrestaShopText(value = "supplier_reference", format = PShopFormat.isReference, maxSize = 32)
	private String supplierReference;
	
	@PrestaShopText(value = "location", format = PShopFormat.isReference, maxSize = 64)
	private String location;
	
	@PrestaShopText(value = "width", format = PShopFormat.isUnsignedFloat)
	private BigDecimal width;
	
	@PrestaShopText(value = "height", format = PShopFormat.isUnsignedFloat)
	private BigDecimal height;
	
	@PrestaShopText(value = "depth", format = PShopFormat.isUnsignedFloat)
	private BigDecimal depth;
	
	@PrestaShopText(value = "weight", format = PShopFormat.isUnsignedFloat)
	private BigDecimal weight;
	
	@PrestaShopText(value = "quantity_discount", format = PShopFormat.isBool)
	private PShopBoolean quantityDiscount;
	
	@PrestaShopText(value = "ean13", format = PShopFormat.isEan13, maxSize = 13)
	private String ean13;
	
	@PrestaShopText(value = "upc", format = PShopFormat.isUpc, maxSize = 12)
	private String upc;
	
	@PrestaShopText(value = "cache_is_pack", format = PShopFormat.isBool)
	private PShopBoolean cacheIsPack;
	
	@PrestaShopText(value = "cache_has_attachments", format = PShopFormat.isBool)
	private PShopBoolean cacheHasAttachments;
	
	@PrestaShopText(value = "is_virtual", format = PShopFormat.isBool)
	private PShopBoolean isVirtual;
	
	@PrestaShopText(value = "on_sale", format = PShopFormat.isBool)
	private PShopBoolean onSale;
	
	@PrestaShopText(value = "online_only", format = PShopFormat.isBool)
	private PShopBoolean onlineOnly;
	
	@PrestaShopText(value = "ecotax", format = PShopFormat.isPrice)
	private BigDecimal ecotax;
		
	@PrestaShopText(value = "minimal_quantity", format = PShopFormat.isUnsignedInt)
	private long minimalQuantity;
	
	@PrestaShopText(value = "price", format = PShopFormat.isPrice, required = true)
	private BigDecimal price;
	
	@PrestaShopText(value = "wholesale_price", format = PShopFormat.isPrice)
	private BigDecimal wholesalePrice;
	
	@PrestaShopText(value = "unity", format = PShopFormat.isString)
	private String unity;
	
	@PrestaShopText(value = "unit_price_ratio", format = PShopFormat.isFloat)
	private BigDecimal unitPriceRatio;
	
	@PrestaShopText(value = "additional_shipping_cost", format = PShopFormat.isPrice)
	private BigDecimal additionalShippingCost;
	
	@PrestaShopText(value = "customizable", format = PShopFormat.isUnsignedInt)
	private PShopBoolean customizable;
	
	@PrestaShopText(value = "text_fields", format = PShopFormat.isUnsignedInt)
	private long textFields;
	
	@PrestaShopText(value = "uploadable_files", format = PShopFormat.isUnsignedInt)
	private long uploadableFiles;
	
	@PrestaShopText(value = "active", format = PShopFormat.isBool)
	private PShopBoolean active;
	
	@PrestaShopText(value = "redirect_type", format = PShopFormat.isString)
	private String redirect_type;
	
	@PrestaShopText(value = "id_product_redirected", format = PShopFormat.isUnsignedId)
	private long idProductRedirected;
	
	@PrestaShopText(value = "available_for_order", format = PShopFormat.isBool)
	private PShopBoolean availableForOrder;
	
	// TODO: make availableDate a date Format is isDateFormat???
	@PrestaShopText(value = "available_date", format = PShopFormat.isDate)
	private String availableDate;
	
	@PrestaShopText(value = "condition", format = PShopFormat.isGenericName)
	private String condition;
	
	@PrestaShopText(value = "show_price", format = PShopFormat.isBool)
	private PShopBoolean showPrice;
	
	@PrestaShopText(value = "indexed", format = PShopFormat.isBool)
	private PShopBoolean indexed;
	
	@PrestaShopText(value = "visibility", format = PShopFormat.isProductVisibility)
	private ProductVisibility visibility;

	@PrestaShopText(value = "advanced_stock_management", format = PShopFormat.isBool)
	private PShopBoolean advancedStockManagement;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateAdd;
	
	@PrestaShopText(value = "date_upd", format = PShopFormat.isDate)
	private Date dateUpd;
	
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("meta_description")
	private List<LanguageElement> metaDescription;

	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("meta_keywords")
	private List<LanguageElement> metaKeywords;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("meta_title")
	private List<LanguageElement> metaTitle;
	
	@IsLinkRewrite
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("link_rewrite")
	private List<LanguageElement> linkRewrite;
	
	@IsCatalogName
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("name")
	private List<LanguageElement> name;

	@IsCleanHtml
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("description")
	private List<LanguageElement> description;

	@IsCleanHtml
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("description_short")
	private List<LanguageElement> descriptionShort;

	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("available_now")
	private List<LanguageElement> availableNow;
	
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement("available_later")
	private List<LanguageElement> availableLater;
	
	
	/*
<associations>
<categories node_type="category">
<category>
<id required="true"/>
</category>
</categories>
<images node_type="image">
<image>
<id/>
</image>
</images>
<combinations node_type="combinations">
<combinations>
<id required="true"/>
</combinations>
</combinations>
<product_option_values node_type="product_options_values">
<product_options_values>
<id required="true"/>
</product_options_values>
</product_option_values>
<product_features node_type="product_feature">
<product_feature>
<id required="true"/>
<custom/>
<id_feature_value xlink:href="http://192.168.1.139/prestashop/api/product_feature_values/" required="true"/>
</product_feature>
</product_features>
<tags node_type="tag">
<tag>
<id required="true"/>
</tag>
</tags>
<stock_availables node_type="stock_available">
<stock_available>
<id required="true"/>
<id_product_attribute required="true"/>
</stock_available>
</stock_availables>
<accessories node_type="product">
<product>
<id xlink:href="http://192.168.1.139/prestashop/api/product/" required="true"/>
</product>
</accessories>
<product_bundle node_type="products">
<products>
<id required="true"/>
<quantity/>
</products>
</product_bundle>
</associations>
</product>
	 */
	
	
	/**
	 * 
	 */
	public Product() {
		super();
		this.name = new ArrayList<LanguageElement>();
		this.linkRewrite = new ArrayList<LanguageElement>();
		this.description = new ArrayList<LanguageElement>();
		this.metaDescription = new ArrayList<LanguageElement>();
		this.metaKeywords = new ArrayList<LanguageElement>();
		this.metaTitle = new ArrayList<LanguageElement>();
		this.descriptionShort = new ArrayList<LanguageElement>();
		this.availableNow = new ArrayList<LanguageElement>();
		this.availableLater = new ArrayList<LanguageElement>();
	}
	
	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity#getId()
	 */
	@Override
	public long getId() {
		return this.id;
	}

	

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity#setId(long)
	 */
	@Override
	public void setId(long id) throws Exception {
		this.id = id;
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
	 * @return the idCategoryDefault
	 */
	public long getIdCategoryDefault() {
		return idCategoryDefault;
	}


	/**
	 * @param idCategoryDefault the idCategoryDefault to set
	 */
	public void setIdCategoryDefault(long idCategoryDefault) {
		this.idCategoryDefault = idCategoryDefault;
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
	 * @return the _new
	 */
	public String get_new() {
		return _new;
	}


	/**
	 * @param _new the _new to set
	 */
	public void set_new(String _new) {
		this._new = _new;
	}


	/**
	 * @return the cacheDefaultAttribute
	 */
	public long getCacheDefaultAttribute() {
		return cacheDefaultAttribute;
	}


	/**
	 * @param cacheDefaultAttribute the cacheDefaultAttribute to set
	 */
	public void setCacheDefaultAttribute(long cacheDefaultAttribute) {
		this.cacheDefaultAttribute = cacheDefaultAttribute;
	}


	/**
	 * @return the idDefaultImage
	 */
	public long getIdDefaultImage() {
		return idDefaultImage;
	}


	/**
	 * @param idDefaultImage the idDefaultImage to set
	 */
	public void setIdDefaultImage(long idDefaultImage) {
		this.idDefaultImage = idDefaultImage;
	}


	/**
	 * @return the idDefaultCombination
	 */
	public long getIdDefaultCombination() {
		return idDefaultCombination;
	}


	/**
	 * @param idDefaultCombination the idDefaultCombination to set
	 */
	public void setIdDefaultCombination(long idDefaultCombination) {
		this.idDefaultCombination = idDefaultCombination;
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
	 * @return the positionInCategory
	 */
	public long getPositionInCategory() {
		return positionInCategory;
	}


	/**
	 * @param positionInCategory the positionInCategory to set
	 */
	public void setPositionInCategory(long positionInCategory) {
		this.positionInCategory = positionInCategory;
	}


	/**
	 * @return the manufacturerName
	 */
	public String getManufacturerName() {
		return manufacturerName;
	}


	/**
	 * @param manufacturerName the manufacturerName to set
	 */
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}


	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the idShopDefault
	 */
	public long getIdShopDefault() {
		return idShopDefault;
	}


	/**
	 * @param idShopDefault the idShopDefault to set
	 */
	public void setIdShopDefault(long idShopDefault) {
		this.idShopDefault = idShopDefault;
	}


	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}


	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}


	/**
	 * @return the supplierReference
	 */
	public String getSupplierReference() {
		return supplierReference;
	}


	/**
	 * @param supplierReference the supplierReference to set
	 */
	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the width
	 */
	public BigDecimal getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(BigDecimal width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public BigDecimal getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}


	/**
	 * @return the depth
	 */
	public BigDecimal getDepth() {
		return depth;
	}


	/**
	 * @param depth the depth to set
	 */
	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}


	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}


	/**
	 * @return the quantityDiscount
	 */
	public PShopBoolean getQuantityDiscount() {
		return quantityDiscount;
	}


	/**
	 * @param quantityDiscount the quantityDiscount to set
	 */
	public void setQuantityDiscount(PShopBoolean quantityDiscount) {
		this.quantityDiscount = quantityDiscount;
	}


	/**
	 * @return the ean13
	 */
	public String getEan13() {
		return ean13;
	}


	/**
	 * @param ean13 the ean13 to set
	 */
	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}


	/**
	 * @return the upc
	 */
	public String getUpc() {
		return upc;
	}


	/**
	 * @param upc the upc to set
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}


	/**
	 * @return the cacheIsPack
	 */
	public PShopBoolean getCacheIsPack() {
		return cacheIsPack;
	}


	/**
	 * @param cacheIsPack the cacheIsPack to set
	 */
	public void setCacheIsPack(PShopBoolean cacheIsPack) {
		this.cacheIsPack = cacheIsPack;
	}


	/**
	 * @return the cacheHasAttachments
	 */
	public PShopBoolean getCacheHasAttachments() {
		return cacheHasAttachments;
	}


	/**
	 * @param cacheHasAttachments the cacheHasAttachments to set
	 */
	public void setCacheHasAttachments(PShopBoolean cacheHasAttachments) {
		this.cacheHasAttachments = cacheHasAttachments;
	}


	/**
	 * @return the isVirtual
	 */
	public PShopBoolean getIsVirtual() {
		return isVirtual;
	}


	/**
	 * @param isVirtual the isVirtual to set
	 */
	public void setIsVirtual(PShopBoolean isVirtual) {
		this.isVirtual = isVirtual;
	}


	/**
	 * @return the onSale
	 */
	public PShopBoolean getOnSale() {
		return onSale;
	}


	/**
	 * @param onSale the onSale to set
	 */
	public void setOnSale(PShopBoolean onSale) {
		this.onSale = onSale;
	}


	/**
	 * @return the onlineOnly
	 */
	public PShopBoolean getOnlineOnly() {
		return onlineOnly;
	}


	/**
	 * @param onlineOnly the onlineOnly to set
	 */
	public void setOnlineOnly(PShopBoolean onlineOnly) {
		this.onlineOnly = onlineOnly;
	}


	/**
	 * @return the ecotax
	 */
	public BigDecimal getEcotax() {
		return ecotax;
	}


	/**
	 * @param ecotax the ecotax to set
	 */
	public void setEcotax(BigDecimal ecotax) {
		this.ecotax = ecotax;
	}


	/**
	 * @return the minimalQuantity
	 */
	public long getMinimalQuantity() {
		return minimalQuantity;
	}


	/**
	 * @param minimalQuantity the minimalQuantity to set
	 */
	public void setMinimalQuantity(long minimalQuantity) {
		this.minimalQuantity = minimalQuantity;
	}


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	/**
	 * @return the wholesalePrice
	 */
	public BigDecimal getWholesalePrice() {
		return wholesalePrice;
	}


	/**
	 * @param wholesalePrice the wholesalePrice to set
	 */
	public void setWholesalePrice(BigDecimal wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}


	/**
	 * @return the unity
	 */
	public String getUnity() {
		return unity;
	}


	/**
	 * @param unity the unity to set
	 */
	public void setUnity(String unity) {
		this.unity = unity;
	}


	/**
	 * @return the unitPriceRatio
	 */
	public BigDecimal getUnitPriceRatio() {
		return unitPriceRatio;
	}


	/**
	 * @param unitPriceRatio the unitPriceRatio to set
	 */
	public void setUnitPriceRatio(BigDecimal unitPriceRatio) {
		this.unitPriceRatio = unitPriceRatio;
	}


	/**
	 * @return the additionalShippingCost
	 */
	public BigDecimal getAdditionalShippingCost() {
		return additionalShippingCost;
	}


	/**
	 * @param additionalShippingCost the additionalShippingCost to set
	 */
	public void setAdditionalShippingCost(BigDecimal additionalShippingCost) {
		this.additionalShippingCost = additionalShippingCost;
	}


	/**
	 * @return the customizable
	 */
	public PShopBoolean getCustomizable() {
		return customizable;
	}


	/**
	 * @param customizable the customizable to set
	 */
	public void setCustomizable(PShopBoolean customizable) {
		this.customizable = customizable;
	}


	/**
	 * @return the textFields
	 */
	public long getTextFields() {
		return textFields;
	}


	/**
	 * @param textFields the textFields to set
	 */
	public void setTextFields(long textFields) {
		this.textFields = textFields;
	}


	/**
	 * @return the uploadableFiles
	 */
	public long getUploadableFiles() {
		return uploadableFiles;
	}


	/**
	 * @param uploadableFiles the uploadableFiles to set
	 */
	public void setUploadableFiles(long uploadableFiles) {
		this.uploadableFiles = uploadableFiles;
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
	 * @return the redirect_type
	 */
	public String getRedirect_type() {
		return redirect_type;
	}


	/**
	 * @param redirect_type the redirect_type to set
	 */
	public void setRedirect_type(String redirect_type) {
		this.redirect_type = redirect_type;
	}


	/**
	 * @return the idProductRedirected
	 */
	public long getIdProductRedirected() {
		return idProductRedirected;
	}


	/**
	 * @param idProductRedirected the idProductRedirected to set
	 */
	public void setIdProductRedirected(long idProductRedirected) {
		this.idProductRedirected = idProductRedirected;
	}


	/**
	 * @return the availableForOrder
	 */
	public PShopBoolean getAvailableForOrder() {
		return availableForOrder;
	}


	/**
	 * @param availableForOrder the availableForOrder to set
	 */
	public void setAvailableForOrder(PShopBoolean availableForOrder) {
		this.availableForOrder = availableForOrder;
	}


	/**
	 * @return the availableDate
	 */
	public String getAvailableDate() {
		return availableDate;
	}


	/**
	 * @param availableDate the availableDate to set
	 */
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}


	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}


	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}


	/**
	 * @return the showPrice
	 */
	public PShopBoolean getShowPrice() {
		return showPrice;
	}


	/**
	 * @param showPrice the showPrice to set
	 */
	public void setShowPrice(PShopBoolean showPrice) {
		this.showPrice = showPrice;
	}


	/**
	 * @return the indexed
	 */
	public PShopBoolean getIndexed() {
		return indexed;
	}


	/**
	 * @param indexed the indexed to set
	 */
	public void setIndexed(PShopBoolean indexed) {
		this.indexed = indexed;
	}


	/**
	 * @return the visibility
	 */
	public ProductVisibility getVisibility() {
		return visibility;
	}


	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(ProductVisibility visibility) {
		this.visibility = visibility;
	}


	/**
	 * @return the advancedStockManagement
	 */
	public PShopBoolean getAdvancedStockManagement() {
		return advancedStockManagement;
	}


	/**
	 * @param advancedStockManagement the advancedStockManagement to set
	 */
	public void setAdvancedStockManagement(PShopBoolean advancedStockManagement) {
		this.advancedStockManagement = advancedStockManagement;
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
	 * @return the metaDescription
	 */
	public List<LanguageElement> getMetaDescription() {
		return metaDescription;
	}


	/**
	 * @param metaDescription the metaDescription to set
	 */
	public void setMetaDescription(List<LanguageElement> metaDescription) {
		this.metaDescription = metaDescription;
	}


	/**
	 * @return the metaKeywords
	 */
	public List<LanguageElement> getMetaKeywords() {
		return metaKeywords;
	}


	/**
	 * @param metaKeywords the metaKeywords to set
	 */
	public void setMetaKeywords(List<LanguageElement> metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	/**
	 * @return the metaTitle
	 */
	public List<LanguageElement> getMetaTitle() {
		return metaTitle;
	}


	/**
	 * @param metaTitle the metaTitle to set
	 */
	public void setMetaTitle(List<LanguageElement> metaTitle) {
		this.metaTitle = metaTitle;
	}


	/**
	 * @return the linkRewrite
	 */
	public List<LanguageElement> getLinkRewrite() {
		return linkRewrite;
	}


	/**
	 * @param linkRewrite the linkRewrite to set
	 */
	public void setLinkRewrite(List<LanguageElement> linkRewrite) {
		this.linkRewrite = linkRewrite;
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


	/**
	 * @return the description
	 */
	public List<LanguageElement> getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(List<LanguageElement> description) {
		this.description = description;
	}


	/**
	 * @return the descriptionShort
	 */
	public List<LanguageElement> getDescriptionShort() {
		return descriptionShort;
	}


	/**
	 * @param descriptionShort the descriptionShort to set
	 */
	public void setDescriptionShort(List<LanguageElement> descriptionShort) {
		this.descriptionShort = descriptionShort;
	}


	/**
	 * @return the availableNow
	 */
	public List<LanguageElement> getAvailableNow() {
		return availableNow;
	}


	/**
	 * @param availableNow the availableNow to set
	 */
	public void setAvailableNow(List<LanguageElement> availableNow) {
		this.availableNow = availableNow;
	}


	/**
	 * @return the availableLater
	 */
	public List<LanguageElement> getAvailableLater() {
		return availableLater;
	}


	/**
	 * @param availableLater the availableLater to set
	 */
	public void setAvailableLater(List<LanguageElement> availableLater) {
		this.availableLater = availableLater;
	}
	
	

}
