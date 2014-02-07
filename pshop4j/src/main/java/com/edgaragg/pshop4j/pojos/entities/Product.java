/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.IsBarcode;
import com.edgaragg.pshop4j.modeling.annotations.IsBool;
import com.edgaragg.pshop4j.modeling.annotations.IsCatalogName;
import com.edgaragg.pshop4j.modeling.annotations.IsCleanHtml;
import com.edgaragg.pshop4j.modeling.annotations.IsPrice;
import com.edgaragg.pshop4j.modeling.annotations.IsReference;
import com.edgaragg.pshop4j.modeling.annotations.IsUnsignedFloat;
import com.edgaragg.pshop4j.modeling.annotations.IsUnsignedId;
import com.edgaragg.pshop4j.modeling.annotations.IsUnsignedInt;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;
import com.edgaragg.pshop4j.modeling.annotations.IsLinkRewrite;
import com.edgaragg.pshop4j.modeling.enums.ProductVisibility;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.products)
@PrestaShopElement("product")
@PrestaShopIgnore(elements = "associations")
public class Product implements PrestaShopPojoEntity {
	
	@IsUnsignedId
	@PrestaShopVirtual()
	@PrestaShopAttribute("id")
	@PrestaShopText("id")
	private long id;
	
	@IsUnsignedId
	@PrestaShopText("id_manufacturer")
	private long idManufacturer;
	
	@IsUnsignedId
	@PrestaShopText("id_category_default")
	private long idCategoryDefault;
	
	@IsUnsignedId
	@PrestaShopText("id_supplier")
	private long idSupplier;
	
	@PrestaShopText("new")
	private String _new;
	
	@PrestaShopText("cache_default_attribute")
	private long cacheDefaultAttribute;
	
	@PrestaShopText("id_default_image")
	private long idDefaultImage;
	
	@PrestaShopText("id_default_combination")
	private long idDefaultCombination;
	
	@IsUnsignedId
	@PrestaShopText("id_tax_rules_group")
	private long idTaxRulesGroup;
	
	@PrestaShopText("position_in_category")
	private long positionInCategory;
	
	@PrestaShopText("manufacturer_name")
	private String manufacturerName;
	
	@PrestaShopText("quantity")
	private long quantity;
	
	@PrestaShopText("type")
	private String type;
	
	@IsUnsignedId
	@PrestaShopText("id_shop_default")
	private long idShopDefault;
	
	@IsReference
	@PrestaShopText("reference")
	private String reference;
	
	@IsReference
	@PrestaShopText("supplier_reference")
	private String supplierReference;
	
	@IsReference(maxSize = 64)
	@PrestaShopText("location")
	private String location;
	
	@IsUnsignedFloat
	@PrestaShopText("width")
	private BigDecimal width;
	
	@IsUnsignedFloat
	@PrestaShopText("height")
	private BigDecimal height;
	
	@IsUnsignedFloat
	@PrestaShopText("depth")
	private BigDecimal depth;
	
	@IsUnsignedFloat
	@PrestaShopText("weight")
	private BigDecimal weight;
	
	@IsBool
	@PrestaShopText("quantity_discount")
	private short quantityDiscount;
	
	@IsBarcode(regex = "^[0-9]{0,13}$", maxSize = 13)
	@PrestaShopText("ean13")
	private String ean13;
	
	@IsBarcode(regex = "^[0-9]{0,12}$", maxSize = 12)
	@PrestaShopText("upc")
	private String upc;
	
	@IsBool
	@PrestaShopText("cache_is_pack")
	private short cacheIsPack;
	
	@IsBool
	@PrestaShopText("cache_has_attachments")
	private short cacheHasAttachments;
	
	@IsBool
	@PrestaShopText("is_virtual")
	private short isVirtual;
	
	@IsBool
	@PrestaShopText("on_sale")
	private short onSale;
	
	@IsBool
	@PrestaShopText("online_only")
	private short onlineOnly;
	
	@IsPrice
	@PrestaShopText("ecotax")
	private BigDecimal ecotax;
		
	@IsUnsignedInt
	@PrestaShopText("minimal_quantity")
	private long minimalQuantity;
	
	@IsPrice(required = true)
	@PrestaShopText("price")
	private BigDecimal price;
	
	@IsPrice
	@PrestaShopText("wholesale_price")
	private BigDecimal wholesalePrice;
	
	@PrestaShopText("unity")
	private String unity;
	
	@PrestaShopText("unit_price_ratio")
	private BigDecimal unitPriceRatio;
	
	@IsPrice
	@PrestaShopText("additional_shipping_cost")
	private BigDecimal additionalShippingCost;
	
	@IsBool
	@PrestaShopText("customizable")
	private short customizable;
	
	@IsUnsignedInt
	@PrestaShopText("text_fields")
	private long textFields;
	
	@IsUnsignedInt
	@PrestaShopText("uploadable_files")
	private long uploadableFiles;
	
	@IsBool
	@PrestaShopText("active")
	private short active;
	
	@PrestaShopText("redirect_type")
	private String redirect_type;
	
	@IsUnsignedId
	@PrestaShopText("id_product_redirected")
	private long idProductRedirected;
	
	@IsBool
	@PrestaShopText("available_for_order")
	private short availableForOrder;
	
	// TODO: make availableDate a date
	@PrestaShopText("available_date")
	private String availableDate;
	
	@PrestaShopText("condition")
	private String condition;
	
	@IsBool
	@PrestaShopText("show_price")
	private short showPrice;
	
	@IsBool
	@PrestaShopText("indexed")
	private short indexed;
	
	@PrestaShopText("visibility")
	private ProductVisibility visibility;

	@IsBool
	@PrestaShopText("advanced_stock_management")
	private short advancedStockManagement;
	
	@PrestaShopText("date_add")
	private Date dateAdd;
	
	@PrestaShopText("date_upd")
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

}
