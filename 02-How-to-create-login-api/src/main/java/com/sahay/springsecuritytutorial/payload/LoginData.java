package com.sahay.springsecuritytutorial.payload;

import lombok.Data;

@Data
public class LoginData {
	private String email;
	private String password;
}
