package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转发请求Servlet Tomcat内部跳转
 */
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", "ForwardServlet->廖海龙");
		//同一个Request，作用域相同
		req.getRequestDispatcher("/getdata").forward(req, resp);
	}
}
