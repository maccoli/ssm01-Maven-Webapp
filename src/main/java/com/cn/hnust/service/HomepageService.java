package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;

public interface HomepageService {
    //one
	public List<Country> showCountryInHome(Integer id);
	
	//two
	public List<Country> showCountrysInhome();
	
	public List<Restaurant> showRestaurantInHome();
	
	public List<ScenicSpot> showScenicspotInHome();
	
	public List<Hotel> showHotelInHome();
	
	//three
	List<Integer> showHotCountryByColl();
	
	List<Country> showHotCountry(List<Integer> cid);
	
	List<Article> showHotArticleByColl();
	

}
