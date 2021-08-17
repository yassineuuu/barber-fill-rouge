package com.barbers.users.shared;


import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	

	
	public static String generateUserId(int length) {
		final Random RANDOM = new SecureRandom();
		final String ALPHANUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXZabcdefghijklmnopqrstuvwxyz";

		StringBuilder returnValue = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
		}

		return new String(returnValue);
	}

}
