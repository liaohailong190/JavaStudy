package org.liaohailong.cookiesessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addcookie")
public class AddCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 自定义cookie
		Cookie cookie = new Cookie("name", "liaohailong");
		//cookie保存24小时
		cookie.setMaxAge(60 * 60 * 24);
		// 返回cookie给客户端
		resp.addCookie(cookie);
		System.out.println("AddCookieServlet GET请求，cookie = " + cookie.getName());
	}
}
