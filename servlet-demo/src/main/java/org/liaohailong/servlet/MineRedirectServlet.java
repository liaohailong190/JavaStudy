package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mineredirect")
public class MineRedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �ֶ������ض���
		resp.setContentType("text/html;charset=UTF-8");// ������Ӧ��������
		resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		resp.setHeader("Location", "www.baidu.com");// �ض����ַ OtherServlet->"xxxx��ַ"
	}
}