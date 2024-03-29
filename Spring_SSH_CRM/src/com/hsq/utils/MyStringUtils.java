package com.hsq.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyStringUtils {
	
	/**
	 * 获得md5加密后的数据
	 * @param value 明文
	 * @return 密文
	 */
	public static String getMD5Value(String value){
		
		try {
			//1 获得jdk提供消息摘要算法工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2 加密的结果10进制
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3将10进制 转换16进制
//			System.out.println(Arrays.toString(md5ValueByteArray));
			BigInteger bigInteger = new BigInteger(1 , md5ValueByteArray);
			
			
			return bigInteger.toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
			//如果出现了异常，将默认值
			//return value;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getMD5Value("1234"));
	}

}
