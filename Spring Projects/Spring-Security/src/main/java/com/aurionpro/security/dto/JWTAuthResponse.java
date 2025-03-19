package com.aurionpro.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class JWTAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";
}