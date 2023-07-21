package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String recipientEmail, String subject, String message) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("fullstacktest@gmx.com");
		email.setTo(recipientEmail);
		email.setSubject(subject);
		email.setText(message);

		javaMailSender.send(email);

		System.out.println("Email inviata con successo!");
	}
}