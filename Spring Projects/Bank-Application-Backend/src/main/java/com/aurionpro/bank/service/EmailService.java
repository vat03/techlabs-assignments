package com.aurionpro.bank.service;

public interface EmailService {
	void sendEmail(String to, String subject, String body);
}
