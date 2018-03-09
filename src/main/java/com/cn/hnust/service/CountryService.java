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
	 * ��ȡһ���û���������������
	 * @param session
	 * @return
	 */
	public List<CountryWithBLOBs> getUserCountrysides(HttpSession session);
	
	/**
	 * ���������ȡ���
	 * @param type
	 * @return
	 */
	public List<CountryWithBLOBs> getCountrysByType(String type,Integer page,String content);
	
	/**
	 * ��ҳ��ȡ
	 * @param page
	 * @return
	 */
	public List<CountryWithBLOBs> getAllCountry(Integer page);
	
	/**
	 * ��������
	 * @param bloBs
	 * @return
	 */
	public int newCountry(CountryWithBLOBs bloBs);
	
	/**
	 * �޸������Ϣ
	 * @param bloBs
	 * @return
	 */
	public int changeInfo(CountryWithBLOBs bloBs);
	
	/**
	 * ɾ����弰�������Ϣ
	 * @param id
	 * @return
	 */
	public int deleteCountry(int id);
	
	public List<String> getAllCountrysideNames();
	
	public CountryWithBLOBs getByName(String name);
}
