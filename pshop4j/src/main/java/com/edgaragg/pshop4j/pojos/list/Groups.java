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
public class Groups implements PrestaShopPojoList<Group> {
	@PrestaShopElement(name = "group")
	@PrestaShopList(type=Group.class)
	private List<Group> groups;
	
	/**
	 * 
	 */
	public Groups() {
		this.groups = new ArrayList<Group>();
	}

	@Override
	public Group get(int index) {
		return this.groups.size() < index ? null : this.groups.get(index);
	}

	@Override
	public void add(Group newObject) {
		this.groups.add(newObject);
	}

	@Override
	public int size() {
		return this.groups.size();
	}

}
