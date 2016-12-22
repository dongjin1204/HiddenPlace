package com.phoenix.hiddenplace.security;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider {
	
	@Inject
	private PasswordEncoder passwordEncoder;

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
}
