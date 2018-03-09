package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.CountryMapper;
import com.cn.hnust.dao.HotelMapper;
import com.cn.hnust.dao.RestaurantMapper;
import com.cn.hnust.dao.ScenicSpotMapper;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.DeleteSRHService;

@Service("deleteSRHService")
public class DeleteSRHServiceImpl implements DeleteSRHService {

	@Resource
	private HotelMapper hotelMapper;
	
	@Resource
	private CountryMapper countryMapper;
	
	@Resource
	private ScenicSpotMapper scenicSpotMapper;
	
	@Resource
	private RestaurantMapper restaurantMapper;
	
	@Transactional
	public void delHotel(Integer id, CountryWithBLOBs country2) {
		Integer idhotel = id;
		int dh = hotelMapper.deleteByPrimaryKey(idhotel);
	  if(dh == 1)	{
		countryMapper.updateHotels(country2);
		}
	}
	
	@Override
	public Hotel delHotelfile(Integer id) {
		Integer idhotel = id;
		return this.hotelMapper.selectByPrimaryKey(idhotel);
	   
		
	}

	@Override
	public void delScenicspot(Integer id, CountryWithBLOBs country2) {
		Integer scenicspotid = id;
		int ds = scenicSpotMapper.deleteByPrimaryKey(scenicspotid);
	  if(ds == 1)	{
		countryMapper.updateSights(country2);
		}
		
	}

	@Override
	public ScenicSpot delScenicspotfile(Integer id) {
		Integer scenicspotid = id;
		return this.scenicSpotMapper.selectByPrimaryKey(scenicspotid);
	}

	@Override
	public void delRestaurant(Integer id, CountryWithBLOBs country2) {
		Integer restaurantid = id;
		int dr =  restaurantMapper.deleteByPrimaryKey(restaurantid);
		if(dr == 1){
			countryMapper.updateRestaurants(country2);
		}
		
	}

	@Override
	public Restaurant delRestaurantfile(Integer id) {
		Integer restaurantid = id;
		return this.restaurantMapper.selectByPrimaryKey(restaurantid);
	}
     
}
