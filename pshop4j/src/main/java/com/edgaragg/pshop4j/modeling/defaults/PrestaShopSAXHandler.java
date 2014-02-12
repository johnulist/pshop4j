/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAssociationMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElementMapping;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.enums.PShopIntegerEnum;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.PrestaShopPojoList;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.util.Tools;

/**
 * @author Edgar Gonzalez
 * @param <T>
 *
 */
public class PrestaShopSAXHandler extends DefaultHandler {
	
	/**
	 * @param <T>
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public <T extends PrestaShopPojo> PrestaShopSAXHandler(Class<T> clazz) {
		this.clazz = clazz;
		this.heap = new Vector<SAXObjectDescription>();
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz){
		return (T) this.heap.get(0).getPojo();
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(PRESTASHOP.equals(qName)) return;
		//System.out.println("-> start " + qName);
		SAXObjectDescription desc = getLastObjectDescription(); 
		if(desc.isIgnoring()){
			return;
		}
		if(desc.checkForIgnorableElement(qName)){
			desc.setIgnore(qName);
			return;
		}
		// if the heap is empty, we are in the first element of the docuemnt
		if(this.heap.isEmpty()){
			createFirstElement(qName, attributes);
		}else{
			createPojoFromElement(qName, attributes);
		}
		
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
		SAXObjectDescription desc = getLastObjectDescription();
		if(desc.isIgnoringElement(qName)){
			desc.setIgnore(null);
			return;
		}
		
				
		if(desc.isIgnoring()) return;
		// first of all, we assign the text attribute if exists
		this.assignTextValue(qName);
		
		if(this.heap.size() > 1){
			PrestaShopPojo lastElement = getLastObjectDescription().getPojo();
			SAXObjectDescription ownerDesc = this.heap.get(this.heap.size() - 2); 
			PrestaShopPojo owner = ownerDesc.getPojo();
			// look into the owner object the field for the last element
			Field field = Tools.getFieldForElement(owner.getClass(), qName);
		
			if(ownerDesc.isAssociationList()){
				Associations associations = (Associations)ownerDesc.getPojo();
				associations.addAssociation((PrestaShopPojoList<?>)lastElement);
				this.heap.removeElementAt(this.heap.size()-1);
				return;
			}
			
			if(field == null || field.getType().isPrimitive() || field.getType().isEnum() || ALLOWED_CLASSES.contains(field.getType().getSimpleName().toLowerCase())){
				return;
			}
			
			//System.out.printf("End element %s (%s -> %s)\n", qName, lastElement.getClass().getSimpleName(), owner.getClass().getSimpleName());
			// checking if the field is a list
			if(field.getType().isAssignableFrom(List.class)){
				field.setAccessible(true);
				try {
					@SuppressWarnings("unchecked")
					List<PrestaShopPojo> innerList =  (List<PrestaShopPojo>) field.get(owner);
					innerList.add(lastElement);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				field.setAccessible(false);
			}else{
				field.setAccessible(true);
				try {
					field.set(owner, lastElement);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				field.setAccessible(false);
			}
			// remove last element
			this.heap.removeElementAt(this.heap.size()-1);
		}
	}

	
	
	/**
	 * 
	 * @param o
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T> T cast(String o, Class<T> clazz){
		Object instance = null;
		switch(clazz.getSimpleName().toLowerCase()){
		case "string":
			return (T) (o == null ? "" : o);
		case "bigdecimal":
			return (T) new BigDecimal(o == null ? "0" : o);
		case "boolean":
			return (T) new Boolean(o == null ? "false" : o);
		case "long":
			return (T) new Long(o == null ? "0" : o);
		case "short":
			return (T) new Short(o == null ? "0" : o);
		case "int":
			return (T) new Integer(o == null ? "0" : o);
		case "date":{
			if(o == null) return null;
			String trimmedData = o.trim();
			if(trimmedData.equals("")) return null;
			try {
				return (T) (trimmedData.length() == 10 ? BIRTHDAY_FORMAT : DATE_FORMAT).parse(o); 
			} catch (ParseException e) {
				return null;
			}
		}
		default:
			if(clazz.isEnum()){
				if(PShopIntegerEnum.class.isAssignableFrom(clazz)){
					return (T) Tools.intToPShopIntegerEnum(clazz, Integer.parseInt(o));
				}else{
					return (T) Enum.valueOf((Class<Enum>)clazz, o);
				}
			}		
		}
		
		

		
		
		
		return (T) instance;
	}

	
	

	
	/**
	 * 
	 * @param clazz
	 * @param currentObj
	 * @param attributes
	 */
	protected <T> void fillAttributes(Class<T> clazz, Object currentObj, Attributes attributes){
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			PrestaShopAttribute fieldAttribute = field.getAnnotation(PrestaShopAttribute.class);
			if(fieldAttribute != null){
				String attrValue = attributes.getValue("", fieldAttribute.value());
				//if(attrValue == null) continue;
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
	
	
	/**
	 * @param qName
	 */
	private void assignTextValue(String qName) {
		PrestaShopPojo textElement = getLastObjectDescription().getPojo();
		Field field = Tools.getFieldForElement(textElement.getClass(), qName);
		
		if(field != null){
			field.setAccessible(true);
			try {
				field.set(textElement, this.cast((text.trim().length() > 0) ? text.trim() : null, field.getType()));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			field.setAccessible(false);
		}
	}

	/**
	 * @param qName
	 * @param attributes
	 */
	private void createPojoFromElement(String qName, Attributes attributes) {
		// we are in an element that can be or not another pojo.
		// we must to check for it.  To do this, we find the field into the current object
		// and iterate
		SAXObjectDescription desc = this.getLastObjectDescription();
		Class<?> currentClass = desc.getPojo().getClass();
		Field elementField = Tools.getFieldForElement(currentClass, qName);
		if(elementField == null){
			if(desc.isAssociationList()){
				// we don't have the element defined in our class, but we have this info
				// in the PrestaShopAssociationMapping annotation, we get it and search for
				// the corresponding element
				// first we got the top parent object class
				SAXObjectDescription parentDesc = this.heap.get(this.heap.indexOf(desc)-1);
				// now, we find the association mapping for the parent element
				PrestaShopAssociationMapping mapping = parentDesc.getPojo().getClass().getAnnotation(PrestaShopAssociationMapping.class);
				// we found an association mapping, now search for the class corresponding to this element
				if(mapping != null){
					for(PrestaShopElementMapping elementMap : mapping.value()){
						if(elementMap.element().equals(qName)){
							Class<?> associatedClass = elementMap.type();
							// Now we have the class, create an instance and store it into the heap
							try {
								PrestaShopPojo currentObject = (PrestaShopPojo)associatedClass.newInstance();
								this.fillAttributes(associatedClass, currentObject, attributes);
								this.addToHeap(currentObject);
							} catch (InstantiationException | IllegalAccessException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			return;
		}
		// checking if the field is not a primitive or an allowed class
		// if it is a primitive or an allowed class, we do nothing because the content is on the element text
		// we don't seek in attributes in this case
		if(!elementField.getType().isPrimitive() && !elementField.getType().isEnum() && !ALLOWED_CLASSES.contains(elementField.getType().getSimpleName().toLowerCase())){
			try {
				// get the element type
				Class<?> newClass = elementField.getType();
				
				// check if the type is a list and it has the associated type
				if(newClass.isAssignableFrom(List.class) && elementField.isAnnotationPresent(PrestaShopList.class)){
					// if it is the case, create a new pojo of this type, fill its attributes and add it to the heap
					// in order to seek for childrens
					Class<?> listClass = elementField.getAnnotation(PrestaShopList.class).value(); 
					PrestaShopPojo currentObject = (PrestaShopPojo)listClass.newInstance();
					this.fillAttributes(listClass, currentObject, attributes);
					this.addToHeap(currentObject);
				}else{
					// It is a entity object (not a list), now, we fill its attributes and add into the heap
					PrestaShopPojo currentObject = (PrestaShopPojo)newClass.newInstance();
					this.fillAttributes(newClass, currentObject, attributes);	
					this.addToHeap(currentObject);
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
				
		}
	}

	/**
	 * @return
	 */
	private SAXObjectDescription getLastObjectDescription() {
		return this.heap.isEmpty() ? SAXObjectDescription.EMPTY_DESCRIPTION : this.heap.get(this.heap.size()-1);
	}

	/**
	 * @param qName
	 * @param attributes
	 * @throws SAXException
	 */
	private void createFirstElement(String qName, Attributes attributes)
			throws SAXException {
		PrestaShopElement element = this.clazz.getAnnotation(PrestaShopElement.class);
		if(!element.value().equals(qName)){
			this.fatalError(new SAXParseException("Class element does not match with XML document", null));
			return;
		}
		try {
			this.addToHeap((PrestaShopPojo)this.clazz.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.fillAttributes(this.clazz, this.heap.get(0), attributes);
	}
	
	/**
	 * 
	 * @param pojo
	 */
	private void addToHeap(PrestaShopPojo pojo){
		//SAXObjectDescription desc = new SAXObjectDescription(pojo);
		this.heap.add(new SAXObjectDescription(pojo));
	}

	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat BIRTHDAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final List<String> ALLOWED_CLASSES = Arrays.asList("string", "bigdecimal", "date");
	private static final String PRESTASHOP = "prestashop";
	private Class<?> clazz;
	private String text;
	private Vector<SAXObjectDescription> heap;
	
}
