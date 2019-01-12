package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向请求Servlet 外部跳转
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getContextPath();
		req.setAttribute("name", "RedirectServlet->廖海龙");
		/*
		 * Request不相同，作用域失效 因为重定向是外部跳转，所以需要带上全路径
		 */
		resp.sendRedirect(contextPath + "/getdata");
	}
}
