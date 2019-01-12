package org.liaohailong.cookiesessions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/lasttime")
public class LastTimeServlet extends HttpServlet {
	private static final String KEY_COOKIE_LAST_TIME = "KEY_COOKIE_LAST_TIME";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 中文乱码问题修改：
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 1，获取cookie信息
		// 2，如果Cookie没有，说明为第一次访问
		// 3，现在访问的时间存放在Cookie里面去
		Cookie[] cookies = req.getCookies();
		String lastTime = "";
		Cookie cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				System.out.println("cookie.name = " + cookie.getName() + ",cookie.value = " + cookie.getValue());
			}
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (StringUtils.equals(KEY_COOKIE_LAST_TIME, cookie.getName())) {
					lastTime = cookie.getValue();
					break;
				}
			}
		}
		Date date = new Date();
		String nowTime = DATE_FORMAT.format(date);
		System.out.println("last time = " + lastTime);

		if (StringUtils.isEmpty(lastTime)) {
			lastTime = nowTime;
			resp.getWriter().write("您是第一次访问，当前访问时间为：" + nowTime);
		} else {
			resp.getWriter().write("欢迎再次光临，您是上次的访问时间是：" + lastTime);
		}

		cookie = new Cookie(KEY_COOKIE_LAST_TIME, nowTime);
		cookie.setMaxAge(60 * 60 * 24);
		resp.addCookie(cookie);
	}
}
