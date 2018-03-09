package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.CountrysideColl;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CountrysideCollService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "CountrysideColl")
@Controller
@RequestMapping(value="/CountrysideColl")
public class CountrysideCollController {

	@Resource
	public CountrysideCollService countrysideCollService;
	
	@ResponseBody
	@RequestMapping(value="/allColls",produces = "text/json;charset=UTF-8")
	public void getUserColls(HttpSession session,HttpServletResponse response){
		User user = (User) session.getAttribute("user");
		List<CountrysideColl> colls = this.countrysideCollService.getUserColl(user);
		System.out.println("colls:"+colls.toString());
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("CountrysideColls", colls);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/cancel",produces = "text/json;charset=UTF-8")
	public String cancel(@PathVariable("id") Integer id){
		if(this.countrysideCollService.cancelColl(id)==1){
			return "取消成功";
		}else{
			return "取消失败";
		}
	}
	
	@ApiOperation(value = "收藏新的乡村", httpMethod = "GET", notes = "new collected countryside", response = java.lang.String.class)
	@ResponseBody
	@RequestMapping(value="/newColl",produces = "text/json;charset=UTF-8")
	public String newColl(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("remark")String remark,@RequestParam("mainPic")String mainPic,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		mainPic = mainPic.substring(mainPic.lastIndexOf("/")+1);
		CountrysideColl coll = new CountrysideColl();
		coll.setColltime(Calendar.getInstance().getTime());
		coll.setCountryId(id);
		coll.setCountrysideName(name);
		coll.setMainpic(mainPic);
		coll.setRemark(remark);
		coll.setUserUserid(user.getUserid());
		System.out.println(coll.toString());
		if(this.countrysideCollService.newColl(coll)==1){
			return "收藏成功";
		}else{
			return "收藏失败";
		}
	}
	
/*	@ApiOperation(value = "收藏新的乡村2", httpMethod = "GET", notes = "new collected countryside2", response = java.lang.Integer.class)
	@ResponseBody
	@RequestMapping(value="/newColl2",produces = "text/json;charset=UTF-8")
	public int newColl2(@RequestParam("id") Integer id){
		
	}*/
}
