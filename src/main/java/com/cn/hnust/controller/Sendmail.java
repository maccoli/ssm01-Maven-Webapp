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
* @Description: Sendmail��̳�Thread�����Sendmail����һ���߳��࣬����߳������ڸ�ָ�����û�����Email 
* @author: �°�����
* @date: 2015-1-12 ����10:43:48
*
*/
public class Sendmail extends Thread {
        //���ڸ��û������ʼ�������
    private String from = "17826806306@163.com";
        //������û���
    private String username = "17826806306";
        //���������
    private String password = "shen0410";
        //�����ʼ��ķ�������ַ
    private String host = "smtp.163.com";
    
    private User user;
    public Sendmail(User user){
        this.user = user;
    }
    
    /* ��дrun������ʵ�֣���run�����з����ʼ���ָ�����û� 
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
    * @Description: ����Ҫ���͵��ʼ�
    * @Anthor:�°�����
    * @param session
    * @param user
    * @return
    * @throws Exception
    */   
    public Message createEmail(Session session,User user) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getUseremail()));
        message.setSubject("�û�ע���ʼ�");
        String info = "��ã�"+user.getUseremail()+"!"+"<br>"+"����Ҫ���������������������˻�:"+"<br>"+"http://192.168.2.119:8000/ssm01/user/verification?key="+user.getKeyval()+"&from="+user.getUseremail();
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}