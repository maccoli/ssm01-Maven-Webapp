package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface DBRService {
	
	/**
	 * 
	 * @return
	 */
	public List<User> getInfo();
	
	/**
	 * 注册时个性化推荐
	 * @return
	 */
	public List<User> getinfow(User user);
}
