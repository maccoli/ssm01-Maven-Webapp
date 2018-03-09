package com.cn.hnust.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.BackStageService;
import com.cn.hnust.service.CountryService;
import com.cn.hnust.service.RecordUserService;
import com.cn.hnust.service.RecordUsersService;

@Controller
@RequestMapping("/BackStage")
public class BackStageController {

	@Resource
	private BackStageService backStageService;

	@Resource
	private RecordUserService recordUserService;

	@Resource
	private RecordUsersService recordUsersService;

	// ----乡村分析
	@RequestMapping(value = "/showCountryInStage", produces = "text/html;;charset=utf-8")
	public void showCountryInStage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(request.getParameter("countryId"));
		List<Country> country = new ArrayList<Country>();
		// Hotel hotele = new Hotel();
		List<Restaurant> restaurant = new ArrayList<Restaurant>();
		List<ScenicSpot> scenicspot = new ArrayList<ScenicSpot>();
		List<Hotel> hotel = new ArrayList<Hotel>();
		List<Object> sids = new ArrayList<Object>();
		List<Integer> rids = new ArrayList<Integer>();
		List<Object> hids = new ArrayList<Object>();

		// -----获取餐馆，景点，酒店的数目
		country = this.backStageService.getSRHByCountry(id);
		Integer count = backStageService.getUsercollByCountry(id);

		// --获取餐馆的数据
		restaurant = this.backStageService.getRestaurantByCountry(id);

		// 对restaurant进行分离，再放入到rids中
		Iterator<Restaurant> iterator = restaurant.iterator();
		while (iterator.hasNext()) {
			Restaurant restaurant2 = (Restaurant) iterator.next();
			restaurant2.getRestaurantid();
			rids.add(restaurant2.getRestaurantid());
		}

		// --获取景点数据
		scenicspot = this.backStageService.getScenicspotByCountry(id);
		// 分离
		Iterator<ScenicSpot> iterator2 = scenicspot.iterator();
		while (iterator2.hasNext()) {
			ScenicSpot scenicspot2 = (ScenicSpot) iterator2.next();
			scenicspot2.getScenicspotid();
			sids.add(scenicspot2.getScenicspotid());
		}
		// --获取酒店的数据
		hotel = this.backStageService.getHotelByCountry(id);
		// 分离
		Iterator<Hotel> iterator3 = hotel.iterator();
		while (iterator3.hasNext()) {
			Hotel hotel2 = (Hotel) iterator3.next();
			hotel2.getIdhotel();
			hids.add(hotel2.getIdhotel());
		}

		List<Integer> rcount = new ArrayList<Integer>();
		List<Integer> scount = new ArrayList<Integer>();
		List<Integer> hcount = new ArrayList<Integer>();

		rcount = backStageService.getRestaurantcollByUser(rids);
		scount = backStageService.getScenicspotcollByUser(sids);
		hcount = backStageService.getHotelcollByUser(hids);

		System.out.println(rcount);
		System.out.println(scount);
		System.out.println(hcount);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list1", country);
		jsonObject.put("list2", count);
		jsonObject.put("list3", restaurant);
		jsonObject.put("list3_2", rcount);
		jsonObject.put("list4", scenicspot);
		jsonObject.put("list4_2", scount);
		jsonObject.put("list5", hotel);
		jsonObject.put("list5_2", hcount);
		response.getWriter().write(jsonObject.toString());
		return;
	}

	// -------用户分析
	@RequestMapping("/showallUser")
	public void showallUser(HttpServletResponse response) throws IOException {
		// request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<User> allu = new ArrayList<User>();
		allu = this.recordUserService.getRecordtimeByuser();

		Integer users = this.recordUserService.getAllUser();

		Integer articles = this.recordUserService.getAllArticleByUser();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list1", allu);
		jsonObject.put("list2", users);
		jsonObject.put("list3", articles);

		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showUserone")
	public void showUserone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Integer userid = Integer.parseInt(request.getParameter("id"));

		List<User> user = new ArrayList<User>();

		List<Article> article = new ArrayList<Article>();

		List<ScenicSpot> scenicspot = new ArrayList<ScenicSpot>();

		user = this.recordUserService.getUsernameByid(userid);
		article = this.recordUsersService.getUserArticles(userid);

		Integer scenicspotid = this.recordUserService.getCollByUserid(userid);

		scenicspot = this.recordUserService.getScenicspotBysid(scenicspotid);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list1", user);
		jsonObject.put("list2", article);
		jsonObject.put("list3", scenicspot);
		response.getWriter().write(jsonObject.toString());
		return;
	}
}
