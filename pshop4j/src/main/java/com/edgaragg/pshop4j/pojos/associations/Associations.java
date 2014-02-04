/**
 * 
 */
package com.edgaragg.pshop4j.pojos.associations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class Associations implements PrestaShopPojo {

	private List<PrestaShopPojo> pojosInAssociation;
	
	/**
	 * 
	 */
	public Associations() {
		this.setAssociation(new ArrayList<PrestaShopPojo>());
	}
	
	public void addAssociation(PrestaShopPojo pojo){
		
	}

	/**
	 * @return the pojosInAssociation
	 */
	public List<PrestaShopPojo> getAssociation() {
		return Collections.unmodifiableList(this.pojosInAssociation);
	}

	/**
	 * @param pojosInAssociation the pojosInAssociation to set
	 */
	private void setAssociation(List<PrestaShopPojo> pojosInAssociation) {
		this.pojosInAssociation = pojosInAssociation;
	}

}
