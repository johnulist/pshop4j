/**
 * 
 */
package com.edgaragg.pshop4j.pojos.associations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.list.PrestaShopPojoList;

/**
 * @author Edgar Gonzalez
 * 
 */
public class Associations implements PrestaShopPojo {

	private List<PrestaShopPojoList<?>> pojosInAssociation;
	
	
	/**
	 * 
	 */
	public Associations() {
		this.setAssociation(new ArrayList<PrestaShopPojoList<?>>());
	}
	
	public <T extends PrestaShopPojo> void addAssociation(PrestaShopPojoList<T> pojoList){
		this.pojosInAssociation.add(pojoList);
	}
	
	public <T extends PrestaShopPojoList<?>> void addAssociationListFromClass(Class<T> clazz){
		try {
			PrestaShopPojoList<?> list = (PrestaShopPojoList<?>)clazz.newInstance();
			this.pojosInAssociation.add(list);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the pojosInAssociation
	 */
	public List<PrestaShopPojoList<?>> getAssociation() {
		return Collections.unmodifiableList(this.pojosInAssociation);
	}

	/**
	 * @param pojosInAssociation the pojosInAssociation to set
	 */
	private void setAssociation(List<PrestaShopPojoList<?>> pojosInAssociation) {
		this.pojosInAssociation = pojosInAssociation;
	}
	
}
