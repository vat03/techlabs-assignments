//package com.aurionpro.bank.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.aurionpro.bank.service.EmailService;
//
//@RestController
//@RequestMapping("/bankapp/email")
//public class EmailController {
//
//	@Autowired
//	private EmailService emailService;
//
//	@PostMapping("/sendEmail")
//	public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
//		emailService.sendEmail(to, subject, body);
//		return "Email sent successfully!";
//	}
//}