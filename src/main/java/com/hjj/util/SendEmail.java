package com.hjj.util;

import java.security.GeneralSecurityException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail {
	private static SendEmail sendEmail;
	private SendEmail(){
		
	}
	public static SendEmail getInStance(){
		if(sendEmail==null){
			sendEmail = new SendEmail();
		}
		return sendEmail;
	}
    public int send(String userInfo,String to,int send) throws GeneralSecurityException 
    {
    	int result = 0;
    	// 收件人电子邮箱
        //String to = "847977675@qq.com";

    	// 发件人电子邮箱
        String from = "346484458@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        //设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("346484458@qq.com", "uwosasqfhqihbhhf"); //发件人邮件用户名、密码
            }
        });

        try{
        	// 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is an email from AliceHouse!");

            // 设置消息体
            message.setText("This is actual message", "UTF-8");

            //result，0代表发送注册邮件，1代表发送忘记密码
            if(send==0){

                String too = MessageFormat.format("<a href='http://localhost:8080/Alice/RegisterSure?email={0}'>点击这里完成激活</a>",userInfo);

                too = too.replace("{0}", userInfo);
                System.out.println(too);// 发送 HTML 消息, 可以插入html标签
                message.setContent(too,
                                   "text/html;charset=utf-8" );
            }
            if(send==1){
                String too = MessageFormat.format("这是你的密码：{0}，请查收！",userInfo);
                too = too.replace("{0}", userInfo);
                System.out.println(too);// 发送 HTML 消息, 可以插入html标签
                message.setContent(too,
                                   "text/html;charset=utf-8" );
            }
            // 发送消息
            Transport.send(message);
            result=1;
            //System.out.println("Sent message successfully....from runoob.com");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
		return result;
    }

}