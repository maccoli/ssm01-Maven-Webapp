package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Restaurant;

public interface RestaurantMapper {
    int deleteByPrimaryKey(Integer restaurantid);
    
    int deleteByCountrysideId(Integer countrysideId);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    Restaurant selectByPrimaryKey(Integer restaurantid);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKeyWithBLOBs(Restaurant record);

    int updateByPrimaryKey(Restaurant record);
    
    List<Restaurant> getCountryRestaurants(CountryWithBLOBs countryWithBLOBs);
}