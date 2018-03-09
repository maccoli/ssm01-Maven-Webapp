package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.RestaurantMapper;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.service.RestaurantService;

@Service(value = "/restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Resource
	private RestaurantMapper restaurantMapper;

	@Override
	public List<Restaurant> getCountryRestaurant(CountryWithBLOBs countryWithBLOBs) {
		// TODO Auto-generated method stub
		List<Restaurant> list = this.restaurantMapper.getCountryRestaurants(countryWithBLOBs);
		return list;
	}

	@Override
	public Restaurant getRestDetail(Integer id) {
		// TODO Auto-generated method stub
		Restaurant restaurant = new Restaurant();
		restaurant = this.restaurantMapper.selectByPrimaryKey(id);
		return restaurant;
	}

	public int insert(Restaurant record) {

		return restaurantMapper.insert(record);
	}
}
