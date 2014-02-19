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
import com.edgaragg.pshop4j.pojos.entities.Contact;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;
import com.edgaragg.pshop4j.pojos.list.Contacts;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;


/**
 * @author Edgar Gonzalez
 *
 */
public class TestContacts extends PShop4jTest {
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Contacts> result = this.getMapper().headFullDisplay(Contacts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Contacts resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testHead - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Contacts> result = this.getMapper().listFullDisplay(Contacts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Contacts resource = result.getResource();
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testGetFullDisplay - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Contacts> result = this.getMapper().list(Contacts.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Contacts resource = result.getResource();
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testGetOnlyID - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Contacts> result = this.getMapper().listFullDisplay(Contacts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Contacts resource = result.getResource();
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Contacts.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testHashEquality - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Contact entity = new Contact();
		entity.setEmail("test@test.com");
		entity.setCustomerService(PShopBoolean.FALSE);
		entity.setName(new LanguageElements());
		entity.getName().add(new LanguageElement().withId(1).withContent("lang 1"));
		entity.getName().add(new LanguageElement().withId(2).withContent("lang 2"));
		entity.getName().add(new LanguageElement().withId(3).withContent("lang 3"));
		
		
		PrestaShopMapperResponse<Contact> result = this.getMapper().post(entity);
		if(result.getException() != null)
			System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		
		Contact resource = result.getResource();
		assertTrue(resource.getId() > 0);
		assertTrue(resource.getName().size() > 0);
		
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		String newEmail = "newemail@test.com";
		entity.setEmail(newEmail);
		entity.getName().get(0).setContent("test");
		
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getName().size() > 0);
		assertEquals(resource.getEmail(), newEmail);
		assertEquals(resource.getName().get(0).getContent(), "test");
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Contacts - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}
}
