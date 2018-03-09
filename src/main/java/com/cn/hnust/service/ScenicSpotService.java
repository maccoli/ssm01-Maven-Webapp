package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.ScenicSpot;

public interface ScenicSpotService {
	/**
	 * 获取乡村的所有景点
	 * @return
	 */
	public List<ScenicSpot> getCountrysideSpots(CountryWithBLOBs country);
	
	public ScenicSpot getDetail(Integer id);
	
	public int changeInfo(ScenicSpot spot);
	
	public int newSopt(ScenicSpot spot);
	
	public List<String> getAllSpotNames();
	
	public List<ScenicSpot> getSpotsByTag1(String tag1);
	
	public List<ScenicSpot> getSpotsByTag2(String tag1);
	
	int insertScenicspot(ScenicSpot scenicspot);
}
