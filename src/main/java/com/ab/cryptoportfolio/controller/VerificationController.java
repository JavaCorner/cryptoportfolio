package com.ab.cryptoportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ab.cryptoportfolio.entity.CryptoUser;
import com.ab.cryptoportfolio.repository.UserRepository;
import com.ab.cryptoportfolio.service.VerificationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VerificationController {

	private final VerificationService verificationService;
	private final UserRepository userRepository;
	
	@GetMapping("/verify/email")
	public String verifyEmail(@RequestParam String id) {
		String username = verificationService.getUsernameForId(id);
		if(username != null) {
			CryptoUser user = userRepository.findByUsername(username);
			user.setVerified(true);
			userRepository.save(user);
		}
		return "redirect:/login-verified";
	}
	
}
