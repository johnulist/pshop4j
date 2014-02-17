/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;

/**
 * @author Edgar Gonzalez
 *
 */
public class LanguageElements extends PrestaShopPojoList<LanguageElement> {
	@PrestaShopElement("language")
	@PrestaShopList(LanguageElement.class)
	private List<LanguageElement> elements;
	
	@Override
	protected List<LanguageElement> createInnerList() {
		this.elements = new ArrayList<LanguageElement>();
		return this.elements;
	}

}
