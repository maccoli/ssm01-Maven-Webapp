package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.CountryComment;
import com.cn.hnust.pojo.CountryWithBLOBs;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CountryCommentService;
import com.cn.hnust.service.CountryService;

@Controller
@RequestMapping("/CountryComment")
public class CountryCommentController {

	@Resource
	private CountryCommentService commentService;
	@Resource
	private CountryService countryService;
	
	@RequestMapping(value="/countryComment",produces="text/json;charset=UTF-8")
	public void getCountryComments(HttpSession session,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		CountryWithBLOBs bloBs = (CountryWithBLOBs)session.getAttribute("CountryWithBLOBs");
		List<CountryComment> comments = this.commentService.getCountryComments(bloBs);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("comments", comments);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Ìí¼ÓÐÂÆÀÂÛ
	 * @param request
	 * @param session
	 * @param response
	 */
	@RequestMapping(value="/newComment",produces="text/json;charset=UTF-8")
	public void newCountryComment(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		User user = (User)session.getAttribute("user");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		CountryComment comment = new CountryComment();
		CountryWithBLOBs countryWithBLOBs = new CountryWithBLOBs();
		StringBuffer requestBody;
		JSONObject object = new JSONObject();
		Calendar calendar = Calendar.getInstance();
		try {
			BufferedReader reader = request.getReader();
			String input = null;
			requestBody = new StringBuffer();
			while ((input = reader.readLine()) != null) {
				requestBody.append(input);
				JSONObject jsonObject = new JSONObject(input);
				comment.setScore(Double.valueOf(jsonObject.get("scores").toString()));
				comment.setContent(jsonObject.get("content").toString());
				comment.setCountryId(jsonObject.getInt("id"));
				comment.setUserUserid(user.getUserid());
				comment.setDelivertime(calendar.getTime());
				countryWithBLOBs.setId(jsonObject.getInt("id"));
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		countryWithBLOBs = countryService.getOneCountryById(countryWithBLOBs.getId());
		object.put("info", this.commentService.newCountryComment(comment));
		List<CountryComment> comments =this.commentService.getCountryComments(countryWithBLOBs);
		object.put("comments", comments);
		try {
			response.getWriter().print(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
