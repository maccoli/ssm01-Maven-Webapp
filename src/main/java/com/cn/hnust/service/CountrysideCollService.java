package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountrysideColl;
import com.cn.hnust.pojo.User;

public interface CountrysideCollService {
	/**
	 * 获取用户的所有收藏乡村
	 * @param user
	 * @return
	 */
	public List<CountrysideColl> getUserColl(User user);
	
	/**
	 * 取消收藏指定ID的的乡村
	 * @param integer
	 * @return
	 */
	public int cancelColl(Integer integer);
	/**
	 * 新增收藏
	 * @param coll
	 * @return
	 */
	public int newColl(CountrysideColl coll);
	

}
