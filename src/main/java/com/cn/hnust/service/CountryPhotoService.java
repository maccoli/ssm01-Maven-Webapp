package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryPhoto;

public interface CountryPhotoService {
	
	/**
	 * 获取一个乡村的所有照片
	 * @param country
	 * @return
	 */
	public List<CountryPhoto> getCountryPhotos(Country country);
	
	public int newPhotos(CountryPhoto photo);
}
