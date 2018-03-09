package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CountrysideCollMapper;
import com.cn.hnust.pojo.CountrysideColl;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CountrysideCollService;
@Service("countrysideCollService")
public class CountrysideCollServiceImpl implements CountrysideCollService {
	@Resource
	private CountrysideCollMapper CountrysideCollMapper;
	@Override
	public List<CountrysideColl> getUserColl(User user) {
		// TODO Auto-generated method stub
		return this.CountrysideCollMapper.getUserColl(user);
	}
	@Override
	public int cancelColl(Integer integer) {
		// TODO Auto-generated method stub
		return this.CountrysideCollMapper.deleteByPrimaryKey(integer);
	}
	@Override
	public int newColl(CountrysideColl coll) {
		// TODO Auto-generated method stub
		return this.CountrysideCollMapper.insertSelective(coll);
	}

}
