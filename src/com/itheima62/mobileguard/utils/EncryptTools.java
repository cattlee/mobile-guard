package com.itheima62.mobileguard.utils;

public class EncryptTools {
	/**
	 * @param seed
	 *      加密的种子
	 * @param str
	 *      要加密的字符串
	 * @return
	 */
	public static String encrypt(int seed,String str){
		byte[] bytes = str.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] ^= seed;//对字节加密
		}
		return new String(bytes);
	}
	
	/**
	 * @param seed
	 *     解密的种子
	 * @param str
	 * @return
	 */
	public static String decryption(int seed,String str){
		byte[] bytes = str.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] ^= seed;//对字节加密
		}
		return new String(bytes);
	}
}
