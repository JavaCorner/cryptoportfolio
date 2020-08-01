package com.ab.cryptoportfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ab.cryptoportfolio.event.UserRegistrationEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

	private final JavaMailSender mailSender;
	private final VerificationService verificationService;

	@Override
	public void onApplicationEvent(UserRegistrationEvent event) {
		String username = event.getUser().getUsername();
		String verificationId = verificationService.createVerification(username);		
		String email = event.getUser().getEmail();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Crypto Portfolio Account Verification");
		message.setText("Account activation link: https://localhost:8080/verify/email?id="+verificationId);
		message.setTo(email);
		mailSender.send(message);
	}

}
