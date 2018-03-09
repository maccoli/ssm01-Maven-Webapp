package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByPwd(User userid);
    
    User selectByEmail(User user);
    
    User selectByUsername(User user);
    
    User selectByKeyVal(String keyVal);
    /**
     * 筛选所有用户
     * @return
     */
    List<User> selectAllUser();
    
    /**
     * 更新用户验证状态
     * @param record
     * @return
     */
    int updateActive(User record);
    /**
     * 删除keyval
     * @param record
     * @return
     */
    int deleteKeyVal(User record);
}