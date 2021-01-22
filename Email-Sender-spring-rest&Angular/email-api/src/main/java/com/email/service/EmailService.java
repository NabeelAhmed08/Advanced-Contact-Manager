package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to, String subject,String message) {
		boolean f = false;
		
		
		
		System.out.println("sending mail");
		
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("nabeelahmed1999anas@gmail.com");
			simpleMailMessage.setTo(to);
			simpleMailMessage.setText(message);
			simpleMailMessage.setSubject(subject);
			javaMailSender.send(simpleMailMessage);
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
}
