/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	private HashMap<Long, Integer> mapIndexes;
	
	public LanguageElements(){
		this.mapIndexes = new HashMap<Long, Integer>();
	}
	
	public String getContent(long langId){
		if(this.mapIndexes.containsKey(langId)){
			return this.elements.get(this.mapIndexes.get(langId)).getContent();
		}else{
			throw new IndexOutOfBoundsException(String.format("langId is out of bounds (%d)\n", this.elements.size()));
		}
	}
	
	@Override
	protected List<LanguageElement> createInnerList() {
		this.elements = new ArrayList<LanguageElement>();
		return this.elements;
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.pojos.PrestaShopPojoList#add(com.edgaragg.pshop4j.pojos.PrestaShopPojo)
	 */
	@Override
	public synchronized void add(LanguageElement newObject) {
		super.add(newObject);
		this.mapIndexes.put(newObject.getId(), this.elements.size()-1);
	}

}
