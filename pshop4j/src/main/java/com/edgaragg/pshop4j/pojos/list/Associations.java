/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class Associations implements PrestaShopPojo {

	@PrestaShopElement(name = "groups")
	private Groups groups;
	/**
	 * 
	 */
	public Associations() {

	}
	/**
	 * @return the groups
	 */
	public Groups getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}
