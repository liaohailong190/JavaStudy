package org.liaohailong.cookiesessions;

import java.util.UUID;

public class TokenUtil {
	public static String getToken() {
		return UUID.randomUUID().toString();
	}
}
