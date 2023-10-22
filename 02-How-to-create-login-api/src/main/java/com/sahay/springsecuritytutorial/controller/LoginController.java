package com.sahay.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahay.springsecuritytutorial.payload.LoginData;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users/login")
public class LoginController {
	private AuthenticationManager authenticationManager;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginData data) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));

		// We are explicitly setting Authentication object in SecurityContextHolder
		SecurityContextHolder.getContext().setAuthentication(authenticate);

		return new ResponseEntity<String>("Login Successful!!", HttpStatus.OK);
	}

}
