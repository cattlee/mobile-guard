package com.itheima62.mobileguard.utils;

public class EncryptTools {
	/**
	 * @param seed
	 *      ���ܵ�����
	 * @param str
	 *      Ҫ���ܵ��ַ���
	 * @return
	 */
	public static String encrypt(int seed,String str){
		byte[] bytes = str.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] ^= seed;//���ֽڼ���
		}
		return new String(bytes);
	}
	
	/**
	 * @param seed
	 *     ���ܵ�����
	 * @param str
	 * @return
	 */
	public static String decryption(int seed,String str){
		byte[] bytes = str.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] ^= seed;//���ֽڼ���
		}
		return new String(bytes);
	}
}
