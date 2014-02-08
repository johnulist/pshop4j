package com.edgaragg.pshop4j.test;

import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.modeling.PrestaShopMapper;

public class PShop4jTest {

	private PrestaShopWebservice web;
	private PrestaShopMapper mapper;
	private List<Filter> filters = Collections.emptyList();
	
	
	public PShop4jTest() {
		web = new PrestaShopWebservice("192.168.1.139/prestashop", "0HMRPJPZM2CE10H1HLZH2HGXGA2F2LWS");
		mapper = new PrestaShopMapper(web);
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
	
	

}
