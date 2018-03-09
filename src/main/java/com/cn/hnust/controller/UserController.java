package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.UserService;
import com.cn.hnust.util.MD5Util;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value="user")
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	@ResponseBody
	@ApiOperation(value="获取session用户信息",httpMethod="GET",notes="get user in session",response=User.class)  
	@RequestMapping(value = "/info", produces = "text/json;charset=UTF-8")
	public void userinfo(HttpSession session, HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		List<User> users = new ArrayList<User>();
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		users.add(user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", users);
		try {
			// response.getWriter().write(jsonObject.toString());
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * controller:user-login
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", produces = "text/json;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session) {
		User user = new User();
		String piccode = (String) request.getSession().getAttribute("piccode");
		String username = "";
		String password = "";
		String checkcode = "0";
		StringBuffer requestBody;
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				username = jsonObject.get("email").toString();
				password = jsonObject.get("password").toString();
				checkcode = jsonObject.get("checkcode").toString();
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("checkcode-----" + checkcode + ":" + piccode);
		checkcode = checkcode.toUpperCase();
		JSONObject object = new JSONObject();
		if (piccode.equals(checkcode)) {
			try {
				password = MD5Util.encrypt(password);// MD5加密
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setUsername(username);
			user.setUserpassword(password);
			user = this.userService.getUserByPwd(user);
			if (user != null) {
				session.setAttribute("user", user);
				System.out.println("success:");
				// user.setUserpassword(""); //删除传输给前端用户信息中的密码项
				object.put("info", "登陆成功");
				return "登陆成功";
			} else {
				return "用户名或者密码不正确";
			}
		} else {
			return "验证码不正确";
		}
	}

	/**
	 * controller:change user's pwd
	 * 
	 * @param request
	 * @param map
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changepwd", produces = "text/json;charset=UTF-8")
	public String changepwd(HttpServletRequest request, Map<String, Object> map, Model model) {
		String oldpwd = "";
		String newpwd = "";
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("SESSION:" + user.toString());
		StringBuffer requestBody;
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				System.out.println("info:" + input);
				JSONObject jsonObject = new JSONObject(input);
				oldpwd = jsonObject.getString("oldpwd");
				newpwd = jsonObject.getString("newpwd");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("AA:" + MD5Util.encrypt(oldpwd).equals(user.getUserpassword()));
			if (MD5Util.encrypt(oldpwd).equals(user.getUserpassword())) {
				newpwd = MD5Util.encrypt(newpwd);
				user.setUserpassword(newpwd);
				if (this.userService.changePwd(user) == 1) {
					request.getSession().setAttribute("user", user);
					return "修改密码成功";
				} else {
					return "修改失败";
				}
			} else {
				return "旧密码不正确";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "修改失败";
	}

	/**
	 * controller:user-exit
	 * 
	 * @param session
	 * @return
	 */
	@ApiOperation(value = "普通用户退出", httpMethod = "GET", notes = "normal user exit", response = java.lang.String.class)
	@RequestMapping(value = "/exit",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String exit(HttpSession session) {
		try {
			session.removeAttribute("user");
			User user = (User)session.getAttribute("user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "登出失败";
		}
		return "登出成功";
	}

	/**
	 * controller:user-registerPage
	 * 
	 * @return
	 */
	@RequestMapping(value = "/registerPage")
	public String registerPage() {
		return "register";
	}

	/**
	 * controller:user-register
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register", produces = "text/json;charset=UTF-8")
	public String register(HttpServletRequest request, ModelMap model, HttpSession session) {
		User newuser = new User();
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
				newuser.setUsername(jsonObject.get("name").toString());
				newuser.setUserpassword(jsonObject.get("passwordO").toString());
				newuser.setPhone(jsonObject.get("phonenum").toString());
				checkcode = jsonObject.get("yanzhen").toString();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		checkcode = checkcode.toUpperCase();
		if (piccode.equals(checkcode)) {
			System.out.println("aaaaaaa");
			try {
				String changedPwd = MD5Util.encrypt(newuser.getUserpassword());
				newuser.setUserpassword(changedPwd);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Byte a = 0;
			newuser.setActive(a);
			Calendar calendar = Calendar.getInstance();
			try {
				String key = MD5Util.encrypt(calendar.toString() + newuser.getUseremail());
				newuser.setKeyval(key);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("user", newuser);
			String info = this.userService.register(newuser);
			// 注册成功发送邮件
			if (info.equals("注册成功")) {
				Sendmail send = new Sendmail(newuser);
				// 启动线程，线程启动之后就会执行run方法来发送邮件
				send.start();
				// Releaseverification releaseverification = new
				// Releaseverification(newuser);
				// releaseverification.run();

				return "恭喜你注册成功，一封邮件已经发往你的邮箱，请点击邮箱中的连接进行验证！";
			} else {
				return info;
			}
		} else {
			return "验证码不正确";
		}
	}

	/**
	 * 邮箱验证
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/verification")
	public String verification(HttpServletRequest request, ModelMap model) {
		String email = request.getParameter("from");
		model.addAttribute("waitingEmial", email);
		String confirmation_token = request.getParameter("key");
		if (this.userService.userverificate(confirmation_token).equals("success")) {
			return "index";
		} else {
			return "verificationFailure";
		}
	}

	/**
	 * Resend verification email
	 * 
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/verificationAgain", produces = "text/json;charset=UTF-8")
	public String verificationAgain(HttpServletRequest request, ModelMap model) {
		User user = new User();
		String waitingEmial = (String) model.get("waitingEmial");
		String waitingEmial2 = (String) request.getSession().getAttribute("waitingEmial");
		user.setUseremail(waitingEmial);
		user = this.userService.getUserByEmial(user);
		if (user != null) {
			Calendar calendar = Calendar.getInstance();
			String key = null;
			try {
				key = MD5Util.encrypt(calendar.toString() + user.getUseremail());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setKeyval(key);
			Sendmail send = new Sendmail(user);
			// 启动线程，线程启动之后就会执行run方法来发送邮件
			send.start();
			this.userService.changeVal(user);
			return "邮件已重新发送，请点击邮箱中的连接进行验证！";
		} else {
			return "重新发送邮件失败";
		}
	}

	/**
	 * change user's keyvalue
	 * 
	 * @param user
	 */
	@RequestMapping(value = "/changeval")
	public void changeval(User user) {
		System.out.println("a:" + user);
		System.out.println("b:" + userService);
		this.userService.changeVal(user);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeUserInfo", produces = "text/json;charset=UTF-8")
	public void changeUserInfo(HttpServletRequest request, HttpSession session,HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			user.setUsername(request.getParameter("username"));
			if(request.getParameter("sex").equals("0")){
				user.setSex("男");
			}else{
				user.setSex("女");
			}
			user.setPhone(request.getParameter("phone"));
			user.setCity(request.getParameter("city"));
			user.setWechat(request.getParameter("wechat"));
			user.setSignature(request.getParameter("signature"));
			String birth = request.getParameter("birth");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(birth);
				user.setBirth(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Date date = new Date(birth);
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("/img/headpic") + "/"
							+ String.valueOf(new Date().getTime()) + "."
							+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
					// 上传
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
		JSONObject jsonObject = new JSONObject();
		user = this.userService.changeUserInfo(user);
		List<User> list = new ArrayList<User>();
		list.add(user);
		jsonObject.put("user", list);
		jsonObject.put("info", "修改成功");
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value="判断普通用户是否登录",httpMethod="GET",notes="if user is logedin ?")
	@ResponseBody
	@RequestMapping(value="isLogin",produces="text/json;charset=UTF-8")
	public String isLogin(HttpSession session){
		User user = (User)session.getAttribute("user");
		if(user==null){
			return "未登录";
		}else{
			return "已登陆";
		}
	}
}