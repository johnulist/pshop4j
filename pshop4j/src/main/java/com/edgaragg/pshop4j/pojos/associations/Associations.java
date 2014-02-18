/**
 * 
 */
package com.edgaragg.pshop4j.pojos.associations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;

/**
 * @author Edgar Gonzalez
 * 
 */
public class Associations implements PrestaShopPojo, Iterable<PrestaShopPojoList<?>> {

	private Map<Class<?>, PrestaShopPojoList<?>> pojosInAssociation;
	
	/**
	 * 
	 */
	public Associations() {
		this.pojosInAssociation = new HashMap<Class<?>, PrestaShopPojoList<?>>();
	}
	
	public <T extends PrestaShopPojo> void addAssociation(PrestaShopPojoList<T> pojoList){
		this.pojosInAssociation.put(pojoList.getClass(), pojoList);
	}
	
	public <T extends PrestaShopPojoList<?>> void addAssociationListFromClass(Class<T> clazz){
		try {
			PrestaShopPojoList<?> list = (PrestaShopPojoList<?>)clazz.newInstance();
			this.pojosInAssociation.put(clazz, list);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PrestaShopPojoEntity, P extends PrestaShopPojoList<T>> 
	void addAssociation(T entity, Class<P> listClass){
		if(!this.pojosInAssociation.containsKey(listClass)){
			this.addAssociationListFromClass(listClass);
		}
		
		((P)this.pojosInAssociation.get(listClass)).add(entity);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PrestaShopPojoList<?>> T get(Class<T> clazz){
		return (T) (this.pojosInAssociation.containsKey(clazz) ? this.pojosInAssociation.get(clazz) : null);
	}

	@Override
	public Iterator<PrestaShopPojoList<?>> iterator() {
		return this.pojosInAssociation.values().iterator();
	}
}
