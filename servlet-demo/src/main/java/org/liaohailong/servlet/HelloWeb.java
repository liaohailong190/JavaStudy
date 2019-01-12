package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWeb extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is HelloWeb!");
		ServletContext servletContext = getServletContext();
		String name = (String) servletContext.getAttribute("name");
		resp.getWriter().write("from GET , this is HelloWeb class ,and name = " + name);
	}
}