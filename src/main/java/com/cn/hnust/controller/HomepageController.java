package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.dao.HomepageMapper;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;


@Controller
@RequestMapping("/homepage")
public class HomepageController {

	@Resource
	private HomepageMapper homepageMapper;
	
	@RequestMapping("/ShowHomepage")
	@ResponseBody

	 public void ShowHomepage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		Integer id = Integer.parseInt(request.getParameter("id"));
/*		 BufferedReader reader = request.getReader();
		 String input = null;
		 StringBuffer requestBody = new StringBuffer();
		 while((input = reader.readLine())!=null){
			 requestBody.append(input);
             JSONObject jsonObject = new JSONObject(input);
             id = jsonObject.getInt("id");
		 }*/
		 //首页点击村
		 List<Country> country= new ArrayList<Country>();
		 country = this.homepageMapper.showCountryInHome(id);
		 
		 //搜索框
		 List<Country> countrys= new ArrayList<Country>();
		 List<Restaurant> restaurant= new ArrayList<Restaurant>();
		 List<ScenicSpot> scenicspot= new ArrayList<ScenicSpot>();
		 List<Hotel> hotel= new ArrayList<Hotel>();
         
		 countrys =this.homepageMapper.showCountrysInhome(); 
				 
		 restaurant = this.homepageMapper.showRestaurantInHome();
		 
		 scenicspot = this.homepageMapper.showScenicspotInHome();
		 
		 hotel = this.homepageMapper.showHotelInHome();
		 
		 //推荐
		 List<Integer> cid= new ArrayList<Integer>();
		 
		 List<Country> countryhot = new ArrayList<Country>();
		 
		 List<Article> article = new ArrayList<Article>();
		 
		 cid = this.homepageMapper.showHotCountryByColl();
		 
		 countryhot = this.homepageMapper.showHotCountry(cid);
		 
		 article = this.homepageMapper.showHotArticleByColl();
		 

		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("list1", country);
         jsonObject.put("list2_1", countrys);
         jsonObject.put("list2_2", restaurant);
         jsonObject.put("list2_3", scenicspot);
         jsonObject.put("list2_4", hotel);
         jsonObject.put("list3_1", countryhot);
         jsonObject.put("list3_2", article);
		 response.getWriter().write(jsonObject.toString());
		 return;

	 }
}
