package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.ArticleService;

@Controller
@RequestMapping(value = "/userarticle")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@ResponseBody
	@RequestMapping(value = "/newArticle", produces = "text/json;charset=UTF-8")
	public String newArticle(HttpServletRequest request, Map<String, Object> map, ModelMap model, HttpSession session) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		User user = (User) session.getAttribute("user");
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String value = request.getParameter("value");
		Date date = new Date();
		String mainpic = null;
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					mainpic = file.getOriginalFilename();
					mainpic = date.getTime() + mainpic.substring(mainpic.lastIndexOf("."), mainpic.length());
					String path = "E:/springUpload/" + mainpic;
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		Article article = new Article(title, user.getUsername(), date, mainpic, location, user.getUserid(), value);
		System.out.println(article);
		return "发布成功";
	}

	@ResponseBody
	@RequestMapping(value = "/newarticle2", produces = "text/json;charset=UTF-8")
	public String newarticle2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Article article = new Article();
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		Date date = new Date();
		if (multipartResolver.isMultipart(request)) {
			article.setName(request.getParameter("name"));
			article.setLocation(request.getParameter("location"));
			article.setContent(request.getParameter("content"));
			try {
				FileWriter fw = new FileWriter(request.getServletContext().getRealPath("/img/upload") + "/"
						+ String.valueOf(date.getTime()) + ".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(request.getParameter("content"));// 往已有的文件上添加字符串
				article.setContent(String.valueOf(date.getTime()) + ".txt");
				bw.close();
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "发表成功";
			}
			article.setUsername(user.getUsername());
			article.setUserUserid(user.getUserid());
			Calendar calendar = Calendar.getInstance();
			article.setArticletime(calendar.getTime());
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("/img/articles/cover") + "/"
							+ String.valueOf(date.getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					// 上传
					try {
						file.transferTo(new File(path));
						article.setMainpic(String.valueOf(date.getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "发表成功";
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "发表成功";
					}
				}
			}
		}
		this.articleService.newArticle(article);
		return "发表成功";
	}

	@ResponseBody
	@RequestMapping(value = "/UserArticles", produces = "text/json;charset=UTF-8")
	public void getUserArticles(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		User user = (User) request.getSession().getAttribute("user");
		List<Article> articles = this.articleService.getUserArticles(user);
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
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject object = new JSONObject();
		object.put("articles", articles);
		try {
			response.getWriter().write(object.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/Bypage", produces = "text/json;charset=utf-8")
	public void getArticleByPage(HttpServletRequest request, HttpServletResponse response) {
		Integer page = Integer.valueOf(request.getParameter("page"));
		User user = (User) request.getSession().getAttribute("user");
		response.setCharacterEncoding("text/json;charset=utf-8");
		List<Article> articles = this.articleService.getArticlesByPage(user, page);
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
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject object = new JSONObject();
		object.put("articles", articles);
		try {
			response.getWriter().write(object.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/view", produces = "text/json;charset=utf-8")
	public void view(HttpServletRequest request, HttpServletResponse response) {
		Article article = new Article();
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		Date date = new Date();
		if (multipartResolver.isMultipart(request)) {
			article.setName(request.getParameter("name"));
			article.setLocation(request.getParameter("location"));
			article.setContent(request.getParameter("content"));
			Calendar calendar = Calendar.getInstance();
			article.setArticletime(calendar.getTime());
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("/img/src") + "/"
							+ String.valueOf(date.getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					try {
						file.transferTo(new File(path));
						article.setMainpic(String.valueOf(date.getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		JSONObject object = new JSONObject();
		object.put("article", article);
		try {
			response.getWriter().print(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@ResponseBody
	@RequestMapping(value = "/getOneArticleById", produces = "application/json;charset=utf-8")
	public Article getOneArticleById(HttpServletRequest request) {
		Article article = new Article();
		int id = 1;
		try {
			BufferedReader reader = request.getReader();
			id = Integer.valueOf(reader.readLine());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		article = this.articleService.one(id);
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
		return article;
	}
}
