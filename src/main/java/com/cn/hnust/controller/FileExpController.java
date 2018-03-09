package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class FileExpController {
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request){
        //����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //���form���Ƿ���enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
    	   String name = request.getParameter("txt");
    	   String name2 = request.getParameter("txt2");
    	   System.out.println(name);
    	   System.out.println(name2);
    	   
           //��request��ɶಿ��request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //��ȡmultiRequest �����е��ļ���
           Iterator iter=multiRequest.getFileNames();
           while(iter.hasNext())
           {
               //һ�α��������ļ�
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null)
               {
                   String path="E:/springUpload/"+file.getOriginalFilename();
                   //�ϴ�
                   try {
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
   return "/index"; 
	}
}
