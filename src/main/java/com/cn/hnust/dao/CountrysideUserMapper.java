package com.cn.hnust.dao;

import com.cn.hnust.pojo.CountrysideUser;

public interface CountrysideUserMapper {
    int deleteByPrimaryKey(Integer idcountrysideuser);

    int insert(CountrysideUser record);

    int insertnewUser(CountrysideUser record);
    
    int insertSelective(CountrysideUser record);

    CountrysideUser selectByPrimaryKey(Integer idcountrysideuser);

    int updateByPrimaryKeySelective(CountrysideUser record);

    int updateByPrimaryKey(CountrysideUser record);
    
    CountrysideUser selectByName(String username);
    
    int selectCountByName(CountrysideUser user);
    
    int selectCountByPhone(CountrysideUser user);
    
    CountrysideUser selectByPhone(String phone);
}