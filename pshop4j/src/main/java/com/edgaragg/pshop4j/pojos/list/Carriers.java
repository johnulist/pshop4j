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
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.pojos.entities.Carrier;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.carriers)
@PrestaShopElement("carriers")
public class Carriers extends PrestaShopPojoList<Carrier> {
	@PrestaShopElement("carrier")
	@PrestaShopList(Carrier.class)
	private List<Carrier> carriers;
	
	@Override
	protected List<Carrier> createInnerList() {
		this.carriers = new ArrayList<Carrier>();
		return this.carriers;
	}

}
