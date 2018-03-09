package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.ScenicSpot;

public interface ScenicSpotMapper {
    int deleteByPrimaryKey(Integer scenicspotid);
    
    int deleteBycountrysideId(Integer countrysideId);

    int insert(ScenicSpot record);

    int insertSelective(ScenicSpot record);

    ScenicSpot selectByPrimaryKey(Integer scenicspotid);

    int updateByPrimaryKeySelective(ScenicSpot record);

    int updateByPrimaryKeyWithBLOBs(ScenicSpot record);

    int updateByPrimaryKey(ScenicSpot record);
    
    List<ScenicSpot> getCountrysideSopts(CountryWithBLOBs country);
    
    List<String> getAllSpotNames();
    
    List<ScenicSpot> getSpotsByTag1(Map<String, Object> map);
    
    List<ScenicSpot> getSpotsByTag2(Map<String, Object> map);
    
}