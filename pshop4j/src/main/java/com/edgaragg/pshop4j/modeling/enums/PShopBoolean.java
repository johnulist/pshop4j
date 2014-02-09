package com.edgaragg.pshop4j.modeling.enums;

import java.util.HashMap;
import java.util.Map;

public enum PShopBoolean implements PShopIntegerEnum{
	FALSE,
	TRUE;
	
	private static final Map<Integer, PShopBoolean> typesByValue = new HashMap<Integer, PShopBoolean>();

    static {
        for (PShopBoolean type : PShopBoolean.values()) {
            typesByValue.put(type.ordinal(), type);
        }
    }
    
    public static PShopBoolean fromInt(int i){
    	return typesByValue.get(i);
    }

}
