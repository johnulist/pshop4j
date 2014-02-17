/**
 * 
 */
package com.edgaragg.pshop4j.pojos;

import java.util.Iterator;
import java.util.List;

/**
 * @author Edgar Gonzalez
 *
 */
public abstract class PrestaShopPojoList<T extends PrestaShopPojo> implements PrestaShopPojo, Iterable<T> {
	private List<T> pojos;// = Collections.emptyList();
	
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
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return this.pojos.iterator();
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
