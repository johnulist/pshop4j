/**
 * 
 */
package com.edgaragg.pshop4j.modeling;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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
public class PrestaShopAsyncMapper {


	/**
	 * 
	 */
	public PrestaShopAsyncMapper(PrestaShopWebservice webservice) {
		this.parser = null;
		this.webservice = webservice;
	}
	
	
	/**
	 * 
	 * @param keyObject
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	load(final ENTITY keyObject, final PrestaShopAsyncResponse<ENTITY> response){
		return this.load((Class<ENTITY>)keyObject.getClass(), keyObject, response);
	}
	
	/**
	 * 
	 * @param keyObject
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	load(final ENTITY keyObject){
		return this.load(keyObject, null);
	}
	
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @param response
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	load(final Class<ENTITY> clazz, final PrestaShopPojoEntity key, final PrestaShopAsyncResponse<ENTITY> response) {
		this.checkDefaults();
		
		Callable<PrestaShopMapperResponse<ENTITY>> callable = new Callable<PrestaShopMapperResponse<ENTITY>>(){
			@Override
			public PrestaShopMapperResponse<ENTITY> call() throws Exception {
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<ENTITY>()
							.withException(new InvalidResourceException(clazz));
				}
				
				GetRequest request = new GetRequest().withResource(resource.value()).withId(key == null ? 0 : key.getId());
				PrestaShopMapperResponse<ENTITY> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);
				return mapperResponse;
			}
		};
		FutureTask<PrestaShopMapperResponse<ENTITY>> task = new FutureTask<PrestaShopMapperResponse<ENTITY>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	load(final Class<ENTITY> clazz, final PrestaShopPojoEntity key) {
		return this.load(clazz, key, null);
	}
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	list(
			final Class<LIST> clazz, 
			final List<String> fields, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit, 
			final PrestaShopAsyncResponse<LIST> response){
		
		Callable<PrestaShopMapperResponse<LIST>> callable = new Callable<PrestaShopMapperResponse<LIST>>(){
			@Override
			public PrestaShopMapperResponse<LIST> call() throws Exception {
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<LIST>()
							.withException(new InvalidResourceException(clazz));
				}
				
				GetRequest request = new GetRequest().withResource(resource.value())
						.withFields(fields)
						.withFilters(filters)
						.withLimit(limit)
						.withSort(sort);
				PrestaShopMapperResponse<LIST> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);
				return mapperResponse;
			}
		};
		FutureTask<PrestaShopMapperResponse<LIST>> task = new FutureTask<PrestaShopMapperResponse<LIST>>(callable);
		executor.execute(task);
		return task;
	}
	
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	list(
			final Class<LIST> clazz, 
			final List<String> fields, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit){
		return this.list(clazz, fields, filters, sort, limit, null);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> list(final Class<LIST> clazz, final PrestaShopAsyncResponse<LIST> response) {
		List<Filter> filters = Collections.emptyList();
		List<String> fields = Collections.emptyList();
		return this.list(clazz, fields, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT, response);
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> list(final Class<LIST> clazz) {
		return this.list(clazz, null);
	}
	
	
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> listFullDisplay(
			final Class<LIST> clazz, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit,
			final PrestaShopAsyncResponse<LIST> response){
		Callable<PrestaShopMapperResponse<LIST>> callable = new Callable<PrestaShopMapperResponse<LIST>>(){
			@Override
			public PrestaShopMapperResponse<LIST> call() throws Exception {
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<LIST>()
							.withException(new InvalidResourceException(clazz));
				}
				
				GetRequest request = new GetRequest().withResource(resource.value())
						.withFullDisplay(true)
						.withFilters(filters)
						.withSort(sort)
						.withLimit(limit);
				PrestaShopMapperResponse<LIST> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);
				return mapperResponse;
			}
		};
		FutureTask<PrestaShopMapperResponse<LIST>> task = new FutureTask<PrestaShopMapperResponse<LIST>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> listFullDisplay(
			final Class<LIST> clazz, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit){
		return this.listFullDisplay(clazz, filters, sort, limit, null);
	}
	
	
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	headFullDisplay(
			final Class<LIST> clazz, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit,
			final PrestaShopAsyncResponse<LIST> response){
		Callable<PrestaShopMapperResponse<LIST>> callable = new Callable<PrestaShopMapperResponse<LIST>>(){
			@Override
			public PrestaShopMapperResponse<LIST> call() throws Exception {
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<LIST>()
							.withException(new InvalidResourceException(clazz));
				}
				HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
						.withFullDisplay(true)
						.withFilters(filters)
						.withSort(sort)
						.withLimit(limit);
				PrestaShopMapperResponse<LIST> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);				
				return mapperResponse;
			}
		};
		
		FutureTask<PrestaShopMapperResponse<LIST>> task = new FutureTask<PrestaShopMapperResponse<LIST>>(callable);
		executor.execute(task);
		return task;
	}
	
	
	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	headFullDisplay(
			final Class<LIST> clazz, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit){
		return this.headFullDisplay(clazz, filters, sort, limit, null);	
	}
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	head(
			final Class<LIST> clazz, 
			final List<String> fields, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit,
			final PrestaShopAsyncResponse<LIST> response) {
		
		Callable<PrestaShopMapperResponse<LIST>> callable = new Callable<PrestaShopMapperResponse<LIST>>(){
			@Override
			public PrestaShopMapperResponse<LIST> call() throws Exception {
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<LIST>()
							.withException(new InvalidResourceException(clazz));
				}
				
				HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value())
						.withFields(fields)
						.withFilters(filters)
						.withSort(sort)
						.withLimit(limit);
				
				PrestaShopMapperResponse<LIST> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);				
				return mapperResponse;
			}
		};
		FutureTask<PrestaShopMapperResponse<LIST>> task = new FutureTask<PrestaShopMapperResponse<LIST>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>>	head(
			final Class<LIST> clazz, 
			final List<String> fields, 
			final List<Filter> filters, 
			final Sort sort, 
			final Limit limit){
		return this.head(clazz, fields, filters, sort, limit, null);
	}
			
	
	/**
	 * 
	 * @param clazz
	 * @param response
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> head(final Class<LIST> clazz, final PrestaShopAsyncResponse<LIST> response){
		List<Filter> filters = Collections.emptyList();
		List<String> fields = Collections.emptyList();
		return this.head(clazz, fields, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT, response);		
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public <LIST extends PrestaShopPojoList<ENTITY>, ENTITY extends PrestaShopPojoEntity> 
	Future<PrestaShopMapperResponse<LIST>> head(final Class<LIST> clazz){
		return this.head(clazz, null);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @param response
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	head(final Class<ENTITY> clazz, final PrestaShopPojoEntity key, final PrestaShopAsyncResponse<ENTITY> response) {
		Callable<PrestaShopMapperResponse<ENTITY>> callable = new Callable<PrestaShopMapperResponse<ENTITY>>(){
			@Override
			public PrestaShopMapperResponse<ENTITY> call() throws Exception {
				checkDefaults();
				PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
				if(resource == null){
					return new PrestaShopMapperResponse<ENTITY>()
							.withException(new InvalidResourceException(clazz));
				}
				
				HeadRequest request = (HeadRequest) new HeadRequest().withResource(resource.value()).withId(key == null ? 0 : key.getId());
				PrestaShopMapperResponse<ENTITY> mapperResponse = executeGetRequest(clazz, request);
				if(response != null) response.setPrestaShopResponse(mapperResponse);				
				return mapperResponse;
			}
		};
		FutureTask<PrestaShopMapperResponse<ENTITY>> task = new FutureTask<PrestaShopMapperResponse<ENTITY>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param key
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	head(final Class<ENTITY> clazz, final PrestaShopPojoEntity key){
		return this.head(clazz, key, null);
	}
	
	/**
	 * 
	 * @param keyObject
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	head(final ENTITY keyObject, final PrestaShopAsyncResponse<ENTITY> response){
		return this.load((Class<ENTITY>)keyObject.getClass(), keyObject, response);
	}
	
	/**
	 * 
	 * @param keyObject
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>>
	head(final ENTITY keyObject){
		return this.head(keyObject, null);
	}
	
	
	/**
	 * 
	 * @param entity
	 * @param response
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	post(final ENTITY entity, final PrestaShopAsyncResponse<ENTITY> response){
		Callable<PrestaShopMapperResponse<ENTITY>> callable = new Callable<PrestaShopMapperResponse<ENTITY>>(){
			@Override
			public PrestaShopMapperResponse<ENTITY> call() throws Exception {
				checkDefaults();
				@SuppressWarnings("unchecked")
				Class<ENTITY> clazz = (Class<ENTITY>) entity.getClass();
				try {
					PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
					if(resource == null){
						return new PrestaShopMapperResponse<ENTITY>()
								.withException(new InvalidResourceException(clazz));
					}
					InputStream stream = generator.generate(entity);
					PostRequest request = new PostRequest().withEntityStream(stream).withResource(resource.value());
					PrestaShopResponse innerResponse = webservice.executeRequest(request);
					
					PrestaShopMapperResponse<ENTITY> mapperResponse = new PrestaShopMapperResponse<ENTITY>()
							.withResource(parser.parse(clazz, innerResponse.getStream()))
							.withHash(getResponseHash(innerResponse))
							.withHeaders(innerResponse.getHeaders());
					if(response != null) response.setPrestaShopResponse(mapperResponse);				
					return mapperResponse;
					
				} catch (IOException | InvalidValueException | PrestaShopServerException e1) {
					return new PrestaShopMapperResponse<ENTITY>()
							.withException(e1);
				}
			}
		};
		FutureTask<PrestaShopMapperResponse<ENTITY>> task = new FutureTask<PrestaShopMapperResponse<ENTITY>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	post(final ENTITY entity){
		return this.post(entity, null);
	}
	
	/**
	 * 
	 * @param entity
	 * @param response
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	put(final ENTITY entity, final PrestaShopAsyncResponse<ENTITY> response){
		Callable<PrestaShopMapperResponse<ENTITY>> callable = new Callable<PrestaShopMapperResponse<ENTITY>>(){
			@Override
			public PrestaShopMapperResponse<ENTITY> call() throws Exception {
				checkDefaults();
				@SuppressWarnings("unchecked")
				Class<ENTITY> clazz = (Class<ENTITY>) entity.getClass();
				try {
					
					PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
					if(resource == null){
						return new PrestaShopMapperResponse<ENTITY>()
								.withException(new InvalidResourceException(clazz));
					}
					InputStream stream = generator.generate(entity);
					
					PutRequest request = new PutRequest().withEntityStream(stream).withId(entity.getId()).withResource(resource.value());
					PrestaShopResponse innerResponse = webservice.executeRequest(request);
					
					PrestaShopMapperResponse<ENTITY> mapperResponse = new PrestaShopMapperResponse<ENTITY>()
							.withResource(parser.parse(clazz, innerResponse.getStream()))
							.withHash(getResponseHash(innerResponse))
							.withHeaders(innerResponse.getHeaders());
					if(response != null) response.setPrestaShopResponse(mapperResponse);				
					return mapperResponse;
				} catch (IOException | InvalidValueException | PrestaShopServerException e1) {
					e1.printStackTrace();
					return new PrestaShopMapperResponse<ENTITY>()
							.withException(e1);
				}	
			}
		};
		FutureTask<PrestaShopMapperResponse<ENTITY>> task = new FutureTask<PrestaShopMapperResponse<ENTITY>>(callable);
		executor.execute(task);
		return task;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	put(final ENTITY entity){
		return this.put(entity, null);
	}
	
	
	/**
	 * 
	 * @param entity
	 * @param response
	 * @return
	 */
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	delete(final ENTITY entity, final PrestaShopAsyncResponse<ENTITY> response){
		Callable<PrestaShopMapperResponse<ENTITY>> callable = new Callable<PrestaShopMapperResponse<ENTITY>>(){
			@Override
			public PrestaShopMapperResponse<ENTITY> call() throws Exception {
				checkDefaults();
				@SuppressWarnings("unchecked")
				Class<ENTITY> clazz = (Class<ENTITY>) entity.getClass();
				try {
					
					PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
					if(resource == null){
						return new PrestaShopMapperResponse<ENTITY>()
								.withException(new InvalidResourceException(clazz));
					}

					DeleteRequest request = new DeleteRequest().withId(entity.getId()).withResource(resource.value());
					PrestaShopResponse innerResponse = webservice.executeRequest(request);

					PrestaShopMapperResponse<ENTITY> mapperResponse = new PrestaShopMapperResponse<ENTITY>()
							.withHeaders(innerResponse.getHeaders())
							.withHash(getResponseHash(innerResponse));
					if(response != null) response.setPrestaShopResponse(mapperResponse);				
					return mapperResponse;
				} catch (IOException | PrestaShopServerException e1) {
					e1.printStackTrace();
					return new PrestaShopMapperResponse<ENTITY>()
							.withException(e1);
				}	
			}
		};
		FutureTask<PrestaShopMapperResponse<ENTITY>> task = new FutureTask<PrestaShopMapperResponse<ENTITY>>(callable);
		executor.execute(task);
		return task;
	}
	
	public <ENTITY extends PrestaShopPojoEntity> Future<PrestaShopMapperResponse<ENTITY>> 
	delete(final ENTITY entity){
		return this.delete(entity, null);
	}
	
	
	/**
	 * 
	 * @param parser
	 * @return
	 */
	public PrestaShopAsyncMapper withParser(PrestaShopParser parser){
		this.parser = parser;
		return this;
	}
	
	/**
	 * 
	 * @param generator
	 * @return
	 */
	public PrestaShopAsyncMapper withGenerator(PrestaShopGenerator generator){
		this.generator = generator;
		return this;
	}
	
	
	/**
	 * 
	 * @param validator
	 * @return
	 */
	public PrestaShopAsyncMapper withPojoValidator(PrestaShopPojoValidator validator){
		this.validator = validator;
		return this;
	}
	
	/**
	 * @return the executor
	 */
	public static Executor getExecutor() {
		return executor;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param request
	 * @return
	 */
	private <POJO extends PrestaShopPojo>
	PrestaShopMapperResponse<POJO> executeGetRequest(Class<POJO> clazz, GetRequest request){
		synchronized(this){
			checkDefaults();
		}
		try {
			this.validator.checkFilters(clazz, request.getFilters());
		} catch (NotFilterableException | FieldNotFoundException e) {
			return new PrestaShopMapperResponse<POJO>()
					.withException(e);
		}
		// executes
		PrestaShopResponse response;
		try {
			response = this.webservice.executeRequest(request);
		} catch (IOException | PrestaShopServerException e) {
			e.printStackTrace();
			return new PrestaShopMapperResponse<POJO>()
					.withException(e);
		}
		
		InputStream stream = response.getStream();
		System.out.println("END");
		// finally, execute the parser
		return new PrestaShopMapperResponse<POJO>()
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

	

	/**
	 * @param executor the executor to set
	 */
	protected static void setExecutor(Executor executor) {
		PrestaShopAsyncMapper.executor = executor;
	}
		
	
	static{
		setExecutor(Executors.newCachedThreadPool());
	}
	
	private static Executor executor;
	private PrestaShopWebservice webservice; 
	private PrestaShopParser parser;
	private PrestaShopGenerator generator;
	private PrestaShopPojoValidator validator;
	
}
