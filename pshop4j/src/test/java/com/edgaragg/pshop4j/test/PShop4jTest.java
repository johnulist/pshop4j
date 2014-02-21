package com.edgaragg.pshop4j.test;

import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.modeling.PrestaShopAsyncMapper;
import com.edgaragg.pshop4j.modeling.PrestaShopMapper;

public class PShop4jTest {

	private PrestaShopWebservice web;
	private PrestaShopMapper mapper;
	private PrestaShopAsyncMapper asyncMapper;
	private List<Filter> filters = Collections.emptyList();
	
	
	public PShop4jTest() {
		web = new PrestaShopWebservice("localhost/prestashop/", "EZ6F6YRLJPDXJEJNGW8HZ5T01VHN787B");
		mapper = new PrestaShopMapper(web);
		asyncMapper = new PrestaShopAsyncMapper(web);
	}


	/**
	 * @return the web
	 */
	public PrestaShopWebservice getWeb() {
		return web;
	}


	/**
	 * @param web the web to set
	 */
	public void setWeb(PrestaShopWebservice web) {
		this.web = web;
	}


	/**
	 * @return the mapper
	 */
	public PrestaShopMapper getMapper() {
		return mapper;
	}


	/**
	 * @param mapper the mapper to set
	 */
	public void setMapper(PrestaShopMapper mapper) {
		this.mapper = mapper;
	}


	/**
	 * @return the filters
	 */
	public List<Filter> getFilters() {
		return filters;
	}


	/**
	 * @param filters the filters to set
	 */
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}


	/**
	 * @return the asyncMapper
	 */
	public PrestaShopAsyncMapper getAsyncMapper() {
		return asyncMapper;
	}


	/**
	 * @param asyncMapper the asyncMapper to set
	 */
	public void setAsyncMapper(PrestaShopAsyncMapper asyncMapper) {
		this.asyncMapper = asyncMapper;
	}
	
	

}
