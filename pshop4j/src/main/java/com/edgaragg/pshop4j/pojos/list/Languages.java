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
@PrestaShopResource(resource = Resources.languages)
@PrestaShopElement(name = "languages")
public class Languages extends PrestaShopPojoList<Language> {

	@PrestaShopElement(name = "language")
	@PrestaShopList(type=Language.class)
	private List<Language> languages = new ArrayList<Language>();
	/**
	 * 
	 */
	public Languages() {
		super();
		this.setList(this.languages);
	}
}
