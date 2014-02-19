/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgaragg.pshop4j.modeling.PrestaShopPojoValidator;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.modeling.enums.PShopFormat;
import com.edgaragg.pshop4j.modeling.enums.PShopIntegerEnum;
import com.edgaragg.pshop4j.modeling.exceptions.InvalidValueException;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoEntity;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.entities.LanguageElement;
import com.edgaragg.pshop4j.pojos.list.LanguageElements;

/**
 * @author Edgar Gonzalez
 *
 */
final class InternalEntityReader {

	private ByteArrayOutputStream stream;
	private PrestaShopPojoEntity entity;
	private List<String> tags;
	private PrestaShopPojoValidator validator;
	private static final SimpleDateFormat DATE_FORMAT_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat DATE_FORMAT_LITE = new SimpleDateFormat("yyyy-MM-dd");
	
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
		
		// iterate over all non-virtual attributes 
		iterateFields(fields, this.entity, true);
		// close resource
		this.closeLastTag();
		this.close();
		return this.stream.toByteArray();
	}

	/**
	 * @param fields
	 * @throws IOException
	 * @throws InvalidValueException
	 */
	@SuppressWarnings("unchecked")
	private void iterateFields(Field[] fields, PrestaShopPojoEntity entity, boolean validate) throws IOException,
			InvalidValueException {
		for(Field field : fields){
			PrestaShopList listAnnotation = field.getAnnotation(PrestaShopList.class);
			PrestaShopElement elemAnnotation = field.getAnnotation(PrestaShopElement.class);
			PrestaShopText textAnnotation = field.getAnnotation(PrestaShopText.class);
			if(textAnnotation != null && !textAnnotation.isVirtual()){
				try {
					field.setAccessible(true);
					Object contentObj = field.get(entity);
					String content = getStringValue(contentObj, field);
					if(validate) this.validator.validate(field, content);
					
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
			}else if(listAnnotation != null && elemAnnotation != null){
				// It is a list. Get the class and iterate
				if(LanguageElement.class.isAssignableFrom(listAnnotation.value())){
					this.openTag(elemAnnotation.value());
					field.setAccessible(true);
					try {
						Map<String, String> id = new HashMap<String, String>();
						LanguageElements langs = (LanguageElements) field.get(entity);
						if(langs != null){
							for(LanguageElement lang : langs){
								id.clear();
								id.put("id", Long.toString(lang.getId()));
								this.openTagWithAttributes("language", id);
								String content = lang.getContent();
								this.putText((content == null || content.length() == 0) ? "" : content);
								this.closeLastTag();
							}
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}finally{
						field.setAccessible(false);
					}
					
					this.closeLastTag();
				}
				
			}else if(elemAnnotation != null && elemAnnotation.value().toLowerCase().equals("associations")){
				try {
					this.openTag("associations");
					field.setAccessible(true);
					Associations associations = (Associations)field.get(entity);
					if(associations != null){
						for(PrestaShopPojoList<?> list : associations){
							// get the tag
							PrestaShopElement listTag = list.getClass().getAnnotation(PrestaShopElement.class);
							if(list.size() == 0){
								this.openEmptyTag(listTag.value());
							}else{
								this.openTag(listTag.value());
								// iterate over all the items in the list
								for(PrestaShopPojoEntity entityInList : (PrestaShopPojoList<? extends PrestaShopPojoEntity>)list){
									PrestaShopElement entityTag = entityInList.getClass().getAnnotation(PrestaShopElement.class);
									this.openTag(entityTag.value());
									Field[] entityFields = entityInList.getClass().getDeclaredFields();
									this.iterateFields(entityFields, entityInList, false);
									this.closeLastTag();
								}
								this.closeLastTag();
							}
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}finally{
					field.setAccessible(false);
					this.closeLastTag();
				}
			}
		}
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
	 * @param text
	 * @throws IOException
	 */
	private void openTagWithAttributes(String tag, Map<String, String> attrs) throws IOException{
		if(this.tags.size() == 0){
			throw new IOException("A malformed XML will be produced");
		}
		this.tags.add(tag);
		this.stream.write(String.format("<%s", tag).getBytes());
		for(String key : attrs.keySet()){
			this.stream.write(String.format(" %s=\"%s\" ", key, attrs.get(key)).getBytes());
		}
		this.stream.write(String.format(">", tag).getBytes());
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
			PrestaShopText txt = field.getAnnotation(PrestaShopText.class);
			if(txt != null && txt.format().equals(PShopFormat.isBirthDate)){
				return DATE_FORMAT_LITE.format((Date)content);
			}else{
				return DATE_FORMAT_FULL.format((Date)content);
			}
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
