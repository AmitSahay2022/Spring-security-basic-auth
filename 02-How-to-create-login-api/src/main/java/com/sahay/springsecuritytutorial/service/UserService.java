package com.sahay.springsecuritytutorial.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sahay.springsecuritytutorial.entity.User;
import com.sahay.springsecuritytutorial.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder encoder;

	public User saveUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("User allready exist");
		} else {
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		User loggedInUser = getLoggedInUser();
		loggedInUser.setName(user.getName());
		loggedInUser.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(loggedInUser);
	}

	public User getUserDetails() {
		return getLoggedInUser();
	}

	public String deleteUser() {
		User user = getLoggedInUser();
		userRepository.delete(user);
		return "User Deleted Successfully";
	}

	public User getLoggedInUser() {
		//This is the Code to extract Login user 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String emailId = authentication.getName();
		return userRepository.findByEmail(emailId).orElseThrow(() -> new RuntimeException("User not found"));
	}
}
