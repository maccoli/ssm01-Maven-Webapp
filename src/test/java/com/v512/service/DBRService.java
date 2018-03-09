package com.v512.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.UserService;
import com.cn.hnust.service.impl.UserServiceImpl;

public class DBRService {
	
	@Test
	public void test(){
		User user = new User();
		user.setUseremail("222");
		user.setUserpassword("222");
		
	}
}
