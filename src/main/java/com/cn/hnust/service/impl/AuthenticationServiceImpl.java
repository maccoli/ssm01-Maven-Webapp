package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.AuthenticationMapper;
import com.cn.hnust.pojo.Authentication;
import com.cn.hnust.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource
	private AuthenticationMapper authenticationMapper;
	
	@Override
	public void addAutn(Authentication authentication) {
		
		 this.authenticationMapper.addAutn(authentication);
	}

	@Override
	public Authentication getAuthenticationInfo(Integer integer) {
		// TODO Auto-generated method stub
		return 	this.authenticationMapper.getAuth(integer);
	}

}
