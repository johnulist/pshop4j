/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import java.util.Date;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(resource = Resources.categories)
@PrestaShopElement(name = "category")
public class Category implements PrestaShopPojoEntity {

	@PrestaShopAttribute(name = "id")
	@PrestaShopText(element = "id")
	private long id;
	@PrestaShopText(element = "id_parent")
	private long idParent;
	@PrestaShopText(element = "level_depth")
	private int levelDepth;
	// nb_products_recursive
	@PrestaShopText(element = "active")
	private short active;
	@PrestaShopText(element = "id_shop_default")
	private long idShopDefault;
	@PrestaShopText(element = "is_root_category")
	private short isRootCategory;
	@PrestaShopText(element = "position")
	private long position;
	@PrestaShopText(element = "date_add")
	private Date dateAdd;
	@PrestaShopText(element = "date_upd")
	private Date dateUpd;
	
	
	/**
	 * 
	 */
	public Category() {
		
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
	public short getIsRootCategory() {
		return isRootCategory;
	}

	/**
	 * @param isRootCategory the isRootCategory to set
	 */
	public void setIsRootCategory(short isRootCategory) {
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
	
	

}
