/**
 * 
 */
package com.edgaragg.pshop4j.modeling;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopIgnore;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 * @param <T>
 *
 */
public class PrestaShopSAXHandler extends DefaultHandler {
	private static final String PRESTASHOP = "prestashop";
	private boolean firstElement = true;
	private Class<?> clazz;
	private String text;
	private Vector<Object> heap;
	private Map<Class<?>, List<String>> ignoreList;
	private String currentIgnoringElement = null;
	
	/**
	 * @param <T>
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public <T extends PrestaShopPojo> PrestaShopSAXHandler(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		this.clazz = clazz;
//		this.customObject = this.clazz.newInstance();
		this.heap = new Vector<Object>();
		this.heap.add(this.clazz.newInstance());
		this.ignoreList = new HashMap<Class<?>, List<String>>();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz){
		return (T) this.heap.get(0);
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
		if(this.currentIgnoringElement != null){
			if(this.currentIgnoringElement.equals(qName)){
				this.currentIgnoringElement = null;
			}
			return;
		}
		// first of all, we assign the text attribute if exists
		if(text.trim().length() > 0){
			Object textElement = this.heap.get(this.heap.size()-1);
			Field field = this.getFieldElementFor(textElement.getClass(), qName);
			if(field != null){
				field.setAccessible(true);
				try {
					field.set(textElement, this.cast(text.trim(), field.getType()));
					System.out.printf("\tSetting value %s into %s (%s)\n", text.trim(), field.getName(), field.getType().getSimpleName());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				field.setAccessible(false);
			}
		}
		
		if(this.heap.size() > 1){
			Object lastElement = this.heap.get(this.heap.size() - 1);			
			Object owner = this.heap.get(this.heap.size() - 2);
			// look for the element annotation on lastElement
			//PrestaShopElement classElement = lastElement.getClass().getAnnotation(PrestaShopElement.class);
			// look into the owner object the field for the last element
			Field field = this.getFieldElementFor(owner.getClass(), qName);
		
			if(field == null || field.getType().isPrimitive() || field.getType().getSimpleName().equalsIgnoreCase("string")){
				return;
			}
			
			// checking if the field is a list
			if(field.getType().isAssignableFrom(List.class)){
				System.out.println(field.getName() + ":" + field.getType().getSimpleName());
				
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
		this.addIgnoreForClass(this.clazz);
	}
	
	private void addIgnoreForClass(Class<?> cls){
		System.out.println("Creating ignore list for " + cls.getSimpleName());
		Annotation[] ann = cls.getAnnotations();
		for(Annotation a : ann){
			System.out.println("\t" + a.annotationType().getSimpleName());
		}
		PrestaShopIgnore ignoreAnnotation = cls.getAnnotation(PrestaShopIgnore.class);
		List<String> ignore = new ArrayList<String>();
		if(ignoreAnnotation != null){
			System.out.println("HAS SOMETHING");
			String[] items = ignoreAnnotation.elements().split(",");
			for(String item : items){
				System.out.println("Ignore " + item);
				ignore.add(item.trim().toLowerCase());
			}
		}else{
			System.out.println("NO IGNORABLE ITEMS");
		}
		this.ignoreList.put(cls, ignore);
		
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
		}
		
		return (T) instance;
	}

	protected <T> Field getFieldElementFor(Class<T> searchClazz, String element){
		Field[] fields = searchClazz.getDeclaredFields();
		//System.out.println("Finding field for " + element);
		for(Field field : fields){
			PrestaShopElement fieldElement = field.getAnnotation(PrestaShopElement.class);
			PrestaShopText fieldText = field.getAnnotation(PrestaShopText.class);
//			if(fieldElement != null) System.out.println("FIELD: " + fieldElement.name());
//			if(fieldText != null) System.out.println("FIELD: " + fieldText.element());
			
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
			//System.out.println("FIELD: " + field.getName());
			
			PrestaShopAttribute fieldAttribute = field.getAnnotation(PrestaShopAttribute.class);
			if(fieldAttribute != null){
				String attrValue = attributes.getValue("", fieldAttribute.name());
				if(attrValue == null) continue;
				try {
					System.out.printf("\tSetting value %s into %s (%s)\n", attrValue, field.getName(), field.getType().getSimpleName());
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
		
		// Ignoring element.. it is a child of an ignored element
		if(currentIgnoringElement != null){
			System.out.println("Ignoring " + qName + " because of " + currentIgnoringElement);
			return;
		}
		// check if the current element must be ignored
		List<String> currentIgnoreList = this.ignoreList.get(this.heap.get(this.heap.size() - 1).getClass());
		Class<?> cls = this.heap.get(this.heap.size() - 1).getClass();
		System.out.println("Checking for " + cls.getSimpleName());
		if(currentIgnoringElement == null && currentIgnoreList.contains(qName.toLowerCase())){
			System.out.println("Ignoring element " + qName);
			this.currentIgnoringElement = qName.toLowerCase();
			return;
		}
		
		
		System.out.println("Start element " + qName);
		if(this.firstElement){
			firstElement = false;
			PrestaShopElement element = this.clazz.getAnnotation(PrestaShopElement.class);
			System.out.println("Class element name: " + element.name());
			if(!element.name().equals(qName)){
				this.fatalError(new SAXParseException("Class element does not match with XML document", null));
				return;
			}
			this.fillAttributes(this.clazz, this.heap.get(0), attributes);
		}else{
			// we are in an element that can be or not another object.
			// we must to check for it.  To do this, we find the field into the current object
			// and iterate
			Class<?> currentClass = this.heap.get(this.heap.size()-1).getClass();
			System.out.println("Check for element");
			Field elementField = this.getFieldElementFor(currentClass, qName);
			System.out.println("field for "+qName);
			if(elementField == null){
				System.out.println("null element");	
				return;
			}
			if(elementField.getType().isPrimitive() || elementField.getType().getSimpleName().equalsIgnoreCase("string")
					|| elementField.getType().getSimpleName().equalsIgnoreCase("bigdecimal")){
				//Object currentObj = this.heap.get(this.heap.size()-1);
				//elementField.setAccessible(true);
				//elementField.set(currentObj, );
				//elementField.setAccessible(false);
			}else{
				try {
					Class<?> newClass = elementField.getType();
					// avoid Lists
					
					if(newClass.isAssignableFrom(List.class) && elementField.isAnnotationPresent(PrestaShopList.class)){			
						Class<?> listClass = elementField.getAnnotation(PrestaShopList.class).type(); 
						System.out.println("\t\tCreating new object for " + listClass.getSimpleName());
						Object currentObject = listClass.newInstance();
						this.fillAttributes(listClass, currentObject, attributes);
						this.heap.add(currentObject);
						this.addIgnoreForClass(listClass);
					}else{
						System.out.println("Creating new object for " + newClass.getName());
						Object currentObject;
						
						currentObject = newClass.newInstance();
						this.fillAttributes(newClass, currentObject, attributes);
						this.heap.add(currentObject);
						this.addIgnoreForClass(newClass);
					}
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		}
		
	}

}
