package com.cn.hnust.controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cn.hnust.pojo.User;
/**
* @ClassName: Sendmai
* @Description: Sendmail类继承Thread，因此Sendmail就是一个线程类，这个线程类用于给指定的用户发送Email 
* @author: 孤傲苍狼
* @date: 2015-1-12 下午10:43:48
*
*/
public class Sendmail extends Thread {
        //用于给用户发送邮件的邮箱
    private String from = "17826806306@163.com";
        //邮箱的用户名
    private String username = "17826806306";
        //邮箱的密码
    private String password = "shen0410";
        //发送邮件的服务器地址
    private String host = "smtp.163.com";
    
    private User user;
    public Sendmail(User user){
        this.user = user;
    }
    
    /* 重写run方法的实现，在run方法中发送邮件给指定的用户 
     * @see java.lang.Thread#run() 
     */  
    @Override
    public void run() {
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", host);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(prop);
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(host, username, password);
            Message message = createEmail(session,user);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /** 
    * @Method: createEmail
    * @Description: 创建要发送的邮件
    * @Anthor:孤傲苍狼
    * @param session
    * @param user
    * @return
    * @throws Exception
    */   
    public Message createEmail(Session session,User user) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getUseremail()));
        message.setSubject("用户注册邮件");
        String info = "你好："+user.getUseremail()+"!"+"<br>"+"你需要点击以下链接来激活你的账户:"+"<br>"+"http://192.168.2.119:8000/ssm01/user/verification?key="+user.getKeyval()+"&from="+user.getUseremail();
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}