package com.emgc.jobhunters.serviceimpl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.emgc.jobhunters.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOnlyText(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
	}
	
	@Override
	public void sendWithAttachment(String to, String subject, String content) throws MessagingException, IOException {
		MimeMessage message = javaMailSender.createMimeMessage();
	      
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(content);
	    ClassPathResource resource = new ClassPathResource("static/music/Riverside.mp3");
	    helper.addAttachment("Music", resource.getFile());
	    javaMailSender.send(message);		
	}

}
