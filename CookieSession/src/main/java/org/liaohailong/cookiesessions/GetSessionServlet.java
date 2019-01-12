package org.liaohailong.cookiesessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/getsession")
public class GetSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResponsUtil.setUtf8(resp);

		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		String text = "";
		if (StringUtils.isEmpty(name)) {
			System.out.println("session name 为空，准备跳转->/createsession");
			String contextPath = getServletContext().getContextPath();
			resp.sendRedirect(contextPath + "/createsession");
//			req.getRequestDispatcher("/createsession").forward(req, resp);
		} else {
			text = "welcome to here again, session name = " + name + "  session id = " + session.getId();
			ResponsUtil.write(resp, text);
		}
	}
}
