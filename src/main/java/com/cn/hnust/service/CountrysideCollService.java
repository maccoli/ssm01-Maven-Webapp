package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountrysideColl;
import com.cn.hnust.pojo.User;

public interface CountrysideCollService {
	/**
	 * ��ȡ�û��������ղ����
	 * @param user
	 * @return
	 */
	public List<CountrysideColl> getUserColl(User user);
	
	/**
	 * ȡ���ղ�ָ��ID�ĵ����
	 * @param integer
	 * @return
	 */
	public int cancelColl(Integer integer);
	/**
	 * �����ղ�
	 * @param coll
	 * @return
	 */
	public int newColl(CountrysideColl coll);
	

}
