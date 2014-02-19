/**
 * 
 */
package com.edgaragg.pshop4j.test;

import static org.junit.Assert.assertEquals;
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
import com.edgaragg.pshop4j.pojos.entities.Carrier;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;
import com.edgaragg.pshop4j.pojos.list.Carriers;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;


/**
 * @author Edgar Gonzalez
 *
 */
public class TestCarriers extends PShop4jTest {
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carriers> result = this.getMapper().headFullDisplay(Carriers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carriers resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carriers> result = this.getMapper().listFullDisplay(Carriers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carriers resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Carriers> result = this.getMapper().list(Carriers.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carriers resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Carriers> result = this.getMapper().listFullDisplay(Carriers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Carriers resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Carriers.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Carrier entity = new Carrier();
		entity.setActive(PShopBoolean.TRUE);
		entity.setName("test");
		entity.setDelay(new LanguageElements());
		entity.getDelay().add(new LanguageElement().withId(1).withContent("text1"));
		entity.getDelay().add(new LanguageElement().withId(2).withContent("text2"));
		entity.getDelay().add(new LanguageElement().withId(3).withContent("text3"));
		
		PrestaShopMapperResponse<Carrier> result = this.getMapper().post(entity);
		if(result.getException() != null)
			System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		
		Carrier resource = result.getResource();
		assertTrue(resource.getId() > 0);
		
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		entity.setName("ANOTHER");
		
		
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertEquals(resource.getName(), "ANOTHER");
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Carriers - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
}
