package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CountryVideoMapper;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryVideo;
import com.cn.hnust.service.CountryVideoService;
@Service("countryVideoService")
public class CountryVideoServiceImpl implements CountryVideoService {

	@Resource
	private CountryVideoMapper countryVideoMapper;
	
	@Override
	public List<CountryVideo> getcountrysideVideos(Country country) {
		// TODO Auto-generated method stub
		List<CountryVideo> videos = this.countryVideoMapper.getCountrysideVideos(country);
		return videos;
	}

	@Override
	public int newVideos(CountryVideo video) {
		// TODO Auto-generated method stub
		return this.countryVideoMapper.insertSelective(video);
	}
}
