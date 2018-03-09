package com.cn.hnust.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cn.hnust.pojo.CountryWithBLOBs;

public interface CountryService {
	/**
	 * get one country by id
	 * @param id
	 * @return
	 */
	public CountryWithBLOBs getOneCountryById(int id);
	
	/**
	 * 获取一个用户管理的所有与乡村
	 * @param session
	 * @return
	 */
	public List<CountryWithBLOBs> getUserCountrysides(HttpSession session);
	
	/**
	 * 根据种类获取乡村
	 * @param type
	 * @return
	 */
	public List<CountryWithBLOBs> getCountrysByType(String type,Integer page,String content);
	
	/**
	 * 分页获取
	 * @param page
	 * @return
	 */
	public List<CountryWithBLOBs> getAllCountry(Integer page);
	
	/**
	 * 添加新乡村
	 * @param bloBs
	 * @return
	 */
	public int newCountry(CountryWithBLOBs bloBs);
	
	/**
	 * 修改乡村信息
	 * @param bloBs
	 * @return
	 */
	public int changeInfo(CountryWithBLOBs bloBs);
	
	/**
	 * 删除乡村及其相关信息
	 * @param id
	 * @return
	 */
	public int deleteCountry(int id);
	
	public List<String> getAllCountrysideNames();
	
	public CountryWithBLOBs getByName(String name);
}
