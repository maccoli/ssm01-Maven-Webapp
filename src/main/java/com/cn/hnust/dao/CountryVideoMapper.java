package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryVideo;

public interface CountryVideoMapper {
    int deleteByPrimaryKey(Integer idcountryvideo);
    
    int deleteBycountrysideId(Integer countrysideId);

    int insert(CountryVideo record);

    int insertSelective(CountryVideo record);

    CountryVideo selectByPrimaryKey(Integer idcountryvideo);

    int updateByPrimaryKeySelective(CountryVideo record);

    int updateByPrimaryKey(CountryVideo record);
    
    List<CountryVideo> getCountrysideVideos(Country country);
}