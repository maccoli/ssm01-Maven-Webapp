package com.cn.hnust.util;


import java.text.SimpleDateFormat;
import java.util.Locale;

public class Quartz {

    /** 
     * ��ʱ����ִ�з��� 
     * */  
    public void tips(){  
        String time = new SimpleDateFormat("MMM d��yyyy KK:mm:ss a",Locale.ENGLISH).format(System.currentTimeMillis());  
        System.out.println("time:"+time);  
    }  
}
