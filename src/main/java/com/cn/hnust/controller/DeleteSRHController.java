package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.CountrysideUser;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.DeleteSRHService;

@Controller
@RequestMapping("/deleteSRH")
public class DeleteSRHController {

	@Resource
	private DeleteSRHService deleteSRHService;
	
	
	@RequestMapping("/delSRH")
	public String delSRH(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		CountryWithBLOBs country2= new CountryWithBLOBs();
		CountrysideUser cuser = (CountrysideUser) session.getAttribute("countrysideUser");
		country2.setUserid(cuser.getIdcountrysideuser());
		country2.setId(Integer.parseInt(cuser.getCountrysideId()));
		String type = null;
		Integer id = null;
	/*≤‚ ‘”√--	country2.setId(1);
		String type = "hotel";
		Integer id = Integer.parseInt(request.getParameter("id"));*/
         
		StringBuffer requestBody;
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while((input = reader.readLine())!=null){
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				type = jsonObject.get("type").toString();
				id = Integer.parseInt(jsonObject.get("id").toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if(type.equals("hotel")){
	//	 Map<String, Object> reMap = new HashMap<String, Object>();  
		Hotel hotel = new Hotel();
		hotel = this.deleteSRHService.delHotelfile(id);

		String fileName = hotel.getMainpic();

		String fileName2 = hotel.getPice();

		String fdate [] = fileName2.split(";");
		
		String fileVideo = hotel.getVideo();
		
		//…æ≥˝∑‚√Ê
		String path = request.getServletContext().getRealPath("/img/hotel/cover");
		File targetFile = new File(path,fileName);
		if(targetFile.exists()){
			targetFile.delete();
		}
		
		//…æ≥˝Õº∆¨ºØ
		String path2 = request.getServletContext().getRealPath("/img/hotel/otherPic");	
		for(int i = 0;i < fdate.length;i++)
		{
		File targetFile2 = new File(path2,fdate[i]);
		if(targetFile2.exists()){
			targetFile2.delete();
		}
		}
		
		//…æ≥˝ ”∆µ
		String path3 = request.getServletContext().getRealPath("/img/hotel/videos");
		File targetFile3 = new File(path3,fileVideo);
		if(targetFile3.exists()){
			targetFile3.delete();
		}
		
		this.deleteSRHService.delHotel(id, country2);
	}
	
	if(type.equals("scenicspot")){
		ScenicSpot scenicspot = new ScenicSpot();
	    scenicspot = this.deleteSRHService.delScenicspotfile(id);
		String fileName = scenicspot.getCover();
		String fileName2 = scenicspot.getPices();
		String fdate[] = fileName2.split(";");
		
		String fileVideo = scenicspot.getVideo();
		
		String path = request.getServletContext().getRealPath("/img/scenicspot/cover");
		File targetFile = new File(path,fileName);
		if(targetFile.exists()){
			targetFile.delete();
		}
		
		String path2 = request.getServletContext().getRealPath("/img/scenicspot/otherPic");
		for(int i = 0;i<fdate.length;i++){
		File targetFile2 = new File(path2,fdate[i]);
		if(targetFile2.exists()){
			targetFile2.delete();
		}
		}
		
		String path3 = request.getServletContext().getRealPath("/img/scenicspot/videos");
		File targetFile3 = new File(path3,fileVideo);
		if(targetFile3.exists()){
			targetFile3.delete();
		}
		
		this.deleteSRHService.delScenicspot(id, country2);
	}
	
	if(type.equals("restaurant")){
		Restaurant restaurant = new Restaurant();
		restaurant = this.deleteSRHService.delRestaurantfile(id);
		String fileName = restaurant.getCover();
		String fileName2 = restaurant.getPices();
		String fdate[] = fileName2.split(";");
		
		String fileVideo = restaurant.getVideo();
		
		String path = request.getServletContext().getRealPath("/img/restaurant/cover");
		File targetFile = new File(path,fileName);
		if(targetFile.exists()){
			targetFile.delete();
		}
		
		String path2 = request.getServletContext().getRealPath("/img/restaurant/otherPic");
		for(int i = 0;i<fdate.length;i++){
		File targetFile2 = new File(path2,fdate[i]);
		if(targetFile2.exists()){
			targetFile2.delete();
		}
		}
		
		String path3 = request.getServletContext().getRealPath("/img/restaurant/videos");
		File targetFile3 = new File(path3,fileVideo);
		if(targetFile3.exists()){
			targetFile3.delete();
		}
		
		this.deleteSRHService.delScenicspot(id, country2);
	}
	

	return "success";
		
	}
	
	
}
