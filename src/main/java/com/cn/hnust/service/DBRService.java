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
	 * ע��ʱ���Ի��Ƽ�
	 * @return
	 */
	public List<User> getinfow(User user);
}
