package org.liaohailong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifecycler extends HttpServlet {
	private int i = 1;

	public ServletLifecycler() {
		System.out.println("ServletLifecycler 构造函数被调用");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("我是ServletLifecycler init");
	}

	@Override
	public void destroy() {
		System.out.println("我是ServletLifecycler destroy");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我是ServletLifecycler doGet");

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		synchronized (ServletLifecycler.class) {
			resp.getWriter().write("我是ServletLifecycler doGet  i = " + i);
			try {
				Thread.sleep(1000 * 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}
