package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CountryPhotoMapper;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryPhoto;
import com.cn.hnust.service.CountryPhotoService;
@Service("countryPhotoService")
public class CountryPhotoServiceImpl implements CountryPhotoService {
	@Resource
	private CountryPhotoMapper countryPhotoMapper;
	
	@Override
	public List<CountryPhoto> getCountryPhotos(Country country) {
		// TODO Auto-generated method stub
		List<CountryPhoto>  photos= this.countryPhotoMapper.getCountryPhotos(country);
		return photos;
	}

	@Override
	public int newPhotos(CountryPhoto photo) {
		// TODO Auto-generated method stub
		return this.countryPhotoMapper.insertSelective(photo);
	}

}
