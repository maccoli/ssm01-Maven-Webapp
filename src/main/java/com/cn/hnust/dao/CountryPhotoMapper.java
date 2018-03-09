package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryPhoto;

public interface CountryPhotoMapper {
    int deleteByPrimaryKey(Integer idcountryphoto);
    
    int deleteBycountrysideId(Integer countrysideId);
    
    int insert(CountryPhoto record);

    int insertSelective(CountryPhoto record);

    CountryPhoto selectByPrimaryKey(Integer idcountryphoto);

    int updateByPrimaryKeySelective(CountryPhoto record);

    int updateByPrimaryKey(CountryPhoto record);
    
    List<CountryPhoto> getCountryPhotos(Country country);
}