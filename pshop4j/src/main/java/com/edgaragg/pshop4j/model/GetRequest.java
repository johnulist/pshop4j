/**
 * 
 */
package com.edgaragg.pshop4j.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Edgar Gonzalez
 *
 */
public class GetRequest extends PrestaShopRequest {
	
	private long id = 0;
	private boolean fullDisplay = false;
	private List<String> fields;
	private List<Filter> filters;
	private Sort sort;
	private Limit limit;
	
	/**
	 * 
	 */
	public GetRequest() {
		this.setMethod(METHOD_GET);
		this.fields = Collections.emptyList();
		this.filters = Collections.emptyList();
		this.setSort(null);
		this.setLimit(null);
	}
	
	/**
	 * Assign the resource
	 * @param resource the resource to set
	 * @return current PrestaShopRequest object
	 */
	public GetRequest withResource(Resources resource){
		this.setResource(resource);
		return this;
	}

	
	public GetRequest withId(long id){
		this.setId(id);
		return this;
	}
	
	public GetRequest withFullDisplay(boolean fullDisplay){
		this.setFullDisplay(fullDisplay);
		return this;
	}
	
	public GetRequest withFields(String...fields){
		this.setFields(Arrays.asList(fields));
		return this;
	}
	
	public GetRequest withFields(List<String> fields){
		if(fields == null) {
			this.fields = Collections.emptyList();
		}else{
			this.setFields(fields);
			this.setFullDisplay(false);
		}
		return this;
	}
	
	public GetRequest withFilters(Filter...filters){
		this.setFilters(Arrays.asList(filters));
		return this;
	}
	
	public GetRequest withFilters(List<Filter> filters){
		if(filters == null) {
			this.filters = Collections.emptyList();
		}else{
			this.setFilters(filters);
		}
		return this;
	}
	
	public GetRequest withSort(Sort sort){
		this.setSort(sort);
		return this;
	}
	
	public GetRequest withLimit(Limit limit){
		this.setLimit(limit);
		return this;
	}
	
	
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fullDisplay
	 */
	public boolean isFullDisplay() {
		return fullDisplay;
	}

	/**
	 * @param fullDisplay the fullDisplay to set
	 */
	public void setFullDisplay(boolean fullDisplay) {
		this.fullDisplay = fullDisplay;
	}

	/**
	 * @return the fields
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
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
	 * @return the sort
	 */
	public Sort getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Sort sort) {
		this.sort = sort;
	}

	/**
	 * @return the limit
	 */
	public Limit getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Limit limit) {
		this.limit = limit;
	}

	@Override
	protected String getIdentifier() {
		return "";
	}


	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentBody()
	 */
	@Override
	protected String getContentBody() {
		return "";
	}

	
	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getQuery()
	 */
	@Override
	protected String getQuery() {
		List<String> queryParams = new ArrayList<String>();
		
		// get display
		if(this.isFullDisplay()){
			queryParams.add("display=full");
		}else{
			if(this.getFields() != null && this.getFields().size() > 0){
				StringBuilder fieldBuilder = new StringBuilder();
				for(String field : this.getFields()){
					fieldBuilder.append(",").append(field);
				}
				
				// include id
				//System.out.println("ID:" + this.id);
				if(this.id > 0 && !this.getFields().contains("id")){
					fieldBuilder.append(",id");
				}
				queryParams.add(String.format("display=[%s]", fieldBuilder.substring(1)));
			}
		}
		
		// get 
		if(this.limit != null && !this.limit.equals(Limit.EMPTY_LIMIT)){
			queryParams.add(this.limit.getFilterString());
		}
		
		if(this.sort != null && !this.sort.equals(Sort.EMPTY_SORT)){
			queryParams.add(this.sort.getFilterString());
		}
		
		if(this.filters!= null && !this.filters.isEmpty()){
			for(Filter filter : this.filters){
				queryParams.add(filter.getFilterString());
			}
		}
		
		if(queryParams.size() == 0) return "";
		
		StringBuilder query = new StringBuilder();
		
		for(String param : queryParams){
			query.append("&").append(param);
		}
		return "?" + query.substring(1);
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.model.PrestaShopRequest#getContentType()
	 */
	@Override
	protected String getContentType() {
		return "";
	}
		
	
	

}
