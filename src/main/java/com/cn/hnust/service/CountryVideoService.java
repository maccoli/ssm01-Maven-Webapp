package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryVideo;

public interface CountryVideoService {
	/**
	 * ��ȡһ����������չʾ��Ƶ
	 * @param country
	 * @return
	 */
	public List<CountryVideo> getcountrysideVideos(Country country);
	
	public int newVideos(CountryVideo video);
}
