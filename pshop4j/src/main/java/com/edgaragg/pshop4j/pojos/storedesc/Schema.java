/**
 * 
 */
package com.edgaragg.pshop4j.pojos.storedesc;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;

/**
 * @author Edgar Gonzalez
 *
 */
public class Schema {

	@PrestaShopAttribute("xlink:href")
	private String endPoint;
	@PrestaShopAttribute("type")
	private String type;
	/**
	 * 
	 */
	public Schema() {

	}
	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}
	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	

}
