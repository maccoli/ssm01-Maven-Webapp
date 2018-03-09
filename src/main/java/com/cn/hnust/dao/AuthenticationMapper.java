package com.cn.hnust.dao;

import com.cn.hnust.pojo.Authentication;

public interface AuthenticationMapper {

	public void addAutn(Authentication authentication);
	
	public Authentication getAuth(Integer userid);
}
