package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@RequestMapping("/welcome")
	public String home() {
		
		return "heeelo api testing";
		
	}
	
//	Api to send email
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
		
	boolean result = this.emailService.sendEmail(request.getto(), request.getSubject(), request.getMessage());
		
	if (result) {
		
		return ResponseEntity.ok(new EmailResponse("Email to "+request.getto()+ " is sent sucessfully"));
	} 
	
	else {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email is not sent"));
	}
	
	
		
	}
	
	
	
	
}
