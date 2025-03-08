package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.modal.Email;
import com.email.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody Email email) {
		if(emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo()))
			return ResponseEntity.accepted().body("Email Sent Successfully...");
		return ResponseEntity.ok(email);
	}
}
