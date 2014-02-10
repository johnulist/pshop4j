/**
 * 
 */
package com.edgaragg.pshop4j.modeling.enums;

/**
 * @author Edgar Gonzalez
 *
 */
public enum PShopFormat {
	// value formats
	isBool,
	isFloat,
	isUnsignedFloat,
	isInt,
	isUnsignedInt,
	isNullOrUnsignedId,
	isSerializedArray("a:[0-9]+:{.*;}$"),
	isString,
	isUnsignedId,
	isDate,
	// Specific value types
	isBirthDate("^([0-9]{4})-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2][0-9])|(3[01]))( [0-9]{2}:[0-9]{2}:[0-9]{2})?$"),
	isCleanHtml,
	isColor("^(#[0-9a-fA-F]{6}|[a-zA-Z0-9-]*)$"),
	isEmail("^[a-z0-9!#$%&\\'*+\\/=?^`{}|~_-]+[.a-z0-9!#$%&\'*+\\/=?^`{}|~_-]*@[a-z0-9]+[._a-z0-9-]*\\.[a-z0-9]+$"),
	isImageSize("^[0-9]{1,4}$"),
	isLanguageCode("^[a-zA-Z]{2}(-[a-zA-Z]{2})?$"),
	isLanguageIsoCode("^[a-zA-Z]{2,3}$"),
	isLinkRewrite("^[_a-zA-Z0-9-]+$"),
	isMd5("^[a-f0-9A-F]{32}$"),
	isNumericIsoCode("^[0-9]{2,3}$"),
	isPasswd("^[.a-zA-Z_0-9-!@#$%\\^&*()]{5,32}$"),
	isPasswdAdmin("^[.a-zA-Z_0-9-!@#$%\\^&*()]{8,32}$"),
	isPhpDateFormat("^[^<>]+$"),
	isPriceDisplayMethod,
	isReference("^[^<>;={}]*$"),
	isUrl("^[~:#,%&_=\\(\\)\\.\\? \\+\\-@\\/a-zA-Z0-9]+$"),
	// Names
	isCatalogName("^[^<>;=#{}]*$"),
	isCarrierName("^[^<>;=#{}]*$"),
	isConfigName("^[a-zA-Z_0-9-]+$"),
	isGenericName("^[^<>;=#{}]*$"),
	isImageTypeName("^[a-zA-Z0-9_ -]+$"),
	isName("^[^0-9!<>,;?=+()@#\"°{}_$%:]*$"),
	isTplName("^[a-zA-Z0-9_-]+$"),
	isSiret,
	isApe,
	// Location
	isAddress("^[^!<>?=+@{}_$%]*$"),
	isCityName("^[^!<>;?=+@#\"°{}_$%]*$"),
	isCoordinate("^\\-?[0-9]{1,8}\\.[0-9]{1,8}$"),
	isMessage("[<>{}]"),
	isPhoneNumber("^[+0-9. ()-]*$"),
	isPostCode("^[a-zA-Z 0-9-]+$"),
	isStateIsoCode("^[a-zA-Z0-9]{2,3}((-)[a-zA-Z0-9]{1,3})?$"),
	isZipCodeFormat("^[NLCnlc -]+$"),
	//Products
	isAbsoluteUrl("^https?:\\/\\/[:#%&_=\\(\\)\\.\\? \\+\\-@\\/a-zA-Z0-9]+$"),
	isDniLite("^[0-9A-Za-z-.]{1,16}$"),
	isEan13("^[0-9]{0,13}$"),
	isPrice,
	isProductVisibility("^both|catalog|search|none$"),
	isUpc("^[0-9]{0,12}$");/*,
	// PShop4J custom formats
	isList,
	isEntity,
	isStoreDescription;*/
	
	
	
	
	private String regex;
	
	PShopFormat(){
		this.regex = "";
	}
	
	PShopFormat(String regex){
		this.regex = regex;
	}
	
	public String getRegex(){
		return this.regex;
	}
}
