package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.AddExamineMapper;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.Specialty;
import com.cn.hnust.service.ShowExamineService;

@Service("showExamineService")
public class ShowExamineServiceImpl implements ShowExamineService {

	@Resource
	private AddExamineMapper addExamineMapper;
	
	@Override
	public List<Country> showCountryInExamine(String name) {
		
		return this.addExamineMapper.showCountryInExamine(name);
	}

	@Override
	public List<Object> showCountryphotoInExamine(Integer cid) {
		
		return this.addExamineMapper.showCountryphotoInExamine(cid);
	}

	@Override
	public List<Object> showCountryvideoInExamine(Integer cid) {
		
		return this.addExamineMapper.showCountryvideoInExamine(cid);
	}

	@Override
	public List<Restaurant> showRestaurantInExamine(String rname) {
		
		return this.addExamineMapper.showRestaurantInExamine(rname);
	}

	@Override
	public List<ScenicSpot> showScenicspotInExamine(String sname) {
		
		return this.addExamineMapper.showScenicspotInExamine(sname);
	}

	@Override
	public List<Hotel> showHotelInExamine(String hname) {
		
		return this.addExamineMapper.showHotelInExamine(hname);
	}

	@Override
	public List<Specialty> showCountryspecialtyInExamine(Integer cid) {
		
		return this.addExamineMapper.showCountryspecialtyInExamine(cid);
	}

}
