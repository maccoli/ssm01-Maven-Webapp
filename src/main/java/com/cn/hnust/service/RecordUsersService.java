package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.User;

public interface RecordUsersService {

	 List<Article> getUserArticles(Integer userid);
	 
}
