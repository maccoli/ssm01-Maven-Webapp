package com.cn.hnust.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.Country;
import com.cn.hnust.pojo.Hotel;
import com.cn.hnust.pojo.Restaurant;
import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.pojo.Specialty;
import com.cn.hnust.service.AddExamineService;
import com.cn.hnust.service.ShowExamineService;

@Controller
@RequestMapping("/AddExamine")
public class AddExamineController {
	@Resource
	private AddExamineService addExamineService;

	@Resource
	private ShowExamineService showExamineService;

	@RequestMapping("/showExamine")
	public void showExamine(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Country> country = new ArrayList<Country>();

		country = this.addExamineService.getCountryInExamine();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", country);

		response.getWriter().write(jsonObject.toString());
		return;
	}

	@RequestMapping("/showExaminer")
	public void showExaminer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Restaurant> restaurant = new ArrayList<Restaurant>();

		restaurant = this.addExamineService.getRestaurantInExamine();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("list", restaurant);

		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showExamines")
	public void showExamines(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<ScenicSpot> scenicspot = new ArrayList<ScenicSpot>();

		scenicspot = this.addExamineService.getScenicspotInExamine();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("list", scenicspot);
		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showExamineh")
	public void showExamineh(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Hotel> hotel = new ArrayList<Hotel>();

		hotel = this.addExamineService.getHotelInExamine();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", hotel);
		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/updateExaminec")
	public void updateExaminec(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Integer examine = Integer.parseInt(request.getParameter("examine"));
		Country country = new Country();
		country.setName(name);
		country.setExamine(examine);
		
		addExamineService.updateCountryInExamine(country);
	}

	@RequestMapping("/updateExaminer")
	public void updateExaminer(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Integer examine = Integer.parseInt(request.getParameter("examine"));
         Restaurant restaurant = new Restaurant();
         restaurant.setName(name);
         restaurant.setExamine(examine);

		addExamineService.updateRestaurantInExamine(restaurant);
	}

	@RequestMapping("/updateExamines")
	public void updateExamines(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Integer examine = Integer.parseInt(request.getParameter("examine"));
		ScenicSpot scenicspot = new ScenicSpot();
		scenicspot.setName(name);
		scenicspot.setExamine(examine);
		addExamineService.updateScenicspotInExamine(scenicspot);
	}

	@RequestMapping("/updateExamineh")
	public void updateExamineh(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Integer examine = Integer.parseInt(request.getParameter("examine"));
		Hotel hotel = new Hotel();
		hotel.setHotelname(name);
		hotel .setExamine(examine);
		
		addExamineService.updateHotelInExamine(hotel);
	}

	@RequestMapping("/showsExamine")
	public void showsExamine(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		Integer cid = null;
		List<Country> country = new ArrayList<Country>();

		country = this.showExamineService.showCountryInExamine(name);

		Iterator<Country> iterator = country.iterator();
		while (iterator.hasNext()) {
			Country country2 = (Country) iterator.next();
			cid = country2.getId();
		}

		List<Object> photos = new ArrayList<Object>();
		List<Object> videos = new ArrayList<Object>();
		List<Specialty> specialty = new ArrayList<Specialty>();

		photos = this.showExamineService.showCountryphotoInExamine(cid);

		videos = this.showExamineService.showCountryvideoInExamine(cid);

		specialty = this.showExamineService.showCountryspecialtyInExamine(cid);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", country);
		jsonObject.put("list1", photos);
		jsonObject.put("list2", videos);
		jsonObject.put("list3", specialty);
		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showsRExamine")
	public void showsRExamine(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String rname = request.getParameter("rname");
		List<Restaurant> restaurant = new ArrayList<Restaurant>();

		restaurant = this.showExamineService.showRestaurantInExamine(rname);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", restaurant);
		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showsSExamine")
	public void showsSExamine(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String sname = request.getParameter("sname");
		List<ScenicSpot> scenicspot = new ArrayList<ScenicSpot>();
		scenicspot = this.showExamineService.showScenicspotInExamine(sname);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", scenicspot);
		response.getWriter().write(jsonObject.toString());
		return;

	}

	@RequestMapping("/showsHExamine")
	public void showsHotel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String hname = request.getParameter("hname");
		List<Hotel> hotel = new ArrayList<Hotel>();

		hotel = this.showExamineService.showHotelInExamine(hname);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", hotel);
		response.getWriter().write(jsonObject.toString());
		return;
	}

	
}
