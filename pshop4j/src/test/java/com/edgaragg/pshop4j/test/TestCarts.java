/**
 * 
 */
package com.edgaragg.pshop4j.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperResponse;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.entities.Cart;
import com.edgaragg.pshop4j.pojos.entities.CartRow;
import com.edgaragg.pshop4j.pojos.list.CartRows;
import com.edgaragg.pshop4j.pojos.list.Carts;

/**
 * @author Edgar Gonzalez
 *
 */
public class TestCarts extends PShop4jTest {
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carts> result = this.getMapper().headFullDisplay(Carts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carts resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carts> result = this.getMapper().listFullDisplay(Carts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carts resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Carts> result = this.getMapper().list(Carts.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carts resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carts> result = this.getMapper().listFullDisplay(Carts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carts resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Carts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Cart entity = new Cart();
		entity.setIdCurrency(1);
		entity.setIdAddressDelivery(1);
		entity.setIdAddressInvoice(1);
		entity.setIdCustomer(1);
		CartRow row = new CartRow();
		row.setIdProduct(1);
		row.setQuantity(new BigDecimal(11));
		entity.setAssociations(new Associations());
		entity.getAssociations().addAssociation(row, CartRows.class);
		
		PrestaShopMapperResponse<Cart> result = this.getMapper().post(entity);
		if(result.getException() != null)
			System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		
		Cart resource = result.getResource();
		assertTrue(resource.getId() > 0);
		CartRows rows = resource.getAssociations().get(CartRows.class);
		assertNotNull(rows);
		assertTrue(rows.size() == 1);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		
		entity.getAssociations().get(CartRows.class).get(0).setQuantity(new BigDecimal(1));;
		
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getAssociations().get(CartRows.class).get(0).getQuantity().equals(new BigDecimal(1)));
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carts - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
}
