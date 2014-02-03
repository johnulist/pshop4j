/**
 * 
 */
package com.edgaragg.pshop4j.pojos.entities;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopPojoEntity extends PrestaShopPojo {
	public long getId();
	public void setId(long id) throws Exception;	
}
