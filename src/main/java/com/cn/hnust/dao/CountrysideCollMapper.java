package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.CountrysideColl;
import com.cn.hnust.pojo.User;

public interface CountrysideCollMapper {
    int deleteByPrimaryKey(Integer idcountrysidecoll);

    int insert(CountrysideColl record);

    int insertSelective(CountrysideColl record);

    CountrysideColl selectByPrimaryKey(Integer idcountrysidecoll);

    int updateByPrimaryKeySelective(CountrysideColl record);

    int updateByPrimaryKey(CountrysideColl record);
    
    List<CountrysideColl> getUserColl(User user);
    
}