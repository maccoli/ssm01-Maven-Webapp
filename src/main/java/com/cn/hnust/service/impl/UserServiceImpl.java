package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userDao;

	@Override
	public User getUserByPwd(User user) {
		// TODO Auto-generated method stub
		User data = this.userDao.selectByPwd(user);
		if (data != null) {
			if (data.getActive()==0) {
				return null;// 账号未激活
			} else {
				if (user.getUserpassword().equals(data.getUserpassword())) {
					return data; // 成功登陆
				} else {
					return null; // 密码不正确
				}
			}
		} else {
			return null; // 数据库没有此用户
		}
	}

	@Override
	public int changePwd(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		if (this.userDao.selectByEmail(user) != null) {
			return "邮箱已注册";
		} else if (this.userDao.selectByUsername(user) != null) {
			return "用户名已注册";
		} else if (this.userDao.insert(user) == 1) {
			return "注册成功";
		} else {
			return "注册失败";
		}
	}

	@Override
	public String userverificate(String keyval) {
		// TODO Auto-generated method stub
		User user = this.userDao.selectByKeyVal(keyval);
		if(user!=null){
			Byte a = 1;
			user.setActive(a);
			this.userDao.deleteKeyVal(user);
			this.userDao.updateActive(user);
			return "success";
		}else{
			return "failure";
		}
	}

	@Override
	public void changeVal(User user) {
		// TODO Auto-generated method stub
		this.userDao.deleteKeyVal(user);
	}

	@Override
	public User getUserByEmial(User user) {
		// TODO Auto-generated method stub
		return this.userDao.selectByEmail(user);
	}

	@Override
	public User changeUserInfo(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateByPrimaryKeySelective(user);
		user = this.userDao.selectByPrimaryKey(user.getUserid());
		return user;
	}
	
}