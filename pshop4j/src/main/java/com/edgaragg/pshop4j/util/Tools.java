/**
 * 
 */
package com.edgaragg.pshop4j.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Edgar Gonzalez
 *
 */
public class Tools {

	public static String encrypt(String textToEncrypt){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(textToEncrypt.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(Integer.toHexString(0x100 | (b & 0xff)).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
