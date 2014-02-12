/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.edgaragg.pshop4j.modeling.PrestaShopXMLParser;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopSAXParser implements PrestaShopXMLParser {

	
	private SAXParserFactory factory;
	private SAXParser saxParser;
	
	
	/**
	 * 
	 */
	public PrestaShopSAXParser() {
		this.factory = SAXParserFactory.newInstance();
		try {
			this.saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.modeling.PrestaShopXMLParser#parse(java.lang.Class, java.io.InputStream)
	 */
	@Override
	public <T extends PrestaShopPojo> T parse(Class<T> clazz, InputStream stream) {
		try {
			PrestaShopSAXHandler handler = new PrestaShopSAXHandler(clazz);
			this.saxParser.parse(stream, handler);
			return handler.getObject(clazz);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.modeling.PrestaShopXMLParser#parseList(java.lang.Class, java.io.InputStream)
	 */
	@Override
	public <T extends PrestaShopPojo> List<T> parseList(Class<T> clazz,
			InputStream stream) {
		try {
			this.saxParser.parse(stream, new PrestaShopSAXHandler(clazz));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
