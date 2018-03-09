package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;

public interface BackStageService {

	public Integer getUsercollByCountry(Integer id);
	
	public List<Country> getSRHByCountry(Integer id);
	
	public List<Restaurant> getRestaurantByCountry(Integer id);
	
	public List<ScenicSpot> getScenicspotByCountry(Integer id);
	
	public List<Hotel> getHotelByCountry(Integer id);

	public List<Integer> getScenicspotcollByUser(List<Object> sids);
	
	public List<Integer> getRestaurantcollByUser(List<Integer> rids);
	    
	public List<Integer> getHotelcollByUser(List<Object> hids);
}
