package org.liaohailong.service;

import org.apache.commons.lang.StringUtils;

public class HelloService {

	public void getString(String text) {
		if (StringUtils.isEmpty(text))
			System.out.println("text is empty!");
		else
			System.out.println("text is not empty , text = " + text);
	}
}