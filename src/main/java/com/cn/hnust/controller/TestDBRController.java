package com.cn.hnust.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.DBRService;

@Controller
@RequestMapping("/DBR")
public class TestDBRController {
	@Resource
	private DBRService dbrService;
	
	@RequestMapping("/userinfo")
	public void test(){
		this.dbrService.getInfo();
		
	}
	/**
	 * 用户登录时推荐用户以类似的用户
	 */
	@RequestMapping("/login")
	public void login(){
		User user = new User();
		user.setBirth(new Date(1989, 5, 10));
		user.setSex("男");
		user.setFavorite("艺术,人文,清新,怀古");
		this.dbrService.getinfow(user);
	}
}
