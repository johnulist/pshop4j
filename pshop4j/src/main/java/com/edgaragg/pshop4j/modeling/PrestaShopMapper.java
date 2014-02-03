/**
 * 
 */
package com.edgaragg.pshop4j.modeling;



import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.GetRequest;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.PrestaShopResponse;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopResource;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopMapper {

	private PrestaShopWebservice webservice; 
	private PrestaShopXMLParser parser;
	private PrestaShopMapperListener listener;
	
	/**
	 * 
	 */
	public PrestaShopMapper(PrestaShopWebservice webservice) {
		this.parser = null;
		this.webservice = webservice;
		this.listener = null;
	}

	/**
	 * 
	 * @param clazz
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojo> T listFullDisplay(Class<T> clazz, List<Filter> filters, Sort sort, Limit limit) throws Exception{
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			// TODO: create exception class
			throw new Exception("Invalid resource");
		}
		
		GetRequest request = new GetRequest().withResource(resource.resource())
				.withFullDisplay(true)
				.withFilters(filters)
				.withLimit(limit);
		
		// executes
		PrestaShopResponse response = this.webservice.executeRequest(request); 
		InputStream stream = response.getStream();
		this.sendToListener(response);
		// finally, execute the parser
		return this.parser.parse(clazz, stream);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param fields
	 * @param filters
	 * @param sort
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojo> T list(Class<T> clazz, List<String> fields, List<Filter> filters, Sort sort, Limit limit) throws Exception{
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			// TODO: create exception class
			throw new Exception("Invalid resource");
		}
		
		GetRequest request = new GetRequest().withResource(resource.resource())
				.withFields(fields)
				.withFilters(filters)
				.withLimit(limit);
		
		// executes
		PrestaShopResponse response = this.webservice.executeRequest(request); 
		InputStream stream = response.getStream();
		this.sendToListener(response);
		// finally, execute the parser
		return this.parser.parse(clazz, stream);
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T extends PrestaShopPojo> T list(Class<T> clazz) throws Exception{
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
	public <T extends PrestaShopPojoEntity> T load(Class<T> clazz, PrestaShopPojoEntity key) throws Exception{
		if(this.parser == null){
			parser = new PrestaShopSAXParser();
		}
		
		PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		if(resource == null){
			// TODO: create exception class
			throw new Exception("Invalid resource");
		}
		
		GetRequest request = new GetRequest().withResource(resource.resource()).withId(key == null ? 0 : key.getId());
		
		// executes
		PrestaShopResponse response = this.webservice.executeRequest(request); 
		InputStream stream = response.getStream();
		this.sendToListener(response);
		// finally, execute the parser
		return this.parser.parse(clazz, stream);
	}
	
	/**
	 * 
	 * @param response
	 */
	private void sendToListener(PrestaShopResponse response){
		if(this.listener != null && response.getHeaders().containsKey("Content-Sha1")){
			List<String> headValues = response.getHeaders().get("Content-Sha1");
			if(!headValues.isEmpty()){
				listener.sendResponseHash(headValues.get(0));
			}
		}
	}
	
	/**
	 * 
	 * @param keyObject
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends PrestaShopPojoEntity> T load(T keyObject) throws Exception{
		return (T) load(keyObject.getClass(), keyObject);
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
	 * @return the listener
	 */
	public PrestaShopMapperListener getListener() {
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public void setListener(PrestaShopMapperListener listener) {
		this.listener = listener;
	}
	
}
