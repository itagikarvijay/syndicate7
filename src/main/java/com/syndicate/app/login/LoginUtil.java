package com.syndicate.app.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginUtil {

	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	public String hashPassword(String pwd) {
		String encodedPassword = bCryptPasswordEncoder().encode(pwd);
		return encodedPassword;
	}

	public boolean comparePassword(String passwordFromUI, String passwordFromDB) {
		if (bCryptPasswordEncoder().matches(passwordFromUI, passwordFromDB)) {
			return true;
		} else {
			return false;
		}
	}
}
