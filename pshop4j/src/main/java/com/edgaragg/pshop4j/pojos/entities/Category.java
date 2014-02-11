/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAssociationMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElementMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.list.Categories;
import com.edgaragg.pshop4j.pojos.list.Products;

/**
 * @author Edgar Gonzalez
 */
@PrestaShopResource(Resources.categories)
@PrestaShopElement(value = "category")
@PrestaShopAssociationMapping({
	@PrestaShopElementMapping(element = "categories", type = Categories.class),
	@PrestaShopElementMapping(element = "products", type = Products.class)
})
public class Category implements PrestaShopPojoEntity {

	@PrestaShopAttribute("id")
	@PrestaShopText(value = "id", format = PShopFormat.isUnsignedId)
	private long id;
	
	@PrestaShopText(value = "id_parent", format = PShopFormat.isUnsignedInt)
	private long idParent;
	
	@PrestaShopText(value = "level_depth", format = PShopFormat.isUnsignedInt)
	private int levelDepth;
	
	@PrestaShopText(value = "nb_products_recursive", format = PShopFormat.isString, notFilterable = true)
	private int nbProductsRecursive;
	
	@PrestaShopText(value = "active", format = PShopFormat.isBool, required = true)
	private PShopBoolean active;
	
	@PrestaShopText(value = "id_shop_default", format = PShopFormat.isUnsignedId)
	private long idShopDefault;
	
	@PrestaShopText(value = "is_root_category", format = PShopFormat.isBool)
	private PShopBoolean isRootCategory;
	
	@PrestaShopText(value = "position", format = PShopFormat.isInt)
	private long position;
	
	@PrestaShopText(value = "date_add", format = PShopFormat.isDate)
	private Date dateAdd;
	
	@PrestaShopText(value = "date_upd", format = PShopFormat.isDate)
	private Date dateUpd;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "name", format = PShopFormat.isGenericName)
	private List<LanguageElement> name;

	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "link_rewrite", format = PShopFormat.isLinkRewrite)
	private List<LanguageElement> linkRewrite;

	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "description", format = PShopFormat.isCleanHtml)
	private List<LanguageElement> description;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "meta_title", format = PShopFormat.isGenericName)
	private List<LanguageElement> metaTitle;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "meta_description", format = PShopFormat.isGenericName)
	private List<LanguageElement> metaDescription;
	
	@PrestaShopList(LanguageElement.class)
	@PrestaShopElement(value = "meta_keywords", format = PShopFormat.isGenericName)
	private List<LanguageElement> metaKeywords;

	@PrestaShopElement("associations")
	private Associations associations;
	
	/**
	 * 
	 */
	public Category() {
		this.name = new ArrayList<LanguageElement>();
		this.linkRewrite = new ArrayList<LanguageElement>();
		this.description = new ArrayList<LanguageElement>();
		this.metaDescription = new ArrayList<LanguageElement>();
		this.metaKeywords = new ArrayList<LanguageElement>();
		this.metaTitle = new ArrayList<LanguageElement>();
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
	 * @return the idParent
	 */
	public long getIdParent() {
		return idParent;
	}

	/**
	 * @param idParent the idParent to set
	 */
	public void setIdParent(long idParent) {
		this.idParent = idParent;
	}

	/**
	 * @return the levelDepth
	 */
	public int getLevelDepth() {
		return levelDepth;
	}

	/**
	 * @param levelDepth the levelDepth to set
	 */
	public void setLevelDepth(int levelDepth) {
		this.levelDepth = levelDepth;
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
	 * @return the isRootCategory
	 */
	public PShopBoolean getIsRootCategory() {
		return isRootCategory;
	}

	/**
	 * @param isRootCategory the isRootCategory to set
	 */
	public void setIsRootCategory(PShopBoolean isRootCategory) {
		this.isRootCategory = isRootCategory;
	}

	/**
	 * @return the position
	 */
	public long getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(long position) {
		this.position = position;
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
	 * @return the nbProductsRecursive
	 */
	public int getNbProductsRecursive() {
		return nbProductsRecursive;
	}

	/**
	 * @param nbProductsRecursive the nbProductsRecursive to set
	 */
	public void setNbProductsRecursive(int nbProductsRecursive) {
		this.nbProductsRecursive = nbProductsRecursive;
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
