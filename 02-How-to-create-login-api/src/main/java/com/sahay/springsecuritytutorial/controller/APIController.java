package com.sahay.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class APIController {
	@GetMapping
	public ResponseEntity<String> getBankName() {
		return new ResponseEntity<String>("SBI Patna Bihar", HttpStatus.OK);
	}
    @GetMapping("/loan")
	public ResponseEntity<String> getLoan(){
		return new ResponseEntity<String>("5 Lakh loan for every Authenticated User!!",HttpStatus.OK);
	}
}
