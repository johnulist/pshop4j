/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.PrestaShopPojoValidator;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
final class InternalEntityReader {

	private ByteArrayOutputStream stream;
	private PrestaShopPojoEntity entity;
	private List<String> tags;
	private PrestaShopPojoValidator validator;
	
	
	InternalEntityReader(PrestaShopPojoEntity entity, PrestaShopPojoValidator validator){
		this.entity = entity;
		this.stream = new ByteArrayOutputStream();
		this.setValidator(validator);
		this.tags = new ArrayList<String>();
		this.tags.add("prestashop");
	}
	
	public byte[] readAll() throws IOException, InvalidValueException {
		Class<?> clazz = entity.getClass();
		//PrestaShopResource resource = clazz.getAnnotation(PrestaShopResource.class);
		this.stream.write("<prestashop>".getBytes());
		
		// open resource
		//this.openTag(resource.value().name());
		this.openTag(clazz.getSimpleName().toLowerCase());
		
		// copy the id
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			PrestaShopText textAnnotation = field.getAnnotation(PrestaShopText.class);
			if(textAnnotation != null && textAnnotation.value().equals("id")){
				
				long id = 0;
				try {
					field.setAccessible(true);
					id = Long.parseLong(field.get(this.entity).toString());
					field.setAccessible(false);
				} catch (IllegalArgumentException
						| IllegalAccessException e) {
				}finally{
					field.setAccessible(false);
				}
				if (id != 0){
					this.openTag("id", String.valueOf(id));
				}
				break;
			}
		}
		
		// iterate over all non-virtual attributes 
		for(Field field : fields){
			PrestaShopText textAnnotation = field.getAnnotation(PrestaShopText.class);
			if(textAnnotation != null && !textAnnotation.isVirtual()){
				
				try {
					field.setAccessible(true);
					Object content = field.get(this.entity);
					this.validator.validate(field, content);
					this.openTag(textAnnotation.value(), content == null ? "" : content.toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} catch(InvalidValueException ex){
					field.setAccessible(false);
					throw ex;
				}finally{
					field.setAccessible(false);
				}
			}
		}
		// close resource
		this.closeLastTag();
		this.close();
		return this.stream.toByteArray();
	}
	
	
	/**
	 * @return the validator
	 */
	public PrestaShopPojoValidator getValidator() {
		return validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(PrestaShopPojoValidator validator) {
		this.validator = validator;
	}
	
	private void openTag(String tag) throws IOException{
		if(this.tags.size() == 0){
			throw new IOException("A malformed XML will be produced");
		}
		this.tags.add(tag);
		this.stream.write(String.format("<%s>", tag).getBytes());
	}
	
	private void openTag(String tag, String text) throws IOException{
		this.openTag(tag);
		this.putText(text);
		this.closeLastTag();
	}
	
//	private void openEmptyTag(String tag) throws IOException{
//		if(this.tags.size() == 0){
//			throw new IOException("A malformed XML will be produced");
//		}
//		this.stream.write(String.format("<%s/>", tag).getBytes());
//	}
	
	private void closeLastTag() throws IOException{
		int index = this.tags.size() - 1;
		String tag = this.tags.get(index);
		this.stream.write(String.format("<%s>", tag).getBytes());
		this.tags.remove(index);
	}
	
	private void putText(String text) throws IOException{
		this.stream.write(text.getBytes());
	}
	
	private void close() throws IOException{
		if(this.tags.size() != 1){
			throw new IOException("A malformed XML will be produced");
		}
		this.closeLastTag();
	}

		
}
