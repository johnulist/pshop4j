/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.associations.Associations;

/**
 * @author Edgar Gonzalez
 *
 */
public class SAXObjectDescription {
	public static final SAXObjectDescription EMPTY_DESCRIPTION = new SAXObjectDescription(null);
	
	private List<String> ignoreList;
	private PrestaShopPojo pojo;
	private String ignore;
	private boolean isAssociationList;
	
	
	/**
	 * 
	 * @param object
	 */
	public SAXObjectDescription(PrestaShopPojo pojo) {
		this.ignoreList = new ArrayList<String>();
		this.setPojo(pojo);
		this.ignore = null;
		if(pojo == null) return;
		Class<?> cls = pojo.getClass();
		PrestaShopIgnore ignoreAnnotation = cls.getAnnotation(PrestaShopIgnore.class);
		if(ignoreAnnotation != null){
			String[] items = ignoreAnnotation.elements().split(",");
			for(String item : items){
				this.ignoreList.add(item.trim().toLowerCase());
			}
		}
		this.setAssociationList(Associations.class.isInstance(pojo));
	}
	/**
	 * @return the pojo
	 */
	public PrestaShopPojo getPojo() {
		return this.ignore != null ? null : this.pojo;
	}
	/**
	 * @param pojo the pojo to set
	 */
	public void setPojo(PrestaShopPojo pojo) {
		this.pojo = pojo;
	}
	
	public boolean checkForIgnorableElement(String elemet){
		return this.ignoreList.contains(elemet.toLowerCase());
	}
	
	/**
	 * @param ignore the ignore to set
	 */
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	
	public boolean isIgnoringElement(String element){
		return this.ignore == null ? false : this.ignore.equals(element);
	}
	
	public boolean isIgnoring(){
		return this.ignore != null;
	}
	/**
	 * @return the isAssociationList
	 */
	public boolean isAssociationList() {
		return isAssociationList;
	}
	/**
	 * @param isAssociationList the isAssociationList to set
	 */
	private void setAssociationList(boolean isAssociationList) {
		this.isAssociationList = isAssociationList;
	}
	

}
