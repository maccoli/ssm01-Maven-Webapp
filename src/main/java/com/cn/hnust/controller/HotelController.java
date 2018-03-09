package com.cn.hnust.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.service.HotelService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value="Hotel")
@Controller
@RequestMapping(value="/Hotel")
public class HotelController {

	@Resource
	private HotelService hotelService;
	
	@ApiOperation(value="获取乡村所有的住宿",httpMethod="GET",notes="get all CountryHotels")
	@ResponseBody
	@RequestMapping(value="/allCountryHotels", produces = "text/json;charset=UTF-8")
	public void getAllCountryHotels(HttpSession session,HttpServletResponse response){
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CountryWithBLOBs bloBs = (CountryWithBLOBs)session.getAttribute("CountryWithBLOBs");
		List<Hotel> hotels = this.hotelService.getCountryHotels(bloBs);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("hotels", hotels);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/changeHotelInfo",produces="text/json;charset=utf-8")
	public String changeHotelInfo(Hotel hotel){
		
		return "修改失败";
	}
	
	@ResponseBody
	@RequestMapping(value="/detail")
	public Hotel getHotelDetail(HttpServletRequest request){
		Hotel hotel = new Hotel();
		int id = 123;
/*		try {
			BufferedReader reader = request.getReader();
			id = Integer.valueOf(reader.readLine());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		hotel = this.hotelService.getHotelDetail(id);
		return hotel;
	}
}
