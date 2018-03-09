package com.cn.hnust.util;


import java.text.SimpleDateFormat;
import java.util.Locale;

public class Quartz {

    /** 
     * 定时任务，执行方法 
     * */  
    public void tips(){  
        String time = new SimpleDateFormat("MMM d，yyyy KK:mm:ss a",Locale.ENGLISH).format(System.currentTimeMillis());  
        System.out.println("time:"+time);  
    }  
}
