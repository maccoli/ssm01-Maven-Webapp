package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.pojo.CountrysideUser;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CountryService;
import com.cn.hnust.service.CountrysideUserService;
import com.cn.hnust.util.MD5Util;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "CountrysideUser")
@Controller
@RequestMapping(value = "/CountrysideUser")
public class CountrysideUserController {
	@Resource
	private CountrysideUserService countrysideUserService;
	@Resource
	private CountryService countryService;

	@ResponseBody
	@RequestMapping(value = "/login", produces = "text/json;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		CountrysideUser user = new CountrysideUser();
		String piccode = (String) request.getSession().getAttribute("piccode");
		StringBuffer requestBody;
		String checkcode = "0";
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				user.setName(jsonObject.get("email").toString());
				user.setUserpassword(jsonObject.get("password").toString());
				checkcode = jsonObject.get("checkcode").toString();
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		checkcode = checkcode.toUpperCase();
		if (checkcode.equals(piccode)) {
			return this.countrysideUserService.getUser(user, request.getSession());
		} else {
			return "验证码不正确";
		}
	}

	@ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "get info")
	@ResponseBody
	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	public void userinfo(HttpSession session, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CountrysideUser user = (CountrysideUser) session.getAttribute("countrysideUser");
		JSONObject jsonObject = new JSONObject();
		List<CountrysideUser> countrysideUsers = new ArrayList<CountrysideUser>();
		countrysideUsers.add(user);
		user.setUserpassword(null);
		jsonObject.put("countrysideUser", countrysideUsers);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/login2", produces = "text/json;charset=UTF-8")
	public String Test(HttpServletRequest request, HttpServletResponse response) {
		CountrysideUser countrysideUser = new CountrysideUser();
		countrysideUser.setName(request.getParameter("name"));
		countrysideUser.setUserpassword(request.getParameter("userpassword"));
		return this.countrysideUserService.getUser(countrysideUser, request.getSession());
	}

	@ResponseBody
	@RequestMapping(value = "/changeInfo", produces = "text/json;charset=utf-8")
	public String changeUserInfo(HttpSession session, @RequestParam("username") String username,
			@RequestParam("sex") String sex, @RequestParam("city") String city, @RequestParam("phone") String phone,HttpServletRequest request) {
		CountrysideUser user = (CountrysideUser)session.getAttribute("CountrysideUser");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		user.setName(username);
		if(sex.equals("0")){
			user.setSex("男");
		}else{
			user.setSex("女");
		}
		user.setUserphone(phone);
		user.setCity(city);
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("/img/headpic") + "/"
							+ String.valueOf(new Date().getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					try {
						user.setHeadpic(String.valueOf(new Date().getTime()) + "." + file.getOriginalFilename()
								.substring(file.getOriginalFilename().lastIndexOf(".") + 1));
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
		System.out.println("info:"+user.toString());
		/* return this.countrysideUserService.changeUserInfo(user, session); */
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/changePwd", produces = "text/json;charset=utf-8")
	public String changePwd(HttpSession session, HttpServletRequest request) {
		String pwd = "";
		String newpwd = "";
		StringBuffer requestBody;
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				pwd = jsonObject.get("pwd").toString();
				newpwd = jsonObject.get("newpwd").toString();
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return this.countrysideUserService.changePwd(pwd, newpwd, session);
	}

	@ApiOperation(value = "判断商业用户是否登录", httpMethod = "GET", notes = "if countrysideUser is logedin ?", response = java.lang.String.class)
	@ResponseBody
	@RequestMapping(value = "isLogin", produces = "text/json;charset=UTF-8")
	public String isLogin(HttpSession session) {
		CountrysideUser user = (CountrysideUser) session.getAttribute("countrysideUser");
		if (user == null) {
			return "未登录";
		} else {
			return "已登陆";
		}
	}
	
	@ApiOperation(value = "商业用户退出", httpMethod = "GET", notes = "admin user exit", response = java.lang.String.class)
	@ResponseBody
	@RequestMapping(value = "/exit",produces="text/json;charset=UTF-8")
	public String exit(HttpSession session) {
		try {
			session.removeAttribute("countrysideUser");
			System.out.println("111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "登出失败";
		}
		return "登出成功";
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public String register(HttpServletRequest request, ModelMap model, HttpSession session){
		CountrysideUser newuser = new CountrysideUser();
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = "00";
		StringBuffer requestBody;
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				newuser.setUseremail(jsonObject.get("email").toString());
				newuser.setName(jsonObject.get("name").toString());
				newuser.setUserpassword(jsonObject.get("passwordO").toString());
				newuser.setUserphone(jsonObject.get("phonenum").toString());
				checkcode = jsonObject.get("yanzhen").toString();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "验证码不正确";
		}
		try {
			checkcode = checkcode.toUpperCase();
			if (piccode.equals(checkcode)) {
				try {
					String changedPwd = MD5Util.encrypt(newuser.getUserpassword());
					newuser.setUserpassword(changedPwd);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(newuser);
			this.countrysideUserService.newUser(newuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "注册失败";
		}
		return "恭喜你注册成功，一封邮件已经发往你的邮箱，请点击邮箱中的连接进行验证！";
	}
}
