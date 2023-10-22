package com.sahay.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahay.springsecuritytutorial.entity.User;
import com.sahay.springsecuritytutorial.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> saveOrRegister(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<User> getUserInfo() {
		return new ResponseEntity<User>(userService.getUserDetails(), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteUser() {
		return new ResponseEntity<String>(userService.deleteUser(), HttpStatus.ACCEPTED);
	}
}
