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
import com.edgaragg.pshop4j.pojos.entities.Language;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopResource(Resources.languages)
@PrestaShopElement("languages")
public class Languages extends PrestaShopPojoList<Language> {

	@PrestaShopElement("language")
	@PrestaShopList(Language.class)
	private List<Language> languages;
	/**
	 * 
	 */
	public Languages() {
		super();
	}
	@Override
	protected List<Language> createInnerList() {
		this.languages = new ArrayList<Language>();
		return this.languages;
	}
}
