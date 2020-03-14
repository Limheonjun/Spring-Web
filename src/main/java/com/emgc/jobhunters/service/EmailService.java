package com.emgc.jobhunters.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendOnlyText(String to, String subject, String content);
	public void sendWithAttachment(String to, String subject, String content) throws MessagingException, MessagingException, IOException;
}
