package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.Specialty;

public interface AddExamineMapper {

	List<Country> showCountryInExamine(String name);
	
	List<Object> showCountryphotoInExamine(Integer cid);
	
	List<Object> showCountryvideoInExamine(Integer cid);
	
	List<Specialty> showCountryspecialtyInExamine(Integer cid);
	
	List<Restaurant> showRestaurantInExamine(String rname);
	
	List<ScenicSpot> showScenicspotInExamine(String sname);
	
	List<Hotel> showHotelInExamine(String hname);
}
