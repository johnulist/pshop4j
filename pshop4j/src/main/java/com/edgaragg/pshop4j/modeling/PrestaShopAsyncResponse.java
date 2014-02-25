/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public interface PrestaShopAsyncResponse<POJO extends PrestaShopPojo> {
	void setPrestaShopResponse(PrestaShopMapperResponse<POJO> response);
}
