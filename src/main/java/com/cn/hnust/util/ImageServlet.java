package com.cn.hnust.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//验证码图片的大小
		BufferedImage bi = new BufferedImage(80,22,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(200,150,255);
		g.setColor(c);
		//跟验证图片对应
		g.fillRect(0, 0, 80, 22);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r = new Random();
		int len=ch.length,index;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<5; i++){
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			g.drawString(ch[index]+"", (i*15)+3, 18);
			sb.append(ch[index]);
		}
		System.out.println("piccode:"+sb.toString());
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
}
