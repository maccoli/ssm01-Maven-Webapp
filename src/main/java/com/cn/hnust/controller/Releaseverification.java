package com.cn.hnust.controller;

import org.springframework.stereotype.Controller;

import com.cn.hnust.pojo.User;

@Controller
public class Releaseverification implements Runnable {
	
	private User user;
	public Releaseverification(User user) {
		super();
		this.user = user;
	}

	public Releaseverification() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(30000);
			new UserController().changeval(user);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
