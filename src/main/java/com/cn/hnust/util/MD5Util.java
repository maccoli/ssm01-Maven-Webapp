package com.cn.hnust.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String encrypt(String origStr)throws
	NoSuchAlgorithmException{
		if(origStr==null){
			return "";
		}
			MessageDigest md=
				MessageDigest.getInstance("md5");
					//digest方法,加密
			byte[]buf = md.digest(origStr.getBytes());
			//为了方便使用,将其转换成一个字符串
			BASE64Encoder encode =
				new BASE64Encoder();
			String str = encode.encode(buf);
						
			return str;
	}
		
}
