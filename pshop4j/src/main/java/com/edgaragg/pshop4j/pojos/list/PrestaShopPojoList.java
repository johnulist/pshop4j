/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public abstract class PrestaShopPojoList<T extends PrestaShopPojo> implements PrestaShopPojo {
	private List<T> pojos = Collections.emptyList();
	
	/**
	 * 
	 */
	public PrestaShopPojoList() {
		super();
	}
	
	public T get(int index){
		return this.pojos.isEmpty() ? null : this.pojos.get(index);
	}
	
	public void add(T newObject){
		this.pojos.add(newObject);
	}
	
	public int size(){
		return this.pojos.size();
	}
	
	protected void setList(List<T> pojos){
		this.pojos = pojos;
	}
}
