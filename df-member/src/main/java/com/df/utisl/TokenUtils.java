package com.df.utisl;

import java.util.UUID;

public class TokenUtils {
	public static String getToken() {
		String token = UUID.randomUUID().toString().replace("-", "");
		return token;
	}
}
