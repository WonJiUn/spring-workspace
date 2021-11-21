package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	//xml 파일로 설정할 수도 있음
    @Bean
    public static JavaMailSender mailSender() {
   JavaMailSenderImpl jms = new JavaMailSenderImpl();
   jms.setHost("smtp.gmail.com");	//구글 smtp 서버 설정(고정값)
   jms.setPort(587);	//구글 smtp 메일 포트(고정값)
   jms.setUsername("hohodaebakk@gmail.com");
   jms.setPassword("cmcl0524!");

   Properties prop = new Properties();
   prop.setProperty("mail.transport.protocol", "smtp");
   prop.setProperty("mail.smtp.auth", "true"); 
   prop.setProperty("mail.smtp.starttls.enable", "true");
   prop.setProperty("mail.debug", "true");
   jms.setJavaMailProperties(prop);

   return jms;
    }
}
