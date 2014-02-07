/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopVirtual;


/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.groups)
@PrestaShopElement("group")
public class Group implements PrestaShopPojoEntity {

	@PrestaShopVirtual()
	@PrestaShopElement("id")
	@PrestaShopAttribute("id")
	private long id;
	/**
	 * 
	 */
	public Group() {
		
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) throws Exception {
		this.id = id;
	}

}
