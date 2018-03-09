package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.hnust.pojo.Authentication;
import com.cn.hnust.pojo.CountrysideUser;
import com.cn.hnust.service.AuthenticationService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/Authentication")
public class AuthenticationController {

	@Resource
	private AuthenticationService authenticationService;

	@ResponseBody
	@RequestMapping(value = "/addAutn", produces = "text/json;charset=UTF-8")
	public String AddAutn(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication authentication = new Authentication();
		CountrysideUser cuser = (CountrysideUser) session.getAttribute("countrysideUser");
		authentication.setUserid(cuser.getIdcountrysideuser());
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			authentication.setRealid(request.getParameter("realid"));
			authentication.setRealname(request.getParameter("realname"));
			authentication.setRemarks(request.getParameter("remarks"));
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("/img/authenticationpic") + "/"
							+ String.valueOf(new Date().getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					try {
						if (file.getName().equals("rzpic1")) {
							authentication.setIdcardo(String.valueOf(new Date().getTime()) + "." + file
									.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
						} else if (file.getName().equals("rzpic2")) {
							authentication.setIdcardx(String.valueOf(new Date().getTime()) + "." + file
									.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
						} else if (file.getName().equals("rzpic3")) {
							authentication.setRemarkphoto(String.valueOf(new Date().getTime()) + "." + file
									.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
						}
						file.transferTo(new File(path));
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
		this.authenticationService.addAutn(authentication);
		return "success";
	}
	@ApiOperation(value="/getAuthInfo",httpMethod="GET",response=com.cn.hnust.pojo.Authentication.class)
	@ResponseBody
	@RequestMapping(value="/getAuthInfo")
	public Authentication getAuthenticationInfo(/*@RequestParam("id")Integer userid*/){
		int userid = 18;
		Authentication authentication = this.authenticationService.getAuthenticationInfo(userid);
		return authentication;
	}
}
