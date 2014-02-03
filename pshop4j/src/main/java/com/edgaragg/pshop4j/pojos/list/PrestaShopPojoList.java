/**
 * 
 */
package com.edgaragg.pshop4j.pojos.list;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopPojoList<T extends PrestaShopPojo> extends PrestaShopPojo {
	public T get(int index);
	public void add(T newObject);
	public int size();
}
