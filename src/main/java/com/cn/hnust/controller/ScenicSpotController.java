package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.ScenicSpotService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "ScenicSpot")
@Controller
@RequestMapping(value = "/ScenicSpot")
public class ScenicSpotController {
	@Resource
	private ScenicSpotService scenicSpotService;

	@ApiOperation(value = "获取乡村所有的景点", httpMethod = "GET", notes = "get all Spots")
	@ResponseBody
	@RequestMapping(value = "/getSpots", produces = "text/json;charset=UTF-8")
	public void getUser(HttpSession session, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CountryWithBLOBs bloBs = (CountryWithBLOBs) session.getAttribute("CountryWithBLOBs");
		System.out.println(bloBs.toString());
		/* this.scenicSpotService.getCountrysideSpots(user); */
		List<ScenicSpot> spots = this.scenicSpotService.getCountrysideSpots(bloBs);
		JSONObject object = new JSONObject();
		object.put("ScenicSpots", spots);
		try {
			response.getWriter().print(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiOperation(value = "修改景点信息", httpMethod = "GET", notes = "change spot infomation", response = java.lang.String.class)
	@ResponseBody
	@RequestMapping("/newSpot")
	public String newSpot(@RequestParam("id")int id,@RequestParam("name") String name, @RequestParam("jianjie") String introduce,
			@RequestParam("price") int price, @RequestParam("phone") String phone,
			@RequestParam("adress") String adress, @RequestParam("location") String location,HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		ScenicSpot spot = new ScenicSpot();
		spot.setAddress(adress);
		spot.setName(name);
		spot.setLocation(location);
		spot.setCinformation(phone);
		spot.setSynosis(introduce);
		spot.setPrice(price);
		String cover = "";
		String path =  "";
		String pics = "";
		String video = "";
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				Calendar calendar = Calendar.getInstance();
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					if (file.getName().equals("fengmian")) {
						cover = file.getOriginalFilename();
						System.out.println("fengmian:"+cover);
						path = request.getServletContext().getRealPath("/img/scienspot/cover") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						cover = String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					} else if(file.getName().startsWith("images")) {
						path = request.getServletContext().getRealPath("/img/scienspot/otherPic") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						pics = pics + ";" + String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						System.out.println("pics:"+pics);
					}else{
						path = request.getServletContext().getRealPath("/img/scienspot/videos") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						video = String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						System.out.println("video:"+video);
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
			spot.setVideo(video);
			spot.setPices(pics);
			spot.setCover(cover);
		}
		this.scenicSpotService.newSopt(spot);
		return "修改成功";
	}

	@ResponseBody
	@RequestMapping(value = "/detail")
	public ScenicSpot getSpotDetail(HttpServletRequest request) {
		int id  = 123;
		StringBuffer requestBody;
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

		ScenicSpot scenicSpot = new ScenicSpot();
		scenicSpot = this.scenicSpotService.getDetail(id);
		return scenicSpot;
	}

	@ApiOperation(value = "修改景点信息", httpMethod = "GET", notes = "change spot infomation", response = java.lang.String.class)
	@ResponseBody
	@RequestMapping(value = "/changeSpot", produces = "text/json;charset=utf-8")
	public String changeInfo(@RequestParam("id")int id,@RequestParam("name") String name, @RequestParam("jianjie") String introduce,
			@RequestParam("price") int price, @RequestParam("phone") String phone,
			@RequestParam("adress") String adress, @RequestParam("location") String location,HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		ScenicSpot spot = this.scenicSpotService.getDetail(id);
		spot.setAddress(adress);
		spot.setName(name);
		spot.setLocation(location);
		spot.setCinformation(phone);
		spot.setSynosis(introduce);
		spot.setPrice(price);
		String cover = "";
		String path =  "";
		String pics = "";
		String video = "";
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				Calendar calendar = Calendar.getInstance();
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					if (file.getName().equals("fengmian")) {
						cover = file.getOriginalFilename();
						System.out.println("fengmian:"+cover);
						path = request.getServletContext().getRealPath("/img/scienspot/cover") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						cover = String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					} else if(file.getName().startsWith("images")) {
						path = request.getServletContext().getRealPath("/img/scienspot/otherPic") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						pics = pics + ";" + String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						System.out.println("pics:"+pics);
					}else{
						path = request.getServletContext().getRealPath("/img/scienspot/videos") + "/"
								+ String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						video = String.valueOf(calendar.getTime().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
						System.out.println("video:"+video);
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
			spot.setVideo(video);
			spot.setPices(pics);
			spot.setCover(cover);
		}
		this.scenicSpotService.changeInfo(spot);
		return "修改成功";
	}
	
	@ApiOperation(value="/getSpotNames",httpMethod="GET",response=java.util.List.class)
	@ResponseBody
	@RequestMapping(value="/getSpotNames")
	public List<String> getAllScenicspotNames(){
		List<String> names = new LinkedList<String>();
		names = this.scenicSpotService.getAllSpotNames();
		return names;
	}
}
