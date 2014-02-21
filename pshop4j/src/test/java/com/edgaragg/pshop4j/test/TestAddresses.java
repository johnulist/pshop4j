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
import java.util.concurrent.Future;

import org.junit.Test;

import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperResponse;
import com.edgaragg.pshop4j.pojos.entities.Address;
import com.edgaragg.pshop4j.pojos.list.Addresses;

/**
 * @author Edgar Gonzalez
 *
 */
public class TestAddresses extends PShop4jTest {

	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Addresses> result = this.getMapper().headFullDisplay(Addresses.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Addresses resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Addresses> result = this.getMapper().listFullDisplay(Addresses.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Addresses resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Addresses> result = this.getMapper().list(Addresses.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Addresses resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Addresses> result = this.getMapper().listFullDisplay(Addresses.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Addresses resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Addresses.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Address entity = new Address();
		entity.setAddress1("address 1");
		entity.setAlias("my address");
		entity.setCity("city");
		entity.setFirstname("fulanito");
		entity.setLastname("de tal");
		entity.setIdCountry(1);
		entity.setIdCustomer(1);
		entity.setIdState(1);
		entity.setPostCode("11111");
		
		PrestaShopMapperResponse<Address> result = this.getMapper().post(entity);
		//System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		Address resource = result.getResource();
		assertTrue(resource.getId() > 0);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		String addr = "changing name";
		entity.setAddress1(addr);
		
		
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getAddress1().equals(addr));
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	/************************************************************************************************************************
	 * ASYNC
	 ************************************************************************************************************************/
	
	
	@Test
	public void testAsyncHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			Future<PrestaShopMapperResponse<Addresses>> future = this.getAsyncMapper().headFullDisplay(Addresses.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			while(!future.isDone()){
				System.out.print(".");
				Thread.sleep(10);
			}
			PrestaShopMapperResponse<Addresses> result = future.get();
			Addresses resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Addresses - testAsyncHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
}
