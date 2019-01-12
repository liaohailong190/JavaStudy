package org.liaohailong.cookiesessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/doform")
public class DoFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isSubmit(req)) {
			String userName = req.getParameter("userName");
			try {
				Thread.sleep(1000 * 2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = req.getSession();
			session.removeAttribute("sessionToken");
			System.out.println("���ݿ�������� userName = " + userName);
		} else {
			System.out.println("�����ظ��ύ");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private boolean isSubmit(HttpServletRequest req) {
		String parameter = req.getParameter("parameterToken");
		HttpSession session = req.getSession();
		String token = (String) session.getAttribute("sessionToken");
		if (StringUtils.isEmpty(token)) {
			return false;
		}
		// У��token����ֹα��
		if (StringUtils.equals(parameter, token)) {
			return true;
		}
		return false;
	}
}