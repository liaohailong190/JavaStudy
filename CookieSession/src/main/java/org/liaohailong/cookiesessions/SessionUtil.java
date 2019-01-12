package org.liaohailong.cookiesessions;

public class SessionUtil {
	private CacheManager cacheManager = new CacheManager();

	public String setAttribute(String value) {
		String sessionId = TokenUtil.getToken();
		cacheManager.put(sessionId, value);
		return sessionId;
	}
}
