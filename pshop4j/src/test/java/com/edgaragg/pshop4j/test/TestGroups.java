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
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.enums.PriceDisplayMethod;
import com.edgaragg.pshop4j.pojos.entities.Group;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;
import com.edgaragg.pshop4j.pojos.list.Groups;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;

/**
 * @author egonzalez
 *
 */
public class TestGroups extends PShop4jTest {

	/**
	 * 
	 */
	public TestGroups() {
		
	}
	
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Groups> result = this.getMapper().headFullDisplay(Groups.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Groups resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Groups> result = this.getMapper().listFullDisplay(Groups.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Groups resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			System.out.println(resource.get(0).getName().get(0).getId());
			assertTrue(resource.get(0).getName().get(0).getId() == 1);
			assertTrue(resource.get(0).getName().get(1).getId() == 2);
			assertTrue(resource.get(0).getName().get(2).getId() == 3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Groups> result = this.getMapper().list(Groups.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Groups resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Groups> result = this.getMapper().listFullDisplay(Groups.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Groups resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Groups.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Group group = new Group();
		//lang.setId(100);
//		group.setDateAdd(Calendar.getInstance().getTime());
//		group.setDateUpd(Calendar.getInstance().getTime());
		group.setPriceDisplayMethod(PriceDisplayMethod.PS_TAX_INC);
		group.setShowPrices(PShopBoolean.TRUE);
		LanguageElements name = new LanguageElements();
		name.add(new LanguageElement().withId(1).withContent("lang 1"));
		name.add(new LanguageElement().withId(2).withContent("lang 2"));
		name.add(new LanguageElement().withId(3).withContent("lang 3"));
		group.setName(name);
		group.setReduction(new BigDecimal(0));
		PrestaShopMapperResponse<Group> result = this.getMapper().post(group);
		//System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		Group resource = result.getResource();
		assertTrue(resource.getId() > 0);
		assertTrue(resource.getName().size() > 0);
		System.out.println(resource.getName().get(0).getId());
		assertTrue(resource.getName().get(0).getId() == 1);
		assertTrue(resource.getName().get(1).getId() == 2);
		assertTrue(resource.getName().get(2).getId() == 3);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		group = resource;
		group.setReduction(new BigDecimal(100));
		String content = "new Content";
		group.getName().get(0).setContent(content);
		
		result = this.getMapper().put(resource);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getReduction().equals(new BigDecimal(100)));
		assertTrue(resource.getName().get(0).getContent().equals(content));
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Groups - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
	}
	
	

}
