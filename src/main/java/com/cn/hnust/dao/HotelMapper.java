package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Hotel;

public interface HotelMapper {
    int deleteByPrimaryKey(Integer idhotel);
    
    int deleteByCountrysideId(Integer countrysideId);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    Hotel selectByPrimaryKey(Integer idhotel);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKeyWithBLOBs(Hotel record);

    int updateByPrimaryKey(Hotel record);
    
    List<Hotel> getCountryHotels(CountryWithBLOBs countryWithBLOBs);
}