package com.cn.hnust.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.User;

public interface ArticleService {
	
	public List<Article> getUserArticles(User user);
	
	/**
	 * 发表新游记
	 * @param article
	 * @return
	 */
	public void newArticle(Article article);
	
	public Article one(Integer id);
	
	public List<Article> getCountrysideArticles(CountryWithBLOBs bloBs,HttpServletRequest request);
	
	public List<Article> getArticlesByPage(User user,Integer page);
}
