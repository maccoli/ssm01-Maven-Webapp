package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Hotel;

public interface HotelService {
	/**
	 * 获取一个乡村所有的住宿
	 * @param countryWithBLOBs
	 * @return
	 */
	public List<Hotel> getCountryHotels(CountryWithBLOBs countryWithBLOBs);
	
	
	public Hotel getHotelDetail(Integer id);
	
	public int insert(Hotel hotel);
}
