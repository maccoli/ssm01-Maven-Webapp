package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.cn.hnust.dao.CountrysideUserMapper;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.CountryComment;
import com.cn.hnust.pojo.CountryPhoto;
import com.cn.hnust.pojo.CountryVideo;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.CountrysideUser;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.ArticleService;
import com.cn.hnust.service.CountryCommentService;
import com.cn.hnust.service.CountryPhotoService;
import com.cn.hnust.service.CountryService;
import com.cn.hnust.service.CountryVideoService;
import com.cn.hnust.service.CountrysideUserService;
import com.cn.hnust.service.HotelService;
import com.cn.hnust.service.RestaurantService;
import com.cn.hnust.service.ScenicSpotService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "country")
@Controller
@RequestMapping("/country")
public class CountryController {
	@Resource
	private CountryService countryService;
	@Resource
	private CountryPhotoService countryPhotoService;
	@Resource
	private CountryVideoService countryVideoService;
	@Resource
	private ArticleService articleService;
	@Resource
	private RestaurantService restaurantService;
	@Resource
	private HotelService hotelService;
	@Resource
	private ScenicSpotService scenicSpotService;
	@Resource
	private CountryCommentService commentService;

	@Resource
	private CountrysideUserService countrysideUserService;
	/*
	 * @Resource private SpecialtyService specialtyService;
	 */

	@ResponseBody
	@RequestMapping(value = "/oneCountryById", produces = "application/json;charset=UTF-8")
	public Map<String, Object> getOneCountryById(HttpServletRequest request) {
		int countryId = Integer.valueOf(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		CountryWithBLOBs countryWithBLOBs = this.countryService.getOneCountryById(countryId);
		List<CountryPhoto> countryPhotos = this.countryPhotoService.getCountryPhotos(countryWithBLOBs);
		List<CountryVideo> countryVideos = this.countryVideoService.getcountrysideVideos(countryWithBLOBs);
		// List<Specialty> specialties =
		// this.specialtyService.getCountrysideSpecialty(countryWithBLOBs);
		map.put("countryside", countryWithBLOBs);
		map.put("countryPhotos", countryPhotos);
		map.put("countryVideos", countryVideos);
		// map.put("specialties", specialties);
		return map;
	}

	/**
	 * 获取一个用户管理的所有乡村
	 * 
	 * @param httpSession
	 */
	@ResponseBody
	@RequestMapping(value = "/UserCountrysides", produces = "text/json;charset=UTF-8")
	public void getUserCountrysides(HttpServletResponse response, HttpSession session) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*
		 * List<CountryWithBLOBs> countryWithBLOBs =
		 * this.countryService.getUserCountrysides(httpSession); JSONObject
		 * object = new JSONObject(); object.put("countrysides",
		 * countryWithBLOBs); try { response.getWriter().print(object); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		CountryWithBLOBs bloBs  = new CountryWithBLOBs();
		CountrysideUser user = (CountrysideUser) session.getAttribute("countrysideUser");
		if(user.getCountrysideId()==null){
			bloBs = new CountryWithBLOBs();
		}else{
			bloBs = this.countryService.getOneCountryById(Integer.valueOf(user.getCountrysideId()));
		}
		session.setAttribute("CountryWithBLOBs", bloBs);
		JSONObject object = new JSONObject();
		List<CountryWithBLOBs> bs = new ArrayList<CountryWithBLOBs>();
		bs.add(bloBs);
		object.put("CountryWithBLOBs", bs);
		try {
			response.getWriter().print(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取一个乡村的所有信息
	 * 
	 * @param request
	 * @param response
	 */
	@ApiOperation(value = "获取乡村所有信息", httpMethod = "GET", notes = "get country all info", response = List.class)
	@ResponseBody
	@RequestMapping(value = "/allInfo")
	public void getAllInfo(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		JSONObject object = new JSONObject();
		CountryWithBLOBs bloBs = new CountryWithBLOBs();
		StringBuffer requestBody;
		Integer id = 1;
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				id = Integer.valueOf(jsonObject.get("id").toString());
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bloBs.setId(id);
		bloBs = this.countryService.getOneCountryById(bloBs.getId());
		List<CountryWithBLOBs> bloBs2 = new ArrayList<CountryWithBLOBs>();
		List<CountryPhoto> photos = this.countryPhotoService.getCountryPhotos(bloBs);
		List<CountryVideo> videos = this.countryVideoService.getcountrysideVideos(bloBs);
		List<Article> articles = this.articleService.getCountrysideArticles(bloBs,request);
		List<ScenicSpot> scenicSpots = this.scenicSpotService.getCountrysideSpots(bloBs);
		List<Hotel> hotels = this.hotelService.getCountryHotels(bloBs);
		List<Restaurant> restaurants = this.restaurantService.getCountryRestaurant(bloBs);
		List<CountryComment> comments = this.commentService.getCountryComments(bloBs);
		bloBs2.add(bloBs);
		CountryWithBLOBs bs = bloBs2.get(0);
		String path = bs.getCulture();
		String path2 = bs.getActivities();
		File file = new File(request.getServletContext().getRealPath("/img/upload") + "/" + path);// 定义一个file对象，用来初始化FileReader
		FileReader reader = null;
		File file2 = new File(request.getServletContext().getRealPath("/img/upload") + "/" + path2);// 定义一个file对象，用来初始化FileReader
		FileReader reader2 = null;
		try {
			reader = new FileReader(file);
			reader2 = new FileReader(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 定义一个fileReader对象，用来初始化BufferedReader
		BufferedReader bReader = new BufferedReader(reader);// new一个BufferedReader对象，将文件内容读取到缓存
		StringBuilder sb = new StringBuilder();// 定义一个字符串缓存，将字符串存放缓存中
		String s = "";
		BufferedReader bReader2 = new BufferedReader(reader2);// new一个BufferedReader对象，将文件内容读取到缓存
		StringBuilder sb2 = new StringBuilder();// 定义一个字符串缓存，将字符串存放缓存中
		String s2 = "";
		try {
			while ((s = bReader.readLine()) != null) {// 逐行读取文件内容，不读取换行符和末尾的空格
				sb.append(s + "\n");// 将读取的字符串添加换行符后累加存放在缓存中
			}
			bReader.close();
			while ((s2 = bReader2.readLine()) != null) {// 逐行读取文件内容，不读取换行符和末尾的空格
				sb2.append(s2 + "\n");// 将读取的字符串添加换行符后累加存放在缓存中
			}
			bReader2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = sb.toString();
		String str2 = sb2.toString();
		bs.setCulture(str);
		bs.setActivities(str2);
		bloBs2.clear();
		bloBs2.add(bs);
		object.put("info", "获取信息成功");
		object.put("country", bloBs2);
		object.put("photos", photos);
		object.put("videos", videos);
		object.put("articles", articles);
		object.put("scenicSpots", scenicSpots);
		object.put("hotels", hotels);
		object.put("restaurants", restaurants);
		object.put("comments", comments);
		try {
			response.getWriter().print(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiOperation(value = "根据类别获取乡村", httpMethod = "GET", notes = "get user in session", response = List.class)
	@ResponseBody
	@RequestMapping(value = "/ByType", produces = "application/json;charset=UTF-8")
	public List<CountryWithBLOBs> getCountryByType(
			/*
			 * @RequestParam("countryType") String countrytype,
			 * 
			 * @RequestParam("page") Integer page, @RequestParam("content")
			 * String content,
			 */HttpServletRequest request, HttpServletResponse response) {
		String countrytype = "";
		Integer page = 0;
		String content = "";
		StringBuffer requestBody;
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				countrytype = jsonObject.get("type1").toString();
				page = Integer.valueOf(jsonObject.get("page").toString());
				content = jsonObject.get("key").toString();
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("1:"+countrytype);
		System.out.println("1:"+page);
		System.out.println("1:"+content);
		System.out.println();
		List<CountryWithBLOBs> bloBs = this.countryService.getCountrysByType(countrytype, page, content);
		if (bloBs.size() == 0) {
			return null;
		} else {
			return bloBs;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getAllXc", produces = "application/json;charset=UTF-8")
	public String getAllCountrysides(HttpServletRequest request) {
		List<CountryWithBLOBs> bs = new ArrayList<CountryWithBLOBs>();
		int page = 0;
		try {
			BufferedReader reader = request.getReader();
			page = Integer.valueOf(reader.readLine());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bs = this.countryService.getAllCountry(page);
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(); // 构造方法里，也可以直接传需要序列化的属性名字
		filter.getExcludes().add("introduce");
		filter.getExcludes().add("culture");
		filter.getExcludes().add("activities");
		filter.getExcludes().add("ac");
		filter.getExcludes().add("rc");
		filter.getExcludes().add("cc");
		filter.getExcludes().add("score");
		filter.getExcludes().add("targetsum");
		filter.getExcludes().add("hotels");
		filter.getExcludes().add("restaurants");
		filter.getExcludes().add("examine");
		filter.getExcludes().add("userid");
		filter.getExcludes().add("username");
		filter.getExcludes().add("addtime");
		filter.getExcludes().add("sights");
		filter.getExcludes().add("location");
		return JSON.toJSONString(bs, filter);
	}

	@ResponseBody
	@RequestMapping(value = "/newCountry")
	public String newCountryside(HttpServletRequest request, HttpSession session) {
		CountryWithBLOBs bs = new CountryWithBLOBs();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		CountrysideUser user = (CountrysideUser) session.getAttribute("countrysideUser");
		Date date = new Date();
		bs.setName(request.getParameter("name"));
		bs.setIntroduce(request.getParameter("introduce"));
		bs.setLocation(request.getParameter("location"));
		bs.setCountrytype(request.getParameter("countrytype"));
		bs.setUserid(user.getIdcountrysideuser());
		bs.setUsername(user.getName());
		String cover = null;
		String pics = "";
		String videos = "";
		String[] speciality;
		String path;
		Date date2 = new Date();
		date2.setTime(2l + date.getTime());
		List<String> list = new ArrayList<String>();
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			try {
				FileWriter fw = new FileWriter(request.getServletContext().getRealPath("/img/upload") + "/"
						+ String.valueOf(date.getTime()) + ".txt", true);
				FileWriter fw2 = new FileWriter(request.getServletContext().getRealPath("/img/upload") + "/"
						+ String.valueOf(date2.getTime()) + ".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				bw.write(request.getParameter("culture"));
				bw2.write(request.getParameter("activities"));
				bw.close();
				bw2.close();
				fw.close();
				fw2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "添加乡村失败";
			}
			bs.setActivities(String.valueOf(date.getTime()) + ".txt");
			bs.setCulture(String.valueOf(date2.getTime()) + ".txt");
			// 处理请求中的文件
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					Date date3 = new Date();
					if (file.getName().equals("mianpic")) {
						cover = file.getOriginalFilename();
						path = request.getServletContext().getRealPath("/img/countryside/mainPic") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						cover = String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					} else if (file.getName().startsWith("techang")) {
						path = request.getServletContext().getRealPath("/img/countryside/pics") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						list.add(String.valueOf(date3.getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));
					} else if (file.getName().startsWith("meijing/pic")) {
						path = request.getServletContext().getRealPath("/img/countryside/pics") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						pics = pics + ";" + String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						;
					} else {
						path = request.getServletContext().getRealPath("/img/countryside/videos") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						videos = videos + ";" + String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					}
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return "添加乡村失败";
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return "添加乡村失败";
					}
				}
			}
			bs.setMianpic(cover);
		}
		CountryPhoto countryPhoto = new CountryPhoto();
		CountryVideo countryVideo = new CountryVideo();
		countryPhoto.setCountryId(bs.getId());
		countryPhoto.setSrc(pics);
		countryVideo.setCountryId(bs.getId());
		countryVideo.setSrc(videos);
		if (this.countryService.newCountry(bs) == 1) {
			List<CountryWithBLOBs> bloBs = this.countryService.getUserCountrysides(session);
			countryPhoto.setCountryId(bloBs.get(0).getId());
			countryVideo.setCountryId(bloBs.get(0).getId());
			this.countryVideoService.newVideos(countryVideo);
			this.countryPhotoService.newPhotos(countryPhoto);
			String name = bs.getName();
			user.setCountrysideId(String.valueOf(this.countryService.getByName(name).getId()));
			this.countrysideUserService.changeUserInfo(user, session);
			return "添加成功";
		} else {
			return "添加失败";
		}
	}
	@ApiOperation(value="changeInfo",notes="change countryside info",httpMethod="GET",response=java.lang.String.class)
	@ResponseBody
	@RequestMapping(value="/changeInfo",produces="text/json;charset=utf-8")
	public String changeInfo(HttpServletRequest request,HttpSession session){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		CountrysideUser user = (CountrysideUser) session.getAttribute("countrysideUser");
		CountryWithBLOBs bs = this.countryService.getOneCountryById(Integer.valueOf(user.getCountrysideId()));
		System.out.println(bs.toString());
		Date date = new Date();
		bs.setName(request.getParameter("name"));
		bs.setIntroduce(request.getParameter("introduce"));
		bs.setLocation(request.getParameter("location"));
		bs.setCountrytype(request.getParameter("countrytype"));
		bs.setUserid(user.getIdcountrysideuser());
		bs.setUsername(user.getName());
		String cover = null;
		String pics = "";
		String videos = "";
		String path;
		Date date2 = new Date();
		date2.setTime(2l + date.getTime());
		List<String> list = new ArrayList<String>();
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			try {
				FileWriter fw = new FileWriter(request.getServletContext().getRealPath("/img/upload") + "/"
						+ String.valueOf(date.getTime()) + ".txt", true);
				FileWriter fw2 = new FileWriter(request.getServletContext().getRealPath("/img/upload") + "/"
						+ String.valueOf(date2.getTime()) + ".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				bw.write(request.getParameter("culture"));
				bw2.write(request.getParameter("activities"));
				bw.close();
				bw2.close();
				fw.close();
				fw2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "添加乡村失败";
			}
			bs.setActivities(String.valueOf(date.getTime()) + ".txt");
			bs.setCulture(String.valueOf(date2.getTime()) + ".txt");
			// 处理请求中的文件
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					Date date3 = new Date();
					if (file.getName().equals("mianpic")) {
						cover = file.getOriginalFilename();
						path = request.getServletContext().getRealPath("/img/countryside/mainPic") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						cover = String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					} else if (file.getName().startsWith("techang")) {
						path = request.getServletContext().getRealPath("/img/countryside/pics") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						list.add(String.valueOf(date3.getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));
					} else if (file.getName().startsWith("meijing/pic")) {
						path = request.getServletContext().getRealPath("/img/countryside/pics") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						pics = pics + ";" + String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						;
					} else {
						path = request.getServletContext().getRealPath("/img/countryside/videos") + "/"
								+ String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						videos = videos + ";" + String.valueOf(date3.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					}
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return "添加乡村失败";
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return "添加乡村失败";
					}
				}
			}
			bs.setMianpic(cover);
		}
		CountryPhoto countryPhoto = new CountryPhoto();
		CountryVideo countryVideo = new CountryVideo();
		countryPhoto.setCountryId(bs.getId());
		countryPhoto.setSrc(pics);
		countryVideo.setCountryId(bs.getId());
		countryVideo.setSrc(videos);
		if (this.countryService.changeInfo(bs) == 1) {
			List<CountryWithBLOBs> bloBs = this.countryService.getUserCountrysides(session);
			countryPhoto.setCountryId(bloBs.get(0).getId());
			countryVideo.setCountryId(bloBs.get(0).getId());
			this.countryVideoService.newVideos(countryVideo);
			this.countryPhotoService.newPhotos(countryPhoto);
			this.countrysideUserService.changeUserInfo(user, session);
			return "修改乡村成功";
		} else {
			return "修改乡村失败";
		}
	}
	
	@ApiOperation(value="delete",notes="delete countryside",httpMethod="GET",response=java.lang.String.class)
	@ResponseBody
	@RequestMapping(value="/delete",produces="text/json;charset=utf-8")
	public String deleteCountryside(){
		this.countryService.deleteCountry(15);
		return "修改乡村成功";
	}
	
	@ApiOperation(value="/getCountrysideNames",httpMethod="GET",response=java.util.List.class)
	@ResponseBody
	@RequestMapping(value="/getCountrysideNames")
	public List<String> getAllCountrysideNames(){
		List<String> names = new LinkedList<String>();
		names = this.countryService.getAllCountrysideNames();
		return names;
	}
	
}
