package com.zmm.commonutils.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.Key;

public class DesDecode {

	/** 加密算法,可用 DES */
	public static final String ALGORITHM_DES = "DESede/ECB/PKCS5Padding";

	public static String encodeBase64(byte[] input) throws Exception {
		Class<?> clazz = Class
				.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("encode", byte[].class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, new Object[] { input });
		return (String) retObj;
	}

	public static byte[] decodeBase64(String input) throws Exception {
		Class<?> clazz = Class
				.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("decode", String.class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, input);
		return (byte[]) retObj;
	}

	public static String encryption(byte[] bytes, String keyStr) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			Key key = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(keyStr.getBytes("UTF-8")));
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return encodeBase64(cipher.doFinal(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decryption(String bytes, String keyStr) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			Key key = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(keyStr.getBytes("UTF-8")));
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(decodeBase64(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 3DES算法，加密
	 * 
	 * @param key 加密私钥，长度不能够小于8位
	 * @param data 待加密字符串
	 * @return 加密后的字节数组，一般结合Base64编码使用
	 */
	public static String encode(String key, String data) {
		try {
			return encryption(data.getBytes("UTF-8"), key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 3DES算法，解密
	 * 
	 * @param data 待解密字符串
	 * @param key 解密私钥，长度不能够小于8位
	 * @return 解密后的字节数组
	 */
	public static String decode(String key, String data) {
		byte[] result = decryption(data, key);
		try {
			return new String(result,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	 /**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String applyId = "6497";
		String res = encode("5D74DBF28ED0E3C43E29AD11", applyId);
		System.out.println("加密后:" + res);
		String ssss = decode("5D74DBF28ED0E3C43E29AD11", "m5h6NKE4/y0=");
		System.out.println("解密后:" + ssss);
	}

}
