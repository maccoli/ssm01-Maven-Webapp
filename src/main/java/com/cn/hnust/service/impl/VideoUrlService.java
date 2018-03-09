package com.cn.hnust.service.impl;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class VideoUrlService {
	
	public void getAllVideoUrl() {
		
		String time = new SimpleDateFormat("MMM d£¬yyyy KK:mm:ss a", Locale.ENGLISH).format(System.currentTimeMillis());
		System.out.println("time:" + time);
	}
}
