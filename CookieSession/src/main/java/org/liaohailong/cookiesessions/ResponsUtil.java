package org.liaohailong.cookiesessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponsUtil {

	private ResponsUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void setUtf8(HttpServletResponse resp) {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	}

	public static void write(HttpServletResponse resp, String text) {
		try {
			PrintWriter writer = resp.getWriter();
			writer.write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
