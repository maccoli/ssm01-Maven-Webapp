package com.cn.hnust.service;

import com.cn.hnust.pojo.Authentication;

public interface AuthenticationService {
	
	public void addAutn(Authentication authentication);
	
	public Authentication getAuthenticationInfo(Integer integer);
}
