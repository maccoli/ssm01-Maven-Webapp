package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;

public interface AddExamineService {

	 List<Country> getCountryInExamine();
	 
	 List<Restaurant> getRestaurantInExamine();
	 
	 List<ScenicSpot> getScenicspotInExamine();
	 
	 List<Hotel> getHotelInExamine();
	 
	 Integer updateCountryInExamine(Country country);
	 
     Integer updateRestaurantInExamine(Restaurant restaurant);
	 
	 Integer updateScenicspotInExamine(ScenicSpot scenicspot);
	 
	 Integer updateHotelInExamine(Hotel hotel);
}
