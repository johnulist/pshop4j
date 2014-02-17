/**
 * 
 */
package com.edgaragg.pshop4j.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperResponse;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.pojos.entities.Customer;
import com.edgaragg.pshop4j.pojos.list.Customers;

/**
 * @author Edgar Gonzalez
 *
 */
public class TestCustomers extends PShop4jTest {

	/**
	 * 
	 */
	public TestCustomers() {
		
	}

	
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Customers> result = this.getMapper().headFullDisplay(Customers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Customers resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Customers> result = this.getMapper().listFullDisplay(Customers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Customers resource = result.getResource();
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Customers> result = this.getMapper().list(Customers.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Customers resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Customers> result = this.getMapper().listFullDisplay(Customers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Customers resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Customers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Customer entity = new Customer();
		entity.setActive(PShopBoolean.TRUE);
		entity.setBirthday(Calendar.getInstance().getTime());
		entity.setCompany("EdgarAGG");
		entity.setDeleted(PShopBoolean.FALSE);
		entity.setEmail("test@test.com");
		entity.setFirstName("Fulanito");
		entity.setLastName("De Tal");
		entity.setPasswd("menganito");
		entity.setSecureKey("6814a0f08c2523b6825989a5dcf9b7b5");
		entity.setShowPublicPrices(PShopBoolean.TRUE);
		entity.setIdDefaultGroup(1);
		
		PrestaShopMapperResponse<Customer> result = this.getMapper().post(entity);
		//System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		Customer resource = result.getResource();
		assertTrue(resource.getId() > 0);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		String name = "changing name";
		entity.setFirstName(name);
		entity.setPasswd("otra_cosa");
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getFirstName().equals(name));
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Customers - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
}
