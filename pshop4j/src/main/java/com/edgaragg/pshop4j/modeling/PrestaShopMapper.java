/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.GetRequest;
import com.edgaragg.pshop4j.model.HeadRequest;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.exceptions.FieldNotFoundException;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidResourceException;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.modeling.parser.PrestaShopSAXParser;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.list.PrestaShopPojoList;
import com.edgaragg.pshop4j.util.Tools;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopMapper {
	
	/**
	 * 
	 */
	public PrestaShopMapper(PrestaShopWebservice webservice) {
		this.parser = null;
		this.webservice = webservice;
	}

	
	/**
	 * 
	 * @param <P>
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws NotFilterableException 
	 * @throws FieldNotFoundException 
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T>	listFullDisplay(Class<T> clazz, List<Filter> filters, Sort sort, Limit limit){
		try {
			this.checkFilters(clazz, filters);
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		GetRequest request = new GetRequest().withResource(resource.value())
				.withFullDisplay(true)
				.withFilters(filters)
				.withLimit(limit);
		return this.executeGetRequest(clazz, request);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws NotFilterableException 
	 * @throws FieldNotFoundException 
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T>	list(Class<T> clazz, List<String> fields, List<Filter> filters, Sort sort, Limit limit){
		try {
			this.checkFilters(clazz, filters);
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		GetRequest request = new GetRequest().withResource(resource.value())
				.withFields(fields)
				.withFilters(filters)
				.withLimit(limit);
		
		return this.executeGetRequest(clazz, request);
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T> list(Class<T> clazz) {
		List<Filter> filters = Collections.emptyList();
		List<String> fields = Collections.emptyList();
		return this.list(clazz, fields, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);		
	}
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> 
	load(Class<T> clazz, PrestaShopPojoEntity key) {
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		GetRequest request = new GetRequest().withResource(resource.value()).withId(key == null ? 0 : key.getId());
		
		return this.executeGetRequest(clazz, request);
	}
	
	
	/**
	 * 
	 * @param keyObject
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> load(T keyObject){
		return this.load((Class<T>)keyObject.getClass(), keyObject);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws NotFilterableException 
	 * @throws FieldNotFoundException 
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T>	headFullDisplay(Class<T> clazz, List<Filter> filters, Sort sort, Limit limit){
		try {
			this.checkFilters(clazz, filters);
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
				.withFullDisplay(true)
				.withFilters(filters)
				.withLimit(limit);
		return this.executeGetRequest(clazz, request);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws NotFilterableException 
	 * @throws FieldNotFoundException 
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T>	head(Class<T> clazz, List<String> fields, List<Filter> filters, Sort sort, Limit limit) {
		try {
			this.checkFilters(clazz, filters);
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
				.withFields(fields)
				.withFilters(filters)
				.withLimit(limit);
		
		return this.executeGetRequest(clazz, request);
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoList<P>, P extends PrestaShopPojoEntity> 
	PrestaShopMapperResponse<T> head(Class<T> clazz){
		List<Filter> filters = Collections.emptyList();
		List<String> fields = Collections.emptyList();
		return this.head(clazz, fields, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);		
	}
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> 
	head(Class<T> clazz, PrestaShopPojoEntity key) {
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value()).withId(key == null ? 0 : key.getId());
		
		return this.executeGetRequest(clazz, request);
	}
	
	
	/**
	 * 
	 * @param keyObject
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> head(T keyObject) throws Exception{
		return this.load((Class<T>)keyObject.getClass(), keyObject);
	}
	
		
	
	/**
	 * 
	 * @param parser
	 * @return
	 */
	public PrestaShopMapper withXMLParser(PrestaShopXMLParser parser){
		this.parser = parser;
		return this;
	}

	/**
	 * 
	 * @param clazz
	 * @param request
	 * @return
	 */
	private <T extends PrestaShopPojo>
	PrestaShopMapperResponse<T> executeGetRequest(Class<T> clazz, GetRequest request){
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		// executes
		PrestaShopResponse response;
		try {
			response = this.webservice.executeRequest(request);
		} catch (IOException e) {
			e.printStackTrace();
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		
		InputStream stream = response.getStream();
		
		// finally, execute the parser
		return new PrestaShopMapperResponse<T>()
				.withResource((request instanceof HeadRequest) ? null : this.parser.parse(clazz, stream))
				.withHash(this.getResponseHash(response))
				.withHeaders(response.getHeaders());
		
	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	private String getResponseHash(PrestaShopResponse response){
		if(response.getHeaders().containsKey("Content-Sha1")){
			List<String> headValues = response.getHeaders().get("Content-Sha1");
			if(!headValues.isEmpty()){
				return headValues.get(0);
			}
		}
		return "";
	}
	
	
	@SuppressWarnings("unchecked")
	private <T extends PrestaShopPojo> void checkFilters(Class<T> clazz, List<Filter> filters) throws NotFilterableException, FieldNotFoundException {
		Class<T> innerClass = clazz;
		// clazz is a pojo list, we need to know the internal type of this list
		// to do that, we apply simple english rules
		//TODO: improve this, see http://www.yorku.ca/jmason/EnglishNoun.java 
		if(PrestaShopPojoList.class.isAssignableFrom(clazz)){
			String listClassName = clazz.getSimpleName();
			String entityClassName = "";
		
			if(listClassName.endsWith("sses") || listClassName.endsWith("shes") || listClassName.endsWith("ches")
					|| listClassName.endsWith("xes")){
				entityClassName = listClassName.substring(0, listClassName.length() - 2);
			}else if(listClassName.endsWith("ies")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("y");
			}else if(listClassName.endsWith("ves")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("f");
			}else if(listClassName.endsWith("ses")){
				entityClassName = listClassName.substring(0, listClassName.length() - 3).concat("sis");
			}else{
				entityClassName = listClassName.substring(0, listClassName.length() - 1);	
			}
			
			try {
				innerClass = (Class<T>) Class.forName("com.edgaragg.pshop4j.pojos.entities." + entityClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		for(Filter filter : filters){
			Field field = Tools.getFieldForElement(innerClass, filter.getField());
			if(field == null) throw new FieldNotFoundException(innerClass, filter.getField());
			if(field.isAnnotationPresent(PrestaShopText.class)){
				PrestaShopText text = field.getAnnotation(PrestaShopText.class);
				if(text.notFilterable()){
					throw new NotFilterableException(filter);
				}
			}
		}
		
	}
	
	private PrestaShopWebservice webservice; 
	private PrestaShopXMLParser parser;
	
}
