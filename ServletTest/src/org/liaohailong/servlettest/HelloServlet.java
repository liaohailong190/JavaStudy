package org.liaohailong.servlettest;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		resp.setCharacterEncoding("utf-8");//���ݱ��룬��ֹ��������
		
		resp.setContentType("text/html;charset=utf-8");//��������������
		resp.getWriter().write("���Ƕ�̬��Դ��ʱ��Ϊ:" + new Date());
	}
}
