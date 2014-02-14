/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.PrestaShopPojoValidator;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopIntegerEnum;
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
	
	/**
	 * 
	 * @param entity
	 * @param validator
	 */
	InternalEntityReader(PrestaShopPojoEntity entity, PrestaShopPojoValidator validator){
		this.entity = entity;
		this.stream = new ByteArrayOutputStream();
		this.setValidator(validator);
		this.tags = new ArrayList<String>();
		this.tags.add("prestashop");
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws InvalidValueException
	 */
	public byte[] readAll() throws IOException, InvalidValueException {
		Class<?> clazz = entity.getClass();
		this.stream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
		this.stream.write("<prestashop xmlns:xlink=\"http://www.w3.org/1999/xlink\">".getBytes());
		
		// open resource
		this.openTag(clazz.getSimpleName().toLowerCase());
		
		// copy the id
		Field[] fields = clazz.getDeclaredFields();
//		for(Field field : fields){
//			PrestaShopText textAnnotation = field.getAnnotation(PrestaShopText.class);
//			if(textAnnotation != null && textAnnotation.value().equals("id")){
//				
//				long id = 0;
//				try {
//					field.setAccessible(true);
//					id = Long.parseLong(field.get(this.entity).toString());
//					field.setAccessible(false);
//				} catch (IllegalArgumentException
//						| IllegalAccessException e) {
//				}finally{
//					field.setAccessible(false);
//				}
//				if (id != 0){
//					this.openTag("id", String.valueOf(id));
//				}
//				break;
//			}
//		}
		
		// iterate over all non-virtual attributes 
		for(Field field : fields){
			PrestaShopText textAnnotation = field.getAnnotation(PrestaShopText.class);
			if(textAnnotation != null && !textAnnotation.isVirtual()){
				try {
					field.setAccessible(true);
					Object contentObj = field.get(this.entity);
					String content = getStringValue(contentObj, field);
					this.validator.validate(field, content);
					if(content.toString().length() == 0 || 
							(textAnnotation.nullOnZero() && content.toString().equals("0"))){
						this.openEmptyTag(textAnnotation.value());
					}else{
						this.openTag(textAnnotation.value(), content == null ? "" : content.toString());
					}
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
	
	/**
	 * 
	 * @param tag
	 * @throws IOException
	 */
	private void openTag(String tag) throws IOException{
		if(this.tags.size() == 0){
			throw new IOException("A malformed XML will be produced");
		}
		this.tags.add(tag);
		this.stream.write(String.format("<%s>", tag).getBytes());
	}
	
	/**
	 * 
	 * @param tag
	 * @param text
	 * @throws IOException
	 */
	private void openTag(String tag, String text) throws IOException{
		this.openTag(tag);
		this.putText(text);
		this.closeLastTag();
	}
	
	/**
	 * 
	 * @param tag
	 * @throws IOException
	 */
	private void openEmptyTag(String tag) throws IOException{
		if(this.tags.size() == 0){
			throw new IOException("A malformed XML will be produced");
		}
		this.stream.write(String.format("<%s/>", tag).getBytes());
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void closeLastTag() throws IOException{
		int index = this.tags.size() - 1;
		String tag = this.tags.get(index);
		this.stream.write(String.format("</%s>", tag).getBytes());
		this.tags.remove(index);
	}
	
	private void putText(String text) throws IOException{
		this.stream.write(text.getBytes());
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void close() throws IOException{
		if(this.tags.size() != 1){
			throw new IOException("A malformed XML will be produced");
		}
		this.closeLastTag();
	}
	
	/**
	 * 
	 * @param content
	 * @param field
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private String getStringValue(Object content, Field field){
		if(content == null) return "";
		Class<?> clazz = field.getType();
		switch(clazz.getSimpleName().toLowerCase()){
		case "string":
			return content.toString();
		case "bigdecimal":
			return ((BigDecimal)content).toPlainString();
		case "boolean":
			return String.valueOf((boolean)content);
		case "long":
			return String.valueOf((long)content);
		case "short":
			return String.valueOf((short)content);
		case "int":
			return String.valueOf((int)content);
		case "date":{
			return "01/01/1970"; 
		}
		default:
			if(clazz.isEnum()){
				@SuppressWarnings("rawtypes")
				Class<? extends Enum> enumClass = (Class<? extends Enum>)clazz;
				if(PShopIntegerEnum.class.isAssignableFrom(clazz)){
					return String.valueOf(Enum.valueOf(enumClass, content.toString()).ordinal());
				}else{
					return Enum.valueOf(enumClass, content.toString()).name();
				}
			}
		}
				
		return "";
		
	}

		
}
