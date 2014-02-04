/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class SAXObjectDescription {

	private List<String> ignoreList;
	private PrestaShopPojo pojo;
	private String ignore;
	
	/**
	 * 
	 * @param object
	 */
	public SAXObjectDescription(PrestaShopPojo pojo) {
		this.ignoreList = new ArrayList<String>();
		this.setPojo(pojo);
		this.ignore = null;
		
		Class<?> cls = pojo.getClass();
		System.out.println("Creating ignore list for " + cls.getSimpleName());
		Annotation[] ann = cls.getAnnotations();
		for(Annotation a : ann){
			System.out.println("\t" + a.annotationType().getSimpleName());
		}
		PrestaShopIgnore ignoreAnnotation = cls.getAnnotation(PrestaShopIgnore.class);
		if(ignoreAnnotation != null){
			System.out.println("HAS SOMETHING");
			String[] items = ignoreAnnotation.elements().split(",");
			for(String item : items){
				System.out.println("Ignore " + item);
				this.ignoreList.add(item.trim().toLowerCase());
			}
		}else{
			System.out.println("NO IGNORABLE ITEMS");
		}
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
	

}
