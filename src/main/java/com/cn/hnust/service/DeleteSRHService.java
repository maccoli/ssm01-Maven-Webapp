package com.cn.hnust.service;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;

public interface DeleteSRHService {

	public void delHotel(Integer id,CountryWithBLOBs country2);
	
	public Hotel delHotelfile(Integer id);
	
	public void delScenicspot(Integer id,CountryWithBLOBs country2);
	
	public ScenicSpot delScenicspotfile(Integer id);
	
	public void delRestaurant(Integer id,CountryWithBLOBs country2);
	
	public Restaurant delRestaurantfile(Integer id);
}
