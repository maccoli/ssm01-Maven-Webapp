package com.v512.dao;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import com.cn.hnust.util.MD5Util;

public class Test {
	public static void main(String[] args) {
/*		Calendar calendar = Calendar.getInstance();
		try {
			String info = MD5Util.encrypt(calendar.toString());
			System.out.println(info);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(MD5Util.encrypt("111"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
