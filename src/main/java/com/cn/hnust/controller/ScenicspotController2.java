package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.CountrysideUser;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.HotelService;
import com.cn.hnust.service.RestaurantService;
import com.cn.hnust.service.ScenicSpotService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/SRH")
public class ScenicspotController2 {

	@Resource
	private ScenicSpotService scenicspotService;
	
	@Resource RestaurantService restaurantService;
	
	@Resource HotelService hotelService;
	
	@ResponseBody
	@RequestMapping(value="/addSRH",produces = "text/json;charset=UTF-8")
	public String addScenicspot(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	    CountrysideUser cuser = (CountrysideUser) session.getAttribute("countrysideUser");
	    
		/*scenicspot.setUserid(111);
		scenicspot.setUsername("余村负责人");*/
		String picess = null;
		String picess2= null;
		//判别：S、R、H
		String srhType = null;
		//传过来SRH各个数据
		String srhname = null;
		String srhsynopsis = null;
		String srhlocation = null;
		int srhprice = 0;
		String srhcinformation = null;
		String srhaddress = null;
		String srhcover = null;
		String srhvideo = null;
		String srhaddtime = null;
		Date srhaddtimezz = new java.util.Date();
		int srhcountryid =  Integer.valueOf(cuser.getCountrysideId());
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
		     srhType = request.getParameter("type");
			 srhname = request.getParameter("name");
			 srhsynopsis = request.getParameter("jianjie");
			 srhlocation = request.getParameter("location");
			 srhprice = Integer.parseInt(request.getParameter("price"));
			 srhcinformation = request.getParameter("phone");
			 srhaddress = request.getParameter("adress");            
		/*	scenicspot.setSname(request.getParameter("name"));
			scenicspot.setSynopsis(request.getParameter("synopsis"));
			scenicspot.setLocation(request.getParameter("location"));
			scenicspot.setPrice(Integer.parseInt(request.getParameter("price")));	
			scenicspot.setCinformation(request.getParameter("cinformation"));
			scenicspot.setAddress(request.getParameter("address"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    scenicspot.setAddtime(new java.util.Date());*/
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			if(srhType.equals("sight")){
			while(iter.hasNext()){
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					// 一次遍历所有文件
					/*String path = request.getServletContext().getRealPath("/img/scienspot") +"/"
							+ String.valueOf(new Date().getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);*/
					// 上传
					Date date = new Date();
					try {
						if(file.getName().equals("fengmian")){	
							String path = request.getServletContext().getRealPath("/img/scienspot/cover") +"/"
								+ String.valueOf(date.getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
							System.out.println(file.getName()+path);
							file.transferTo(new File(path));
							srhcover = String.valueOf(date.getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				     /*    scenicspot.setCover(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
						}
						else if(file.getName().equals("video")){
							String path = request.getServletContext().getRealPath("/img/scienspot/videos") +"/"
									+ String.valueOf(date.getTime()) + "."
									+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								file.transferTo(new File(path));
							srhvideo = String.valueOf(date.getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
							
							/*scenicspot.setVideo(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
						}
						else{
							String path = request.getServletContext().getRealPath("/img/scienspot/otherPic") +"/"
									+ String.valueOf(date.getTime()) + "."
									+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								file.transferTo(new File(path));							
						picess=String.valueOf(date.getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				    	picess2 += ";"+picess;
						}
					
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
			else if(srhType.equals("canguan")){
			while(iter.hasNext()){
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					// 一次遍历所有文件
					/*String path = request.getServletContext().getRealPath("/img/scienspot") +"/"
							+ String.valueOf(new Date().getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);*/
					// 上传
					try {
						if(file.getName().equals("fengmian")){	
							String path = request.getServletContext().getRealPath("/img/restaurant/cover") +"/"
								+ String.valueOf(new Date().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
							
							file.transferTo(new File(path));
							srhcover = String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				     /*    scenicspot.setCover(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
						}
						else if(file.getName().equals("video")){
							String path = request.getServletContext().getRealPath("/img/restaurant/videos") +"/"
									+ String.valueOf(new Date().getTime()) + "."
									+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								
								file.transferTo(new File(path));
							srhvideo = String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
							
							/*scenicspot.setVideo(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
						}
						else{
							String path = request.getServletContext().getRealPath("/img/restaurant/otherPic") +"/"
									+ String.valueOf(new Date().getTime()) + "."
									+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								
								file.transferTo(new File(path));
							
						picess=String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				    	picess2 += ";"+picess;
						}
					
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
			else if(srhType.equals("hotle")){
				while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile(iter.next().toString());
					if (file != null) {
						// 一次遍历所有文件
						/*String path = request.getServletContext().getRealPath("/img/scienspot") +"/"
								+ String.valueOf(new Date().getTime()) + "."
								+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);*/
						// 上传
						try {
							if(file.getName().equals("fengmian")){	
								String path = request.getServletContext().getRealPath("/img/hotel/cover") +"/"
									+ String.valueOf(new Date().getTime()) + "."
									+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								
								file.transferTo(new File(path));
								srhcover = String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
										.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					     /*    scenicspot.setCover(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
							}
							else if(file.getName().equals("video")){
								String path = request.getServletContext().getRealPath("/img/hotel/videos") +"/"
										+ String.valueOf(new Date().getTime()) + "."
										+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
									
									file.transferTo(new File(path));
								srhvideo = String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
										.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								
								/*scenicspot.setVideo(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1));*/
							}
							else{
								String path = request.getServletContext().getRealPath("/img/hotel/otherPic") +"/"
										+ String.valueOf(new Date().getTime()) + "."
										+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
									
									file.transferTo(new File(path));
								
							picess=String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
									.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					    	picess2 += ";"+picess;
							}
						
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
	}
        
    if(srhType.equals("sight")){

    	ScenicSpot scenicspot = new ScenicSpot();
    	/*scenicspot.setUserid(111);
		scenicspot.setUsername("余村负责人");*/
    	
    	scenicspot.setUserid(cuser.getIdcountrysideuser());
		scenicspot.setUsername(cuser.getName());
    	scenicspot.setName(srhname);
    	scenicspot.setSynosis(srhsynopsis);
    	scenicspot.setLocation(srhlocation);
    	scenicspot.setPrice(srhprice);
    	scenicspot.setCinformation(srhcinformation);
    	scenicspot.setAddress(srhaddress);
    	scenicspot.setCover(srhcover);
    	scenicspot.setPices(picess2);
        scenicspot.setVideo(srhvideo);
        scenicspot.setCountryId(srhcountryid);
    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 srhaddtime = sdf.format(srhaddtimezz);
		 scenicspot.setAddtime(srhaddtime);
    	this.scenicspotService.insertScenicspot(scenicspot);
    }
    else if(srhType.equals("canguan")){
    	Restaurant record = new Restaurant();
    	record.setUserid(cuser.getIdcountrysideuser());
    	record.setUsername(cuser.getName());
    	record.setName(srhname);
    	record.setSynopsis(srhsynopsis);
    	record.setLocation(srhlocation);
    	record.setPerprice(srhprice);
    	record.setCinformation(srhcinformation);
    	record.setAddress(srhaddress);
    	record.setCover(srhcover);
    	record.setPices(picess2);
    	record.setVideo(srhvideo);
    	record.setCountryId(srhcountryid);
    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 srhaddtime = sdf.format(srhaddtimezz);
		 record.setAddtime(srhaddtime);
    	this.restaurantService.insert(record);
    	
    }
    else if(srhType.equals("hotle")){
    	Hotel record = new Hotel();
    	record.setUserid(cuser.getIdcountrysideuser());
    	record.setUsername(cuser.getName());
    	record.setHotelname(srhname);
    	record.setIntroduce(srhsynopsis);
    	record.setLocation(srhlocation);
    	record.setLowprice(Double.valueOf(srhprice));
    	
    	record.setPhone(srhcinformation);
    	record.setDetaillocation(srhaddress);
    	record.setMainpic(srhcover);
    	record.setPice(picess2);
    	record.setVideo(srhvideo);
        record.setCountryId(srhcountryid);
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 srhaddtime = sdf.format(srhaddtimezz);
		 record.setAddtime(srhaddtime);
    	this.hotelService.insert(record);
    	
    }
    
	return "success";
	}
}
