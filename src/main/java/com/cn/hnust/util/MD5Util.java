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
					//digest����,����
			byte[]buf = md.digest(origStr.getBytes());
			//Ϊ�˷���ʹ��,����ת����һ���ַ���
			BASE64Encoder encode =
				new BASE64Encoder();
			String str = encode.encode(buf);
						
			return str;
	}
		
}
