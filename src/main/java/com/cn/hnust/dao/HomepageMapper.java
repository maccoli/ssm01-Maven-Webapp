package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;

public interface HomepageMapper {

	public List<Country> showCountryInHome(Integer id);
	
	public List<Country> showCountrysInhome();
	
	public List<Restaurant> showRestaurantInHome();
	
	public List<ScenicSpot> showScenicspotInHome();
	
	public List<Hotel> showHotelInHome();
	
	List<Integer> showHotCountryByColl();
	
	List<Article> showHotArticleByColl();
	
	List<Country> showHotCountry(List<Integer> cid);
	
	
}
