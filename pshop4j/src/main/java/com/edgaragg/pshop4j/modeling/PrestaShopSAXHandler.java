/**
 * 
 */
package com.edgaragg.pshop4j.modeling;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 * @param <T>
 *
 */
public class PrestaShopSAXHandler extends DefaultHandler {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat BIRTHDAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final String PRESTASHOP = "prestashop";
	private boolean firstElement = true;
	private Class<?> clazz;
	private String text;
	private Vector<SAXObjectDescription> heap;

	
	/**
	 * @param <T>
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public <T extends PrestaShopPojo> PrestaShopSAXHandler(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		this.clazz = clazz;
		this.heap = new Vector<SAXObjectDescription>();
		this.heap.add(new SAXObjectDescription((PrestaShopPojo)this.clazz.newInstance()));
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz){
		return (T) this.heap.get(0).getPojo();
	}

	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		this.text = new String(ch, start, length);
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		
		// end ignoring element
		SAXObjectDescription desc = this.heap.get(this.heap.size() - 1);
		if(desc.isIgnoringElement(qName)){
			desc.setIgnore(null);
			return;
		}
		if(desc.isIgnoring()) return;
		
		// first of all, we assign the text attribute if exists
		if(text.trim().length() > 0){
			PrestaShopPojo textElement = this.heap.get(this.heap.size()-1).getPojo();
			Field field = this.getFieldElementFor(textElement.getClass(), qName);
			if(field != null){
				field.setAccessible(true);
				try {
					field.set(textElement, this.cast(text.trim(), field.getType()));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				field.setAccessible(false);
			}
		}
		
		if(this.heap.size() > 1){
			PrestaShopPojo lastElement = this.heap.get(this.heap.size() - 1).getPojo();			
			PrestaShopPojo owner = this.heap.get(this.heap.size() - 2).getPojo();

			// look into the owner object the field for the last element
			Field field = this.getFieldElementFor(owner.getClass(), qName);
		
			if(field == null || field.getType().isPrimitive() || field.getType().getSimpleName().equalsIgnoreCase("string")){
				return;
			}
			
			// checking if the field is a list
			if(field.getType().isAssignableFrom(List.class)){				
				try {
					field.setAccessible(true);
					@SuppressWarnings("unchecked")
					List<Object> innerList =  (List<Object>) field.get(owner);
					innerList.add(lastElement);
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}	
			}else{
				field.setAccessible(true);
				try {
					field.set(owner, lastElement);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				field.setAccessible(false);
			}
			this.heap.remove(lastElement);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	protected <T> T cast(Object o, Class<T> clazz){
		Object instance = null;
		if(clazz.getSimpleName().equalsIgnoreCase("string")){
			instance = o.toString();
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("bigdecimal")){
			instance = new BigDecimal(o.toString());
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("boolean")){
			 instance = Boolean.parseBoolean(o.toString());
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("long")){
			instance = Long.parseLong(o.toString());
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("short")){
			instance = Short.parseShort(o.toString());
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("int")){
			instance = Integer.parseInt(o.toString());
		}else
		if(clazz.getSimpleName().equalsIgnoreCase("date")){
			String trimmedData = o.toString().trim();
			if(trimmedData.equals("")) return null;
			try {
				instance = (trimmedData.length() == 10 ? BIRTHDAY_FORMAT : DATE_FORMAT).parse(o.toString()); 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			
		
		return (T) instance;
	}

	protected <T> Field getFieldElementFor(Class<T> searchClazz, String element){
		Field[] fields = searchClazz.getDeclaredFields();
		for(Field field : fields){
			PrestaShopElement fieldElement = field.getAnnotation(PrestaShopElement.class);
			PrestaShopText fieldText = field.getAnnotation(PrestaShopText.class);
			
			if((fieldElement != null && fieldElement.name().equals(element)) || 
					(fieldText != null && fieldText.element().equals(element))){
				return field;
			}
		}
		return null;
	}
	
	
	
	
	
	protected <T> void fillAttributes(Class<T> clazz, Object currentObj, Attributes attributes){
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			PrestaShopAttribute fieldAttribute = field.getAnnotation(PrestaShopAttribute.class);
			if(fieldAttribute != null){
				String attrValue = attributes.getValue("", fieldAttribute.name());
				if(attrValue == null) continue;
				try {
					field.setAccessible(true);
					field.set(currentObj, cast(attrValue, field.getType()));
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(PRESTASHOP.equals(qName)) return;
		
		SAXObjectDescription desc = this.heap.get(this.heap.size() - 1); 
		if(desc.isIgnoring()){
			return;
		}
		if(desc.checkForIgnorableElement(qName)){
			desc.setIgnore(qName);
			return;
		}
			
		if(this.firstElement){
			firstElement = false;
			PrestaShopElement element = this.clazz.getAnnotation(PrestaShopElement.class);
			if(!element.name().equals(qName)){
				this.fatalError(new SAXParseException("Class element does not match with XML document", null));
				return;
			}
			this.fillAttributes(this.clazz, this.heap.get(0), attributes);
		}else{
			// we are in an element that can be or not another object.
			// we must to check for it.  To do this, we find the field into the current object
			// and iterate
			Class<?> currentClass = this.heap.get(this.heap.size()-1).getPojo().getClass();
			Field elementField = this.getFieldElementFor(currentClass, qName);
			if(elementField == null){
				return;
			}
			if(!elementField.getType().isPrimitive() && !elementField.getType().getSimpleName().equalsIgnoreCase("string")
					&& !elementField.getType().getSimpleName().equalsIgnoreCase("bigdecimal")
					&& !elementField.getType().getSimpleName().equalsIgnoreCase("date")){
				try {
					Class<?> newClass = elementField.getType();
					
					if(newClass.isAssignableFrom(List.class) && elementField.isAnnotationPresent(PrestaShopList.class)){			
						Class<?> listClass = elementField.getAnnotation(PrestaShopList.class).type(); 
						PrestaShopPojo currentObject = (PrestaShopPojo)listClass.newInstance();
						this.fillAttributes(listClass, currentObject, attributes);
						this.heap.add(new SAXObjectDescription(currentObject));
					}else{
						PrestaShopPojo currentObject = (PrestaShopPojo)newClass.newInstance();
						this.fillAttributes(newClass, currentObject, attributes);
						this.heap.add(new SAXObjectDescription(currentObject));
					}
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
					
			}
		}
		
	}

}
