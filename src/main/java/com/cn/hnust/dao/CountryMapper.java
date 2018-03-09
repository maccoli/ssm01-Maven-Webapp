package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.CountryWithBLOBs;

public interface CountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountryWithBLOBs record);
    
    int insertSelective(CountryWithBLOBs record);

    CountryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CountryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CountryWithBLOBs record);

    int updateByPrimaryKey(Country record);
	
    List<CountryWithBLOBs> getUserCountrysides(List<Integer> ids);
    
    List<CountryWithBLOBs> getCountrysByType(Map<String,Object> map);
    
    List<CountryWithBLOBs> getCountryByPage(Map<String,Object> map);
    
    List<CountryWithBLOBs> getCountrysByType2(Map<String,Object> map);
    
    List<String> getAllNames();
    
    int updateSights(CountryWithBLOBs country2);
    
    int updateHotels(CountryWithBLOBs country2);
    
    int updateRestaurants(CountryWithBLOBs country2);
    
    CountryWithBLOBs getByName(String name);
}