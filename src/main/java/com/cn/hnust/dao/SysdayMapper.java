package com.cn.hnust.dao;

import com.cn.hnust.pojo.Sysday;

public interface SysdayMapper {
    int deleteByPrimaryKey(Integer idsysinfo);

    int insert(Sysday record);

    int insertSelective(Sysday record);

    Sysday selectByPrimaryKey(Integer idsysinfo);

    int updateByPrimaryKeySelective(Sysday record);

    int updateByPrimaryKey(Sysday record);
}