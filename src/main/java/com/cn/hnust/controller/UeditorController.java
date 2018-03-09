package com.cn.hnust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ueditor")
public class UeditorController {
	
	@RequestMapping("/value")
	public String ueditorValue(HttpServletRequest request){
		String value = request.getParameter("value");
		String container = request.getParameter("content");
		System.out.println("value:"+value);
		System.out.println("container:"+container);
		
		return null;
	}
}
