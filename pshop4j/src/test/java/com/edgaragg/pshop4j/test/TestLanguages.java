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
import com.edgaragg.pshop4j.pojos.entities.Language;
import com.edgaragg.pshop4j.pojos.list.Languages;

/**
 * @author egonzalez
 *
 */
public class TestLanguages extends PShop4jTest {

	/**
	 * 
	 */
	public TestLanguages() {
		
	}

	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Languages> result = this.getMapper().headFullDisplay(Languages.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Languages resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Languages> result = this.getMapper().listFullDisplay(Languages.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Languages resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Languages> result = this.getMapper().list(Languages.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Languages resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Languages> result = this.getMapper().listFullDisplay(Languages.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Languages resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Languages.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Language lang = new Language();
		//lang.setId(100);
		lang.setActive(PShopBoolean.TRUE);
		lang.setName("test lang");
		lang.setIsoCode("JJ");
		lang.setLanguageCode("LN-ES");
		lang.setDateFormatLite("dd-mm-aa");
		lang.setDateFormatFull("dd-mm-aa");
		PrestaShopMapperResponse<Language> result = this.getMapper().post(lang);
		//System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		Language resource = result.getResource();
		assertTrue(resource.getId() > 0);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		lang = resource;
		String name = "changing name";
		lang.setName(name);
		result = this.getMapper().put(resource);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getName().equals(name));
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Languages - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
	}
	
}
