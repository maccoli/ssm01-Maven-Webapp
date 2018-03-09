package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.User;

public interface RecordUserService {

	 
	 List<User> getRecordtimeByuser();
	 
	 List<User> getUsernameByid(Integer userid);
	 

	 public Integer getCollByUserid(Integer userid);
	 
	 List<ScenicSpot> getScenicspotBysid(Integer scenicspotid);
	 
     Integer getAllUser();
	 
	 Integer getAllArticleByUser();
}
