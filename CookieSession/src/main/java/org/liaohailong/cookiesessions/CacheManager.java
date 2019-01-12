package org.liaohailong.cookiesessions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CacheManager {
	private Map<String, Cache> cacheMap = new HashMap<String, Cache>();

	public synchronized void put(String key, Object value) {
		put(key, value, 0);
	}

	public synchronized void put(String key, Object value, long timeout) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setValue(value);
		timeout = timeout > 0 ? timeout : 0;
		cache.setTimeout(timeout + System.currentTimeMillis());
		cacheMap.put(key, cache);
	}

	public synchronized void remove(String key) {
		cacheMap.remove(key);
	}

	public synchronized Object get(String key) {
		Cache cache = cacheMap.get(key);
		return cache == null ? null : cache.getValue();
	}

	public synchronized void checkTimeOut() {
		Set<String> removeKey = new HashSet<String>();
		for (Map.Entry<String, Cache> entry : cacheMap.entrySet()) {
			String key = entry.getKey();
			Cache value = entry.getValue();
			long timeout = value.getTimeout();
			long timeOffset = System.currentTimeMillis() - timeout;

			if (timeOffset < 0) {
				removeKey.add(key);
			}
		}
		// ����Զ��建��
		for (String key : removeKey) {
			cacheMap.remove(key);
		}
	}
}