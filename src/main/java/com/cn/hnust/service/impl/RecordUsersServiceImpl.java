package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ArticleMapper;
import com.cn.hnust.dao.BackStageMapper;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.RecordUserService;
import com.cn.hnust.service.RecordUsersService;

@Service("recordUsersService")
public class RecordUsersServiceImpl implements RecordUsersService {

	
	@Resource
	private ArticleMapper articleMapper;
	

	@Override
	public List<Article> getUserArticles(Integer userid) {
		User user = new User();
		user.setUserid(userid);
		return this.articleMapper.getUserArticles(user);
	}
	
	

}
