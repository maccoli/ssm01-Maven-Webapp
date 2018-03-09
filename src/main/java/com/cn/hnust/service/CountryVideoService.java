package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryVideo;

public interface CountryVideoService {
	/**
	 * 获取一个乡村的所有展示视频
	 * @param country
	 * @return
	 */
	public List<CountryVideo> getcountrysideVideos(Country country);
	
	public int newVideos(CountryVideo video);
}
