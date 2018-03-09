package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.BackStageMapper;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.RecordUserService;

@Service("recordUserService")
public class RecordUserServiceImpl implements RecordUserService {

	@Resource
	private BackStageMapper backStageMapper;

	@Override
	public List<User> getRecordtimeByuser() {
		
		return this.backStageMapper.getRecordtimeByuser();
	}

	@Override
	public List<User> getUsernameByid(Integer userid) {
		
		return this.backStageMapper.getUsernameByid(userid);
	}

	@Override
	public Integer getCollByUserid(Integer userid) {
		
		return this.backStageMapper.getCollByUserid(userid);
	}

	@Override
	public List<ScenicSpot> getScenicspotBysid(Integer scenicspotid) {
		
		return this.backStageMapper.getScenicspotBysid(scenicspotid);
	}

	@Override
	public Integer getAllUser() {
		
		return this.backStageMapper.getAllUser();
	}

	@Override
	public Integer getAllArticleByUser() {
		
		return this.backStageMapper.getAllArticleByUser();
	}


}
