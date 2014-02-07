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
		this.pojos = this.createInnerList();
		if(this.pojos == null){
			System.out.println("CONSTRUCTOR WTF????");
		}
	}
	
	public T get(int index){
		return this.pojos.isEmpty() ? null : this.pojos.get(index);
	}
	
	public void add(T newObject){
		this.pojos.add(newObject);
	}
	
	public int size(){
		if(this.pojos == null){
			System.out.println("WTF????");
			return 0;
		}
		return this.pojos.size();
	}
	
	
	protected abstract List<T> createInnerList();
}
