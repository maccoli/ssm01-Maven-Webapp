package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Restaurant;

public interface RestaurantService {
	/**
	 * 获取乡村的所有餐馆
	 * @return
	 */
	public List<Restaurant> getCountryRestaurant(CountryWithBLOBs countryWithBLOBs);
	
	public Restaurant getRestDetail(Integer id);
	
	int insert(Restaurant record);
}
