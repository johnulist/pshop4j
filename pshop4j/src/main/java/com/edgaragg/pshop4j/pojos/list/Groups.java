/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.entities.Group;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(resource = Resources.groups)
@PrestaShopElement(name = "groups")
public class Groups extends PrestaShopPojoList<Group> {
	@PrestaShopElement(name = "group")
	@PrestaShopList(type=Group.class)
	private List<Group> groups;
	
	/**
	 * 
	 */
	public Groups() {
		super();
		this.groups = new ArrayList<Group>();
		this.setList(this.groups);
	}

	

}
