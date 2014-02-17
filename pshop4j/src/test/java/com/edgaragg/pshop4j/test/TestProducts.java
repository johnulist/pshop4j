package com.edgaragg.pshop4j.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.SingleValueFilter;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperResponse;
import com.edgaragg.pshop4j.modeling.enums.PShopBoolean;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;
import com.edgaragg.pshop4j.pojos.entities.Product;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;
import com.edgaragg.pshop4j.pojos.list.Products;

public class TestProducts extends PShop4jTest {

	public TestProducts() {

	}
	
	@Test
	public void testNotFilterable(){
		long start = Calendar.getInstance().getTimeInMillis();
		try {
			PrestaShopMapperResponse<Products> result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("id_default_image", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Products resource = result.getResource();
			assertNull(resource);
			Exception ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
			
			result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("id_default_combination", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			resource = result.getResource();
			assertNull(resource);
			ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
			
			result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("position_in_category", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			resource = result.getResource();
			assertNull(resource);
			ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
			result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("manufacturer_name", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			resource = result.getResource();
			assertNull(resource);
			ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
			result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("quantity", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			resource = result.getResource();
			assertNull(resource);
			ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
			result = this.getMapper().listFullDisplay(Products.class, 
					Arrays.asList((Filter)new SingleValueFilter("type", "1")), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			resource = result.getResource();
			assertNull(resource);
			ex = result.getException(); 
			assertNotNull(ex);
			assertTrue(NotFilterableException.class.isInstance(ex));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testNotFilterable - Execution time: %.5f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testHead(){
		long start = Calendar.getInstance().getTimeInMillis();
		try {
			PrestaShopMapperResponse<Products> result = this.getMapper().headFullDisplay(Products.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Products resource = result.getResource();
			assertNull(resource);
			assertNull(result.getException());
			assertTrue(result.getHash().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testHead - Execution time: %.5f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetFullDisplay(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Products> result = this.getMapper().listFullDisplay(Products.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Products resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testGetFullDisplay - Execution time: %.5f seconds\n", (end - start)/1000.0);
	}
	
	@Test
	public void testGetOnlyID(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			List<String> fields = Collections.emptyList();
			PrestaShopMapperResponse<Products> result = this.getMapper().list(Products.class, fields, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Products resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			assertTrue(result.getHash().length() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testGetOnlyID - Execution time: %.5f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testHashEquality(){
		long start = Calendar.getInstance().getTimeInMillis();
		
		try {
			PrestaShopMapperResponse<Products> result = this.getMapper().listFullDisplay(Products.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Products resource = result.getResource();
//			Products result = mapper.list(Products.class);
			assertNotNull(resource);
			assertNull(result.getException());
			assertTrue(resource.size() > 0);
			String hashGet = result.getHash();
			
			result = this.getMapper().headFullDisplay(Products.class, this.getFilters(), Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			String hashHead = result.getHash();
			assertTrue(hashGet.equals(hashHead) && hashGet.length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testHashEquality - Execution time: %.5f seconds\n", (end - start)/1000.0);
	}
	
	
	@Test
	public void testPostPutAndDelete(){
		long start = Calendar.getInstance().getTimeInMillis();
		Product entity = new Product();
		entity.setActive(PShopBoolean.TRUE);
		entity.setPrice(new BigDecimal(1000));
		entity.setDescription(new LanguageElements());
		entity.getDescription().add(new LanguageElement().withId(1).withContent("lang 1"));
		entity.getDescription().add(new LanguageElement().withId(2).withContent("lang 2"));
		entity.getDescription().add(new LanguageElement().withId(3).withContent("lang 3"));
		entity.setLinkRewrite(new LanguageElements());
		entity.getLinkRewrite().add(new LanguageElement().withId(1).withContent("lang1"));
		entity.getLinkRewrite().add(new LanguageElement().withId(2).withContent("lang2"));
		entity.getLinkRewrite().add(new LanguageElement().withId(3).withContent("lang3"));
		entity.setName(new LanguageElements());
		entity.getName().add(new LanguageElement().withId(1).withContent("name 1"));
		entity.getName().add(new LanguageElement().withId(2).withContent("name 2"));
		entity.getName().add(new LanguageElement().withId(3).withContent("name 3"));
		
		PrestaShopMapperResponse<Product> result = this.getMapper().post(entity);
		//System.out.println(result.getException().getMessage());
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		Product resource = result.getResource();
		assertTrue(resource.getId() > 0);
		long id = resource.getId();
		System.out.printf("RESOURCE ID: %d\n", id);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testPostPutAndDelete (POST) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		// PUT
		start = Calendar.getInstance().getTimeInMillis();
		entity = resource;
		String name = "changing name";
		entity.setPrice(new BigDecimal(1500));
		entity.getName().get(0).setContent(name);
		
		result = this.getMapper().put(entity);
		assertNotNull(result);
		assertNotNull(result.getResource());
		assertNull(result.getException());
		resource = result.getResource();
		assertTrue(resource.getName().get(0).getContent().equals(name));
		assertTrue(resource.getPrice().equals(new BigDecimal(1500)));
		
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testPostPutAndDelete (PUT) - Execution time: %.2f seconds\n", (end - start)/1000.0);
		
		// DELETE
		start = Calendar.getInstance().getTimeInMillis();
		result = this.getMapper().delete(resource);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Products - testPostPutAndDelete (DELETE) - Execution time: %.2f seconds\n", (end - start)/1000.0);
	}

}
