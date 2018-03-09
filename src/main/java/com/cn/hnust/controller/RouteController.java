package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.ScenicSpot;
import com.cn.hnust.service.ScenicSpotService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/route")
public class RouteController {
	
	@Resource
	private ScenicSpotService scenicSpotService;
	
	@RequestMapping(value="/getRoutes")
	@ResponseBody
	@ApiOperation(value="/getRoutes")
	public void getRoutes(){
		String tag1 = "亲子出游";
		String tag2 = "摄影";
		List<ScenicSpot> scenicSpots = this.scenicSpotService.getSpotsByTag1(tag1);
		List<ScenicSpot> scenicSpots2  = this.scenicSpotService.getSpotsByTag2(tag2);
		System.out.println(scenicSpots);
		System.out.println(scenicSpots2);
	}
}
