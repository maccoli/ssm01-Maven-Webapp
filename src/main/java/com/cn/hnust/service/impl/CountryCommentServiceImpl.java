package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CountryCommentMapper;
import com.cn.hnust.pojo.CountryComment;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.service.CountryCommentService;
@Service("countryCommentService")
public class CountryCommentServiceImpl implements CountryCommentService {

	@Resource
	private CountryCommentMapper countryCommentMapper;
	
	@Override
	public List<CountryComment> getCountryComments(CountryWithBLOBs countryWithBLOBs) {
		// TODO Auto-generated method stub
		List<CountryComment> comments = this.countryCommentMapper.getCountryComments(countryWithBLOBs);
		return comments;
	}

	@Override
	public String newCountryComment(CountryComment comment) {
		// TODO Auto-generated method stub
		int sum = this.countryCommentMapper.insertSelective(comment);
		if(sum==1){
			return "评论成功";
		}{
			return "评论失败";
		}
	}

}
