package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.HomepageMapper;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.HomepageService;

@Service("homepageService")
public class HomepageServiceImpl implements HomepageService {

	@Resource
	private HomepageMapper homepageMapper;
	
	@Override
	public List<Country> showCountryInHome(Integer id) {
		
		return homepageMapper.showCountryInHome(id);
	}

	@Override
	public List<Restaurant> showRestaurantInHome() {
		
		return homepageMapper.showRestaurantInHome();
	}

	@Override
	public List<ScenicSpot> showScenicspotInHome() {

		return homepageMapper.showScenicspotInHome();
	}

	@Override
	public List<Hotel> showHotelInHome() {

		return homepageMapper.showHotelInHome();
	}

	@Override
	public List<Country> showCountrysInhome() {

		return homepageMapper.showCountrysInhome();
	}

	@Override
	public List<Integer> showHotCountryByColl() {
		
		return homepageMapper.showHotCountryByColl();
	}

	@Override
	public List<Country> showHotCountry(List<Integer> cid) {
	
		return homepageMapper.showHotCountry(cid);
	}

	@Override
	public List<Article> showHotArticleByColl() {
		
		return homepageMapper.showHotArticleByColl();
	}

}
