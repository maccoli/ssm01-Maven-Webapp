package com.cn.hnust.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.BackStageMapper;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.BackStageService;

@Service("backStageService")
public class BackStageServiceImpl implements BackStageService {

	@Resource
	private BackStageMapper backStageMapper;
	
	@Override
	public Integer getUsercollByCountry(Integer id) {

		return this.backStageMapper.getUsercollByCountry(id);
	}

	@Override
	public List<Country> getSRHByCountry(Integer id) {

		return this.backStageMapper.getSRHByCountry(id);
	}

	@Override
	public List<Restaurant> getRestaurantByCountry(Integer id) {
		
		return this.backStageMapper.getRestaurantByCountry(id);
	}

	@Override
	public List<ScenicSpot> getScenicspotByCountry(Integer id) {
	
		return this.backStageMapper.getScenicspotByCountry(id);
	}

	@Override
	public List<Hotel> getHotelByCountry(Integer id) {
	
		return this.backStageMapper.getHotelByCountry(id);
	}

	@Override
	public List<Integer> getScenicspotcollByUser(List<Object> sids) {
		if(sids.size()==0){
			return new LinkedList<Integer>();
		}
		return this.backStageMapper.getScenicspotcollByUser(sids);
	}

	@Override
	public List<Integer> getRestaurantcollByUser(List<Integer> rids) {
		if(rids.size()==0){
			return new LinkedList<Integer>();
		}
		return this.backStageMapper.getRestaurantcollByUser(rids);
	}

	@Override
	public List<Integer> getHotelcollByUser(List<Object> hids) {
		if(hids.size()==0){
			return new LinkedList<Integer>();
		}
		return this.backStageMapper.getHotelcollByUser(hids);
	}

}
