/**
 * 
 */
package com.edgaragg.pshop4j.pojos.storedesc;

import java.util.ArrayList;
import java.util.List;

import com.edgaragg.pshop4j.modeling.annotations.PrestaShopAttribute;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopElement;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopList;
import com.edgaragg.pshop4j.modeling.annotations.PrestaShopText;

/**
 * @author Edgar Gonzalez
 *
 */
@PrestaShopElement("customers")
public class StoreDescriptionItem {

	@PrestaShopAttribute("xlink:href")
	private String endPoint;
	@PrestaShopAttribute("get")
	private boolean get;
	@PrestaShopAttribute("put")
	private boolean put;
	@PrestaShopAttribute("post")
	private boolean post;
	@PrestaShopAttribute("delete")
	private boolean delete;
	@PrestaShopAttribute("head")
	private boolean head;
	@PrestaShopText("description")
	private String description;
	@PrestaShopElement("schema")
	@PrestaShopList(Schema.class)
	private List<Schema> schemas;
	
	/**
	 * 
	 */
	public StoreDescriptionItem() {
		this.schemas = new ArrayList<Schema>();
	}
	
	
	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}


	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * @return the get
	 */
	public boolean isGet() {
		return get;
	}

	/**
	 * @param get the get to set
	 */
	public void setGet(boolean get) {
		this.get = get;
	}

	/**
	 * @return the put
	 */
	public boolean isPut() {
		return put;
	}

	/**
	 * @param put the put to set
	 */
	public void setPut(boolean put) {
		this.put = put;
	}

	/**
	 * @return the post
	 */
	public boolean isPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(boolean post) {
		this.post = post;
	}

	/**
	 * @return the delete
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	/**
	 * @return the head
	 */
	public boolean isHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(boolean head) {
		this.head = head;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the schemas
	 */
	public List<Schema> getSchemas() {
		return schemas;
	}


	/**
	 * @param schemas the schemas to set
	 */
	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}

	

}
