/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.DeleteRequest;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.GetRequest;
import com.edgaragg.pshop4j.model.HeadRequest;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.PostRequest;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
import com.edgaragg.pshop4j.model.PutRequest;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.modeling.defaults.PrestaShopDefaultXMLGenerator;
import com.edgaragg.pshop4j.modeling.defaults.PrestaShopSAXParser;
import com.edgaragg.pshop4j.modeling.defaults.PrestaShopValidator;
import com.edgaragg.pshop4j.modeling.exceptions.FieldNotFoundException;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidResourceException;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.modeling.exceptions.NotFilterableException;
import com.edgaragg.pshop4j.modeling.exceptions.PrestaShopServerException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;

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
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		GetRequest request = new GetRequest().withResource(resource.value())
				.withFullDisplay(true)
				.withFilters(filters)
				.withSort(sort)
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
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		GetRequest request = new GetRequest().withResource(resource.value())
				.withFields(fields)
				.withFilters(filters)
				.withLimit(limit)
				.withSort(sort);
		
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
		this.checkDefaults();
		
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
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
				.withFullDisplay(true)
				.withFilters(filters)
				.withSort(sort)
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
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			return new PrestaShopMapperResponse<T>()
					.withException(new InvalidResourceException(clazz));
		}
		
		HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
				.withFields(fields)
				.withFilters(filters)
				.withSort(sort)
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
		this.checkDefaults();
		
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
	 * @param entity
	 * @return
	 */
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> post(T entity){
		this.checkDefaults();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) entity.getClass();
		try {
			PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
			if(resource == null){
				return new PrestaShopMapperResponse<T>()
						.withException(new InvalidResourceException(clazz));
			}
			InputStream stream = this.generator.generate(entity);
			PostRequest request = new PostRequest().withEntityStream(stream).withResource(resource.value());
			PrestaShopResponse response = this.webservice.executeRequest(request);
			
			return new PrestaShopMapperResponse<T>()
					.withResource(this.parser.parse(clazz, response.getStream()))
					.withHash(this.getResponseHash(response))
					.withHeaders(response.getHeaders());
			
		} catch (IOException | InvalidValueException | PrestaShopServerException e1) {
			return new PrestaShopMapperResponse<T>()
					.withException(e1);
		}
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> put(T entity){
		this.checkDefaults();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) entity.getClass();
		try {
			
			PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
			if(resource == null){
				return new PrestaShopMapperResponse<T>()
						.withException(new InvalidResourceException(clazz));
			}
			InputStream stream = this.generator.generate(entity);
			
			PutRequest request = new PutRequest().withEntityStream(stream).withId(entity.getId()).withResource(resource.value());
			PrestaShopResponse response = this.webservice.executeRequest(request);
			
			return new PrestaShopMapperResponse<T>()
					.withResource(this.parser.parse(clazz, response.getStream()))
					.withHash(this.getResponseHash(response))
					.withHeaders(response.getHeaders());
		} catch (IOException | InvalidValueException | PrestaShopServerException e1) {
			e1.printStackTrace();
			return new PrestaShopMapperResponse<T>()
					.withException(e1);
		}	
	}
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public <T extends PrestaShopPojoEntity> PrestaShopMapperResponse<T> delete(T entity){
		this.checkDefaults();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) entity.getClass();
		try {
			
			PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
			if(resource == null){
				return new PrestaShopMapperResponse<T>()
						.withException(new InvalidResourceException(clazz));
			}

			DeleteRequest request = new DeleteRequest().withId(entity.getId()).withResource(resource.value());
			PrestaShopResponse response = this.webservice.executeRequest(request);
						
			return new PrestaShopMapperResponse<T>()
					.withHeaders(response.getHeaders())
					.withHash(this.getResponseHash(response));
		} catch (IOException | PrestaShopServerException e1) {
			e1.printStackTrace();
			return new PrestaShopMapperResponse<T>()
					.withException(e1);
		}	
	}
			
	
	/**
	 * 
	 * @param parser
	 * @return
	 */
	public PrestaShopMapper withParser(PrestaShopParser parser){
		this.parser = parser;
		return this;
	}
	
	/**
	 * 
	 * @param generator
	 * @return
	 */
	public PrestaShopMapper withGenerator(PrestaShopGenerator generator){
		this.generator = generator;
		return this;
	}
	
	
	/**
	 * 
	 * @param validator
	 * @return
	 */
	public PrestaShopMapper withPojoValidator(PrestaShopPojoValidator validator){
		this.validator = validator;
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
		checkDefaults();
		try {
			this.validator.checkFilters(clazz, request.getFilters());
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<T>()
					.withException(e);
		}
		// executes
		PrestaShopResponse response;
		try {
			response = this.webservice.executeRequest(request);
		} catch (IOException | PrestaShopServerException e) {
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
	 */
	private void checkDefaults() {
		if(this.parser == null){
			this.parser = new PrestaShopSAXParser();
		}
		if(this.validator == null){
			this.validator = new PrestaShopValidator();
		}
		if(this.generator == null){
			this.generator = new PrestaShopDefaultXMLGenerator();
		}
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


	private PrestaShopWebservice webservice; 
	private PrestaShopParser parser;
	private PrestaShopGenerator generator;
	private PrestaShopPojoValidator validator;
	
}
