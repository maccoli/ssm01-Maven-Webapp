package com.cn.hnust.service;

import com.cn.hnust.pojo.User;  

public interface UserService {
    /**
     * get user by pwd
     * @param user
     * @return
     */
	public User getUserByPwd(User user);
    
	/**
	 * change user's pwd
	 * @param user
	 * @return
	 */
    public int changePwd(User user);
    
	/**
	 * user register
	 * @param user
	 * @return
	 */
    public String register(User user);
    
    /**
     * user's verificate
     * @param keyval
     * @return
     */
    public String userverificate(String keyval);
    
/*    public String updateUser(User user);
    */
    /**
     * change user's active
     * @param user
     */
    public void changeVal(User user);
    
    /**
     * 根据邮箱查找用户
     * @param user
     * @return
     */
    public User getUserByEmial(User user);
    
    /**
     * 修改用户信息
     * @param user
     */
    public User changeUserInfo(User user);
}