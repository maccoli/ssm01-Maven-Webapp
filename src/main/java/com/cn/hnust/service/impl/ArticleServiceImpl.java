package com.cn.hnust.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ArticleMapper;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Resource
	private ArticleMapper articleDao;

	@Override
	public List<Article> getUserArticles(User user) {
		// TODO Auto-generated method stub
		List<Article> articles = this.articleDao.getUserArticles(user);
		return articles;
	}

	@Override
	public void newArticle(Article article) {
		// TODO Auto-generated method stub
		this.articleDao.insertSelective(article);
		
	}

	@Override
	public Article one(Integer id) {
		// TODO Auto-generated method stub
		return this.articleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> getCountrysideArticles(CountryWithBLOBs bloBs,HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Article> articles = this.articleDao.getCountrysideArticles(bloBs);
		Iterator<Article> iterator = articles.iterator();
		while (iterator.hasNext()) {
			Article article = (Article) iterator.next();
			String path = article.getContent();
			File file = new File(request.getServletContext().getRealPath("/img/upload") + "/" + path);// 定义一个file对象，用来初始化FileReader
			FileReader reader = null;
			try {
				reader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 定义一个fileReader对象，用来初始化BufferedReader
			BufferedReader bReader = new BufferedReader(reader);// new一个BufferedReader对象，将文件内容读取到缓存
			StringBuilder sb = new StringBuilder();// 定义一个字符串缓存，将字符串存放缓存中
			String s = "";
			try {
				while ((s = bReader.readLine()) != null) {// 逐行读取文件内容，不读取换行符和末尾的空格
					sb.append(s + "\n");// 将读取的字符串添加换行符后累加存放在缓存中
				}
				bReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str = sb.toString();
			article.setContent(str);
		}
		return articles;
	}

	@Override
	public List<Article> getArticlesByPage(User user, Integer page) {
		// TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",page*12);
        map.put("pagesize",12);
        List<Article> articles = this.articleDao.selectArticleByMap(map);  
		return articles;
	}
}
