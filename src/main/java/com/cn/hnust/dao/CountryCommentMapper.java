package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.CountryComment;
import com.cn.hnust.pojo.CountryWithBLOBs;

public interface CountryCommentMapper {
    int deleteByPrimaryKey(Integer idcountrycomment);
    
    int deleteBycountry_id(Integer countrysideId);

    int insert(CountryComment record);

    int insertSelective(CountryComment record);

    CountryComment selectByPrimaryKey(Integer idcountrycomment);

    int updateByPrimaryKeySelective(CountryComment record);

    int updateByPrimaryKeyWithBLOBs(CountryComment record);

    int updateByPrimaryKey(CountryComment record);
    
    List<CountryComment> getCountryComments(CountryWithBLOBs countryWithBLOBs);
    
}