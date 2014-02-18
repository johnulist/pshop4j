package com.edgaragg.pshop4j.pojos.entities;

import java.math.BigDecimal;

import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

@PrestaShopResource(Resources.cart_row)
@PrestaShopElement(value = "cart_row")
public class CartRow implements PrestaShopPojoEntity {

	@PrestaShopText(value = "id_product", format = PShopFormat.isUnsignedId, required = true)
	private long idProduct;
	
	@PrestaShopText(value = "id_product_attribute", format = PShopFormat.isUnsignedId, required = true)
	private long idProductAttribute;
	
	@PrestaShopText(value = "id_address_delivery", format = PShopFormat.isUnsignedId, required = true)
	private long idAddressDelivery;
	
	@PrestaShopText(value = "quantity", format = PShopFormat.isUnsignedInt, required = true)
	private BigDecimal quantity;
	
	@Override
	public long getId() {
		return 0;
	}

	@Override
	public void setId(long id) {
		
	}

	/**
	 * @return the idProduct
	 */
	public long getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the idProductAttribute
	 */
	public long getIdProductAttribute() {
		return idProductAttribute;
	}

	/**
	 * @param idProductAttribute the idProductAttribute to set
	 */
	public void setIdProductAttribute(long idProductAttribute) {
		this.idProductAttribute = idProductAttribute;
	}

	/**
	 * @return the idAddressDelivery
	 */
	public long getIdAddressDelivery() {
		return idAddressDelivery;
	}

	/**
	 * @param idAddressDelivery the idAddressDelivery to set
	 */
	public void setIdAddressDelivery(long idAddressDelivery) {
		this.idAddressDelivery = idAddressDelivery;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
	

}
