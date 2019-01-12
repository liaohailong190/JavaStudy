package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ض�������Servlet �ⲿ��ת
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getContextPath();
		req.setAttribute("name", "RedirectServlet->�κ���");
		/*
		 * Request����ͬ��������ʧЧ ��Ϊ�ض������ⲿ��ת��������Ҫ����ȫ·��
		 */
		resp.sendRedirect(contextPath + "/getdata");
	}
}