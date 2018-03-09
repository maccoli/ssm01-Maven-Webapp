package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.BackStageMapper;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.AddExamineService;

@Service("addExamineService")
public class AddExamineServiceImpl implements AddExamineService {

	@Resource
	private BackStageMapper backStageMapper;
	
	@Override
	public List<Country> getCountryInExamine() {
	
		return this.backStageMapper.getCountryInExamine();
	}

	@Override
	public List<Restaurant> getRestaurantInExamine() {
		
		return this.backStageMapper.getRestaurantInExamine();
	}

	@Override
	public List<ScenicSpot> getScenicspotInExamine() {
		
		return this.backStageMapper.getScenicspotInExamine();
	}

	@Override
	public List<Hotel> getHotelInExamine() {
		
		return this.backStageMapper.getHotelInExamine();
	}

	@Override
	public Integer updateCountryInExamine(Country country) {
	
		return this.backStageMapper.updateCountryInExamine(country);
	}

	@Override
	public Integer updateRestaurantInExamine(Restaurant restaurant) {
		
		return this.backStageMapper.updateRestaurantInExamine(restaurant);
	}

	@Override
	public Integer updateScenicspotInExamine(ScenicSpot scenicspot) {
		
		return this.backStageMapper.updateScenicspotInExamine(scenicspot);
	}

	@Override
	public Integer updateHotelInExamine(Hotel hotel) {
		
		return this.backStageMapper.updateHotelInExamine(hotel);
	}

}
