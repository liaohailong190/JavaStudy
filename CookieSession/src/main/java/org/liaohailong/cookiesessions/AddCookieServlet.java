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
		// �Զ���cookie
		Cookie cookie = new Cookie("name", "liaohailong");
		//cookie����24Сʱ
		cookie.setMaxAge(60 * 60 * 24);
		// ����cookie���ͻ���
		resp.addCookie(cookie);
		System.out.println("AddCookieServlet GET����cookie = " + cookie.getName());
	}
}